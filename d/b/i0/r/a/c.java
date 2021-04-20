package d.b.i0.r.a;

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
import d.b.c.e.p.l;
import d.b.i0.r0.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class c implements d.b.i0.r.a.h.b {

    /* renamed from: g  reason: collision with root package name */
    public static String f60890g = "6021001853-2133634870";

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f60891b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60892c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadState f60893d = AdLoadState.INIT;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.k.a f60894e = null;

    /* renamed from: f  reason: collision with root package name */
    public final a.f f60895f = new a();

    /* loaded from: classes4.dex */
    public class a extends a.g {
        public a() {
        }

        @Override // d.b.i0.r0.a.f
        public void onAdClicked(String str) {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdClicked : " + str);
            }
            if (c.this.f60894e != null) {
                c.this.f60894e.b(false, false, 6);
            }
        }

        @Override // d.b.i0.r0.a.f
        public void onAdClose(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
            if (c.this.f60894e != null) {
                c.this.f60894e.onAdDismiss();
            }
            d.b.i0.r.a.h.a.c().a();
        }

        @Override // d.b.i0.r0.a.f
        public void onAdError(String str) {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdError : " + str);
            }
            d.b.i0.r.a.j.a.j(d.b.i0.r.a.j.a.f60939d, "1");
            if (c.this.f60894e != null) {
                c.this.f60894e.onAdDismiss();
            }
        }

        @Override // d.b.i0.r0.a.f
        public void onAdShow(String str) {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdshow");
            }
            c.this.f60894e.c(false, false, 6);
            d.b.i0.r.a.j.a.j(d.b.i0.r.a.j.a.f60939d, "0");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.i0.r0.a.e
        public void a(String str, int i) {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdLoaded successed: " + str);
            }
            d.b.i0.r.a.j.a.i(d.b.i0.r.a.j.a.f60939d, "0", i);
            if (d.b.i0.r0.a.h().k(str)) {
                c.this.f60893d = AdLoadState.SUCCEED;
            } else {
                c.this.f60893d = AdLoadState.FAILED;
                ((ViewGroup) c.this.f60891b.get()).removeView(c.this.f60892c);
            }
            d.b.i0.r.a.h.a.c().g(c.this.f60894e);
        }

        @Override // d.b.i0.r0.a.e
        public void onError(String str) {
            if (d.b.i0.r.a.h.b.f60928a) {
                Log.d("IAdSdkSplash", "BEAR ad onLoadError: " + str);
            }
            d.b.i0.r.a.j.a.i(d.b.i0.r.a.j.a.f60939d, str, 0);
            c.this.f60893d = AdLoadState.FAILED;
            ((ViewGroup) c.this.f60891b.get()).removeView(c.this.f60892c);
            d.b.i0.r.a.h.a.c().g(c.this.f60894e);
        }
    }

    public c() {
        f60890g = d.b.h0.r.d0.b.j().k("splash_bear_sid_type_key", 0) == 1 ? "6021001000-1366583569" : "6021001853-2133634870";
    }

    public static void i(int i) {
        f60890g = i == 1 ? "6021001000-1366583569" : "6021001853-2133634870";
        d.b.h0.r.d0.b.j().v("splash_bear_sid_type_key", i);
    }

    @Override // d.b.i0.r.a.h.b
    public String a() {
        return "bear";
    }

    @Override // d.b.i0.r.a.h.b
    public AdLoadState b() {
        return this.f60893d;
    }

    @Override // d.b.i0.r.a.h.b
    public void c(d.b.h0.k.c cVar) {
        Context context = cVar.b().getContext();
        if (!(context instanceof Activity) || cVar.b() == null) {
            return;
        }
        this.f60891b = new WeakReference<>(cVar.b());
        Activity activity = (Activity) context;
        ViewGroup g2 = d.b.i0.r0.a.h().g(activity, f60890g);
        this.f60892c = g2;
        if (g2 == null) {
            return;
        }
        this.f60894e = cVar.a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f60891b.get().getContext()) * 0.8125d));
        layoutParams.addRule(14, -1);
        this.f60891b.get().addView(this.f60892c, layoutParams);
        if (d.b.i0.r.a.h.b.f60928a) {
            Log.d("IAdSdkSplash", "BEAR ad start load");
        }
        d.b.i0.r0.a h2 = d.b.i0.r0.a.h();
        String str = f60890g;
        b bVar = new b();
        h2.l(activity, str, bVar, d.b.i0.r0.a.a("spalsh", d.b.i0.r.a.h.a.c().b() + ""));
        this.f60893d = AdLoadState.LOADING;
        d.b.i0.r.a.j.a.h(d.b.i0.r.a.j.a.f60939d);
    }

    public final void h() {
        WeakReference<ViewGroup> weakReference = this.f60891b;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60891b.get().getLayoutParams();
        layoutParams.width = l.k(this.f60891b.get().getContext());
        layoutParams.height = (int) (l.i(this.f60891b.get().getContext()) * 0.8125d);
        this.f60891b.get().setLayoutParams(layoutParams);
    }

    public boolean j() {
        if (this.f60892c != null && this.f60891b.get() != null) {
            Context context = this.f60891b.get().getContext();
            if (context instanceof Activity) {
                d.b.h0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                d.b.i0.r0.a h2 = d.b.i0.r0.a.h();
                Activity activity = (Activity) context;
                String str = f60890g;
                ViewGroup viewGroup = this.f60892c;
                a.f fVar = this.f60895f;
                h2.n(activity, str, viewGroup, fVar, d.b.i0.r0.a.a("spalsh", d.b.i0.r.a.h.a.c().b() + ""));
                SkinManager.setBackgroundColor(this.f60892c, R.color.CAM_X0101, 0);
                return true;
            }
        }
        return false;
    }

    @Override // d.b.i0.r.a.h.b
    public void show() {
        if (this.f60891b != null && this.f60893d == AdLoadState.SUCCEED) {
            h();
            this.f60893d = AdLoadState.SHOWED;
            j();
        }
    }
}
