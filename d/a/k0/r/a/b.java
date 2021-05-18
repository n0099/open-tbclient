package d.a.k0.r.a;

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
import d.a.j0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b implements d.a.k0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f60188b;

    /* renamed from: c  reason: collision with root package name */
    public int f60189c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f60190d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f60191e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f60192f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.k.b f60193g;

    /* loaded from: classes4.dex */
    public class a implements d.a.j0.k.b {
        public a() {
        }

        @Override // d.a.j0.k.b
        public void a() {
            b.this.l();
        }
    }

    /* renamed from: d.a.k0.r.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1573b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.k.a f60195a;

        public C1573b(d.a.j0.k.a aVar) {
            this.f60195a = aVar;
        }

        public final void a(String str, int i2) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("type", "gd");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.k0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            d.a.k0.r.a.j.a.i(d.a.k0.r.a.j.a.f60245b, "0", i2);
            b.this.f60192f = AdLoadState.SUCCEED;
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "bes gd loaded success");
            }
            b.this.f60188b = rsplashType;
            if (b.this.f60190d == null || b.this.f60191e == null) {
                return;
            }
            d.a.k0.r.a.h.a.c().g(this.f60195a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "bes gd onAdClick");
            }
            d.a.j0.k.a aVar = this.f60195a;
            if (aVar != null) {
                aVar.b(b.this.f60188b == RsplashType.VIDEO, 1 == b.this.f60189c, 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "bes gd onAdDismissed");
            }
            boolean z = b.this.f60192f == AdLoadState.DISMISSED;
            b.this.f60192f = AdLoadState.DISMISSED;
            d.a.j0.k.a aVar = this.f60195a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.a.k0.r.a.j.a.i(d.a.k0.r.a.j.a.f60245b, str, 0);
            d.a.k0.r.a.j.a.j(d.a.k0.r.a.j.a.f60245b, "1");
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
            }
            b.this.f60192f = AdLoadState.FAILED;
            d.a.k0.r.a.h.a.c().g(this.f60195a);
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
            }
            boolean z = 1 == b.this.f60189c;
            d.a.j0.k.a aVar = this.f60195a;
            if (aVar != null) {
                aVar.c(b.this.f60188b == RsplashType.VIDEO, z, 1);
            }
            d.a.k0.r.a.j.a.j(d.a.k0.r.a.j.a.f60245b, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.j0.k.a aVar = this.f60195a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
        }
    }

    public b() {
        new AdSplashStyle();
        this.f60192f = AdLoadState.INIT;
        this.f60193g = new a();
    }

    @Override // d.a.k0.r.a.h.b
    public AdLoadState a() {
        return this.f60192f;
    }

    @Override // d.a.k0.r.a.h.b
    public void b(d.a.j0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f49391c = this.f60193g;
        d.a.j0.k.a a2 = cVar.a();
        this.f60191e = new WeakReference<>(cVar.b());
        C1573b c1573b = new C1573b(a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            cVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.b0.a.b.a.f38533a.get().e());
            this.f60190d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.b0.a.b.a.f38533a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1573b);
            this.f60192f = AdLoadState.LOADING;
            this.f60190d.load();
            d.a.k0.r.a.j.a.h(d.a.k0.r.a.j.a.f60245b);
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "bes gd start load");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    @Override // d.a.k0.r.a.h.b
    public String c() {
        return "bes_gd";
    }

    @Override // d.a.k0.r.a.h.b
    public void destroy() {
        SplashAd splashAd = this.f60190d;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference = this.f60191e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60191e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f60191e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.k0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f60190d == null || (weakReference = this.f60191e) == null || weakReference.get() == null || this.f60192f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f60191e.get().getChildCount() > 0) {
            this.f60191e.get().removeAllViews();
        }
        this.f60192f = AdLoadState.SHOWED;
        if (d.a.k0.r.a.h.b.f60236a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f60190d.show(this.f60191e.get());
    }
}
