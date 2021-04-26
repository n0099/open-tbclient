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
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.a.c.e.p.l;
import d.a.i0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b implements d.a.j0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f59443b;

    /* renamed from: c  reason: collision with root package name */
    public int f59444c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f59445d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f59446e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f59447f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.k.b f59448g;

    /* loaded from: classes4.dex */
    public class a implements d.a.i0.k.b {
        public a() {
        }

        @Override // d.a.i0.k.b
        public void a() {
            b.this.l();
        }
    }

    /* renamed from: d.a.j0.r.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1499b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.k.a f59450a;

        public C1499b(d.a.i0.k.a aVar) {
            this.f59450a = aVar;
        }

        public final void a(String str, int i2) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("type", "gd");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.j0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            d.a.j0.r.a.j.a.i(d.a.j0.r.a.j.a.f59500b, "0", i2);
            b.this.f59447f = AdLoadState.SUCCEED;
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes gd loaded success");
            }
            b.this.f59443b = rsplashType;
            if (b.this.f59445d == null || b.this.f59446e == null) {
                return;
            }
            d.a.j0.r.a.h.a.c().g(this.f59450a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes gd onAdClick");
            }
            d.a.i0.k.a aVar = this.f59450a;
            if (aVar != null) {
                aVar.b(b.this.f59443b == RsplashType.VIDEO, 1 == b.this.f59444c, 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes gd onAdDismissed");
            }
            boolean z = b.this.f59447f == AdLoadState.DISMISSED;
            b.this.f59447f = AdLoadState.DISMISSED;
            d.a.i0.k.a aVar = this.f59450a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.a.j0.r.a.j.a.i(d.a.j0.r.a.j.a.f59500b, str, 0);
            d.a.j0.r.a.j.a.j(d.a.j0.r.a.j.a.f59500b, "1");
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
            }
            b.this.f59447f = AdLoadState.FAILED;
            d.a.j0.r.a.h.a.c().g(this.f59450a);
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
            }
            boolean z = 1 == b.this.f59444c;
            d.a.i0.k.a aVar = this.f59450a;
            if (aVar != null) {
                aVar.c(b.this.f59443b == RsplashType.VIDEO, z, 1);
            }
            d.a.j0.r.a.j.a.j(d.a.j0.r.a.j.a.f59500b, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.i0.k.a aVar = this.f59450a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
        }
    }

    public b() {
        new AdSplashStyle();
        this.f59447f = AdLoadState.INIT;
        this.f59448g = new a();
    }

    @Override // d.a.j0.r.a.h.b
    public AdLoadState a() {
        return this.f59447f;
    }

    @Override // d.a.j0.r.a.h.b
    public void b(d.a.i0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f48563c = this.f59448g;
        d.a.i0.k.a a2 = cVar.a();
        this.f59446e = new WeakReference<>(cVar.b());
        C1499b c1499b = new C1499b(a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            cVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.b0.a.b.a.f39288a.get().e());
            this.f59445d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.b0.a.b.a.f39288a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1499b);
            this.f59447f = AdLoadState.LOADING;
            this.f59445d.load();
            d.a.j0.r.a.j.a.h(d.a.j0.r.a.j.a.f59500b);
            if (d.a.j0.r.a.h.b.f59491a) {
                Log.d("IAdSdkSplash", "bes gd start load");
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
        return "bes_gd";
    }

    @Override // d.a.j0.r.a.h.b
    public void destroy() {
        SplashAd splashAd = this.f59445d;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference = this.f59446e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f59446e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f59446e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.j0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f59445d == null || (weakReference = this.f59446e) == null || weakReference.get() == null || this.f59447f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f59446e.get().getChildCount() > 0) {
            this.f59446e.get().removeAllViews();
        }
        this.f59447f = AdLoadState.SHOWED;
        if (d.a.j0.r.a.h.b.f59491a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f59445d.show(this.f59446e.get());
    }
}
