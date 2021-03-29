package d.b.m0.a.e;

import android.content.Context;
import d.b.m0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64067a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1735a f64068b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1735a f64069c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f64067a) {
                d.b.m0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f64068b = new c();
                f64069c = new m();
                a.a().c();
                a.a().d(f64069c);
                a.a().d(f64068b);
                a.a().e(context);
                f64067a = true;
                return;
            }
            d.b.m0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
