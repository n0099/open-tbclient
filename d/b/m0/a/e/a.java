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
    public static final a f64792c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<InterfaceC1747a> f64793a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public boolean f64794b;

    /* renamed from: d.b.m0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1747a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    public static a a() {
        return f64792c;
    }

    public final Set<InterfaceC1747a> b() {
        return this.f64793a;
    }

    public final void c() {
        synchronized (this.f64793a) {
            this.f64793a.clear();
        }
    }

    public final void d(InterfaceC1747a interfaceC1747a) {
        synchronized (this.f64793a) {
            this.f64793a.add(interfaceC1747a);
        }
    }

    public final void e(Context context) {
        if (this.f64794b || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception unused) {
            d.b.m0.a.f.i.b("registerActivityLifecycleCallbacks encounter exception");
        }
        this.f64794b = true;
    }
}
