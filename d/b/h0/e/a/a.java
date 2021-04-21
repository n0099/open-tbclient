package d.b.h0.e.a;

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
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f48260a;

    /* renamed from: b  reason: collision with root package name */
    public AdElementInfo f48261b;

    /* renamed from: c  reason: collision with root package name */
    public View f48262c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f48263d;

    /* renamed from: e  reason: collision with root package name */
    public int f48264e;

    /* renamed from: f  reason: collision with root package name */
    public int f48265f;

    /* renamed from: g  reason: collision with root package name */
    public AdImageVIew f48266g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageVIew f48267h;
    public RelativeLayout i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public Button n;
    public ImageView o;
    public boolean p;
    public String q;
    public d.b.h0.e.a.m.a r;
    public d.b.h0.e.a.m.d s;
    public e t;
    public boolean u;
    public Runnable v;
    public View.OnClickListener w;
    public View.OnClickListener x;

    /* renamed from: d.b.h0.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0959a implements Runnable {
        public RunnableC0959a() {
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
            d.b.h0.g.i0.c A = d.b.h0.g.i0.c.A();
            String str = a.this.q;
            A.K(str, "" + System.currentTimeMillis());
            if (a.this.t != null) {
                a.this.t.g();
            }
            d.b.h0.g.k0.e.b.b(a.this.u ? "gdtbanner" : "banner", IntentConfig.CLOSE);
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
        this.v = new RunnableC0959a();
        this.w = new c();
        this.x = new d();
        this.f48260a = context;
        this.f48261b = adElementInfo;
        this.q = str;
        this.p = d.b.h0.g.i0.c.A().q();
        this.u = z;
        j();
    }

    public void g(int i) {
        int f2 = h0.f(i);
        this.f48264e = f2;
        this.f48265f = (int) (f2 / d.b.h0.e.a.q.d.f48403a);
        this.f48262c.setLayoutParams(new RelativeLayout.LayoutParams(this.f48264e, this.f48265f));
        this.f48263d.setLayoutParams(new RelativeLayout.LayoutParams(this.f48264e, this.f48265f));
        int i2 = (int) (this.f48265f * d.b.h0.e.a.q.d.f48404b);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(i2, this.f48265f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * d.b.h0.e.a.q.d.m), (int) (this.f48265f * d.b.h0.e.a.q.d.n));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.f48267h.setLayoutParams(layoutParams);
        int i3 = this.f48264e - i2;
        this.i.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f48265f));
        int i4 = this.f48265f;
        float f3 = i3;
        int i5 = (int) (d.b.h0.e.a.q.d.f48410h * f3);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (i4 * d.b.h0.e.a.q.d.f48405c);
        layoutParams2.leftMargin = i5;
        layoutParams2.rightMargin = i5;
        this.l.setLayoutParams(layoutParams2);
        this.l.setTextSize(0, (int) (i4 * d.b.h0.e.a.q.d.f48407e));
        this.l.setLineSpacing((int) (i4 * d.b.h0.e.a.q.d.f48406d), 1.0f);
        int i6 = this.f48265f;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (i6 * d.b.h0.e.a.q.d.f48409g));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (i6 * d.b.h0.e.a.q.d.f48408f);
        layoutParams3.leftMargin = i5;
        layoutParams3.rightMargin = i5;
        this.k.setLayoutParams(layoutParams3);
        int i7 = (int) (this.f48265f * d.b.h0.e.a.q.d.k);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (f3 * d.b.h0.e.a.q.d.i), -1);
        layoutParams4.addRule(9);
        float f4 = (int) (d.b.h0.e.a.q.d.l * i7);
        this.m.setTextSize(0, f4);
        layoutParams4.addRule(15);
        this.m.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (d.b.h0.e.a.q.d.j * f3), i7);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.n.setTextSize(0, f4);
        this.n.setLayoutParams(layoutParams5);
        if (this.o != null) {
            int i8 = (int) (this.f48265f * d.b.h0.e.a.q.d.o);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i8, i8);
            layoutParams6.addRule(10);
            layoutParams6.addRule(11);
            this.o.setLayoutParams(layoutParams6);
        }
    }

    public View h() {
        return this.f48262c;
    }

    public void i() {
        View view = this.f48262c;
        if (view != null && view.getVisibility() == 0) {
            this.f48262c.setVisibility(4);
        }
        k0.W(this.v);
    }

    public final void j() {
        Resources resources = this.f48260a.getResources();
        View inflate = LayoutInflater.from(this.f48260a).inflate(h.ng_game_banner_ad, (ViewGroup) null);
        this.f48262c = inflate;
        this.f48263d = (LinearLayout) inflate.findViewById(g.banner_view);
        this.j = (RelativeLayout) this.f48262c.findViewById(g.banner_ad_left);
        AdImageVIew adImageVIew = (AdImageVIew) this.f48262c.findViewById(g.banner_w_pic);
        this.f48266g = adImageVIew;
        AdElementInfo adElementInfo = this.f48261b;
        if (adElementInfo != null) {
            adImageVIew.setImageUrl(adElementInfo.z());
        }
        AdImageVIew adImageVIew2 = (AdImageVIew) this.f48262c.findViewById(g.ad_text);
        this.f48267h = adImageVIew2;
        adImageVIew2.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.i = (RelativeLayout) this.f48262c.findViewById(g.banner_ad_right);
        this.k = (RelativeLayout) this.f48262c.findViewById(g.banner_right_bottom);
        this.l = (TextView) this.f48262c.findViewById(g.banner_title);
        this.m = (TextView) this.f48262c.findViewById(g.banner_app_name);
        AdElementInfo adElementInfo2 = this.f48261b;
        if (adElementInfo2 != null) {
            this.l.setText(adElementInfo2.G());
            this.m.setText(this.f48261b.j());
        }
        Button button = (Button) this.f48262c.findViewById(g.banner_ad_act);
        this.n = button;
        button.setVisibility(8);
        AdElementInfo adElementInfo3 = this.f48261b;
        if (adElementInfo3 != null && adElementInfo3.h() == 1) {
            this.n.setVisibility(0);
            this.n.setText(resources.getString(i.see_detail));
        }
        AdElementInfo adElementInfo4 = this.f48261b;
        if (adElementInfo4 != null && adElementInfo4.h() == 2) {
            this.n.setVisibility(0);
            this.n.setText(resources.getString(i.down_immediately));
        }
        if (this.f48261b == null) {
            this.j.setVisibility(8);
            this.i.setVisibility(8);
            this.f48262c.findViewById(g.no_ad_tips).setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        this.f48262c.findViewById(g.no_ad_tips).setVisibility(8);
        if (this.u) {
            this.n.setOnClickListener(this.x);
            this.f48263d.setOnClickListener(this.x);
        } else {
            this.n.setOnClickListener(this.w);
            this.f48263d.setOnClickListener(this.w);
        }
        this.f48262c.setVisibility(4);
        if (this.p) {
            ImageView imageView = (ImageView) this.f48262c.findViewById(g.close_ad_btn);
            this.o = imageView;
            imageView.setVisibility(0);
            this.o.setOnClickListener(new b());
        }
    }

    public void k(e eVar) {
        this.t = eVar;
    }

    public void l(d.b.h0.e.a.m.a aVar) {
        this.r = aVar;
    }

    public void m(d.b.h0.e.a.m.d dVar) {
        this.s = dVar;
    }

    public void n() {
        View view = this.f48262c;
        if (view == null || view.getVisibility() != 4) {
            return;
        }
        this.f48262c.setAnimation(AnimationUtils.loadAnimation(this.f48260a, d.b.h0.e.a.c.ng_game_ad_open));
        this.f48262c.setVisibility(0);
        k0.U(this.v, d.b.h0.g.i0.c.A().n());
    }

    public a(Context context) {
        this.v = new RunnableC0959a();
        this.w = new c();
        this.x = new d();
        this.f48260a = context;
        j();
    }
}
