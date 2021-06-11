package d.a.n0.k1.o.l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.n0.e3.v;
import d.a.n0.k1.o.l.a;
import d.a.n0.k1.o.l.c;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60411a;

    /* renamed from: b  reason: collision with root package name */
    public View f60412b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f60413c;

    /* renamed from: d  reason: collision with root package name */
    public int f60414d;

    /* renamed from: e  reason: collision with root package name */
    public ImmersiveVideoCardEx.a f60415e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f60416f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60417g;

    /* renamed from: h  reason: collision with root package name */
    public String f60418h;
    public View j;
    public int k;
    public int l;
    public n n;
    public d.a.n0.k1.o.l.a o;
    public d.a.n0.k1.o.l.c p;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60419i = false;
    public boolean m = false;
    public TbImageView.f q = new a();
    public SeekBar.OnSeekBarChangeListener r = new b();
    public VideoControllerView.d s = new c();
    public View.OnClickListener t = new d();
    public c.p u = new e();
    public CyberPlayerManager.OnPreparedListener v = new f();
    public VideoControllerView.c w = new g();
    public a.h x = new h();

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || o.this.f60416f == null) {
                return;
            }
            o.this.f60416f.setDefaultBgResource(0);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z) {
                o.this.p.X();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (o.this.p.a0() || o.this.p.h0() == null) {
                return;
            }
            o.this.p.D0(o.this.p.h0().getSeekPosition());
            o.this.p.O0(o.this.f60418h);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements VideoControllerView.d {
        public c() {
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            if (o.this.r()) {
                return;
            }
            o.this.p.i0(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!o.this.r() && view.getId() == o.this.f60412b.getId()) {
                if (!d.a.c.e.p.j.z()) {
                    d.a.c.e.p.l.J(o.this.f60411a.getPageActivity(), o.this.f60411a.getString(R.string.neterror));
                }
                if (o.this.o == null || !o.this.f60413c.isPlaying()) {
                    return;
                }
                o.this.o.r();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements c.p {
        public e() {
        }

        @Override // d.a.n0.k1.o.l.c.p
        public void a() {
        }

        @Override // d.a.n0.k1.o.l.c.p
        public void b() {
            o.this.o.l();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public f() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (o.this.f60413c == null) {
                return;
            }
            o.this.o.r();
            if (o.this.n == null || o.this.n.e() == null || !o.this.n.e().equals(o.this.f60418h) || o.this.n.f() <= 0) {
                if (o.this.n == null || o.this.n.g(o.this.f60418h) <= 0) {
                    return;
                }
                o.this.f60413c.seekTo(o.this.n.g(o.this.f60418h));
                return;
            }
            o.this.f60413c.seekTo(o.this.n.f());
            o.this.n.o(null);
            o.this.n.p(0);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements VideoControllerView.c {
        public g() {
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            if (o.this.r() || o.this.o == null || o.this.j == null) {
                return;
            }
            if (o.this.f60413c.isPlaying()) {
                o.this.o.r();
            }
            if (o.this.j.getAlpha() != 1.0f) {
                o.this.j.setAlpha(1.0f);
            }
            o.this.j.clearAnimation();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.h {
        public h() {
        }

        @Override // d.a.n0.k1.o.l.a.h
        public void a() {
            if (o.this.p.a0()) {
                o.this.p.l0();
            }
        }

        @Override // d.a.n0.k1.o.l.a.h
        public void b() {
            if (o.this.p.a0()) {
                o.this.p.W();
            }
        }

        @Override // d.a.n0.k1.o.l.a.h
        public void c() {
            if (o.this.p.a0()) {
                o.this.p.W();
            }
        }
    }

    public o(TbPageContext<?> tbPageContext, View view) {
        this.f60411a = tbPageContext;
        this.f60412b = view;
        view.setOnClickListener(this.t);
        d.a.n0.k1.o.l.c a2 = d.a.n0.k1.o.l.d.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.f60413c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.f60412b.findViewById(R.id.video_thumbnail);
        this.f60416f = tbImageView;
        tbImageView.setEvent(this.q);
        this.f60417g = (ImageView) this.f60412b.findViewById(R.id.img_play);
        this.j = this.p.b0();
        this.k = d.a.c.e.p.l.k(this.f60411a.getPageActivity());
        this.l = d.a.c.e.p.l.i(this.f60411a.getPageActivity());
        this.n = d.a.n0.k1.o.l.d.c(this.f60411a);
    }

    public int k() {
        if (r()) {
            return 0;
        }
        return this.f60413c.getCurrentPosition();
    }

    public int l() {
        return this.f60414d;
    }

    public String m() {
        return this.f60418h;
    }

    public View n() {
        return this.f60412b;
    }

    public final void o() {
        d.a.n0.k1.o.l.c cVar = this.p;
        if (cVar == null || this.f60413c == null || this.f60415e == null) {
            return;
        }
        cVar.P0();
        this.p.A0(this.f60412b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.f60415e.f17959d);
        this.p.I0(this.f60415e.f17962g);
        this.p.J0(this.f60418h);
        this.p.x0(this.u);
        this.p.r0();
        this.p.L0();
    }

    public boolean p() {
        return this.m;
    }

    public boolean q() {
        return !this.f60419i;
    }

    public final boolean r() {
        return this.f60412b == null || this.f60413c == null || this.f60416f == null || this.f60417g == null || this.j == null || this.o == null;
    }

    public void s(d.a.n0.k1.o.l.a aVar) {
        this.o = aVar;
        if (aVar != null) {
            aVar.t(this.x);
        }
    }

    public void t(boolean z) {
        d.a.n0.k1.o.l.c cVar = this.p;
        if (cVar != null) {
            cVar.C0(z);
        }
    }

    public void u(boolean z) {
        d.a.n0.k1.o.l.c cVar = this.p;
        if (cVar != null) {
            cVar.N0(z);
        }
    }

    public void v() {
        d.a.n0.k1.o.l.c cVar;
        if (this.m) {
            return;
        }
        int i2 = this.f60414d;
        if (i2 <= 0 || i2 == d.a.n0.k1.o.k.c.f60356a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!v.b() || (cVar = this.p) == null) {
                return;
            }
            cVar.O0(this.f60418h);
        }
    }

    public void w() {
        d.a.n0.k1.o.l.c cVar;
        if (r()) {
            return;
        }
        if (this.m && (cVar = this.p) != null && this.f60412b.equals(cVar.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.f60419i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i2) {
        this.f60415e = aVar;
        this.f60414d = i2;
        if (r() || aVar == null) {
            return;
        }
        String str = this.f60418h;
        if (str == null || !str.equalsIgnoreCase(aVar.f17956a)) {
            w();
            this.f60418h = aVar.f17956a;
            this.f60416f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f60416f.U(aVar.f17959d, 17, false);
            int i3 = aVar.f17960e;
            int i4 = aVar.f17961f;
            ViewGroup.LayoutParams layoutParams = this.f60412b.getLayoutParams();
            if (i3 > 0 && i4 > 0 && layoutParams != null && !aVar.f17963h) {
                if (i3 > i4) {
                    layoutParams.height = ((this.k * 1) * i4) / i3;
                } else {
                    layoutParams.height = this.k;
                }
                this.f60412b.setLayoutParams(layoutParams);
                this.p.M0();
            } else if (layoutParams != null && aVar.f17963h) {
                layoutParams.width = this.k;
                layoutParams.height = this.l;
                this.f60412b.setLayoutParams(layoutParams);
                this.p.k0();
            }
            this.p.T();
        }
    }

    public void y(String str, String str2) {
        d.a.n0.k1.o.l.c cVar = this.p;
        if (cVar != null) {
            cVar.R0(str, str2);
        }
    }
}
