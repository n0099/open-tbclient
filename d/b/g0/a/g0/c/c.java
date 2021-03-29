package d.b.g0.a.g0.c;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes2.dex */
public final class c {
    public static void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(b());
        } catch (Exception e2) {
            e2.getStackTrace();
        }
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS ai_apps_favorites (_id INTEGER PRIMARY KEY AUTOINCREMENT,sort_index INTEGER,app_id TEXT NOT NULL UNIQUE,app_icon TEXT,app_name TEXT,app_type INTEGER,frame_type INTEGER,favorite_time INTEGER DEFAULT 0);";
    }
}
