package d.a.k0.t.d.f.f;

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
import d.a.j0.z0.m0;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f extends d.a.k0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public View f61488f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f61489g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f61490h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f61491i;
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
            if (TextUtils.isEmpty(f.this.f61471d.f61424b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = f.this;
            urlManager.dealOneLink(fVar.f61470c, new String[]{fVar.f61471d.f61424b}, true);
            d.a.k0.t.d.d.a c2 = d.a.k0.t.d.d.a.c();
            f fVar2 = f.this;
            c2.f("c12909", fVar2.f61471d.f61427e, 2, fVar2.m);
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.n = new a();
        this.o = new b(this);
        this.p = new c(this);
    }

    @Override // d.a.k0.t.d.f.f.a
    public void b(d.a.k0.t.d.f.c.a aVar) {
        String y1;
        super.b(aVar);
        if (!ListUtils.isEmpty(this.f61471d.f61425c) && this.f61471d.f61425c.get(0) != null) {
            this.k = this.f61471d.f61425c.get(0).v1();
            this.m = this.f61471d.f61425c.get(0).o0();
        }
        VideoInfo videoInfo = this.k;
        if (videoInfo != null) {
            this.f61491i.V(videoInfo.thumbnail_url, 10, false);
            if (!TextUtils.isEmpty(this.f61471d.f61425c.get(0).l1())) {
                y1 = this.f61471d.f61425c.get(0).l1().toString();
            } else {
                y1 = this.f61471d.f61425c.get(0).y1();
            }
            if (!TextUtils.isEmpty(y1)) {
                this.j.setText(y1);
            }
            this.l = this.k.video_url;
            d.a.k0.t.d.d.a.c().f("c12908", this.f61471d.f61427e, 2, this.m);
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public View c() {
        return this.f61488f;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void d() {
        this.f61488f = LayoutInflater.from(this.f61470c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
        this.f61488f.setLayoutParams(new FrameLayout.LayoutParams(this.f61468a, this.f61469b));
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f61488f.findViewById(R.id.video_view);
        this.f61489g = tbCyberVideoView;
        tbCyberVideoView.setOnPreparedListener(this.n);
        this.f61489g.setOnErrorListener(this.o);
        this.f61489g.setOnSurfaceDestroyedListener(this.p);
        this.f61489g.setOnCompletionListener(new d());
        this.f61489g.setStageType(null);
        this.f61490h = (ImageView) this.f61488f.findViewById(R.id.video_play_btn);
        TbImageView tbImageView = (TbImageView) this.f61488f.findViewById(R.id.video_cover_img);
        this.f61491i = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.f61491i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j = (TextView) this.f61488f.findViewById(R.id.video_title);
        this.f61488f.setOnClickListener(new e());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.k0.t.d.f.f.a
    public boolean f(d.a.k0.t.d.f.c.a aVar) {
        return (aVar == null || 2 != aVar.f61426d || TextUtils.isEmpty(aVar.f61423a)) ? false : true;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.k0.t.d.f.f.a
    public void h() {
        super.h();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f61488f.getLayoutParams();
        layoutParams.width = this.f61468a;
        layoutParams.height = this.f61469b;
        this.f61488f.setLayoutParams(layoutParams);
    }

    @Override // d.a.k0.t.d.f.f.a
    public void i(int i2) {
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
    }

    @Override // d.a.k0.t.d.f.f.a
    public void j() {
        TbCyberVideoView tbCyberVideoView = this.f61489g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            this.f61489g.G();
            this.f61489g = null;
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public void k() {
        TbCyberVideoView tbCyberVideoView = this.f61489g;
        if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
            this.f61490h.setVisibility(0);
            this.f61489g.pause();
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public void l() {
        TbCyberVideoView tbCyberVideoView = this.f61489g;
        if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
            this.f61490h.setVisibility(8);
            this.f61489g.start();
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public void m() {
        TbCyberVideoView tbCyberVideoView = this.f61489g;
        if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
            return;
        }
        this.f61491i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !m0.b(1, this.l)) {
            return;
        }
        this.f61489g.setVideoPath(this.l);
        this.f61489g.setLooping(true);
    }

    @Override // d.a.k0.t.d.f.f.a
    public void n() {
        TbCyberVideoView tbCyberVideoView = this.f61489g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    public final void q() {
        d.a.k0.t.d.d.a.c().f("c12910", this.f61471d.f61427e, 2, this.m);
        this.f61491i.setVisibility(8);
        this.f61490h.setVisibility(8);
        TbCyberVideoView tbCyberVideoView = this.f61489g;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.setVolume(0.0f, 0.0f);
            try {
                this.f61489g.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
