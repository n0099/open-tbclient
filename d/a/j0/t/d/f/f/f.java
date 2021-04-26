package d.a.j0.t.d.f.f;

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
import d.a.i0.z0.m0;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f extends d.a.j0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public View f60764f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f60765g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60766h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f60767i;
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
            if (TextUtils.isEmpty(f.this.f60747d.f60700b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = f.this;
            urlManager.dealOneLink(fVar.f60746c, new String[]{fVar.f60747d.f60700b}, true);
            d.a.j0.t.d.d.a c2 = d.a.j0.t.d.d.a.c();
            f fVar2 = f.this;
            c2.f("c12909", fVar2.f60747d.f60703e, 2, fVar2.m);
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.n = new a();
        this.o = new b(this);
        this.p = new c(this);
    }

    @Override // d.a.j0.t.d.f.f.a
    public void b(d.a.j0.t.d.f.c.a aVar) {
        String x1;
        super.b(aVar);
        if (!ListUtils.isEmpty(this.f60747d.f60701c) && this.f60747d.f60701c.get(0) != null) {
            this.k = this.f60747d.f60701c.get(0).u1();
            this.m = this.f60747d.f60701c.get(0).o0();
        }
        VideoInfo videoInfo = this.k;
        if (videoInfo != null) {
            this.f60767i.V(videoInfo.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.f60747d.f60701c.get(0).l1())) {
                x1 = this.f60747d.f60701c.get(0).l1().toString();
            } else {
                x1 = this.f60747d.f60701c.get(0).x1();
            }
            if (!TextUtils.isEmpty(x1)) {
                this.j.setText(x1);
            }
            this.l = this.k.video_url;
            d.a.j0.t.d.d.a.c().f("c12908", this.f60747d.f60703e, 2, this.m);
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public View c() {
        return this.f60764f;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void d() {
        this.f60764f = LayoutInflater.from(this.f60746c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.f60764f.setLayoutParams(new FrameLayout.LayoutParams(this.f60744a, this.f60745b));
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f60764f.findViewById(R.id.video_view);
        this.f60765g = tbCyberVideoView;
        tbCyberVideoView.setOnPreparedListener(this.n);
        this.f60765g.setOnErrorListener(this.o);
        this.f60765g.setOnSurfaceDestroyedListener(this.p);
        this.f60765g.setOnCompletionListener(new d());
        this.f60765g.setStageType(null);
        this.f60766h = (ImageView) this.f60764f.findViewById(R.id.video_play_btn);
        TbImageView tbImageView = (TbImageView) this.f60764f.findViewById(R.id.video_cover_img);
        this.f60767i = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.f60767i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j = (TextView) this.f60764f.findViewById(R.id.video_title);
        this.f60764f.setOnClickListener(new e());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.t.d.f.f.a
    public boolean f(d.a.j0.t.d.f.c.a aVar) {
        return (aVar == null || 2 != aVar.f60702d || TextUtils.isEmpty(aVar.f60699a)) ? false : true;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.j0.t.d.f.f.a
    public void h() {
        super.h();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f60764f.getLayoutParams();
        layoutParams.width = this.f60744a;
        layoutParams.height = this.f60745b;
        this.f60764f.setLayoutParams(layoutParams);
    }

    @Override // d.a.j0.t.d.f.f.a
    public void i(int i2) {
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
    }

    @Override // d.a.j0.t.d.f.f.a
    public void j() {
        TbCyberVideoView tbCyberVideoView = this.f60765g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f60765g.G();
            this.f60765g = null;
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public void k() {
        TbCyberVideoView tbCyberVideoView = this.f60765g;
        if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
            this.f60766h.setVisibility(0);
            this.f60765g.pause();
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public void l() {
        TbCyberVideoView tbCyberVideoView = this.f60765g;
        if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
            this.f60766h.setVisibility(8);
            this.f60765g.start();
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public void m() {
        TbCyberVideoView tbCyberVideoView = this.f60765g;
        if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
            return;
        }
        this.f60767i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !m0.b(1, this.l)) {
            return;
        }
        this.f60765g.setVideoPath(this.l);
        this.f60765g.setLooping(true);
    }

    @Override // d.a.j0.t.d.f.f.a
    public void n() {
        TbCyberVideoView tbCyberVideoView = this.f60765g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    public final void q() {
        d.a.j0.t.d.d.a.c().f("c12910", this.f60747d.f60703e, 2, this.m);
        this.f60767i.setVisibility(8);
        this.f60766h.setVisibility(8);
        TbCyberVideoView tbCyberVideoView = this.f60765g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.setVolume(0.0f, 0.0f);
            try {
                this.f60765g.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
