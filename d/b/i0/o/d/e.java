package d.b.i0.o.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import d.b.i0.s2.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public c f58634a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f58635b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.o.d.c f58636c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58637d;

    /* renamed from: e  reason: collision with root package name */
    public int f58638e;

    /* renamed from: f  reason: collision with root package name */
    public long f58639f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1412e f58640g;

    /* loaded from: classes4.dex */
    public class a implements InterfaceC1412e {
        public a() {
        }

        @Override // d.b.i0.o.d.e.InterfaceC1412e
        public void a() {
            if (e.this.f58635b == null || !e.this.h()) {
                return;
            }
            e.this.j(BdBaseApplication.getInst().getApp().getApplicationContext(), e.this.f58635b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h.n.b<Long> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f58642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f58643f;

        public b(AdDownloadData adDownloadData, Context context) {
            this.f58642e = adDownloadData;
            this.f58643f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            if (e.this.f58634a.a()) {
                e.this.i(this.f58643f, this.f58642e);
                return;
            }
            e.this.f58635b = this.f58642e;
            e.this.f58639f = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final e f58648a = new e(null);
    }

    /* renamed from: d.b.i0.o.d.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1412e {
        void a();
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e g() {
        return d.f58648a;
    }

    public final boolean h() {
        return (this.f58638e == 0 || d.b.i0.s2.c.e(System.currentTimeMillis(), this.f58639f, this.f58638e)) ? false : true;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i;
        if (!TextUtils.isEmpty(adDownloadData.getDeeplink())) {
            i = w.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
        } else {
            w.x(adDownloadData.getPkgName());
            i = -1;
        }
        this.f58636c.a(i, adDownloadData.pkgName(), adDownloadData.getExtInfo());
        this.f58635b = null;
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        if (context == null || adDownloadData == null || !this.f58637d) {
            return;
        }
        h.d.J(1000L, TimeUnit.MILLISECONDS).p(h.l.b.a.b()).D(new b(adDownloadData, context));
    }

    public void k() {
        if (this.f58637d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f58634a);
            this.f58634a.b(this.f58640g);
        }
    }

    public e() {
        this.f58634a = new c(null);
        this.f58635b = null;
        this.f58636c = new d.b.i0.o.d.c();
        this.f58637d = d.b.i0.a.e().p();
        this.f58638e = d.b.i0.a.e().f();
        this.f58640g = new a();
    }

    /* loaded from: classes4.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f58645e;

        /* renamed from: f  reason: collision with root package name */
        public InterfaceC1412e f58646f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f58647g;

        public c() {
            this.f58645e = null;
            this.f58646f = null;
            this.f58647g = true;
        }

        public boolean a() {
            WeakReference<Activity> weakReference = this.f58645e;
            return (weakReference == null || weakReference.get() == null || !this.f58647g) ? false : true;
        }

        public void b(InterfaceC1412e interfaceC1412e) {
            this.f58646f = interfaceC1412e;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = this.f58645e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f58645e = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            InterfaceC1412e interfaceC1412e;
            this.f58645e = new WeakReference<>(activity);
            if (!this.f58647g && (interfaceC1412e = this.f58646f) != null) {
                interfaceC1412e.a();
            }
            this.f58647g = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference = this.f58645e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f58647g = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
