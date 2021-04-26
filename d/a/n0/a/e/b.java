package d.a.n0.a.e;

import android.content.Context;
import d.a.n0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f63374a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1704a f63375b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1704a f63376c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f63374a) {
                d.a.n0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f63375b = new c();
                f63376c = new m();
                a.a().c();
                a.a().d(f63376c);
                a.a().d(f63375b);
                a.a().e(context);
                f63374a = true;
                return;
            }
            d.a.n0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
