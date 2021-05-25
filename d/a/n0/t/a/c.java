package d.a.n0.t.a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import d.a.c.e.p.l;
import d.a.n0.s0.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class c implements d.a.n0.t.a.h.b {

    /* renamed from: g  reason: collision with root package name */
    public static String f60778g = "6021002119-1732188456";

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f60779b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60780c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadState f60781d = AdLoadState.INIT;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.k.a f60782e = null;

    /* renamed from: f  reason: collision with root package name */
    public final a.f f60783f = new a();

    /* loaded from: classes4.dex */
    public class a extends a.g {
        public a() {
        }

        @Override // d.a.n0.s0.a.f
        public void onAdClicked(String str) {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdClicked : " + str);
            }
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
            if (c.this.f60782e != null) {
                c.this.f60782e.b(false, false, 6);
            }
        }

        @Override // d.a.n0.s0.a.f
        public void onAdClose(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
            FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
            if (c.this.f60782e != null) {
                c.this.f60782e.onAdDismiss();
            }
        }

        @Override // d.a.n0.s0.a.f
        public void onAdError(String str) {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdError : " + str);
            }
            d.a.n0.t.a.j.a.k(d.a.n0.t.a.j.a.f60828d, "1");
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
            if (c.this.f60782e != null) {
                c.this.f60782e.onAdDismiss();
            }
        }

        @Override // d.a.n0.s0.a.f
        public void onAdShow(String str) {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdshow");
            }
            c.this.f60782e.c(false, false, 6);
            d.a.n0.t.a.j.a.k(d.a.n0.t.a.j.a.f60828d, "0");
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.n0.s0.a.e
        public void a(String str, int i2) {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdLoaded successed: " + str);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
            d.a.n0.t.a.j.a.j(d.a.n0.t.a.j.a.f60828d, "0", i2);
            if (d.a.n0.s0.a.h().k(str)) {
                c.this.f60781d = AdLoadState.SUCCEED;
            } else {
                c.this.f60781d = AdLoadState.FAILED;
                ((ViewGroup) c.this.f60779b.get()).removeView(c.this.f60780c);
            }
            d.a.n0.t.a.h.a.c().g(c.this.f60782e);
        }

        @Override // d.a.n0.s0.a.e
        public void onError(String str) {
            if (d.a.n0.t.a.h.b.f60817a) {
                Log.d("IAdSdkSplash", "BEAR ad onLoadError: " + str);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
            d.a.n0.t.a.j.a.j(d.a.n0.t.a.j.a.f60828d, str, 0);
            c.this.f60781d = AdLoadState.FAILED;
            ((ViewGroup) c.this.f60779b.get()).removeView(c.this.f60780c);
            d.a.n0.t.a.h.a.c().g(c.this.f60782e);
        }
    }

    public c() {
        f60778g = d.a.m0.r.d0.b.j().k("splash_bear_sid_type_key", 0) == 1 ? "6021002118-283136489" : "6021002119-1732188456";
    }

    public static void i(int i2) {
        f60778g = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        d.a.m0.r.d0.b.j().v("splash_bear_sid_type_key", i2);
    }

    @Override // d.a.n0.t.a.h.b
    public AdLoadState a() {
        return this.f60781d;
    }

    @Override // d.a.n0.t.a.h.b
    public void b(d.a.m0.k.d dVar) {
        Context context = dVar.b().getContext();
        if (!(context instanceof Activity) || dVar.b() == null) {
            return;
        }
        this.f60779b = new WeakReference<>(dVar.b());
        Activity activity = (Activity) context;
        ViewGroup g2 = d.a.n0.s0.a.h().g(activity, f60778g);
        this.f60780c = g2;
        if (g2 == null) {
            return;
        }
        this.f60782e = dVar.a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f60779b.get().getContext()) * 0.8125d));
        layoutParams.addRule(14, -1);
        this.f60779b.get().addView(this.f60780c, layoutParams);
        if (d.a.n0.t.a.h.b.f60817a) {
            Log.d("IAdSdkSplash", "BEAR ad start load");
        }
        d.a.n0.s0.a h2 = d.a.n0.s0.a.h();
        String str = f60778g;
        b bVar = new b();
        h2.l(activity, str, bVar, d.a.n0.s0.a.a("spalsh", d.a.n0.t.a.h.a.c().b() + ""));
        this.f60781d = AdLoadState.LOADING;
        d.a.n0.t.a.j.a.i(d.a.n0.t.a.j.a.f60828d);
        FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
    }

    @Override // d.a.n0.t.a.h.b
    public String c() {
        return "bear";
    }

    @Override // d.a.n0.t.a.h.b
    public void destroy() {
        d.a.n0.s0.a.h().c(f60778g);
    }

    public final void h() {
        WeakReference<ViewGroup> weakReference = this.f60779b;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60779b.get().getLayoutParams();
        layoutParams.width = l.k(this.f60779b.get().getContext());
        layoutParams.height = (int) (l.i(this.f60779b.get().getContext()) * 0.8125d);
        this.f60779b.get().setLayoutParams(layoutParams);
    }

    public boolean j() {
        if (this.f60780c != null && this.f60779b.get() != null) {
            Context context = this.f60779b.get().getContext();
            if (context instanceof Activity) {
                d.a.m0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                d.a.n0.s0.a h2 = d.a.n0.s0.a.h();
                Activity activity = (Activity) context;
                String str = f60778g;
                ViewGroup viewGroup = this.f60780c;
                a.f fVar = this.f60783f;
                h2.n(activity, str, viewGroup, fVar, d.a.n0.s0.a.a("spalsh", d.a.n0.t.a.h.a.c().b() + ""));
                SkinManager.setBackgroundColor(this.f60780c, R.color.CAM_X0101, 0);
                return true;
            }
        }
        return false;
    }

    @Override // d.a.n0.t.a.h.b
    public void show() {
        if (this.f60779b != null && this.f60781d == AdLoadState.SUCCEED) {
            h();
            this.f60781d = AdLoadState.SHOWED;
            j();
        }
    }
}
