package d.b.j0.r.a;

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
import d.b.c.e.p.l;
import d.b.i0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class d implements d.b.j0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f61319b;

    /* renamed from: c  reason: collision with root package name */
    public int f61320c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f61321d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f61322e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f61323f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.k.b f61324g;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.k.b {
        public a() {
        }

        @Override // d.b.i0.k.b
        public void a() {
            d.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.k.a f61326a;

        public b(d.b.i0.k.a aVar) {
            this.f61326a = aVar;
        }

        public final void a(String str, int i) {
            d.b.c.e.n.a a2 = j.a();
            a2.b("type", AdCard.CHARGE_STYLE_CPC);
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.b.j0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            d.b.j0.r.a.j.a.i(d.b.j0.r.a.j.a.f61361e, "0", i);
            d.this.f61323f = AdLoadState.SUCCEED;
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded success");
            }
            if (d.this.f61321d == null || d.this.f61322e == null) {
                return;
            }
            d.this.f61319b = rsplashType;
            d.this.f61320c = 0;
            d.b.j0.r.a.h.a.c().g(this.f61326a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes cpc ad onAdClick ");
            }
            d.b.i0.k.a aVar = this.f61326a;
            if (aVar != null) {
                aVar.b(d.this.f61319b == RsplashType.VIDEO, 1 == d.this.f61320c, 7);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            d.this.n();
            boolean z = d.this.f61323f == AdLoadState.DISMISSED;
            d.this.f61323f = AdLoadState.DISMISSED;
            d.b.i0.k.a aVar = this.f61326a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.b.j0.r.a.j.a.i(d.b.j0.r.a.j.a.f61361e, str, 0);
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded failed : " + str);
            }
            d.this.f61323f = AdLoadState.FAILED;
            d.b.j0.r.a.h.a.c().g(this.f61326a);
            d.b.j0.r.a.j.a.j(d.b.j0.r.a.j.a.f61361e, "1");
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes cpc ad present");
            }
            boolean z = 1 == d.this.f61320c;
            d.b.i0.k.a aVar = this.f61326a;
            if (aVar != null) {
                aVar.c(false, z, 7);
            }
            d.b.j0.r.a.j.a.j(d.b.j0.r.a.j.a.f61361e, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.b.i0.k.a aVar = this.f61326a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
            d.this.n();
        }
    }

    public d() {
        new AdSplashStyle();
        this.f61323f = AdLoadState.INIT;
        this.f61324g = new a();
    }

    @Override // d.b.j0.r.a.h.b
    public String a() {
        return AdCard.CHARGE_STYLE_CPC;
    }

    @Override // d.b.j0.r.a.h.b
    public AdLoadState b() {
        return this.f61323f;
    }

    @Override // d.b.j0.r.a.h.b
    public void c(d.b.i0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f50981c = this.f61324g;
        d.b.i0.k.a a2 = cVar.a();
        this.f61322e = new WeakReference<>(cVar.b());
        b bVar = new b(a2);
        try {
            Context context = cVar.b().getContext();
            cVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.b.b0.a.b.a.f42106a.get().h());
            this.f61321d = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.b.b0.a.b.a.f42106a.get().g()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), bVar);
            this.f61323f = AdLoadState.LOADING;
            this.f61321d.load();
            d.b.j0.r.a.j.a.h(d.b.j0.r.a.j.a.f61361e);
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes cpc ad start load ");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    public final void m() {
        WeakReference<ViewGroup> weakReference = this.f61322e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61322e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f61322e.get().setLayoutParams(layoutParams);
    }

    public void n() {
        SplashAd splashAd = this.f61321d;
        if (splashAd != null) {
            splashAd.destroy();
        }
        d.b.j0.r.a.h.a.c().a();
    }

    @Override // d.b.j0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f61321d == null || (weakReference = this.f61322e) == null || weakReference.get() == null || this.f61323f != AdLoadState.SUCCEED) {
            return;
        }
        m();
        int i = this.f61320c;
        if (this.f61322e.get().getChildCount() > 0) {
            this.f61322e.get().removeAllViews();
        }
        if (d.b.j0.r.a.h.b.f61349a) {
            Log.d("IAdSdkSplash", "bes cpc ad show");
        }
        this.f61323f = AdLoadState.SHOWED;
        this.f61321d.show(this.f61322e.get());
    }
}
