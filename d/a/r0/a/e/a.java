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
    public static final a f68124c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<InterfaceC1859a> f68125a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public boolean f68126b;

    /* renamed from: d.a.r0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1859a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    public static a a() {
        return f68124c;
    }

    public final Set<InterfaceC1859a> b() {
        return this.f68125a;
    }

    public final void c() {
        synchronized (this.f68125a) {
            this.f68125a.clear();
        }
    }

    public final void d(InterfaceC1859a interfaceC1859a) {
        synchronized (this.f68125a) {
            this.f68125a.add(interfaceC1859a);
        }
    }

    public final void e(Context context) {
        if (this.f68126b || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception unused) {
            d.a.r0.a.f.i.b("registerActivityLifecycleCallbacks encounter exception");
        }
        this.f68126b = true;
    }
}
