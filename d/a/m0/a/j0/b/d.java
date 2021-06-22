package d.a.m0.a.j0.b;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Uri f46833a;

    public static void a(@NonNull SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user_behavior(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,launch_type INT NOT NULL,source varchar(100),ext TEXT,time BIGINT);");
        } catch (Exception e2) {
            d.a.m0.a.e0.d.c("SwanLaunchBehaviorTable", "createTable", e2);
        }
    }

    @NonNull
    public static synchronized Uri b() {
        Uri uri;
        synchronized (d.class) {
            if (f46833a == null) {
                f46833a = b.f46831c.buildUpon().appendPath("user_behavior").build();
            }
            uri = f46833a;
        }
        return uri;
    }
}
