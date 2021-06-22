package d.a.o0.t.a;

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
import d.a.o0.s0.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class c implements d.a.o0.t.a.h.b {

    /* renamed from: g  reason: collision with root package name */
    public static String f64594g = "6021002119-1732188456";

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f64595b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f64596c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadState f64597d = AdLoadState.INIT;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.k.a f64598e = null;

    /* renamed from: f  reason: collision with root package name */
    public final a.g f64599f = new a();

    /* loaded from: classes4.dex */
    public class a extends a.h {
        public a() {
        }

        @Override // d.a.o0.s0.a.g
        public void onAdClicked(String str) {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdClicked : " + str);
            }
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
            if (c.this.f64598e != null) {
                c.this.f64598e.b(false, false, 6);
            }
        }

        @Override // d.a.o0.s0.a.g
        public void onAdClose(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
            FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
            if (c.this.f64598e != null) {
                c.this.f64598e.onAdDismiss();
            }
        }

        @Override // d.a.o0.s0.a.g
        public void onAdError(String str) {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdError : " + str);
            }
            d.a.o0.t.a.j.a.k(d.a.o0.t.a.j.a.f64644d, "1");
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
            if (c.this.f64598e != null) {
                c.this.f64598e.onAdDismiss();
            }
        }

        @Override // d.a.o0.s0.a.g
        public void onAdShow(String str) {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdshow");
            }
            c.this.f64598e.c(false, false, 6);
            d.a.o0.t.a.j.a.k(d.a.o0.t.a.j.a.f64644d, "0");
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.f {
        public b() {
        }

        @Override // d.a.o0.s0.a.f
        public void a(String str, int i2) {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdLoaded successed: " + str);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
            d.a.o0.t.a.j.a.j(d.a.o0.t.a.j.a.f64644d, "0", i2);
            if (d.a.o0.s0.a.h().k(str)) {
                c.this.f64597d = AdLoadState.SUCCEED;
            } else {
                c.this.f64597d = AdLoadState.FAILED;
                ((ViewGroup) c.this.f64595b.get()).removeView(c.this.f64596c);
            }
            d.a.o0.t.a.h.a.c().g(c.this.f64598e);
        }

        @Override // d.a.o0.s0.a.f
        public void onError(String str) {
            if (d.a.o0.t.a.h.b.f64633a) {
                Log.d("IAdSdkSplash", "BEAR ad onLoadError: " + str);
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
            d.a.o0.t.a.j.a.j(d.a.o0.t.a.j.a.f64644d, str, 0);
            c.this.f64597d = AdLoadState.FAILED;
            ((ViewGroup) c.this.f64595b.get()).removeView(c.this.f64596c);
            d.a.o0.t.a.h.a.c().g(c.this.f64598e);
        }
    }

    public c() {
        f64594g = d.a.n0.r.d0.b.j().k("splash_bear_sid_type_key", 0) == 1 ? "6021002118-283136489" : "6021002119-1732188456";
    }

    public static void i(int i2) {
        f64594g = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        d.a.n0.r.d0.b.j().v("splash_bear_sid_type_key", i2);
    }

    @Override // d.a.o0.t.a.h.b
    public AdLoadState a() {
        return this.f64597d;
    }

    @Override // d.a.o0.t.a.h.b
    public void b(d.a.n0.k.d dVar) {
        Context context = dVar.b().getContext();
        if (!(context instanceof Activity) || dVar.b() == null) {
            return;
        }
        this.f64595b = new WeakReference<>(dVar.b());
        Activity activity = (Activity) context;
        ViewGroup g2 = d.a.o0.s0.a.h().g(activity, f64594g);
        this.f64596c = g2;
        if (g2 == null) {
            return;
        }
        this.f64598e = dVar.a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f64595b.get().getContext()) * 0.8125d));
        layoutParams.addRule(14, -1);
        this.f64595b.get().addView(this.f64596c, layoutParams);
        if (d.a.o0.t.a.h.b.f64633a) {
            Log.d("IAdSdkSplash", "BEAR ad start load");
        }
        d.a.o0.s0.a h2 = d.a.o0.s0.a.h();
        String str = f64594g;
        b bVar = new b();
        h2.l(activity, str, bVar, d.a.o0.s0.a.a("spalsh", d.a.o0.t.a.h.a.c().b() + ""));
        this.f64597d = AdLoadState.LOADING;
        d.a.o0.t.a.j.a.i(d.a.o0.t.a.j.a.f64644d);
        FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
    }

    @Override // d.a.o0.t.a.h.b
    public String c() {
        return "bear";
    }

    @Override // d.a.o0.t.a.h.b
    public void destroy() {
        d.a.o0.s0.a.h().c(f64594g);
    }

    public final void h() {
        WeakReference<ViewGroup> weakReference = this.f64595b;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f64595b.get().getLayoutParams();
        layoutParams.width = l.k(this.f64595b.get().getContext());
        layoutParams.height = (int) (l.i(this.f64595b.get().getContext()) * 0.8125d);
        this.f64595b.get().setLayoutParams(layoutParams);
    }

    public boolean j() {
        if (this.f64596c != null && this.f64595b.get() != null) {
            Context context = this.f64595b.get().getContext();
            if (context instanceof Activity) {
                d.a.n0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                d.a.o0.s0.a h2 = d.a.o0.s0.a.h();
                Activity activity = (Activity) context;
                String str = f64594g;
                ViewGroup viewGroup = this.f64596c;
                a.g gVar = this.f64599f;
                h2.o(activity, str, viewGroup, gVar, d.a.o0.s0.a.a("spalsh", d.a.o0.t.a.h.a.c().b() + ""));
                SkinManager.setBackgroundColor(this.f64596c, R.color.CAM_X0101, 0);
                return true;
            }
        }
        return false;
    }

    @Override // d.a.o0.t.a.h.b
    public void show() {
        if (this.f64595b != null && this.f64597d == AdLoadState.SUCCEED) {
            h();
            this.f64597d = AdLoadState.SHOWED;
            j();
        }
    }
}
