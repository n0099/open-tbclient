package d.b.g0.a.g0.c;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Uri f44886a;

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
            if (f44886a == null) {
                f44886a = b.f44884c.buildUpon().appendPath("user_behavior").build();
            }
            uri = f44886a;
        }
        return uri;
    }
}
