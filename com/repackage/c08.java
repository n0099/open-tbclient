package com.repackage;

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
import com.baidu.tbadk.core.data.ThreadData;
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
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes5.dex */
public class c08 extends u78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout M0;
    public PbNextVideoLayout N0;
    public ImageView O0;
    public ImageView P0;
    public int Q0;
    public int R0;
    public boolean S0;
    public ObjectAnimator T0;
    public VideoPbViewModel U0;
    public int V0;
    public String W0;
    public String X0;
    public BaijiahaoData Y0;
    public AbsVideoPbFragment Z0;
    public View a1;
    public View b1;
    public boolean c1;
    public boolean d1;
    public ObjectAnimator e1;
    public ObjectAnimator f1;
    public Runnable g1;
    public Runnable h1;
    public Runnable i1;
    public Runnable j1;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c08 a;

        public a(c08 c08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c08Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c08 a;

        /* loaded from: classes5.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.R0();
                    pg.a().postDelayed(this.a.a.i1, 5000L);
                }
            }
        }

        public b(c08 c08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c08Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.M0.b()) {
                return;
            }
            Context context = this.a.O;
            int i = this.a.T ? R.dimen.tbds210 : R.dimen.tbds244;
            this.a.S0 = true;
            this.a.T0.setFloatValues(-oi.f(context, i));
            this.a.T0.removeAllListeners();
            this.a.T0.addListener(new a(this));
            this.a.T0.start();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c08 a;

        /* loaded from: classes5.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.M0.setVisibility(8);
                }
            }
        }

        public c(c08 c08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c08Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.T0.setFloatValues(oi.f(this.a.O, this.a.T ? R.dimen.tbds210 : R.dimen.tbds244));
                this.a.T0.removeAllListeners();
                this.a.T0.addListener(new a(this));
                this.a.T0.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c08 a;

        public d(c08 c08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c08Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d1 && (this.a.O instanceof Activity)) {
                this.a.M0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c08(Context context, View view2) {
        super(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Q0 = -1;
        this.V0 = 0;
        this.g1 = new a(this);
        this.h1 = new b(this);
        this.i1 = new c(this);
        this.j1 = new d(this);
        P();
        if (context instanceof AbsPbActivity) {
            this.U0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.c1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        X(true);
        Y(true);
        this.i0 = false;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.S0 || this.M0.b()) {
            return;
        }
        this.M0.setTranslationX(0.0f);
        this.M0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.M0.getLayoutParams()).bottomMargin = oi.f(this.O, this.T ? R.dimen.tbds248 : R.dimen.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.M0, AnimationProperty.TRANSLATE_X, 0.0f);
        this.T0 = ofFloat;
        ofFloat.setDuration(500);
        R0();
        pg.a().postDelayed(this.h1, 5000L);
    }

    public final StatisticItem L0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.V).param("fid", this.W).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.Y0;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.Y0.oriUgcVid);
                int i = this.Y0.oriUgcType;
                if (i == 4) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (i == 2) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
            }
            Context context = this.O;
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).getPbModel() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.O).getPbModel().Y0()).param("obj_id", ((AbsPbActivity) this.O).getPbModel().Z0()).param("obj_source", ((AbsPbActivity) this.O).getPbModel().a1());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Z0();
            UtilHelper.hideStatusBar((Activity) this.O, this.a1);
            this.d1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.Z0;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.t4(false);
            }
        }
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d1 : invokeV.booleanValue;
    }

    @Override // com.repackage.u78
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.O();
            if (this.Y) {
                K0();
            }
        }
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.T : invokeV.booleanValue;
    }

    @Override // com.repackage.u78
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i = this.b & (-33);
            this.b = i;
            int i2 = this.o & (-33);
            this.o = i2;
            int i3 = this.d & (-33);
            this.d = i3;
            int i4 = this.e & (-33);
            this.e = i4;
            int i5 = this.n & (-33);
            this.n = i5;
            int i6 = this.f & (-33);
            this.f = i6;
            int i7 = this.g & (-33);
            this.g = i7;
            int i8 = this.h & (-33);
            this.h = i8;
            int i9 = this.i & (-33);
            this.i = i9;
            int i10 = this.j & (-33);
            this.j = i10;
            int i11 = this.k & (-33);
            this.k = i11;
            this.b = i | 1024;
            this.o = i2 | 1024;
            int i12 = i3 | 1024;
            this.d = i12;
            this.e = i4 & (-1025);
            this.n = i5 & (-1025);
            this.f = i6 | 1024;
            this.g = i7 | 1024;
            int i13 = i8 | 1024;
            this.h = i13;
            int i14 = i9 | 1024;
            this.i = i14;
            this.j = i10 | 1024;
            this.k = i11 & (-1025);
            this.d = i12 | 16384;
            this.h = i13 | 16384;
            this.i = i14 & (-2);
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            R0();
            X(false);
            Y(false);
        }
    }

    @Override // com.repackage.u78
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                ((PbVideoMediaController) operableVideoMediaControllerView).q(this.T, this.Y);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i = 0;
            int f = (this.Y && this.T) ? oi.f(this.O, R.dimen.tbds42) : 0;
            if (this.Y && !this.T) {
                i = oi.f(this.O, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = f;
            layoutParams.rightMargin = i;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.O0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
            int f2 = oi.f(this.O, (!this.Y || this.T) ? R.dimen.tbds104 : R.dimen.tbds208);
            layoutParams3.leftMargin = f2;
            layoutParams2.rightMargin = f2;
            this.N0.b(this.T, this.Y);
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, false, 10);
            pg.a().removeCallbacks(this.g1);
            pg.a().postDelayed(this.g1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            pg.a().removeCallbacks(this.h1);
            pg.a().removeCallbacks(this.i1);
        }
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.N0.setIsCountDownValid(z);
        }
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.d1 = z;
        }
    }

    public void U0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !ni.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                int i = this.p;
                if (i == this.f || i == this.g) {
                    int i2 = this.p | 32768;
                    this.p = i2;
                    o0(i2);
                }
                int i3 = this.p;
                if (i3 == this.i) {
                    int i4 = i3 | 131072;
                    this.p = i4;
                    o0(i4);
                }
                this.f |= 32768;
                this.g |= 32768;
                this.i |= 131072;
                this.N0.setDate(threadData);
                return;
            }
            int i5 = this.p;
            if (i5 == this.f || i5 == this.g || i5 == this.i) {
                int i6 = this.p & (-32769);
                this.p = i6;
                int i7 = i6 & (-131073);
                this.p = i7;
                o0(i7);
            }
            this.f &= -32769;
            this.g &= -32769;
            this.i &= -131073;
        }
    }

    @Override // com.repackage.u78
    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            Context context = this.O;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.Y);
            }
            super.V(z);
            R0();
            if (this.Y) {
                K0();
            } else {
                this.M0.setVisibility(8);
            }
        }
    }

    public void V0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !ni.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                int i = this.p;
                if (i == this.f || i == this.g) {
                    int i2 = this.p | 65536;
                    this.p = i2;
                    o0(i2);
                }
                this.f |= 65536;
                this.g |= 65536;
                return;
            }
            int i3 = this.p;
            if (i3 == this.f || i3 == this.g) {
                int i4 = this.p & (-65537);
                this.p = i4;
                o0(i4);
            }
            this.f &= -65537;
            this.g &= -65537;
        }
    }

    public void W0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            this.a1 = view2;
        }
    }

    public void X0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            this.b1 = view2;
        }
    }

    public void Y0(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, absVideoPbFragment) == null) {
            this.Z0 = absVideoPbFragment;
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.f1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b1, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.f1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.f1.start();
        }
    }

    @Override // com.repackage.u78
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? R.layout.obfuscated_res_0x7f0d0694 : invokeV.intValue;
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.e1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b1, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.e1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.e1.start();
        }
    }

    @Override // com.repackage.u78
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.d0();
            this.M0 = (PbVideoFullscreenAttentionLayout) this.Q.findViewById(R.id.obfuscated_res_0x7f09230c);
            this.N0 = (PbNextVideoLayout) this.Q.findViewById(R.id.obfuscated_res_0x7f09232e);
            this.O0 = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092349);
            this.P0 = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f09232d);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O0, R.drawable.obfuscated_res_0x7f080635, R.color.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P0, R.drawable.obfuscated_res_0x7f080627, R.color.CAM_X0101, null);
            this.u.t();
            this.u.setDrawCorner(false);
            this.M0.setOnClickEvent(this);
            this.O0.setOnClickListener(this);
            this.P0.setOnClickListener(this);
            this.N0.setOnClickListener(this);
            this.R0 = oi.k(this.O) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // com.repackage.u78
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.repackage.u78
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) ? this.Y || motionEvent.getX() > ((float) this.R0) : invokeL.booleanValue;
    }

    @Override // com.repackage.u78
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.u78
    public void o0(int i) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i != this.g && i != this.h && i != this.f && i != this.d) {
                R0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.M0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i2 = this.p;
            int i3 = this.k;
            if (i2 != i3 && i == i3) {
                pg.a().removeCallbacks(this.g1);
                int i4 = this.p;
                if ((i4 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i4 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.o0(i);
            if (!this.Y) {
                this.I.setVisibility(8);
                this.J.setVisibility(8);
                VideoPbViewModel videoPbViewModel = this.U0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.w((i & 1024) > 0);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.U0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.w((i & 128) > 0);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i5 = i & 16384;
                operableVideoMediaControllerView.setVisibility((i5 > 0 || (i & 128) > 0) ? 0 : 8);
                ((PbVideoMediaController) this.F).setBottomBarShow(i5 > 0);
            }
            ImageView imageView = this.O0;
            if (imageView != null) {
                imageView.setVisibility((65536 & i) > 0 ? 0 : 8);
            }
            ImageView imageView2 = this.P0;
            if (imageView2 != null) {
                imageView2.setVisibility((32768 & i) > 0 ? 0 : 8);
            }
            if (this.N0 != null) {
                boolean z = (131072 & i) > 0;
                this.N0.setVisibility(z ? 0 : 8);
                if (z) {
                    TiebaStatic.log(L0("c13600"));
                }
            }
            if (this.Y || this.c1 || !(this.O instanceof Activity)) {
                return;
            }
            if ((i & 128) > 0) {
                if (this.d1) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment2 = this.Z0;
                if (absVideoPbFragment2 == null || !absVideoPbFragment2.J3()) {
                    a1();
                    UtilHelper.showStatusBar((Activity) this.O, this.a1);
                }
                this.d1 = true;
                pg.a().removeCallbacks(this.j1);
                pg.a().postDelayed(this.j1, 3000L);
            } else if (this.d1 || ((absVideoPbFragment = this.Z0) != null && absVideoPbFragment.J3())) {
                M0();
            }
        }
    }

    @Override // com.repackage.u78, com.repackage.r78
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            R0();
            this.M0.setVisibility(8);
            if (!this.c1) {
                M0();
            }
            if (z) {
                int i = this.p;
                this.Q0 = i;
                if (i == this.g || ((i == this.h && !this.t.getControl().isPlaying()) || this.p == this.i)) {
                    this.Q0 |= 1;
                }
                stopPlay();
            } else {
                int i2 = this.Q0;
                if (i2 == -1) {
                    startPlay();
                } else if (i2 != this.d && i2 != this.f && i2 != this.e && i2 != this.n) {
                    this.F.setCurrentDuration(l78.d().c(this.U), false);
                    o0(this.Q0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.repackage.u78, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, view2) == null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f09184f) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view2);
        if (id == R.id.obfuscated_res_0x7f0906c2) {
            R0();
            pg.a().post(this.i1);
        } else if (id == R.id.obfuscated_res_0x7f09232d || id == R.id.obfuscated_res_0x7f09232e) {
            VideoPbViewModel videoPbViewModel = this.U0;
            if (videoPbViewModel != null) {
                videoPbViewModel.p(id == R.id.obfuscated_res_0x7f09232e);
            }
            if (id == R.id.obfuscated_res_0x7f09232d) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        } else if (id == R.id.obfuscated_res_0x7f092349) {
            VideoPbViewModel videoPbViewModel2 = this.U0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.q();
            }
            TiebaStatic.log(new StatisticItem("c13594"));
        } else if (id == R.id.obfuscated_res_0x7f091703) {
            this.i &= -131073;
            this.p &= -131073;
            this.N0.setVisibility(8);
        }
    }

    @Override // com.repackage.u78, com.repackage.r78
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, true, 10);
            pg.a().removeCallbacks(this.g1);
            pg.a().postDelayed(this.g1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.u78, com.repackage.r78
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, threadData) == null) || threadData == null) {
            return;
        }
        this.Y0 = threadData.getBaijiahaoData();
        m78 m78Var = new m78();
        m78Var.a = "6";
        m78Var.c = threadData.getTid();
        m78Var.d = Long.toString(threadData.getFid());
        m78Var.e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.O;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.V0 = intExtra;
                if (intExtra == 0) {
                    this.V0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.W0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    m78Var.k = this.W0;
                }
                m78Var.i = Integer.toString(this.V0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.X0 = stringExtra2;
                m78Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            m78Var.m = threadData.getThreadVideoInfo().video_md5;
            m78Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(m78Var);
        this.S0 = false;
        if (this.U0.c().s0()) {
            this.N0.setIsCountDownValid(true);
        } else {
            this.N0.setIsCountDownValid(false);
        }
        if (this.Y && threadData.getThreadVideoInfo() != null) {
            if (this.T != (threadData.getThreadVideoInfo().is_vertical.intValue() == 1)) {
                U();
            }
        }
        super.setData(threadData);
        X(!this.T);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        this.M0.setData(threadData);
    }

    @Override // com.repackage.u78, com.repackage.r78
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.M0.setUniqueId(bdUniqueId);
        }
    }

    @Override // com.repackage.u78
    public void u0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == R.id.obfuscated_res_0x7f09230a) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i == R.id.obfuscated_res_0x7f09234f) {
                TiebaStatic.log(L0("c13602"));
            } else if (i == R.id.obfuscated_res_0x7f09233f) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i == R.id.obfuscated_res_0x7f092334) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i == R.id.obfuscated_res_0x7f09232e) {
                TiebaStatic.log(L0("c13601").param("obj_type", this.N0.h ? 1 : 2));
            }
        }
    }

    @Override // com.repackage.u78
    public void v0() {
        m78 m78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (m78Var = this.Z) == null) {
            return;
        }
        m78 b2 = m78Var.b();
        b2.a = "pb";
        b78.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
    }
}
