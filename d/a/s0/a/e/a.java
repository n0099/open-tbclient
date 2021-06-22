package d.a.s0.a.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f68240c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<InterfaceC1863a> f68241a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public boolean f68242b;

    /* renamed from: d.a.s0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1863a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    public static a a() {
        return f68240c;
    }

    public final Set<InterfaceC1863a> b() {
        return this.f68241a;
    }

    public final void c() {
        synchronized (this.f68241a) {
            this.f68241a.clear();
        }
    }

    public final void d(InterfaceC1863a interfaceC1863a) {
        synchronized (this.f68241a) {
            this.f68241a.add(interfaceC1863a);
        }
    }

    public final void e(Context context) {
        if (this.f68242b || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception unused) {
            d.a.s0.a.f.i.b("registerActivityLifecycleCallbacks encounter exception");
        }
        this.f68242b = true;
    }
}
