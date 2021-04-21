package d.b.j0.t3;

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
import d.b.i0.s.c.i0;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public LogoActivity f63043a;

    /* renamed from: b  reason: collision with root package name */
    public View f63044b;

    /* renamed from: c  reason: collision with root package name */
    public View f63045c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63046d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63047e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f63048f;

    /* renamed from: g  reason: collision with root package name */
    public g f63049g;
    public int j;
    public boolean k = true;
    public Runnable l = new a();

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.t3.a f63050h = new d.b.j0.t3.a();
    public d.b.j0.t3.c i = new d.b.j0.t3.c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63049g != null) {
                d.this.f63049g.onError();
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
            if (d.this.f63049g != null) {
                d.this.k = false;
                d.this.f63049g.onError();
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
            if (d.this.f63049g != null) {
                d.this.k = false;
                d.this.f63049g.onSkip();
            }
        }
    }

    /* renamed from: d.b.j0.t3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1657d implements MediaPlayer.OnPreparedListener {

        /* renamed from: d.b.j0.t3.d$d$a */
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

        public C1657d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.b.c.e.m.e.a().removeCallbacks(d.this.l);
            d.this.f63048f.setMediaPlayer(mediaPlayer);
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
            if (d.this.f63049g != null) {
                d.this.k = false;
                d.this.f63049g.onSkip();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63057e;

        public f(String str) {
            this.f63057e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12945"));
            if (k.isEmpty(this.f63057e)) {
                return;
            }
            d.this.k = false;
            d.this.f63049g.onSkip();
            UrlManager.getInstance().dealOneLink(d.this.f63043a.getPageContext(), new String[]{this.f63057e});
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onError();

        void onSkip();
    }

    public d(LogoActivity logoActivity) {
        this.j = 0;
        this.f63043a = logoActivity;
        this.j = 0;
    }

    public boolean h() {
        d.b.j0.t3.a aVar;
        return (d.b.i0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f63050h) != null && this.i != null && aVar.b() && this.i.l();
    }

    public void i() {
        if (d.b.i0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) {
            return;
        }
        d.b.j0.t3.c cVar = this.i;
        if (cVar != null) {
            cVar.g();
        }
        d.b.i0.r.d0.b.j().w("key_video_splash_last_show_time", 0L);
    }

    public final View j(double d2) {
        View inflate = LayoutInflater.from(this.f63043a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f63043a) * d2)));
        ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.f63048f = scaleVideoView;
        scaleVideoView.setOnErrorListener(new b());
        this.f63048f.setOnCompletionListener(new c());
        this.f63048f.setOnPreparedListener(new C1657d());
        TextView textView = (TextView) inflate.findViewById(R.id.skip);
        this.f63047e = textView;
        textView.setOnClickListener(new e());
        String p = d.b.i0.r.d0.b.j().p("key_video_splash_config", "");
        i0 i0Var = new i0();
        i0Var.g(p);
        String c2 = i0Var.c();
        View findViewById = inflate.findViewById(R.id.tip_container);
        this.f63045c = findViewById;
        findViewById.setOnClickListener(new f(c2));
        this.f63046d = (TextView) inflate.findViewById(R.id.tip_text);
        String b2 = i0Var.b();
        if (k.isEmpty(b2)) {
            b2 = this.f63043a.getString(R.string.video_splash_tip_default);
        }
        this.f63046d.setText(b2);
        s();
        return inflate;
    }

    public View k(double d2) {
        if (this.f63044b == null) {
            this.f63044b = j(d2);
        }
        return this.f63044b;
    }

    public final void l() {
        ScaleVideoView scaleVideoView = this.f63048f;
        if (scaleVideoView != null) {
            scaleVideoView.setBackgroundResource(0);
        }
    }

    public final void m() {
        d.b.j0.t3.c cVar = this.i;
        if (cVar == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f63048f.setVideoPath(this.i.i());
    }

    public void n() {
        d.b.c.e.m.e.a().removeCallbacks(this.l);
    }

    public void o() {
        ScaleVideoView scaleVideoView = this.f63048f;
        if (scaleVideoView != null) {
            this.j = scaleVideoView.getCurrentPosition();
            this.f63048f.stopPlayback();
            if (this.k) {
                s();
            }
        }
    }

    public void p() {
        this.k = true;
        ScaleVideoView scaleVideoView = this.f63048f;
        if (scaleVideoView != null) {
            scaleVideoView.resume();
        }
    }

    public final void q() {
        d.b.j0.t3.a aVar = this.f63050h;
        if (aVar != null) {
            aVar.g(System.currentTimeMillis());
        }
        int i = this.j;
        if (i >= 0) {
            this.f63048f.seekTo(i);
        }
        this.f63048f.start();
    }

    public void r(g gVar) {
        this.f63049g = gVar;
    }

    public final void s() {
        d.b.j0.t3.c cVar = this.i;
        if (cVar == null || !cVar.l()) {
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.i.i());
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
            if (this.f63048f != null) {
                this.f63048f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            ScaleVideoView scaleVideoView = this.f63048f;
            if (scaleVideoView != null) {
                scaleVideoView.setBackgroundColor(this.f63043a.getResources().getColor(R.color.CAM_X0101));
            }
        }
    }

    public void t() {
        TiebaStatic.log(new StatisticItem("c12944"));
        d.b.c.e.m.e.a().postDelayed(this.l, 1000L);
        m();
    }
}
