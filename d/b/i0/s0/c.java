package d.b.i0.s0;

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
import d.b.i0.r0.a;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements a.c {

    /* loaded from: classes4.dex */
    public class a implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f61436a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f61437b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61438c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f61439d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f61440e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f61441f;

        public a(c cVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            this.f61436a = funNativeAd;
            this.f61437b = activity;
            this.f61438c = viewGroup;
            this.f61439d = list;
            this.f61440e = list2;
            this.f61441f = funAdInteractionListener;
        }

        @Override // d.b.i0.r0.a.h
        public void a() {
            this.f61436a.show(this.f61437b, this.f61438c, this.f61439d, this.f61440e, this.f61441f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FunAdSdk.SdkInitializeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f61442a;

        public b(c cVar, a.h hVar) {
            this.f61442a = hVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            a.h hVar = this.f61442a;
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    /* renamed from: d.b.i0.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1573c implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f61443a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f61444b;

        public C1573c(a.e eVar, a.d dVar) {
            this.f61443a = eVar;
            this.f61444b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.e eVar = this.f61443a;
            if (eVar != null) {
                eVar.a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f61444b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.e eVar = this.f61443a;
            if (eVar != null) {
                eVar.onError(str);
            }
            c.this.k("advert_load", str, 0, this.f61444b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f61446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f61447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f61448c;

        public d(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f61446a = activity;
            this.f61447b = funAdSlot;
            this.f61448c = funAdLoadListener;
        }

        @Override // d.b.i0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().loadAd(this.f61446a, this.f61447b, this.f61448c);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f61449a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f61450b;

        public e(a.f fVar, a.d dVar) {
            this.f61449a = fVar;
            this.f61450b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f61449a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f61449a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f61449a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f61450b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f61449a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f61450b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f61449a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f61452a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61453b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61454c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f61455d;

        public f(c cVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f61452a = activity;
            this.f61453b = viewGroup;
            this.f61454c = str;
            this.f61455d = funAdInteractionListener;
        }

        @Override // d.b.i0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().showAd(this.f61452a, this.f61453b, this.f61454c, this.f61455d);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61456a;

        public g(c cVar, String str) {
            this.f61456a = str;
        }

        @Override // d.b.i0.r0.a.h
        public void a() {
            FunAdSdk.getAdFactory().destroyAd(this.f61456a);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f61457a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f61458b;

        public h(WeakReference weakReference, a.d dVar) {
            this.f61457a = weakReference;
            this.f61458b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            if (this.f61457a.get() != null) {
                ((a.e) this.f61457a.get()).a(str, 0);
            }
            c.this.k("advert_load", str, 1, this.f61458b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            if (this.f61457a.get() != null) {
                ((a.e) this.f61457a.get()).onError(str);
            }
            c.this.k("advert_load", str, 0, this.f61458b);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f61460a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f61461b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f61462c;

        public i(c cVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f61460a = activity;
            this.f61461b = funAdSlot;
            this.f61462c = funAdLoadListener;
        }

        @Override // d.b.i0.r0.a.h
        public void a() {
            try {
                FunAdSdk.getAdFactory().loadAd(this.f61460a, this.f61461b, this.f61462c);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.f f61463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.d f61464b;

        public j(a.f fVar, a.d dVar) {
            this.f61463a = fVar;
            this.f61464b = dVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.f fVar = this.f61463a;
            if (fVar != null) {
                fVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.f fVar = this.f61463a;
            if (fVar != null) {
                fVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.f fVar = this.f61463a;
            if (fVar != null) {
                fVar.onAdError(str);
            }
            c.this.k("advert_show", str, 0, this.f61464b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.f fVar = this.f61463a;
            if (fVar != null) {
                fVar.onAdShow(str);
            }
            c.this.k("advert_show", str, 1, this.f61464b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.f fVar = this.f61463a;
            if (fVar != null) {
                fVar.onRewardedVideo(str);
            }
        }
    }

    @Override // d.b.i0.r0.a.c
    public ViewGroup a(Activity activity, String str) {
        return new FrameLayout(activity);
    }

    @Override // d.b.i0.r0.a.c
    public Object b(@NonNull Activity activity, @NonNull String str) {
        j(null);
        return FunAdSdk.getAdFactory().getNativeAd(activity, str);
    }

    @Override // d.b.i0.r0.a.c
    public void c(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new d(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new C1573c(eVar, dVar)));
    }

    @Override // d.b.i0.r0.a.c
    public void d(String str) {
        destroyAd(str);
    }

    @Override // d.b.i0.r0.a.c
    public void destroyAd(String str) {
        j(new g(this, str));
    }

    @Override // d.b.i0.r0.a.c
    public synchronized void e(Application application, a.h hVar) {
        if (!FunAdSdk.isSdkInitializeComplete()) {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).build(), null, new b(this, hVar));
            return;
        }
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // d.b.i0.r0.a.c
    public void f(Activity activity, @NonNull Object obj, a.f fVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.d dVar) {
        if (activity.isDestroyed() || !(obj instanceof FunNativeAd)) {
            return;
        }
        j(new a(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new j(fVar, dVar)));
    }

    @Override // d.b.i0.r0.a.c
    public void g(Activity activity, String str, a.e eVar, a.d dVar) {
        j(new i(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new h(new WeakReference(eVar), dVar)));
    }

    @Override // d.b.i0.r0.a.c
    public void h(Activity activity, String str, ViewGroup viewGroup, a.f fVar, a.d dVar) {
        if (viewGroup == null) {
            return;
        }
        j(new f(this, activity, viewGroup, str, new e(fVar, dVar)));
    }

    @Override // d.b.i0.r0.a.c
    public boolean isAdReady(String str) {
        j(null);
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    public final void j(a.h hVar) {
        e(TbadkCoreApplication.getInst(), hVar);
    }

    public final void k(String str, String str2, int i2, a.d dVar) {
        d.b.c.e.n.a a2 = d.b.h0.m0.j.a();
        a2.b("type", "bear");
        a2.b("locate", dVar.f60949a);
        a2.b(SetImageWatermarkTypeReqMsg.SWITCH, dVar.f60950b);
        a2.b("sid", str2);
        a2.c("isSuccess", Integer.valueOf(i2));
        BdStatisticsManager.getInstance().debug(str, a2);
    }
}
