package d.a.o0.a.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f64079c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<InterfaceC1769a> f64080a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public boolean f64081b;

    /* renamed from: d.a.o0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1769a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    public static a a() {
        return f64079c;
    }

    public final Set<InterfaceC1769a> b() {
        return this.f64080a;
    }

    public final void c() {
        synchronized (this.f64080a) {
            this.f64080a.clear();
        }
    }

    public final void d(InterfaceC1769a interfaceC1769a) {
        synchronized (this.f64080a) {
            this.f64080a.add(interfaceC1769a);
        }
    }

    public final void e(Context context) {
        if (this.f64081b || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception unused) {
            d.a.o0.a.f.i.b("registerActivityLifecycleCallbacks encounter exception");
        }
        this.f64081b = true;
    }
}
