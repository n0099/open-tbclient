package d.b.j0.s0;

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
import d.b.c.e.p.l;
import d.b.j0.r0.a;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements a.c {

    /* loaded from: classes4.dex */
    public class a implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f61857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f61858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61859c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f61860d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f61861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f61862f;

        public a(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            this.f61857a = funNativeAd;
            this.f61858b = activity;
            this.f61859c = viewGroup;
            this.f61860d = list;
            this.f61861e = list2;
            this.f61862f = funAdInteractionListener;
        }

        @Override // d.b.j0.r0.a.h
        public void a() {
            this.f61857a.show(this.f61858b, this.f61859c, this.f61860d, this.f61861e, this.f61862f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FunAdSdk.SdkInitializeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f61863a;

        public b(c cVar, a.h hVar) {
            this.f61863a = hVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            a.h hVar = this.f61863a;
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    /* renamed from: d.b.j0.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1596c implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f61864a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f61865b;

        public C1596c(a.e eVar, a.d dVar) {
            this.f61864a = eVar;
            this.f61865b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.e eVar = this.f61864a;
            if (eVar != null) {
                eVar.a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f61865b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.e eVar = this.f61864a;
            if (eVar != null) {
                eVar.onError(str);
            }
            c.this.k("advert_load", str, 0, this.f61865b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f61867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f61868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f61869c;

        public d(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f61867a = activity;
            this.f61868b = funAdSlot;
            this.f61869c = funAdLoadListener;
        }

        @Override // d.b.j0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().loadAd(this.f61867a, this.f61868b, this.f61869c);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f61870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f61871b;

        public e(a.f fVar, a.d dVar) {
            this.f61870a = fVar;
            this.f61871b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f61870a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f61870a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f61870a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f61871b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f61870a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f61871b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f61870a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f61873a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61874b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61875c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f61876d;

        public f(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f61873a = activity;
            this.f61874b = viewGroup;
            this.f61875c = str;
            this.f61876d = funAdInteractionListener;
        }

        @Override // d.b.j0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().showAd(this.f61873a, this.f61874b, this.f61875c, this.f61876d);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61877a;

        public g(c cVar, String str) {
            this.f61877a = str;
        }

        @Override // d.b.j0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().destroyAd(this.f61877a);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f61878a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f61879b;

        public h(WeakReference weakReference, a.d dVar) {
            this.f61878a = weakReference;
            this.f61879b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            if (this.f61878a.get() != null) {
                ((a.e) this.f61878a.get()).a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f61879b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            if (this.f61878a.get() != null) {
                ((a.e) this.f61878a.get()).onError(str);
            }
            c.this.k("advert_load", str, 0, this.f61879b);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f61881a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f61882b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f61883c;

        public i(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f61881a = activity;
            this.f61882b = funAdSlot;
            this.f61883c = funAdLoadListener;
        }

        @Override // d.b.j0.r0.a.h
        public void a() {
            try {
                FunAdSdk.getAdFactory().loadAd(this.f61881a, this.f61882b, this.f61883c);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f61884a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f61885b;

        public j(a.f fVar, a.d dVar) {
            this.f61884a = fVar;
            this.f61885b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f61884a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f61884a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f61884a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f61885b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f61884a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f61885b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f61884a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    @Override // d.b.j0.r0.a.c
    public ViewGroup a(Activity activity, String str) {
        return new FrameLayout(activity);
    }

    @Override // d.b.j0.r0.a.c
    public Object b(@NonNull Activity activity, @NonNull String str) {
        j(null);
        return FunAdSdk.getAdFactory().getNativeAd(activity, str);
    }

    @Override // d.b.j0.r0.a.c
    public void c(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new d(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new C1596c(eVar, dVar)));
    }

    @Override // d.b.j0.r0.a.c
    public void d(String str) {
        destroyAd(str);
    }

    @Override // d.b.j0.r0.a.c
    public void destroyAd(String str) {
        j(new g(this, str));
    }

    @Override // d.b.j0.r0.a.c
    public synchronized void e(Application application, a.h hVar) {
        if (!FunAdSdk.isSdkInitializeComplete()) {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).build(), null, new b(this, hVar));
            return;
        }
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // d.b.j0.r0.a.c
    public void f(Activity activity, @NonNull Object obj, a.f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.d dVar) {
        if (activity.isDestroyed() || !(obj instanceof FunNativeAd)) {
            return;
        }
        j(new a(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new j(fVar, dVar)));
    }

    @Override // d.b.j0.r0.a.c
    public void g(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new i(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new h(new WeakReference(eVar), dVar)));
    }

    @Override // d.b.j0.r0.a.c
    public void h(Activity activity, String str, ViewGroup viewGroup, a.f fVar, a.d dVar) {
        if (viewGroup == null) {
            return;
        }
        j(new f(this, activity, viewGroup, str, new e(fVar, dVar)));
    }

    @Override // d.b.j0.r0.a.c
    public boolean isAdReady(String str) {
        j(null);
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    public final void j(a.h hVar) {
        e(TbadkCoreApplication.getInst(), hVar);
    }

    public final void k(String str, String str2, int i2, a.d dVar) {
        d.b.c.e.n.a a2 = d.b.i0.m0.j.a();
        a2.b("type", "bear");
        a2.b("locate", dVar.f61370a);
        a2.b(SetImageWatermarkTypeReqMsg.SWITCH, dVar.f61371b);
        a2.b("sid", str2);
        a2.c("isSuccess", Integer.valueOf(i2));
        BdStatisticsManager.getInstance().debug(str, a2);
    }
}
