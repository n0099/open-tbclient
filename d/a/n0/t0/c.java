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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.fun.ad.sdk.FunAdCallback;
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
public class c implements a.d {

    /* renamed from: a  reason: collision with root package name */
    public final FunAdCallback f64529a = new C1666c(this);

    /* loaded from: classes4.dex */
    public class a implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.g f64530a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e f64531b;

        public a(a.g gVar, a.e eVar) {
            this.f64530a = gVar;
            this.f64531b = eVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.g gVar = this.f64530a;
            if (gVar != null) {
                gVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.g gVar = this.f64530a;
            if (gVar != null) {
                gVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.g gVar = this.f64530a;
            if (gVar != null) {
                gVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f64531b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.g gVar = this.f64530a;
            if (gVar != null) {
                gVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f64531b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.g gVar = this.f64530a;
            if (gVar != null) {
                gVar.onRewardedVideo(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f64533a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f64534b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f64535c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f64536d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f64537e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f64538f;

        public b(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            this.f64533a = funNativeAd;
            this.f64534b = activity;
            this.f64535c = viewGroup;
            this.f64536d = list;
            this.f64537e = list2;
            this.f64538f = funAdInteractionListener;
        }

        @Override // d.a.n0.s0.a.i
        public void a() {
            this.f64533a.show(this.f64534b, this.f64535c, this.f64536d, this.f64537e, this.f64538f);
        }
    }

    /* renamed from: d.a.n0.t0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1666c implements FunAdCallback {
        public C1666c(c cVar) {
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClicked(String str, String str2, String str3) {
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdClose(String str, String str2, String str3) {
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoad(String str, String str2, String str3) {
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoadError(String str, String str2, String str3, int i2, String str4) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW_ERROR).param("obj_locate", i2).param("obj_source", str).param("obj_param1", str4).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, str3));
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdLoaded(String str, String str2, String str3) {
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShow(String str, String str2, String str3) {
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onAdShowError(String str, String str2, String str3, int i2, String str4) {
        }

        @Override // com.fun.ad.sdk.FunAdCallback
        public void onRewardedVideo(String str, String str2, String str3) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements FunAdSdk.SdkInitializeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f64539a;

        public d(c cVar, a.i iVar) {
            this.f64539a = iVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            a.i iVar = this.f64539a;
            if (iVar != null) {
                iVar.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f64540a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e f64541b;

        public e(a.f fVar, a.e eVar) {
            this.f64540a = fVar;
            this.f64541b = eVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.f fVar = this.f64540a;
            if (fVar != null) {
                fVar.a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f64541b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.f fVar = this.f64540a;
            if (fVar != null) {
                fVar.onError(str);
            }
            c.this.k("advert_load", str, 0, this.f64541b);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f64543a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f64544b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f64545c;

        public f(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f64543a = activity;
            this.f64544b = funAdSlot;
            this.f64545c = funAdLoadListener;
        }

        @Override // d.a.n0.s0.a.i
        public void a() {
            FunAdSdk.getAdFactory().loadAd(this.f64543a, this.f64544b, this.f64545c);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.g f64546a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e f64547b;

        public g(a.g gVar, a.e eVar) {
            this.f64546a = gVar;
            this.f64547b = eVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.g gVar = this.f64546a;
            if (gVar != null) {
                gVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.g gVar = this.f64546a;
            if (gVar != null) {
                gVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.g gVar = this.f64546a;
            if (gVar != null) {
                gVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f64547b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.g gVar = this.f64546a;
            if (gVar != null) {
                gVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f64547b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.g gVar = this.f64546a;
            if (gVar != null) {
                gVar.onRewardedVideo(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f64549a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f64550b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f64551c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f64552d;

        public h(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f64549a = activity;
            this.f64550b = viewGroup;
            this.f64551c = str;
            this.f64552d = funAdInteractionListener;
        }

        @Override // d.a.n0.s0.a.i
        public void a() {
            FunAdSdk.getAdFactory().showAd(this.f64549a, this.f64550b, this.f64551c, this.f64552d);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f64553a;

        public i(c cVar, String str) {
            this.f64553a = str;
        }

        @Override // d.a.n0.s0.a.i
        public void a() {
            FunAdSdk.getAdFactory().destroyAd(this.f64553a);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f64554a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.e f64555b;

        public j(a.f fVar, a.e eVar) {
            this.f64554a = fVar;
            this.f64555b = eVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.f fVar = this.f64554a;
            if (fVar != null) {
                fVar.a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f64555b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.f fVar = this.f64554a;
            if (fVar != null) {
                fVar.onError(str);
            }
            c.this.k("advert_load", str, 0, this.f64555b);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements a.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f64557a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f64558b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f64559c;

        public k(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f64557a = activity;
            this.f64558b = funAdSlot;
            this.f64559c = funAdLoadListener;
        }

        @Override // d.a.n0.s0.a.i
        public void a() {
            try {
                FunAdSdk.getAdFactory().loadAd(this.f64557a, this.f64558b, this.f64559c);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @Override // d.a.n0.s0.a.d
    public void a(Activity activity, String str, a.f fVar, a.e eVar) {
        j(new f(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new e(fVar, eVar)));
    }

    @Override // d.a.n0.s0.a.d
    public void b(String str) {
        destroyAd(str);
    }

    @Override // d.a.n0.s0.a.d
    public void c(Activity activity, @NonNull Object obj, a.g gVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.e eVar) {
        if (activity.isDestroyed() || !(obj instanceof FunNativeAd)) {
            return;
        }
        j(new b(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new a(gVar, eVar)));
    }

    @Override // d.a.n0.s0.a.d
    public ViewGroup d(Activity activity, String str) {
        return new FrameLayout(activity);
    }

    @Override // d.a.n0.s0.a.d
    public void destroyAd(String str) {
        j(new i(this, str));
    }

    @Override // d.a.n0.s0.a.d
    public Object e(@NonNull Activity activity, @NonNull String str) {
        j(null);
        return FunAdSdk.getAdFactory().getNativeAd(activity, str);
    }

    @Override // d.a.n0.s0.a.d
    public synchronized void f(Application application, a.i iVar) {
        if (!FunAdSdk.isSdkInitializeComplete()) {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).build(), this.f64529a, new d(this, iVar));
            return;
        }
        if (iVar != null) {
            iVar.a();
        }
    }

    @Override // d.a.n0.s0.a.d
    public void g(Activity activity, String str, a.f fVar, a.e eVar) {
        j(new k(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new j(fVar, eVar)));
    }

    @Override // d.a.n0.s0.a.d
    public void h(Activity activity, String str, ViewGroup viewGroup, a.g gVar, a.e eVar) {
        if (viewGroup == null) {
            return;
        }
        j(new h(this, activity, viewGroup, str, new g(gVar, eVar)));
    }

    @Override // d.a.n0.s0.a.d
    public boolean isAdReady(String str) {
        j(null);
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    public final void j(a.i iVar) {
        f(TbadkCoreApplication.getInst(), iVar);
    }

    public final void k(String str, String str2, int i2, a.e eVar) {
        d.a.c.e.n.a a2 = d.a.m0.m0.j.a();
        a2.b("type", "bear");
        a2.b("locate", eVar.f64071a);
        a2.b(SetImageWatermarkTypeReqMsg.SWITCH, eVar.f64072b);
        a2.b("sid", str2);
        a2.c("isSuccess", Integer.valueOf(i2));
        BdStatisticsManager.getInstance().debug(str, a2);
    }
}
