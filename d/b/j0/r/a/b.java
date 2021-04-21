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
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import d.b.c.e.p.l;
import d.b.i0.m0.j;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b implements d.b.j0.r.a.h.b {

    /* renamed from: b  reason: collision with root package name */
    public RsplashType f61302b;

    /* renamed from: c  reason: collision with root package name */
    public int f61303c = 1;

    /* renamed from: d  reason: collision with root package name */
    public SplashAd f61304d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f61305e;

    /* renamed from: f  reason: collision with root package name */
    public volatile AdLoadState f61306f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.k.b f61307g;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.k.b {
        public a() {
        }

        @Override // d.b.i0.k.b
        public void a() {
            b.this.l();
        }
    }

    /* renamed from: d.b.j0.r.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1560b implements SplashLpCloseListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.k.a f61309a;

        public C1560b(d.b.i0.k.a aVar) {
            this.f61309a = aVar;
        }

        public final void a(String str, int i) {
            d.b.c.e.n.a a2 = j.a();
            a2.b("type", "gd");
            a2.b("locate", "splash");
            a2.c(SetImageWatermarkTypeReqMsg.SWITCH, Integer.valueOf(d.b.j0.r.a.h.a.c().b()));
            a2.c("isSuccess", Integer.valueOf(i));
            BdStatisticsManager.getInstance().debug(str, a2);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            d.b.j0.r.a.j.a.i(d.b.j0.r.a.j.a.f61358b, "0", i);
            b.this.f61306f = AdLoadState.SUCCEED;
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes gd loaded success");
            }
            b.this.f61302b = rsplashType;
            if (b.this.f61304d == null || b.this.f61305e == null) {
                return;
            }
            d.b.j0.r.a.h.a.c().g(this.f61309a);
            a("advert_load", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdClick() {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes gd onAdClick");
            }
            d.b.i0.k.a aVar = this.f61309a;
            if (aVar != null) {
                aVar.b(b.this.f61302b == RsplashType.VIDEO, 1 == b.this.f61303c, 1);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdDismissed() {
            b.this.m();
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes gd onAdDismissed");
            }
            boolean z = b.this.f61306f == AdLoadState.DISMISSED;
            b.this.f61306f = AdLoadState.DISMISSED;
            d.b.i0.k.a aVar = this.f61309a;
            if (aVar == null || z) {
                return;
            }
            aVar.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            d.b.j0.r.a.j.a.i(d.b.j0.r.a.j.a.f61358b, str, 0);
            d.b.j0.r.a.j.a.j(d.b.j0.r.a.j.a.f61358b, "1");
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes gd loaded loaded failed :" + str);
            }
            b.this.f61306f = AdLoadState.FAILED;
            d.b.j0.r.a.h.a.c().g(this.f61309a);
            a("advert_show", 0);
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdPresent() {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "bes gd present, and time is " + System.currentTimeMillis());
            }
            boolean z = 1 == b.this.f61303c;
            d.b.i0.k.a aVar = this.f61309a;
            if (aVar != null) {
                aVar.c(b.this.f61302b == RsplashType.VIDEO, z, 1);
            }
            d.b.j0.r.a.j.a.j(d.b.j0.r.a.j.a.f61358b, "0");
            a("advert_show", 1);
        }

        @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
        public void onLpClosed() {
            d.b.i0.k.a aVar = this.f61309a;
            if (aVar != null) {
                aVar.onLpClosed();
            }
            b.this.m();
        }
    }

    public b() {
        new AdSplashStyle();
        this.f61306f = AdLoadState.INIT;
        this.f61307g = new a();
    }

    @Override // d.b.j0.r.a.h.b
    public String a() {
        return "bes_gd";
    }

    @Override // d.b.j0.r.a.h.b
    public AdLoadState b() {
        return this.f61306f;
    }

    @Override // d.b.j0.r.a.h.b
    public void c(d.b.i0.k.c cVar) {
        if (cVar == null || cVar.b() == null || cVar.b().getContext() == null) {
            return;
        }
        cVar.f50981c = this.f61307g;
        d.b.i0.k.a a2 = cVar.a();
        this.f61305e = new WeakReference<>(cVar.b());
        C1560b c1560b = new C1560b(a2);
        try {
            Context context = cVar.b().getContext();
            cVar.b();
            RequestParameters.Builder addExtra = new RequestParameters.Builder().setHeight(l.k(context)).setWidth(l.i(context)).addExtra(SplashAd.KEY_LIMIT_REGION_CLICK, "true").addExtra(SplashAd.KEY_FETCHAD, "false");
            RequestParameters.Builder addExtra2 = addExtra.addExtra(SplashAd.KEY_BOTTOM_LOGO_ID, "" + d.b.b0.a.b.a.f42106a.get().h());
            this.f61304d = new SplashAd(context, "4776976", addExtra2.addExtra(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "" + d.b.b0.a.b.a.f42106a.get().g()).addExtra(SplashAd.KEY_SKIP_TYPE, "1").addExtra(SplashAd.KEY_LABEL_TYPE, "1").build(), c1560b);
            this.f61306f = AdLoadState.LOADING;
            this.f61304d.load();
            d.b.j0.r.a.j.a.h(d.b.j0.r.a.j.a.f61358b);
            if (d.b.j0.r.a.h.b.f61349a) {
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
        WeakReference<ViewGroup> weakReference = this.f61305e;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61305e.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f61305e.get().setLayoutParams(layoutParams);
    }

    public void m() {
        SplashAd splashAd = this.f61304d;
        if (splashAd != null) {
            splashAd.destroy();
        }
        d.b.j0.r.a.h.a.c().a();
    }

    @Override // d.b.j0.r.a.h.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        if (this.f61304d == null || (weakReference = this.f61305e) == null || weakReference.get() == null || this.f61306f != AdLoadState.SUCCEED) {
            return;
        }
        l();
        if (this.f61305e.get().getChildCount() > 0) {
            this.f61305e.get().removeAllViews();
        }
        this.f61306f = AdLoadState.SHOWED;
        if (d.b.j0.r.a.h.b.f61349a) {
            Log.d("IAdSdkSplash", "bes gd show, and time is " + System.currentTimeMillis());
        }
        this.f61304d.show(this.f61305e.get());
    }
}
