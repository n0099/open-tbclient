package d.a.m0.f.i.i;

import android.annotation.SuppressLint;
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
import d.a.m0.f.i.g;
import d.a.m0.f.i.r.h;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f50438a;

    /* renamed from: b  reason: collision with root package name */
    public AdElementInfo f50439b;

    /* renamed from: c  reason: collision with root package name */
    public View f50440c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f50441d;

    /* renamed from: e  reason: collision with root package name */
    public int f50442e;

    /* renamed from: f  reason: collision with root package name */
    public int f50443f;

    /* renamed from: g  reason: collision with root package name */
    public AdImageVIew f50444g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageVIew f50445h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f50446i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public Button n;
    public ImageView o;
    public boolean p;
    public d.a.m0.f.i.l.a q;
    public d.a.m0.f.i.l.d r;
    public e s;
    public boolean t;
    public Runnable u;
    public View.OnClickListener v;
    public View.OnClickListener w;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.g();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.m0.f.i.r.d.b(d.this.u);
            if (d.this.s != null) {
                d.this.s.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.q != null) {
                d.this.q.b(CommandType.BANNER_VIEW, null);
            }
        }
    }

    /* renamed from: d.a.m0.f.i.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1034d implements View.OnClickListener {
        public View$OnClickListenerC1034d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.r != null) {
                d.this.r.f(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void b();
    }

    public d(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.u = new a();
        this.v = new c();
        this.w = new View$OnClickListenerC1034d();
        this.f50438a = context;
        this.f50439b = adElementInfo;
        this.p = d.a.m0.f.i.m.a.a().j();
        this.t = z;
        h();
    }

    public void e(int i2) {
        int a2 = h.a(i2);
        this.f50442e = a2;
        this.f50443f = (int) (a2 / d.a.m0.f.i.i.e.f50451a);
        this.f50440c.setLayoutParams(new RelativeLayout.LayoutParams(this.f50442e, this.f50443f));
        this.f50441d.setLayoutParams(new RelativeLayout.LayoutParams(this.f50442e, this.f50443f));
        int i3 = (int) (this.f50443f * d.a.m0.f.i.i.e.f50452b);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f50443f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i3 * d.a.m0.f.i.i.e.m), (int) (this.f50443f * d.a.m0.f.i.i.e.n));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.f50445h.setLayoutParams(layoutParams);
        int i4 = this.f50442e - i3;
        this.f50446i.setLayoutParams(new LinearLayout.LayoutParams(i4, this.f50443f));
        int i5 = this.f50443f;
        float f2 = i4;
        int i6 = (int) (d.a.m0.f.i.i.e.f50458h * f2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (i5 * d.a.m0.f.i.i.e.f50453c);
        layoutParams2.leftMargin = i6;
        layoutParams2.rightMargin = i6;
        this.l.setLayoutParams(layoutParams2);
        this.l.setTextSize(0, (int) (i5 * d.a.m0.f.i.i.e.f50455e));
        this.l.setLineSpacing((int) (i5 * d.a.m0.f.i.i.e.f50454d), 1.0f);
        int i7 = this.f50443f;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (i7 * d.a.m0.f.i.i.e.f50457g));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (i7 * d.a.m0.f.i.i.e.f50456f);
        layoutParams3.leftMargin = i6;
        layoutParams3.rightMargin = i6;
        this.k.setLayoutParams(layoutParams3);
        int i8 = (int) (this.f50443f * d.a.m0.f.i.i.e.k);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (f2 * d.a.m0.f.i.i.e.f50459i), -1);
        layoutParams4.addRule(9);
        float f3 = (int) (d.a.m0.f.i.i.e.l * i8);
        this.m.setTextSize(0, f3);
        layoutParams4.addRule(15);
        this.m.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (d.a.m0.f.i.i.e.j * f2), i8);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.n.setTextSize(0, f3);
        this.n.setLayoutParams(layoutParams5);
        if (this.o != null) {
            int i9 = (int) (this.f50443f * d.a.m0.f.i.i.e.o);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i9, i9);
            layoutParams6.addRule(10);
            layoutParams6.addRule(11);
            this.o.setLayoutParams(layoutParams6);
        }
    }

    public View f() {
        return this.f50440c;
    }

    public void g() {
        View view = this.f50440c;
        if (view != null && view.getVisibility() == 0) {
            this.f50440c.setVisibility(4);
        }
        d.a.m0.f.i.r.d.b(this.u);
    }

    @SuppressLint({"InflateParams"})
    public final void h() {
        Resources resources = this.f50438a.getResources();
        View inflate = LayoutInflater.from(this.f50438a).inflate(d.a.m0.f.i.f.ng_game_banner_ad, (ViewGroup) null);
        this.f50440c = inflate;
        this.f50441d = (LinearLayout) inflate.findViewById(d.a.m0.f.i.e.banner_view);
        this.j = (RelativeLayout) this.f50440c.findViewById(d.a.m0.f.i.e.banner_ad_left);
        AdImageVIew adImageVIew = (AdImageVIew) this.f50440c.findViewById(d.a.m0.f.i.e.banner_w_pic);
        this.f50444g = adImageVIew;
        AdElementInfo adElementInfo = this.f50439b;
        if (adElementInfo != null) {
            adImageVIew.setImageUrl(adElementInfo.z());
        }
        AdImageVIew adImageVIew2 = (AdImageVIew) this.f50440c.findViewById(d.a.m0.f.i.e.ad_text);
        this.f50445h = adImageVIew2;
        adImageVIew2.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.f50446i = (RelativeLayout) this.f50440c.findViewById(d.a.m0.f.i.e.banner_ad_right);
        this.k = (RelativeLayout) this.f50440c.findViewById(d.a.m0.f.i.e.banner_right_bottom);
        this.l = (TextView) this.f50440c.findViewById(d.a.m0.f.i.e.banner_title);
        this.m = (TextView) this.f50440c.findViewById(d.a.m0.f.i.e.banner_app_name);
        AdElementInfo adElementInfo2 = this.f50439b;
        if (adElementInfo2 != null) {
            this.l.setText(adElementInfo2.G());
            this.m.setText(this.f50439b.j());
        }
        Button button = (Button) this.f50440c.findViewById(d.a.m0.f.i.e.banner_ad_act);
        this.n = button;
        button.setVisibility(8);
        AdElementInfo adElementInfo3 = this.f50439b;
        if (adElementInfo3 != null && adElementInfo3.h() == 1) {
            this.n.setVisibility(0);
            this.n.setText(resources.getString(g.see_detail));
        }
        AdElementInfo adElementInfo4 = this.f50439b;
        if (adElementInfo4 != null && adElementInfo4.h() == 2) {
            this.n.setVisibility(0);
            this.n.setText(resources.getString(g.swanapp_ad_download_button));
        }
        if (this.f50439b == null) {
            this.j.setVisibility(8);
            this.f50446i.setVisibility(8);
            this.f50440c.findViewById(d.a.m0.f.i.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.f50446i.setVisibility(0);
        this.f50440c.findViewById(d.a.m0.f.i.e.no_ad_tips).setVisibility(8);
        if (this.t) {
            this.n.setOnClickListener(this.w);
            this.f50441d.setOnClickListener(this.w);
        } else {
            this.n.setOnClickListener(this.v);
            this.f50441d.setOnClickListener(this.v);
        }
        this.f50440c.setVisibility(4);
        if (this.p) {
            ImageView imageView = (ImageView) this.f50440c.findViewById(d.a.m0.f.i.e.close_ad_btn);
            this.o = imageView;
            imageView.setVisibility(0);
            this.o.setOnClickListener(new b());
        }
    }

    public void i(e eVar) {
        this.s = eVar;
    }

    public void j(d.a.m0.f.i.l.a aVar) {
        this.q = aVar;
    }

    public void k(d.a.m0.f.i.l.d dVar) {
        this.r = dVar;
    }

    public void l() {
        View view = this.f50440c;
        if (view == null || view.getVisibility() != 4) {
            return;
        }
        this.f50440c.setAnimation(AnimationUtils.loadAnimation(this.f50438a, d.a.m0.f.i.a.ng_game_ad_open));
        this.f50440c.setVisibility(0);
        d.a.m0.f.i.r.d.a(this.u, d.a.m0.f.i.m.a.a().a());
    }

    public d(Context context) {
        this.u = new a();
        this.v = new c();
        this.w = new View$OnClickListenerC1034d();
        this.f50438a = context;
        h();
    }
}
