package d.a.k0.s0;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import d.a.c.e.p.l;
import d.a.k0.r0.a;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements a.c {

    /* loaded from: classes4.dex */
    public class a implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f60736a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f60737b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f60738c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f60739d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f60740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f60741f;

        public a(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            this.f60736a = funNativeAd;
            this.f60737b = activity;
            this.f60738c = viewGroup;
            this.f60739d = list;
            this.f60740e = list2;
            this.f60741f = funAdInteractionListener;
        }

        @Override // d.a.k0.r0.a.h
        public void a() {
            this.f60736a.show(this.f60737b, this.f60738c, this.f60739d, this.f60740e, this.f60741f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FunAdSdk.SdkInitializeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f60742a;

        public b(c cVar, a.h hVar) {
            this.f60742a = hVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            a.h hVar = this.f60742a;
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    /* renamed from: d.a.k0.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1604c implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f60743a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60744b;

        public C1604c(a.e eVar, a.d dVar) {
            this.f60743a = eVar;
            this.f60744b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.e eVar = this.f60743a;
            if (eVar != null) {
                eVar.a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f60744b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.e eVar = this.f60743a;
            if (eVar != null) {
                eVar.onError(str);
            }
            c.this.k("advert_load", str, 0, this.f60744b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60746a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f60747b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f60748c;

        public d(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f60746a = activity;
            this.f60747b = funAdSlot;
            this.f60748c = funAdLoadListener;
        }

        @Override // d.a.k0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().loadAd(this.f60746a, this.f60747b, this.f60748c);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f60749a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60750b;

        public e(a.f fVar, a.d dVar) {
            this.f60749a = fVar;
            this.f60750b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f60749a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f60749a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f60749a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f60750b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f60749a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f60750b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f60749a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60752a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f60753b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60754c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f60755d;

        public f(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f60752a = activity;
            this.f60753b = viewGroup;
            this.f60754c = str;
            this.f60755d = funAdInteractionListener;
        }

        @Override // d.a.k0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().showAd(this.f60752a, this.f60753b, this.f60754c, this.f60755d);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60756a;

        public g(c cVar, String str) {
            this.f60756a = str;
        }

        @Override // d.a.k0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().destroyAd(this.f60756a);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f60757a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60758b;

        public h(WeakReference weakReference, a.d dVar) {
            this.f60757a = weakReference;
            this.f60758b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            if (this.f60757a.get() != null) {
                ((a.e) this.f60757a.get()).a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f60758b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            if (this.f60757a.get() != null) {
                ((a.e) this.f60757a.get()).onError(str);
            }
            c.this.k("advert_load", str, 0, this.f60758b);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60760a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f60761b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f60762c;

        public i(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f60760a = activity;
            this.f60761b = funAdSlot;
            this.f60762c = funAdLoadListener;
        }

        @Override // d.a.k0.r0.a.h
        public void a() {
            try {
                FunAdSdk.getAdFactory().loadAd(this.f60760a, this.f60761b, this.f60762c);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f60763a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60764b;

        public j(a.f fVar, a.d dVar) {
            this.f60763a = fVar;
            this.f60764b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f60763a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f60763a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f60763a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f60764b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f60763a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f60764b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f60763a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    @Override // d.a.k0.r0.a.c
    public void a(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new d(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new C1604c(eVar, dVar)));
    }

    @Override // d.a.k0.r0.a.c
    public void b(String str) {
        destroyAd(str);
    }

    @Override // d.a.k0.r0.a.c
    public void c(Activity activity, @NonNull Object obj, a.f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.d dVar) {
        if (activity.isDestroyed() || !(obj instanceof FunNativeAd)) {
            return;
        }
        j(new a(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new j(fVar, dVar)));
    }

    @Override // d.a.k0.r0.a.c
    public ViewGroup d(Activity activity, String str) {
        return new FrameLayout(activity);
    }

    @Override // d.a.k0.r0.a.c
    public void destroyAd(String str) {
        j(new g(this, str));
    }

    @Override // d.a.k0.r0.a.c
    public Object e(@NonNull Activity activity, @NonNull String str) {
        j(null);
        return FunAdSdk.getAdFactory().getNativeAd(activity, str);
    }

    @Override // d.a.k0.r0.a.c
    public synchronized void f(Application application, a.h hVar) {
        if (!FunAdSdk.isSdkInitializeComplete()) {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).build(), null, new b(this, hVar));
            return;
        }
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // d.a.k0.r0.a.c
    public void g(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new i(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new h(new WeakReference(eVar), dVar)));
    }

    @Override // d.a.k0.r0.a.c
    public void h(Activity activity, String str, ViewGroup viewGroup, a.f fVar, a.d dVar) {
        if (viewGroup == null) {
            return;
        }
        j(new f(this, activity, viewGroup, str, new e(fVar, dVar)));
    }

    @Override // d.a.k0.r0.a.c
    public boolean isAdReady(String str) {
        j(null);
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    public final void j(a.h hVar) {
        f(TbadkCoreApplication.getInst(), hVar);
    }

    public final void k(String str, String str2, int i2, a.d dVar) {
        d.a.c.e.n.a a2 = d.a.j0.m0.j.a();
        a2.b("type", "bear");
        a2.b("locate", dVar.f60257a);
        a2.b(SetImageWatermarkTypeReqMsg.SWITCH, dVar.f60258b);
        a2.b("sid", str2);
        a2.c("isSuccess", Integer.valueOf(i2));
        BdStatisticsManager.getInstance().debug(str, a2);
    }
}
