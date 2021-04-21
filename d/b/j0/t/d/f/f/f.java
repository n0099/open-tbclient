package d.b.j0.t.d.f.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.b.i0.z0.m0;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f extends d.b.j0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public View f62583f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f62584g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f62585h;
    public TbImageView i;
    public TextView j;
    public VideoInfo k;
    public String l;
    public String m;
    public CyberPlayerManager.OnPreparedListener n;
    public CyberPlayerManager.OnErrorListener o;
    public TbCyberVideoView.g p;

    /* loaded from: classes4.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            f.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public b(f fVar) {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbCyberVideoView.g {
        public c(f fVar) {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements CyberPlayerManager.OnCompletionListener {
        public d() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            f.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(f.this.f62567d.f62512b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = f.this;
            urlManager.dealOneLink(fVar.f62566c, new String[]{fVar.f62567d.f62512b}, true);
            d.b.j0.t.d.d.a c2 = d.b.j0.t.d.d.a.c();
            f fVar2 = f.this;
            c2.f("c12909", fVar2.f62567d.f62515e, 2, fVar2.m);
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.n = new a();
        this.o = new b(this);
        this.p = new c(this);
    }

    @Override // d.b.j0.t.d.f.f.a
    public void b(d.b.j0.t.d.f.c.a aVar) {
        String x1;
        super.b(aVar);
        if (!ListUtils.isEmpty(this.f62567d.f62513c) && this.f62567d.f62513c.get(0) != null) {
            this.k = this.f62567d.f62513c.get(0).u1();
            this.m = this.f62567d.f62513c.get(0).o0();
        }
        VideoInfo videoInfo = this.k;
        if (videoInfo != null) {
            this.i.W(videoInfo.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.f62567d.f62513c.get(0).l1())) {
                x1 = this.f62567d.f62513c.get(0).l1().toString();
            } else {
                x1 = this.f62567d.f62513c.get(0).x1();
            }
            if (!TextUtils.isEmpty(x1)) {
                this.j.setText(x1);
            }
            this.l = this.k.video_url;
            d.b.j0.t.d.d.a.c().f("c12908", this.f62567d.f62515e, 2, this.m);
        }
    }

    @Override // d.b.j0.t.d.f.f.a
    public View c() {
        return this.f62583f;
    }

    @Override // d.b.j0.t.d.f.f.a
    public void d() {
        this.f62583f = LayoutInflater.from(this.f62566c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.f62583f.setLayoutParams(new FrameLayout.LayoutParams(this.f62564a, this.f62565b));
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f62583f.findViewById(R.id.video_view);
        this.f62584g = tbCyberVideoView;
        tbCyberVideoView.setOnPreparedListener(this.n);
        this.f62584g.setOnErrorListener(this.o);
        this.f62584g.setOnSurfaceDestroyedListener(this.p);
        this.f62584g.setOnCompletionListener(new d());
        this.f62584g.setStageType(null);
        this.f62585h = (ImageView) this.f62583f.findViewById(R.id.video_play_btn);
        TbImageView tbImageView = (TbImageView) this.f62583f.findViewById(R.id.video_cover_img);
        this.i = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j = (TextView) this.f62583f.findViewById(R.id.video_title);
        this.f62583f.setOnClickListener(new e());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.j0.t.d.f.f.a
    public boolean f(d.b.j0.t.d.f.c.a aVar) {
        return (aVar == null || 2 != aVar.f62514d || TextUtils.isEmpty(aVar.f62511a)) ? false : true;
    }

    @Override // d.b.j0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.b.j0.t.d.f.f.a
    public void h() {
        super.h();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f62583f.getLayoutParams();
        layoutParams.width = this.f62564a;
        layoutParams.height = this.f62565b;
        this.f62583f.setLayoutParams(layoutParams);
    }

    @Override // d.b.j0.t.d.f.f.a
    public void i(int i) {
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
    }

    @Override // d.b.j0.t.d.f.f.a
    public void j() {
        TbCyberVideoView tbCyberVideoView = this.f62584g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f62584g.G();
            this.f62584g = null;
        }
    }

    @Override // d.b.j0.t.d.f.f.a
    public void k() {
        TbCyberVideoView tbCyberVideoView = this.f62584g;
        if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
            this.f62585h.setVisibility(0);
            this.f62584g.pause();
        }
    }

    @Override // d.b.j0.t.d.f.f.a
    public void l() {
        TbCyberVideoView tbCyberVideoView = this.f62584g;
        if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
            this.f62585h.setVisibility(8);
            this.f62584g.start();
        }
    }

    @Override // d.b.j0.t.d.f.f.a
    public void m() {
        TbCyberVideoView tbCyberVideoView = this.f62584g;
        if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
            return;
        }
        this.i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !m0.b(1, this.l)) {
            return;
        }
        this.f62584g.setVideoPath(this.l);
        this.f62584g.setLooping(true);
    }

    @Override // d.b.j0.t.d.f.f.a
    public void n() {
        TbCyberVideoView tbCyberVideoView = this.f62584g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    public final void q() {
        d.b.j0.t.d.d.a.c().f("c12910", this.f62567d.f62515e, 2, this.m);
        this.i.setVisibility(8);
        this.f62585h.setVisibility(8);
        TbCyberVideoView tbCyberVideoView = this.f62584g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.setVolume(0.0f, 0.0f);
            try {
                this.f62584g.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
