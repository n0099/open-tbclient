package d.a.j0.s0;

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
import d.a.j0.r0.a;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements a.c {

    /* loaded from: classes4.dex */
    public class a implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f60018a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f60019b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f60020c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f60021d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f60022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f60023f;

        public a(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            this.f60018a = funNativeAd;
            this.f60019b = activity;
            this.f60020c = viewGroup;
            this.f60021d = list;
            this.f60022e = list2;
            this.f60023f = funAdInteractionListener;
        }

        @Override // d.a.j0.r0.a.h
        public void a() {
            this.f60018a.show(this.f60019b, this.f60020c, this.f60021d, this.f60022e, this.f60023f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FunAdSdk.SdkInitializeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f60024a;

        public b(c cVar, a.h hVar) {
            this.f60024a = hVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            a.h hVar = this.f60024a;
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    /* renamed from: d.a.j0.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1535c implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f60025a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60026b;

        public C1535c(a.e eVar, a.d dVar) {
            this.f60025a = eVar;
            this.f60026b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.e eVar = this.f60025a;
            if (eVar != null) {
                eVar.a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f60026b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.e eVar = this.f60025a;
            if (eVar != null) {
                eVar.onError(str);
            }
            c.this.k("advert_load", str, 0, this.f60026b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60028a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f60029b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f60030c;

        public d(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f60028a = activity;
            this.f60029b = funAdSlot;
            this.f60030c = funAdLoadListener;
        }

        @Override // d.a.j0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().loadAd(this.f60028a, this.f60029b, this.f60030c);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f60031a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60032b;

        public e(a.f fVar, a.d dVar) {
            this.f60031a = fVar;
            this.f60032b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f60031a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f60031a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f60031a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f60032b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f60031a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f60032b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f60031a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60034a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f60035b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f60036c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f60037d;

        public f(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f60034a = activity;
            this.f60035b = viewGroup;
            this.f60036c = str;
            this.f60037d = funAdInteractionListener;
        }

        @Override // d.a.j0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().showAd(this.f60034a, this.f60035b, this.f60036c, this.f60037d);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60038a;

        public g(c cVar, String str) {
            this.f60038a = str;
        }

        @Override // d.a.j0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().destroyAd(this.f60038a);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f60039a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60040b;

        public h(WeakReference weakReference, a.d dVar) {
            this.f60039a = weakReference;
            this.f60040b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            if (this.f60039a.get() != null) {
                ((a.e) this.f60039a.get()).a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f60040b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            if (this.f60039a.get() != null) {
                ((a.e) this.f60039a.get()).onError(str);
            }
            c.this.k("advert_load", str, 0, this.f60040b);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f60042a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f60043b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f60044c;

        public i(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f60042a = activity;
            this.f60043b = funAdSlot;
            this.f60044c = funAdLoadListener;
        }

        @Override // d.a.j0.r0.a.h
        public void a() {
            try {
                FunAdSdk.getAdFactory().loadAd(this.f60042a, this.f60043b, this.f60044c);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f60045a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f60046b;

        public j(a.f fVar, a.d dVar) {
            this.f60045a = fVar;
            this.f60046b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f60045a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f60045a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f60045a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f60046b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f60045a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f60046b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f60045a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    @Override // d.a.j0.r0.a.c
    public void a(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new d(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new C1535c(eVar, dVar)));
    }

    @Override // d.a.j0.r0.a.c
    public void b(String str) {
        destroyAd(str);
    }

    @Override // d.a.j0.r0.a.c
    public void c(Activity activity, @NonNull Object obj, a.f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.d dVar) {
        if (activity.isDestroyed() || !(obj instanceof FunNativeAd)) {
            return;
        }
        j(new a(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new j(fVar, dVar)));
    }

    @Override // d.a.j0.r0.a.c
    public ViewGroup d(Activity activity, String str) {
        return new FrameLayout(activity);
    }

    @Override // d.a.j0.r0.a.c
    public void destroyAd(String str) {
        j(new g(this, str));
    }

    @Override // d.a.j0.r0.a.c
    public Object e(@NonNull Activity activity, @NonNull String str) {
        j(null);
        return FunAdSdk.getAdFactory().getNativeAd(activity, str);
    }

    @Override // d.a.j0.r0.a.c
    public synchronized void f(Application application, a.h hVar) {
        if (!FunAdSdk.isSdkInitializeComplete()) {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).build(), null, new b(this, hVar));
            return;
        }
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // d.a.j0.r0.a.c
    public void g(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new i(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new h(new WeakReference(eVar), dVar)));
    }

    @Override // d.a.j0.r0.a.c
    public void h(Activity activity, String str, ViewGroup viewGroup, a.f fVar, a.d dVar) {
        if (viewGroup == null) {
            return;
        }
        j(new f(this, activity, viewGroup, str, new e(fVar, dVar)));
    }

    @Override // d.a.j0.r0.a.c
    public boolean isAdReady(String str) {
        j(null);
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    public final void j(a.h hVar) {
        f(TbadkCoreApplication.getInst(), hVar);
    }

    public final void k(String str, String str2, int i2, a.d dVar) {
        d.a.c.e.n.a a2 = d.a.i0.m0.j.a();
        a2.b("type", "bear");
        a2.b("locate", dVar.f59512a);
        a2.b(SetImageWatermarkTypeReqMsg.SWITCH, dVar.f59513b);
        a2.b("sid", str2);
        a2.c("isSuccess", Integer.valueOf(i2));
        BdStatisticsManager.getInstance().debug(str, a2);
    }
}
