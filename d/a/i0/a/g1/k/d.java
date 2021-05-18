package d.a.i0.a.g1.k;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.lifecycle.process.LifecycleProcessType;
import d.a.i0.a.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f41767c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static final d f41768d = new d();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f41769a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.i0.a.g1.k.a> f41770b;

    /* loaded from: classes3.dex */
    public class b extends d.a.i0.a.g1.a {

        /* renamed from: e  reason: collision with root package name */
        public int f41771e;

        public b() {
            this.f41771e = 0;
        }

        @Override // d.a.i0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            int i2 = this.f41771e + 1;
            this.f41771e = i2;
            if (i2 == 1) {
                d.this.d(activity);
            }
        }

        @Override // d.a.i0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            int i2 = this.f41771e - 1;
            this.f41771e = i2;
            if (i2 == 0) {
                d.this.e(activity);
            }
        }
    }

    public d() {
        d.a.c0.a.b.d<d.a.i0.a.g1.k.a> dVar = new c().f41766a;
        this.f41770b = dVar == null ? null : dVar.getList();
    }

    public static d a() {
        return f41768d;
    }

    public void b(Context context) {
        if (this.f41769a.getAndSet(true) || !c()) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new b());
        }
    }

    public final boolean c() {
        return LifecycleProcessType.getCurrent() == LifecycleProcessType.MAIN;
    }

    public void d(Activity activity) {
        if (f41767c) {
            String curProcessName = ProcessUtils.getCurProcessName();
            Log.d("ProcessLifecycleDispatcher", curProcessName + " to foreground");
        }
        if (this.f41770b != null) {
            LifecycleProcessType current = LifecycleProcessType.getCurrent();
            for (d.a.i0.a.g1.k.a aVar : this.f41770b) {
                if (current == aVar.b()) {
                    aVar.a(true, activity);
                }
            }
        }
    }

    public void e(Activity activity) {
        if (f41767c) {
            String curProcessName = ProcessUtils.getCurProcessName();
            Log.d("ProcessLifecycleDispatcher", curProcessName + " to background");
        }
        if (this.f41770b != null) {
            LifecycleProcessType current = LifecycleProcessType.getCurrent();
            for (d.a.i0.a.g1.k.a aVar : this.f41770b) {
                if (current == aVar.b()) {
                    aVar.a(false, activity);
                }
            }
        }
    }
}
