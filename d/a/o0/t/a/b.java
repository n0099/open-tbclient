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
public class b implements d.a.o0.t.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f64585b;

    /* renamed from: c  reason: collision with root package name */
    public int f64586c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f64587d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f64588e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f64589f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.k.b f64590g;

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.k.b {
        public a() {
        }

        @Override // d.a.n0.k.b
        public void a() {
            b.this.l();
        }
    }

    /* renamed from: d.a.o0.t.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1666b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.k.a f64592a;

        public C1666b(d.a.n0.k.a aVar) {
            this.f64592a = aVar;
        }

        public final void a(String str, int i2) {
            d.a.c.e.n.a a2 = j.a();
            a2.b("type", "gd");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.a.o0.t.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i2));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i2) {
            d.a.o0.t.a.j.a.j(d.a.o0.t.a.j.a.f64642b, "0", i2);
            b.this.f64589f = AdLoadState.SUCCEED;
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes gd loaded success");
            }
            b.this.f64585b = rsplashType;
            if (b.this.f64587d == null || b.this.f64588e == null) {
                return;
            }
            d.a.o0.t.a.h.a.c().g(this.f64592a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes gd onAdClick");
            }
            d.a.n0.k.a aVar = this.f64592a;
            if (aVar != null) {
                aVar.b(b.this.f64585b == RsplashType.VIDEO, 1 == b.this.f64586c, 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes gd onAdDismissed");
            }
            boolean z = b.this.f64589f == AdLoadState.DISMISSED;
            b.this.f64589f = AdLoadState.DISMISSED;
            d.a.n0.k.a aVar = this.f64592a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.a.o0.t.a.j.a.j(d.a.o0.t.a.j.a.f64642b, str, 0);
            d.a.o0.t.a.j.a.k(d.a.o0.t.a.j.a.f64642b, "1");
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
            }
            b.this.f64589f = AdLoadState.FAILED;
            d.a.o0.t.a.h.a.c().g(this.f64592a);
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
            }
            boolean z = 1 == b.this.f64586c;
            d.a.n0.k.a aVar = this.f64592a;
            if (aVar != null) {
                aVar.c(b.this.f64585b == RsplashType.VIDEO, z, 1);
            }
            d.a.o0.t.a.j.a.k(d.a.o0.t.a.j.a.f64642b, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.a.n0.k.a aVar = this.f64592a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
        }
    }

    public b() {
        new AdSplashStyle();
        this.f64589f = AdLoadState.INIT;
        this.f64590g = new a();
    }

    @Override // d.a.o0.t.a.h.b
    public AdLoadState a() {
        return this.f64589f;
    }

    @Override // d.a.o0.t.a.h.b
    public void b(d.a.n0.k.d dVar) {
        if (dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        dVar.f53216c = this.f64590g;
        d.a.n0.k.a a2 = dVar.a();
        this.f64588e = new WeakReference<>(dVar.b());
        C1666b c1666b = new C1666b(a2);
        try {
            Context context = TbadkCoreApplication.getInst().getContext();
            dVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.a.d0.a.b.a.f43374a.get().e());
            this.f64587d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.a.d0.a.b.a.f43374a.get().d()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1666b);
            this.f64589f = AdLoadState.LOADING;
            this.f64587d.load();
            d.a.o0.t.a.j.a.i(d.a.o0.t.a.j.a.f64642b);
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "bes gd start load");
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
        return "bes_gd";
    }

    @Override // d.a.o0.t.a.h.b
    public void destroy() {
        SplashAd splashAd = this.f64587d;
        if (splashAd != null) {
            splashAd.destroy();
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference = this.f64588e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f64588e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f64588e.get().setLayoutParams(layoutParams);
    }

    @Override // d.a.o0.t.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f64587d == null || (weakReference = this.f64588e) == null || weakReference.get() == null || this.f64589f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f64588e.get().getChildCount() > 0) {
            this.f64588e.get().removeAllViews();
        }
        this.f64589f = AdLoadState.SHOWED;
        if (d.a.o0.t.a.h.b.f64633a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f64587d.show(this.f64588e.get());
    }
}
