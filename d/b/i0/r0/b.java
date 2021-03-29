package d.b.i0.r0;

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
import d.b.b.e.p.l;
import d.b.i0.q0.a;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements a.b {

    /* loaded from: classes4.dex */
    public class a implements a.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAd f59694a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f59695b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f59696c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f59697d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f59698e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f59699f;

        public a(b bVar, FunNativeAd funNativeAd, Activity activity, ViewGroup viewGroup, List list, List list2, FunAdInteractionListener funAdInteractionListener) {
            this.f59694a = funNativeAd;
            this.f59695b = activity;
            this.f59696c = viewGroup;
            this.f59697d = list;
            this.f59698e = list2;
            this.f59699f = funAdInteractionListener;
        }

        @Override // d.b.i0.q0.a.g
        public void a() {
            this.f59694a.show(this.f59695b, this.f59696c, this.f59697d, this.f59698e, this.f59699f);
        }
    }

    /* renamed from: d.b.i0.r0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1502b implements FunAdSdk.SdkInitializeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.g f59700a;

        public C1502b(b bVar, a.g gVar) {
            this.f59700a = gVar;
        }

        @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
        public void onComplete() {
            a.g gVar = this.f59700a;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f59701a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.c f59702b;

        public c(a.d dVar, a.c cVar) {
            this.f59701a = dVar;
            this.f59702b = cVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            a.d dVar = this.f59701a;
            if (dVar != null) {
                dVar.a(str, 0);
            }
            b.this.k("advert_load", str, 1, this.f59702b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            a.d dVar = this.f59701a;
            if (dVar != null) {
                dVar.onError(str);
            }
            b.this.k("advert_load", str, 0, this.f59702b);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f59704a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f59705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f59706c;

        public d(b bVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f59704a = activity;
            this.f59705b = funAdSlot;
            this.f59706c = funAdLoadListener;
        }

        @Override // d.b.i0.q0.a.g
        public void a() {
            FunAdSdk.getAdFactory().loadAd(this.f59704a, this.f59705b, this.f59706c);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f59707a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.c f59708b;

        public e(a.e eVar, a.c cVar) {
            this.f59707a = eVar;
            this.f59708b = cVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.e eVar = this.f59707a;
            if (eVar != null) {
                eVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.e eVar = this.f59707a;
            if (eVar != null) {
                eVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.e eVar = this.f59707a;
            if (eVar != null) {
                eVar.onAdError(str);
            }
            b.this.k("advert_show", str, 0, this.f59708b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.e eVar = this.f59707a;
            if (eVar != null) {
                eVar.onAdShow(str);
            }
            b.this.k("advert_show", str, 1, this.f59708b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.e eVar = this.f59707a;
            if (eVar != null) {
                eVar.onRewardedVideo(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f59710a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f59711b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f59712c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f59713d;

        public f(b bVar, Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
            this.f59710a = activity;
            this.f59711b = viewGroup;
            this.f59712c = str;
            this.f59713d = funAdInteractionListener;
        }

        @Override // d.b.i0.q0.a.g
        public void a() {
            FunAdSdk.getAdFactory().showAd(this.f59710a, this.f59711b, this.f59712c, this.f59713d);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59714a;

        public g(b bVar, String str) {
            this.f59714a = str;
        }

        @Override // d.b.i0.q0.a.g
        public void a() {
            FunAdSdk.getAdFactory().destroyAd(this.f59714a);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements FunAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f59715a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.c f59716b;

        public h(WeakReference weakReference, a.c cVar) {
            this.f59715a = weakReference;
            this.f59716b = cVar;
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onAdLoaded(String str) {
            if (this.f59715a.get() != null) {
                ((a.d) this.f59715a.get()).a(str, 0);
            }
            b.this.k("advert_load", str, 1, this.f59716b);
        }

        @Override // com.fun.ad.sdk.FunAdLoadListener
        public void onError(String str) {
            if (this.f59715a.get() != null) {
                ((a.d) this.f59715a.get()).onError(str);
            }
            b.this.k("advert_load", str, 0, this.f59716b);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f59718a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f59719b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FunAdLoadListener f59720c;

        public i(b bVar, Activity activity, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            this.f59718a = activity;
            this.f59719b = funAdSlot;
            this.f59720c = funAdLoadListener;
        }

        @Override // d.b.i0.q0.a.g
        public void a() {
            try {
                FunAdSdk.getAdFactory().loadAd(this.f59718a, this.f59719b, this.f59720c);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements FunAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f59721a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.c f59722b;

        public j(a.e eVar, a.c cVar) {
            this.f59721a = eVar;
            this.f59722b = cVar;
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClicked(String str) {
            a.e eVar = this.f59721a;
            if (eVar != null) {
                eVar.onAdClicked(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdClose(String str) {
            a.e eVar = this.f59721a;
            if (eVar != null) {
                eVar.onAdClose(str);
            }
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdError(String str) {
            a.e eVar = this.f59721a;
            if (eVar != null) {
                eVar.onAdError(str);
            }
            b.this.k("advert_show", str, 0, this.f59722b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onAdShow(String str) {
            a.e eVar = this.f59721a;
            if (eVar != null) {
                eVar.onAdShow(str);
            }
            b.this.k("advert_show", str, 1, this.f59722b);
        }

        @Override // com.fun.ad.sdk.FunAdInteractionListener
        public void onRewardedVideo(String str) {
            a.e eVar = this.f59721a;
            if (eVar != null) {
                eVar.onRewardedVideo(str);
            }
        }
    }

    @Override // d.b.i0.q0.a.b
    public ViewGroup a(Activity activity, String str) {
        return new FrameLayout(activity);
    }

    @Override // d.b.i0.q0.a.b
    public Object b(@NonNull Activity activity, @NonNull String str) {
        j(null);
        return FunAdSdk.getAdFactory().getNativeAd(activity, str);
    }

    @Override // d.b.i0.q0.a.b
    public void c(Activity activity, String str, a.d dVar, a.c cVar) {
        j(new d(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new c(dVar, cVar)));
    }

    @Override // d.b.i0.q0.a.b
    public void d(String str) {
        destroyAd(str);
    }

    @Override // d.b.i0.q0.a.b
    public void destroyAd(String str) {
        j(new g(this, str));
    }

    @Override // d.b.i0.q0.a.b
    public synchronized void e(Application application, a.g gVar) {
        if (!FunAdSdk.isSdkInitializeComplete()) {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).build(), null, new C1502b(this, gVar));
            return;
        }
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // d.b.i0.q0.a.b
    public void f(Activity activity, @NonNull Object obj, a.e eVar, ViewGroup viewGroup, List<View> list, List<View> list2, a.c cVar) {
        if (activity.isDestroyed() || !(obj instanceof FunNativeAd)) {
            return;
        }
        j(new a(this, (FunNativeAd) obj, activity, viewGroup, list, list2, new j(eVar, cVar)));
    }

    @Override // d.b.i0.q0.a.b
    public void g(Activity activity, String str, a.d dVar, a.c cVar) {
        j(new i(this, activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.k(activity)).build(), new h(new WeakReference(dVar), cVar)));
    }

    @Override // d.b.i0.q0.a.b
    public void h(Activity activity, String str, ViewGroup viewGroup, a.e eVar, a.c cVar) {
        if (viewGroup == null) {
            return;
        }
        j(new f(this, activity, viewGroup, str, new e(eVar, cVar)));
    }

    @Override // d.b.i0.q0.a.b
    public boolean isAdReady(String str) {
        j(null);
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    public final void j(a.g gVar) {
        e(TbadkCoreApplication.getInst(), gVar);
    }

    public final void k(String str, String str2, int i2, a.c cVar) {
        d.b.b.e.n.a a2 = d.b.h0.m0.j.a();
        a2.b("type", "bear");
        a2.b("locate", cVar.f59261a);
        a2.b(SetImageWatermarkTypeReqMsg.SWITCH, cVar.f59262b);
        a2.b("sid", str2);
        a2.c("isSuccess", Integer.valueOf(i2));
        BdStatisticsManager.getInstance().debug(str, a2);
    }
}
