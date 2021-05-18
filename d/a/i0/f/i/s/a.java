package d.a.i0.f.i.s;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
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
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.view.InteractiveEndFrameView;
import com.baidu.swan.game.ad.view.RewardLoadWebView;
import com.baidu.swan.game.ad.view.RewardVideoView;
import d.a.i0.f.i.r.h;
import d.a.i0.f.i.r.i;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public abstract class a {
    public d.a.i0.f.i.o.b A;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f46658a;

    /* renamed from: b  reason: collision with root package name */
    public View f46659b;

    /* renamed from: c  reason: collision with root package name */
    public RewardVideoView f46660c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.f.i.m.b.c f46661d;

    /* renamed from: e  reason: collision with root package name */
    public int f46662e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f46663f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f46664g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f46665h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46666i;
    public TextView j;
    public View k;
    public TextView l;
    public RelativeLayout m;
    public Context p;
    public AdElementInfo q;
    public d.a.i0.f.i.l.c s;
    public RewardLoadWebView t;
    public RewardLoadWebView u;
    public InteractiveEndFrameView v;
    public Resources w;
    public d.a.i0.f.i.n.a x;
    public d.a.i0.f.i.l.d z;
    public final Handler r = new Handler();
    public boolean B = false;
    public Runnable C = new b();
    public View.OnClickListener D = new c();
    public View.OnClickListener E = new d();
    public View.OnClickListener F = new e();
    public int n = d.a.i0.f.i.m.a.b().q();
    public int o = d.a.i0.f.i.m.a.b().p();
    public boolean y = i.i();

    /* renamed from: d.a.i0.f.i.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC0977a implements View.OnTouchListener {
        public View$OnTouchListenerC0977a(a aVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46661d != null) {
                a.this.K();
                int currentPosition = a.this.f46661d.getCurrentPosition();
                a aVar = a.this;
                aVar.J(aVar.f46662e, currentPosition);
                int min = Math.min(currentPosition + 1000, a.this.f46662e);
                a.this.f46663f.setProgress(min / 1000);
                if (min < a.this.f46662e) {
                    a.this.r.postDelayed(a.this.C, 100L);
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
            if (a.this.f46660c == null) {
                return;
            }
            if (a.this.f46660c.d()) {
                a.this.f46665h.setImageResource(d.a.i0.f.i.d.ng_game_vol_open);
                a.this.f46660c.e(false);
                return;
            }
            a.this.f46665h.setImageResource(d.a.i0.f.i.d.ng_game_vol_close);
            a.this.f46660c.e(true);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s != null) {
                a.this.s.e(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.z != null) {
                a.this.z.f(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements RewardVideoView.a {
        public f() {
        }

        @Override // com.baidu.swan.game.ad.view.RewardVideoView.a
        public void onVolumeChanged(int i2) {
            int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? ((AudioManager) a.this.p.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getStreamMinVolume(3) : 0;
            if (i2 <= streamMinVolume || !a.this.f46660c.d()) {
                if (i2 > streamMinVolume || a.this.f46660c.d()) {
                    return;
                }
                a.this.f46665h.setImageResource(d.a.i0.f.i.d.ng_game_vol_close);
                a.this.f46660c.e(true);
                return;
            }
            a.this.f46665h.setImageResource(d.a.i0.f.i.d.ng_game_vol_open);
            a.this.f46660c.e(false);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f46672e;

        public g(a aVar, View view) {
            this.f46672e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            int n = d.a.i0.f.i.m.a.b().n();
            if (d.a.i0.f.i.m.a.b().w(this.f46672e)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f46672e.getLayoutParams();
                layoutParams.topMargin = this.f46672e.getTop() + n;
                this.f46672e.setLayoutParams(layoutParams);
            }
        }
    }

    public a(Context context, AdElementInfo adElementInfo, d.a.i0.f.i.n.a aVar) {
        this.p = context;
        this.q = adElementInfo;
        this.w = this.p.getResources();
        this.x = aVar;
        w();
        this.A = new d.a.i0.f.i.o.b(this.p);
        x(this.f46664g);
    }

    public void A() {
        m();
        I();
    }

    public void B() {
        m();
        I();
    }

    public abstract void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo);

    public void D() {
        H();
    }

    public void E(d.a.i0.f.i.l.c cVar) {
        this.s = cVar;
    }

    public void F(d.a.i0.f.i.l.d dVar) {
        this.z = dVar;
    }

    public void G(String str) {
        RewardVideoView rewardVideoView = this.f46660c;
        if (rewardVideoView != null) {
            rewardVideoView.f(str);
        }
    }

    public final void H() {
        if (this.f46663f != null) {
            this.r.removeCallbacksAndMessages(null);
            this.r.postDelayed(this.C, 0L);
        }
    }

    public final void I() {
        if (this.f46663f != null) {
            this.r.removeCallbacksAndMessages(null);
        }
    }

    public final void J(long j, int i2) {
        if (this.y) {
            if (j <= 15000 || i2 > 15000) {
                this.j.setText(d.a.i0.f.i.g.swangame_game_ad_reward_tip);
                this.f46666i.setVisibility(0);
                this.k.setVisibility(0);
                this.j.setVisibility(0);
            } else if (i2 < 5000) {
                this.f46664g.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.f46666i.setVisibility(8);
            } else if (i2 < 10000) {
                this.f46664g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                this.f46666i.setVisibility(8);
            } else {
                this.f46664g.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.f46666i.setVisibility(0);
            }
        }
    }

    public final void K() {
        d.a.i0.f.i.m.b.c cVar;
        if (this.q == null || (cVar = this.f46661d) == null) {
            return;
        }
        this.f46662e = cVar.getDuration();
        int min = Math.min(this.q.A(), this.f46662e / 1000);
        int B = this.q.B();
        int currentPosition = this.f46661d.getCurrentPosition() / 1000;
        String string = this.p.getResources().getString(d.a.i0.f.i.g.swangame_game_ad_video_reward_time_surplus);
        String string2 = this.p.getResources().getString(d.a.i0.f.i.g.swangame_game_ad_video_time_surplus);
        if (currentPosition <= min) {
            this.j.setText(String.format(string, Integer.valueOf(min - currentPosition)));
        } else {
            this.j.setText(String.format(string2, Integer.valueOf((this.f46662e / 1000) - currentPosition)));
        }
        if (currentPosition <= B) {
            this.f46666i.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.f46666i.setVisibility(0);
        this.k.setVisibility(0);
    }

    public final void l() {
        TextView textView = new TextView(this.p);
        this.l = textView;
        textView.setBackground(this.w.getDrawable(d.a.i0.f.i.d.ng_game_bg_close_ad));
        this.l.setTextColor(this.w.getColor(d.a.i0.f.i.b.close_ad_text_color));
        this.l.setText(this.w.getString(d.a.i0.f.i.g.close_ad_des));
        this.l.setTextSize(2, 16.0f);
        this.l.setOnClickListener(this.E);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h.a(96.0f), h.a(30.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.addRule(13);
        this.l.setGravity(17);
        layoutParams.setMargins(0, this.f46664g.getTop(), this.w.getDimensionPixelSize(d.a.i0.f.i.c.include_land_close_ad_margin), 0);
        this.f46658a.addView(this.l, layoutParams);
        x(this.l);
    }

    public final void m() {
        if (this.f46658a != null) {
            this.B = true;
            this.f46664g.setVisibility(4);
            this.m.setVisibility(4);
            this.f46666i.setVisibility(4);
            if (!TextUtils.isEmpty(this.q.t())) {
                InteractiveEndFrameView interactiveEndFrameView = new InteractiveEndFrameView(this.p);
                this.v = interactiveEndFrameView;
                interactiveEndFrameView.s(this.q, this.f46658a);
                this.f46658a.addView(this.v, new RelativeLayout.LayoutParams(-1, -1));
                d.a.i0.f.i.q.b.i(this.q, this.A);
            } else if (!TextUtils.isEmpty(this.q.s())) {
                RewardLoadWebView rewardLoadWebView = new RewardLoadWebView(this.p);
                this.u = rewardLoadWebView;
                rewardLoadWebView.b("reward_end_frame_html", this.q, this.x);
                this.f46658a.addView(this.u, new RelativeLayout.LayoutParams(-1, -1));
                d.a.i0.f.i.q.b.i(this.q, this.A);
            } else {
                View inflate = LayoutInflater.from(this.p).inflate(d.a.i0.f.i.f.ng_game_reward_close_banner, (ViewGroup) null);
                this.f46658a.addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
                ((AdImageVIew) inflate.findViewById(d.a.i0.f.i.e.reward_icon)).setImageUrl(this.q.v());
                ((TextView) inflate.findViewById(d.a.i0.f.i.e.title)).setText(this.q.G());
                ((TextView) inflate.findViewById(d.a.i0.f.i.e.desc)).setText(this.q.q());
                Button button = (Button) inflate.findViewById(d.a.i0.f.i.e.download);
                if (this.q.h() == 1) {
                    button.setText(this.p.getResources().getString(d.a.i0.f.i.g.see_detail));
                }
                if (this.q.h() == 2) {
                    button.setText(this.p.getResources().getString(d.a.i0.f.i.g.swanapp_ad_download_button));
                }
                inflate.findViewById(d.a.i0.f.i.e.content_des).setOnClickListener(this.F);
                button.setOnClickListener(this.F);
            }
            l();
        }
    }

    public void n() {
        I();
        RewardLoadWebView rewardLoadWebView = this.t;
        if (rewardLoadWebView != null) {
            rewardLoadWebView.c();
            this.t = null;
        }
        RewardLoadWebView rewardLoadWebView2 = this.u;
        if (rewardLoadWebView2 != null) {
            rewardLoadWebView2.c();
            this.u = null;
        }
        InteractiveEndFrameView interactiveEndFrameView = this.v;
        if (interactiveEndFrameView != null) {
            interactiveEndFrameView.t();
            this.v = null;
        }
    }

    public RewardVideoView.a o() {
        return new f();
    }

    public void p() {
        AdElementInfo adElementInfo;
        d.a.i0.f.i.m.b.c cVar;
        H();
        ProgressBar progressBar = this.f46663f;
        if (progressBar != null && (cVar = this.f46661d) != null) {
            progressBar.setMax(cVar.getDuration() / 1000);
            this.f46663f.setVisibility(4);
        }
        if (this.j != null && this.f46661d != null && (adElementInfo = this.q) != null) {
            this.j.setText(String.format(this.p.getResources().getString(d.a.i0.f.i.g.swangame_game_ad_video_reward_time_surplus), Integer.valueOf(Math.max(this.q.B(), Math.min(adElementInfo.A(), this.f46661d.getDuration())) / 1000)));
            if (this.q.B() >= 0) {
                this.f46666i.setVisibility(8);
                this.k.setVisibility(8);
            }
        }
        if (this.f46664g.getVisibility() != 0) {
            this.f46664g.setVisibility(0);
        }
        if (this.m.getVisibility() != 0) {
            this.m.setAnimation(AnimationUtils.loadAnimation(this.p, d.a.i0.f.i.a.ng_game_ad_open));
            this.m.setVisibility(0);
        }
        d.a.i0.f.i.m.b.c cVar2 = this.f46661d;
        if (cVar2 != null) {
            J(cVar2.getDuration(), this.f46661d.getCurrentPosition());
        }
    }

    public abstract String q();

    public View r() {
        return this.f46659b;
    }

    public d.a.i0.f.i.m.b.c s() {
        RewardVideoView rewardVideoView = this.f46660c;
        if (rewardVideoView != null) {
            return rewardVideoView.getPlayer();
        }
        return null;
    }

    public boolean t() {
        return this.B;
    }

    public abstract View u();

    public final void v() {
        this.f46658a.setOnTouchListener(new View$OnTouchListenerC0977a(this));
        this.f46665h.setOnClickListener(this.D);
        this.f46666i.setOnClickListener(this.E);
    }

    public final void w() {
        this.f46659b = u();
        this.f46659b.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o));
        this.f46658a = (RelativeLayout) this.f46659b.findViewById(d.a.i0.f.i.e.reward_relative);
        RewardVideoView rewardVideoView = (RewardVideoView) this.f46659b.findViewById(d.a.i0.f.i.e.video_view);
        this.f46660c = rewardVideoView;
        rewardVideoView.setVolumeChangeListener(o());
        if (this.y) {
            this.f46660c.setOnClickListener(this.F);
        }
        this.f46663f = (ProgressBar) this.f46659b.findViewById(d.a.i0.f.i.e.swangame_game_ad_video_progress_horizontal);
        this.f46664g = (LinearLayout) this.f46659b.findViewById(d.a.i0.f.i.e.vol_clo);
        this.f46665h = (ImageView) this.f46659b.findViewById(d.a.i0.f.i.e.volume);
        if (this.f46660c.d()) {
            this.f46665h.setImageResource(d.a.i0.f.i.d.ng_game_vol_close);
        }
        this.f46666i = (TextView) this.f46659b.findViewById(d.a.i0.f.i.e.close_ad);
        this.j = (TextView) this.f46659b.findViewById(d.a.i0.f.i.e.close_ad_header);
        this.k = this.f46659b.findViewById(d.a.i0.f.i.e.close_ad_middle);
        this.m = (RelativeLayout) this.f46659b.findViewById(d.a.i0.f.i.e.banner);
        if (!TextUtils.isEmpty(this.q.k())) {
            this.t = new RewardLoadWebView(this.p);
            this.m.addView(this.t, new RelativeLayout.LayoutParams(-1, -1));
            C(this.m, this.q);
            this.t.b(q(), this.q, this.x);
        } else {
            View inflate = LayoutInflater.from(this.p).inflate(d.a.i0.f.i.f.ng_game_reward_banner, (ViewGroup) null);
            this.m.addView(inflate);
            ((AdImageVIew) inflate.findViewById(d.a.i0.f.i.e.reward_icon)).setImageUrl(this.q.v());
            ((TextView) inflate.findViewById(d.a.i0.f.i.e.title)).setText(this.q.G());
            ((TextView) inflate.findViewById(d.a.i0.f.i.e.desc)).setText(this.q.q());
            Button button = (Button) inflate.findViewById(d.a.i0.f.i.e.download);
            if (this.q.h() == 1) {
                button.setText(this.p.getResources().getString(d.a.i0.f.i.g.see_detail));
            }
            if (this.q.h() == 2) {
                button.setText(this.p.getResources().getString(d.a.i0.f.i.g.swanapp_ad_download_button));
            }
            this.m.setOnClickListener(this.F);
            button.setOnClickListener(this.F);
        }
        this.f46661d = this.f46660c.getPlayer();
        v();
    }

    public final void x(View view) {
        view.post(new g(this, view));
    }

    public void y() {
        d.a.i0.f.i.m.b.c cVar = this.f46661d;
        if (cVar != null) {
            this.f46662e = cVar.getDuration();
        }
    }

    public void z() {
        I();
    }
}
