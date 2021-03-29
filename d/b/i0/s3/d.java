package d.b.i0.s3;

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
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.ScaleVideoView;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.s.c.g0;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public LogoActivity f60208a;

    /* renamed from: b  reason: collision with root package name */
    public View f60209b;

    /* renamed from: c  reason: collision with root package name */
    public View f60210c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60211d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60212e;

    /* renamed from: f  reason: collision with root package name */
    public ScaleVideoView f60213f;

    /* renamed from: g  reason: collision with root package name */
    public g f60214g;
    public int j;
    public boolean k = true;
    public Runnable l = new a();

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.s3.a f60215h = new d.b.i0.s3.a();
    public d.b.i0.s3.c i = new d.b.i0.s3.c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f60214g != null) {
                d.this.f60214g.onError();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            d.b.b.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f60214g != null) {
                d.this.k = false;
                d.this.f60214g.onError();
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
            d.b.b.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f60214g != null) {
                d.this.k = false;
                d.this.f60214g.onSkip();
            }
        }
    }

    /* renamed from: d.b.i0.s3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1536d implements MediaPlayer.OnPreparedListener {

        /* renamed from: d.b.i0.s3.d$d$a */
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

        public C1536d() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            d.b.b.e.m.e.a().removeCallbacks(d.this.l);
            d.this.f60213f.setMediaPlayer(mediaPlayer);
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
            d.b.b.e.m.e.a().removeCallbacks(d.this.l);
            if (d.this.f60214g != null) {
                d.this.k = false;
                d.this.f60214g.onSkip();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f60222e;

        public f(String str) {
            this.f60222e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12945"));
            if (k.isEmpty(this.f60222e)) {
                return;
            }
            d.this.k = false;
            d.this.f60214g.onSkip();
            UrlManager.getInstance().dealOneLink(d.this.f60208a.getPageContext(), new String[]{this.f60222e});
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onError();

        void onSkip();
    }

    public d(LogoActivity logoActivity) {
        this.j = 0;
        this.f60208a = logoActivity;
        this.j = 0;
    }

    public boolean h() {
        d.b.i0.s3.a aVar;
        return (d.b.h0.r.d0.b.i().j("key_video_splash_switch", 0) == 1) && (aVar = this.f60215h) != null && this.i != null && aVar.b() && this.i.l();
    }

    public void i() {
        if (d.b.h0.r.d0.b.i().j("key_video_splash_switch", 0) == 1) {
            return;
        }
        d.b.i0.s3.c cVar = this.i;
        if (cVar != null) {
            cVar.g();
        }
        d.b.h0.r.d0.b.i().v("key_video_splash_last_show_time", 0L);
    }

    public final View j(double d2) {
        View inflate = LayoutInflater.from(this.f60208a).inflate(R.layout.video_splash_layout, (ViewGroup) null);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (l.i(this.f60208a) * d2)));
        ScaleVideoView scaleVideoView = (ScaleVideoView) inflate.findViewById(R.id.video);
        this.f60213f = scaleVideoView;
        scaleVideoView.setOnErrorListener(new b());
        this.f60213f.setOnCompletionListener(new c());
        this.f60213f.setOnPreparedListener(new C1536d());
        TextView textView = (TextView) inflate.findViewById(R.id.skip);
        this.f60212e = textView;
        textView.setOnClickListener(new e());
        String o = d.b.h0.r.d0.b.i().o("key_video_splash_config", "");
        g0 g0Var = new g0();
        g0Var.g(o);
        String c2 = g0Var.c();
        View findViewById = inflate.findViewById(R.id.tip_container);
        this.f60210c = findViewById;
        findViewById.setOnClickListener(new f(c2));
        this.f60211d = (TextView) inflate.findViewById(R.id.tip_text);
        String b2 = g0Var.b();
        if (k.isEmpty(b2)) {
            b2 = this.f60208a.getString(R.string.video_splash_tip_default);
        }
        this.f60211d.setText(b2);
        s();
        return inflate;
    }

    public View k(double d2) {
        if (this.f60209b == null) {
            this.f60209b = j(d2);
        }
        return this.f60209b;
    }

    public final void l() {
        ScaleVideoView scaleVideoView = this.f60213f;
        if (scaleVideoView != null) {
            scaleVideoView.setBackgroundResource(0);
        }
    }

    public final void m() {
        d.b.i0.s3.c cVar = this.i;
        if (cVar == null || k.isEmpty(cVar.i())) {
            return;
        }
        this.f60213f.setVideoPath(this.i.i());
    }

    public void n() {
        d.b.b.e.m.e.a().removeCallbacks(this.l);
    }

    public void o() {
        ScaleVideoView scaleVideoView = this.f60213f;
        if (scaleVideoView != null) {
            this.j = scaleVideoView.getCurrentPosition();
            this.f60213f.stopPlayback();
            if (this.k) {
                s();
            }
        }
    }

    public void p() {
        this.k = true;
        ScaleVideoView scaleVideoView = this.f60213f;
        if (scaleVideoView != null) {
            scaleVideoView.resume();
        }
    }

    public final void q() {
        d.b.i0.s3.a aVar = this.f60215h;
        if (aVar != null) {
            aVar.g(System.currentTimeMillis());
        }
        int i = this.j;
        if (i >= 0) {
            this.f60213f.seekTo(i);
        }
        this.f60213f.start();
    }

    public void r(g gVar) {
        this.f60214g = gVar;
    }

    public final void s() {
        d.b.i0.s3.c cVar = this.i;
        if (cVar == null || !cVar.l()) {
            return;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.i.i());
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
            if (this.f60213f != null) {
                this.f60213f.setBackgroundDrawable(new BitmapDrawable(frameAtTime));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            ScaleVideoView scaleVideoView = this.f60213f;
            if (scaleVideoView != null) {
                scaleVideoView.setBackgroundColor(this.f60208a.getResources().getColor(R.color.CAM_X0101));
            }
        }
    }

    public void t() {
        TiebaStatic.log(new StatisticItem("c12944"));
        d.b.b.e.m.e.a().postDelayed(this.l, 1000L);
        m();
    }
}
