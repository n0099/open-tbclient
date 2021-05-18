package d.a.k0.o.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import d.a.k0.s2.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public c f57785a;

    /* renamed from: b  reason: collision with root package name */
    public AdDownloadData f57786b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.o.d.c f57787c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57788d;

    /* renamed from: e  reason: collision with root package name */
    public int f57789e;

    /* renamed from: f  reason: collision with root package name */
    public long f57790f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1446e f57791g;

    /* loaded from: classes4.dex */
    public class a implements InterfaceC1446e {
        public a() {
        }

        @Override // d.a.k0.o.d.e.InterfaceC1446e
        public void a() {
            if (e.this.f57786b == null || !e.this.h()) {
                return;
            }
            e.this.j(BdBaseApplication.getInst().getApp().getApplicationContext(), e.this.f57786b);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h.n.b<Long> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadData f57793e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f57794f;

        public b(AdDownloadData adDownloadData, Context context) {
            this.f57793e = adDownloadData;
            this.f57794f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Long l) {
            if (e.this.f57785a.a()) {
                e.this.i(this.f57794f, this.f57793e);
                return;
            }
            e.this.f57786b = this.f57793e;
            e.this.f57790f = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public static final e f57799a = new e(null);
    }

    /* renamed from: d.a.k0.o.d.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1446e {
        void a();
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e g() {
        return d.f57799a;
    }

    public final boolean h() {
        return (this.f57789e == 0 || d.a.k0.s2.d.e(System.currentTimeMillis(), this.f57790f, this.f57789e)) ? false : true;
    }

    public final void i(Context context, AdDownloadData adDownloadData) {
        int i2;
        if (!TextUtils.isEmpty(adDownloadData.getDeeplink())) {
            i2 = y.d(context, adDownloadData.getDeeplink(), adDownloadData.adId(), adDownloadData.getExtInfo());
        } else {
            y.x(adDownloadData.getPkgName());
            i2 = -1;
        }
        this.f57787c.a(i2, adDownloadData.pkgName(), adDownloadData.getExtInfo());
        this.f57786b = null;
    }

    public void j(Context context, AdDownloadData adDownloadData) {
        if (context == null || adDownloadData == null || !this.f57788d) {
            return;
        }
        h.d.G(1000L, TimeUnit.MILLISECONDS).o(h.l.b.a.b()).B(new b(adDownloadData, context));
    }

    public void k() {
        if (this.f57788d) {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.f57785a);
            this.f57785a.b(this.f57791g);
        }
    }

    public e() {
        this.f57785a = new c(null);
        this.f57786b = null;
        this.f57787c = new d.a.k0.o.d.c();
        this.f57788d = d.a.k0.a.e().p();
        this.f57789e = d.a.k0.a.e().f();
        this.f57791g = new a();
    }

    /* loaded from: classes4.dex */
    public static class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Activity> f57796e;

        /* renamed from: f  reason: collision with root package name */
        public InterfaceC1446e f57797f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f57798g;

        public c() {
            this.f57796e = null;
            this.f57797f = null;
            this.f57798g = true;
        }

        public boolean a() {
            WeakReference<Activity> weakReference = this.f57796e;
            return (weakReference == null || weakReference.get() == null || !this.f57798g) ? false : true;
        }

        public void b(InterfaceC1446e interfaceC1446e) {
            this.f57797f = interfaceC1446e;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = this.f57796e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f57796e = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            InterfaceC1446e interfaceC1446e;
            this.f57796e = new WeakReference<>(activity);
            if (!this.f57798g && (interfaceC1446e = this.f57797f) != null) {
                interfaceC1446e.a();
            }
            this.f57798g = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference<Activity> weakReference = this.f57796e;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.f57798g = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
