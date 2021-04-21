package d.b.h0.e.a;

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
import d.b.h0.a.i2.h0;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f48272a;

    /* renamed from: b  reason: collision with root package name */
    public View f48273b;

    /* renamed from: c  reason: collision with root package name */
    public RewardVideoView f48274c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.b1.g.a f48275d;

    /* renamed from: e  reason: collision with root package name */
    public int f48276e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f48277f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f48278g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f48279h;
    public TextView i;
    public TextView j;
    public View k;
    public RelativeLayout l;
    public Context o;
    public AdElementInfo p;
    public d.b.h0.e.a.m.c r;
    public RewardLoadWebView s;
    public RewardLoadWebView t;
    public InteractiveEndFrameView u;
    public Resources v;
    public d.b.h0.e.a.n.a w;
    public d.b.h0.e.a.m.d y;
    public d.b.h0.e.a.r.b z;
    public final Handler q = new Handler();
    public boolean A = false;
    public Runnable B = new RunnableC0960b();
    public View.OnClickListener C = new c();
    public View.OnClickListener D = new d();
    public View.OnClickListener E = new e();
    public int m = d.b.h0.g.k0.e.c.c();
    public int n = d.b.h0.g.k0.e.c.b();
    public boolean x = d.b.h0.e.a.q.f.i();

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a(b bVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: d.b.h0.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0960b implements Runnable {
        public RunnableC0960b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f48275d != null) {
                b.this.I();
                int i = b.this.f48275d.i();
                b bVar = b.this;
                bVar.H(bVar.f48276e, i);
                int min = Math.min(i + 1000, b.this.f48276e);
                b.this.f48277f.setProgress(min / 1000);
                if (min < b.this.f48276e) {
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
            if (b.this.f48274c == null) {
                return;
            }
            if (b.this.f48274c.c()) {
                b.this.f48279h.setImageResource(f.ng_game_vol_open);
                b.this.f48274c.d(false);
                return;
            }
            b.this.f48279h.setImageResource(f.ng_game_vol_close);
            b.this.f48274c.d(true);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.r != null) {
                b.this.r.b(view);
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
                b.this.y.d(view);
            }
        }
    }

    public b(Context context, AdElementInfo adElementInfo, d.b.h0.e.a.n.a aVar) {
        this.o = context;
        this.p = adElementInfo;
        this.v = this.o.getResources();
        this.w = aVar;
        v();
        this.z = new d.b.h0.e.a.r.b(this.o);
    }

    public abstract void A(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public void B() {
        F();
    }

    public void C(d.b.h0.e.a.m.c cVar) {
        this.r = cVar;
    }

    public void D(d.b.h0.e.a.m.d dVar) {
        this.y = dVar;
    }

    public void E(String str) {
        RewardVideoView rewardVideoView = this.f48274c;
        if (rewardVideoView != null) {
            rewardVideoView.e(str);
        }
    }

    public final void F() {
        if (this.f48277f != null) {
            this.q.removeCallbacksAndMessages(null);
            this.q.postDelayed(this.B, 0L);
        }
    }

    public final void G() {
        if (this.f48277f != null) {
            this.q.removeCallbacksAndMessages(null);
        }
    }

    public final void H(long j, int i) {
        if (this.x) {
            if (j <= 15000 || i > 15000) {
                this.j.setText(i.swangame_game_ad_reward_tip);
                this.i.setVisibility(0);
                this.k.setVisibility(0);
                this.j.setVisibility(0);
            } else if (i < 5000) {
                this.f48278g.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.i.setVisibility(8);
            } else if (i < 10000) {
                this.f48278g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                this.i.setVisibility(8);
            } else {
                this.f48278g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.i.setVisibility(0);
            }
        }
    }

    public final void I() {
        d.b.h0.a.b1.g.a aVar;
        if (this.p == null || (aVar = this.f48275d) == null) {
            return;
        }
        this.f48276e = aVar.j();
        int min = Math.min(this.p.A(), this.f48276e / 1000);
        int B = this.p.B();
        int i = this.f48275d.i() / 1000;
        String string = this.o.getResources().getString(i.swangame_game_ad_video_reward_time_surplus);
        String string2 = this.o.getResources().getString(i.swangame_game_ad_video_time_surplus);
        if (i <= min) {
            this.j.setText(String.format(string, Integer.valueOf(min - i)));
        } else {
            this.j.setText(String.format(string2, Integer.valueOf((this.f48276e / 1000) - i)));
        }
        if (i <= B) {
            this.i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        TextView textView = new TextView(this.o);
        textView.setBackground(this.v.getDrawable(f.ng_game_bg_close_ad));
        textView.setTextColor(this.v.getColor(d.b.h0.e.a.d.close_ad_text_color));
        textView.setText(this.v.getString(i.close_ad_des));
        textView.setTextSize(2, 16.0f);
        textView.setOnClickListener(this.D);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h0.e(this.o, 96.0f), h0.e(this.o, 30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        textView.setGravity(17);
        layoutParams.setMargins(0, this.v.getDimensionPixelSize(d.b.h0.e.a.e.include_land_close_ad_margin), this.v.getDimensionPixelSize(d.b.h0.e.a.e.include_land_close_ad_margin), 0);
        this.f48272a.addView(textView, layoutParams);
    }

    public final void m() {
        if (this.f48272a != null) {
            this.A = true;
            this.f48278g.setVisibility(4);
            this.l.setVisibility(4);
            this.i.setVisibility(4);
            if (!TextUtils.isEmpty(this.p.t())) {
                InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.o);
                this.u = interactiveEndFrameView;
                interactiveEndFrameView.s(this.p, this.f48272a);
                this.f48272a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
                d.b.h0.e.a.p.c.f(this.p, this.z);
            } else if (!TextUtils.isEmpty(this.p.s())) {
                RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.o);
                this.t = rewardLoadWebView;
                rewardLoadWebView.b("reward_end_frame_html", this.p, this.w);
                this.f48272a.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
                d.b.h0.e.a.p.c.f(this.p, this.z);
            } else {
                View inflate = LayoutInflater.from(this.o).inflate(h.ng_game_reward_close_banner, (ViewGroup) null);
                this.f48272a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
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
        d.b.h0.a.b1.g.a aVar;
        F();
        ProgressBar progressBar = this.f48277f;
        if (progressBar != null && (aVar = this.f48275d) != null) {
            progressBar.setMax(aVar.j() / 1000);
            this.f48277f.setVisibility(4);
        }
        if (this.j != null && this.f48275d != null && (adElementInfo = this.p) != null) {
            this.j.setText(String.format(this.o.getResources().getString(i.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.p.B(), Math.min(adElementInfo.A(), this.f48275d.j())) / 1000)));
            if (this.p.B() >= 0) {
                this.i.setVisibility(8);
                this.k.setVisibility(8);
            }
        }
        if (this.f48278g.getVisibility() != 0) {
            this.f48278g.setVisibility(0);
        }
        if (this.l.getVisibility() != 0) {
            this.l.setAnimation(AnimationUtils.loadAnimation(this.o, d.b.h0.e.a.c.ng_game_ad_open));
            this.l.setVisibility(0);
        }
        d.b.h0.a.b1.g.a aVar2 = this.f48275d;
        if (aVar2 != null) {
            H(aVar2.j(), this.f48275d.i());
        }
    }

    public abstract String p();

    public View q() {
        return this.f48273b;
    }

    public d.b.h0.a.b1.g.a r() {
        RewardVideoView rewardVideoView = this.f48274c;
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
        this.f48272a.setOnTouchListener(new a(this));
        this.f48279h.setOnClickListener(this.C);
        this.i.setOnClickListener(this.D);
    }

    public final void v() {
        this.f48273b = t();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.m, this.n);
        this.f48273b.setLayoutParams(layoutParams);
        this.f48272a = (RelativeLayout) this.f48273b.findViewById(g.reward_relative);
        RewardVideoView rewardVideoView = (RewardVideoView) this.f48273b.findViewById(g.video_view);
        this.f48274c = rewardVideoView;
        rewardVideoView.setLayoutParams(layoutParams);
        if (this.x) {
            this.f48274c.setOnClickListener(this.E);
        }
        this.f48277f = (ProgressBar) this.f48273b.findViewById(g.swangame_game_ad_video_progress_horizontal);
        this.f48278g = (LinearLayout) this.f48273b.findViewById(g.vol_clo);
        this.f48279h = (ImageView) this.f48273b.findViewById(g.volume);
        this.i = (TextView) this.f48273b.findViewById(g.close_ad);
        this.j = (TextView) this.f48273b.findViewById(g.close_ad_header);
        this.k = this.f48273b.findViewById(g.close_ad_middle);
        this.l = (RelativeLayout) this.f48273b.findViewById(g.banner);
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
        this.f48275d = this.f48274c.getPlayer();
        u();
    }

    public void w() {
        d.b.h0.a.b1.g.a aVar = this.f48275d;
        if (aVar != null) {
            this.f48276e = aVar.j();
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
