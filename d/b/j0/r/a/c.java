package d.b.j0.r.a;

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
import d.b.j0.r0.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class c implements d.b.j0.r.a.h.b {

    /* renamed from: g  reason: collision with root package name */
    public static String f61311g = "6021001853-2133634870";

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f61312b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f61313c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadState f61314d = AdLoadState.INIT;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.k.a f61315e = null;

    /* renamed from: f  reason: collision with root package name */
    public final a.f f61316f = new a();

    /* loaded from: classes4.dex */
    public class a extends a.g {
        public a() {
        }

        @Override // d.b.j0.r0.a.f
        public void onAdClicked(String str) {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdClicked : " + str);
            }
            if (c.this.f61315e != null) {
                c.this.f61315e.b(false, false, 6);
            }
        }

        @Override // d.b.j0.r0.a.f
        public void onAdClose(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
            if (c.this.f61315e != null) {
                c.this.f61315e.onAdDismiss();
            }
            d.b.j0.r.a.h.a.c().a();
        }

        @Override // d.b.j0.r0.a.f
        public void onAdError(String str) {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdError : " + str);
            }
            d.b.j0.r.a.j.a.j(d.b.j0.r.a.j.a.f61360d, "1");
            if (c.this.f61315e != null) {
                c.this.f61315e.onAdDismiss();
            }
        }

        @Override // d.b.j0.r0.a.f
        public void onAdShow(String str) {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdshow");
            }
            c.this.f61315e.c(false, false, 6);
            d.b.j0.r.a.j.a.j(d.b.j0.r.a.j.a.f61360d, "0");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.j0.r0.a.e
        public void a(String str, int i) {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdLoaded successed: " + str);
            }
            d.b.j0.r.a.j.a.i(d.b.j0.r.a.j.a.f61360d, "0", i);
            if (d.b.j0.r0.a.h().k(str)) {
                c.this.f61314d = AdLoadState.SUCCEED;
            } else {
                c.this.f61314d = AdLoadState.FAILED;
                ((ViewGroup) c.this.f61312b.get()).removeView(c.this.f61313c);
            }
            d.b.j0.r.a.h.a.c().g(c.this.f61315e);
        }

        @Override // d.b.j0.r0.a.e
        public void onError(String str) {
            if (d.b.j0.r.a.h.b.f61349a) {
                Log.d("IAdSdkSplash", "BEAR ad onLoadError: " + str);
            }
            d.b.j0.r.a.j.a.i(d.b.j0.r.a.j.a.f61360d, str, 0);
            c.this.f61314d = AdLoadState.FAILED;
            ((ViewGroup) c.this.f61312b.get()).removeView(c.this.f61313c);
            d.b.j0.r.a.h.a.c().g(c.this.f61315e);
        }
    }

    public c() {
        f61311g = d.b.i0.r.d0.b.j().k("splash_bear_sid_type_key", 0) == 1 ? "6021001000-1366583569" : "6021001853-2133634870";
    }

    public static void i(int i) {
        f61311g = i == 1 ? "6021001000-1366583569" : "6021001853-2133634870";
        d.b.i0.r.d0.b.j().v("splash_bear_sid_type_key", i);
    }

    @Override // d.b.j0.r.a.h.b
    public String a() {
        return "bear";
    }

    @Override // d.b.j0.r.a.h.b
    public AdLoadState b() {
        return this.f61314d;
    }

    @Override // d.b.j0.r.a.h.b
    public void c(d.b.i0.k.c cVar) {
        Context context = cVar.b().getContext();
        if (!(context instanceof Activity) || cVar.b() == null) {
            return;
        }
        this.f61312b = new WeakReference<>(cVar.b());
        Activity activity = (Activity) context;
        ViewGroup g2 = d.b.j0.r0.a.h().g(activity, f61311g);
        this.f61313c = g2;
        if (g2 == null) {
            return;
        }
        this.f61315e = cVar.a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f61312b.get().getContext()) * 0.8125d));
        layoutParams.addRule(14, -1);
        this.f61312b.get().addView(this.f61313c, layoutParams);
        if (d.b.j0.r.a.h.b.f61349a) {
            Log.d("IAdSdkSplash", "BEAR ad start load");
        }
        d.b.j0.r0.a h2 = d.b.j0.r0.a.h();
        String str = f61311g;
        b bVar = new b();
        h2.l(activity, str, bVar, d.b.j0.r0.a.a("spalsh", d.b.j0.r.a.h.a.c().b() + ""));
        this.f61314d = AdLoadState.LOADING;
        d.b.j0.r.a.j.a.h(d.b.j0.r.a.j.a.f61360d);
    }

    public final void h() {
        WeakReference<ViewGroup> weakReference = this.f61312b;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61312b.get().getLayoutParams();
        layoutParams.width = l.k(this.f61312b.get().getContext());
        layoutParams.height = (int) (l.i(this.f61312b.get().getContext()) * 0.8125d);
        this.f61312b.get().setLayoutParams(layoutParams);
    }

    public boolean j() {
        if (this.f61313c != null && this.f61312b.get() != null) {
            Context context = this.f61312b.get().getContext();
            if (context instanceof Activity) {
                d.b.i0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                d.b.j0.r0.a h2 = d.b.j0.r0.a.h();
                Activity activity = (Activity) context;
                String str = f61311g;
                ViewGroup viewGroup = this.f61313c;
                a.f fVar = this.f61316f;
                h2.n(activity, str, viewGroup, fVar, d.b.j0.r0.a.a("spalsh", d.b.j0.r.a.h.a.c().b() + ""));
                SkinManager.setBackgroundColor(this.f61313c, R.color.CAM_X0101, 0);
                return true;
            }
        }
        return false;
    }

    @Override // d.b.j0.r.a.h.b
    public void show() {
        if (this.f61312b != null && this.f61314d == AdLoadState.SUCCEED) {
            h();
            this.f61314d = AdLoadState.SHOWED;
            j();
        }
    }
}
