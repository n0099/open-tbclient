package d.a.o0.t.a;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.c.e.p.l;
import d.a.n0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class d implements d.a.o0.t.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f64602b;

    /* renamed from: c  reason: collision with root package name */
    public int f64603c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f64604d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f64605e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f64606f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.k.b f64607g;

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.k.b {
        public a() {
        }

        @Override // d.a.n0.k.b
        public void a() {
            d.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.k.a f64609a;

        public b(d.a.n0.k.a aVar) {
            this.f64609a = aVar;
        }

        public final void a(String str, int i2) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("type", "cpc");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.o0.t.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            d.a.o0.t.a.j.a.j(d.a.o0.t.a.j.a.f64645e, "0", i2);
            d.this.f64606f = AdLoadState.SUCCEED;
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded success");
            }
            if (d.this.f64604d == null || d.this.f64605e == null) {
                return;
            }
            d.this.f64602b = rsplashType;
            d.this.f64603c = 0;
            d.a.o0.t.a.h.a.c().g(this.f64609a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes cpc ad onAdClick ");
            }
            d.a.n0.k.a aVar = this.f64609a;
            if (aVar != null) {
                aVar.b(d.this.f64602b == RsplashType.VIDEO, 1 == d.this.f64603c, 7);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            boolean z = d.this.f64606f == AdLoadState.DISMISSED;
            d.this.f64606f = AdLoadState.DISMISSED;
            d.a.n0.k.a aVar = this.f64609a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.a.o0.t.a.j.a.j(d.a.o0.t.a.j.a.f64645e, str, 0);
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded failed : " + str);
            }
            d.this.f64606f = AdLoadState.FAILED;
            d.a.o0.t.a.h.a.c().g(this.f64609a);
            d.a.o0.t.a.j.a.k(d.a.o0.t.a.j.a.f64645e, "1");
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes cpc ad present");
            }
            boolean z = 1 == d.this.f64603c;
            d.a.n0.k.a aVar = this.f64609a;
            if (aVar != null) {
                aVar.c(false, z, 7);
            }
            d.a.o0.t.a.j.a.k(d.a.o0.t.a.j.a.f64645e, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.n0.k.a aVar = this.f64609a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
        }
    }

    public d() {
        new AdSplashStyle();
        this.f64606f = AdLoadState.INIT;
        this.f64607g = new a();
    }

    @Override // d.a.o0.t.a.h.b
    public AdLoadState a() {
        return this.f64606f;
    }

    @Override // d.a.o0.t.a.h.b
    public void b(d.a.n0.k.d dVar) {
        if (dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f53216c = this.f64607g;
        d.a.n0.k.a a2 = dVar.a();
        this.f64605e = new WeakReference<>(dVar.b());
        b bVar = new b(a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.d0.a.b.a.f43374a.get().e());
            this.f64604d = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.d0.a.b.a.f43374a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), bVar);
            this.f64606f = AdLoadState.LOADING;
            this.f64604d.load();
            d.a.o0.t.a.j.a.i(d.a.o0.t.a.j.a.f64645e);
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes cpc ad start load ");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // d.a.o0.t.a.h.b
    public String c() {
        return "cpc";
    }

    @Override // d.a.o0.t.a.h.b
    public void destroy() {
        SplashAd splashAd = this.f64604d;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    public final void m() {
        WeakReference<ViewGroup> weakReference = this.f64605e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f64605e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f64605e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.o0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f64604d == null || (weakReference = this.f64605e) == null || weakReference.get() == null || this.f64606f != AdLoadState.SUCCEED) {
            return;
        }
        m();
        int i2 = this.f64603c;
        if (this.f64605e.get().getChildCount() > 0) {
            this.f64605e.get().removeAllViews();
        }
        if (d.a.o0.t.a.h.b.f64633a) {
            Log.d("IAdSdkSplash", "bes cpc ad show");
        }
        this.f64606f = AdLoadState.SHOWED;
        this.f64604d.show(this.f64605e.get());
    }
}
