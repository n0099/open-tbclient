package d.a.s0.a.e;

import android.content.Context;
import d.a.s0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68243a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1863a f68244b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1863a f68245c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f68243a) {
                d.a.s0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f68244b = new c();
                f68245c = new m();
                a.a().c();
                a.a().d(f68245c);
                a.a().d(f68244b);
                a.a().e(context);
                f68243a = true;
                return;
            }
            d.a.s0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
