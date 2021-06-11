package d.a.n0.e2.o.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.videoView.PbNextVideoLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoFullscreenAttentionLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoMediaController;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import d.a.c.e.m.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.n0.k2.h;
import d.a.n0.k2.n;
import d.a.n0.k2.o;
/* loaded from: classes5.dex */
public class a extends d.a.n0.k2.q.d {
    public PbVideoFullscreenAttentionLayout G0;
    public PbNextVideoLayout M0;
    public ImageView N0;
    public ImageView O0;
    public int P0;
    public int Q0;
    public boolean R0;
    public ObjectAnimator S0;
    public VideoPbViewModel T0;
    public int U0;
    public String V0;
    public String W0;
    public BaijiahaoData X0;
    public VideoPbFragment Y0;
    public View Z0;
    public View a1;
    public boolean b1;
    public boolean c1;
    public ObjectAnimator d1;
    public ObjectAnimator e1;
    public Runnable f1;
    public Runnable g1;
    public Runnable h1;
    public Runnable i1;

    /* renamed from: d.a.n0.e2.o.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1345a implements Runnable {
        public RunnableC1345a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.L.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: d.a.n0.e2.o.r.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1346a extends AnimatorListenerAdapter {
            public C1346a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.V0();
                e.a().postDelayed(a.this.h1, 5000L);
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.G0.b()) {
                return;
            }
            Context context = a.this.P;
            int i2 = a.this.U ? R.dimen.tbds210 : R.dimen.tbds244;
            a.this.R0 = true;
            a.this.S0.setFloatValues(-l.g(context, i2));
            a.this.S0.removeAllListeners();
            a.this.S0.addListener(new C1346a());
            a.this.S0.start();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: d.a.n0.e2.o.r.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1347a extends AnimatorListenerAdapter {
            public C1347a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.G0.setVisibility(8);
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.S0.setFloatValues(l.g(a.this.P, a.this.U ? R.dimen.tbds210 : R.dimen.tbds244));
            a.this.S0.removeAllListeners();
            a.this.S0.addListener(new C1347a());
            a.this.S0.start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.c1 && (a.this.P instanceof Activity)) {
                a.this.Q0();
            }
        }
    }

    public a(Context context, View view) {
        super(context, view);
        this.P0 = -1;
        this.U0 = 0;
        this.f1 = new RunnableC1345a();
        this.g1 = new b();
        this.h1 = new c();
        this.i1 = new d();
        O();
        if (context instanceof PbActivity) {
            this.T0 = (VideoPbViewModel) ViewModelProviders.of((PbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.b1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        X(true);
        Y(true);
        this.e0 = false;
    }

    @Override // d.a.n0.k2.q.d
    public void N() {
        super.N();
        if (this.a0) {
            O0();
        }
    }

    @Override // d.a.n0.k2.q.d
    public void O() {
        int i2 = this.f60612f & (-33);
        this.f60612f = i2;
        int i3 = this.f60613g & (-33);
        this.f60613g = i3;
        int i4 = this.f60614h & (-33);
        this.f60614h = i4;
        int i5 = this.f60615i & (-33);
        this.f60615i = i5;
        int i6 = this.j & (-33);
        this.j = i6;
        int i7 = this.k & (-33);
        this.k = i7;
        int i8 = this.l & (-33);
        this.l = i8;
        int i9 = this.m & (-33);
        this.m = i9;
        int i10 = this.n & (-33);
        this.n = i10;
        this.f60612f = i2 | 1024;
        int i11 = i3 | 1024;
        this.f60613g = i11;
        this.f60614h = i4 & (-1025);
        this.f60615i = i5 | 1024;
        this.j = i6 | 1024;
        int i12 = i7 | 1024;
        this.k = i12;
        int i13 = i8 | 1024;
        this.l = i13;
        this.m = i9 | 1024;
        this.n = i10 & (-1025);
        this.f60613g = i11 | 16384;
        this.k = i12 | 16384;
        this.l = i13 & (-2);
    }

    public final void O0() {
        if (this.R0 || this.G0.b()) {
            return;
        }
        this.G0.setTranslationX(0.0f);
        this.G0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.G0.getLayoutParams()).bottomMargin = l.g(this.P, this.U ? R.dimen.tbds248 : R.dimen.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.G0, "translationX", 0.0f);
        this.S0 = ofFloat;
        ofFloat.setDuration(500);
        V0();
        e.a().postDelayed(this.g1, 5000L);
    }

    @Override // d.a.n0.k2.q.d
    public void P() {
        this.H.a(this.U, this.a0);
        this.I.e(this.U, this.a0);
        OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
        if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
            ((PbVideoMediaController) operableVideoMediaControllerView).t(this.U, this.a0);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        int i2 = 0;
        int g2 = (this.a0 && this.U) ? l.g(this.P, R.dimen.tbds42) : 0;
        if (this.a0 && !this.U) {
            i2 = l.g(this.P, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = g2;
        layoutParams.rightMargin = i2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N0.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.O0.getLayoutParams();
        int g3 = l.g(this.P, (!this.a0 || this.U) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = g3;
        layoutParams2.rightMargin = g3;
        this.M0.b(this.U, this.a0);
    }

    public final StatisticItem P0(String str) {
        StatisticItem param = new StatisticItem(str).param("tid", this.W).param("fid", this.Y).param("uid", TbadkCoreApplication.getCurrentAccount());
        BaijiahaoData baijiahaoData = this.X0;
        if (baijiahaoData != null) {
            param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            param.param(TiebaStatic.Params.OBJ_PARAM6, this.X0.oriUgcVid);
            int i2 = this.X0.oriUgcType;
            if (i2 == 4) {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i2 == 2) {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        Context context = this.P;
        if ((context instanceof PbActivity) && ((PbActivity) context).getPbModel() != null) {
            param.param("ab_tag", ((PbActivity) this.P).getPbModel().H0()).param("obj_id", ((PbActivity) this.P).getPbModel().I0()).param("obj_source", ((PbActivity) this.P).getPbModel().J0());
        }
        return param;
    }

    public final void Q0() {
        d1();
        UtilHelper.hideStatusBar((Activity) this.P, this.Z0);
        this.c1 = false;
        VideoPbFragment videoPbFragment = this.Y0;
        if (videoPbFragment != null) {
            videoPbFragment.x4(false);
        }
    }

    public boolean R0() {
        return this.c1;
    }

    public boolean S0() {
        return this.U;
    }

    public void T0() {
        V0();
        X(false);
        Y(false);
    }

    @Override // d.a.n0.k2.q.d
    public void U(boolean z) {
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
        }
        super.U(z);
        V0();
        if (this.a0) {
            O0();
        } else {
            this.G0.setVisibility(8);
        }
    }

    public boolean U0() {
        if (this.q == this.n) {
            return false;
        }
        this.L.setVisibility(0);
        this.L.d(this.P, false, 10);
        e.a().removeCallbacks(this.f1);
        e.a().postDelayed(this.f1, 1500L);
        return true;
    }

    public final void V0() {
        e.a().removeCallbacks(this.g1);
        e.a().removeCallbacks(this.h1);
    }

    public void W0(boolean z) {
        this.M0.setIsCountDownValid(z);
    }

    public void X0(boolean z) {
        this.c1 = z;
    }

    public void Y0(a2 a2Var) {
        if (a2Var != null && a2Var.x1() != null && !k.isEmpty(a2Var.x1().video_url)) {
            int i2 = this.q;
            if (i2 == this.f60615i || i2 == this.j) {
                int i3 = this.q | 32768;
                this.q = i3;
                s0(i3);
            }
            int i4 = this.q;
            if (i4 == this.l) {
                int i5 = i4 | 131072;
                this.q = i5;
                s0(i5);
            }
            this.f60615i |= 32768;
            this.j |= 32768;
            this.l |= 131072;
            this.M0.setDate(a2Var);
            return;
        }
        int i6 = this.q;
        if (i6 == this.f60615i || i6 == this.j || i6 == this.l) {
            int i7 = this.q & (-32769);
            this.q = i7;
            int i8 = i7 & (-131073);
            this.q = i8;
            s0(i8);
        }
        this.f60615i &= -32769;
        this.j &= -32769;
        this.l &= -131073;
    }

    public void Z0(a2 a2Var) {
        if (a2Var != null && a2Var.x1() != null && !k.isEmpty(a2Var.x1().video_url)) {
            int i2 = this.q;
            if (i2 == this.f60615i || i2 == this.j) {
                int i3 = this.q | 65536;
                this.q = i3;
                s0(i3);
            }
            this.f60615i |= 65536;
            this.j |= 65536;
            return;
        }
        int i4 = this.q;
        if (i4 == this.f60615i || i4 == this.j) {
            int i5 = this.q & (-65537);
            this.q = i5;
            s0(i5);
        }
        this.f60615i &= -65537;
        this.j &= -65537;
    }

    @Override // d.a.n0.k2.q.d
    public int a0() {
        return R.layout.pb_operable_video_container;
    }

    public void a1(View view) {
        this.Z0 = view;
    }

    public void b1(View view) {
        this.a1 = view;
    }

    public void c1(VideoPbFragment videoPbFragment) {
        this.Y0 = videoPbFragment;
    }

    @Override // d.a.n0.k2.q.d
    public void d0() {
        super.d0();
        this.G0 = (PbVideoFullscreenAttentionLayout) this.R.findViewById(R.id.video_fullscreen_attention);
        this.M0 = (PbNextVideoLayout) this.R.findViewById(R.id.video_next_layout);
        this.N0 = (ImageView) this.R.findViewById(R.id.video_pre);
        this.O0 = (ImageView) this.R.findViewById(R.id.video_next);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.N0, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, null);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O0, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, null);
        this.v.A();
        this.v.setDrawCorner(false);
        this.G0.setOnClickEvent(this);
        this.N0.setOnClickListener(this);
        this.O0.setOnClickListener(this);
        this.M0.setOnClickListener(this);
        this.Q0 = l.k(this.P) / 10;
        this.I.setShareFrom(18);
    }

    public final void d1() {
        if (this.e1 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a1, "alpha", 1.0f, 0.0f);
            this.e1 = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.e1.start();
    }

    @Override // d.a.n0.k2.q.d
    public void e0() {
        this.u.setVolume(1.0f, 1.0f);
    }

    public final void e1() {
        if (this.d1 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a1, "alpha", 0.0f, 1.0f);
            this.d1 = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.d1.start();
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public boolean f0() {
        if (this.q == this.n) {
            return false;
        }
        this.L.setVisibility(0);
        this.L.d(this.P, true, 10);
        e.a().removeCallbacks(this.f1);
        e.a().postDelayed(this.f1, 1500L);
        return true;
    }

    @Override // d.a.n0.k2.q.d
    public boolean g0(MotionEvent motionEvent) {
        return this.a0 || motionEvent.getX() > ((float) this.Q0);
    }

    @Override // d.a.n0.k2.q.d
    public boolean h0() {
        return false;
    }

    @Override // d.a.n0.k2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.play) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view);
        if (id == R.id.concern_video_info_item) {
            V0();
            e.a().post(this.h1);
        } else if (id != R.id.video_next && id != R.id.video_next_layout) {
            if (id == R.id.video_pre) {
                VideoPbViewModel videoPbViewModel = this.T0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.p();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.l &= -131073;
                this.q &= -131073;
                this.M0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.T0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.o(id == R.id.video_next_layout);
            }
            if (id == R.id.video_next) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public boolean r0(boolean z) {
        V0();
        this.G0.setVisibility(8);
        if (!this.b1) {
            Q0();
        }
        if (z) {
            int i2 = this.q;
            this.P0 = i2;
            if (i2 == this.j || ((i2 == this.k && !this.u.isPlaying()) || this.q == this.l)) {
                this.P0 |= 1;
            }
            stopPlay();
        } else {
            int i3 = this.P0;
            if (i3 == -1) {
                startPlay();
            } else if (i3 != this.f60613g && i3 != this.f60615i && i3 != this.f60614h) {
                this.G.setCurrentDuration(n.d().c(this.V), false);
                s0(this.P0);
            } else {
                startPlay();
            }
        }
        return true;
    }

    @Override // d.a.n0.k2.q.d
    public void s0(int i2) {
        VideoPbFragment videoPbFragment;
        if (i2 != this.j && i2 != this.k && i2 != this.f60615i && i2 != this.f60613g) {
            V0();
            PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.G0;
            if (pbVideoFullscreenAttentionLayout != null) {
                pbVideoFullscreenAttentionLayout.setVisibility(8);
            }
        }
        int i3 = this.q;
        int i4 = this.n;
        if (i3 != i4 && i2 == i4) {
            e.a().removeCallbacks(this.f1);
            int i5 = this.q;
            if ((i5 & 16384) > 0) {
                i2 = (i2 | 16384) & (-129) & (-65);
            } else if ((i5 & 128) > 0) {
                i2 = (i2 & (-16385)) | 128 | 64;
            }
            this.n = i2;
        }
        super.s0(i2);
        if (!this.a0) {
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            VideoPbViewModel videoPbViewModel = this.T0;
            if (videoPbViewModel != null) {
                videoPbViewModel.v((i2 & 1024) > 0);
            }
        }
        VideoPbViewModel videoPbViewModel2 = this.T0;
        if (videoPbViewModel2 != null) {
            videoPbViewModel2.v((i2 & 128) > 0);
        }
        OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
        if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
            int i6 = i2 & 16384;
            operableVideoMediaControllerView.setVisibility((i6 > 0 || (i2 & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.G).setBottomBarShow(i6 > 0);
        }
        ImageView imageView = this.N0;
        if (imageView != null) {
            imageView.setVisibility((65536 & i2) > 0 ? 0 : 8);
        }
        ImageView imageView2 = this.O0;
        if (imageView2 != null) {
            imageView2.setVisibility((32768 & i2) > 0 ? 0 : 8);
        }
        if (this.M0 != null) {
            boolean z = (131072 & i2) > 0;
            this.M0.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(P0("c13600"));
            }
        }
        if (this.a0 || this.b1 || !(this.P instanceof Activity)) {
            return;
        }
        if ((i2 & 128) > 0) {
            if (this.c1) {
                return;
            }
            VideoPbFragment videoPbFragment2 = this.Y0;
            if (videoPbFragment2 == null || !videoPbFragment2.H3()) {
                e1();
                UtilHelper.showStatusBar((Activity) this.P, this.Z0);
            }
            this.c1 = true;
            e.a().removeCallbacks(this.i1);
            e.a().postDelayed(this.i1, 3000L);
        } else if (this.c1 || ((videoPbFragment = this.Y0) != null && videoPbFragment.H3())) {
            Q0();
        }
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public void setData(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.X0 = a2Var.V();
        o oVar = new o();
        oVar.f60587a = "6";
        oVar.f60589c = a2Var.z1();
        oVar.f60590d = Long.toString(a2Var.c0());
        oVar.f60591e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (a2Var.V1()) {
                int intExtra = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                this.U0 = intExtra;
                if (intExtra == 0) {
                    this.U0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                this.V0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    oVar.k = this.V0;
                }
                oVar.f60595i = Integer.toString(this.U0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.W0 = stringExtra2;
                oVar.f60595i = stringExtra2;
            }
        }
        if (a2Var.x1() != null) {
            oVar.m = a2Var.x1().video_md5;
            oVar.p = String.valueOf(a2Var.x1().is_vertical);
        }
        n0(oVar);
        this.R0 = false;
        if (this.T0.c().g0()) {
            this.M0.setIsCountDownValid(true);
        } else {
            this.M0.setIsCountDownValid(false);
        }
        if (this.a0 && a2Var.x1() != null) {
            if (this.U != (a2Var.x1().is_vertical.intValue() == 1)) {
                T();
            }
        }
        super.setData(a2Var);
        X(!this.U);
        if (a2Var.T() != null) {
            a2Var.T().setIsLike(a2Var.T().hadConcerned());
        }
        this.G0.setData(a2Var);
    }

    @Override // d.a.n0.k2.q.d, d.a.n0.k2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.G0.setUniqueId(bdUniqueId);
    }

    @Override // d.a.n0.k2.q.d
    public void y0(int i2) {
        if (i2 == R.id.video_full_screen) {
            if (!C()) {
                TiebaStatic.log(new StatisticItem("c13598"));
            } else {
                TiebaStatic.log(new StatisticItem("c13599"));
            }
        } else if (i2 == R.id.video_replay) {
            TiebaStatic.log(P0("c13602"));
        } else if (i2 == R.id.video_play) {
            TiebaStatic.log(new StatisticItem("c13597"));
        } else if (i2 == R.id.video_pause) {
            TiebaStatic.log(new StatisticItem("c13596"));
        } else if (i2 == R.id.video_next_layout) {
            TiebaStatic.log(P0("c13601").param("obj_type", this.M0.l ? 1 : 2));
        }
    }

    @Override // d.a.n0.k2.q.d
    public void z0() {
        o oVar = this.b0;
        if (oVar != null) {
            o b2 = oVar.b();
            b2.f60587a = "pb";
            h.e(b2.m, "", "2", b2, this.u.getPcdnState());
        }
    }
}
