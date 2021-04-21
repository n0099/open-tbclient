package d.b.j0.o.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import d.b.j0.s2.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public c f59055a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f59056b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.o.d.c f59057c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59058d;

    /* renamed from: e  reason: collision with root package name */
    public int f59059e;

    /* renamed from: f  reason: collision with root package name */
    public long f59060f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1435e f59061g;

    /* loaded from: classes4.dex */
    public class a implements InterfaceC1435e {
        public a() {
        }

        @Override // d.b.j0.o.d.e.InterfaceC1435e
        public void a() {
            if (e.this.f59056b == null || !e.this.h()) {
                return;
            }
            e.this.j(BdBaseApplication.getInst().getApp().getApplicationContext(), e.this.f59056b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h.n.b<Long> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f59063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f59064f;

        public b(AdDownloadData adDownloadData, Context context) {
            this.f59063e = adDownloadData;
            this.f59064f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            if (e.this.f59055a.a()) {
                e.this.i(this.f59064f, this.f59063e);
                return;
            }
            e.this.f59056b = this.f59063e;
            e.this.f59060f = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final e f59069a = new e(null);
    }

    /* renamed from: d.b.j0.o.d.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1435e {
        void a();
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e g() {
        return d.f59069a;
    }

    public final boolean h() {
        return (this.f59059e == 0 || d.b.j0.s2.c.e(System.currentTimeMillis(), this.f59060f, this.f59059e)) ? false : true;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i;
        if (!TextUtils.isEmpty(adDownloadData.getDeeplink())) {
            i = w.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
        } else {
            w.x(adDownloadData.getPkgName());
            i = -1;
        }
        this.f59057c.a(i, adDownloadData.pkgName(), adDownloadData.getExtInfo());
        this.f59056b = null;
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        if (context == null || adDownloadData == null || !this.f59058d) {
            return;
        }
        h.d.J(1000L, TimeUnit.MILLISECONDS).p(h.l.b.a.b()).D(new b(adDownloadData, context));
    }

    public void k() {
        if (this.f59058d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f59055a);
            this.f59055a.b(this.f59061g);
        }
    }

    public e() {
        this.f59055a = new c(null);
        this.f59056b = null;
        this.f59057c = new d.b.j0.o.d.c();
        this.f59058d = d.b.j0.a.e().p();
        this.f59059e = d.b.j0.a.e().f();
        this.f59061g = new a();
    }

    /* loaded from: classes4.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f59066e;

        /* renamed from: f  reason: collision with root package name */
        public InterfaceC1435e f59067f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f59068g;

        public c() {
            this.f59066e = null;
            this.f59067f = null;
            this.f59068g = true;
        }

        public boolean a() {
            WeakReference<Activity> weakReference = this.f59066e;
            return (weakReference == null || weakReference.get() == null || !this.f59068g) ? false : true;
        }

        public void b(InterfaceC1435e interfaceC1435e) {
            this.f59067f = interfaceC1435e;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = this.f59066e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f59066e = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            InterfaceC1435e interfaceC1435e;
            this.f59066e = new WeakReference<>(activity);
            if (!this.f59068g && (interfaceC1435e = this.f59067f) != null) {
                interfaceC1435e.a();
            }
            this.f59068g = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference = this.f59066e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f59068g = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
