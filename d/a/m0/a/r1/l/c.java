package d.a.m0.a.r1.l;

import android.content.ContentResolver;
import android.content.ContentValues;
import androidx.annotation.AnyThread;
import d.a.m0.a.j2.j;
import d.a.m0.a.v2.q;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f48309a = -1;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("appKey", Q.getAppId());
            contentValues.put("launch_type", Integer.valueOf(j.b()));
            contentValues.put("source", Q.L().T());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            ContentResolver contentResolver = d.a.m0.a.c1.a.b().getContentResolver();
            if (contentResolver != null) {
                contentResolver.insert(d.a.m0.a.j0.b.d.b(), contentValues);
            }
        }
    }

    public static int a() {
        int i2 = f48309a;
        if (i2 != -1) {
            return i2;
        }
        d.a.m0.a.c1.a.Z().getSwitch("swan_backstage_policy", 0);
        f48309a = 300;
        if (300 < 60) {
            f48309a = 60;
        } else if (300 > 3600) {
            f48309a = 3600;
        }
        return f48309a;
    }

    @AnyThread
    public static void b() {
        q.j(new a(), "SwanLaunchBehavior");
    }
}
