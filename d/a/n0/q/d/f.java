package d.a.n0.q.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import d.a.n0.t2.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f61899a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f61900b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.q.d.c f61901c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61902d;

    /* renamed from: e  reason: collision with root package name */
    public int f61903e;

    /* renamed from: f  reason: collision with root package name */
    public long f61904f;

    /* renamed from: g  reason: collision with root package name */
    public e f61905g;

    /* loaded from: classes4.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.n0.q.d.f.e
        public void a() {
            if (f.this.f61900b == null || !f.this.h()) {
                return;
            }
            f.this.j(BdBaseApplication.getInst().getApp().getApplicationContext(), f.this.f61900b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h.n.b<Long> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f61907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f61908f;

        public b(AdDownloadData adDownloadData, Context context) {
            this.f61907e = adDownloadData;
            this.f61908f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            if (f.this.f61899a.a()) {
                f.this.i(this.f61908f, this.f61907e);
                return;
            }
            f.this.f61900b = this.f61907e;
            f.this.f61904f = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final f f61913a = new f(null);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f g() {
        return d.f61913a;
    }

    public final boolean h() {
        return (this.f61903e == 0 || d.a.n0.t2.d.e(System.currentTimeMillis(), this.f61904f, this.f61903e)) ? false : true;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i2;
        if (!TextUtils.isEmpty(adDownloadData.getDeeplink())) {
            i2 = y.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
        } else {
            y.x(adDownloadData.getPkgName());
            i2 = -1;
        }
        this.f61901c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
        this.f61900b = null;
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        if (context == null || adDownloadData == null || !this.f61902d) {
            return;
        }
        h.d.G(1000L, TimeUnit.MILLISECONDS).o(h.l.b.a.b()).B(new b(adDownloadData, context));
    }

    public void k() {
        if (this.f61902d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f61899a);
            this.f61899a.b(this.f61905g);
        }
    }

    public f() {
        this.f61899a = new c(null);
        this.f61900b = null;
        this.f61901c = new d.a.n0.q.d.c();
        this.f61902d = d.a.n0.a.h().s();
        this.f61903e = d.a.n0.a.h().i();
        this.f61905g = new a();
    }

    /* loaded from: classes4.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f61910e;

        /* renamed from: f  reason: collision with root package name */
        public e f61911f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f61912g;

        public c() {
            this.f61910e = null;
            this.f61911f = null;
            this.f61912g = true;
        }

        public boolean a() {
            WeakReference<Activity> weakReference = this.f61910e;
            return (weakReference == null || weakReference.get() == null || !this.f61912g) ? false : true;
        }

        public void b(e eVar) {
            this.f61911f = eVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = this.f61910e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f61910e = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            e eVar;
            this.f61910e = new WeakReference<>(activity);
            if (!this.f61912g && (eVar = this.f61911f) != null) {
                eVar.a();
            }
            this.f61912g = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference = this.f61910e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f61912g = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
