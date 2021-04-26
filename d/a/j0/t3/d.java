package d.a.j0.t3;

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
import d.a.i0.s.c.i0;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public LogoActivity f61250a;

    /* renamed from: b  reason: collision with root package name */
    public View f61251b;

    /* renamed from: c  reason: collision with root package name */
    public View f61252c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61253d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61254e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f61255f;

    /* renamed from: g  reason: collision with root package name */
    public g f61256g;
    public int j;
    public boolean k = true;
    public Runnable l = new a();

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.t3.a f61257h = new d.a.j0.t3.a();

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.t3.c f61258i = new d.a.j0.t3.c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f61256g != null) {
                d.this.f61256g.onError();
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
            if (d.this.f61256g != null) {
                d.this.k = false;
                d.this.f61256g.onError();
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
            if (d.this.f61256g != null) {
                d.this.k = false;
                d.this.f61256g.onSkip();
            }
        }
    }

    /* renamed from: d.a.j0.t3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1597d implements MediaPlayer.OnPreparedListener {

        /* renamed from: d.a.j0.t3.d$d$a */
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

        public C1597d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.a.c.e.m.e.a().removeCallbacks(d.this.l);
            d.this.f61255f.setMediaPlayer(mediaPlayer);
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
            if (d.this.f61256g != null) {
                d.this.k = false;
                d.this.f61256g.onSkip();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f61265e;

        public f(String str) {
            this.f61265e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12945"));
            if (k.isEmpty(this.f61265e)) {
                return;
            }
            d.this.k = false;
            d.this.f61256g.onSkip();
            UrlManager.getInstance().dealOneLink(d.this.f61250a.getPageContext(), new String[]{this.f61265e});
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onError();

        void onSkip();
    }

    public d(LogoActivity logoActivity) {
        this.j = 0;
        this.f61250a = logoActivity;
        this.j = 0;
    }

    public boolean h() {
        d.a.j0.t3.a aVar;
        return (d.a.i0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && (aVar = this.f61257h) != null && this.f61258i != null && aVar.b() && this.f61258i.l();
    }

    public void i() {
        if (d.a.i0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) {
            return;
        }
        d.a.j0.t3.c cVar = this.f61258i;
        if (cVar != null) {
            cVar.g();
        }
        d.a.i0.r.d0.b.j().w("key_video_splash_last_show_time", 0L);
    }

    public final View j(double d2) {
        View inflate = LayoutInflater.from(this.f61250a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f61250a) * d2)));
        ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.f61255f = scaleVideoView;
        scaleVideoView.setOnErrorListener(new b());
        this.f61255f.setOnCompletionListener(new c());
        this.f61255f.setOnPreparedListener(new C1597d());
        TextView textView = (TextView) inflate.findViewById(R.id.skip);
        this.f61254e = textView;
        textView.setOnClickListener(new e());
        String p = d.a.i0.r.d0.b.j().p("key_video_splash_config", "");
        i0 i0Var = new i0();
        i0Var.g(p);
        String c2 = i0Var.c();
        View findViewById = inflate.findViewById(R.id.tip_container);
        this.f61252c = findViewById;
        findViewById.setOnClickListener(new f(c2));
        this.f61253d = (TextView) inflate.findViewById(R.id.tip_text);
        String b2 = i0Var.b();
        if (k.isEmpty(b2)) {
            b2 = this.f61250a.getString(R.string.video_splash_tip_default);
        }
        this.f61253d.setText(b2);
        s();
        return inflate;
    }

    public View k(double d2) {
        if (this.f61251b == null) {
            this.f61251b = j(d2);
        }
        return this.f61251b;
    }

    public final void l() {
        ScaleVideoView scaleVideoView = this.f61255f;
        if (scaleVideoView != null) {
            scaleVideoView.setBackgroundResource(0);
        }
    }

    public final void m() {
        d.a.j0.t3.c cVar = this.f61258i;
        if (cVar == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f61255f.setVideoPath(this.f61258i.i());
    }

    public void n() {
        d.a.c.e.m.e.a().removeCallbacks(this.l);
    }

    public void o() {
        ScaleVideoView scaleVideoView = this.f61255f;
        if (scaleVideoView != null) {
            this.j = scaleVideoView.getCurrentPosition();
            this.f61255f.stopPlayback();
            if (this.k) {
                s();
            }
        }
    }

    public void p() {
        this.k = true;
        ScaleVideoView scaleVideoView = this.f61255f;
        if (scaleVideoView != null) {
            scaleVideoView.resume();
        }
    }

    public final void q() {
        d.a.j0.t3.a aVar = this.f61257h;
        if (aVar != null) {
            aVar.g(System.currentTimeMillis());
        }
        int i2 = this.j;
        if (i2 >= 0) {
            this.f61255f.seekTo(i2);
        }
        this.f61255f.start();
    }

    public void r(g gVar) {
        this.f61256g = gVar;
    }

    public final void s() {
        d.a.j0.t3.c cVar = this.f61258i;
        if (cVar == null || !cVar.l()) {
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f61258i.i());
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
            if (this.f61255f != null) {
                this.f61255f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            ScaleVideoView scaleVideoView = this.f61255f;
            if (scaleVideoView != null) {
                scaleVideoView.setBackgroundColor(this.f61250a.getResources().getColor(R.color.CAM_X0101));
            }
        }
    }

    public void t() {
        TiebaStatic.log(new StatisticItem("c12944"));
        d.a.c.e.m.e.a().postDelayed(this.l, 1000L);
        m();
    }
}
