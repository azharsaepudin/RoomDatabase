package com.azhar.roomdatabase;

        import android.content.Context;

        import androidx.annotation.NonNull;
        import androidx.room.Database;
        import androidx.room.DatabaseConfiguration;
        import androidx.room.InvalidationTracker;
        import androidx.room.Room;
        import androidx.room.RoomDatabase;
        import androidx.sqlite.db.SupportSQLiteDatabase;
        import androidx.sqlite.db.SupportSQLiteOpenHelper;

        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

@Database(entities = {Mahasiswa.class}, version = 1, exportSchema = false)
abstract class MahasiswaRoomDatabase extends RoomDatabase {

    abstract MahasiswaDao mahasiswaDao();
    private static volatile MahasiswaRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MahasiswaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MahasiswaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MahasiswaRoomDatabase.class, "mahasiswa_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {

//                MahasiswaDao dao = INSTANCE.mahasiswaDao();
//                dao.deleteAll();
//
//                Mahasiswa mhs = new Mahasiswa("Rudi");
//                dao.insert(mhs);

            });
        }
    };
}
