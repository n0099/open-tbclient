package d.a.n0.t.a;

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
import d.a.m0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class d implements d.a.n0.t.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f60786b;

    /* renamed from: c  reason: collision with root package name */
    public int f60787c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f60788d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f60789e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f60790f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.k.b f60791g;

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.k.b {
        public a() {
        }

        @Override // d.a.m0.k.b
        public void a() {
            d.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.k.a f60793a;

        public b(d.a.m0.k.a aVar) {
            this.f60793a = aVar;
        }

        public final void a(String str, int i2) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("type", "cpc");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.n0.t.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            d.a.n0.t.a.j.a.j(d.a.n0.t.a.j.a.f60829e, "0", i2);
            d.this.f60790f = AdLoadState.SUCCEED;
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded success");
            }
            if (d.this.f60788d == null || d.this.f60789e == null) {
                return;
            }
            d.this.f60786b = rsplashType;
            d.this.f60787c = 0;
            d.a.n0.t.a.h.a.c().g(this.f60793a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes cpc ad onAdClick ");
            }
            d.a.m0.k.a aVar = this.f60793a;
            if (aVar != null) {
                aVar.b(d.this.f60786b == RsplashType.VIDEO, 1 == d.this.f60787c, 7);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            boolean z = d.this.f60790f == AdLoadState.DISMISSED;
            d.this.f60790f = AdLoadState.DISMISSED;
            d.a.m0.k.a aVar = this.f60793a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.a.n0.t.a.j.a.j(d.a.n0.t.a.j.a.f60829e, str, 0);
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes cpc ad loaded failed : " + str);
            }
            d.this.f60790f = AdLoadState.FAILED;
            d.a.n0.t.a.h.a.c().g(this.f60793a);
            d.a.n0.t.a.j.a.k(d.a.n0.t.a.j.a.f60829e, "1");
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes cpc ad present");
            }
            boolean z = 1 == d.this.f60787c;
            d.a.m0.k.a aVar = this.f60793a;
            if (aVar != null) {
                aVar.c(false, z, 7);
            }
            d.a.n0.t.a.j.a.k(d.a.n0.t.a.j.a.f60829e, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.m0.k.a aVar = this.f60793a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
        }
    }

    public d() {
        new AdSplashStyle();
        this.f60790f = AdLoadState.INIT;
        this.f60791g = new a();
    }

    @Override // d.a.n0.t.a.h.b
    public AdLoadState a() {
        return this.f60790f;
    }

    @Override // d.a.n0.t.a.h.b
    public void b(d.a.m0.k.d dVar) {
        if (dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f49435c = this.f60791g;
        d.a.m0.k.a a2 = dVar.a();
        this.f60789e = new WeakReference<>(dVar.b());
        b bVar = new b(a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.d0.a.b.a.f39590a.get().e());
            this.f60788d = new SplashAd(context, "7352842", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.d0.a.b.a.f39590a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), bVar);
            this.f60790f = AdLoadState.LOADING;
            this.f60788d.load();
            d.a.n0.t.a.j.a.i(d.a.n0.t.a.j.a.f60829e);
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes cpc ad start load ");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // d.a.n0.t.a.h.b
    public String c() {
        return "cpc";
    }

    @Override // d.a.n0.t.a.h.b
    public void destroy() {
        SplashAd splashAd = this.f60788d;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    public final void m() {
        WeakReference<ViewGroup> weakReference = this.f60789e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60789e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f60789e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.n0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f60788d == null || (weakReference = this.f60789e) == null || weakReference.get() == null || this.f60790f != AdLoadState.SUCCEED) {
            return;
        }
        m();
        int i2 = this.f60787c;
        if (this.f60789e.get().getChildCount() > 0) {
            this.f60789e.get().removeAllViews();
        }
        if (d.a.n0.t.a.h.b.f60817a) {
            Log.d("IAdSdkSplash", "bes cpc ad show");
        }
        this.f60790f = AdLoadState.SHOWED;
        this.f60788d.show(this.f60789e.get());
    }
}
