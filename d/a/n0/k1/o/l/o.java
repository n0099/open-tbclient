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
    public TbPageContext<?> f56722a;

    /* renamed from: b  reason: collision with root package name */
    public View f56723b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f56724c;

    /* renamed from: d  reason: collision with root package name */
    public int f56725d;

    /* renamed from: e  reason: collision with root package name */
    public ImmersiveVideoCardEx.a f56726e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f56727f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56728g;

    /* renamed from: h  reason: collision with root package name */
    public String f56729h;
    public View j;
    public int k;
    public int l;
    public n n;
    public d.a.n0.k1.o.l.a o;
    public d.a.n0.k1.o.l.c p;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56730i = false;
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
            if (!z || o.this.f56727f == null) {
                return;
            }
            o.this.f56727f.setDefaultBgResource(0);
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
            o.this.p.O0(o.this.f56729h);
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
            if (!o.this.r() && view.getId() == o.this.f56723b.getId()) {
                if (!d.a.c.e.p.j.z()) {
                    d.a.c.e.p.l.J(o.this.f56722a.getPageActivity(), o.this.f56722a.getString(R.string.neterror));
                }
                if (o.this.o == null || !o.this.f56724c.isPlaying()) {
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
            if (o.this.f56724c == null) {
                return;
            }
            o.this.o.r();
            if (o.this.n == null || o.this.n.e() == null || !o.this.n.e().equals(o.this.f56729h) || o.this.n.f() <= 0) {
                if (o.this.n == null || o.this.n.g(o.this.f56729h) <= 0) {
                    return;
                }
                o.this.f56724c.seekTo(o.this.n.g(o.this.f56729h));
                return;
            }
            o.this.f56724c.seekTo(o.this.n.f());
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
            if (o.this.f56724c.isPlaying()) {
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
        this.f56722a = tbPageContext;
        this.f56723b = view;
        view.setOnClickListener(this.t);
        d.a.n0.k1.o.l.c a2 = d.a.n0.k1.o.l.d.a(tbPageContext);
        this.p = a2;
        a2.H0(this);
        this.f56724c = this.p.f0();
        TbImageView tbImageView = (TbImageView) this.f56723b.findViewById(R.id.video_thumbnail);
        this.f56727f = tbImageView;
        tbImageView.setEvent(this.q);
        this.f56728g = (ImageView) this.f56723b.findViewById(R.id.img_play);
        this.j = this.p.b0();
        this.k = d.a.c.e.p.l.k(this.f56722a.getPageActivity());
        this.l = d.a.c.e.p.l.i(this.f56722a.getPageActivity());
        this.n = d.a.n0.k1.o.l.d.c(this.f56722a);
    }

    public int k() {
        if (r()) {
            return 0;
        }
        return this.f56724c.getCurrentPosition();
    }

    public int l() {
        return this.f56725d;
    }

    public String m() {
        return this.f56729h;
    }

    public View n() {
        return this.f56723b;
    }

    public final void o() {
        d.a.n0.k1.o.l.c cVar = this.p;
        if (cVar == null || this.f56724c == null || this.f56726e == null) {
            return;
        }
        cVar.P0();
        this.p.A0(this.f56723b);
        if (this.p.e0()) {
            this.p.Q();
        }
        this.p.h0().setOnProgressUpdatedListener(this.s);
        this.p.h0().setOnDragingListener(this.w);
        this.p.h0().setOnSeekBarChangeListener(this.r);
        this.p.z0(this.v);
        this.p.G0(this.f56726e.f17883d);
        this.p.I0(this.f56726e.f17886g);
        this.p.J0(this.f56729h);
        this.p.x0(this.u);
        this.p.r0();
        this.p.L0();
    }

    public boolean p() {
        return this.m;
    }

    public boolean q() {
        return !this.f56730i;
    }

    public final boolean r() {
        return this.f56723b == null || this.f56724c == null || this.f56727f == null || this.f56728g == null || this.j == null || this.o == null;
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
        int i2 = this.f56725d;
        if (i2 <= 0 || i2 == d.a.n0.k1.o.k.c.f56667a) {
            this.m = true;
            if (r()) {
                return;
            }
            o();
            if (!v.b() || (cVar = this.p) == null) {
                return;
            }
            cVar.O0(this.f56729h);
        }
    }

    public void w() {
        d.a.n0.k1.o.l.c cVar;
        if (r()) {
            return;
        }
        if (this.m && (cVar = this.p) != null && this.f56723b.equals(cVar.c0())) {
            this.p.P0();
            if (this.p.e0()) {
                this.p.j0();
            }
        }
        this.m = false;
        this.f56730i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i2) {
        this.f56726e = aVar;
        this.f56725d = i2;
        if (r() || aVar == null) {
            return;
        }
        String str = this.f56729h;
        if (str == null || !str.equalsIgnoreCase(aVar.f17880a)) {
            w();
            this.f56729h = aVar.f17880a;
            this.f56727f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f56727f.V(aVar.f17883d, 17, false);
            int i3 = aVar.f17884e;
            int i4 = aVar.f17885f;
            ViewGroup.LayoutParams layoutParams = this.f56723b.getLayoutParams();
            if (i3 > 0 && i4 > 0 && layoutParams != null && !aVar.f17887h) {
                if (i3 > i4) {
                    layoutParams.height = ((this.k * 1) * i4) / i3;
                } else {
                    layoutParams.height = this.k;
                }
                this.f56723b.setLayoutParams(layoutParams);
                this.p.M0();
            } else if (layoutParams != null && aVar.f17887h) {
                layoutParams.width = this.k;
                layoutParams.height = this.l;
                this.f56723b.setLayoutParams(layoutParams);
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
