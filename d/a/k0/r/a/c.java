package d.a.k0.r.a;

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
import d.a.c.e.p.l;
import d.a.k0.r0.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class c implements d.a.k0.r.a.h.b {

    /* renamed from: g  reason: collision with root package name */
    public static String f60197g = "6021002119-1732188456";

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f60198b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60199c;

    /* renamed from: d  reason: collision with root package name */
    public AdLoadState f60200d = AdLoadState.INIT;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.k.a f60201e = null;

    /* renamed from: f  reason: collision with root package name */
    public final a.f f60202f = new a();

    /* loaded from: classes4.dex */
    public class a extends a.g {
        public a() {
        }

        @Override // d.a.k0.r0.a.f
        public void onAdClicked(String str) {
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdClicked : " + str);
            }
            if (c.this.f60201e != null) {
                c.this.f60201e.b(false, false, 6);
            }
        }

        @Override // d.a.k0.r0.a.f
        public void onAdClose(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
            if (c.this.f60201e != null) {
                c.this.f60201e.onAdDismiss();
            }
        }

        @Override // d.a.k0.r0.a.f
        public void onAdError(String str) {
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdError : " + str);
            }
            d.a.k0.r.a.j.a.j(d.a.k0.r.a.j.a.f60247d, "1");
            if (c.this.f60201e != null) {
                c.this.f60201e.onAdDismiss();
            }
        }

        @Override // d.a.k0.r0.a.f
        public void onAdShow(String str) {
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdshow");
            }
            c.this.f60201e.c(false, false, 6);
            d.a.k0.r.a.j.a.j(d.a.k0.r.a.j.a.f60247d, "0");
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.k0.r0.a.e
        public void a(String str, int i2) {
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "BEAR ad onAdLoaded successed: " + str);
            }
            d.a.k0.r.a.j.a.i(d.a.k0.r.a.j.a.f60247d, "0", i2);
            if (d.a.k0.r0.a.h().k(str)) {
                c.this.f60200d = AdLoadState.SUCCEED;
            } else {
                c.this.f60200d = AdLoadState.FAILED;
                ((ViewGroup) c.this.f60198b.get()).removeView(c.this.f60199c);
            }
            d.a.k0.r.a.h.a.c().g(c.this.f60201e);
        }

        @Override // d.a.k0.r0.a.e
        public void onError(String str) {
            if (d.a.k0.r.a.h.b.f60236a) {
                Log.d("IAdSdkSplash", "BEAR ad onLoadError: " + str);
            }
            d.a.k0.r.a.j.a.i(d.a.k0.r.a.j.a.f60247d, str, 0);
            c.this.f60200d = AdLoadState.FAILED;
            ((ViewGroup) c.this.f60198b.get()).removeView(c.this.f60199c);
            d.a.k0.r.a.h.a.c().g(c.this.f60201e);
        }
    }

    public c() {
        f60197g = d.a.j0.r.d0.b.j().k("splash_bear_sid_type_key", 0) == 1 ? "6021002118-283136489" : "6021002119-1732188456";
    }

    public static void i(int i2) {
        f60197g = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        d.a.j0.r.d0.b.j().v("splash_bear_sid_type_key", i2);
    }

    @Override // d.a.k0.r.a.h.b
    public AdLoadState a() {
        return this.f60200d;
    }

    @Override // d.a.k0.r.a.h.b
    public void b(d.a.j0.k.c cVar) {
        Context context = cVar.b().getContext();
        if (!(context instanceof Activity) || cVar.b() == null) {
            return;
        }
        this.f60198b = new WeakReference<>(cVar.b());
        Activity activity = (Activity) context;
        ViewGroup g2 = d.a.k0.r0.a.h().g(activity, f60197g);
        this.f60199c = g2;
        if (g2 == null) {
            return;
        }
        this.f60201e = cVar.a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f60198b.get().getContext()) * 0.8125d));
        layoutParams.addRule(14, -1);
        this.f60198b.get().addView(this.f60199c, layoutParams);
        if (d.a.k0.r.a.h.b.f60236a) {
            Log.d("IAdSdkSplash", "BEAR ad start load");
        }
        d.a.k0.r0.a h2 = d.a.k0.r0.a.h();
        String str = f60197g;
        b bVar = new b();
        h2.l(activity, str, bVar, d.a.k0.r0.a.a("spalsh", d.a.k0.r.a.h.a.c().b() + ""));
        this.f60200d = AdLoadState.LOADING;
        d.a.k0.r.a.j.a.h(d.a.k0.r.a.j.a.f60247d);
    }

    @Override // d.a.k0.r.a.h.b
    public String c() {
        return "bear";
    }

    @Override // d.a.k0.r.a.h.b
    public void destroy() {
        d.a.k0.r0.a.h().c(f60197g);
    }

    public final void h() {
        WeakReference<ViewGroup> weakReference = this.f60198b;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f60198b.get().getLayoutParams();
        layoutParams.width = l.k(this.f60198b.get().getContext());
        layoutParams.height = (int) (l.i(this.f60198b.get().getContext()) * 0.8125d);
        this.f60198b.get().setLayoutParams(layoutParams);
    }

    public boolean j() {
        if (this.f60199c != null && this.f60198b.get() != null) {
            Context context = this.f60198b.get().getContext();
            if (context instanceof Activity) {
                d.a.j0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                d.a.k0.r0.a h2 = d.a.k0.r0.a.h();
                Activity activity = (Activity) context;
                String str = f60197g;
                ViewGroup viewGroup = this.f60199c;
                a.f fVar = this.f60202f;
                h2.n(activity, str, viewGroup, fVar, d.a.k0.r0.a.a("spalsh", d.a.k0.r.a.h.a.c().b() + ""));
                SkinManager.setBackgroundColor(this.f60199c, R.color.CAM_X0101, 0);
                return true;
            }
        }
        return false;
    }

    @Override // d.a.k0.r.a.h.b
    public void show() {
        if (this.f60198b != null && this.f60200d == AdLoadState.SUCCEED) {
            h();
            this.f60200d = AdLoadState.SHOWED;
            j();
        }
    }
}
