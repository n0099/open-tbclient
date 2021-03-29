package d.b.i0.c2.o.k;

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
import d.b.b.e.m.e;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.i0.i2.h;
import d.b.i0.i2.n;
import d.b.i0.i2.o;
/* loaded from: classes5.dex */
public class a extends d.b.i0.i2.q.d {
    public PbVideoFullscreenAttentionLayout K0;
    public PbNextVideoLayout L0;
    public ImageView M0;
    public ImageView N0;
    public int O0;
    public int P0;
    public boolean Q0;
    public ObjectAnimator R0;
    public VideoPbViewModel S0;
    public int T0;
    public String U0;
    public String V0;
    public BaijiahaoData W0;
    public VideoPbFragment X0;
    public View Y0;
    public View Z0;
    public boolean a1;
    public boolean b1;
    public ObjectAnimator c1;
    public ObjectAnimator d1;
    public Runnable e1;
    public Runnable f1;
    public Runnable g1;
    public Runnable h1;

    /* renamed from: d.b.i0.c2.o.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1179a implements Runnable {
        public RunnableC1179a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.L.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: d.b.i0.c2.o.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1180a extends AnimatorListenerAdapter {
            public C1180a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.T0();
                e.a().postDelayed(a.this.g1, 5000L);
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.K0.b()) {
                return;
            }
            Context context = a.this.P;
            int i = a.this.U ? R.dimen.tbds210 : R.dimen.tbds244;
            a.this.Q0 = true;
            a.this.R0.setFloatValues(-l.g(context, i));
            a.this.R0.removeAllListeners();
            a.this.R0.addListener(new C1180a());
            a.this.R0.start();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: d.b.i0.c2.o.k.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1181a extends AnimatorListenerAdapter {
            public C1181a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.K0.setVisibility(8);
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.R0.setFloatValues(l.g(a.this.P, a.this.U ? R.dimen.tbds210 : R.dimen.tbds244));
            a.this.R0.removeAllListeners();
            a.this.R0.addListener(new C1181a());
            a.this.R0.start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.b1 && (a.this.P instanceof Activity)) {
                a.this.O0();
            }
        }
    }

    public a(Context context, View view) {
        super(context, view);
        this.O0 = -1;
        this.T0 = 0;
        this.e1 = new RunnableC1179a();
        this.f1 = new b();
        this.g1 = new c();
        this.h1 = new d();
        Q();
        if (context instanceof PbActivity) {
            this.S0 = (VideoPbViewModel) ViewModelProviders.of((PbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.a1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        Y(true);
        this.e0 = false;
    }

    public final void M0() {
        if (this.Q0 || this.K0.b()) {
            return;
        }
        this.K0.setTranslationX(0.0f);
        this.K0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.K0.getLayoutParams()).bottomMargin = l.g(this.P, this.U ? R.dimen.tbds248 : R.dimen.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.K0, "translationX", 0.0f);
        this.R0 = ofFloat;
        ofFloat.setDuration(500);
        T0();
        e.a().postDelayed(this.f1, 5000L);
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public boolean N() {
        if (this.q == this.n) {
            return false;
        }
        this.L.setVisibility(0);
        this.L.d(this.P, true, 10);
        e.a().removeCallbacks(this.e1);
        e.a().postDelayed(this.e1, 1500L);
        return true;
    }

    public final StatisticItem N0(String str) {
        StatisticItem param = new StatisticItem(str).param("tid", this.W).param("fid", this.Y).param("uid", TbadkCoreApplication.getCurrentAccount());
        BaijiahaoData baijiahaoData = this.W0;
        if (baijiahaoData != null) {
            param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            param.param(TiebaStatic.Params.OBJ_PARAM6, this.W0.oriUgcVid);
            int i = this.W0.oriUgcType;
            if (i == 4) {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i == 2) {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        Context context = this.P;
        if ((context instanceof PbActivity) && ((PbActivity) context).getPbModel() != null) {
            param.param("ab_tag", ((PbActivity) this.P).getPbModel().D0()).param("obj_id", ((PbActivity) this.P).getPbModel().E0()).param("obj_source", ((PbActivity) this.P).getPbModel().F0());
        }
        return param;
    }

    public final void O0() {
        b1();
        UtilHelper.hideStatusBar((Activity) this.P, this.Y0);
        this.b1 = false;
        VideoPbFragment videoPbFragment = this.X0;
        if (videoPbFragment != null) {
            videoPbFragment.f4(false);
        }
    }

    @Override // d.b.i0.i2.q.d
    public void P() {
        super.P();
        if (this.a0) {
            M0();
        }
    }

    public boolean P0() {
        return this.b1;
    }

    @Override // d.b.i0.i2.q.d
    public void Q() {
        int i = this.f56188f & (-33);
        this.f56188f = i;
        int i2 = this.f56189g & (-33);
        this.f56189g = i2;
        int i3 = this.f56190h & (-33);
        this.f56190h = i3;
        int i4 = this.i & (-33);
        this.i = i4;
        int i5 = this.j & (-33);
        this.j = i5;
        int i6 = this.k & (-33);
        this.k = i6;
        int i7 = this.l & (-33);
        this.l = i7;
        int i8 = this.m & (-33);
        this.m = i8;
        int i9 = this.n & (-33);
        this.n = i9;
        this.f56188f = i | 1024;
        int i10 = i2 | 1024;
        this.f56189g = i10;
        this.f56190h = i3 & (-1025);
        this.i = i4 | 1024;
        this.j = i5 | 1024;
        int i11 = i6 | 1024;
        this.k = i11;
        int i12 = i7 | 1024;
        this.l = i12;
        this.m = i8 | 1024;
        this.n = i9 & (-1025);
        this.f56189g = i10 | 16384;
        this.k = i11 | 16384;
        this.l = i12 & (-2);
    }

    public boolean Q0() {
        return this.U;
    }

    @Override // d.b.i0.i2.q.d
    public void R() {
        this.H.a(this.U, this.a0);
        this.I.e(this.U, this.a0);
        OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
        if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
            ((PbVideoMediaController) operableVideoMediaControllerView).t(this.U, this.a0);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        int i = 0;
        int g2 = (this.a0 && this.U) ? l.g(this.P, R.dimen.tbds42) : 0;
        if (this.a0 && !this.U) {
            i = l.g(this.P, R.dimen.tbds34);
        }
        layoutParams.bottomMargin = g2;
        layoutParams.rightMargin = i;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.M0.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.N0.getLayoutParams();
        int g3 = l.g(this.P, (!this.a0 || this.U) ? R.dimen.tbds104 : R.dimen.tbds208);
        layoutParams3.leftMargin = g3;
        layoutParams2.rightMargin = g3;
        this.L0.b(this.U, this.a0);
    }

    public void R0() {
        T0();
        Y(false);
    }

    public boolean S0() {
        if (this.q == this.n) {
            return false;
        }
        this.L.setVisibility(0);
        this.L.d(this.P, false, 10);
        e.a().removeCallbacks(this.e1);
        e.a().postDelayed(this.e1, 1500L);
        return true;
    }

    public final void T0() {
        e.a().removeCallbacks(this.f1);
        e.a().removeCallbacks(this.g1);
    }

    public void U0(boolean z) {
        this.L0.setIsCountDownValid(z);
    }

    public void V0(boolean z) {
        this.b1 = z;
    }

    @Override // d.b.i0.i2.q.d
    public void W(boolean z) {
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
        }
        super.W(z);
        T0();
        if (this.a0) {
            M0();
        } else {
            this.K0.setVisibility(8);
        }
    }

    public void W0(a2 a2Var) {
        if (a2Var != null && a2Var.u1() != null && !k.isEmpty(a2Var.u1().video_url)) {
            int i = this.q;
            if (i == this.i || i == this.j) {
                int i2 = this.q | 32768;
                this.q = i2;
                r0(i2);
            }
            int i3 = this.q;
            if (i3 == this.l) {
                int i4 = i3 | 131072;
                this.q = i4;
                r0(i4);
            }
            this.i |= 32768;
            this.j |= 32768;
            this.l |= 131072;
            this.L0.setDate(a2Var);
            return;
        }
        int i5 = this.q;
        if (i5 == this.i || i5 == this.j || i5 == this.l) {
            int i6 = this.q & (-32769);
            this.q = i6;
            int i7 = i6 & (-131073);
            this.q = i7;
            r0(i7);
        }
        this.i &= -32769;
        this.j &= -32769;
        this.l &= -131073;
    }

    public void X0(a2 a2Var) {
        if (a2Var != null && a2Var.u1() != null && !k.isEmpty(a2Var.u1().video_url)) {
            int i = this.q;
            if (i == this.i || i == this.j) {
                int i2 = this.q | 65536;
                this.q = i2;
                r0(i2);
            }
            this.i |= 65536;
            this.j |= 65536;
            return;
        }
        int i3 = this.q;
        if (i3 == this.i || i3 == this.j) {
            int i4 = this.q & (-65537);
            this.q = i4;
            r0(i4);
        }
        this.i &= -65537;
        this.j &= -65537;
    }

    public void Y0(View view) {
        this.Y0 = view;
    }

    public void Z0(View view) {
        this.Z0 = view;
    }

    public void a1(VideoPbFragment videoPbFragment) {
        this.X0 = videoPbFragment;
    }

    public final void b1() {
        if (this.d1 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Z0, "alpha", 1.0f, 0.0f);
            this.d1 = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.d1.start();
    }

    @Override // d.b.i0.i2.q.d
    public int c0() {
        return R.layout.pb_operable_video_container;
    }

    public final void c1() {
        if (this.c1 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Z0, "alpha", 0.0f, 1.0f);
            this.c1 = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.c1.start();
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public boolean e0(boolean z) {
        T0();
        this.K0.setVisibility(8);
        if (!this.a1) {
            O0();
        }
        if (z) {
            int i = this.q;
            this.O0 = i;
            if (i == this.j || ((i == this.k && !this.u.isPlaying()) || this.q == this.l)) {
                this.O0 |= 1;
            }
            stopPlay();
        } else {
            int i2 = this.O0;
            if (i2 == -1) {
                startPlay();
            } else if (i2 != this.f56189g && i2 != this.i && i2 != this.f56190h) {
                this.G.setCurrentDuration(n.d().c(this.V), false);
                r0(this.O0);
            } else {
                startPlay();
            }
        }
        return true;
    }

    @Override // d.b.i0.i2.q.d
    public void f0() {
        super.f0();
        this.K0 = (PbVideoFullscreenAttentionLayout) this.R.findViewById(R.id.video_fullscreen_attention);
        this.L0 = (PbNextVideoLayout) this.R.findViewById(R.id.video_next_layout);
        this.M0 = (ImageView) this.R.findViewById(R.id.video_pre);
        this.N0 = (ImageView) this.R.findViewById(R.id.video_next);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.M0, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, null);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.N0, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, null);
        this.v.B();
        this.v.setDrawCorner(false);
        this.K0.setOnClickEvent(this);
        this.M0.setOnClickListener(this);
        this.N0.setOnClickListener(this);
        this.L0.setOnClickListener(this);
        this.P0 = l.k(this.P) / 10;
        this.I.setShareFrom(18);
    }

    @Override // d.b.i0.i2.q.d
    public void g0() {
        this.u.setVolume(1.0f, 1.0f);
    }

    @Override // d.b.i0.i2.q.d
    public boolean h0(MotionEvent motionEvent) {
        return this.a0 || motionEvent.getX() > ((float) this.P0);
    }

    @Override // d.b.i0.i2.q.d
    public boolean i0() {
        return false;
    }

    @Override // d.b.i0.i2.q.d, android.view.View.OnClickListener
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
            T0();
            e.a().post(this.g1);
        } else if (id != R.id.video_next && id != R.id.video_next_layout) {
            if (id == R.id.video_pre) {
                VideoPbViewModel videoPbViewModel = this.S0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.p();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == R.id.pb_next_video_close) {
                this.l &= -131073;
                this.q &= -131073;
                this.L0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.S0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.o(id == R.id.video_next_layout);
            }
            if (id == R.id.video_next) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // d.b.i0.i2.q.d
    public void r0(int i) {
        VideoPbFragment videoPbFragment;
        if (i != this.j && i != this.k && i != this.i && i != this.f56189g) {
            T0();
            PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.K0;
            if (pbVideoFullscreenAttentionLayout != null) {
                pbVideoFullscreenAttentionLayout.setVisibility(8);
            }
        }
        int i2 = this.q;
        int i3 = this.n;
        if (i2 != i3 && i == i3) {
            e.a().removeCallbacks(this.e1);
            int i4 = this.q;
            if ((i4 & 16384) > 0) {
                i = (i | 16384) & (-129) & (-65);
            } else if ((i4 & 128) > 0) {
                i = (i & (-16385)) | 128 | 64;
            }
            this.n = i;
        }
        super.r0(i);
        if (!this.a0) {
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            VideoPbViewModel videoPbViewModel = this.S0;
            if (videoPbViewModel != null) {
                videoPbViewModel.v((i & 1024) > 0);
            }
        }
        VideoPbViewModel videoPbViewModel2 = this.S0;
        if (videoPbViewModel2 != null) {
            videoPbViewModel2.v((i & 128) > 0);
        }
        OperableVideoMediaControllerView operableVideoMediaControllerView = this.G;
        if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
            int i5 = i & 16384;
            operableVideoMediaControllerView.setVisibility((i5 > 0 || (i & 128) > 0) ? 0 : 8);
            ((PbVideoMediaController) this.G).setBottomBarShow(i5 > 0);
        }
        ImageView imageView = this.M0;
        if (imageView != null) {
            imageView.setVisibility((65536 & i) > 0 ? 0 : 8);
        }
        ImageView imageView2 = this.N0;
        if (imageView2 != null) {
            imageView2.setVisibility((32768 & i) > 0 ? 0 : 8);
        }
        if (this.L0 != null) {
            boolean z = (131072 & i) > 0;
            this.L0.setVisibility(z ? 0 : 8);
            if (z) {
                TiebaStatic.log(N0("c13600"));
            }
        }
        if (this.a0 || this.a1 || !(this.P instanceof Activity)) {
            return;
        }
        if ((i & 128) > 0) {
            if (this.b1) {
                return;
            }
            VideoPbFragment videoPbFragment2 = this.X0;
            if (videoPbFragment2 == null || !videoPbFragment2.y3()) {
                c1();
                UtilHelper.showStatusBar((Activity) this.P, this.Y0);
            }
            this.b1 = true;
            e.a().removeCallbacks(this.h1);
            e.a().postDelayed(this.h1, 3000L);
        } else if (this.b1 || ((videoPbFragment = this.X0) != null && videoPbFragment.y3())) {
            O0();
        }
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public void setData(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        this.W0 = a2Var.V();
        o oVar = new o();
        oVar.f56164a = "6";
        oVar.f56166c = a2Var.w1();
        oVar.f56167d = Long.toString(a2Var.c0());
        oVar.f56168e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (a2Var.S1()) {
                int intExtra = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                this.T0 = intExtra;
                if (intExtra == 0) {
                    this.T0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
                this.U0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    oVar.k = this.U0;
                }
                oVar.i = Integer.toString(this.T0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.V0 = stringExtra2;
                oVar.i = stringExtra2;
            }
        }
        if (a2Var.u1() != null) {
            oVar.m = a2Var.u1().video_md5;
            oVar.p = String.valueOf(a2Var.u1().is_vertical);
        }
        Z(oVar);
        this.Q0 = false;
        if (this.S0.c().f0()) {
            this.L0.setIsCountDownValid(true);
        } else {
            this.L0.setIsCountDownValid(false);
        }
        if (this.a0 && a2Var.u1() != null) {
            if (this.U != (a2Var.u1().is_vertical.intValue() == 1)) {
                V();
            }
        }
        super.setData(a2Var);
        Y(!this.U);
        if (a2Var.T() != null) {
            a2Var.T().setIsLike(a2Var.T().hadConcerned());
        }
        this.K0.setData(a2Var);
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.K0.setUniqueId(bdUniqueId);
    }

    @Override // d.b.i0.i2.q.d
    public void w0(int i) {
        if (i == R.id.video_full_screen) {
            if (!D()) {
                TiebaStatic.log(new StatisticItem("c13598"));
            } else {
                TiebaStatic.log(new StatisticItem("c13599"));
            }
        } else if (i == R.id.video_replay) {
            TiebaStatic.log(N0("c13602"));
        } else if (i == R.id.video_play) {
            TiebaStatic.log(new StatisticItem("c13597"));
        } else if (i == R.id.video_pause) {
            TiebaStatic.log(new StatisticItem("c13596"));
        } else if (i == R.id.video_next_layout) {
            TiebaStatic.log(N0("c13601").param("obj_type", this.L0.l ? 1 : 2));
        }
    }

    @Override // d.b.i0.i2.q.d
    public void x0() {
        o oVar = this.b0;
        if (oVar != null) {
            o b2 = oVar.b();
            b2.f56164a = "pb";
            h.e(b2.m, "", "2", b2, this.u.getPcdnState());
        }
    }
}
