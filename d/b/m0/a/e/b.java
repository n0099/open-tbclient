package d.b.m0.a.e;

import android.content.Context;
import d.b.m0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64066a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1734a f64067b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1734a f64068c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f64066a) {
                d.b.m0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f64067b = new c();
                f64068c = new m();
                a.a().c();
                a.a().d(f64068c);
                a.a().d(f64067b);
                a.a().e(context);
                f64066a = true;
                return;
            }
            d.b.m0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
