package d.a.j0.o.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import d.a.j0.s2.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public c f57078a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f57079b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.o.d.c f57080c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57081d;

    /* renamed from: e  reason: collision with root package name */
    public int f57082e;

    /* renamed from: f  reason: collision with root package name */
    public long f57083f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1374e f57084g;

    /* loaded from: classes4.dex */
    public class a implements InterfaceC1374e {
        public a() {
        }

        @Override // d.a.j0.o.d.e.InterfaceC1374e
        public void a() {
            if (e.this.f57079b == null || !e.this.h()) {
                return;
            }
            e.this.j(BdBaseApplication.getInst().getApp().getApplicationContext(), e.this.f57079b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h.n.b<Long> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f57086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f57087f;

        public b(AdDownloadData adDownloadData, Context context) {
            this.f57086e = adDownloadData;
            this.f57087f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            if (e.this.f57078a.a()) {
                e.this.i(this.f57087f, this.f57086e);
                return;
            }
            e.this.f57079b = this.f57086e;
            e.this.f57083f = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final e f57092a = new e(null);
    }

    /* renamed from: d.a.j0.o.d.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1374e {
        void a();
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e g() {
        return d.f57092a;
    }

    public final boolean h() {
        return (this.f57082e == 0 || d.a.j0.s2.c.e(System.currentTimeMillis(), this.f57083f, this.f57082e)) ? false : true;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i2;
        if (!TextUtils.isEmpty(adDownloadData.getDeeplink())) {
            i2 = x.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
        } else {
            x.x(adDownloadData.getPkgName());
            i2 = -1;
        }
        this.f57080c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
        this.f57079b = null;
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        if (context == null || adDownloadData == null || !this.f57081d) {
            return;
        }
        h.d.G(1000L, TimeUnit.MILLISECONDS).o(h.l.b.a.b()).B(new b(adDownloadData, context));
    }

    public void k() {
        if (this.f57081d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f57078a);
            this.f57078a.b(this.f57084g);
        }
    }

    public e() {
        this.f57078a = new c(null);
        this.f57079b = null;
        this.f57080c = new d.a.j0.o.d.c();
        this.f57081d = d.a.j0.a.e().p();
        this.f57082e = d.a.j0.a.e().f();
        this.f57084g = new a();
    }

    /* loaded from: classes4.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f57089e;

        /* renamed from: f  reason: collision with root package name */
        public InterfaceC1374e f57090f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f57091g;

        public c() {
            this.f57089e = null;
            this.f57090f = null;
            this.f57091g = true;
        }

        public boolean a() {
            WeakReference<Activity> weakReference = this.f57089e;
            return (weakReference == null || weakReference.get() == null || !this.f57091g) ? false : true;
        }

        public void b(InterfaceC1374e interfaceC1374e) {
            this.f57090f = interfaceC1374e;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = this.f57089e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f57089e = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            InterfaceC1374e interfaceC1374e;
            this.f57089e = new WeakReference<>(activity);
            if (!this.f57091g && (interfaceC1374e = this.f57090f) != null) {
                interfaceC1374e.a();
            }
            this.f57091g = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference = this.f57089e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f57091g = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
