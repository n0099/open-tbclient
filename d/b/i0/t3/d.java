package d.b.i0.t3;

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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.s.c.i0;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public LogoActivity f62622a;

    /* renamed from: b  reason: collision with root package name */
    public View f62623b;

    /* renamed from: c  reason: collision with root package name */
    public View f62624c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62625d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62626e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f62627f;

    /* renamed from: g  reason: collision with root package name */
    public g f62628g;
    public int j;
    public boolean k = true;
    public Runnable l = new a();

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t3.a f62629h = new d.b.i0.t3.a();
    public d.b.i0.t3.c i = new d.b.i0.t3.c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f62628g != null) {
                d.this.f62628g.onError();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            d.b.c.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f62628g != null) {
                d.this.k = false;
                d.this.f62628g.onError();
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
            d.b.c.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f62628g != null) {
                d.this.k = false;
                d.this.f62628g.onSkip();
            }
        }
    }

    /* renamed from: d.b.i0.t3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1634d implements MediaPlayer.OnPreparedListener {

        /* renamed from: d.b.i0.t3.d$d$a */
        /* loaded from: classes5.dex */
        public class a implements MediaPlayer.OnInfoListener {
            public a() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 3) {
                    d.this.l();
                    return false;
                }
                return false;
            }
        }

        public C1634d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.b.c.e.m.e.a().removeCallbacks(d.this.l);
            d.this.f62627f.setMediaPlayer(mediaPlayer);
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
            d.b.c.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f62628g != null) {
                d.this.k = false;
                d.this.f62628g.onSkip();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62636e;

        public f(String str) {
            this.f62636e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12945"));
            if (k.isEmpty(this.f62636e)) {
                return;
            }
            d.this.k = false;
            d.this.f62628g.onSkip();
            UrlManager.getInstance().dealOneLink(d.this.f62622a.getPageContext(), new String[]{this.f62636e});
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onError();

        void onSkip();
    }

    public d(LogoActivity logoActivity) {
        this.j = 0;
        this.f62622a = logoActivity;
        this.j = 0;
    }

    public boolean h() {
        d.b.i0.t3.a aVar;
        return (d.b.h0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f62629h) != null && this.i != null && aVar.b() && this.i.l();
    }

    public void i() {
        if (d.b.h0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) {
            return;
        }
        d.b.i0.t3.c cVar = this.i;
        if (cVar != null) {
            cVar.g();
        }
        d.b.h0.r.d0.b.j().w("key_video_splash_last_show_time", 0L);
    }

    public final View j(double d2) {
        View inflate = LayoutInflater.from(this.f62622a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f62622a) * d2)));
        ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.f62627f = scaleVideoView;
        scaleVideoView.setOnErrorListener(new b());
        this.f62627f.setOnCompletionListener(new c());
        this.f62627f.setOnPreparedListener(new C1634d());
        TextView textView = (TextView) inflate.findViewById(R.id.skip);
        this.f62626e = textView;
        textView.setOnClickListener(new e());
        String p = d.b.h0.r.d0.b.j().p("key_video_splash_config", "");
        i0 i0Var = new i0();
        i0Var.g(p);
        String c2 = i0Var.c();
        View findViewById = inflate.findViewById(R.id.tip_container);
        this.f62624c = findViewById;
        findViewById.setOnClickListener(new f(c2));
        this.f62625d = (TextView) inflate.findViewById(R.id.tip_text);
        String b2 = i0Var.b();
        if (k.isEmpty(b2)) {
            b2 = this.f62622a.getString(R.string.video_splash_tip_default);
        }
        this.f62625d.setText(b2);
        s();
        return inflate;
    }

    public View k(double d2) {
        if (this.f62623b == null) {
            this.f62623b = j(d2);
        }
        return this.f62623b;
    }

    public final void l() {
        ScaleVideoView scaleVideoView = this.f62627f;
        if (scaleVideoView != null) {
            scaleVideoView.setBackgroundResource(0);
        }
    }

    public final void m() {
        d.b.i0.t3.c cVar = this.i;
        if (cVar == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f62627f.setVideoPath(this.i.i());
    }

    public void n() {
        d.b.c.e.m.e.a().removeCallbacks(this.l);
    }

    public void o() {
        ScaleVideoView scaleVideoView = this.f62627f;
        if (scaleVideoView != null) {
            this.j = scaleVideoView.getCurrentPosition();
            this.f62627f.stopPlayback();
            if (this.k) {
                s();
            }
        }
    }

    public void p() {
        this.k = true;
        ScaleVideoView scaleVideoView = this.f62627f;
        if (scaleVideoView != null) {
            scaleVideoView.resume();
        }
    }

    public final void q() {
        d.b.i0.t3.a aVar = this.f62629h;
        if (aVar != null) {
            aVar.g(System.currentTimeMillis());
        }
        int i = this.j;
        if (i >= 0) {
            this.f62627f.seekTo(i);
        }
        this.f62627f.start();
    }

    public void r(g gVar) {
        this.f62628g = gVar;
    }

    public final void s() {
        d.b.i0.t3.c cVar = this.i;
        if (cVar == null || !cVar.l()) {
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.i.i());
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
            if (this.f62627f != null) {
                this.f62627f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            ScaleVideoView scaleVideoView = this.f62627f;
            if (scaleVideoView != null) {
                scaleVideoView.setBackgroundColor(this.f62622a.getResources().getColor(R.color.CAM_X0101));
            }
        }
    }

    public void t() {
        TiebaStatic.log(new StatisticItem("c12944"));
        d.b.c.e.m.e.a().postDelayed(this.l, 1000L);
        m();
    }
}
