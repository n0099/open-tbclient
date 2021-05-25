package d.a.l0.f.i.i;

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
import d.a.l0.f.i.g;
import d.a.l0.f.i.r.h;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f46656a;

    /* renamed from: b  reason: collision with root package name */
    public AdElementInfo f46657b;

    /* renamed from: c  reason: collision with root package name */
    public View f46658c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f46659d;

    /* renamed from: e  reason: collision with root package name */
    public int f46660e;

    /* renamed from: f  reason: collision with root package name */
    public int f46661f;

    /* renamed from: g  reason: collision with root package name */
    public AdImageVIew f46662g;

    /* renamed from: h  reason: collision with root package name */
    public AdImageVIew f46663h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f46664i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public Button n;
    public ImageView o;
    public boolean p;
    public d.a.l0.f.i.l.a q;
    public d.a.l0.f.i.l.d r;
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
            d.a.l0.f.i.r.d.b(d.this.u);
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

    /* renamed from: d.a.l0.f.i.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0975d implements View.OnClickListener {
        public View$OnClickListenerC0975d() {
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
        this.w = new View$OnClickListenerC0975d();
        this.f46656a = context;
        this.f46657b = adElementInfo;
        this.p = d.a.l0.f.i.m.a.a().j();
        this.t = z;
        h();
    }

    public void e(int i2) {
        int a2 = h.a(i2);
        this.f46660e = a2;
        this.f46661f = (int) (a2 / d.a.l0.f.i.i.e.f46669a);
        this.f46658c.setLayoutParams(new RelativeLayout.LayoutParams(this.f46660e, this.f46661f));
        this.f46659d.setLayoutParams(new RelativeLayout.LayoutParams(this.f46660e, this.f46661f));
        int i3 = (int) (this.f46661f * d.a.l0.f.i.i.e.f46670b);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f46661f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i3 * d.a.l0.f.i.i.e.m), (int) (this.f46661f * d.a.l0.f.i.i.e.n));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.f46663h.setLayoutParams(layoutParams);
        int i4 = this.f46660e - i3;
        this.f46664i.setLayoutParams(new LinearLayout.LayoutParams(i4, this.f46661f));
        int i5 = this.f46661f;
        float f2 = i4;
        int i6 = (int) (d.a.l0.f.i.i.e.f46676h * f2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (i5 * d.a.l0.f.i.i.e.f46671c);
        layoutParams2.leftMargin = i6;
        layoutParams2.rightMargin = i6;
        this.l.setLayoutParams(layoutParams2);
        this.l.setTextSize(0, (int) (i5 * d.a.l0.f.i.i.e.f46673e));
        this.l.setLineSpacing((int) (i5 * d.a.l0.f.i.i.e.f46672d), 1.0f);
        int i7 = this.f46661f;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (i7 * d.a.l0.f.i.i.e.f46675g));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (i7 * d.a.l0.f.i.i.e.f46674f);
        layoutParams3.leftMargin = i6;
        layoutParams3.rightMargin = i6;
        this.k.setLayoutParams(layoutParams3);
        int i8 = (int) (this.f46661f * d.a.l0.f.i.i.e.k);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (f2 * d.a.l0.f.i.i.e.f46677i), -1);
        layoutParams4.addRule(9);
        float f3 = (int) (d.a.l0.f.i.i.e.l * i8);
        this.m.setTextSize(0, f3);
        layoutParams4.addRule(15);
        this.m.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (d.a.l0.f.i.i.e.j * f2), i8);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.n.setTextSize(0, f3);
        this.n.setLayoutParams(layoutParams5);
        if (this.o != null) {
            int i9 = (int) (this.f46661f * d.a.l0.f.i.i.e.o);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i9, i9);
            layoutParams6.addRule(10);
            layoutParams6.addRule(11);
            this.o.setLayoutParams(layoutParams6);
        }
    }

    public View f() {
        return this.f46658c;
    }

    public void g() {
        View view = this.f46658c;
        if (view != null && view.getVisibility() == 0) {
            this.f46658c.setVisibility(4);
        }
        d.a.l0.f.i.r.d.b(this.u);
    }

    @SuppressLint({"InflateParams"})
    public final void h() {
        Resources resources = this.f46656a.getResources();
        View inflate = LayoutInflater.from(this.f46656a).inflate(d.a.l0.f.i.f.ng_game_banner_ad, (ViewGroup) null);
        this.f46658c = inflate;
        this.f46659d = (LinearLayout) inflate.findViewById(d.a.l0.f.i.e.banner_view);
        this.j = (RelativeLayout) this.f46658c.findViewById(d.a.l0.f.i.e.banner_ad_left);
        AdImageVIew adImageVIew = (AdImageVIew) this.f46658c.findViewById(d.a.l0.f.i.e.banner_w_pic);
        this.f46662g = adImageVIew;
        AdElementInfo adElementInfo = this.f46657b;
        if (adElementInfo != null) {
            adImageVIew.setImageUrl(adElementInfo.z());
        }
        AdImageVIew adImageVIew2 = (AdImageVIew) this.f46658c.findViewById(d.a.l0.f.i.e.ad_text);
        this.f46663h = adImageVIew2;
        adImageVIew2.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.f46664i = (RelativeLayout) this.f46658c.findViewById(d.a.l0.f.i.e.banner_ad_right);
        this.k = (RelativeLayout) this.f46658c.findViewById(d.a.l0.f.i.e.banner_right_bottom);
        this.l = (TextView) this.f46658c.findViewById(d.a.l0.f.i.e.banner_title);
        this.m = (TextView) this.f46658c.findViewById(d.a.l0.f.i.e.banner_app_name);
        AdElementInfo adElementInfo2 = this.f46657b;
        if (adElementInfo2 != null) {
            this.l.setText(adElementInfo2.G());
            this.m.setText(this.f46657b.j());
        }
        Button button = (Button) this.f46658c.findViewById(d.a.l0.f.i.e.banner_ad_act);
        this.n = button;
        button.setVisibility(8);
        AdElementInfo adElementInfo3 = this.f46657b;
        if (adElementInfo3 != null && adElementInfo3.h() == 1) {
            this.n.setVisibility(0);
            this.n.setText(resources.getString(g.see_detail));
        }
        AdElementInfo adElementInfo4 = this.f46657b;
        if (adElementInfo4 != null && adElementInfo4.h() == 2) {
            this.n.setVisibility(0);
            this.n.setText(resources.getString(g.swanapp_ad_download_button));
        }
        if (this.f46657b == null) {
            this.j.setVisibility(8);
            this.f46664i.setVisibility(8);
            this.f46658c.findViewById(d.a.l0.f.i.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.f46664i.setVisibility(0);
        this.f46658c.findViewById(d.a.l0.f.i.e.no_ad_tips).setVisibility(8);
        if (this.t) {
            this.n.setOnClickListener(this.w);
            this.f46659d.setOnClickListener(this.w);
        } else {
            this.n.setOnClickListener(this.v);
            this.f46659d.setOnClickListener(this.v);
        }
        this.f46658c.setVisibility(4);
        if (this.p) {
            ImageView imageView = (ImageView) this.f46658c.findViewById(d.a.l0.f.i.e.close_ad_btn);
            this.o = imageView;
            imageView.setVisibility(0);
            this.o.setOnClickListener(new b());
        }
    }

    public void i(e eVar) {
        this.s = eVar;
    }

    public void j(d.a.l0.f.i.l.a aVar) {
        this.q = aVar;
    }

    public void k(d.a.l0.f.i.l.d dVar) {
        this.r = dVar;
    }

    public void l() {
        View view = this.f46658c;
        if (view == null || view.getVisibility() != 4) {
            return;
        }
        this.f46658c.setAnimation(AnimationUtils.loadAnimation(this.f46656a, d.a.l0.f.i.a.ng_game_ad_open));
        this.f46658c.setVisibility(0);
        d.a.l0.f.i.r.d.a(this.u, d.a.l0.f.i.m.a.a().a());
    }

    public d(Context context) {
        this.u = new a();
        this.v = new c();
        this.w = new View$OnClickListenerC0975d();
        this.f46656a = context;
        h();
    }
}
