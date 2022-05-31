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
/* loaded from: classes6.dex */
public class ix7 extends b58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout N0;
    public PbNextVideoLayout O0;
    public ImageView P0;
    public ImageView Q0;
    public int R0;
    public int S0;
    public boolean T0;
    public ObjectAnimator U0;
    public VideoPbViewModel V0;
    public int W0;
    public String X0;
    public String Y0;
    public BaijiahaoData Z0;
    public AbsVideoPbFragment a1;
    public View b1;
    public View c1;
    public boolean d1;
    public boolean e1;
    public ObjectAnimator f1;
    public ObjectAnimator g1;
    public Runnable h1;
    public Runnable i1;
    public Runnable j1;
    public Runnable k1;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        public a(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        /* loaded from: classes6.dex */
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
                    mg.a().postDelayed(this.a.a.j1, 5000L);
                }
            }
        }

        public b(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.N0.b()) {
                return;
            }
            Context context = this.a.O;
            int i = this.a.T ? R.dimen.tbds210 : R.dimen.tbds244;
            this.a.T0 = true;
            this.a.U0.setFloatValues(-li.f(context, i));
            this.a.U0.removeAllListeners();
            this.a.U0.addListener(new a(this));
            this.a.U0.start();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        /* loaded from: classes6.dex */
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
                    this.a.a.N0.setVisibility(8);
                }
            }
        }

        public c(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U0.setFloatValues(li.f(this.a.O, this.a.T ? R.dimen.tbds210 : R.dimen.tbds244));
                this.a.U0.removeAllListeners();
                this.a.U0.addListener(new a(this));
                this.a.U0.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix7 a;

        public d(ix7 ix7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e1 && (this.a.O instanceof Activity)) {
                this.a.M0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ix7(Context context, View view2) {
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
        this.R0 = -1;
        this.W0 = 0;
        this.h1 = new a(this);
        this.i1 = new b(this);
        this.j1 = new c(this);
        this.k1 = new d(this);
        P();
        if (context instanceof AbsPbActivity) {
            this.V0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            this.d1 = TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity);
        }
        X(true);
        Y(true);
        this.i0 = false;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.T0 || this.N0.b()) {
            return;
        }
        this.N0.setTranslationX(0.0f);
        this.N0.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.N0.getLayoutParams()).bottomMargin = li.f(this.O, this.T ? R.dimen.tbds248 : R.dimen.tbds428);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N0, AnimationProperty.TRANSLATE_X, 0.0f);
        this.U0 = ofFloat;
        ofFloat.setDuration(500);
        R0();
        mg.a().postDelayed(this.i1, 5000L);
    }

    public final StatisticItem L0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.V).param("fid", this.W).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.Z0;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.Z0.oriUgcVid);
                int i = this.Z0.oriUgcType;
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
                param.param("ab_tag", ((AbsPbActivity) this.O).getPbModel().U1()).param("obj_id", ((AbsPbActivity) this.O).getPbModel().V1()).param("obj_source", ((AbsPbActivity) this.O).getPbModel().W1());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Z0();
            UtilHelper.hideStatusBar((Activity) this.O, this.b1);
            this.e1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.a1;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.y4(false);
            }
        }
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e1 : invokeV.booleanValue;
    }

    @Override // com.repackage.b58
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

    @Override // com.repackage.b58
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

    @Override // com.repackage.b58
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
            int f = (this.Y && this.T) ? li.f(this.O, R.dimen.tbds42) : 0;
            if (this.Y && !this.T) {
                i = li.f(this.O, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = f;
            layoutParams.rightMargin = i;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Q0.getLayoutParams();
            int f2 = li.f(this.O, (!this.Y || this.T) ? R.dimen.tbds104 : R.dimen.tbds208);
            layoutParams3.leftMargin = f2;
            layoutParams2.rightMargin = f2;
            this.O0.b(this.T, this.Y);
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
            mg.a().removeCallbacks(this.h1);
            mg.a().postDelayed(this.h1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            mg.a().removeCallbacks(this.i1);
            mg.a().removeCallbacks(this.j1);
        }
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.O0.setIsCountDownValid(z);
        }
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.e1 = z;
        }
    }

    public void U0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !ki.isEmpty(threadData.getThreadVideoInfo().video_url)) {
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
                this.O0.setDate(threadData);
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

    @Override // com.repackage.b58
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
                this.N0.setVisibility(8);
            }
        }
    }

    public void V0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !ki.isEmpty(threadData.getThreadVideoInfo().video_url)) {
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
            this.b1 = view2;
        }
    }

    public void X0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            this.c1 = view2;
        }
    }

    public void Y0(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, absVideoPbFragment) == null) {
            this.a1 = absVideoPbFragment;
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.g1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.g1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.g1.start();
        }
    }

    @Override // com.repackage.b58
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? R.layout.obfuscated_res_0x7f0d067b : invokeV.intValue;
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.f1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.f1.start();
        }
    }

    @Override // com.repackage.b58
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.d0();
            this.N0 = (PbVideoFullscreenAttentionLayout) this.Q.findViewById(R.id.obfuscated_res_0x7f092305);
            this.O0 = (PbNextVideoLayout) this.Q.findViewById(R.id.obfuscated_res_0x7f092329);
            this.P0 = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f09233e);
            this.Q0 = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092328);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P0, R.drawable.obfuscated_res_0x7f080622, R.color.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.Q0, R.drawable.obfuscated_res_0x7f080614, R.color.CAM_X0101, null);
            this.u.t();
            this.u.setDrawCorner(false);
            this.N0.setOnClickEvent(this);
            this.P0.setOnClickListener(this);
            this.Q0.setOnClickListener(this);
            this.O0.setOnClickListener(this);
            this.S0 = li.k(this.O) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // com.repackage.b58
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.repackage.b58
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) ? this.Y || motionEvent.getX() > ((float) this.S0) : invokeL.booleanValue;
    }

    @Override // com.repackage.b58
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.b58
    public void o0(int i) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i != this.g && i != this.h && i != this.f && i != this.d) {
                R0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.N0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i2 = this.p;
            int i3 = this.k;
            if (i2 != i3 && i == i3) {
                mg.a().removeCallbacks(this.h1);
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
                VideoPbViewModel videoPbViewModel = this.V0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.w((i & 1024) > 0);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.V0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.w((i & 128) > 0);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i5 = i & 16384;
                operableVideoMediaControllerView.setVisibility((i5 > 0 || (i & 128) > 0) ? 0 : 8);
                ((PbVideoMediaController) this.F).setBottomBarShow(i5 > 0);
            }
            ImageView imageView = this.P0;
            if (imageView != null) {
                imageView.setVisibility((65536 & i) > 0 ? 0 : 8);
            }
            ImageView imageView2 = this.Q0;
            if (imageView2 != null) {
                imageView2.setVisibility((32768 & i) > 0 ? 0 : 8);
            }
            if (this.O0 != null) {
                boolean z = (131072 & i) > 0;
                this.O0.setVisibility(z ? 0 : 8);
                if (z) {
                    TiebaStatic.log(L0("c13600"));
                }
            }
            if (this.Y || this.d1 || !(this.O instanceof Activity)) {
                return;
            }
            if ((i & 128) > 0) {
                if (this.e1) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment2 = this.a1;
                if (absVideoPbFragment2 == null || !absVideoPbFragment2.O3()) {
                    a1();
                    UtilHelper.showStatusBar((Activity) this.O, this.b1);
                }
                this.e1 = true;
                mg.a().removeCallbacks(this.k1);
                mg.a().postDelayed(this.k1, 3000L);
            } else if (this.e1 || ((absVideoPbFragment = this.a1) != null && absVideoPbFragment.O3())) {
                M0();
            }
        }
    }

    @Override // com.repackage.b58, com.repackage.y48
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            R0();
            this.N0.setVisibility(8);
            if (!this.d1) {
                M0();
            }
            if (z) {
                int i = this.p;
                this.R0 = i;
                if (i == this.g || ((i == this.h && !this.t.getControl().isPlaying()) || this.p == this.i)) {
                    this.R0 |= 1;
                }
                stopPlay();
            } else {
                int i2 = this.R0;
                if (i2 == -1) {
                    startPlay();
                } else if (i2 != this.d && i2 != this.f && i2 != this.e && i2 != this.n) {
                    this.F.setCurrentDuration(s48.d().c(this.U), false);
                    o0(this.R0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.repackage.b58, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, view2) == null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f09185c) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view2);
        if (id == R.id.obfuscated_res_0x7f0906a0) {
            R0();
            mg.a().post(this.j1);
        } else if (id == R.id.obfuscated_res_0x7f092328 || id == R.id.obfuscated_res_0x7f092329) {
            VideoPbViewModel videoPbViewModel = this.V0;
            if (videoPbViewModel != null) {
                videoPbViewModel.p(id == R.id.obfuscated_res_0x7f092329);
            }
            if (id == R.id.obfuscated_res_0x7f092328) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        } else if (id == R.id.obfuscated_res_0x7f09233e) {
            VideoPbViewModel videoPbViewModel2 = this.V0;
            if (videoPbViewModel2 != null) {
                videoPbViewModel2.q();
            }
            TiebaStatic.log(new StatisticItem("c13594"));
        } else if (id == R.id.obfuscated_res_0x7f0916e0) {
            this.i &= -131073;
            this.p &= -131073;
            this.O0.setVisibility(8);
        }
    }

    @Override // com.repackage.b58, com.repackage.y48
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, true, 10);
            mg.a().removeCallbacks(this.h1);
            mg.a().postDelayed(this.h1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.b58, com.repackage.y48
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, threadData) == null) || threadData == null) {
            return;
        }
        this.Z0 = threadData.getBaijiahaoData();
        t48 t48Var = new t48();
        t48Var.a = "6";
        t48Var.c = threadData.getTid();
        t48Var.d = Long.toString(threadData.getFid());
        t48Var.e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.O;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.W0 = intExtra;
                if (intExtra == 0) {
                    this.W0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.X0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    t48Var.k = this.X0;
                }
                t48Var.i = Integer.toString(this.W0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Y0 = stringExtra2;
                t48Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            t48Var.m = threadData.getThreadVideoInfo().video_md5;
            t48Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(t48Var);
        this.T0 = false;
        if (this.V0.c().s0()) {
            this.O0.setIsCountDownValid(true);
        } else {
            this.O0.setIsCountDownValid(false);
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
        this.N0.setData(threadData);
    }

    @Override // com.repackage.b58, com.repackage.y48
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.N0.setUniqueId(bdUniqueId);
        }
    }

    @Override // com.repackage.b58
    public void u0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == R.id.obfuscated_res_0x7f092303) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i == R.id.obfuscated_res_0x7f092344) {
                TiebaStatic.log(L0("c13602"));
            } else if (i == R.id.obfuscated_res_0x7f092335) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i == R.id.obfuscated_res_0x7f09232a) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i == R.id.obfuscated_res_0x7f092329) {
                TiebaStatic.log(L0("c13601").param("obj_type", this.O0.h ? 1 : 2));
            }
        }
    }

    @Override // com.repackage.b58
    public void v0() {
        t48 t48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (t48Var = this.Z) == null) {
            return;
        }
        t48 b2 = t48Var.b();
        b2.a = "pb";
        i48.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
    }
}
