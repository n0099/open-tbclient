package d.a.m0.a.g1.k;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.lifecycle.process.LifecycleProcessType;
import d.a.m0.a.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45725c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static final d f45726d = new d();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f45727a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.m0.a.g1.k.a> f45728b;

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.a.g1.a {

        /* renamed from: e  reason: collision with root package name */
        public int f45729e;

        public b() {
            this.f45729e = 0;
        }

        @Override // d.a.m0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            int i2 = this.f45729e + 1;
            this.f45729e = i2;
            if (i2 == 1) {
                d.this.d(activity);
            }
        }

        @Override // d.a.m0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            int i2 = this.f45729e - 1;
            this.f45729e = i2;
            if (i2 == 0) {
                d.this.e(activity);
            }
        }
    }

    public d() {
        d.a.f0.a.b.d<d.a.m0.a.g1.k.a> dVar = new c().f45724a;
        this.f45728b = dVar == null ? null : dVar.getList();
    }

    public static d a() {
        return f45726d;
    }

    public void b(Context context) {
        if (this.f45727a.getAndSet(true) || !c()) {
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
        if (f45725c) {
            String curProcessName = ProcessUtils.getCurProcessName();
            Log.d("ProcessLifecycleDispatcher", curProcessName + " to foreground");
        }
        if (this.f45728b != null) {
            LifecycleProcessType current = LifecycleProcessType.getCurrent();
            for (d.a.m0.a.g1.k.a aVar : this.f45728b) {
                if (current == aVar.b()) {
                    aVar.a(true, activity);
                }
            }
        }
    }

    public void e(Activity activity) {
        if (f45725c) {
            String curProcessName = ProcessUtils.getCurProcessName();
            Log.d("ProcessLifecycleDispatcher", curProcessName + " to background");
        }
        if (this.f45728b != null) {
            LifecycleProcessType current = LifecycleProcessType.getCurrent();
            for (d.a.m0.a.g1.k.a aVar : this.f45728b) {
                if (current == aVar.b()) {
                    aVar.a(false, activity);
                }
            }
        }
    }
}
