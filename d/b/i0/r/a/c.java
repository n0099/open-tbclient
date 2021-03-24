package d.b.i0.r.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import d.b.b.e.p.l;
import d.b.i0.q0.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class c implements d.b.i0.r.a.g.b {

    /* renamed from: f  reason: collision with root package name */
    public static String f59641f = "6021001853-2133634870";

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<ViewGroup> f59642a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59643b;

    /* renamed from: c  reason: collision with root package name */
    public AdLoadState f59644c = AdLoadState.INIT;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.k.a f59645d = null;

    /* renamed from: e  reason: collision with root package name */
    public final a.e f59646e = new a();

    /* loaded from: classes4.dex */
    public class a extends a.f {
        public a() {
        }

        @Override // d.b.i0.q0.a.e
        public void onAdClicked(String str) {
            if (c.this.f59645d != null) {
                c.this.f59645d.a(false, false, 6);
            }
        }

        @Override // d.b.i0.q0.a.e
        public void onAdClose(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
            if (c.this.f59645d != null) {
                c.this.f59645d.onAdDismiss();
            }
            d.b.i0.r.a.g.a.c().a();
        }

        @Override // d.b.i0.q0.a.e
        public void onAdError(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", "a064").param("obj_locate", 1));
            if (c.this.f59645d != null) {
                c.this.f59645d.onAdDismiss();
            }
        }

        @Override // d.b.i0.q0.a.e
        public void onAdShow(String str) {
            c.this.f59645d.c(false, false, 6);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", "a064").param("obj_locate", 0));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.d {
        public b() {
        }

        @Override // d.b.i0.q0.a.d
        public void a(String str, int i) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a064").param("obj_locate", 0).eventStat();
            if (d.b.i0.q0.a.h().k(str)) {
                c.this.f59644c = AdLoadState.SUCCEED;
            } else {
                c.this.f59644c = AdLoadState.FAILED;
                ((ViewGroup) c.this.f59642a.get()).removeView(c.this.f59643b);
            }
            d.b.i0.r.a.g.a.c().g(c.this.f59645d);
        }

        @Override // d.b.i0.q0.a.d
        public void onError(String str) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a064").param("obj_locate", 1).eventStat();
            c.this.f59644c = AdLoadState.FAILED;
            ((ViewGroup) c.this.f59642a.get()).removeView(c.this.f59643b);
            d.b.i0.r.a.g.a.c().g(c.this.f59645d);
        }
    }

    public c() {
        f59641f = d.b.h0.r.d0.b.i().j("splash_bear_sid_type_key", 0) == 1 ? "6021001000-1366583569" : "6021001853-2133634870";
    }

    public static void i(int i) {
        f59641f = i == 1 ? "6021001000-1366583569" : "6021001853-2133634870";
        d.b.h0.r.d0.b.i().u("splash_bear_sid_type_key", i);
    }

    @Override // d.b.i0.r.a.g.b
    public String a() {
        return "bear";
    }

    @Override // d.b.i0.r.a.g.b
    public AdLoadState b() {
        return this.f59644c;
    }

    @Override // d.b.i0.r.a.g.b
    public void c(d.b.h0.k.c cVar) {
        Context context = cVar.b().getContext();
        if (!(context instanceof Activity) || cVar.b() == null) {
            return;
        }
        this.f59642a = new WeakReference<>(cVar.b());
        Activity activity = (Activity) context;
        ViewGroup g2 = d.b.i0.q0.a.h().g(activity, f59641f);
        this.f59643b = g2;
        if (g2 == null) {
            return;
        }
        this.f59645d = cVar.a();
        int k = l.k(context);
        double i = l.i(this.f59642a.get().getContext());
        Double.isNaN(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(k, (int) (i * 0.8125d));
        layoutParams.addRule(14, -1);
        this.f59642a.get().addView(this.f59643b, layoutParams);
        d.b.i0.q0.a.h().l(activity, f59641f, new b(), d.b.i0.q0.a.a("spalsh", d.b.i0.r.a.g.a.c().b() + ""));
        this.f59644c = AdLoadState.LOADING;
    }

    public final void h() {
        WeakReference<ViewGroup> weakReference = this.f59642a;
        if (weakReference == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f59642a.get().getLayoutParams();
        int k = l.k(this.f59642a.get().getContext());
        double i = l.i(this.f59642a.get().getContext());
        Double.isNaN(i);
        layoutParams.width = k;
        layoutParams.height = (int) (i * 0.8125d);
        this.f59642a.get().setLayoutParams(layoutParams);
    }

    public boolean j() {
        if (this.f59643b != null && this.f59642a.get() != null) {
            Context context = this.f59642a.get().getContext();
            if (context instanceof Activity) {
                d.b.h0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                d.b.i0.q0.a h2 = d.b.i0.q0.a.h();
                Activity activity = (Activity) context;
                String str = f59641f;
                ViewGroup viewGroup = this.f59643b;
                a.e eVar = this.f59646e;
                h2.n(activity, str, viewGroup, eVar, d.b.i0.q0.a.a("spalsh", d.b.i0.r.a.g.a.c().b() + ""));
                SkinManager.setBackgroundColor(this.f59643b, R.color.CAM_X0101, 0);
                return true;
            }
        }
        return false;
    }

    @Override // d.b.i0.r.a.g.b
    public void show() {
        if (this.f59642a != null && this.f59644c == AdLoadState.SUCCEED) {
            h();
            this.f59644c = AdLoadState.SHOWED;
            j();
        }
    }
}
