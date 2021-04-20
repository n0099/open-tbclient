package d.b.i0.r.a;

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
import d.b.h0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class d implements d.b.i0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f60898b;

    /* renamed from: c  reason: collision with root package name */
    public int f60899c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f60900d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f60901e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f60902f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.k.b f60903g;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.k.b {
        public a() {
        }

        @Override // d.b.h0.k.b
        public void a() {
            d.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.k.a f60905a;

        public b(d.b.h0.k.a aVar) {
            this.f60905a = aVar;
        }

        public final void a(String str, int i) {
            d.b.c.e.n.a a2 = j.a();
            a2.b("type", AdCard.CHARGE_STYLE_CPC);
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.b.i0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            d.b.i0.r.a.j.a.i(d.b.i0.r.a.j.a.f60940e, "0", i);
            d.this.f60902f = AdLoadState.SUCCEED;
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded success");
            }
            if (d.this.f60900d == null || d.this.f60901e == null) {
                return;
            }
            d.this.f60898b = rsplashType;
            d.this.f60899c = 0;
            d.b.i0.r.a.h.a.c().g(this.f60905a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes cpc ad onAdClick ");
            }
            d.b.h0.k.a aVar = this.f60905a;
            if (aVar != null) {
                aVar.b(d.this.f60898b == RsplashType.VIDEO, 1 == d.this.f60899c, 7);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            d.this.n();
            boolean z = d.this.f60902f == AdLoadState.DISMISSED;
            d.this.f60902f = AdLoadState.DISMISSED;
            d.b.h0.k.a aVar = this.f60905a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.b.i0.r.a.j.a.i(d.b.i0.r.a.j.a.f60940e, str, 0);
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded failed : " + str);
            }
            d.this.f60902f = AdLoadState.FAILED;
            d.b.i0.r.a.h.a.c().g(this.f60905a);
            d.b.i0.r.a.j.a.j(d.b.i0.r.a.j.a.f60940e, "1");
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes cpc ad present");
            }
            boolean z = 1 == d.this.f60899c;
            d.b.h0.k.a aVar = this.f60905a;
            if (aVar != null) {
                aVar.c(false, z, 7);
            }
            d.b.i0.r.a.j.a.j(d.b.i0.r.a.j.a.f60940e, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.b.h0.k.a aVar = this.f60905a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
            d.this.n();
        }
    }

    public d() {
        new AdSplashStyle();
        this.f60902f = AdLoadState.INIT;
        this.f60903g = new a();
    }

    @Override // d.b.i0.r.a.h.b
    public String a() {
        return AdCard.CHARGE_STYLE_CPC;
    }

    @Override // d.b.i0.r.a.h.b
    public AdLoadState b() {
        return this.f60902f;
    }

    @Override // d.b.i0.r.a.h.b
    public void c(d.b.h0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f50645c = this.f60903g;
        d.b.h0.k.a a2 = cVar.a();
        this.f60901e = new WeakReference<>(cVar.b());
        b bVar = new b(a2);
        try {
            Context context = cVar.b().getContext();
            cVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.b.a0.a.b.a.f41817a.get().h());
            this.f60900d = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.b.a0.a.b.a.f41817a.get().g()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), bVar);
            this.f60902f = AdLoadState.LOADING;
            this.f60900d.load();
            d.b.i0.r.a.j.a.h(d.b.i0.r.a.j.a.f60940e);
            if (d.b.i0.r.a.h.b.f60928a) {
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
        WeakReference<ViewGroup> weakReference = this.f60901e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60901e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f60901e.get().setLayoutParams(layoutParams);
    }

    public void n() {
        SplashAd splashAd = this.f60900d;
        if (splashAd != null) {
            splashAd.destroy();
        }
        d.b.i0.r.a.h.a.c().a();
    }

    @Override // d.b.i0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f60900d == null || (weakReference = this.f60901e) == null || weakReference.get() == null || this.f60902f != AdLoadState.SUCCEED) {
            return;
        }
        m();
        int i = this.f60899c;
        if (this.f60901e.get().getChildCount() > 0) {
            this.f60901e.get().removeAllViews();
        }
        if (d.b.i0.r.a.h.b.f60928a) {
            Log.d("IAdSdkSplash", "bes cpc ad show");
        }
        this.f60902f = AdLoadState.SHOWED;
        this.f60900d.show(this.f60901e.get());
    }
}
