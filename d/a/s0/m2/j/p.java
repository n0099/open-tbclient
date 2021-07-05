package d.a.s0.m2.j;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import d.a.s0.x2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class p {
    public static /* synthetic */ Interceptable $ic = null;
    public static int T = 5000;
    public static final float U;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public RelativeLayout B;
    public int C;
    public int D;
    public GradientDrawable E;
    public FrameLayout F;
    public FrameLayout.LayoutParams G;
    public AlphaAnimation H;
    public AlphaAnimation I;
    public d.a.s0.m2.g.b J;
    public d.a.s0.m2.j.k K;
    public ValueAnimator L;
    public long M;
    public boolean N;
    public int O;
    public int P;
    public boolean Q;
    public Runnable R;
    public d.a.s0.m2.d.a S;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63620a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f63621b;

    /* renamed from: c  reason: collision with root package name */
    public PluginErrorTipView f63622c;

    /* renamed from: d  reason: collision with root package name */
    public View f63623d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.w1.a f63624e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f63625f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f63626g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f63627h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f63628i;
    public d.a.s0.m2.e.a j;
    public boolean k;
    public BdUniqueId l;
    public d.a.s0.m2.d.f m;
    public BaseFragment n;
    public float[] o;
    public float p;
    public int q;
    public LottieSlideLoadingLayout r;
    public PersonHeaderBackgroundController s;
    public AppBarLayout t;
    public FrameLayout u;
    public NewPagerSlidingTabBaseStrip v;
    public View w;
    public CustomViewPager x;
    public m y;
    public LinearLayout z;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63629a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p pVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Integer.valueOf(i2)};
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
            this.f63629a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.f63629a.O == ((Integer) customResponsedMessage.getData()).intValue() && this.f63629a.N) {
                d.a.c.e.m.e.a().removeCallbacks(this.f63629a.R);
                this.f63629a.V();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f63630e;

        public b(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63630e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63630e.N) {
                this.f63630e.V();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.s0.m2.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63631a;

        public c(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63631a = pVar;
        }

        @Override // d.a.s0.m2.d.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f63631a.Q = z;
                if (this.f63631a.J == null || this.f63631a.J.B() == null) {
                    return;
                }
                this.f63631a.J.B().setOpen(z);
            }
        }

        @Override // d.a.s0.m2.d.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f63631a.G.height = -2;
                this.f63631a.F.setLayoutParams(this.f63631a.G);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements d.a.r0.r.f0.p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63632a;

        public d(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63632a = pVar;
        }

        @Override // d.a.r0.r.f0.p.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.r0.r.f0.p.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.c.e.m.e.a().postDelayed(this.f63632a.R, p.T);
                this.f63632a.N = true;
                p pVar = this.f63632a;
                pVar.O = pVar.y.f();
                this.f63632a.M();
                this.f63632a.y.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63633a;

        public e(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63633a = pVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i2 == 0, this.f63633a.f63620a.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.f63633a.f63620a.getPageActivity());
                }
                this.f63633a.r.setEnableSlideLoading(i2 == 0);
                int abs = Math.abs(i2);
                this.f63633a.K.i(abs == 0);
                float f2 = abs;
                this.f63633a.K.m(f2 > this.f63633a.p / 2.0f);
                float abs2 = ((double) this.f63633a.p) == 0.0d ? 0.0f : Math.abs(f2 / this.f63633a.p);
                this.f63633a.K.h(abs2);
                if (abs2 >= 1.0f) {
                    this.f63633a.o = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.f63633a.E.setCornerRadii(this.f63633a.o);
                    this.f63633a.u.setBackgroundDrawable(this.f63633a.E);
                    this.f63633a.Y();
                } else {
                    this.f63633a.o = new float[]{p.U, p.U, p.U, p.U, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.f63633a.E.setCornerRadii(this.f63633a.o);
                    this.f63633a.u.setBackgroundDrawable(this.f63633a.E);
                    this.f63633a.O();
                }
                int i3 = this.f63633a.D - this.f63633a.C;
                if (this.f63633a.D <= 0 || Math.abs(i2) < i3) {
                    return;
                }
                this.f63633a.r.o();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f63634e;

        public f(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63634e = pVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f63634e.y.l(i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63635a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(p pVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Integer.valueOf(i2)};
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
            this.f63635a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f63635a.K == null) {
                return;
            }
            this.f63635a.K.n();
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63636a;

        public h(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63636a = pVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f63636a.H.reset();
                this.f63636a.H = null;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63637a;

        public i(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63637a = pVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f63637a.w.setVisibility(8);
                this.f63637a.I.reset();
                this.f63637a.I = null;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f63638e;

        public j(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63638e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63638e.C == 0) {
                p pVar2 = this.f63638e;
                pVar2.C = pVar2.F.getMeasuredHeight();
                this.f63638e.p = pVar.F.getMeasuredHeight() - this.f63638e.K.e().getMeasuredHeight();
                if (this.f63638e.s != null) {
                    p pVar3 = this.f63638e;
                    pVar3.P = pVar3.q + this.f63638e.K.e().getMeasuredHeight() + this.f63638e.F.getMeasuredHeight() + this.f63638e.v.getMeasuredHeight();
                    boolean z = (this.f63638e.k || this.f63638e.j.j() == null || this.f63638e.j.j().getNewGodData() == null || !this.f63638e.j.j().getNewGodData().isNewGod()) ? false : true;
                    this.f63638e.G.height = this.f63638e.P;
                    this.f63638e.F.setLayoutParams(this.f63638e.G);
                    this.f63638e.P += z ? d.a.s0.m2.g.a.b0 : 0;
                    this.f63638e.G.height = -2;
                    this.f63638e.F.setLayoutParams(this.f63638e.G);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63639a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(p pVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Integer.valueOf(i2)};
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
            this.f63639a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d.a.s0.x2.b)) {
                SparseArray<b.a> sparseArray = ((d.a.s0.x2.b) customResponsedMessage.getData()).f69449a;
                if (sparseArray.size() <= 0) {
                    return;
                }
                b.a aVar = sparseArray.get(2);
                if (this.f63639a.J != null && aVar != null) {
                    this.f63639a.J.I(aVar.f69450a);
                }
                b.a aVar2 = sparseArray.get(4);
                b.a aVar3 = sparseArray.get(3);
                b.a aVar4 = sparseArray.get(1);
                b.a aVar5 = sparseArray.get(7);
                b.a aVar6 = sparseArray.get(8);
                if (this.f63639a.j != null) {
                    if (this.f63639a.j.w != null && this.f63639a.j.w.f63517b != null && aVar2 != null) {
                        this.f63639a.j.w.f63517b.putBoolean("person_center_item_red_tip_show", aVar2.f69450a);
                    }
                    if (aVar3 != null && this.f63639a.j.v != null && this.f63639a.j.v.f63517b != null) {
                        this.f63639a.j.v.f63517b.putBoolean("person_center_item_red_tip_show", aVar3.f69450a);
                    }
                    if (aVar4 != null && this.f63639a.j.u != null && this.f63639a.j.u.f63517b != null) {
                        this.f63639a.j.u.f63517b.putBoolean("person_center_item_red_tip_show", aVar4.f69450a);
                    }
                    if (aVar5 != null && this.f63639a.j.x != null && this.f63639a.j.x.f63517b != null) {
                        this.f63639a.j.x.f63517b.putBoolean("person_center_item_red_tip_show", aVar5.f69450a);
                    }
                    if (aVar6 == null || this.f63639a.j.y == null || this.f63639a.j.y.f63517b == null) {
                        return;
                    }
                    this.f63639a.j.y.f63517b.putBoolean("person_center_item_red_tip_show", aVar6.f69450a);
                    this.f63639a.j.y.f63517b.putString("person_center_item_txt", String.valueOf(aVar6.f69451b));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f63640a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(p pVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Integer.valueOf(i2)};
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
            this.f63640a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.r0.t.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.r0.t.n) || (nVar = (d.a.r0.t.n) customResponsedMessage.getData()) == null) {
                return;
            }
            this.f63640a.J.K(nVar.a());
        }
    }

    /* loaded from: classes9.dex */
    public class m extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<String> f63641a;

        /* renamed from: b  reason: collision with root package name */
        public List<PersonCenterTabBaseFragment> f63642b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(p pVar, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.f63641a = arrayList;
            arrayList.add(pVar.f63620a.getResources().getString(R.string.person_center_tab_main));
            this.f63641a.add(pVar.f63620a.getResources().getString(R.string.person_center_tab_thread));
            this.f63641a.add(pVar.f63620a.getResources().getString(R.string.person_center_tab_dynamic));
            ArrayList arrayList2 = new ArrayList();
            this.f63642b = arrayList2;
            arrayList2.add(PersonCenterMainTabFragment.M0(pVar.M, pVar.k));
            this.f63642b.add(PersonCenterThreadTabFragment.S0(pVar.M, pVar.k));
            this.f63642b.add(PersonCenterDynamicTabFragment.P0(pVar.M, pVar.k));
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f63642b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f63642b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f63642b.get(i2);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.G0(false);
                }
            }
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (ListUtils.isEmpty(this.f63642b)) {
                    return -1;
                }
                for (int i2 = 0; i2 < this.f63642b.size(); i2++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f63642b.get(i2);
                    if (personCenterTabBaseFragment != null && personCenterTabBaseFragment.isPrimary()) {
                        return personCenterTabBaseFragment.H0();
                    }
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<PersonCenterTabBaseFragment> list = this.f63642b;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i(i2) : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? j(i2) : (CharSequence) invokeI.objValue;
        }

        public PersonCenterTabBaseFragment i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                if (i2 < this.f63642b.size()) {
                    return this.f63642b.get(i2);
                }
                return null;
            }
            return (PersonCenterTabBaseFragment) invokeI.objValue;
        }

        public final String j(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.f63641a.get(i2) : (String) invokeI.objValue;
        }

        public void k(int i2) {
            List<PersonCenterTabBaseFragment> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (list = this.f63642b) == null || list.size() <= 0) {
                return;
            }
            int size = this.f63642b.size();
            for (int i3 = 0; i3 < size; i3++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f63642b.get(i3);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.onChangeSkinType(i2);
                }
            }
        }

        public void l(int i2) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                for (int i3 = 0; i3 < this.f63641a.size() && (personCenterTabBaseFragment = this.f63642b.get(i3)) != null; i3++) {
                    if (i3 == i2) {
                        personCenterTabBaseFragment.setPrimary(true);
                    } else {
                        personCenterTabBaseFragment.setPrimary(false);
                    }
                }
            }
        }

        public void m(d.a.s0.m2.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || aVar == null || ListUtils.isEmpty(this.f63642b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f63642b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f63642b.get(i2);
                if (personCenterTabBaseFragment instanceof PersonCenterMainTabFragment) {
                    ((PersonCenterMainTabFragment) personCenterTabBaseFragment).O0(aVar);
                }
            }
        }

        public void n(d.a.s0.m2.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null || aVar.i() == null || ListUtils.isEmpty(this.f63642b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f63642b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f63642b.get(i2);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.J0(aVar.C);
                    personCenterTabBaseFragment.K0(aVar.i());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1818992525, "Ld/a/s0/m2/j/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1818992525, "Ld/a/s0/m2/j/p;");
                return;
            }
        }
        U = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    }

    public p(BaseFragment baseFragment, d.a.s0.m2.d.g gVar, BdUniqueId bdUniqueId, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, gVar, bdUniqueId, Boolean.valueOf(z), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        float f2 = U;
        this.o = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
        this.p = 674.0f;
        this.N = false;
        this.O = -1;
        this.R = new b(this);
        this.S = new c(this);
        this.n = baseFragment;
        this.f63620a = baseFragment.getPageContext();
        this.l = bdUniqueId;
        this.k = z;
        this.M = j2;
        this.m = gVar.l();
        R(gVar.f63420i);
    }

    public d.a.s0.m2.g.b L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (d.a.s0.m2.g.b) invokeV.objValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (d.a.c.e.p.j.z()) {
                this.f63624e.f();
                this.f63624e.h();
                this.m.l();
                return;
            }
            this.m.p();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m.p();
        }
    }

    public void O() {
        AlphaAnimation alphaAnimation;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && S() && (alphaAnimation = this.I) == null && alphaAnimation == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.I = alphaAnimation2;
            alphaAnimation2.setFillAfter(true);
            this.I.setDuration(300L);
            this.I.setAnimationListener(new i(this));
            this.w.startAnimation(this.I);
        }
    }

    public final void P(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            g gVar = new g(this, 2005016);
            this.f63628i = gVar;
            gVar.setTag(this.l);
            tbPageContext.registerListener(this.f63628i);
        }
    }

    public final void Q(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            k kVar = new k(this, 2001435);
            this.f63625f = kVar;
            kVar.setTag(this.l);
            tbPageContext.registerListener(this.f63625f);
            l lVar = new l(this, 2016485);
            this.f63626g = lVar;
            lVar.setTag(this.l);
            tbPageContext.registerListener(this.f63626g);
            a aVar = new a(this, 2921435);
            this.f63627h = aVar;
            aVar.setTag(this.l);
            tbPageContext.registerListener(this.f63627h);
        }
    }

    public final void R(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.f63623d = view;
            this.q = UtilHelper.getStatusBarHeight();
            this.r = (LottieSlideLoadingLayout) this.f63623d.findViewById(R.id.person_center_content_view);
            TbImageView tbImageView = (TbImageView) this.f63623d.findViewById(R.id.person_center_header_bg);
            this.s = new PersonHeaderBackgroundController(this.f63620a, tbImageView, this.f63623d.findViewById(R.id.person_center_background_cover), this.k);
            this.r.l(tbImageView);
            TbPageContext tbPageContext = this.f63620a;
            View view2 = this.f63623d;
            this.K = new d.a.s0.m2.j.k(tbPageContext, view2, view2.findViewById(R.id.person_center_status_bar_space), this.k);
            FrameLayout frameLayout = (FrameLayout) this.f63623d.findViewById(R.id.person_center_header_container);
            this.F = frameLayout;
            this.G = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            this.r.l(this.F);
            this.r.j(new d(this));
            AppBarLayout appBarLayout = (AppBarLayout) this.f63623d.findViewById(R.id.person_center_app_bar_layout);
            this.t = appBarLayout;
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e(this));
            this.u = (FrameLayout) this.f63623d.findViewById(R.id.person_center_tab_layout_container);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f63623d.findViewById(R.id.person_center_tab_layout);
            this.v = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.v.setRectPaintColor(R.color.CAM_X0302);
            this.v.B(d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds46), d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds46), d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds10), d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds46), true);
            this.v.setIndicatorOffset(d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds64));
            this.v.setIndicatorOvershot(d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds8));
            this.v.setIndicatorRadius(d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds8));
            this.v.setIndicatorMarginBottom(d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds0));
            this.v.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(d.a.c.e.p.l.g(this.f63620a.getPageActivity(), R.dimen.tbds166), -1));
            this.v.setOnPageChangeListener(new f(this));
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.E = gradientDrawable;
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            this.E.setCornerRadii(this.o);
            this.u.setBackgroundDrawable(this.E);
            View findViewById = this.f63623d.findViewById(R.id.person_center_pager_shadow);
            this.w = findViewById;
            SkinManager.setBackgroundResource(findViewById, R.drawable.personalize_tab_shadow);
            this.x = (CustomViewPager) this.f63623d.findViewById(R.id.person_center_view_pager);
            m mVar = new m(this, this.n.getActivity().getSupportFragmentManager());
            this.y = mVar;
            this.x.setAdapter(mVar);
            this.x.setOffscreenPageLimit(this.y.f63642b.size());
            this.y.notifyDataSetChanged();
            this.v.setViewPager(this.x);
            this.x.setCurrentItem(1);
            d.a.s0.m2.g.b bVar = new d.a.s0.m2.g.b(this.f63620a, this.k);
            this.J = bVar;
            bVar.H(this.S);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            this.F.addView(this.J.C(), layoutParams);
            if (this.K.f()) {
                Q(this.f63620a);
            }
            P(this.f63620a);
            this.f63621b = (NoNetworkView) this.f63623d.findViewById(R.id.person_center_no_network_view);
            this.f63622c = (PluginErrorTipView) this.f63623d.findViewById(R.id.person_center_plugin_error_tip_view);
            this.z = (LinearLayout) this.f63623d.findViewById(R.id.person_center_anti_container);
            this.A = (FrameLayout) this.f63623d.findViewById(R.id.person_center_anti_content);
            this.B = (RelativeLayout) this.f63623d.findViewById(R.id.person_center_noanti_rootview);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.w.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            d.a.s0.m2.j.k kVar = this.K;
            if (kVar != null) {
                kVar.g(i2);
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.v;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
                this.v.setRectPaintColor(R.color.CAM_X0302);
                this.v.G();
            }
            GradientDrawable gradientDrawable = this.E;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            }
            d.a.s0.m2.g.b bVar = this.J;
            if (bVar != null) {
                bVar.F(i2);
            }
            m mVar = this.y;
            if (mVar != null) {
                mVar.k(i2);
            }
            NoNetworkView noNetworkView = this.f63621b;
            if (noNetworkView != null) {
                noNetworkView.c(this.f63620a, i2);
            }
            PluginErrorTipView pluginErrorTipView = this.f63622c;
            if (pluginErrorTipView != null) {
                pluginErrorTipView.e(this.f63620a, i2);
            }
            SkinManager.setBackgroundResource(this.z, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f63623d, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.w, R.drawable.personalize_tab_shadow);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.s0.m2.g.b bVar = this.J;
            if (bVar != null) {
                bVar.G();
            }
            ValueAnimator valueAnimator = this.L;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.L.removeAllListeners();
                this.L.removeAllUpdateListeners();
                this.L = null;
            }
            d.a.c.e.m.e.a().removeCallbacks(this.R);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.O = -1;
            this.N = false;
            LottieSlideLoadingLayout lottieSlideLoadingLayout = this.r;
            if (lottieSlideLoadingLayout != null) {
                lottieSlideLoadingLayout.o();
            }
        }
    }

    public void W(d.a.s0.w1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f63624e = aVar;
        }
    }

    public void X(d.a.s0.z3.f fVar) {
        d.a.s0.m2.j.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) || (kVar = this.K) == null) {
            return;
        }
        kVar.j(fVar);
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !S() && this.H == null) {
            this.w.setVisibility(0);
            if (this.H == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.H = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.H.setDuration(300L);
                this.H.setAnimationListener(new h(this));
                this.w.startAnimation(this.H);
            }
        }
    }

    public void Z(d.a.s0.m2.e.a aVar, boolean z, PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{aVar, Boolean.valueOf(z), personStatus}) == null) || aVar == null) {
            return;
        }
        this.j = aVar;
        this.z.setVisibility(8);
        this.B.setVisibility(0);
        d.a.s0.m2.j.k kVar = this.K;
        if (kVar != null) {
            kVar.l(aVar, personStatus);
        }
        d.a.s0.m2.g.b bVar = this.J;
        if (bVar != null) {
            bVar.p(aVar);
        }
        PersonHeaderBackgroundController personHeaderBackgroundController = this.s;
        if (personHeaderBackgroundController != null) {
            personHeaderBackgroundController.e(this.j.j());
        }
        this.F.post(new j(this));
        this.y.n(aVar);
        this.y.m(aVar);
        if (ListUtils.isEmpty(aVar.f())) {
            this.m.m();
            d.a.c.e.p.l.M(this.f63620a.getContext(), this.f63620a.getString(R.string.data_load_error));
            return;
        }
        d.a.s0.x2.a.v().K(this.k);
        int size = aVar.f().size();
        for (int i2 = 0; i2 < size; i2++) {
            d.a.c.k.e.n nVar = aVar.f().get(i2);
            if (nVar != null && (nVar instanceof d.a.s0.m2.e.i)) {
                this.m.m();
                return;
            }
        }
        if (z) {
            return;
        }
        this.m.z(true, aVar.f());
    }
}
