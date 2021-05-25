package d.a.r0.a.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f64406c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<InterfaceC1801a> f64407a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public boolean f64408b;

    /* renamed from: d.a.r0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1801a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    public static a a() {
        return f64406c;
    }

    public final Set<InterfaceC1801a> b() {
        return this.f64407a;
    }

    public final void c() {
        synchronized (this.f64407a) {
            this.f64407a.clear();
        }
    }

    public final void d(InterfaceC1801a interfaceC1801a) {
        synchronized (this.f64407a) {
            this.f64407a.add(interfaceC1801a);
        }
    }

    public final void e(Context context) {
        if (this.f64408b || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception unused) {
            d.a.r0.a.f.i.b("registerActivityLifecycleCallbacks encounter exception");
        }
        this.f64408b = true;
    }
}
