package d.a.h0.e.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.game.ad.InteractiveEndFrameView;
import com.baidu.swan.game.ad.RewardLoadWebView;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.component.RewardVideoView;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import d.a.h0.a.i2.h0;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f45723a;

    /* renamed from: b  reason: collision with root package name */
    public View f45724b;

    /* renamed from: c  reason: collision with root package name */
    public RewardVideoView f45725c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.b1.g.a f45726d;

    /* renamed from: e  reason: collision with root package name */
    public int f45727e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f45728f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f45729g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f45730h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f45731i;
    public TextView j;
    public View k;
    public RelativeLayout l;
    public Context o;
    public AdElementInfo p;
    public d.a.h0.e.a.m.c r;
    public RewardLoadWebView s;
    public RewardLoadWebView t;
    public InteractiveEndFrameView u;
    public Resources v;
    public d.a.h0.e.a.n.a w;
    public d.a.h0.e.a.m.d y;
    public d.a.h0.e.a.r.b z;
    public final Handler q = new Handler();
    public boolean A = false;
    public Runnable B = new RunnableC0899b();
    public View.OnClickListener C = new c();
    public View.OnClickListener D = new d();
    public View.OnClickListener E = new e();
    public int m = d.a.h0.g.k0.e.c.c();
    public int n = d.a.h0.g.k0.e.c.b();
    public boolean x = d.a.h0.e.a.q.f.i();

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a(b bVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: d.a.h0.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0899b implements Runnable {
        public RunnableC0899b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45726d != null) {
                b.this.I();
                int i2 = b.this.f45726d.i();
                b bVar = b.this;
                bVar.H(bVar.f45727e, i2);
                int min = Math.min(i2 + 1000, b.this.f45727e);
                b.this.f45728f.setProgress(min / 1000);
                if (min < b.this.f45727e) {
                    b.this.q.postDelayed(b.this.B, 100L);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f45725c == null) {
                return;
            }
            if (b.this.f45725c.c()) {
                b.this.f45730h.setImageResource(f.ng_game_vol_open);
                b.this.f45725c.d(false);
                return;
            }
            b.this.f45730h.setImageResource(f.ng_game_vol_close);
            b.this.f45725c.d(true);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.r != null) {
                b.this.r.e(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.y != null) {
                b.this.y.f(view);
            }
        }
    }

    public b(Context context, AdElementInfo adElementInfo, d.a.h0.e.a.n.a aVar) {
        this.o = context;
        this.p = adElementInfo;
        this.v = this.o.getResources();
        this.w = aVar;
        v();
        this.z = new d.a.h0.e.a.r.b(this.o);
    }

    public abstract void A(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public void B() {
        F();
    }

    public void C(d.a.h0.e.a.m.c cVar) {
        this.r = cVar;
    }

    public void D(d.a.h0.e.a.m.d dVar) {
        this.y = dVar;
    }

    public void E(String str) {
        RewardVideoView rewardVideoView = this.f45725c;
        if (rewardVideoView != null) {
            rewardVideoView.e(str);
        }
    }

    public final void F() {
        if (this.f45728f != null) {
            this.q.removeCallbacksAndMessages(null);
            this.q.postDelayed(this.B, 0L);
        }
    }

    public final void G() {
        if (this.f45728f != null) {
            this.q.removeCallbacksAndMessages(null);
        }
    }

    public final void H(long j, int i2) {
        if (this.x) {
            if (j <= 15000 || i2 > 15000) {
                this.j.setText(i.swangame_game_ad_reward_tip);
                this.f45731i.setVisibility(0);
                this.k.setVisibility(0);
                this.j.setVisibility(0);
            } else if (i2 < 5000) {
                this.f45729g.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.f45731i.setVisibility(8);
            } else if (i2 < 10000) {
                this.f45729g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                this.f45731i.setVisibility(8);
            } else {
                this.f45729g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.f45731i.setVisibility(0);
            }
        }
    }

    public final void I() {
        d.a.h0.a.b1.g.a aVar;
        if (this.p == null || (aVar = this.f45726d) == null) {
            return;
        }
        this.f45727e = aVar.j();
        int min = Math.min(this.p.A(), this.f45727e / 1000);
        int B = this.p.B();
        int i2 = this.f45726d.i() / 1000;
        String string = this.o.getResources().getString(i.swangame_game_ad_video_reward_time_surplus);
        String string2 = this.o.getResources().getString(i.swangame_game_ad_video_time_surplus);
        if (i2 <= min) {
            this.j.setText(String.format(string, Integer.valueOf(min - i2)));
        } else {
            this.j.setText(String.format(string2, Integer.valueOf((this.f45727e / 1000) - i2)));
        }
        if (i2 <= B) {
            this.f45731i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.f45731i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        TextView textView = new TextView(this.o);
        textView.setBackground(this.v.getDrawable(f.ng_game_bg_close_ad));
        textView.setTextColor(this.v.getColor(d.a.h0.e.a.d.close_ad_text_color));
        textView.setText(this.v.getString(i.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.D);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h0.e(this.o, 96.0f), h0.e(this.o, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.v.getDimensionPixelSize(d.a.h0.e.a.e.include_land_close_ad_margin), this.v.getDimensionPixelSize(d.a.h0.e.a.e.include_land_close_ad_margin), 0);
        this.f45723a.addView(textView, layoutParams);
    }

    public final void m() {
        if (this.f45723a != null) {
            this.A = true;
            this.f45729g.setVisibility(4);
            this.l.setVisibility(4);
            this.f45731i.setVisibility(4);
            if (!TextUtils.isEmpty(this.p.t())) {
                InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.o);
                this.u = interactiveEndFrameView;
                interactiveEndFrameView.s(this.p, this.f45723a);
                this.f45723a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
                d.a.h0.e.a.p.c.f(this.p, this.z);
            } else if (!TextUtils.isEmpty(this.p.s())) {
                RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.o);
                this.t = rewardLoadWebView;
                rewardLoadWebView.b("reward_end_frame_html", this.p, this.w);
                this.f45723a.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                d.a.h0.e.a.p.c.f(this.p, this.z);
            } else {
                View inflate = LayoutInflater.from(this.o).inflate(h.ng_game_reward_close_banner, (ViewGroup) null);
                this.f45723a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(g.reward_icon)).setImageUrl(this.p.v());
                ((TextView) inflate.findViewById(g.title)).setText(this.p.G());
                ((TextView) inflate.findViewById(g.desc)).setText(this.p.q());
                Button button = (Button) inflate.findViewById(g.download);
                if (this.p.h() == 1) {
                    button.setText(this.o.getResources().getString(i.see_detail));
                }
                if (this.p.h() == 2) {
                    button.setText(this.o.getResources().getString(i.down_immediately));
                }
                inflate.findViewById(g.content_des).setOnClickListener(this.E);
                button.setOnClickListener(this.E);
            }
            l();
        }
    }

    public void n() {
        G();
        RewardLoadWebView rewardLoadWebView = this.s;
        if (rewardLoadWebView != null) {
            rewardLoadWebView.c();
            this.s = null;
        }
        RewardLoadWebView rewardLoadWebView2 = this.t;
        if (rewardLoadWebView2 != null) {
            rewardLoadWebView2.c();
            this.t = null;
        }
        InteractiveEndFrameView interactiveEndFrameView = this.u;
        if (interactiveEndFrameView != null) {
            interactiveEndFrameView.t();
            this.u = null;
        }
    }

    public void o() {
        AdElementInfo adElementInfo;
        d.a.h0.a.b1.g.a aVar;
        F();
        ProgressBar progressBar = this.f45728f;
        if (progressBar != null && (aVar = this.f45726d) != null) {
            progressBar.setMax(aVar.j() / 1000);
            this.f45728f.setVisibility(4);
        }
        if (this.j != null && this.f45726d != null && (adElementInfo = this.p) != null) {
            this.j.setText(String.format(this.o.getResources().getString(i.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.p.B(), Math.min(adElementInfo.A(), this.f45726d.j())) / 1000)));
            if (this.p.B() >= 0) {
                this.f45731i.setVisibility(8);
                this.k.setVisibility(8);
            }
        }
        if (this.f45729g.getVisibility() != 0) {
            this.f45729g.setVisibility(0);
        }
        if (this.l.getVisibility() != 0) {
            this.l.setAnimation(AnimationUtils.loadAnimation(this.o, d.a.h0.e.a.c.ng_game_ad_open));
            this.l.setVisibility(0);
        }
        d.a.h0.a.b1.g.a aVar2 = this.f45726d;
        if (aVar2 != null) {
            H(aVar2.j(), this.f45726d.i());
        }
    }

    public abstract String p();

    public View q() {
        return this.f45724b;
    }

    public d.a.h0.a.b1.g.a r() {
        RewardVideoView rewardVideoView = this.f45725c;
        if (rewardVideoView != null) {
            return rewardVideoView.getPlayer();
        }
        return null;
    }

    public boolean s() {
        return this.A;
    }

    public abstract View t();

    public final void u() {
        this.f45723a.setOnTouchListener(new a(this));
        this.f45730h.setOnClickListener(this.C);
        this.f45731i.setOnClickListener(this.D);
    }

    public final void v() {
        this.f45724b = t();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.m, this.n);
        this.f45724b.setLayoutParams(layoutParams);
        this.f45723a = (RelativeLayout) this.f45724b.findViewById(g.reward_relative);
        RewardVideoView rewardVideoView = (RewardVideoView) this.f45724b.findViewById(g.video_view);
        this.f45725c = rewardVideoView;
        rewardVideoView.setLayoutParams(layoutParams);
        if (this.x) {
            this.f45725c.setOnClickListener(this.E);
        }
        this.f45728f = (ProgressBar) this.f45724b.findViewById(g.swangame_game_ad_video_progress_horizontal);
        this.f45729g = (LinearLayout) this.f45724b.findViewById(g.vol_clo);
        this.f45730h = (ImageView) this.f45724b.findViewById(g.volume);
        this.f45731i = (TextView) this.f45724b.findViewById(g.close_ad);
        this.j = (TextView) this.f45724b.findViewById(g.close_ad_header);
        this.k = this.f45724b.findViewById(g.close_ad_middle);
        this.l = (RelativeLayout) this.f45724b.findViewById(g.banner);
        if (!TextUtils.isEmpty(this.p.k())) {
            this.s = new RewardLoadWebView(this.o);
            this.l.addView(this.s, new RelativeLayout.LayoutParams(-1, -1));
            A(this.l, this.p);
            this.s.b(p(), this.p, this.w);
        } else {
            View inflate = LayoutInflater.from(this.o).inflate(h.ng_game_reward_banner, (ViewGroup) null);
            this.l.addView(inflate);
            ((AdImageVIew) inflate.findViewById(g.reward_icon)).setImageUrl(this.p.v());
            ((TextView) inflate.findViewById(g.title)).setText(this.p.G());
            ((TextView) inflate.findViewById(g.desc)).setText(this.p.q());
            Button button = (Button) inflate.findViewById(g.download);
            if (this.p.h() == 1) {
                button.setText(this.o.getResources().getString(i.see_detail));
            }
            if (this.p.h() == 2) {
                button.setText(this.o.getResources().getString(i.down_immediately));
            }
            this.l.setOnClickListener(this.E);
            button.setOnClickListener(this.E);
        }
        this.f45726d = this.f45725c.getPlayer();
        u();
    }

    public void w() {
        d.a.h0.a.b1.g.a aVar = this.f45726d;
        if (aVar != null) {
            this.f45727e = aVar.j();
        }
    }

    public void x() {
        G();
    }

    public void y() {
        m();
        G();
    }

    public void z() {
        m();
        G();
    }
}
