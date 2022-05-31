package com.repackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.operableVideoView.OperableVideoErrorView;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.tieba.play.operableVideoView.OperableVideoShareView;
import com.baidu.tieba.play.operableVideoView.PercentSizeView;
import com.baidu.tieba.play.operableVideoView.VideoGestureView;
import com.baidu.tieba.view.SwitchImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.repackage.g48;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes5.dex */
public class b58 implements y48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View.OnClickListener A0;
    public TextView B;
    public ic0 B0;
    public TextView C;
    public McnAdInfo C0;
    public SwitchImageView D;
    public boolean D0;
    public SwitchImageView E;
    public l E0;
    public OperableVideoMediaControllerView F;
    public long F0;
    public OperableVideoNetworkStateTipView G;
    public g48.c G0;
    public OperableVideoShareView H;
    public CustomMessageListener H0;
    public ImageView I;
    public SeekBar.OnSeekBarChangeListener I0;
    public View J;
    public GestureDetector.SimpleOnGestureListener J0;
    public VideoGestureView K;
    public View.OnTouchListener K0;
    public View L;
    public TbVideoViewSet.b L0;
    public OperableVideoErrorView M;
    public final CustomMessageListener M0;
    public WeakReference<Context> N;
    public Context O;
    public View P;
    public ViewGroup Q;
    public BdUniqueId R;
    public boolean S;
    public boolean T;
    public String U;
    public String V;
    public long W;
    public k48 X;
    public boolean Y;
    public t48 Z;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public ThreadData g0;
    public int h;
    public String h0;
    public int i;
    public boolean i0;
    public int j;
    public boolean j0;
    public int k;
    public String k0;
    public int l;
    public boolean l0;
    public int m;
    public boolean m0;
    public int n;
    public float n0;
    public int o;
    public float o0;
    public int p;
    public GestureDetector p0;
    public int q;
    public int q0;
    public int r;
    public int[] r0;
    public Runnable s;
    public int s0;
    public TbVideoViewContainer t;
    public boolean t0;
    public TbImageView u;
    public int u0;
    public View v;
    public int v0;
    public TBLottieAnimationView w;
    public float w0;
    public ImageView x;
    public int x0;
    public ImageView y;
    public boolean y0;
    public PercentSizeView z;
    public boolean z0;

    /* loaded from: classes5.dex */
    public class a implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public a(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.m0) {
                    b58 b58Var = this.a;
                    b58Var.o0(b58Var.o);
                    this.a.m0 = false;
                } else {
                    b58 b58Var2 = this.a;
                    b58Var2.o0(b58Var2.b);
                }
                this.a.s0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.t.a();
                this.a.q0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b58 b58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.a.stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public c(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b58 b58Var = this.a;
                b58Var.o0(b58Var.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements g48.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public d(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // com.repackage.g48.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.F0 <= 0) {
                    this.a.F0 = i2;
                }
                if (this.a.h0()) {
                    b58 b58Var = this.a;
                    if (!b58Var.T && !b58Var.Y && b58Var.D0) {
                        if (hc0.b().a(this.a.C0.jump_url)) {
                            return;
                        }
                        long j = i2;
                        boolean z = j >= this.a.C0.ad_start_time.longValue() * 1000 && j < this.a.C0.ad_end_time.longValue() * 1000;
                        boolean z2 = this.a.F0 >= (this.a.C0.ad_start_time.longValue() * 1000) + 1000;
                        if (this.a.B0 == null) {
                            b58 b58Var2 = this.a;
                            b58Var2.B0 = new ic0(b58Var2.O);
                        }
                        if (z) {
                            if (!this.a.B0.c()) {
                                gc0 gc0Var = new gc0();
                                gc0Var.b = this.a.C0.card_title;
                                gc0Var.c = this.a.C0.button_title;
                                gc0Var.d = this.a.C0.jump_url;
                                gc0Var.a = this.a.C0.pic_url;
                                gc0Var.f = String.valueOf(this.a.W);
                                b58 b58Var3 = this.a;
                                gc0Var.e = b58Var3.V;
                                gc0Var.g = b58Var3.b0();
                                if (z2) {
                                    this.a.B0.f(gc0Var, (ViewGroup) this.a.P);
                                } else {
                                    this.a.B0.e(gc0Var, (ViewGroup) this.a.P);
                                }
                            }
                        } else if (this.a.B0.c()) {
                            this.a.B0.a();
                        }
                    }
                }
                if (this.a.E0 != null) {
                    this.a.E0.a(i, i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public e(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(b58 b58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && ki.isEquals(this.a.U, (String) customResponsedMessage.getData()) && UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                this.a.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                TbSingleton.getInstance().setVideoCurrentFrame(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public g(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.O();
                if (!this.a.S) {
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public h(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.Q.setScaleX(1.0f);
                this.a.Q.setScaleY(1.0f);
                this.a.Q.setTranslationX(0.0f);
                this.a.Q.setTranslationY(0.0f);
                this.a.H.setScaleX(1.0f);
                this.a.H.setScaleY(1.0f);
                this.a.Q.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (this.a.t0) {
                    return;
                }
                this.a.U();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public i(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                b58 b58Var = this.a;
                b58Var.o0(b58Var.f);
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e89));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || seekBar == null || seekBar.getProgress() >= seekBar.getMax()) {
                return;
            }
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e88));
            if (!this.a.t.getControl().isPlaying()) {
                this.a.t.getControl().p(this.a.L0);
            }
            this.a.S();
            if (this.a.i0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", this.a.V).param("fid", this.a.W).param("obj_type", this.a.T ? 1 : 2).param("obj_locate", this.a.Y ? 1 : 2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public j(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.u0 == i2 && this.a.v0 == i) {
                    return;
                }
                b58 b58Var = this.a;
                b58Var.t0 = b58Var.u0 - i2 > 0 || ((float) i2) < this.a.n0 / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.Q.getLayoutParams();
                if (i2 != this.a.u0) {
                    int i3 = this.a.s0 - i2;
                    int i4 = (int) (i3 * this.a.w0);
                    if (i4 < this.a.x0) {
                        i4 = this.a.x0;
                        i3 = (int) (i4 / this.a.w0);
                    }
                    if (i4 != this.a.x0) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        this.a.Q.setLayoutParams(layoutParams);
                    }
                    this.a.u0 = i2;
                    b58 b58Var2 = this.a;
                    b58Var2.Q.setTranslationY(b58Var2.u0);
                }
                if (i != this.a.u0) {
                    this.a.v0 = i;
                    b58 b58Var3 = this.a;
                    b58Var3.Q.setTranslationX(b58Var3.v0 + ((this.a.o0 - layoutParams.width) / 2.0f));
                }
                this.a.L.setAlpha((layoutParams.width - this.a.x0) / (this.a.o0 - this.a.x0));
                if (this.a.H.getVisibility() == 0) {
                    float f = this.a.n0 / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    this.a.H.setAlpha(f2);
                }
            }
        }

        public final void b(float f) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                if (f > 0.0f) {
                    b58 b58Var = this.a;
                    b58Var.q0 -= 1000;
                    z = true;
                } else {
                    this.a.q0 += 1000;
                    z = false;
                }
                int duration = this.a.t.getControl().getDuration();
                if (this.a.q0 < 0) {
                    this.a.q0 = 0;
                } else if (this.a.q0 > duration) {
                    this.a.q0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.a.q0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.a.K;
                if (videoGestureView != null) {
                    videoGestureView.b(z, str);
                }
                b58 b58Var2 = this.a;
                b58Var2.F.setCurrentDuration(b58Var2.q0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    this.a.t.getControl().pause();
                    b58 b58Var = this.a;
                    if (b58Var.p == b58Var.f) {
                        b58Var.o0(b58Var.g);
                    } else {
                        b58Var.o0(b58Var.h);
                    }
                    this.a.u0(R.id.obfuscated_res_0x7f09232a);
                    return true;
                }
                b58 b58Var2 = this.a;
                int i = b58Var2.p;
                int i2 = b58Var2.g;
                if (i != i2 && i != (i2 | 1)) {
                    int i3 = b58Var2.h;
                    if (i == i3 || i == (i3 | 1)) {
                        b58 b58Var3 = this.a;
                        b58Var3.o0(b58Var3.d);
                        this.a.t.getControl().p(this.a.L0);
                        this.a.u0(R.id.obfuscated_res_0x7f092335);
                        return true;
                    }
                    return true;
                }
                b58 b58Var4 = this.a;
                b58Var4.o0(b58Var4.f);
                this.a.S();
                this.a.t.getControl().p(this.a.L0);
                this.a.u0(R.id.obfuscated_res_0x7f092335);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                this.a.q = 0;
                b58 b58Var = this.a;
                if (b58Var.Y) {
                    b58Var.R((Activity) b58Var.O, true);
                }
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (!this.a.f0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                }
                Context context = this.a.O;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.a.O).disableSwipeJustOnce();
                } else {
                    Context context2 = this.a.O;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.a.O).disableSwipeJustOnce();
                    }
                }
                b58 b58Var = this.a;
                if (b58Var.T && b58Var.g0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i3 = this.a.q;
                    if (i3 != 0) {
                        if (i3 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.a.t.getControl().isPlaying()) {
                            this.a.t.getControl().pause();
                            b58 b58Var2 = this.a;
                            b58Var2.o0(b58Var2.l);
                        }
                        this.a.q = 4;
                        b58 b58Var3 = this.a;
                        b58Var3.r = b58Var3.p;
                        b58 b58Var4 = this.a;
                        b58Var4.p = b58Var4.k;
                        b58Var4.s0 = b58Var4.Q.getMeasuredHeight();
                        b58 b58Var5 = this.a;
                        b58Var5.w0 = b58Var5.o0 / this.a.s0;
                        b58 b58Var6 = this.a;
                        b58Var6.x0 = (int) (b58Var6.P.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    b58 b58Var7 = this.a;
                    int i4 = b58Var7.p;
                    if (i4 == b58Var7.d || i4 == b58Var7.f || i4 == (i = b58Var7.g) || i4 == (i2 = b58Var7.h) || i4 == b58Var7.k || i4 == (i | 1) || i4 == (i2 | 1)) {
                        int i5 = this.a.q;
                        if (i5 == 0) {
                            if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                                this.a.q = 3;
                                b58 b58Var8 = this.a;
                                b58Var8.q0 = b58Var8.t.getControl().getCurrentPosition();
                                b(f);
                            } else if (motionEvent.getX() < this.a.Q.getWidth() / 2) {
                                this.a.q = 2;
                                b58 b58Var9 = this.a;
                                b58Var9.K.a(b58Var9.O, f2 > 0.0f);
                            } else {
                                this.a.q = 1;
                                b58 b58Var10 = this.a;
                                b58Var10.K.c(b58Var10.O, f2 > 0.0f);
                            }
                            b58 b58Var11 = this.a;
                            int i6 = b58Var11.p;
                            int i7 = b58Var11.k;
                            if (i6 != i7) {
                                if ((i6 & 1) > 0) {
                                    b58Var11.k = i7 | 1;
                                } else {
                                    b58Var11.k = i7 & (-2);
                                }
                                b58 b58Var12 = this.a;
                                b58Var12.o0(b58Var12.k);
                            }
                        } else if (i5 == 1) {
                            b58 b58Var13 = this.a;
                            int i8 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                            b58Var13.K.c(b58Var13.O, i8 > 0);
                            if (i8 > 0) {
                                this.a.onVolumeUp();
                            }
                        } else if (i5 == 2) {
                            b58 b58Var14 = this.a;
                            b58Var14.K.a(b58Var14.O, f2 > 0.0f);
                        } else if (i5 == 3) {
                            b(f);
                        }
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    b58 b58Var = this.a;
                    int i = b58Var.p;
                    int i2 = b58Var.d;
                    if (i != i2 && i != b58Var.e && i != b58Var.n) {
                        if (i == b58Var.f) {
                            b58Var.o0(i2);
                        }
                    } else {
                        b58 b58Var2 = this.a;
                        b58Var2.o0(b58Var2.f);
                        this.a.S();
                    }
                } else {
                    b58 b58Var3 = this.a;
                    int i3 = b58Var3.p;
                    int i4 = b58Var3.g;
                    if (i3 == i4) {
                        b58Var3.o0(b58Var3.h);
                    } else if (i3 == (i4 | 1)) {
                        b58Var3.o0(b58Var3.h | 1);
                    } else {
                        int i5 = b58Var3.h;
                        if (i3 == i5) {
                            b58Var3.o0(i4);
                        } else if (i3 == (i5 | 1)) {
                            b58Var3.o0(i4 | 1);
                        } else {
                            b58Var3.o0(b58Var3.b);
                            this.a.startPlay();
                            this.a.l0();
                        }
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b58 a;

        public k(b58 b58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b58Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    b58 b58Var = this.a;
                    if (b58Var.p == b58Var.k) {
                        if (b58Var.q == 4) {
                            this.a.T();
                            this.a.u0 = 0;
                            this.a.v0 = 0;
                        } else {
                            b58 b58Var2 = this.a;
                            b58Var2.p = -1;
                            if (b58Var2.q != 3) {
                                if (this.a.r != -1) {
                                    b58 b58Var3 = this.a;
                                    b58Var3.o0(b58Var3.r);
                                    this.a.r = -1;
                                } else if (this.a.t.getControl().isPlaying()) {
                                    b58 b58Var4 = this.a;
                                    b58Var4.o0(b58Var4.d);
                                } else {
                                    b58 b58Var5 = this.a;
                                    b58Var5.o0(b58Var5.g);
                                }
                            } else {
                                b58 b58Var6 = this.a;
                                b58Var6.F.setCurrentDuration(b58Var6.q0, true);
                                if (this.a.q0 <= this.a.t.getControl().getDuration()) {
                                    if (!this.a.t.getControl().isPlaying()) {
                                        this.a.t.getControl().p(this.a.L0);
                                    }
                                    b58 b58Var7 = this.a;
                                    b58Var7.o0(b58Var7.d);
                                }
                            }
                        }
                        b58 b58Var8 = this.a;
                        if (b58Var8.i0) {
                            String str = null;
                            if (b58Var8.q == 1) {
                                str = "c13361";
                            } else if (this.a.q == 2) {
                                str = "c13346";
                            } else if (this.a.q == 3) {
                                str = "c13362";
                            }
                            if (!ki.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.a.V).param("fid", this.a.W));
                            }
                        }
                        this.a.q = 0;
                        return true;
                    }
                }
                return this.a.p0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface l {
        void a(int i, int i2);
    }

    public b58(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3000;
        this.b = 8211;
        this.c = 19;
        this.d = 0;
        this.e = 4;
        this.f = com.kuaishou.weapon.un.w0.c1;
        this.g = 8416;
        this.h = 0;
        this.i = 513;
        this.j = ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256;
        this.k = 2048;
        this.l = 0;
        this.m = 4099;
        this.n = 0;
        this.o = 1;
        this.p = 8211;
        this.q = 0;
        this.r = -1;
        this.s = new c(this);
        this.N = null;
        this.Y = false;
        this.i0 = true;
        this.j0 = false;
        this.l0 = true;
        this.m0 = false;
        this.r0 = new int[2];
        this.u0 = 0;
        this.v0 = 0;
        this.y0 = false;
        this.z0 = false;
        this.A0 = null;
        this.D0 = false;
        this.F0 = -1L;
        this.G0 = new d(this);
        this.H0 = new f(this, 2921683);
        this.I0 = new i(this);
        this.J0 = new j(this);
        this.K0 = new k(this);
        this.L0 = new a(this);
        this.M0 = new b(this, 2000994);
        if (context == null || view2 == null) {
            return;
        }
        this.O = context;
        this.X = new k48((Activity) context);
        this.P = view2;
        this.n0 = li.i(this.O);
        this.o0 = li.k(this.O);
        d0();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.p;
            if (i2 == this.e || i2 == this.n) {
                o0(this.d);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.T && !"video_tab".equals(this.h0)) {
                this.f = 104;
                this.g = 8290;
            } else {
                this.f = com.kuaishou.weapon.un.w0.c1;
                this.g = 8418;
            }
            if (this.Y) {
                this.b |= 1024;
                this.o |= 8192;
                this.d |= 1024;
                this.e |= 1024;
                this.n |= 1024;
                this.f |= 1024;
                this.g |= 1024;
                this.h |= 1024;
                this.i |= 1024;
                this.j |= 1024;
                this.p |= 1024;
                return;
            }
            this.b &= -1025;
            this.o &= -1025;
            this.d &= -1025;
            this.e &= -1025;
            this.n &= -1025;
            this.f &= -1025;
            this.g &= -1025;
            this.h &= -1025;
            this.i &= -1025;
            this.j &= -1025;
            this.p &= -1025;
        }
    }

    public void Q() {
        float dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            Context context = this.O;
            if (context == null || context.getResources() == null) {
                return;
            }
            if (this.T) {
                dimension = this.O.getResources().getDimension(R.dimen.tbds44);
            } else if (this.Y) {
                dimension = this.O.getResources().getDimension(R.dimen.tbds78);
            } else {
                dimension = this.O.getResources().getDimension(R.dimen.tbds44);
            }
            int i2 = (int) dimension;
            this.A.setPadding(0, 0, "video_tab".equals(this.h0) ? 0 : i2, 0);
            SwitchImageView switchImageView = this.E;
            switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
            this.D.setPadding(i2, 0, 0, 0);
        }
    }

    public final void R(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, activity, z) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (this.T && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
            ViewGroup viewGroup = this.Q;
            if (viewGroup == null) {
                return;
            }
            if (z) {
                viewGroup.setPadding(0, li.s((Activity) this.O), 0, 0);
            } else {
                viewGroup.setPadding(0, 0, 0, 0);
            }
        } else if (z) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            p0();
        } else {
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.Q.setSystemUiVisibility(0);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mg.a().removeCallbacks(this.s);
            mg.a().postDelayed(this.s, this.a);
        }
    }

    public final void T() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!this.T) {
                U();
            } else if (this.p == this.k) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new h(this));
                if (!this.t0) {
                    float width = this.P.getWidth() / this.Q.getWidth();
                    float height = this.P.getHeight() / this.Q.getHeight();
                    this.Q.setPivotX(0.0f);
                    this.Q.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.Q, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.Q, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.Q;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.r0[0]);
                    ViewGroup viewGroup2 = this.Q;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.r0[1]);
                    View view2 = this.L;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, view2.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, AnimationProperty.OPACITY, operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.o0 / this.Q.getWidth();
                    float height2 = this.s0 / this.Q.getHeight();
                    this.Q.setPivotX(0.0f);
                    this.Q.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.Q, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.Q, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.Q;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.Q;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                    OperableVideoShareView operableVideoShareView2 = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView2, AnimationProperty.OPACITY, operableVideoShareView2.getAlpha(), 1.0f);
                    objectAnimator = ofFloat10;
                    objectAnimator2 = null;
                }
                if (objectAnimator2 != null) {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(objectAnimator2).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                } else {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                }
                animatorSet.start();
                int i2 = this.r;
                if (i2 != -1) {
                    this.p = i2;
                    this.r = -1;
                    if (i2 == this.l || i2 == this.f || i2 == this.d) {
                        this.t.getControl().p(this.L0);
                        o0(this.d);
                    }
                }
            } else {
                U();
            }
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            V(true);
        }
    }

    public void V(boolean z) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.P == null || this.Q == null || (tbVideoViewContainer = this.t) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        Context context = this.O;
        if (context != null) {
            li.x(context, this.P);
        }
        if (this.Y) {
            if (this.L.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.L.getParent()).removeView(this.L);
            }
            if ((this.Q.getParent() instanceof ViewGroup) && (this.P instanceof ViewGroup)) {
                this.Y = false;
                this.j0 = true;
                ((ViewGroup) this.Q.getParent()).removeView(this.Q);
                ((ViewGroup) this.P).addView(this.Q);
                this.j0 = false;
                R((Activity) this.O, this.Y);
            }
            if (!this.T && z) {
                this.X.l();
            }
        } else {
            if (this.O != null) {
                if (!this.T && z) {
                    this.X.l();
                }
                if (this.O instanceof Activity) {
                    this.Q.getLocationOnScreen(this.r0);
                    View findViewById = ((Activity) this.O).findViewById(16908290);
                    if (findViewById instanceof ViewGroup) {
                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt instanceof ViewGroup) {
                            this.j0 = true;
                            ((ViewGroup) this.P).removeAllViews();
                            if (this.L == null) {
                                View view2 = new View(this.O);
                                this.L = view2;
                                view2.setClickable(true);
                                this.L.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                this.L.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            }
                            if (this.L.getParent() instanceof ViewGroup) {
                                ((ViewGroup) this.L.getParent()).removeView(this.L);
                            }
                            this.L.setAlpha(1.0f);
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            viewGroup.addView(this.L);
                            viewGroup.addView(this.Q);
                            this.j0 = false;
                            this.Y = true;
                            R((Activity) this.O, true);
                            ic0 ic0Var = this.B0;
                            if (ic0Var != null && ic0Var.c()) {
                                this.B0.a();
                            }
                        }
                    }
                }
            }
            if (this.i0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2));
            }
        }
        P();
        Q();
        if (this.t.getControl().isPlaying()) {
            o0(this.d);
        } else {
            o0(this.p);
        }
        this.E.m();
        j0(this.Y);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                xc5.f(this.N, true);
                s45.b().l(true);
                this.D.setState(0);
            } else {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                xc5.f(this.N, false);
                s45.b().l(false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.X.i(true);
            } else {
                this.X.i(false);
            }
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.X.j();
            } else {
                this.X.k();
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.F.p();
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.w.animate().alpha(0.0f).setDuration(200L).setListener(new g(this)).start();
            }
        }
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.obfuscated_res_0x7f0d0631 : invokeV.intValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    @Override // com.repackage.y48
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.t.getControl().changeRenderViewMode(i2);
        }
    }

    public void d0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (context = this.O) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a0(), (ViewGroup) null);
        this.Q = viewGroup;
        View view2 = this.P;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(viewGroup);
        }
        this.N = new WeakReference<>(TbadkCoreApplication.getInst());
        this.u = (TbImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092366);
        this.v = this.Q.findViewById(R.id.obfuscated_res_0x7f09037e);
        this.w = (TBLottieAnimationView) this.Q.findViewById(R.id.obfuscated_res_0x7f09231e);
        this.x = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092335);
        this.z = (PercentSizeView) this.Q.findViewById(R.id.obfuscated_res_0x7f092323);
        this.y = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f09232a);
        this.A = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f092337);
        this.B = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f092339);
        this.C = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f0922fe);
        this.D = (SwitchImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092325);
        this.E = (SwitchImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092303);
        this.F = (OperableVideoMediaControllerView) this.Q.findViewById(R.id.obfuscated_res_0x7f092322);
        this.G = (OperableVideoNetworkStateTipView) this.Q.findViewById(R.id.obfuscated_res_0x7f092327);
        this.H = (OperableVideoShareView) this.Q.findViewById(R.id.obfuscated_res_0x7f09234a);
        this.J = this.Q.findViewById(R.id.obfuscated_res_0x7f0922ee);
        this.I = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092304);
        this.K = (VideoGestureView) this.Q.findViewById(R.id.obfuscated_res_0x7f092306);
        this.M = (OperableVideoErrorView) this.Q.findViewById(R.id.obfuscated_res_0x7f092300);
        this.H.setVideoContainer(this);
        this.w.addAnimatorListener(new e(this));
        this.w.setAnimation(R.raw.obfuscated_res_0x7f110019);
        this.x.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.x.setOnClickListener(this);
        this.D.setSvgStateImage(new SvgPureType(R.drawable.obfuscated_res_0x7f08061f, R.color.CAM_X0101), new SvgPureType(R.drawable.obfuscated_res_0x7f08061d, R.color.CAM_X0101));
        this.D.setState(1);
        this.D.setOnClickListener(this);
        this.u.t();
        this.u.setDrawCorner(false);
        this.u.setPlaceHolder(3);
        HomeGroupUbsUIHelper.handleImgMask(this.v, R.color.CAM_X0601);
        this.F.setOnSeekBarChangeListener(this.I0);
        this.z.setHeightPercent(0.583f);
        this.z.setBackgroundResource(R.drawable.obfuscated_res_0x7f081269);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.obfuscated_res_0x7f080616, R.color.CAM_X0101), new SvgPureType(R.drawable.obfuscated_res_0x7f08061e, R.color.CAM_X0101));
        this.E.setState(0);
        this.E.setOnClickListener(this);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a0b, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.I.setOnClickListener(this);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.O);
        this.t = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setTryUseViewInSet(true);
        q0();
        this.G.setPlayViewOnClickListener(this);
        this.Q.setOnClickListener(null);
        this.Q.setOnTouchListener(this.K0);
        this.H.setOnTouchListener(this.K0);
        this.M.setOutOnClickListener(this);
        this.p0 = new GestureDetector(this.O, this.J0);
        o0(this.b);
        wq4.d(this.v).s(R.array.Mask_X003);
        wq4.d(this.A).y(R.array.S_O_X001);
        wq4.d(this.C).y(R.array.S_O_X001);
        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
            Context context2 = this.O;
            if (context2 instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context2).registerListener(this.H0);
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                return;
            }
            this.t.getControl().setVolume(1.0f, 1.0f);
            this.D.setState(0);
            s45.b().l(true);
        }
    }

    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) ? this.Y : invokeL.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.T && this.Y : invokeV.booleanValue;
    }

    @Override // com.repackage.y48
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.t.getControl().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.y48
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.Q : (View) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.C0 != null : invokeV.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.z0) {
                return false;
            }
            if (UbsABTestHelper.isVideoTabAutoPlay() && "video_tab".equals(this.h0)) {
                return ji.x();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.G;
            return operableVideoNetworkStateTipView != null && operableVideoNetworkStateTipView.d();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.y48
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    @Override // com.repackage.y48
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.S || this.t.getControl().isPlaying() : invokeV.booleanValue;
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            mg.a().removeCallbacks(this.s);
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.U);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.R);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.D0 = z;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.z0 = z;
        }
    }

    public void o0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            k0();
            if (this.p == this.k) {
                this.r = i2;
                return;
            }
            this.p = i2;
            this.u.setVisibility((i2 & 1) > 0 ? 0 : 8);
            this.v.setVisibility((i2 & 2) > 0 ? 0 : 8);
            this.l0 = (i2 & 4) > 0;
            this.w.clearAnimation();
            this.w.setVisibility(this.l0 ? 0 : 8);
            if (!this.l0) {
                this.w.cancelAnimation();
            } else {
                this.w.setAlpha(1.0f);
            }
            this.x.setVisibility((i2 & 8192) > 0 ? 0 : 8);
            this.y.setVisibility((i2 & 8) > 0 ? 0 : 8);
            int i3 = i2 & 16;
            this.A.setVisibility(i3 > 0 ? 0 : 8);
            this.C.setVisibility(i3 > 0 ? 0 : 8);
            this.D.setVisibility((i2 & 32) > 0 ? 0 : 8);
            this.E.setVisibility((i2 & 64) > 0 ? 0 : 8);
            int i4 = i2 & 128;
            this.F.setVisibility(i4 > 0 ? 0 : 8);
            this.z.setVisibility(i4 > 0 ? 0 : 8);
            if (this.F.getVisibility() == 0) {
                this.F.p();
            }
            this.G.setVisibility((i2 & 256) > 0 ? 0 : 8);
            this.H.setVisibility((i2 & 512) > 0 ? 0 : 8);
            if (this.H.getVisibility() == 0) {
                this.H.setAlpha(1.0f);
            }
            int i5 = i2 & 1024;
            this.I.setVisibility(i5 > 0 ? 0 : 8);
            this.J.setVisibility(i5 > 0 ? 0 : 8);
            this.K.setVisibility((i2 & 2048) > 0 ? 0 : 8);
            this.M.setVisibility((i2 & 4096) <= 0 ? 8 : 0);
        }
    }

    @Override // com.repackage.y48
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.Y) {
                T();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.y48
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            if (z) {
                this.y0 = isPlaying();
                this.w.cancelAnimation();
                int i2 = this.p;
                if (i2 == this.d || i2 == this.e || i2 == this.f || i2 == this.b || i2 == this.n || i2 == this.o || i2 == this.c) {
                    stopPlay();
                }
                int i3 = this.p | 1;
                this.p = i3;
                int i4 = i3 & (-8193);
                this.p = i4;
                o0(i4);
            } else {
                int i5 = this.p;
                if (i5 == this.b || i5 == this.c || i5 == this.o) {
                    if (this.y0) {
                        startPlay();
                        l0();
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, view2) == null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        u0(id);
        if (id == R.id.obfuscated_res_0x7f092325) {
            W();
        } else if (id == R.id.obfuscated_res_0x7f092303 || id == R.id.obfuscated_res_0x7f092304) {
            T();
        } else {
            if (id == R.id.obfuscated_res_0x7f092344) {
                o0(this.b);
                startPlay();
                if (this.i0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2).param("obj_locate", this.Y ? 1 : 2));
                }
                l0();
            } else if (id == R.id.obfuscated_res_0x7f092335) {
                int i2 = this.p;
                if (i2 != this.b && i2 != this.c && i2 != this.o) {
                    o0(this.f);
                    S();
                    this.t.getControl().p(this.L0);
                } else {
                    startPlay();
                }
                if (this.i0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2).param("obj_source", this.Y ? 1 : 2).param("obj_locate", 1));
                }
                l0();
            } else if (id == R.id.obfuscated_res_0x7f09232a) {
                o0(this.g);
                k0();
                this.t.getControl().pause();
                if (this.i0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2).param("obj_source", this.Y ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.obfuscated_res_0x7f09185c) {
                o0(this.b);
                startPlay();
            } else if (id == R.id.obfuscated_res_0x7f091a66) {
                o0(this.b);
                startPlay();
            }
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            o0(this.i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048612, this, i2, i3, obj)) == null) {
            o0(this.m);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i2, i3, obj)) == null) {
            if (i2 == 3 || i2 == 904) {
                if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    t0();
                } else {
                    r0();
                }
            }
            if (i2 == 701) {
                this.l0 = true;
                s0();
                return false;
            } else if (i2 == 702) {
                t0();
                return false;
            } else {
                return false;
            }
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            e0();
            if (this.S) {
                if (this.Y) {
                    Context context = this.O;
                    if (context instanceof Activity) {
                        R((Activity) context, true);
                    }
                }
                this.t.getControl().p(this.L0);
            }
        }
    }

    @Override // com.repackage.y48
    public void onScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.j0) {
            return;
        }
        int i2 = this.p;
        if (i2 != this.g && (i2 != this.h || this.t.getControl().isPlaying())) {
            if (this.p == this.i) {
                w0();
                o0(this.i);
                return;
            }
            w0();
            return;
        }
        w0();
        o0(this.g);
    }

    @Override // com.repackage.y48
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.t.getControl().isPlaying() && !xc5.c() && !s45.b().j()) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                this.D.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.Q.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.Q.setSystemUiVisibility(4);
            } else {
                this.Q.setSystemUiVisibility(5894);
            }
        }
    }

    public void q0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.Q.addView(this.t, 0);
            this.t.setLayoutParams(layoutParams);
            this.F.setPlayer(this.t.getControl());
            this.t.getControl().setContinuePlayEnable(true);
            this.t.getControl().setOperableVideoContainer(this);
            this.t.getControl().setOnSurfaceDestroyedListener(this);
            this.t.getControl().setVideoStatData(this.Z);
            this.t.getControl().setThreadDataForStatistic(this.g0);
            this.t.getControl().getMediaProgressObserver().j(this.G0);
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            o0(this.e);
            this.l0 = true;
            this.F.p();
            Z();
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.l0) {
                this.w.setAlpha(1.0f);
                this.w.setVisibility(0);
                this.x.setVisibility(8);
            } else {
                this.w.setVisibility(8);
                this.x.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView == null || !this.l0) {
                return;
            }
            tBLottieAnimationView.loop(true);
            this.w.setMinAndMaxFrame(14, 80);
            this.w.playAnimation();
        }
    }

    @Override // com.repackage.y48
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            this.A0 = onClickListener;
        }
    }

    @Override // com.repackage.y48
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null) {
            return;
        }
        this.F0 = -1L;
        ic0 ic0Var = this.B0;
        if (ic0Var != null) {
            ic0Var.d();
        }
        if (StringHelper.equals(this.U, threadData.getThreadVideoInfo().video_url)) {
            return;
        }
        stopPlay();
        this.T = threadData.getThreadVideoInfo().is_vertical.intValue() == 1;
        this.U = threadData.getThreadVideoInfo().video_url;
        this.V = threadData.getTid();
        threadData.getThreadVideoInfo().video_length.intValue();
        threadData.getThreadVideoInfo().video_duration.intValue();
        this.W = threadData.getFid();
        this.C0 = threadData.getThreadVideoInfo().mcn_ad_card;
        P();
        Q();
        o0(this.b);
        int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
        this.F.j(intValue);
        this.F.setPlayer(this.t.getControl());
        this.C.setText(StringHelper.stringForVideoTime(intValue));
        this.A.setText(String.format(this.O.getResources().getString(R.string.obfuscated_res_0x7f0f0e70), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
        this.G.setVideoLength(threadData.getThreadVideoInfo().video_length.intValue());
        this.G.setVideoDuration(threadData.getThreadVideoInfo().video_duration.intValue());
        this.G.setTid(this.V);
        this.g0 = threadData;
        this.t.getControl().setThreadDataForStatistic(threadData);
        this.B.setVisibility(8);
        this.u.setPlaceHolder(3);
        if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 2 && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 1) {
            this.u.K(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
        } else {
            this.u.setImageBitmap(null);
            if (!ki.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                this.u.K(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
            } else {
                this.u.K(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            }
        }
        this.H.setShareData(threadData);
    }

    @Override // com.repackage.y48
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.h0 = str;
        }
    }

    @Override // com.repackage.y48
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onClickListener) == null) {
        }
    }

    @Override // com.repackage.y48
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.k0 = str;
        }
    }

    @Override // com.repackage.y48
    public void setStatistic(t48 t48Var) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, t48Var) == null) || (tbVideoViewContainer = this.t) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.Z = t48Var;
        this.t.getControl().setVideoStatData(t48Var);
    }

    @Override // com.repackage.y48
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bdUniqueId) == null) {
            this.R = bdUniqueId;
        }
    }

    @Override // com.repackage.y48
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || StringUtils.isNull(this.U)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.M0);
        if (i0()) {
            o0(this.j);
            return;
        }
        this.S = true;
        if (this.t.getControl().isPlaying()) {
            return;
        }
        TbVideoViewContainer c2 = TbVideoViewSet.b().c(this.U);
        if (c2 == null) {
            this.t.a();
            if (!StringUtils.isNull(this.t.getControl().getOriginUrl()) || UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.O);
                this.t = tbVideoViewContainer;
                tbVideoViewContainer.getControl().setTryUseViewInSet(true);
            }
            q0();
            if (ji.z()) {
                this.t.getControl().setVideoPath(this.U, this.V);
                this.t.getControl().setStageType(this.k0);
                if (!UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                    this.l0 = true;
                }
                s0();
                if (this.i0) {
                    v0();
                }
            }
        } else {
            TbVideoViewContainer tbVideoViewContainer2 = this.t;
            if (tbVideoViewContainer2 == c2) {
                tbVideoViewContainer2.a();
                q0();
            } else {
                if (UbsABTestHelper.isFeedVideoImmersionTransition() && (TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() || TbSingleton.getInstance().getIsJumpFromVideoMiddleView().booleanValue())) {
                    this.t = new TbVideoViewContainer(this.O);
                    TbVideoViewSet.b().e(this.t, this.U);
                    this.m0 = true;
                    TbSingleton.getInstance().setIsJumpFromVideoMiddleView(false);
                } else {
                    this.t.a();
                    c2.a();
                    this.t = c2;
                }
                this.t.getControl().setTryUseViewInSet(true);
                q0();
                if (TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                    this.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                    TbSingleton.getInstance().setVideoCurrentFrame(null);
                }
            }
            this.t.getControl().o();
            onPrepared();
            if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                t0();
            } else {
                r0();
            }
            if (this.i0) {
                v0();
            }
        }
        if (this.i0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.V).param("fid", this.W).param("obj_type", this.T ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // com.repackage.y48
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.S = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            if ((this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof n48)) {
                if (((TbVideoView) this.t.getControl()).isPlaying()) {
                    this.t.getControl().stop();
                } else {
                    this.t.getControl().stopPlayback();
                }
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsNeedReuseVideoPlayer() && !TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && this.U != null && (this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof n48)) {
                ((TbVideoView) this.t.getControl()).N();
                if (this.u != null && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                    this.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                    TbSingleton.getInstance().setVideoCurrentFrame(null);
                }
                ((n48) this.t.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
                TbVideoViewSet.b().d(this.U);
                this.m0 = true;
            }
            this.t.a();
            this.F.n();
            if (this.m0) {
                o0(this.o);
                this.m0 = false;
            } else {
                o0(this.b);
            }
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            o0(this.n);
            this.F.p();
            Z();
        }
    }

    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
        }
    }

    public void v0() {
        t48 t48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (t48Var = this.Z) == null) {
            return;
        }
        t48 b2 = t48Var.b();
        b2.a = this.h0;
        i48.e(b2.m, "", "1", b2, this.t.getControl().getPcdnState());
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.S = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.t.getControl().stop();
            this.F.n();
            o0(this.b);
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }
}
