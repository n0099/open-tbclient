package d.a.n0.a.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f63371c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<InterfaceC1704a> f63372a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public boolean f63373b;

    /* renamed from: d.a.n0.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1704a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    public static a a() {
        return f63371c;
    }

    public final Set<InterfaceC1704a> b() {
        return this.f63372a;
    }

    public final void c() {
        synchronized (this.f63372a) {
            this.f63372a.clear();
        }
    }

    public final void d(InterfaceC1704a interfaceC1704a) {
        synchronized (this.f63372a) {
            this.f63372a.add(interfaceC1704a);
        }
    }

    public final void e(Context context) {
        if (this.f63373b || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception unused) {
            d.a.n0.a.f.i.b("registerActivityLifecycleCallbacks encounter exception");
        }
        this.f63373b = true;
    }
}
