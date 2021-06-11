package d.a.n0.v.d.f.f;

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
import d.a.m0.z0.m0;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f extends d.a.n0.v.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public View f65491f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f65492g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f65493h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f65494i;
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
        public boolean onError(int i2, int i3, Object obj) {
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
            if (TextUtils.isEmpty(f.this.f65474d.f65426b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = f.this;
            urlManager.dealOneLink(fVar.f65473c, new String[]{fVar.f65474d.f65426b}, true);
            d.a.n0.v.d.d.a c2 = d.a.n0.v.d.d.a.c();
            f fVar2 = f.this;
            c2.f("c12909", fVar2.f65474d.f65429e, 2, fVar2.m, null);
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.n = new a();
        this.o = new b(this);
        this.p = new c(this);
    }

    @Override // d.a.n0.v.d.f.f.a
    public void b(d.a.n0.v.d.f.c.a aVar) {
        String A1;
        super.b(aVar);
        if (!ListUtils.isEmpty(this.f65474d.f65427c) && this.f65474d.f65427c.get(0) != null) {
            this.k = this.f65474d.f65427c.get(0).x1();
            this.m = this.f65474d.f65427c.get(0).o0();
        }
        VideoInfo videoInfo = this.k;
        if (videoInfo != null) {
            this.f65494i.U(videoInfo.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.f65474d.f65427c.get(0).n1())) {
                A1 = this.f65474d.f65427c.get(0).n1().toString();
            } else {
                A1 = this.f65474d.f65427c.get(0).A1();
            }
            if (!TextUtils.isEmpty(A1)) {
                this.j.setText(A1);
            }
            this.l = this.k.video_url;
            d.a.n0.v.d.d.a.c().f("c12908", this.f65474d.f65429e, 2, this.m, null);
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public View c() {
        return this.f65491f;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void d() {
        this.f65491f = LayoutInflater.from(this.f65473c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.f65491f.setLayoutParams(new FrameLayout.LayoutParams(this.f65471a, this.f65472b));
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f65491f.findViewById(R.id.video_view);
        this.f65492g = tbCyberVideoView;
        tbCyberVideoView.setOnPreparedListener(this.n);
        this.f65492g.setOnErrorListener(this.o);
        this.f65492g.setOnSurfaceDestroyedListener(this.p);
        this.f65492g.setOnCompletionListener(new d());
        this.f65492g.setStageType(null);
        this.f65493h = (ImageView) this.f65491f.findViewById(R.id.video_play_btn);
        TbImageView tbImageView = (TbImageView) this.f65491f.findViewById(R.id.video_cover_img);
        this.f65494i = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.f65494i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j = (TextView) this.f65491f.findViewById(R.id.video_title);
        this.f65491f.setOnClickListener(new e());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.v.d.f.f.a
    public boolean f(d.a.n0.v.d.f.c.a aVar) {
        return (aVar == null || 2 != aVar.f65428d || TextUtils.isEmpty(aVar.f65425a)) ? false : true;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.n0.v.d.f.f.a
    public void h() {
        super.h();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f65491f.getLayoutParams();
        layoutParams.width = this.f65471a;
        layoutParams.height = this.f65472b;
        this.f65491f.setLayoutParams(layoutParams);
    }

    @Override // d.a.n0.v.d.f.f.a
    public void i(int i2) {
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
    }

    @Override // d.a.n0.v.d.f.f.a
    public void j() {
        TbCyberVideoView tbCyberVideoView = this.f65492g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f65492g.G();
            this.f65492g = null;
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void k() {
        TbCyberVideoView tbCyberVideoView = this.f65492g;
        if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
            this.f65493h.setVisibility(0);
            this.f65492g.pause();
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void l() {
        TbCyberVideoView tbCyberVideoView = this.f65492g;
        if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
            this.f65493h.setVisibility(8);
            this.f65492g.start();
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void m() {
        TbCyberVideoView tbCyberVideoView = this.f65492g;
        if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
            return;
        }
        this.f65494i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !m0.b(1, this.l)) {
            return;
        }
        this.f65492g.setVideoPath(this.l);
        this.f65492g.setLooping(true);
    }

    @Override // d.a.n0.v.d.f.f.a
    public void n() {
        TbCyberVideoView tbCyberVideoView = this.f65492g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    public final void q() {
        d.a.n0.v.d.d.a.c().f("c12910", this.f65474d.f65429e, 2, this.m, null);
        this.f65494i.setVisibility(8);
        this.f65493h.setVisibility(8);
        TbCyberVideoView tbCyberVideoView = this.f65492g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.setVolume(0.0f, 0.0f);
            try {
                this.f65492g.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
