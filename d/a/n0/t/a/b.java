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
    public RsplashType f60769b;

    /* renamed from: c  reason: collision with root package name */
    public int f60770c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f60771d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f60772e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f60773f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.k.b f60774g;

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
    public class C1606b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.k.a f60776a;

        public C1606b(d.a.m0.k.a aVar) {
            this.f60776a = aVar;
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
            d.a.n0.t.a.j.a.j(d.a.n0.t.a.j.a.f60826b, "0", i2);
            b.this.f60773f = AdLoadState.SUCCEED;
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes gd loaded success");
            }
            b.this.f60769b = rsplashType;
            if (b.this.f60771d == null || b.this.f60772e == null) {
                return;
            }
            d.a.n0.t.a.h.a.c().g(this.f60776a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes gd onAdClick");
            }
            d.a.m0.k.a aVar = this.f60776a;
            if (aVar != null) {
                aVar.b(b.this.f60769b == RsplashType.VIDEO, 1 == b.this.f60770c, 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes gd onAdDismissed");
            }
            boolean z = b.this.f60773f == AdLoadState.DISMISSED;
            b.this.f60773f = AdLoadState.DISMISSED;
            d.a.m0.k.a aVar = this.f60776a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.a.n0.t.a.j.a.j(d.a.n0.t.a.j.a.f60826b, str, 0);
            d.a.n0.t.a.j.a.k(d.a.n0.t.a.j.a.f60826b, "1");
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
            }
            b.this.f60773f = AdLoadState.FAILED;
            d.a.n0.t.a.h.a.c().g(this.f60776a);
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
            }
            boolean z = 1 == b.this.f60770c;
            d.a.m0.k.a aVar = this.f60776a;
            if (aVar != null) {
                aVar.c(b.this.f60769b == RsplashType.VIDEO, z, 1);
            }
            d.a.n0.t.a.j.a.k(d.a.n0.t.a.j.a.f60826b, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.m0.k.a aVar = this.f60776a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
        }
    }

    public b() {
        new AdSplashStyle();
        this.f60773f = AdLoadState.INIT;
        this.f60774g = new a();
    }

    @Override // d.a.n0.t.a.h.b
    public AdLoadState a() {
        return this.f60773f;
    }

    @Override // d.a.n0.t.a.h.b
    public void b(d.a.m0.k.d dVar) {
        if (dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f49435c = this.f60774g;
        d.a.m0.k.a a2 = dVar.a();
        this.f60772e = new WeakReference<>(dVar.b());
        C1606b c1606b = new C1606b(a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.d0.a.b.a.f39590a.get().e());
            this.f60771d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.d0.a.b.a.f39590a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1606b);
            this.f60773f = AdLoadState.LOADING;
            this.f60771d.load();
            d.a.n0.t.a.j.a.i(d.a.n0.t.a.j.a.f60826b);
            if (d.a.n0.t.a.h.b.f60817a) {
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
        SplashAd splashAd = this.f60771d;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference = this.f60772e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60772e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f60772e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.n0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f60771d == null || (weakReference = this.f60772e) == null || weakReference.get() == null || this.f60773f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f60772e.get().getChildCount() > 0) {
            this.f60772e.get().removeAllViews();
        }
        this.f60773f = AdLoadState.SHOWED;
        if (d.a.n0.t.a.h.b.f60817a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f60771d.show(this.f60772e.get());
    }
}
