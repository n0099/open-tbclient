package d.b.g0.a.g0.c;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Uri f44493a;

    public static void a(@NonNull SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user_behavior(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,launch_type INT NOT NULL,source varchar(100),ext TEXT,time BIGINT);");
        } catch (Exception e2) {
            d.b.g0.a.c0.c.c("SwanLaunchBehaviorTable", "createTable", e2);
        }
    }

    @NonNull
    public static synchronized Uri b() {
        Uri uri;
        synchronized (d.class) {
            if (f44493a == null) {
                f44493a = b.f44491c.buildUpon().appendPath("user_behavior").build();
            }
            uri = f44493a;
        }
        return uri;
    }
}
