package d.a.n0.t0;

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
import d.a.n0.s0.a;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements a.c {

    /* loaded from: classes4.dex */
    public class a implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f60838a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f60839b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f60840c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f60841d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f60842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f60843f;

        public a(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            this.f60838a = funNativeAd;
            this.f60839b = activity;
            this.f60840c = viewGroup;
            this.f60841d = list;
            this.f60842e = list2;
            this.f60843f = funAdInteractionListener;
        }

        @Override // d.a.n0.s0.a.h
        public void a() {
            this.f60838a.show(this.f60839b, this.f60840c, this.f60841d, this.f60842e, this.f60843f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FunAdSdk.SdkInitializeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f60844a;

        public b(c cVar, a.h hVar) {
            this.f60844a = hVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            a.h hVar = this.f60844a;
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    /* renamed from: d.a.n0.t0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1610c implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f60845a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60846b;

        public C1610c(a.e eVar, a.d dVar) {
            this.f60845a = eVar;
            this.f60846b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.e eVar = this.f60845a;
            if (eVar != null) {
                eVar.a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f60846b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.e eVar = this.f60845a;
            if (eVar != null) {
                eVar.onError(str);
            }
            c.this.k("advert_load", str, 0, this.f60846b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60848a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f60849b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f60850c;

        public d(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f60848a = activity;
            this.f60849b = funAdSlot;
            this.f60850c = funAdLoadListener;
        }

        @Override // d.a.n0.s0.a.h
        public void a() {
            FunAdSdk.getAdFactory().loadAd(this.f60848a, this.f60849b, this.f60850c);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f60851a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60852b;

        public e(a.f fVar, a.d dVar) {
            this.f60851a = fVar;
            this.f60852b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f60851a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f60851a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f60851a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f60852b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f60851a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f60852b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f60851a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60854a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f60855b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60856c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f60857d;

        public f(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f60854a = activity;
            this.f60855b = viewGroup;
            this.f60856c = str;
            this.f60857d = funAdInteractionListener;
        }

        @Override // d.a.n0.s0.a.h
        public void a() {
            FunAdSdk.getAdFactory().showAd(this.f60854a, this.f60855b, this.f60856c, this.f60857d);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60858a;

        public g(c cVar, String str) {
            this.f60858a = str;
        }

        @Override // d.a.n0.s0.a.h
        public void a() {
            FunAdSdk.getAdFactory().destroyAd(this.f60858a);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f60859a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60860b;

        public h(a.e eVar, a.d dVar) {
            this.f60859a = eVar;
            this.f60860b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.e eVar = this.f60859a;
            if (eVar != null) {
                eVar.a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f60860b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.e eVar = this.f60859a;
            if (eVar != null) {
                eVar.onError(str);
            }
            c.this.k("advert_load", str, 0, this.f60860b);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60862a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f60863b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f60864c;

        public i(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f60862a = activity;
            this.f60863b = funAdSlot;
            this.f60864c = funAdLoadListener;
        }

        @Override // d.a.n0.s0.a.h
        public void a() {
            try {
                FunAdSdk.getAdFactory().loadAd(this.f60862a, this.f60863b, this.f60864c);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f60865a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60866b;

        public j(a.f fVar, a.d dVar) {
            this.f60865a = fVar;
            this.f60866b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f60865a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f60865a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f60865a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f60866b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f60865a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f60866b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f60865a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    @Override // d.a.n0.s0.a.c
    public void a(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new d(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new C1610c(eVar, dVar)));
    }

    @Override // d.a.n0.s0.a.c
    public void b(String str) {
        destroyAd(str);
    }

    @Override // d.a.n0.s0.a.c
    public void c(Activity activity, @NonNull Object obj, a.f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.d dVar) {
        if (activity.isDestroyed() || !(obj instanceof FunNativeAd)) {
            return;
        }
        j(new a(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new j(fVar, dVar)));
    }

    @Override // d.a.n0.s0.a.c
    public ViewGroup d(Activity activity, String str) {
        return new FrameLayout(activity);
    }

    @Override // d.a.n0.s0.a.c
    public void destroyAd(String str) {
        j(new g(this, str));
    }

    @Override // d.a.n0.s0.a.c
    public Object e(@NonNull Activity activity, @NonNull String str) {
        j(null);
        return FunAdSdk.getAdFactory().getNativeAd(activity, str);
    }

    @Override // d.a.n0.s0.a.c
    public synchronized void f(Application application, a.h hVar) {
        if (!FunAdSdk.isSdkInitializeComplete()) {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).build(), null, new b(this, hVar));
            return;
        }
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // d.a.n0.s0.a.c
    public void g(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new i(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new h(eVar, dVar)));
    }

    @Override // d.a.n0.s0.a.c
    public void h(Activity activity, String str, ViewGroup viewGroup, a.f fVar, a.d dVar) {
        if (viewGroup == null) {
            return;
        }
        j(new f(this, activity, viewGroup, str, new e(fVar, dVar)));
    }

    @Override // d.a.n0.s0.a.c
    public boolean isAdReady(String str) {
        j(null);
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    public final void j(a.h hVar) {
        f(TbadkCoreApplication.getInst(), hVar);
    }

    public final void k(String str, String str2, int i2, a.d dVar) {
        d.a.c.e.n.a a2 = d.a.m0.m0.j.a();
        a2.b("type", "bear");
        a2.b("locate", dVar.f60380a);
        a2.b(SetImageWatermarkTypeReqMsg.SWITCH, dVar.f60381b);
        a2.b("sid", str2);
        a2.c("isSuccess", Integer.valueOf(i2));
        BdStatisticsManager.getInstance().debug(str, a2);
    }
}
