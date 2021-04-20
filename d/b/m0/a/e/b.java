package d.b.m0.a.e;

import android.content.Context;
import d.b.m0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64795a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1747a f64796b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1747a f64797c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f64795a) {
                d.b.m0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f64796b = new c();
                f64797c = new m();
                a.a().c();
                a.a().d(f64797c);
                a.a().d(f64796b);
                a.a().e(context);
                f64795a = true;
                return;
            }
            d.b.m0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
