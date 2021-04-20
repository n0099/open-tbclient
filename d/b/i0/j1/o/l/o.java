package d.b.i0.j1.o.l;

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
import d.b.i0.d3.v;
import d.b.i0.j1.o.l.a;
import d.b.i0.j1.o.l.c;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f57444a;

    /* renamed from: b  reason: collision with root package name */
    public View f57445b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f57446c;

    /* renamed from: d  reason: collision with root package name */
    public int f57447d;

    /* renamed from: e  reason: collision with root package name */
    public ImmersiveVideoCardEx.a f57448e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f57449f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57450g;

    /* renamed from: h  reason: collision with root package name */
    public String f57451h;
    public View j;
    public int k;
    public int l;
    public n n;
    public d.b.i0.j1.o.l.a o;
    public d.b.i0.j1.o.l.c p;
    public boolean i = false;
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
            if (!z || o.this.f57449f == null) {
                return;
            }
            o.this.f57449f.setDefaultBgResource(0);
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
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
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
            o.this.p.O0(o.this.f57451h);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements VideoControllerView.d {
        public c() {
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i) {
            if (o.this.r()) {
                return;
            }
            o.this.p.i0(i);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!o.this.r() && view.getId() == o.this.f57445b.getId()) {
                if (!d.b.c.e.p.j.z()) {
                    d.b.c.e.p.l.I(o.this.f57444a.getPageActivity(), o.this.f57444a.getString(R.string.neterror));
                }
                if (o.this.o == null || !o.this.f57446c.isPlaying()) {
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

        @Override // d.b.i0.j1.o.l.c.p
        public void a() {
        }

        @Override // d.b.i0.j1.o.l.c.p
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
            if (o.this.f57446c == null) {
                return;
            }
            o.this.o.r();
            if (o.this.n == null || o.this.n.e() == null || !o.this.n.e().equals(o.this.f57451h) || o.this.n.f() <= 0) {
                if (o.this.n == null || o.this.n.g(o.this.f57451h) <= 0) {
                    return;
                }
                o.this.f57446c.seekTo(o.this.n.g(o.this.f57451h));
                return;
            }
            o.this.f57446c.seekTo(o.this.n.f());
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
            if (o.this.f57446c.isPlaying()) {
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

        @Override // d.b.i0.j1.o.l.a.h
        public void a() {
            if (o.this.p.a0()) {
                o.this.p.W();
            }
        }

        @Override // d.b.i0.j1.o.l.a.h
        public void b() {
            if (o.this.p.a0()) {
                o.this.p.l0();
            }
        }

        @Override // d.b.i0.j1.o.l.a.h
        public void c() {
            if (o.this.p.a0()) {
                o.this.p.W();
            }
        }
    }

    public o(TbPageContext<?> tbPageContext, View view) {
        this.f57444a = tbPageContext;
        this.f57445b = view;
        view.setOnClickListener(this.t);
        d.b.i0.j1.o.l.c a2 = d.b.i0.j1.o.l.d.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.f57446c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.f57445b.findViewById(R.id.video_thumbnail);
        this.f57449f = tbImageView;
        tbImageView.setEvent(this.q);
        this.f57450g = (ImageView) this.f57445b.findViewById(R.id.img_play);
        this.j = this.p.b0();
        this.k = d.b.c.e.p.l.k(this.f57444a.getPageActivity());
        this.l = d.b.c.e.p.l.i(this.f57444a.getPageActivity());
        this.n = d.b.i0.j1.o.l.d.c(this.f57444a);
    }

    public int k() {
        if (r()) {
            return 0;
        }
        return this.f57446c.getCurrentPosition();
    }

    public int l() {
        return this.f57447d;
    }

    public String m() {
        return this.f57451h;
    }

    public View n() {
        return this.f57445b;
    }

    public final void o() {
        d.b.i0.j1.o.l.c cVar = this.p;
        if (cVar == null || this.f57446c == null || this.f57448e == null) {
            return;
        }
        cVar.P0();
        this.p.A0(this.f57445b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.f57448e.f18293d);
        this.p.I0(this.f57448e.f18296g);
        this.p.J0(this.f57451h);
        this.p.x0(this.u);
        this.p.r0();
        this.p.L0();
    }

    public boolean p() {
        return this.m;
    }

    public boolean q() {
        return !this.i;
    }

    public final boolean r() {
        return this.f57445b == null || this.f57446c == null || this.f57449f == null || this.f57450g == null || this.j == null || this.o == null;
    }

    public void s(d.b.i0.j1.o.l.a aVar) {
        this.o = aVar;
        if (aVar != null) {
            aVar.t(this.x);
        }
    }

    public void t(boolean z) {
        d.b.i0.j1.o.l.c cVar = this.p;
        if (cVar != null) {
            cVar.C0(z);
        }
    }

    public void u(boolean z) {
        d.b.i0.j1.o.l.c cVar = this.p;
        if (cVar != null) {
            cVar.N0(z);
        }
    }

    public void v() {
        d.b.i0.j1.o.l.c cVar;
        if (this.m) {
            return;
        }
        int i = this.f57447d;
        if (i <= 0 || i == d.b.i0.j1.o.k.c.f57393a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!v.b() || (cVar = this.p) == null) {
                return;
            }
            cVar.O0(this.f57451h);
        }
    }

    public void w() {
        d.b.i0.j1.o.l.c cVar;
        if (r()) {
            return;
        }
        if (this.m && (cVar = this.p) != null && this.f57445b.equals(cVar.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i) {
        this.f57448e = aVar;
        this.f57447d = i;
        if (r() || aVar == null) {
            return;
        }
        String str = this.f57451h;
        if (str == null || !str.equalsIgnoreCase(aVar.f18290a)) {
            w();
            this.f57451h = aVar.f18290a;
            this.f57449f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f57449f.W(aVar.f18293d, 17, false);
            int i2 = aVar.f18294e;
            int i3 = aVar.f18295f;
            ViewGroup.LayoutParams layoutParams = this.f57445b.getLayoutParams();
            if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.f18297h) {
                if (i2 > i3) {
                    layoutParams.height = ((this.k * 1) * i3) / i2;
                } else {
                    layoutParams.height = this.k;
                }
                this.f57445b.setLayoutParams(layoutParams);
                this.p.M0();
            } else if (layoutParams != null && aVar.f18297h) {
                layoutParams.width = this.k;
                layoutParams.height = this.l;
                this.f57445b.setLayoutParams(layoutParams);
                this.p.k0();
            }
            this.p.T();
        }
    }

    public void y(String str, String str2) {
        d.b.i0.j1.o.l.c cVar = this.p;
        if (cVar != null) {
            cVar.R0(str, str2);
        }
    }
}
