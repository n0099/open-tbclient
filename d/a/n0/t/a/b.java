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
public class b implements d.a.n0.t.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f64460b;

    /* renamed from: c  reason: collision with root package name */
    public int f64461c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f64462d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f64463e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f64464f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.k.b f64465g;

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.k.b {
        public a() {
        }

        @Override // d.a.m0.k.b
        public void a() {
            b.this.l();
        }
    }

    /* renamed from: d.a.n0.t.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1662b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.k.a f64467a;

        public C1662b(d.a.m0.k.a aVar) {
            this.f64467a = aVar;
        }

        public final void a(String str, int i2) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("type", "gd");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.n0.t.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            d.a.n0.t.a.j.a.j(d.a.n0.t.a.j.a.f64517b, "0", i2);
            b.this.f64464f = AdLoadState.SUCCEED;
            if (d.a.n0.t.a.h.b.f64508a) {
                Log.d("IAdSdkSplash", "bes gd loaded success");
            }
            b.this.f64460b = rsplashType;
            if (b.this.f64462d == null || b.this.f64463e == null) {
                return;
            }
            d.a.n0.t.a.h.a.c().g(this.f64467a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.a.n0.t.a.h.b.f64508a) {
                Log.d("IAdSdkSplash", "bes gd onAdClick");
            }
            d.a.m0.k.a aVar = this.f64467a;
            if (aVar != null) {
                aVar.b(b.this.f64460b == RsplashType.VIDEO, 1 == b.this.f64461c, 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            if (d.a.n0.t.a.h.b.f64508a) {
                Log.d("IAdSdkSplash", "bes gd onAdDismissed");
            }
            boolean z = b.this.f64464f == AdLoadState.DISMISSED;
            b.this.f64464f = AdLoadState.DISMISSED;
            d.a.m0.k.a aVar = this.f64467a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.a.n0.t.a.j.a.j(d.a.n0.t.a.j.a.f64517b, str, 0);
            d.a.n0.t.a.j.a.k(d.a.n0.t.a.j.a.f64517b, "1");
            if (d.a.n0.t.a.h.b.f64508a) {
                Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
            }
            b.this.f64464f = AdLoadState.FAILED;
            d.a.n0.t.a.h.a.c().g(this.f64467a);
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.a.n0.t.a.h.b.f64508a) {
                Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
            }
            boolean z = 1 == b.this.f64461c;
            d.a.m0.k.a aVar = this.f64467a;
            if (aVar != null) {
                aVar.c(b.this.f64460b == RsplashType.VIDEO, z, 1);
            }
            d.a.n0.t.a.j.a.k(d.a.n0.t.a.j.a.f64517b, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.m0.k.a aVar = this.f64467a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
        }
    }

    public b() {
        new AdSplashStyle();
        this.f64464f = AdLoadState.INIT;
        this.f64465g = new a();
    }

    @Override // d.a.n0.t.a.h.b
    public AdLoadState a() {
        return this.f64464f;
    }

    @Override // d.a.n0.t.a.h.b
    public void b(d.a.m0.k.d dVar) {
        if (dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f53109c = this.f64465g;
        d.a.m0.k.a a2 = dVar.a();
        this.f64463e = new WeakReference<>(dVar.b());
        C1662b c1662b = new C1662b(a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.d0.a.b.a.f43271a.get().e());
            this.f64462d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.d0.a.b.a.f43271a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1662b);
            this.f64464f = AdLoadState.LOADING;
            this.f64462d.load();
            d.a.n0.t.a.j.a.i(d.a.n0.t.a.j.a.f64517b);
            if (d.a.n0.t.a.h.b.f64508a) {
                Log.d("IAdSdkSplash", "bes gd start load");
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
        return "bes_gd";
    }

    @Override // d.a.n0.t.a.h.b
    public void destroy() {
        SplashAd splashAd = this.f64462d;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference = this.f64463e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f64463e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f64463e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.n0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f64462d == null || (weakReference = this.f64463e) == null || weakReference.get() == null || this.f64464f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f64463e.get().getChildCount() > 0) {
            this.f64463e.get().removeAllViews();
        }
        this.f64464f = AdLoadState.SHOWED;
        if (d.a.n0.t.a.h.b.f64508a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f64462d.show(this.f64463e.get());
    }
}
