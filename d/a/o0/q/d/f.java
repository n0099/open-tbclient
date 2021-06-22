package d.a.o0.q.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import d.a.o0.t2.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f62024a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f62025b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.q.d.c f62026c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62027d;

    /* renamed from: e  reason: collision with root package name */
    public int f62028e;

    /* renamed from: f  reason: collision with root package name */
    public long f62029f;

    /* renamed from: g  reason: collision with root package name */
    public e f62030g;

    /* loaded from: classes4.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.o0.q.d.f.e
        public void a() {
            if (f.this.f62025b == null || !f.this.h()) {
                return;
            }
            f.this.j(BdBaseApplication.getInst().getApp().getApplicationContext(), f.this.f62025b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h.n.b<Long> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f62032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f62033f;

        public b(AdDownloadData adDownloadData, Context context) {
            this.f62032e = adDownloadData;
            this.f62033f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            if (f.this.f62024a.a()) {
                f.this.i(this.f62033f, this.f62032e);
                return;
            }
            f.this.f62025b = this.f62032e;
            f.this.f62029f = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final f f62038a = new f(null);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f g() {
        return d.f62038a;
    }

    public final boolean h() {
        return (this.f62028e == 0 || d.a.o0.t2.d.e(System.currentTimeMillis(), this.f62029f, this.f62028e)) ? false : true;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i2;
        if (!TextUtils.isEmpty(adDownloadData.getDeeplink())) {
            i2 = y.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
        } else {
            y.x(adDownloadData.getPkgName());
            i2 = -1;
        }
        this.f62026c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
        this.f62025b = null;
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        if (context == null || adDownloadData == null || !this.f62027d) {
            return;
        }
        h.d.G(1000L, TimeUnit.MILLISECONDS).o(h.l.b.a.b()).B(new b(adDownloadData, context));
    }

    public void k() {
        if (this.f62027d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f62024a);
            this.f62024a.b(this.f62030g);
        }
    }

    public f() {
        this.f62024a = new c(null);
        this.f62025b = null;
        this.f62026c = new d.a.o0.q.d.c();
        this.f62027d = d.a.o0.a.h().s();
        this.f62028e = d.a.o0.a.h().i();
        this.f62030g = new a();
    }

    /* loaded from: classes4.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f62035e;

        /* renamed from: f  reason: collision with root package name */
        public e f62036f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f62037g;

        public c() {
            this.f62035e = null;
            this.f62036f = null;
            this.f62037g = true;
        }

        public boolean a() {
            WeakReference<Activity> weakReference = this.f62035e;
            return (weakReference == null || weakReference.get() == null || !this.f62037g) ? false : true;
        }

        public void b(e eVar) {
            this.f62036f = eVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = this.f62035e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f62035e = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            e eVar;
            this.f62035e = new WeakReference<>(activity);
            if (!this.f62037g && (eVar = this.f62036f) != null) {
                eVar.a();
            }
            this.f62037g = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference = this.f62035e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f62037g = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
