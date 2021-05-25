package d.a.r0.a.e;

import android.content.Context;
import d.a.r0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64409a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1801a f64410b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1801a f64411c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f64409a) {
                d.a.r0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f64410b = new c();
                f64411c = new m();
                a.a().c();
                a.a().d(f64411c);
                a.a().d(f64410b);
                a.a().e(context);
                f64409a = true;
                return;
            }
            d.a.r0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
