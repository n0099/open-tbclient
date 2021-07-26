package d.a.q0.u0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsMoveAreaBottomMenuView;
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d.a.d.e.g.d;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.m2;
import d.a.p0.s.s.b;
import d.a.q0.h.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes8.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar A;
    public View B;
    public View C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public CommonTipView H;
    public d.a.q0.u0.o2.d I;
    public d.a.q0.u0.m1.e.c J;
    public d.a.q0.u0.o2.m K;
    public GifView L;
    public TbImageView M;
    public HashSet<String> N;
    public d.a.q0.n2.i O;
    public int P;
    public int Q;
    public View R;
    public View S;
    public ObservedChangeLinearLayout T;
    public boolean U;
    public d.a.q0.u0.m1.e.a V;
    public boolean W;
    public d.a.q0.v3.e X;
    public AppBarLayout Y;
    public AppBarLayoutStickyBehavior Z;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f64268a;
    public FrsHeaderViewContainer a0;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f64269b;
    public CollapsingToolbarLayout b0;

    /* renamed from: c  reason: collision with root package name */
    public CoordinatorLayout f64270c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public View f64271d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public View f64272e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f64273f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f64274g;
    public d.a.q0.u0.o2.h g0;

    /* renamed from: h  reason: collision with root package name */
    public MessageRedDotView f64275h;
    public FrsMultiDelBottomMenuView h0;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.e0.d f64276i;
    public FrsMoveAreaBottomMenuView i0;
    public ImageView j;
    public NavigationBarCoverTip j0;
    public ImageView k;
    public TextView k0;
    public TextView l;
    public TextView l0;
    public ViewStub m;
    public int m0;
    public FrameLayout n;
    public int n0;
    public TbImageView o;
    public boolean o0;
    public TbImageView p;
    public d.a.d.k.e.l p0;
    public ExposeTagViewCoordinatorLayout q;
    public CustomMessageListener q0;
    public FrsTabViewPager r;
    public AppBarLayout.OnOffsetChangedListener r0;
    public PbListView s;
    public Runnable s0;
    public BdTypeRecyclerView t;
    public boolean t0;
    public d.a.q0.u0.m1.d.e0 u;
    public d.a.q0.u0.o2.k v;
    public d.a.p0.s.s.b w;
    public View.OnClickListener x;
    public NoNetworkView.b y;
    public NoNetworkView z;

    /* loaded from: classes8.dex */
    public class a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f64277a;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64277a = qVar;
        }

        @Override // d.a.p0.s.s.b.c
        public void a(d.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                if (i2 == 0) {
                    this.f64277a.f64268a.b4();
                } else if (i2 != 1 || this.f64277a.f64268a.getPageContext() == null) {
                } else {
                    SelectImageHelper.getAlbumImage(this.f64277a.f64268a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f64278e;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64278e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64278e.m == null) {
                return;
            }
            this.f64278e.n.setVisibility(0);
            this.f64278e.p.setVisibility(0);
            this.f64278e.o.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.d.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f64279a;

        public c(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64279a = qVar;
        }

        @Override // d.a.d.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                this.f64279a.f64268a.getPageContext().getLayoutMode().j(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.d.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.d.e.p.l.g(this.f64279a.f64268a.getActivity(), R.dimen.ds10) : invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? -d.a.d.e.p.l.g(this.f64279a.f64268a.getActivity(), R.dimen.ds6) : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.d.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.p0.s.d0.b.j().w("frs_video_activity_guide", 1L);
            }
        }

        @Override // d.a.d.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.d.e.g.c f64280e;

        public e(q qVar, d.a.d.e.g.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64280e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.d.e.g.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f64280e) == null) {
                return;
            }
            cVar.d();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f64281e;

        public f(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64281e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64281e.W().notifyDataSetChanged();
                if (this.f64281e.o0) {
                    return;
                }
                this.f64281e.O.n(this.f64281e.P, this.f64281e.Q, this.f64281e.G, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f64282a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(q qVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2)};
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
            this.f64282a = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f64282a.p0 == null) {
                        this.f64282a.p0 = new d.a.d.k.e.l(new d.a.d.k.e.j());
                    }
                    this.f64282a.p0.q(this.f64282a.t, 2);
                } else if (this.f64282a.p0 != null) {
                    this.f64282a.p0.w();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f64283a;

        public h(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64283a = qVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                this.f64283a.L(appBarLayout, i2);
                if (this.f64283a.v != null && this.f64283a.q.hasTargetView()) {
                    this.f64283a.v.p(i2 == 0 && !this.f64283a.q.canDrag());
                }
                if (this.f64283a.e0 != i2 && Math.abs(i2) >= 0 && this.f64283a.S() != -1) {
                    if (Math.abs(i2) >= this.f64283a.S()) {
                        if (this.f64283a.c0) {
                            this.f64283a.c0 = false;
                            q qVar = this.f64283a;
                            qVar.J0(qVar.c0);
                        }
                    } else if (!this.f64283a.c0) {
                        this.f64283a.c0 = true;
                        q qVar2 = this.f64283a;
                        qVar2.J0(qVar2.c0);
                    }
                    int Z = this.f64283a.Z() + this.f64283a.f0() + this.f64283a.h0();
                    int totalScrollRange = appBarLayout.getTotalScrollRange() - Z;
                    int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i2);
                    if (totalScrollRange <= 0) {
                        return;
                    }
                    float abs = Math.abs(i2 * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && this.f64283a.e0 - i2 < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        this.f64283a.P1(Math.abs(Z - totalScrollRange2));
                        if (this.f64283a.S != null) {
                            this.f64283a.S.setVisibility(0);
                        }
                    } else if (this.f64283a.S != null) {
                        if (this.f64283a.n0() != UtilHelper.getStatusBarHeight()) {
                            this.f64283a.P1(0);
                        }
                        this.f64283a.S.setVisibility(8);
                    }
                    if (this.f64283a.A != null) {
                        if (this.f64283a.U) {
                            this.f64283a.A.getBarBgView().setAlpha(abs);
                            this.f64283a.S1(false);
                        } else if (this.f64283a.l0 != null) {
                            this.f64283a.l0.setAlpha(abs);
                        }
                    }
                    this.f64283a.e0 = i2;
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i2));
                    CustomMessage customMessage = new CustomMessage(2921397);
                    if (this.f64283a.f64268a != null && this.f64283a.f64268a.K2() != null && this.f64283a.f64268a.K2().z() != null && (this.f64283a.f64268a.K2().z().f16138b instanceof BaseFragment)) {
                        customMessage.setTag(((BaseFragment) this.f64283a.f64268a.K2().z().f16138b).getUniqueId());
                        customResponsedMessage.setOrginalMessage(customMessage);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.f64283a.v == null || this.f64283a.v.h() <= 0 || Math.abs(i2) < this.f64283a.v.h()) {
                    return;
                }
                this.f64283a.v.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements d.a.p0.d1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f64284a;

        public i(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64284a = qVar;
        }

        @Override // d.a.p0.d1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i3 == i5 || i5 <= 0) {
                return;
            }
            this.f64284a.b0.setMinimumHeight(i3);
        }
    }

    /* loaded from: classes8.dex */
    public class j extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f64285a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f64286b;

        public j(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64286b = qVar;
            this.f64285a = 0;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                super.onRemoveFinished(viewHolder);
                int i2 = this.f64285a - 1;
                this.f64285a = i2;
                if (i2 == 0) {
                    this.f64286b.t.getAdapter().notifyDataSetChanged();
                }
            }
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                this.f64285a++;
                super.onRemoveStarting(viewHolder);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(q qVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f64287a;

        public l(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64287a = qVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f64287a.O != null) {
                    this.f64287a.O.k(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.h();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f64288e;

        public m(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64288e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64288e.f64268a.Q2();
                if (this.f64288e.f64268a == null || this.f64288e.Y == null) {
                    return;
                }
                this.f64288e.f64268a.o3();
                this.f64288e.Y.setExpanded(true);
                if (this.f64288e.O != null) {
                    this.f64288e.O.n(this.f64288e.P, this.f64288e.Q, false, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f64289a;

        public n(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64289a = qVar;
        }

        @Override // com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener
        public void onNestedScrollAccepted(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f64289a.v != null && this.f64289a.q.hasTargetView()) {
                this.f64289a.v.p(this.f64289a.e0 == 0 && !this.f64289a.q.canDrag());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f64290e;

        public o(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64290e = qVar;
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
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f64290e.v != null && this.f64290e.q.hasTargetView()) {
                this.f64290e.v.p(false);
                this.f64290e.q.clearTargetView();
            }
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, d.a.q0.u0.m1.e.a aVar, boolean z, d.a.q0.u0.o2.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onClickListener, aVar, Boolean.valueOf(z), hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64268a = null;
        this.f64269b = null;
        this.f64270c = null;
        this.f64271d = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.D = true;
        this.E = true;
        this.F = 0;
        this.G = false;
        this.P = 0;
        this.Q = 0;
        this.R = null;
        this.S = null;
        this.U = false;
        this.W = true;
        this.c0 = true;
        this.d0 = -1;
        this.e0 = -1;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = false;
        this.q0 = new g(this, 2156674);
        this.r0 = new h(this);
        this.s0 = new b(this);
        this.f64268a = frsFragment;
        this.x = onClickListener;
        MessageManager.getInstance().registerListener(this.q0);
        z0(aVar, z);
        this.N = new HashSet<>();
        this.F = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.f0 = TbadkCoreApplication.getInst().getSkinType();
        this.g0 = hVar;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m != null && this.p.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void A1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || this.T == null) {
            return;
        }
        k1();
        if (this.U) {
            this.A.getBarBgView().setAlpha(0.0f);
            this.A.hideBottomLine();
        } else {
            View view = this.R;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.S;
            if (view2 != null) {
                view2.setAlpha(1.0f);
            }
            TextView textView = this.l0;
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
            this.A.getBarBgView().setAlpha(1.0f);
            this.A.showBottomLine();
        }
        K0(this.f0);
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s.b().getParent() != null && this.E : invokeV.booleanValue;
    }

    public void B1() {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.s();
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.i0;
            return frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.b();
        }
        return invokeV.booleanValue;
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.E = true;
            this.t.setNextPage(this.s);
            this.s.z(this.x);
            int i2 = this.F;
            if (i2 > 0) {
                this.s.J(i2);
            }
            this.s.f();
            this.s.A(this.f64268a.getResources().getString(R.string.list_click_load_more));
        }
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.q0.u0.o2.k kVar = this.v;
            if (kVar != null) {
                return kVar.g() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.m == null) {
            return;
        }
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.s0, 5000L);
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.q0.u0.o2.d dVar = this.I;
            if (dVar == null) {
                return false;
            }
            return dVar.p();
        }
        return invokeV.booleanValue;
    }

    public void E1(m2 m2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, m2Var) == null) {
            if (this.m == null) {
                View J2 = this.f64268a.J2();
                ViewStub viewStub = (ViewStub) J2.findViewById(R.id.yule_game_egg_view_stub);
                this.m = viewStub;
                viewStub.setVisibility(0);
                this.n = (FrameLayout) J2.findViewById(R.id.game_activity_egg_layout);
                this.o = (TbImageView) J2.findViewById(R.id.game_activity_egg);
                this.p = (TbImageView) J2.findViewById(R.id.game_activity_egg_s);
                this.o.setPageId(this.f64268a.getUniqueId());
                this.p.setPageId(this.f64268a.getUniqueId());
                this.o.setDefaultBgResource(R.color.common_color_10022);
                this.o.setDefaultResource(0);
                this.p.setDefaultBgResource(R.color.common_color_10022);
                this.p.setDefaultResource(0);
                this.n.setOnClickListener(this.x);
            }
            this.n.setVisibility(0);
            String a2 = m2Var.a();
            String b2 = m2Var.b();
            this.o.M(a2, 10, false);
            this.p.M(b2, 10, false);
            TbadkCoreApplication.getInst().handler.postDelayed(this.s0, 5000L);
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d.a.q0.u0.m1.d.e0 e0Var = this.u;
            if (e0Var instanceof d.a.q0.u0.m1.d.q) {
                ((d.a.q0.u0.m1.d.q) e0Var).r();
            }
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.t.setVisibility(0);
        }
    }

    public void G0() {
        d.a.q0.u0.m1.d.e0 e0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (e0Var = this.u) == null) {
            return;
        }
        e0Var.notifyDataSetChanged();
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.E = true;
            this.t.setNextPage(this.s);
            int i2 = this.F;
            if (i2 > 0) {
                this.s.J(i2);
            }
            this.s.z(null);
            this.s.O();
        }
    }

    public void H0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.o0 = z;
            if (this.O == null) {
                return;
            }
            FrsFragment frsFragment = this.f64268a;
            boolean z2 = (frsFragment == null || frsFragment.K2() == null || this.f64268a.K2().z() == null) ? true : this.f64268a.K2().z().f16138b instanceof FrsAllThreadFragment;
            if (!z && z2) {
                this.O.q(true);
                this.O.n(this.P, this.Q, this.G, true);
                return;
            }
            this.O.q(false);
            this.O.x();
        }
    }

    public final void H1(int i2) {
        d.a.q0.e0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (dVar = this.f64276i) == null) {
            return;
        }
        dVar.g(i2);
    }

    public void I(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onScrollListener) == null) {
            this.t.addOnScrollListener(onScrollListener);
        }
    }

    public void I0(int i2, int i3) {
        d.a.q0.n2.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || (iVar = this.O) == null) {
            return;
        }
        iVar.m(i2, i3, this.G, 1);
    }

    public void I1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, str, i2) == null) {
            if (this.k0 == null) {
                TextView textView = new TextView(this.f64268a.getActivity());
                this.k0 = textView;
                textView.setGravity(19);
                this.k0.setPadding(d.a.d.e.p.l.g(this.f64268a.getActivity(), R.dimen.ds34), 0, d.a.d.e.p.l.g(this.f64268a.getActivity(), R.dimen.ds34), 0);
                this.k0.setLayoutParams(new ViewGroup.LayoutParams(-1, d.a.d.e.p.l.g(this.f64268a.getActivity(), R.dimen.tbds112)));
                this.k0.setTextSize(0, d.a.d.e.p.l.g(this.f64268a.getActivity(), R.dimen.fontsize30));
                this.k0.setMaxLines(2);
                this.k0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.k0.setTextColor(ContextCompat.getColor(this.f64268a.getActivity(), R.color.CAM_X0101));
            }
            this.j0.setBackgroundColor(i2);
            this.k0.setText(str);
            this.j0.m(this.f64268a.getActivity(), this.k0, 5000);
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.f64268a == null) {
            return;
        }
        K(i2);
    }

    public final void J0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || !z || (frsFragment = this.f64268a) == null || frsFragment.R() == null) {
            return;
        }
        this.f64268a.R().U();
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.E = false;
            this.t.setNextPage(this.s);
            int i2 = this.F;
            if (i2 > 0) {
                this.s.J(i2);
            }
            this.s.z(null);
            this.s.f();
            this.s.A(this.f64268a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f64268a.getPageContext(), i2);
                if (this.A.getBackground() != null && this.A.getBackground().mutate() != null) {
                    this.A.getBackground().mutate().setAlpha(0);
                }
                SkinManager.setBackgroundColor(this.A.getBarBgView(), R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.A.getBottomLine(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.B, R.color.CAM_X0204, i2);
                d.a.q0.e0.d dVar = this.f64276i;
                if (dVar != null) {
                    dVar.d(i2);
                }
                if (this.k != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (this.j != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            SkinManager.setBackgroundColor(this.R, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0207);
            S1(true);
        }
    }

    public void K0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f0 = i2;
            d.a.q0.e.f.b bVar = new d.a.q0.e.f.b(this.f64268a, 4);
            bVar.D(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
            d.a.q0.e.f.a aVar = new d.a.q0.e.f.a(this.f64268a.getPageContext(), 4);
            aVar.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
            TbImageView tbImageView = this.M;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            d.a.q0.u0.m1.d.e0 e0Var = this.u;
            if (e0Var != null) {
                e0Var.b();
                this.u.notifyDataSetChanged();
            }
            d.a.p0.u0.a.a(this.f64268a.getPageContext(), this.f64269b);
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.c(this.f64268a.getPageContext(), i2);
            }
            PbListView pbListView = this.s;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.s.d(i2);
            }
            TextView textView = this.l0;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            J(i2);
            d.a.q0.u0.m1.e.c cVar = this.J;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
            }
            d.a.q0.u0.o2.d dVar = this.I;
            if (dVar != null) {
                dVar.u(i2);
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.h0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.d();
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.i0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.c();
            }
            SkinManager.setBackgroundColor(this.f64271d, R.color.CAM_X0202);
        }
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            P();
            d.a.p0.s.s.b bVar = this.w;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    public final void L(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048601, this, appBarLayout, i2) == null) || (frsFragment = this.f64268a) == null || appBarLayout == null || frsFragment.K2() == null || this.f64268a.getPageContext() == null) {
            return;
        }
        int Z = Z() + f0() + h0();
        int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i2);
        FrsTabViewController K2 = this.f64268a.K2();
        ViewGroup.LayoutParams layoutParams = this.f64271d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        FrsFragment frsFragment2 = this.f64268a;
        boolean z = frsFragment2 != null && frsFragment2.c3();
        if (totalScrollRange <= 0) {
            if (this.n0 != 2) {
                K2.f(2);
            }
            this.n0 = 2;
            marginLayoutParams.topMargin = 0;
        } else if (totalScrollRange > 0 && totalScrollRange <= Z) {
            if (this.n0 != 1) {
                K2.f(1);
            }
            this.n0 = 1;
            marginLayoutParams.topMargin = 0;
        } else {
            if (this.n0 != 0) {
                K2.f(0);
            }
            this.n0 = 0;
            if (z) {
                marginLayoutParams.topMargin = d.a.d.e.p.l.g(this.f64268a.getActivity(), R.dimen.tbds_30);
            } else {
                marginLayoutParams.topMargin = 0;
            }
        }
        if (z) {
            this.f64271d.setLayoutParams(marginLayoutParams);
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q0);
            d.a.q0.n2.i iVar = this.O;
            if (iVar != null) {
                iVar.h();
            }
            d.a.q0.u0.o2.m mVar = this.K;
            if (mVar != null) {
                mVar.c();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.h0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.setPageContext(null);
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.i0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.setPageContext(null);
            }
            this.u.m();
            this.t.setOnSrollToBottomListener(null);
            this.t.setScrollable(null);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.s0);
            CommonTipView commonTipView = this.H;
            if (commonTipView != null) {
                commonTipView.i();
            }
            this.N.clear();
            d.a.q0.u0.o2.d dVar = this.I;
            if (dVar != null) {
                dVar.r();
            }
            d.a.q0.v3.e eVar = this.X;
            if (eVar != null) {
                eVar.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.j0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.h0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.e();
            }
            d.a.q0.u0.o2.k kVar = this.v;
            if (kVar != null) {
                kVar.m();
            }
        }
    }

    public void L1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                d.a.p0.t.h.b.a(this.f64268a.m(), postWriteCallBackData);
                return;
            }
            if (this.X == null) {
                this.X = new d.a.q0.v3.e(this.f64268a.getActivity(), this.f64269b);
            }
            this.X.g(postWriteCallBackData);
        }
    }

    public void M(String str) {
        d.a.q0.u0.o2.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (mVar = this.K) == null) {
            return;
        }
        mVar.a(str);
    }

    public boolean M0() {
        InterceptResult invokeV;
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.Y != null && (appBarLayoutStickyBehavior = this.Z) != null && appBarLayoutStickyBehavior.isSticky()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                this.Z.expandedAppBarLayout(this.Y);
                return true;
            }
            d.a.q0.u0.o2.d dVar = this.I;
            return dVar != null && dVar.v();
        }
        return invokeV.booleanValue;
    }

    public void M1() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || d.a.p0.s.d0.b.j().l("frs_video_activity_guide", 0L) != 0 || this.t0 || this.f64268a.getActivity() == null || this.f64268a.getPageContext() == null) {
            return;
        }
        View view = null;
        BdTypeRecyclerView bdTypeRecyclerView = this.t;
        if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.t.getChildCount()) {
            view = this.t.getChildAt(headerViewsCount);
        }
        if (view != null) {
            d.a.d.e.g.d dVar = new d.a.d.e.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new c(this));
            dVar.g(new d(this));
            d.a.d.e.g.c b2 = dVar.b();
            b2.k(false);
            b2.m(this.f64268a.getActivity());
            d.a.d.e.m.e.a().postDelayed(new e(this, b2), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            this.t0 = true;
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.v.e();
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            d.a.q0.u0.o2.d dVar = this.I;
            if (dVar != null) {
                dVar.s();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void N1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || this.I == null) {
            return;
        }
        if (d.a.p0.y.d.h().k()) {
            this.I.A(false);
        } else {
            this.I.A(z);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.k.setVisibility(0);
            this.j.setVisibility(0);
        }
    }

    public void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
        }
    }

    public void O1() {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.t();
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.w == null && this.f64268a.getPageContext() != null) {
            String[] strArr = {this.f64268a.getPageContext().getPageActivity().getString(R.string.take_photo), this.f64268a.getPageContext().getPageActivity().getString(R.string.album)};
            d.a.p0.s.s.b bVar = new d.a.p0.s.s.b(this.f64268a.getPageContext().getPageActivity());
            this.w = bVar;
            bVar.l(this.f64268a.getPageContext().getPageActivity().getString(R.string.operation));
            this.w.j(strArr, new a(this));
            this.w.c(this.f64268a.getPageContext());
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            J(TbadkCoreApplication.getInst().getSkinType());
            d.a.q0.u0.o2.d dVar = this.I;
            if (dVar != null) {
                dVar.t();
            }
        }
    }

    public final void P1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            View m0 = m0();
            View o0 = o0();
            if (!UtilHelper.canUseStyleImmersiveSticky() || m0 == null || o0 == null || m0.getLayoutParams() == null || o0.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = m0.getLayoutParams();
            int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
            layoutParams.height = statusBarHeight;
            if (statusBarHeight < 0) {
                layoutParams.height = 0;
            }
            m0.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = o0.getLayoutParams();
            layoutParams2.height = i2;
            if (i2 > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            o0.setLayoutParams(layoutParams2);
        }
    }

    public void Q() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.a();
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || W() == null) {
            return;
        }
        List<d.a.d.k.e.n> f2 = W().f();
        if (ListUtils.isEmpty(f2)) {
            return;
        }
        for (d.a.d.k.e.n nVar : f2) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.x != 0 && a2Var.w != null && this.f64268a.g0() != null && this.f64268a.g0().d0() != null) {
                    int[] e0 = a2Var.w.e0();
                    a2Var.x = e0[0];
                    a2Var.y = e0[1];
                }
            }
        }
        d.a.d.e.m.e.a().postDelayed(new f(this), 500L);
    }

    public void Q1() {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.u();
    }

    public void R() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.b();
    }

    public void R0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && d.a.p0.s.d0.b.j().g("frs_login_tip", true)) {
                if (this.H == null) {
                    this.H = new CommonTipView(this.f64268a.getActivity());
                }
                this.H.setText(R.string.frs_login_tip);
                this.H.j((FrameLayout) U(), TbadkCoreApplication.getInst().getSkinType());
                d.a.p0.s.d0.b.j().t("frs_login_tip", false);
            }
        }
    }

    public final void R1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (navigationBar = this.A) == null) {
            return;
        }
        float alpha = navigationBar.getBarBgView() != null ? this.A.getBarBgView().getAlpha() : 0.0f;
        float f2 = alpha < 0.5f ? 1.0f - (alpha * 2.0f) : (alpha * 2.0f) - 1.0f;
        if (Float.compare(f2, 0.0f) < 0) {
            f2 = 0.0f;
        }
        if (Float.compare(f2, 1.0f) > 0) {
            f2 = 1.0f;
        }
        TextView textView = this.l0;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            ImageView imageView = this.f64273f;
            if (imageView != null) {
                imageView.setAlpha(f2);
            }
            ImageView imageView2 = this.f64274g;
            if (imageView2 != null) {
                imageView2.setAlpha(f2);
            }
            FrsFragment frsFragment = this.f64268a;
            if (frsFragment != null && frsFragment.K2() != null && this.m0 == 1) {
                this.f64268a.K2().d0(f2);
            }
            MessageRedDotView messageRedDotView = this.f64275h;
            if (messageRedDotView != null) {
                messageRedDotView.setAlpha(f2);
            }
            ImageView imageView3 = this.k;
            if (imageView3 != null) {
                imageView3.setAlpha(f2);
            }
            ImageView imageView4 = this.j;
            if (imageView4 != null) {
                imageView4.setAlpha(f2);
            }
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            float f3 = 1.0f - (2.0f * alpha);
            textView2.setAlpha(f3);
            this.l.setClickable(f3 > 0.0f);
        }
        View view = this.R;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.S;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
        View view3 = this.B;
        if (view3 != null) {
            view3.setAlpha(alpha);
        }
    }

    public final int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            AppBarLayout appBarLayout = this.Y;
            if (appBarLayout == null) {
                return this.d0;
            }
            int i2 = this.d0;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.Y.getChildAt(childCount);
                if (childAt != null) {
                    int scrollFlags = ((AppBarLayout.LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                    if ((scrollFlags & 5) == 5) {
                        if ((scrollFlags & 8) != 0) {
                            i3 += ViewCompat.getMinimumHeight(childAt);
                        }
                    } else if (i3 > 0) {
                        break;
                    }
                }
            }
            int max = Math.max(0, this.Y.getTotalScrollRange() - Math.abs(i3));
            this.d0 = max;
            return max;
        }
        return invokeV.intValue;
    }

    public void S0() {
        d.a.q0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.W && (cVar = this.J) != null) {
                cVar.b(false, false);
            }
            H1(8);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            N1(false);
            this.t.setVisibility(8);
            this.a0.setVisibility(8);
        }
    }

    public final void S1(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048624, this, z) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || !this.U) {
            return;
        }
        if (this.A.getBarBgView().getAlpha() < 0.5f) {
            if (z || this.m0 != 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f64273f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f64274g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.m0 = 0;
            }
        } else if (z || this.m0 != 1) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f64273f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f64274g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), null));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.m0 = 1;
        }
        R1();
    }

    public View T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f64272e : (View) invokeV.objValue;
    }

    public void T0() {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.t();
    }

    public View U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.C : (View) invokeV.objValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            z0(this.V, this.f64268a.W2());
            d.a.q0.u0.m1.d.e0 e0Var = this.u;
            if (e0Var != null) {
                e0Var.e();
            }
        }
    }

    public Context V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            FrsFragment frsFragment = this.f64268a;
            if (frsFragment == null) {
                return null;
            }
            return frsFragment.m().getPageActivity();
        }
        return (Context) invokeV.objValue;
    }

    public void V0(d.a.p0.s.q.g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, g0Var) == null) {
            d.a.q0.e.f.a aVar = new d.a.q0.e.f.a(this.f64268a.getPageContext(), 1);
            aVar.j(this.t);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.f64268a.g());
            hashMap.put("forum_id", this.f64268a.h());
            aVar.k(hashMap);
            aVar.i(g0Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        }
    }

    public d.a.q0.u0.m1.d.e0 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.u : (d.a.q0.u0.m1.d.e0) invokeV.objValue;
    }

    public void W0(int i2, boolean z) {
        d.a.q0.e0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (dVar = this.f64276i) == null) {
            return;
        }
        dVar.e(z, i2);
    }

    public d.a.q0.u0.o2.k X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.v : (d.a.q0.u0.o2.k) invokeV.objValue;
    }

    public void X0() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (noNetworkView = this.z) == null || (bVar = this.y) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public d.a.q0.u0.o2.d Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.I : (d.a.q0.u0.o2.d) invokeV.objValue;
    }

    public void Y0() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (frsMoveAreaBottomMenuView = this.i0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.d();
    }

    public final int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.D) {
                return false;
            }
            this.s.A(this.f64268a.getResources().getString(R.string.load_more_must_after_delete));
            this.s.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            d.a.q0.u0.o2.k kVar = this.v;
            if (kVar == null) {
                return false;
            }
            return kVar.i();
        }
        return invokeV.booleanValue;
    }

    public void a1() {
        d.a.q0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (this.W && (cVar = this.J) != null) {
                cVar.b(true, false);
            }
            H1(0);
            O();
            N1(this.f64268a.n2());
            this.t.setVisibility(0);
            this.a0.setVisibility(0);
        }
    }

    public BdTypeRecyclerView b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.t : (BdTypeRecyclerView) invokeV.objValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.u.notifyDataSetChanged();
        }
    }

    public View c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            PbListView pbListView = this.s;
            if (pbListView == null) {
                return null;
            }
            return pbListView.b();
        }
        return (View) invokeV.objValue;
    }

    public void c1(int i2) {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048644, this, i2) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.n(i2);
    }

    public View d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            d.a.q0.e0.d dVar = this.f64276i;
            if (dVar != null) {
                return dVar.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void d1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048646, this, z) == null) || (appBarLayout = this.Y) == null) {
            return;
        }
        appBarLayout.setExpanded(z);
    }

    public NavigationBar e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.A : (NavigationBar) invokeV.objValue;
    }

    public void e1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048648, this, i2, i3) == null) {
            this.P = i2;
            this.Q = i3;
        }
    }

    public final int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void f1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.u.a(str);
        }
    }

    public ObservedChangeLinearLayout g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.T : (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public void g1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048652, this, i2) == null) || (view = this.f64271d) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public final int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.z == null || d.a.d.e.p.j.z()) {
                return 0;
            }
            return this.z.getHeight();
        }
        return invokeV.intValue;
    }

    public void h1(boolean z) {
        d.a.q0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048654, this, z) == null) || (cVar = this.J) == null) {
            return;
        }
        cVar.a(z);
    }

    public d.a.q0.n2.i i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.O : (d.a.q0.n2.i) invokeV.objValue;
    }

    public void i1(boolean z, boolean z2) {
        d.a.q0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.W && (cVar = this.J) != null) {
            cVar.b(z, z2);
        }
    }

    public TextView j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public void j1(r0 r0Var) {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048658, this, r0Var) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.o(r0Var);
    }

    public d.a.q0.u0.m1.e.c k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.J : (d.a.q0.u0.m1.e.c) invokeV.objValue;
    }

    public final void k1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            this.U = u0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.a0;
            if (frsHeaderViewContainer == null || (layoutParams = frsHeaderViewContainer.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            if (this.U) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + Z(), 0, 0);
            }
            this.a0.requestLayout();
        }
    }

    public RelativeLayout l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.f64269b : (RelativeLayout) invokeV.objValue;
    }

    public void l1(boolean z) {
        d.a.q0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.W = z;
            if (z || (cVar = this.J) == null) {
                return;
            }
            cVar.b(false, false);
        }
    }

    public View m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.R : (View) invokeV.objValue;
    }

    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            this.G = z;
        }
    }

    public final int n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            View view = this.R;
            if (view == null) {
                return 0;
            }
            return view.getHeight();
        }
        return invokeV.intValue;
    }

    public void n1(int i2, boolean z) {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.q(i2, z);
    }

    public View o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.S : (View) invokeV.objValue;
    }

    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
            this.D = z;
            if (z) {
                this.s.A(this.f64268a.getResources().getString(R.string.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.s.b()) {
                    this.s.O();
                    this.f64268a.loadMore();
                    return;
                }
                this.s.f();
                return;
            }
            this.s.A(this.f64268a.getResources().getString(R.string.load_more_must_after_delete));
            this.s.f();
        }
    }

    public ImageView p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.k : (ImageView) invokeV.objValue;
    }

    public void p1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048670, this, i2) == null) || (frsMoveAreaBottomMenuView = this.i0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setVisibility(i2);
    }

    public ImageView q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.j : (ImageView) invokeV.objValue;
    }

    public void q1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048672, this, i2) == null) || (frsMoveAreaBottomMenuView = this.i0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setMoveNumber(i2);
    }

    public void r0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || this.m == null || (frameLayout = this.n) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public void r1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048674, this, i2) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setSelectNumber(i2);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.E = false;
            this.t.setNextPage(null);
        }
    }

    public void s1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048676, this, i2) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setVisibility(i2);
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048677, this, z) == null) || this.J == null) {
            return;
        }
        if (z) {
            i1(false, true);
        } else {
            i1(false, false);
        }
    }

    public void t1(f.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048678, this, cVar) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setDeleteCallback(cVar);
    }

    public final boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            d.a.q0.u0.o2.h hVar = this.g0;
            return hVar != null && hVar.A();
        }
        return invokeV.booleanValue;
    }

    public void u1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i2) == null) {
            this.F = i2;
        }
    }

    public void v0(d.a.p0.s.q.d dVar) {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048681, this, dVar) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.d(dVar);
    }

    public void v1(d.a.d.k.e.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, wVar) == null) {
            this.u.d(wVar);
        }
    }

    public void w0() {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.k();
    }

    public void w1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, bVar) == null) {
            this.y = bVar;
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void x0() {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048685, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.l();
    }

    public void x1(boolean z) {
        d.a.q0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048686, this, z) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.r(z);
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && this.L == null) {
            View J2 = this.f64268a.J2();
            this.L = (GifView) J2.findViewById(R.id.gif_real_time);
            TbImageView tbImageView = (TbImageView) J2.findViewById(R.id.tbimg_real_time);
            this.M = tbImageView;
            tbImageView.setPageId(this.f64268a.getUniqueId());
            this.L.setLayerType(1, null);
            this.M.setLayerType(1, null);
        }
    }

    public void y1(ArrayList<d.a.d.k.e.n> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048688, this, arrayList, frsViewData) == null) || frsViewData == null) {
            return;
        }
        ArrayList<d.a.d.k.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            s sVar = new s();
            ArrayList<d.a.d.k.e.n> arrayList2 = new ArrayList<>();
            arrayList2.add(sVar);
            FrsFragment frsFragment = this.f64268a;
            if (frsFragment != null && frsFragment.g0() != null && this.f64268a.g0().V() == 0) {
                sVar.c(this.f64268a.g0().R());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                d.a.d.k.e.n nVar = switchThreadDataToThreadCardInfo.get(i3);
                if (nVar instanceof a2) {
                    ((a2) nVar).w.b4(i3);
                }
            }
        }
        this.u.g(switchThreadDataToThreadCardInfo, frsViewData);
        d.a.q0.n2.i iVar = this.O;
        if (iVar != null && (i2 = this.P) != 0) {
            iVar.n(i2, this.Q, this.G, true);
        }
        FrsFragment frsFragment2 = this.f64268a;
        if (frsFragment2 != null) {
            frsFragment2.x3();
        }
    }

    public final void z0(d.a.q0.u0.m1.e.a aVar, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048689, this, aVar, z) == null) {
            this.V = aVar;
            View J2 = this.f64268a.J2();
            if (this.f64269b == null) {
                this.f64269b = (NoPressedRelativeLayout) J2.findViewById(R.id.frs);
            }
            if (this.f64271d == null) {
                this.f64271d = J2.findViewById(R.id.frs_content_container);
            }
            if (this.f64270c == null) {
                this.f64270c = (CoordinatorLayout) J2.findViewById(R.id.frs_nested_scroll_layout);
            }
            if (this.C == null) {
                this.C = J2.findViewById(R.id.frs_list_content);
            }
            if (this.b0 == null) {
                this.b0 = (CollapsingToolbarLayout) J2.findViewById(R.id.frs_collapse_layout);
            }
            if (this.a0 == null) {
                this.a0 = (FrsHeaderViewContainer) J2.findViewById(R.id.header_view_container);
            }
            if (this.v == null) {
                this.v = new d.a.q0.u0.o2.k(this.f64268a);
            }
            if (this.T == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) J2.findViewById(R.id.navigation_bar_wrapperLayout);
                this.T = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new i(this));
            }
            if (this.A == null) {
                NavigationBar navigationBar = (NavigationBar) J2.findViewById(R.id.view_navigation_bar);
                this.A = navigationBar;
                navigationBar.getBarBgView().setAlpha(1.0f);
                this.A.setContentPaddingTop(d.a.d.e.p.l.g(V(), R.dimen.tbds24));
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f64268a.W2()) {
                this.A.setVisibility(8);
            }
            if (this.B == null) {
                this.B = J2.findViewById(R.id.frs_navi_line);
                d.a.q0.u0.m1.e.b c2 = aVar.c();
                if (c2 != null) {
                    c2.b(this.B);
                }
            }
            if (this.f64272e == null) {
                View addSystemImageButton = this.A.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.f64272e = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.x);
                this.f64273f = (ImageView) this.f64272e.findViewById(R.id.widget_navi_back_button);
            }
            if (this.k == null) {
                this.k = (ImageView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.k.setOnClickListener(this.x);
            }
            if (this.f64276i == null) {
                d.a.q0.e0.d dVar = new d.a.q0.e0.d(this.f64268a.getPageContext().getPageActivity());
                this.f64276i = dVar;
                this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, dVar.c(), (View.OnClickListener) null);
                this.f64274g = this.f64276i.b();
                MessageRedDotView a2 = this.f64276i.a();
                this.f64275h = a2;
                a2.setShadowEnabled(false);
                this.f64276i.c().setOnClickListener(this.x);
                this.f64276i.f(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
            }
            if (this.j == null) {
                this.j = (ImageView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.j.setOnClickListener(this.x);
            }
            if (this.l == null) {
                TextView textView = (TextView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
                this.l = textView;
                textView.setVisibility(8);
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
                int g2 = d.a.d.e.p.l.g(this.f64268a.getActivity(), R.dimen.tbds31);
                drawable.setBounds(0, 0, g2, g2);
                this.l.setCompoundDrawables(null, null, drawable, null);
                SkinManager.setBackgroundResourceSelector(this.l, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
            }
            if (z2) {
                this.A.onChangeSkinType(this.f64268a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.A.getBottomLine(), R.color.CAM_X0204);
            }
            if (this.t == null) {
                this.t = (BdTypeRecyclerView) J2.findViewById(R.id.frs_lv_thread);
            }
            j jVar = new j(this);
            jVar.setSupportsChangeAnimations(false);
            this.t.setItemAnimator(jVar);
            BdTypeRecyclerView bdTypeRecyclerView = this.t;
            bdTypeRecyclerView.setLayoutManager(new k(this, bdTypeRecyclerView.getContext()));
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                d.a.d.k.e.l lVar = new d.a.d.k.e.l(new d.a.d.k.e.j());
                this.p0 = lVar;
                lVar.q(this.t, 2);
            }
            this.t.setScrollable(this.f64268a);
            this.t.setFadingEdgeLength(0);
            this.t.setOverScrollMode(2);
            this.f64269b.setBottomOrderView(this.t);
            this.t.setOnTouchListener(this.f64268a.G1);
            this.t.setRecyclerListener(new l(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.t;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.t.getPaddingBottom());
            if (this.s == null) {
                PbListView pbListView = new PbListView(this.f64268a.getPageContext().getPageActivity());
                this.s = pbListView;
                pbListView.b();
            }
            this.s.o(R.color.transparent);
            this.s.r(d.a.d.e.p.l.g(this.f64268a.getActivity(), R.dimen.tbds182));
            this.s.v();
            this.s.E(R.dimen.tbfontsize33);
            this.s.C(SkinManager.getColor(R.color.CAM_X0109));
            this.s.y(R.color.CAM_X0110);
            this.t.setOnSrollToBottomListener(this.f64268a);
            this.A.setOnClickListener(new m(this));
            boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
            if (this.u == null) {
                this.u = aVar.b(this.f64268a, this.t, isShowBigImage);
            }
            d.a.q0.u0.o2.k kVar = this.v;
            if (kVar != null) {
                kVar.q(1, false);
            }
            if (!z) {
                if (this.z == null) {
                    this.z = new NoNetworkView(this.f64268a.getActivity());
                    this.z.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.T.addView(this.z);
                }
                if (d.a.d.e.p.j.A()) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setVisibility(0);
                }
                this.z.c(this.f64268a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            y0();
            if (this.I == null) {
                d.a.q0.u0.o2.d a3 = aVar.a(this.f64268a, this.f64269b);
                this.I = a3;
                a3.x(this.f64268a.N2());
            }
            if (this.J == null) {
                this.J = aVar.d(this.f64268a, this.f64269b);
                h1(true);
            }
            if (this.R == null) {
                this.R = J2.findViewById(R.id.statebar_view);
            }
            if (this.S == null) {
                this.S = J2.findViewById(R.id.statebar_view_holder);
            }
            if (this.O == null) {
                this.O = new d.a.q0.n2.i(this.f64268a.getPageContext(), this.t);
            }
            this.O.p(1);
            this.O.t(this.f64268a.getUniqueId());
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) J2.findViewById(R.id.navigation_cover_tip);
            this.j0 = navigationBarCoverTip;
            if (this.K == null) {
                this.K = new d.a.q0.u0.o2.m(this.f64268a, navigationBarCoverTip);
            }
            if (this.Y == null) {
                AppBarLayout appBarLayout = (AppBarLayout) J2.findViewById(R.id.frs_app_bar_layout);
                this.Y = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.r0);
                this.c0 = true;
                this.d0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Y.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.Z = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) J2.findViewById(R.id.frs_multi_delete_menu_view);
            this.h0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.f64268a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) J2.findViewById(R.id.frs_move_area_menu_view);
            this.i0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.f64268a.getPageContext());
            if (this.l0 == null) {
                this.l0 = this.A.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) this.f64268a.getResources().getDimension(R.dimen.ds20);
                layoutParams2.setMargins(0, dimension, dimension, dimension);
                this.l0.setLayoutParams(layoutParams2);
                this.l0.setPadding(0, 0, this.f64268a.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
                this.l0.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            ExposeTagViewCoordinatorLayout exposeTagViewCoordinatorLayout = (ExposeTagViewCoordinatorLayout) J2.findViewById(R.id.frs_nested_scroll_layout);
            this.q = exposeTagViewCoordinatorLayout;
            exposeTagViewCoordinatorLayout.setListener(new n(this));
            FrsTabViewPager frsTabViewPager = (FrsTabViewPager) J2.findViewById(R.id.frs_viewpager);
            this.r = frsTabViewPager;
            frsTabViewPager.addOnPageChangeListener(new o(this));
        }
    }

    public void z1(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048690, this, str) == null) && TextUtils.isEmpty(this.l0.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.l0.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.l0.setText(str2);
            d.a.p0.s.k.c().h(str);
        }
    }
}
