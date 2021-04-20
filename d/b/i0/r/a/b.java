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
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.c.e.p.l;
import d.b.h0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b implements d.b.i0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f60881b;

    /* renamed from: c  reason: collision with root package name */
    public int f60882c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f60883d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f60884e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f60885f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.k.b f60886g;

    /* loaded from: classes4.dex */
    public class a implements d.b.h0.k.b {
        public a() {
        }

        @Override // d.b.h0.k.b
        public void a() {
            b.this.l();
        }
    }

    /* renamed from: d.b.i0.r.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1537b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.k.a f60888a;

        public C1537b(d.b.h0.k.a aVar) {
            this.f60888a = aVar;
        }

        public final void a(String str, int i) {
            d.b.c.e.n.a a2 = j.a();
            a2.b("type", "gd");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.b.i0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            d.b.i0.r.a.j.a.i(d.b.i0.r.a.j.a.f60937b, "0", i);
            b.this.f60885f = AdLoadState.SUCCEED;
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes gd loaded success");
            }
            b.this.f60881b = rsplashType;
            if (b.this.f60883d == null || b.this.f60884e == null) {
                return;
            }
            d.b.i0.r.a.h.a.c().g(this.f60888a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes gd onAdClick");
            }
            d.b.h0.k.a aVar = this.f60888a;
            if (aVar != null) {
                aVar.b(b.this.f60881b == RsplashType.VIDEO, 1 == b.this.f60882c, 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            b.this.m();
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes gd onAdDismissed");
            }
            boolean z = b.this.f60885f == AdLoadState.DISMISSED;
            b.this.f60885f = AdLoadState.DISMISSED;
            d.b.h0.k.a aVar = this.f60888a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.b.i0.r.a.j.a.i(d.b.i0.r.a.j.a.f60937b, str, 0);
            d.b.i0.r.a.j.a.j(d.b.i0.r.a.j.a.f60937b, "1");
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
            }
            b.this.f60885f = AdLoadState.FAILED;
            d.b.i0.r.a.h.a.c().g(this.f60888a);
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
            }
            boolean z = 1 == b.this.f60882c;
            d.b.h0.k.a aVar = this.f60888a;
            if (aVar != null) {
                aVar.c(b.this.f60881b == RsplashType.VIDEO, z, 1);
            }
            d.b.i0.r.a.j.a.j(d.b.i0.r.a.j.a.f60937b, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.b.h0.k.a aVar = this.f60888a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
            b.this.m();
        }
    }

    public b() {
        new AdSplashStyle();
        this.f60885f = AdLoadState.INIT;
        this.f60886g = new a();
    }

    @Override // d.b.i0.r.a.h.b
    public String a() {
        return "bes_gd";
    }

    @Override // d.b.i0.r.a.h.b
    public AdLoadState b() {
        return this.f60885f;
    }

    @Override // d.b.i0.r.a.h.b
    public void c(d.b.h0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f50645c = this.f60886g;
        d.b.h0.k.a a2 = cVar.a();
        this.f60884e = new WeakReference<>(cVar.b());
        C1537b c1537b = new C1537b(a2);
        try {
            Context context = cVar.b().getContext();
            cVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.b.a0.a.b.a.f41817a.get().h());
            this.f60883d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.b.a0.a.b.a.f41817a.get().g()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1537b);
            this.f60885f = AdLoadState.LOADING;
            this.f60883d.load();
            d.b.i0.r.a.j.a.h(d.b.i0.r.a.j.a.f60937b);
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "bes gd start load");
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onLowMemory();
            if (a2 != null) {
                a2.a("oom");
            }
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference = this.f60884e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60884e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f60884e.get().setLayoutParams(layoutParams);
    }

    public void m() {
        SplashAd splashAd = this.f60883d;
        if (splashAd != null) {
            splashAd.destroy();
        }
        d.b.i0.r.a.h.a.c().a();
    }

    @Override // d.b.i0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f60883d == null || (weakReference = this.f60884e) == null || weakReference.get() == null || this.f60885f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f60884e.get().getChildCount() > 0) {
            this.f60884e.get().removeAllViews();
        }
        this.f60885f = AdLoadState.SHOWED;
        if (d.b.i0.r.a.h.b.f60928a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f60883d.show(this.f60884e.get());
    }
}
