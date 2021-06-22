package d.a.o0.u3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.s.c.j0;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public LogoActivity f65219a;

    /* renamed from: b  reason: collision with root package name */
    public View f65220b;

    /* renamed from: c  reason: collision with root package name */
    public View f65221c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f65222d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65223e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f65224f;

    /* renamed from: g  reason: collision with root package name */
    public g f65225g;
    public int j;
    public boolean k = true;
    public Runnable l = new a();

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.u3.a f65226h = new d.a.o0.u3.a();

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.u3.c f65227i = new d.a.o0.u3.c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f65225g != null) {
                d.this.f65225g.onError();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            d.a.c.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f65225g != null) {
                d.this.k = false;
                d.this.f65225g.onError();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            d.a.c.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f65225g != null) {
                d.this.k = false;
                d.this.f65225g.onSkip();
            }
        }
    }

    /* renamed from: d.a.o0.u3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1698d implements MediaPlayer.OnPreparedListener {

        /* renamed from: d.a.o0.u3.d$d$a */
        /* loaded from: classes5.dex */
        public class a implements MediaPlayer.OnInfoListener {
            public a() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                if (i2 == 3) {
                    d.this.l();
                    return false;
                }
                return false;
            }
        }

        public C1698d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.a.c.e.m.e.a().removeCallbacks(d.this.l);
            d.this.f65224f.setMediaPlayer(mediaPlayer);
            mediaPlayer.setOnInfoListener(new a());
            d.this.q();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f65225g != null) {
                d.this.k = false;
                d.this.f65225g.onSkip();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65234e;

        public f(String str) {
            this.f65234e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12945"));
            if (k.isEmpty(this.f65234e)) {
                return;
            }
            d.this.k = false;
            d.this.f65225g.onSkip();
            UrlManager.getInstance().dealOneLink(d.this.f65219a.getPageContext(), new String[]{this.f65234e});
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onError();

        void onSkip();
    }

    public d(LogoActivity logoActivity) {
        this.j = 0;
        this.f65219a = logoActivity;
        this.j = 0;
    }

    public boolean h() {
        d.a.o0.u3.a aVar;
        return (d.a.n0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f65226h) != null && this.f65227i != null && aVar.b() && this.f65227i.l();
    }

    public void i() {
        if (d.a.n0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) {
            return;
        }
        d.a.o0.u3.c cVar = this.f65227i;
        if (cVar != null) {
            cVar.g();
        }
        d.a.n0.r.d0.b.j().w("key_video_splash_last_show_time", 0L);
    }

    public final View j(double d2) {
        View inflate = LayoutInflater.from(this.f65219a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f65219a) * d2)));
        ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.f65224f = scaleVideoView;
        scaleVideoView.setOnErrorListener(new b());
        this.f65224f.setOnCompletionListener(new c());
        this.f65224f.setOnPreparedListener(new C1698d());
        TextView textView = (TextView) inflate.findViewById(R.id.skip);
        this.f65223e = textView;
        textView.setOnClickListener(new e());
        String p = d.a.n0.r.d0.b.j().p("key_video_splash_config", "");
        j0 j0Var = new j0();
        j0Var.g(p);
        String c2 = j0Var.c();
        View findViewById = inflate.findViewById(R.id.tip_container);
        this.f65221c = findViewById;
        findViewById.setOnClickListener(new f(c2));
        this.f65222d = (TextView) inflate.findViewById(R.id.tip_text);
        String b2 = j0Var.b();
        if (k.isEmpty(b2)) {
            b2 = this.f65219a.getString(R.string.video_splash_tip_default);
        }
        this.f65222d.setText(b2);
        s();
        return inflate;
    }

    public View k(double d2) {
        if (this.f65220b == null) {
            this.f65220b = j(d2);
        }
        return this.f65220b;
    }

    public final void l() {
        ScaleVideoView scaleVideoView = this.f65224f;
        if (scaleVideoView != null) {
            scaleVideoView.setBackgroundResource(0);
        }
    }

    public final void m() {
        d.a.o0.u3.c cVar = this.f65227i;
        if (cVar == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f65224f.setVideoPath(this.f65227i.i());
    }

    public void n() {
        d.a.c.e.m.e.a().removeCallbacks(this.l);
    }

    public void o() {
        ScaleVideoView scaleVideoView = this.f65224f;
        if (scaleVideoView != null) {
            this.j = scaleVideoView.getCurrentPosition();
            this.f65224f.stopPlayback();
            if (this.k) {
                s();
            }
        }
    }

    public void p() {
        this.k = true;
        ScaleVideoView scaleVideoView = this.f65224f;
        if (scaleVideoView != null) {
            scaleVideoView.resume();
        }
    }

    public final void q() {
        d.a.o0.u3.a aVar = this.f65226h;
        if (aVar != null) {
            aVar.g(System.currentTimeMillis());
        }
        int i2 = this.j;
        if (i2 >= 0) {
            this.f65224f.seekTo(i2);
        }
        this.f65224f.start();
    }

    public void r(g gVar) {
        this.f65225g = gVar;
    }

    public final void s() {
        d.a.o0.u3.c cVar = this.f65227i;
        if (cVar == null || !cVar.l()) {
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f65227i.i());
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
            if (this.f65224f != null) {
                this.f65224f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            ScaleVideoView scaleVideoView = this.f65224f;
            if (scaleVideoView != null) {
                scaleVideoView.setBackgroundColor(this.f65219a.getResources().getColor(R.color.CAM_X0101));
            }
        }
    }

    public void t() {
        TiebaStatic.log(new StatisticItem("c12944"));
        d.a.c.e.m.e.a().postDelayed(this.l, 1000L);
        m();
    }
}
