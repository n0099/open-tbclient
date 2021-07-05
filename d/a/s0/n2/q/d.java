package d.a.s0.n2.q;

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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
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
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.z0.o0;
import d.a.s0.n2.f;
import d.a.s0.n2.o;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes9.dex */
public class d implements d.a.s0.n2.q.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PercentSizeView A;
    public d.a.a0.c A0;
    public TextView B;
    public McnAdInfo B0;
    public TextView C;
    public boolean C0;
    public TextView D;
    public k D0;
    public SwitchImageView E;
    public long E0;
    public SwitchImageView F;
    public f.c F0;
    public OperableVideoMediaControllerView G;
    public SeekBar.OnSeekBarChangeListener G0;
    public OperableVideoNetworkStateTipView H;
    public GestureDetector.SimpleOnGestureListener H0;
    public OperableVideoShareView I;
    public View.OnTouchListener I0;
    public ImageView J;
    public TbVideoViewSet.b J0;
    public View K;
    public final CustomMessageListener K0;
    public VideoGestureView L;
    public View M;
    public OperableVideoErrorView N;
    public WeakReference<Context> O;
    public Context P;
    public View Q;
    public ViewGroup R;
    public BdUniqueId S;
    public boolean T;
    public boolean U;
    public String V;
    public String W;
    public int X;
    public long Y;
    public d.a.s0.n2.j Z;
    public boolean a0;
    public o b0;
    public b2 c0;

    /* renamed from: e  reason: collision with root package name */
    public int f64067e;

    /* renamed from: f  reason: collision with root package name */
    public int f64068f;

    /* renamed from: g  reason: collision with root package name */
    public int f64069g;

    /* renamed from: h  reason: collision with root package name */
    public int f64070h;

    /* renamed from: i  reason: collision with root package name */
    public int f64071i;
    public String i0;
    public int j;
    public boolean j0;
    public int k;
    public boolean k0;
    public int l;
    public String l0;
    public int m;
    public float m0;
    public int n;
    public float n0;
    public int o;
    public GestureDetector o0;
    public int p;
    public int p0;
    public int q;
    public int[] q0;
    public int r;
    public int r0;
    public int s;
    public boolean s0;
    public Runnable t;
    public int t0;
    public TbCyberVideoView u;
    public int u0;
    public TbImageView v;
    public float v0;
    public View w;
    public int w0;
    public TBLottieAnimationView x;
    public boolean x0;
    public ImageView y;
    public View.OnClickListener y0;
    public ImageView z;
    public View.OnClickListener z0;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64072a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64072a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.f64072a.stopPlay();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64073e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64073e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f64073e;
                dVar.s0(dVar.f64069g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64074a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64074a = dVar;
        }

        @Override // d.a.s0.n2.f.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f64074a.E0 <= 0) {
                    this.f64074a.E0 = i3;
                }
                if (this.f64074a.i0()) {
                    d dVar = this.f64074a;
                    if (!dVar.U && !dVar.a0 && dVar.C0) {
                        if (d.a.a0.b.b().a(this.f64074a.B0.jump_url)) {
                            return;
                        }
                        long j = i3;
                        boolean z = j >= this.f64074a.B0.ad_start_time.longValue() * 1000 && j < this.f64074a.B0.ad_end_time.longValue() * 1000;
                        boolean z2 = this.f64074a.E0 >= (this.f64074a.B0.ad_start_time.longValue() * 1000) + 1000;
                        if (z) {
                            if (!this.f64074a.A0.c()) {
                                d.a.a0.a aVar = new d.a.a0.a();
                                aVar.f43761b = this.f64074a.B0.card_title;
                                aVar.f43762c = this.f64074a.B0.button_title;
                                aVar.f43763d = this.f64074a.B0.jump_url;
                                aVar.f43760a = this.f64074a.B0.pic_url;
                                aVar.f43765f = String.valueOf(this.f64074a.Y);
                                d dVar2 = this.f64074a;
                                aVar.f43764e = dVar2.W;
                                aVar.f43766g = dVar2.b0();
                                if (z2) {
                                    this.f64074a.A0.f(aVar, (ViewGroup) this.f64074a.Q);
                                } else {
                                    this.f64074a.A0.e(aVar, (ViewGroup) this.f64074a.Q);
                                }
                            }
                        } else if (this.f64074a.A0.c()) {
                            this.f64074a.A0.a();
                        }
                    }
                }
                if (this.f64074a.D0 != null) {
                    this.f64074a.D0.a(i2, i3);
                }
            }
        }
    }

    /* renamed from: d.a.s0.n2.q.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1615d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64075e;

        public C1615d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64075e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f64075e.x.setVisibility(8);
                this.f64075e.y.setVisibility(0);
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

    /* loaded from: classes9.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64076e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64076e = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f64076e.x.setVisibility(8);
                this.f64076e.y.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f64076e.N();
                if (!this.f64076e.T) {
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

    /* loaded from: classes9.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64077e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64077e = dVar;
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
                this.f64077e.R.setScaleX(1.0f);
                this.f64077e.R.setScaleY(1.0f);
                this.f64077e.R.setTranslationX(0.0f);
                this.f64077e.R.setTranslationY(0.0f);
                this.f64077e.I.setScaleX(1.0f);
                this.f64077e.I.setScaleY(1.0f);
                this.f64077e.R.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (this.f64077e.s0) {
                    return;
                }
                this.f64077e.T();
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

    /* loaded from: classes9.dex */
    public class g implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64078e;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64078e = dVar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                d dVar = this.f64078e;
                dVar.s0(dVar.f64071i);
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) || seekBar == null || seekBar.getProgress() >= seekBar.getMax()) {
                return;
            }
            seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
            seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
            if (!this.f64078e.u.isPlaying()) {
                d dVar = this.f64078e;
                dVar.u.R(dVar.J0);
            }
            this.f64078e.R();
            if (this.f64078e.j0) {
                TiebaStatic.log(new StatisticItem("c13355").param("tid", this.f64078e.W).param("fid", this.f64078e.Y).param("obj_type", this.f64078e.U ? 1 : 2).param("obj_locate", this.f64078e.a0 ? 1 : 2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64079e;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64079e = dVar;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f64079e.t0 == i3 && this.f64079e.u0 == i2) {
                    return;
                }
                d dVar = this.f64079e;
                dVar.s0 = dVar.t0 - i3 > 0 || ((float) i3) < this.f64079e.m0 / 6.0f;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f64079e.R.getLayoutParams();
                if (i3 != this.f64079e.t0) {
                    int i4 = this.f64079e.r0 - i3;
                    int i5 = (int) (i4 * this.f64079e.v0);
                    if (i5 < this.f64079e.w0) {
                        i5 = this.f64079e.w0;
                        i4 = (int) (i5 / this.f64079e.v0);
                    }
                    if (i5 != this.f64079e.w0) {
                        layoutParams.height = i4;
                        layoutParams.width = i5;
                        this.f64079e.R.setLayoutParams(layoutParams);
                    }
                    this.f64079e.t0 = i3;
                    d dVar2 = this.f64079e;
                    dVar2.R.setTranslationY(dVar2.t0);
                }
                if (i2 != this.f64079e.t0) {
                    this.f64079e.u0 = i2;
                    d dVar3 = this.f64079e;
                    dVar3.R.setTranslationX(dVar3.u0 + ((this.f64079e.n0 - layoutParams.width) / 2.0f));
                }
                this.f64079e.M.setAlpha((layoutParams.width - this.f64079e.w0) / (this.f64079e.n0 - this.f64079e.w0));
                if (this.f64079e.I.getVisibility() == 0) {
                    float f2 = this.f64079e.m0 / 6.0f;
                    float f3 = (f2 - i3) / f2;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    this.f64079e.I.setAlpha(f3);
                }
            }
        }

        public final void b(float f2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                if (f2 > 0.0f) {
                    d dVar = this.f64079e;
                    dVar.p0 -= 1000;
                    z = true;
                } else {
                    this.f64079e.p0 += 1000;
                    z = false;
                }
                int duration = this.f64079e.u.getDuration();
                if (this.f64079e.p0 < 0) {
                    this.f64079e.p0 = 0;
                } else if (this.f64079e.p0 > duration) {
                    this.f64079e.p0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.f64079e.p0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.f64079e.L;
                if (videoGestureView != null) {
                    videoGestureView.b(z, str);
                }
                d dVar2 = this.f64079e;
                dVar2.G.setCurrentDuration(dVar2.p0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.f64079e.u.isPlaying()) {
                    this.f64079e.u.pause();
                    d dVar = this.f64079e;
                    if (dVar.q == dVar.f64071i) {
                        dVar.s0(dVar.j);
                    } else {
                        dVar.s0(dVar.k);
                    }
                    this.f64079e.y0(R.id.video_pause);
                    return true;
                }
                d dVar2 = this.f64079e;
                int i2 = dVar2.q;
                int i3 = dVar2.j;
                if (i2 != i3 && i2 != (i3 | 1)) {
                    int i4 = dVar2.k;
                    if (i2 == i4 || i2 == (i4 | 1)) {
                        d dVar3 = this.f64079e;
                        dVar3.s0(dVar3.f64069g);
                        d dVar4 = this.f64079e;
                        dVar4.u.R(dVar4.J0);
                        this.f64079e.y0(R.id.video_play);
                        return true;
                    }
                    return true;
                }
                d dVar5 = this.f64079e;
                dVar5.s0(dVar5.f64071i);
                this.f64079e.R();
                d dVar6 = this.f64079e;
                dVar6.u.R(dVar6.J0);
                this.f64079e.y0(R.id.video_play);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                this.f64079e.r = 0;
                d dVar = this.f64079e;
                if (dVar.a0) {
                    dVar.Q((Activity) dVar.P, true);
                }
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (!this.f64079e.g0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                Context context = this.f64079e.P;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.f64079e.P).disableSwipeJustOnce();
                } else {
                    Context context2 = this.f64079e.P;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.f64079e.P).disableSwipeJustOnce();
                    }
                }
                d dVar = this.f64079e;
                if (dVar.U && dVar.h0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i4 = this.f64079e.r;
                    if (i4 != 0) {
                        if (i4 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.f64079e.u.isPlaying()) {
                            this.f64079e.u.pause();
                            d dVar2 = this.f64079e;
                            dVar2.s0(dVar2.o);
                        }
                        this.f64079e.r = 4;
                        d dVar3 = this.f64079e;
                        dVar3.s = dVar3.q;
                        d dVar4 = this.f64079e;
                        dVar4.q = dVar4.n;
                        dVar4.r0 = dVar4.R.getMeasuredHeight();
                        d dVar5 = this.f64079e;
                        dVar5.v0 = dVar5.n0 / this.f64079e.r0;
                        d dVar6 = this.f64079e;
                        dVar6.w0 = (int) (dVar6.Q.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    d dVar7 = this.f64079e;
                    int i5 = dVar7.q;
                    if (i5 == dVar7.f64069g || i5 == dVar7.f64071i || i5 == (i2 = dVar7.j) || i5 == (i3 = dVar7.k) || i5 == dVar7.n || i5 == (i2 | 1) || i5 == (i3 | 1)) {
                        int i6 = this.f64079e.r;
                        if (i6 == 0) {
                            if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                                this.f64079e.r = 3;
                                d dVar8 = this.f64079e;
                                dVar8.p0 = dVar8.u.getCurrentPosition();
                                b(f2);
                            } else if (motionEvent.getX() < this.f64079e.R.getWidth() / 2) {
                                this.f64079e.r = 2;
                                d dVar9 = this.f64079e;
                                dVar9.L.a(dVar9.P, f3 > 0.0f);
                            } else {
                                this.f64079e.r = 1;
                                d dVar10 = this.f64079e;
                                dVar10.L.c(dVar10.P, f3 > 0.0f);
                            }
                            d dVar11 = this.f64079e;
                            int i7 = dVar11.q;
                            int i8 = dVar11.n;
                            if (i7 != i8) {
                                if ((i7 & 1) > 0) {
                                    dVar11.n = i8 | 1;
                                } else {
                                    dVar11.n = i8 & (-2);
                                }
                                d dVar12 = this.f64079e;
                                dVar12.s0(dVar12.n);
                            }
                        } else if (i6 == 1) {
                            d dVar13 = this.f64079e;
                            int i9 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                            dVar13.L.c(dVar13.P, i9 > 0);
                            if (i9 > 0) {
                                this.f64079e.e0();
                            }
                        } else if (i6 == 2) {
                            d dVar14 = this.f64079e;
                            dVar14.L.a(dVar14.P, f3 > 0.0f);
                        } else if (i6 == 3) {
                            b(f2);
                        }
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                if (this.f64079e.u.isPlaying()) {
                    d dVar = this.f64079e;
                    int i2 = dVar.q;
                    int i3 = dVar.f64069g;
                    if (i2 != i3 && i2 != dVar.f64070h) {
                        if (i2 == dVar.f64071i) {
                            dVar.s0(i3);
                        }
                    } else {
                        d dVar2 = this.f64079e;
                        dVar2.s0(dVar2.f64071i);
                        this.f64079e.R();
                    }
                } else {
                    d dVar3 = this.f64079e;
                    int i4 = dVar3.q;
                    int i5 = dVar3.j;
                    if (i4 == i5) {
                        dVar3.s0(dVar3.k);
                    } else if (i4 == (i5 | 1)) {
                        dVar3.s0(dVar3.k | 1);
                    } else {
                        int i6 = dVar3.k;
                        if (i4 == i6) {
                            dVar3.s0(i5);
                        } else if (i4 == (i6 | 1)) {
                            dVar3.s0(i5 | 1);
                        } else {
                            dVar3.s0(dVar3.f64068f);
                            this.f64079e.startPlay();
                            this.f64079e.m0();
                        }
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f64080e;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64080e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    d dVar = this.f64080e;
                    if (dVar.q == dVar.n) {
                        if (dVar.r == 4) {
                            this.f64080e.S();
                            this.f64080e.t0 = 0;
                            this.f64080e.u0 = 0;
                        } else {
                            d dVar2 = this.f64080e;
                            dVar2.q = -1;
                            if (dVar2.r != 3) {
                                if (this.f64080e.s != -1) {
                                    d dVar3 = this.f64080e;
                                    dVar3.s0(dVar3.s);
                                    this.f64080e.s = -1;
                                } else if (this.f64080e.u.isPlaying()) {
                                    d dVar4 = this.f64080e;
                                    dVar4.s0(dVar4.f64069g);
                                } else {
                                    d dVar5 = this.f64080e;
                                    dVar5.s0(dVar5.j);
                                }
                            } else {
                                d dVar6 = this.f64080e;
                                dVar6.G.setCurrentDuration(dVar6.p0, true);
                                if (this.f64080e.p0 <= this.f64080e.u.getDuration()) {
                                    if (!this.f64080e.u.isPlaying()) {
                                        d dVar7 = this.f64080e;
                                        dVar7.u.R(dVar7.J0);
                                    }
                                    d dVar8 = this.f64080e;
                                    dVar8.s0(dVar8.f64069g);
                                }
                            }
                        }
                        d dVar9 = this.f64080e;
                        if (dVar9.j0) {
                            String str = null;
                            if (dVar9.r == 1) {
                                str = "c13361";
                            } else if (this.f64080e.r == 2) {
                                str = "c13346";
                            } else if (this.f64080e.r == 3) {
                                str = "c13362";
                            }
                            if (!d.a.c.e.p.k.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.f64080e.W).param("fid", this.f64080e.Y));
                            }
                        }
                        this.f64080e.r = 0;
                        return true;
                    }
                }
                return this.f64080e.o0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class j implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64081a;

        public j(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64081a = dVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f64081a;
                dVar.s0(dVar.f64068f);
                this.f64081a.x0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f64081a.u.G();
                this.f64081a.v0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface k {
        void a(int i2, int i3);
    }

    public d(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64067e = 3000;
        this.f64068f = 8211;
        this.f64069g = 0;
        this.f64070h = 4;
        this.f64071i = 232;
        this.j = 8416;
        this.k = 0;
        this.l = 513;
        this.m = 259;
        this.n = 2048;
        this.o = 0;
        this.p = 4099;
        this.q = 8211;
        this.r = 0;
        this.s = -1;
        this.t = new b(this);
        this.O = null;
        this.a0 = false;
        this.j0 = true;
        this.k0 = false;
        this.q0 = new int[2];
        this.t0 = 0;
        this.u0 = 0;
        this.x0 = false;
        this.y0 = null;
        this.z0 = null;
        this.C0 = false;
        this.E0 = -1L;
        this.F0 = new c(this);
        this.G0 = new g(this);
        this.H0 = new h(this);
        this.I0 = new i(this);
        this.J0 = new j(this);
        this.K0 = new a(this, 2000994);
        if (context == null || view == null) {
            return;
        }
        this.P = context;
        this.Z = new d.a.s0.n2.j((Activity) context);
        this.Q = view;
        this.m0 = l.i(this.P);
        this.n0 = l.k(this.P);
        d0();
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.T = false;
            TBLottieAnimationView tBLottieAnimationView = this.x;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.u.S();
            this.G.q();
            s0(this.f64068f);
            MessageManager.getInstance().unRegisterListener(this.K0);
        }
    }

    @Override // d.a.s0.n2.q.a
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a0 : invokeV.booleanValue;
    }

    @Override // d.a.s0.n2.q.a
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a0) {
                S();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.n2.q.a
    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.R : (View) invokeV.objValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.q == this.f64070h) {
            s0(this.f64069g);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.U && !"video_tab".equals(this.i0)) {
                this.f64071i = 104;
                this.j = 8290;
            } else {
                this.f64071i = 232;
                this.j = 8418;
            }
            if (this.a0) {
                this.f64068f |= 1024;
                this.f64069g |= 1024;
                this.f64070h |= 1024;
                this.f64071i |= 1024;
                this.j |= 1024;
                this.k |= 1024;
                this.l |= 1024;
                this.m |= 1024;
                this.q |= 1024;
                return;
            }
            this.f64068f &= -1025;
            this.f64069g &= -1025;
            this.f64070h &= -1025;
            this.f64071i &= -1025;
            this.j &= -1025;
            this.k &= -1025;
            this.l &= -1025;
            this.m &= -1025;
            this.q &= -1025;
        }
    }

    public void P() {
        float dimension;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.H.a(this.U, this.a0);
            this.I.e(this.U, this.a0);
            Context context = this.P;
            if (context == null || context.getResources() == null) {
                return;
            }
            if (this.U) {
                dimension = this.P.getResources().getDimension(R.dimen.tbds44);
            } else if (this.a0) {
                dimension = this.P.getResources().getDimension(R.dimen.tbds78);
            } else {
                dimension = this.P.getResources().getDimension(R.dimen.tbds44);
            }
            int i2 = (int) dimension;
            this.B.setPadding(0, 0, "video_tab".equals(this.i0) ? 0 : i2, 0);
            SwitchImageView switchImageView = this.F;
            switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i2, 0);
            this.E.setPadding(i2, 0, 0, 0);
        }
    }

    public final void Q(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, activity, z) == null) || activity == null || activity.getWindow() == null) {
            return;
        }
        if (this.U && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
            ViewGroup viewGroup = this.R;
            if (viewGroup == null) {
                return;
            }
            if (z) {
                viewGroup.setPadding(0, l.r((Activity) this.P), 0, 0);
            } else {
                viewGroup.setPadding(0, 0, 0, 0);
            }
        } else if (z) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            t0();
        } else {
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            this.R.setSystemUiVisibility(0);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.t);
            d.a.c.e.m.e.a().postDelayed(this.t, this.f64067e);
        }
    }

    public final void S() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.U) {
                T();
            } else if (this.q == this.n) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new f(this));
                if (!this.s0) {
                    float width = this.Q.getWidth() / this.R.getWidth();
                    float height = this.Q.getHeight() / this.R.getHeight();
                    this.R.setPivotX(0.0f);
                    this.R.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.R, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.R, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.I, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.I, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.R;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.q0[0]);
                    ViewGroup viewGroup2 = this.R;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.q0[1]);
                    View view = this.M;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.I;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, "alpha", operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.n0 / this.R.getWidth();
                    float height2 = this.r0 / this.R.getHeight();
                    this.R.setPivotX(0.0f);
                    this.R.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.R, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.R, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.I, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.I, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.R;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.R;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                    OperableVideoShareView operableVideoShareView2 = this.I;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView2, "alpha", operableVideoShareView2.getAlpha(), 1.0f);
                    objectAnimator = ofFloat10;
                    objectAnimator2 = null;
                }
                if (objectAnimator2 != null) {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(objectAnimator2).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                } else {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                }
                animatorSet.start();
                int i2 = this.s;
                if (i2 != -1) {
                    this.q = i2;
                    this.s = -1;
                    if (i2 == this.o || i2 == this.f64071i || i2 == this.f64069g) {
                        this.u.R(this.J0);
                        s0(this.f64069g);
                    }
                }
            } else {
                T();
            }
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            U(true);
        }
    }

    public void U(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (view = this.Q) == null || this.R == null || this.u == null) {
            return;
        }
        Context context = this.P;
        if (context != null) {
            l.x(context, view);
        }
        if (this.a0) {
            if (this.M.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.M.getParent()).removeView(this.M);
            }
            if ((this.R.getParent() instanceof ViewGroup) && (this.Q instanceof ViewGroup)) {
                this.a0 = false;
                this.k0 = true;
                ((ViewGroup) this.R.getParent()).removeView(this.R);
                ((ViewGroup) this.Q).addView(this.R);
                this.k0 = false;
                Q((Activity) this.P, this.a0);
            }
            if (!this.U && z) {
                this.Z.l();
            }
        } else {
            if (this.P != null) {
                if (!this.U && z) {
                    this.Z.l();
                }
                if (this.P instanceof Activity) {
                    this.R.getLocationOnScreen(this.q0);
                    View findViewById = ((Activity) this.P).findViewById(16908290);
                    if (findViewById instanceof ViewGroup) {
                        View childAt = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt instanceof ViewGroup) {
                            this.k0 = true;
                            ((ViewGroup) this.Q).removeAllViews();
                            if (this.M == null) {
                                View view2 = new View(this.P);
                                this.M = view2;
                                view2.setClickable(true);
                                this.M.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                this.M.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                            }
                            if (this.M.getParent() instanceof ViewGroup) {
                                ((ViewGroup) this.M.getParent()).removeView(this.M);
                            }
                            this.M.setAlpha(1.0f);
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            viewGroup.addView(this.M);
                            viewGroup.addView(this.R);
                            this.k0 = false;
                            this.a0 = true;
                            Q((Activity) this.P, true);
                            d.a.a0.c cVar = this.A0;
                            if (cVar != null && cVar.c()) {
                                this.A0.a();
                            }
                        }
                    }
                }
            }
            if (this.j0) {
                TiebaStatic.log(new StatisticItem("c13360").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2));
            }
        }
        O();
        P();
        if (this.u.isPlaying()) {
            s0(this.f64069g);
        } else {
            s0(this.q);
        }
        this.F.b();
        k0(this.a0);
    }

    @Override // d.a.s0.n2.q.a
    public void V(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.u.getRenderView().setDisplayMode(i2);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.u.setVolume(1.0f, 1.0f);
                o0.e(this.O, true);
                this.E.setState(0);
            } else {
                this.u.setVolume(0.0f, 0.0f);
                this.E.setState(1);
                o0.e(this.O, false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                this.Z.i(true);
            } else {
                this.Z.i(false);
            }
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                this.Z.j();
            } else {
                this.Z.k();
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            s0(this.f64070h);
            this.G.s();
            TBLottieAnimationView tBLottieAnimationView = this.x;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.x.animate().alpha(0.0f).setDuration(200L).setListener(new e(this)).start();
            }
        }
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? R.layout.operable_video_container : invokeV.intValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public void d0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (context = this.P) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a0(), (ViewGroup) null);
        this.R = viewGroup;
        View view = this.Q;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(viewGroup);
        }
        this.O = new WeakReference<>(TbadkCoreApplication.getInst());
        this.v = (TbImageView) this.R.findViewById(R.id.video_thumbnail);
        this.w = this.R.findViewById(R.id.black_mask);
        this.x = (TBLottieAnimationView) this.R.findViewById(R.id.video_loading);
        this.y = (ImageView) this.R.findViewById(R.id.video_play);
        this.A = (PercentSizeView) this.R.findViewById(R.id.video_media_controller_mask);
        this.z = (ImageView) this.R.findViewById(R.id.video_pause);
        this.B = (TextView) this.R.findViewById(R.id.video_play_count);
        this.C = (TextView) this.R.findViewById(R.id.video_play_flag);
        this.D = (TextView) this.R.findViewById(R.id.video_duration);
        this.E = (SwitchImageView) this.R.findViewById(R.id.video_mute);
        this.F = (SwitchImageView) this.R.findViewById(R.id.video_full_screen);
        this.G = (OperableVideoMediaControllerView) this.R.findViewById(R.id.video_media_controller);
        this.H = (OperableVideoNetworkStateTipView) this.R.findViewById(R.id.video_network_state_tip);
        this.I = (OperableVideoShareView) this.R.findViewById(R.id.video_share_view);
        this.K = this.R.findViewById(R.id.video_back_btn_mask);
        this.J = (ImageView) this.R.findViewById(R.id.video_full_screen_back);
        this.L = (VideoGestureView) this.R.findViewById(R.id.video_gesture);
        this.N = (OperableVideoErrorView) this.R.findViewById(R.id.video_error_layout);
        this.I.setVideoContainer(this);
        this.x.addAnimatorListener(new C1615d(this));
        this.x.setAnimation(R.raw.lotti_video_loading);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.E.setState(1);
        this.E.setOnClickListener(this);
        this.v.s();
        this.v.setDrawCorner(false);
        this.v.setPlaceHolder(3);
        d.a.r0.b.g.b.f(this.w, R.color.CAM_X0601);
        this.G.setOnSeekBarChangeListener(this.G0);
        this.A.setHeightPercent(0.583f);
        this.A.setBackgroundResource(R.drawable.video_mask_bg);
        this.F.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
        this.F.setState(0);
        this.F.setOnClickListener(this);
        this.z.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.z.setOnClickListener(this);
        this.J.setOnClickListener(this);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(this.P);
        this.u = tbCyberVideoView;
        tbCyberVideoView.setTryUseViewInSet(true);
        v0();
        this.H.setPlayViewOnClickListener(this);
        this.R.setOnClickListener(null);
        this.R.setOnTouchListener(this.I0);
        this.I.setOnTouchListener(this.I0);
        this.N.setOutOnClickListener(this);
        this.o0 = new GestureDetector(this.P, this.H0);
        s0(this.f64068f);
        this.A0 = new d.a.a0.c(this.P);
        d.a.r0.r.u.c.d(this.w).r(R.array.Mask_X003);
        d.a.r0.r.u.c.d(this.B).w(R.array.S_O_X001);
        d.a.r0.r.u.c.d(this.D).w(R.array.S_O_X001);
    }

    @Override // d.a.s0.n2.q.a
    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.u.isPlaying() && !o0.c()) {
                this.u.setVolume(1.0f, 1.0f);
                this.E.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.u.setVolume(0.0f, 0.0f);
                this.E.setState(1);
                return;
            }
            this.u.setVolume(1.0f, 1.0f);
            this.E.setState(0);
        }
    }

    public boolean g0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) ? this.a0 : invokeL.booleanValue;
    }

    @Override // d.a.s0.n2.q.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.u.getCurrentPosition() : invokeV.intValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.U && this.a0 : invokeV.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.B0 != null : invokeV.booleanValue;
    }

    @Override // d.a.s0.n2.q.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.T || this.u.isPlaying() : invokeV.booleanValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (d.a.r0.b.d.R() && "video_tab".equals(this.i0)) {
                return d.a.c.e.p.j.x();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.H;
            return operableVideoNetworkStateTipView != null && operableVideoNetworkStateTipView.d();
        }
        return invokeV.booleanValue;
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.t);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.V);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.S);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // d.a.s0.n2.q.a
    public void n0(o oVar) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, oVar) == null) || (tbCyberVideoView = this.u) == null) {
            return;
        }
        this.b0 = oVar;
        tbCyberVideoView.setVideoStatData(oVar);
    }

    @Override // d.a.s0.n2.q.a
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, view) == null) || view == null) {
            return;
        }
        int id = view.getId();
        y0(id);
        if (id == R.id.video_mute) {
            W();
        } else if (id != R.id.video_full_screen && id != R.id.video_full_screen_back) {
            if (id == R.id.video_replay) {
                s0(this.f64068f);
                startPlay();
                if (this.j0) {
                    TiebaStatic.log(new StatisticItem("c13345").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_locate", this.a0 ? 1 : 2));
                }
                m0();
            } else if (id == R.id.video_play) {
                if (this.q == this.f64068f) {
                    startPlay();
                } else {
                    s0(this.f64071i);
                    R();
                    this.u.R(this.J0);
                }
                if (this.j0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 1));
                }
                m0();
            } else if (id == R.id.video_pause) {
                s0(this.j);
                l0();
                this.u.pause();
                if (this.j0) {
                    TiebaStatic.log(new StatisticItem("c13344").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", this.a0 ? 1 : 2).param("obj_locate", 2));
                }
            } else if (id == R.id.play) {
                s0(this.f64068f);
                startPlay();
            } else if (id == R.id.retry) {
                s0(this.f64068f);
                startPlay();
            }
        } else {
            S();
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            s0(this.l);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048612, this, i2, i3, obj)) == null) {
            s0(this.p);
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
                w0();
            }
            if (i2 == 701) {
                x0();
                return false;
            } else if (i2 == 702) {
                w0();
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
            f0();
            if (this.T) {
                if (this.a0) {
                    Context context = this.P;
                    if (context instanceof Activity) {
                        Q((Activity) context, true);
                    }
                }
                this.u.R(this.J0);
            }
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.k0) {
            return;
        }
        int i2 = this.q;
        if (i2 != this.j && (i2 != this.k || this.u.isPlaying())) {
            if (this.q == this.l) {
                A0();
                s0(this.l);
                return;
            } else if (this.x0) {
                return;
            } else {
                A0();
                return;
            }
        }
        A0();
        s0(this.j);
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.C0 = z;
        }
    }

    public void q0(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, kVar) == null) {
            this.D0 = kVar;
        }
    }

    @Override // d.a.s0.n2.q.a
    public boolean r0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            if (z) {
                this.x0 = isPlaying();
                this.x.cancelAnimation();
                int i2 = this.q;
                if (i2 == this.f64069g || i2 == this.f64070h || i2 == this.f64071i || i2 == this.f64068f) {
                    stopPlay();
                }
                int i3 = this.q | 1;
                this.q = i3;
                s0(i3);
            } else if (this.q == this.f64068f) {
                if (this.x0) {
                    startPlay();
                    m0();
                    return false;
                }
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            l0();
            if (this.q == this.n) {
                this.s = i2;
                return;
            }
            this.q = i2;
            this.v.setVisibility((i2 & 1) > 0 ? 0 : 8);
            this.w.setVisibility((i2 & 2) > 0 ? 0 : 8);
            boolean z = (i2 & 4) > 0;
            this.x.clearAnimation();
            this.x.setVisibility(z ? 0 : 8);
            if (!z) {
                this.x.cancelAnimation();
            } else {
                this.x.setAlpha(1.0f);
            }
            this.y.setVisibility((i2 & 8192) > 0 ? 0 : 8);
            this.z.setVisibility((i2 & 8) > 0 ? 0 : 8);
            int i3 = i2 & 16;
            this.B.setVisibility(i3 > 0 ? 0 : 8);
            this.D.setVisibility(i3 > 0 ? 0 : 8);
            this.E.setVisibility((i2 & 32) > 0 ? 0 : 8);
            this.F.setVisibility((i2 & 64) > 0 ? 0 : 8);
            int i4 = i2 & 128;
            this.G.setVisibility(i4 > 0 ? 0 : 8);
            this.A.setVisibility(i4 > 0 ? 0 : 8);
            if (this.G.getVisibility() == 0) {
                this.G.s();
            }
            this.H.setVisibility((i2 & 256) > 0 ? 0 : 8);
            this.I.setVisibility((i2 & 512) > 0 ? 0 : 8);
            if (this.I.getVisibility() == 0) {
                this.I.setAlpha(1.0f);
            }
            int i5 = i2 & 1024;
            this.J.setVisibility(i5 > 0 ? 0 : 8);
            this.K.setVisibility(i5 > 0 ? 0 : 8);
            this.L.setVisibility((i2 & 2048) > 0 ? 0 : 8);
            this.N.setVisibility((i2 & 4096) <= 0 ? 8 : 0);
        }
    }

    @Override // d.a.s0.n2.q.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.y0 = onClickListener;
        }
    }

    @Override // d.a.s0.n2.q.a
    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, b2Var) == null) || b2Var == null || b2Var.l1() == null) {
            return;
        }
        this.E0 = -1L;
        d.a.a0.c cVar = this.A0;
        if (cVar != null) {
            cVar.d();
        }
        if (StringHelper.equals(this.V, b2Var.l1().video_url)) {
            return;
        }
        stopPlay();
        this.U = b2Var.l1().is_vertical.intValue() == 1;
        this.V = b2Var.l1().video_url;
        this.W = b2Var.n1();
        b2Var.l1().video_length.intValue();
        this.X = b2Var.l1().video_duration.intValue();
        this.Y = b2Var.Q();
        this.B0 = b2Var.l1().mcn_ad_card;
        O();
        P();
        s0(this.f64068f);
        int intValue = b2Var.l1().video_duration.intValue() * 1000;
        this.G.p(intValue);
        this.G.setPlayer(this.u);
        this.D.setText(StringHelper.stringForVideoTime(intValue));
        this.B.setText(String.format(this.P.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(b2Var.l1().play_count.intValue())));
        this.H.setVideoLength(b2Var.l1().video_length.intValue());
        this.H.setVideoDuration(b2Var.l1().video_duration.intValue());
        this.H.setTid(this.W);
        this.c0 = b2Var;
        this.u.setThreadDataForStatistic(b2Var);
        this.C.setVisibility(8);
        this.v.setPlaceHolder(3);
        this.v.M(b2Var.l1().thumbnail_url, 10, false);
        this.I.setShareData(b2Var);
    }

    @Override // d.a.s0.n2.q.a
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.i0 = str;
        }
    }

    @Override // d.a.s0.n2.q.a
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.l0 = str;
        }
    }

    @Override // d.a.s0.n2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bdUniqueId) == null) {
            this.S = bdUniqueId;
        }
    }

    @Override // d.a.s0.n2.q.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || StringUtils.isNull(this.V)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.K0);
        if (j0()) {
            s0(this.m);
            return;
        }
        this.T = true;
        if (this.u.isPlaying()) {
            return;
        }
        TbCyberVideoView e2 = TbVideoViewSet.d().e(this.V);
        if (e2 == null) {
            this.u.G();
            if (!StringUtils.isNull(this.u.getOriginUrl())) {
                TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(this.P);
                this.u = tbCyberVideoView;
                tbCyberVideoView.setTryUseViewInSet(true);
            }
            v0();
            if (d.a.c.e.p.j.z()) {
                this.u.setVideoDuration(this.X);
                this.u.setVideoPath(this.V, this.W);
                this.u.setStageType(this.l0);
                x0();
                if (this.j0) {
                    z0();
                }
            }
        } else {
            TbCyberVideoView tbCyberVideoView2 = this.u;
            if (tbCyberVideoView2 == e2) {
                if (tbCyberVideoView2.getParent() == null || this.u.getParent() != e2.getParent()) {
                    this.u.G();
                    v0();
                }
            } else {
                tbCyberVideoView2.G();
                e2.G();
                this.u = e2;
                e2.setTryUseViewInSet(true);
                v0();
            }
            this.u.M();
            onPrepared();
            w0();
            if (this.j0) {
                z0();
            }
        }
        if (this.j0) {
            TiebaStatic.log(new StatisticItem("c13357").param("tid", this.W).param("fid", this.Y).param("obj_type", this.U ? 1 : 2).param("obj_source", TbSingleton.getInstance().isVideoCardMute() ? 1 : 2).param("obj_locate", 1));
        }
    }

    @Override // d.a.s0.n2.q.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.T = false;
            TBLottieAnimationView tBLottieAnimationView = this.x;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.u.S();
            this.u.G();
            this.G.q();
            s0(this.f64068f);
            MessageManager.getInstance().unRegisterListener(this.K0);
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.R.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.R.setSystemUiVisibility(4);
            } else {
                this.R.setSystemUiVisibility(5894);
            }
        }
    }

    @Override // d.a.s0.n2.q.a
    public void u0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onClickListener) == null) {
            this.z0 = onClickListener;
        }
    }

    public void v0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && (tbCyberVideoView = this.u) != null && tbCyberVideoView.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.R.addView(this.u.getView(), 0);
            this.u.getView().setLayoutParams(layoutParams);
            this.G.setPlayer(this.u);
            this.u.setContinuePlayEnable(true);
            this.u.setOnPreparedListener(this);
            this.u.setOnCompletionListener(this);
            this.u.setOnErrorListener(this);
            this.u.setOnSurfaceDestroyedListener(this);
            this.u.setOnInfoListener(this);
            this.u.setVideoStatData(this.b0);
            this.u.setThreadDataForStatistic(this.c0);
            this.u.getMediaProgressObserver().j(this.F0);
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            s0(this.f64070h);
            this.G.s();
            Z();
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.x.setAlpha(1.0f);
            this.x.setVisibility(0);
            this.y.setVisibility(8);
            TBLottieAnimationView tBLottieAnimationView = this.x;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.loop(true);
                this.x.setMinAndMaxFrame(14, 80);
                this.x.playAnimation();
            }
        }
    }

    public void y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
        }
    }

    public void z0() {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (oVar = this.b0) == null) {
            return;
        }
        o b2 = oVar.b();
        b2.f64043a = this.i0;
        d.a.s0.n2.h.e(b2.m, "", "1", b2, this.u.getPcdnState());
    }
}
