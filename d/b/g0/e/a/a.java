package d.b.g0.e.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f47538a;

    /* renamed from: b  reason: collision with root package name */
    public AdElementInfo f47539b;

    /* renamed from: c  reason: collision with root package name */
    public View f47540c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f47541d;

    /* renamed from: e  reason: collision with root package name */
    public int f47542e;

    /* renamed from: f  reason: collision with root package name */
    public int f47543f;

    /* renamed from: g  reason: collision with root package name */
    public AdImageVIew f47544g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageVIew f47545h;
    public RelativeLayout i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public Button n;
    public ImageView o;
    public boolean p;
    public String q;
    public d.b.g0.e.a.m.a r;
    public d.b.g0.e.a.m.d s;
    public e t;
    public boolean u;
    public Runnable v;
    public View.OnClickListener w;
    public View.OnClickListener x;

    /* renamed from: d.b.g0.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0926a implements Runnable {
        public RunnableC0926a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k0.W(a.this.v);
            d.b.g0.g.i0.c A = d.b.g0.g.i0.c.A();
            String str = a.this.q;
            A.K(str, "" + System.currentTimeMillis());
            if (a.this.t != null) {
                a.this.t.g();
            }
            d.b.g0.g.k0.e.b.b(a.this.u ? "gdtbanner" : "banner", IntentConfig.CLOSE);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.r != null) {
                a.this.r.e(CommandType.BANNER_VIEW, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s != null) {
                a.this.s.d(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void g();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.v = new RunnableC0926a();
        this.w = new c();
        this.x = new d();
        this.f47538a = context;
        this.f47539b = adElementInfo;
        this.q = str;
        this.p = d.b.g0.g.i0.c.A().q();
        this.u = z;
        j();
    }

    public void g(int i) {
        int f2 = h0.f(i);
        this.f47542e = f2;
        this.f47543f = (int) (f2 / d.b.g0.e.a.q.d.f47681a);
        this.f47540c.setLayoutParams(new RelativeLayout.LayoutParams(this.f47542e, this.f47543f));
        this.f47541d.setLayoutParams(new RelativeLayout.LayoutParams(this.f47542e, this.f47543f));
        int i2 = (int) (this.f47543f * d.b.g0.e.a.q.d.f47682b);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(i2, this.f47543f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * d.b.g0.e.a.q.d.m), (int) (this.f47543f * d.b.g0.e.a.q.d.n));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.f47545h.setLayoutParams(layoutParams);
        int i3 = this.f47542e - i2;
        this.i.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f47543f));
        int i4 = this.f47543f;
        float f3 = i3;
        int i5 = (int) (d.b.g0.e.a.q.d.f47688h * f3);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (i4 * d.b.g0.e.a.q.d.f47683c);
        layoutParams2.leftMargin = i5;
        layoutParams2.rightMargin = i5;
        this.l.setLayoutParams(layoutParams2);
        this.l.setTextSize(0, (int) (i4 * d.b.g0.e.a.q.d.f47685e));
        this.l.setLineSpacing((int) (i4 * d.b.g0.e.a.q.d.f47684d), 1.0f);
        int i6 = this.f47543f;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (i6 * d.b.g0.e.a.q.d.f47687g));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (i6 * d.b.g0.e.a.q.d.f47686f);
        layoutParams3.leftMargin = i5;
        layoutParams3.rightMargin = i5;
        this.k.setLayoutParams(layoutParams3);
        int i7 = (int) (this.f47543f * d.b.g0.e.a.q.d.k);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (f3 * d.b.g0.e.a.q.d.i), -1);
        layoutParams4.addRule(9);
        float f4 = (int) (d.b.g0.e.a.q.d.l * i7);
        this.m.setTextSize(0, f4);
        layoutParams4.addRule(15);
        this.m.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (d.b.g0.e.a.q.d.j * f3), i7);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.n.setTextSize(0, f4);
        this.n.setLayoutParams(layoutParams5);
        if (this.o != null) {
            int i8 = (int) (this.f47543f * d.b.g0.e.a.q.d.o);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i8, i8);
            layoutParams6.addRule(10);
            layoutParams6.addRule(11);
            this.o.setLayoutParams(layoutParams6);
        }
    }

    public View h() {
        return this.f47540c;
    }

    public void i() {
        View view = this.f47540c;
        if (view != null && view.getVisibility() == 0) {
            this.f47540c.setVisibility(4);
        }
        k0.W(this.v);
    }

    public final void j() {
        Resources resources = this.f47538a.getResources();
        View inflate = LayoutInflater.from(this.f47538a).inflate(h.ng_game_banner_ad, (ViewGroup) null);
        this.f47540c = inflate;
        this.f47541d = (LinearLayout) inflate.findViewById(g.banner_view);
        this.j = (RelativeLayout) this.f47540c.findViewById(g.banner_ad_left);
        AdImageVIew adImageVIew = (AdImageVIew) this.f47540c.findViewById(g.banner_w_pic);
        this.f47544g = adImageVIew;
        AdElementInfo adElementInfo = this.f47539b;
        if (adElementInfo != null) {
            adImageVIew.setImageUrl(adElementInfo.z());
        }
        AdImageVIew adImageVIew2 = (AdImageVIew) this.f47540c.findViewById(g.ad_text);
        this.f47545h = adImageVIew2;
        adImageVIew2.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.i = (RelativeLayout) this.f47540c.findViewById(g.banner_ad_right);
        this.k = (RelativeLayout) this.f47540c.findViewById(g.banner_right_bottom);
        this.l = (TextView) this.f47540c.findViewById(g.banner_title);
        this.m = (TextView) this.f47540c.findViewById(g.banner_app_name);
        AdElementInfo adElementInfo2 = this.f47539b;
        if (adElementInfo2 != null) {
            this.l.setText(adElementInfo2.G());
            this.m.setText(this.f47539b.j());
        }
        Button button = (Button) this.f47540c.findViewById(g.banner_ad_act);
        this.n = button;
        button.setVisibility(8);
        AdElementInfo adElementInfo3 = this.f47539b;
        if (adElementInfo3 != null && adElementInfo3.h() == 1) {
            this.n.setVisibility(0);
            this.n.setText(resources.getString(i.see_detail));
        }
        AdElementInfo adElementInfo4 = this.f47539b;
        if (adElementInfo4 != null && adElementInfo4.h() == 2) {
            this.n.setVisibility(0);
            this.n.setText(resources.getString(i.down_immediately));
        }
        if (this.f47539b == null) {
            this.j.setVisibility(8);
            this.i.setVisibility(8);
            this.f47540c.findViewById(g.no_ad_tips).setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        this.f47540c.findViewById(g.no_ad_tips).setVisibility(8);
        if (this.u) {
            this.n.setOnClickListener(this.x);
            this.f47541d.setOnClickListener(this.x);
        } else {
            this.n.setOnClickListener(this.w);
            this.f47541d.setOnClickListener(this.w);
        }
        this.f47540c.setVisibility(4);
        if (this.p) {
            ImageView imageView = (ImageView) this.f47540c.findViewById(g.close_ad_btn);
            this.o = imageView;
            imageView.setVisibility(0);
            this.o.setOnClickListener(new b());
        }
    }

    public void k(e eVar) {
        this.t = eVar;
    }

    public void l(d.b.g0.e.a.m.a aVar) {
        this.r = aVar;
    }

    public void m(d.b.g0.e.a.m.d dVar) {
        this.s = dVar;
    }

    public void n() {
        View view = this.f47540c;
        if (view == null || view.getVisibility() != 4) {
            return;
        }
        this.f47540c.setAnimation(AnimationUtils.loadAnimation(this.f47538a, d.b.g0.e.a.c.ng_game_ad_open));
        this.f47540c.setVisibility(0);
        k0.U(this.v, d.b.g0.g.i0.c.A().n());
    }

    public a(Context context) {
        this.v = new RunnableC0926a();
        this.w = new c();
        this.x = new d();
        this.f47538a = context;
        j();
    }
}
