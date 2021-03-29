package d.b.m0.a.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f64064c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<InterfaceC1735a> f64065a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public boolean f64066b;

    /* renamed from: d.b.m0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1735a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    public static a a() {
        return f64064c;
    }

    public final Set<InterfaceC1735a> b() {
        return this.f64065a;
    }

    public final void c() {
        synchronized (this.f64065a) {
            this.f64065a.clear();
        }
    }

    public final void d(InterfaceC1735a interfaceC1735a) {
        synchronized (this.f64065a) {
            this.f64065a.add(interfaceC1735a);
        }
    }

    public final void e(Context context) {
        if (this.f64066b || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception unused) {
            d.b.m0.a.f.i.b("registerActivityLifecycleCallbacks encounter exception");
        }
        this.f64066b = true;
    }
}
