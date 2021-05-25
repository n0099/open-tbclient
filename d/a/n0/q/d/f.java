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
    public c f58208a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f58209b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.q.d.c f58210c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58211d;

    /* renamed from: e  reason: collision with root package name */
    public int f58212e;

    /* renamed from: f  reason: collision with root package name */
    public long f58213f;

    /* renamed from: g  reason: collision with root package name */
    public e f58214g;

    /* loaded from: classes4.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.n0.q.d.f.e
        public void a() {
            if (f.this.f58209b == null || !f.this.h()) {
                return;
            }
            f.this.j(BdBaseApplication.getInst().getApp().getApplicationContext(), f.this.f58209b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h.n.b<Long> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f58216e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f58217f;

        public b(AdDownloadData adDownloadData, Context context) {
            this.f58216e = adDownloadData;
            this.f58217f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            if (f.this.f58208a.a()) {
                f.this.i(this.f58217f, this.f58216e);
                return;
            }
            f.this.f58209b = this.f58216e;
            f.this.f58213f = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final f f58222a = new f(null);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f g() {
        return d.f58222a;
    }

    public final boolean h() {
        return (this.f58212e == 0 || d.a.n0.t2.d.e(System.currentTimeMillis(), this.f58213f, this.f58212e)) ? false : true;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i2;
        if (!TextUtils.isEmpty(adDownloadData.getDeeplink())) {
            i2 = y.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
        } else {
            y.x(adDownloadData.getPkgName());
            i2 = -1;
        }
        this.f58210c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
        this.f58209b = null;
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        if (context == null || adDownloadData == null || !this.f58211d) {
            return;
        }
        h.d.G(1000L, TimeUnit.MILLISECONDS).o(h.l.b.a.b()).B(new b(adDownloadData, context));
    }

    public void k() {
        if (this.f58211d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f58208a);
            this.f58208a.b(this.f58214g);
        }
    }

    public f() {
        this.f58208a = new c(null);
        this.f58209b = null;
        this.f58210c = new d.a.n0.q.d.c();
        this.f58211d = d.a.n0.a.h().s();
        this.f58212e = d.a.n0.a.h().i();
        this.f58214g = new a();
    }

    /* loaded from: classes4.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f58219e;

        /* renamed from: f  reason: collision with root package name */
        public e f58220f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f58221g;

        public c() {
            this.f58219e = null;
            this.f58220f = null;
            this.f58221g = true;
        }

        public boolean a() {
            WeakReference<Activity> weakReference = this.f58219e;
            return (weakReference == null || weakReference.get() == null || !this.f58221g) ? false : true;
        }

        public void b(e eVar) {
            this.f58220f = eVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = this.f58219e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f58219e = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            e eVar;
            this.f58219e = new WeakReference<>(activity);
            if (!this.f58221g && (eVar = this.f58220f) != null) {
                eVar.a();
            }
            this.f58221g = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference = this.f58219e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f58221g = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
