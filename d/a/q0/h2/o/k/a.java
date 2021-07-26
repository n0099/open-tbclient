package d.a.q0.h2.o.k;

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
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.videoView.PbNextVideoLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoFullscreenAttentionLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoMediaController;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.e;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.q0.n2.h;
import d.a.q0.n2.n;
import d.a.q0.n2.o;
/* loaded from: classes8.dex */
public class a extends d.a.q0.n2.q.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout L0;
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
    public AbsVideoPbFragment Y0;
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

    /* renamed from: d.a.q0.h2.o.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1448a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58429e;

        public RunnableC1448a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58429e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58429e.L.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58430e;

        /* renamed from: d.a.q0.h2.o.k.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1449a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f58431e;

            public C1449a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58431e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f58431e.f58430e.V0();
                    e.a().postDelayed(this.f58431e.f58430e.h1, 5000L);
                }
            }
        }

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58430e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58430e.L0.b()) {
                return;
            }
            Context context = this.f58430e.P;
            int i2 = this.f58430e.U ? R.dimen.tbds210 : R.dimen.tbds244;
            this.f58430e.R0 = true;
            this.f58430e.S0.setFloatValues(-l.g(context, i2));
            this.f58430e.S0.removeAllListeners();
            this.f58430e.S0.addListener(new C1449a(this));
            this.f58430e.S0.start();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58432e;

        /* renamed from: d.a.q0.h2.o.k.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1450a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f58433e;

            public C1450a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58433e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f58433e.f58432e.L0.setVisibility(8);
                }
            }
        }

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58432e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58432e.S0.setFloatValues(l.g(this.f58432e.P, this.f58432e.U ? R.dimen.tbds210 : R.dimen.tbds244));
                this.f58432e.S0.removeAllListeners();
                this.f58432e.S0.addListener(new C1450a(this));
                this.f58432e.S0.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58434e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58434e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58434e.c1 && (this.f58434e.P instanceof Activity)) {
                this.f58434e.Q0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, View view) {
        super(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.P0 = -1;
        this.U0 = 0;
        this.f1 = new RunnableC1448a(this);
        this.g1 = new b(this);
        this.h1 = new c(this);
        this.i1 = new d(this);
        O();
        if (context instanceof AbsPbActivity) {
            this.T0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.b1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        X(true);
        Y(true);
        this.j0 = false;
    }

    @Override // d.a.q0.n2.q.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.N();
            if (this.a0) {
                O0();
            }
        }
    }

    @Override // d.a.q0.n2.q.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.f61448f & (-33);
            this.f61448f = i2;
            int i3 = this.f61449g & (-33);
            this.f61449g = i3;
            int i4 = this.f61450h & (-33);
            this.f61450h = i4;
            int i5 = this.f61451i & (-33);
            this.f61451i = i5;
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
            this.f61448f = i2 | 1024;
            int i11 = i3 | 1024;
            this.f61449g = i11;
            this.f61450h = i4 & (-1025);
            this.f61451i = i5 | 1024;
            this.j = i6 | 1024;
            int i12 = i7 | 1024;
            this.k = i12;
            int i13 = i8 | 1024;
            this.l = i13;
            this.m = i9 | 1024;
            this.n = i10 & (-1025);
            this.f61449g = i11 | 16384;
            this.k = i12 | 16384;
            this.l = i13 & (-2);
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.R0 || this.L0.b()) {
            return;
        }
        this.L0.setTranslationX(0.0f);
        this.L0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.L0.getLayoutParams()).bottomMargin = l.g(this.P, this.U ? R.dimen.tbds248 : R.dimen.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.L0, "translationX", 0.0f);
        this.S0 = ofFloat;
        ofFloat.setDuration(500);
        V0();
        e.a().postDelayed(this.g1, 5000L);
    }

    @Override // d.a.q0.n2.q.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
    }

    public final StatisticItem P0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
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
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).getPbModel() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.P).getPbModel().Q0()).param("obj_id", ((AbsPbActivity) this.P).getPbModel().R0()).param("obj_source", ((AbsPbActivity) this.P).getPbModel().S0());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d1();
            UtilHelper.hideStatusBar((Activity) this.P, this.Z0);
            this.c1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.Y0;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.y4(false);
            }
        }
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c1 : invokeV.booleanValue;
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            V0();
            X(false);
            Y(false);
        }
    }

    @Override // d.a.q0.n2.q.d
    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            Context context = this.P;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.a0);
            }
            super.U(z);
            V0();
            if (this.a0) {
                O0();
            } else {
                this.L0.setVisibility(8);
            }
        }
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.d(this.P, false, 10);
            e.a().removeCallbacks(this.f1);
            e.a().postDelayed(this.f1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e.a().removeCallbacks(this.g1);
            e.a().removeCallbacks(this.h1);
        }
    }

    public void W0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.M0.setIsCountDownValid(z);
        }
    }

    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.c1 = z;
        }
    }

    public void Y0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b2Var) == null) {
            if (b2Var != null && b2Var.m1() != null && !k.isEmpty(b2Var.m1().video_url)) {
                int i2 = this.q;
                if (i2 == this.f61451i || i2 == this.j) {
                    int i3 = this.q | 32768;
                    this.q = i3;
                    p0(i3);
                }
                int i4 = this.q;
                if (i4 == this.l) {
                    int i5 = i4 | 131072;
                    this.q = i5;
                    p0(i5);
                }
                this.f61451i |= 32768;
                this.j |= 32768;
                this.l |= 131072;
                this.M0.setDate(b2Var);
                return;
            }
            int i6 = this.q;
            if (i6 == this.f61451i || i6 == this.j || i6 == this.l) {
                int i7 = this.q & (-32769);
                this.q = i7;
                int i8 = i7 & (-131073);
                this.q = i8;
                p0(i8);
            }
            this.f61451i &= -32769;
            this.j &= -32769;
            this.l &= -131073;
        }
    }

    public void Z0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, b2Var) == null) {
            if (b2Var != null && b2Var.m1() != null && !k.isEmpty(b2Var.m1().video_url)) {
                int i2 = this.q;
                if (i2 == this.f61451i || i2 == this.j) {
                    int i3 = this.q | 65536;
                    this.q = i3;
                    p0(i3);
                }
                this.f61451i |= 65536;
                this.j |= 65536;
                return;
            }
            int i4 = this.q;
            if (i4 == this.f61451i || i4 == this.j) {
                int i5 = this.q & (-65537);
                this.q = i5;
                p0(i5);
            }
            this.f61451i &= -65537;
            this.j &= -65537;
        }
    }

    @Override // d.a.q0.n2.q.d
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.pb_operable_video_container : invokeV.intValue;
    }

    public void a1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            this.Z0 = view;
        }
    }

    public void b1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            this.a1 = view;
        }
    }

    public void c1(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, absVideoPbFragment) == null) {
            this.Y0 = absVideoPbFragment;
        }
    }

    @Override // d.a.q0.n2.q.d
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.d0();
            this.L0 = (PbVideoFullscreenAttentionLayout) this.R.findViewById(R.id.video_fullscreen_attention);
            this.M0 = (PbNextVideoLayout) this.R.findViewById(R.id.video_next_layout);
            this.N0 = (ImageView) this.R.findViewById(R.id.video_pre);
            this.O0 = (ImageView) this.R.findViewById(R.id.video_next);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.N0, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O0, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, null);
            this.v.s();
            this.v.setDrawCorner(false);
            this.L0.setOnClickEvent(this);
            this.N0.setOnClickListener(this);
            this.O0.setOnClickListener(this);
            this.M0.setOnClickListener(this);
            this.Q0 = l.k(this.P) / 10;
            this.I.setShareFrom(18);
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.e1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a1, "alpha", 1.0f, 0.0f);
                this.e1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.e1.start();
        }
    }

    @Override // d.a.q0.n2.q.d
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.u.setVolume(1.0f, 1.0f);
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.d1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a1, "alpha", 0.0f, 1.0f);
                this.d1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.d1.start();
        }
    }

    @Override // d.a.q0.n2.q.d
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) ? this.a0 || motionEvent.getX() > ((float) this.Q0) : invokeL.booleanValue;
    }

    @Override // d.a.q0.n2.q.d
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.q == this.n) {
                return false;
            }
            this.L.setVisibility(0);
            this.L.d(this.P, true, 10);
            e.a().removeCallbacks(this.f1);
            e.a().postDelayed(this.f1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, view) == null) || view == null) {
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

    @Override // d.a.q0.n2.q.d
    public void p0(int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 != this.j && i2 != this.k && i2 != this.f61451i && i2 != this.f61449g) {
                V0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.L0;
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
            super.p0(i2);
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
                AbsVideoPbFragment absVideoPbFragment2 = this.Y0;
                if (absVideoPbFragment2 == null || !absVideoPbFragment2.Q3()) {
                    e1();
                    UtilHelper.showStatusBar((Activity) this.P, this.Z0);
                }
                this.c1 = true;
                e.a().removeCallbacks(this.i1);
                e.a().postDelayed(this.i1, 3000L);
            } else if (this.c1 || ((absVideoPbFragment = this.Y0) != null && absVideoPbFragment.Q3())) {
                Q0();
            }
        }
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.X0 = b2Var.J();
        o oVar = new o();
        oVar.f61423a = "6";
        oVar.f61425c = b2Var.o1();
        oVar.f61426d = Long.toString(b2Var.R());
        oVar.f61427e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.P;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (b2Var.J1()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.U0 = intExtra;
                if (intExtra == 0) {
                    this.U0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.V0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    oVar.k = this.V0;
                }
                oVar.f61431i = Integer.toString(this.U0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.W0 = stringExtra2;
                oVar.f61431i = stringExtra2;
            }
        }
        if (b2Var.m1() != null) {
            oVar.m = b2Var.m1().video_md5;
            oVar.p = String.valueOf(b2Var.m1().is_vertical);
        }
        q0(oVar);
        this.R0 = false;
        if (this.T0.c().m0()) {
            this.M0.setIsCountDownValid(true);
        } else {
            this.M0.setIsCountDownValid(false);
        }
        if (this.a0 && b2Var.m1() != null) {
            if (this.U != (b2Var.m1().is_vertical.intValue() == 1)) {
                T();
            }
        }
        super.setData(b2Var);
        X(!this.U);
        if (b2Var.H() != null) {
            b2Var.H().setIsLike(b2Var.H().hadConcerned());
        }
        this.L0.setData(b2Var);
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.L0.setUniqueId(bdUniqueId);
        }
    }

    @Override // d.a.q0.n2.q.d, d.a.q0.n2.q.a
    public boolean v0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
            V0();
            this.L0.setVisibility(8);
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
                } else if (i3 != this.f61449g && i3 != this.f61451i && i3 != this.f61450h) {
                    this.G.setCurrentDuration(n.d().c(this.V), false);
                    p0(this.P0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // d.a.q0.n2.q.d
    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
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
    }

    @Override // d.a.q0.n2.q.d
    public void z0() {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (oVar = this.b0) == null) {
            return;
        }
        o b2 = oVar.b();
        b2.f61423a = "pb";
        h.e(b2.m, "", "2", b2, this.u.getPcdnState());
    }
}
