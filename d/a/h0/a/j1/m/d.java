package d.a.h0.a.j1.m;

import android.content.ContentResolver;
import android.content.ContentValues;
import androidx.annotation.AnyThread;
import d.a.h0.a.i2.p;
import d.a.h0.a.r1.e;
import d.a.h0.a.z1.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f42982a = -1;

    /* loaded from: classes3.dex */
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
            ContentResolver contentResolver = d.a.h0.a.w0.a.c().getContentResolver();
            if (contentResolver != null) {
                contentResolver.insert(d.a.h0.a.g0.c.d.b(), contentValues);
            }
        }
    }

    public static int a() {
        int i2 = f42982a;
        if (i2 != -1) {
            return i2;
        }
        d.a.h0.a.w0.a.N().getSwitch("swan_backstage_policy", 0);
        f42982a = 300;
        if (300 < 60) {
            f42982a = 60;
        } else if (300 > 3600) {
            f42982a = 3600;
        }
        return f42982a;
    }

    @AnyThread
    public static void b() {
        p.k(new a(), "SwanLaunchBehavior");
    }
}
