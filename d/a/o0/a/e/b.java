package d.a.o0.a.e;

import android.content.Context;
import d.a.o0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64082a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1769a f64083b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1769a f64084c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f64082a) {
                d.a.o0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f64083b = new c();
                f64084c = new m();
                a.a().c();
                a.a().d(f64084c);
                a.a().d(f64083b);
                a.a().e(context);
                f64082a = true;
                return;
            }
            d.a.o0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
