package d.a.r0.a.e;

import android.content.Context;
import d.a.r0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68127a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1859a f68128b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1859a f68129c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f68127a) {
                d.a.r0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f68128b = new c();
                f68129c = new m();
                a.a().c();
                a.a().d(f68129c);
                a.a().d(f68128b);
                a.a().e(context);
                f68127a = true;
                return;
            }
            d.a.r0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
