package d.a.j0.r.a;

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
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.c.e.p.l;
import d.a.i0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class d implements d.a.j0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f59460b;

    /* renamed from: c  reason: collision with root package name */
    public int f59461c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f59462d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f59463e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f59464f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.k.b f59465g;

    /* loaded from: classes4.dex */
    public class a implements d.a.i0.k.b {
        public a() {
        }

        @Override // d.a.i0.k.b
        public void a() {
            d.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.k.a f59467a;

        public b(d.a.i0.k.a aVar) {
            this.f59467a = aVar;
        }

        public final void a(String str, int i2) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("type", AdCard.CHARGE_STYLE_CPC);
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.j0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            d.a.j0.r.a.j.a.i(d.a.j0.r.a.j.a.f59503e, "0", i2);
            d.this.f59464f = AdLoadState.SUCCEED;
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded success");
            }
            if (d.this.f59462d == null || d.this.f59463e == null) {
                return;
            }
            d.this.f59460b = rsplashType;
            d.this.f59461c = 0;
            d.a.j0.r.a.h.a.c().g(this.f59467a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes cpc ad onAdClick ");
            }
            d.a.i0.k.a aVar = this.f59467a;
            if (aVar != null) {
                aVar.b(d.this.f59460b == RsplashType.VIDEO, 1 == d.this.f59461c, 7);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            boolean z = d.this.f59464f == AdLoadState.DISMISSED;
            d.this.f59464f = AdLoadState.DISMISSED;
            d.a.i0.k.a aVar = this.f59467a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.a.j0.r.a.j.a.i(d.a.j0.r.a.j.a.f59503e, str, 0);
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded failed : " + str);
            }
            d.this.f59464f = AdLoadState.FAILED;
            d.a.j0.r.a.h.a.c().g(this.f59467a);
            d.a.j0.r.a.j.a.j(d.a.j0.r.a.j.a.f59503e, "1");
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes cpc ad present");
            }
            boolean z = 1 == d.this.f59461c;
            d.a.i0.k.a aVar = this.f59467a;
            if (aVar != null) {
                aVar.c(false, z, 7);
            }
            d.a.j0.r.a.j.a.j(d.a.j0.r.a.j.a.f59503e, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.i0.k.a aVar = this.f59467a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
        }
    }

    public d() {
        new AdSplashStyle();
        this.f59464f = AdLoadState.INIT;
        this.f59465g = new a();
    }

    @Override // d.a.j0.r.a.h.b
    public AdLoadState a() {
        return this.f59464f;
    }

    @Override // d.a.j0.r.a.h.b
    public void b(d.a.i0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f48563c = this.f59465g;
        d.a.i0.k.a a2 = cVar.a();
        this.f59463e = new WeakReference<>(cVar.b());
        b bVar = new b(a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            cVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.b0.a.b.a.f39288a.get().e());
            this.f59462d = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.b0.a.b.a.f39288a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), bVar);
            this.f59464f = AdLoadState.LOADING;
            this.f59462d.load();
            d.a.j0.r.a.j.a.h(d.a.j0.r.a.j.a.f59503e);
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes cpc ad start load ");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // d.a.j0.r.a.h.b
    public String c() {
        return AdCard.CHARGE_STYLE_CPC;
    }

    @Override // d.a.j0.r.a.h.b
    public void destroy() {
        SplashAd splashAd = this.f59462d;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    public final void m() {
        WeakReference<ViewGroup> weakReference = this.f59463e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f59463e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f59463e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.j0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f59462d == null || (weakReference = this.f59463e) == null || weakReference.get() == null || this.f59464f != AdLoadState.SUCCEED) {
            return;
        }
        m();
        int i2 = this.f59461c;
        if (this.f59463e.get().getChildCount() > 0) {
            this.f59463e.get().removeAllViews();
        }
        if (d.a.j0.r.a.h.b.f59491a) {
            Log.d("IAdSdkSplash", "bes cpc ad show");
        }
        this.f59464f = AdLoadState.SHOWED;
        this.f59462d.show(this.f59463e.get());
    }
}
