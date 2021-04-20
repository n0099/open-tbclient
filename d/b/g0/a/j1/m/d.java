package d.b.g0.a.j1.m;

import android.content.ContentResolver;
import android.content.ContentValues;
import androidx.annotation.AnyThread;
import d.b.g0.a.i2.p;
import d.b.g0.a.r1.e;
import d.b.g0.a.z1.g;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f45328a = -1;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            e O = e.O();
            if (O == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("appKey", O.getAppId());
            contentValues.put("launch_type", Integer.valueOf(g.b()));
            contentValues.put("source", O.J().S());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            ContentResolver contentResolver = d.b.g0.a.w0.a.c().getContentResolver();
            if (contentResolver != null) {
                contentResolver.insert(d.b.g0.a.g0.c.d.b(), contentValues);
            }
        }
    }

    public static int a() {
        int i = f45328a;
        if (i != -1) {
            return i;
        }
        d.b.g0.a.w0.a.N().getSwitch("swan_backstage_policy", 0);
        f45328a = 300;
        if (300 < 60) {
            f45328a = 60;
        } else if (300 > 3600) {
            f45328a = 3600;
        }
        return f45328a;
    }

    @AnyThread
    public static void b() {
        p.k(new a(), "SwanLaunchBehavior");
    }
}
