package d.b.n0.a.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f65060c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<InterfaceC1766a> f65061a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public boolean f65062b;

    /* renamed from: d.b.n0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1766a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    public static a a() {
        return f65060c;
    }

    public final Set<InterfaceC1766a> b() {
        return this.f65061a;
    }

    public final void c() {
        synchronized (this.f65061a) {
            this.f65061a.clear();
        }
    }

    public final void d(InterfaceC1766a interfaceC1766a) {
        synchronized (this.f65061a) {
            this.f65061a.add(interfaceC1766a);
        }
    }

    public final void e(Context context) {
        if (this.f65062b || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception unused) {
            d.b.n0.a.f.i.b("registerActivityLifecycleCallbacks encounter exception");
        }
        this.f65062b = true;
    }
}
