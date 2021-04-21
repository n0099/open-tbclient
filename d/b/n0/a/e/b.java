package d.b.n0.a.e;

import android.content.Context;
import d.b.n0.a.e.a;
import java.util.Date;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f65063a = false;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1766a f65064b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1766a f65065c;

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (!f65063a) {
                d.b.n0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                f65064b = new c();
                f65065c = new m();
                a.a().c();
                a.a().d(f65065c);
                a.a().d(f65064b);
                a.a().e(context);
                f65063a = true;
                return;
            }
            d.b.n0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
        }
    }
}
