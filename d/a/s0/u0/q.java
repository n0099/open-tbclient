package d.a.s0.u0;

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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
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
import d.a.c.e.g.d;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.l2;
import d.a.r0.r.s.b;
import d.a.s0.h.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public CommonTipView F;
    public d.a.s0.u0.o2.d G;
    public d.a.s0.u0.m1.e.c H;
    public d.a.s0.u0.o2.m I;
    public GifView J;
    public TbImageView K;
    public HashSet<String> L;
    public d.a.s0.n2.i M;
    public int N;
    public int O;
    public View P;
    public View Q;
    public ObservedChangeLinearLayout R;
    public boolean S;
    public d.a.s0.u0.m1.e.a T;
    public boolean U;
    public d.a.s0.v3.e V;
    public AppBarLayout W;
    public AppBarLayoutStickyBehavior X;
    public FrsHeaderViewContainer Y;
    public CollapsingToolbarLayout Z;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f66842a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f66843b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public CoordinatorLayout f66844c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f66845d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public View f66846e;
    public d.a.s0.u0.o2.h e0;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f66847f;
    public FrsMultiDelBottomMenuView f0;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f66848g;
    public FrsMoveAreaBottomMenuView g0;

    /* renamed from: h  reason: collision with root package name */
    public MessageRedDotView f66849h;
    public NavigationBarCoverTip h0;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.e0.d f66850i;
    public TextView i0;
    public ImageView j;
    public TextView j0;
    public ImageView k;
    public int k0;
    public TextView l;
    public int l0;
    public ViewStub m;
    public boolean m0;
    public FrameLayout n;
    public d.a.c.k.e.l n0;
    public TbImageView o;
    public CustomMessageListener o0;
    public TbImageView p;
    public AppBarLayout.OnOffsetChangedListener p0;
    public PbListView q;
    public Runnable q0;
    public BdTypeRecyclerView r;
    public boolean r0;
    public d.a.s0.u0.m1.d.e0 s;
    public d.a.s0.u0.o2.k t;
    public d.a.r0.r.s.b u;
    public View.OnClickListener v;
    public NoNetworkView.b w;
    public NoNetworkView x;
    public NavigationBar y;
    public View z;

    /* loaded from: classes9.dex */
    public class a implements d.a.c.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f66851a;

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
            this.f66851a = qVar;
        }

        @Override // d.a.c.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                this.f66851a.f66842a.getPageContext().getLayoutMode().j(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.c.e.p.l.g(this.f66851a.f66842a.getActivity(), R.dimen.ds10) : invokeV.intValue;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? -d.a.c.e.p.l.g(this.f66851a.f66842a.getActivity(), R.dimen.ds6) : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.r0.r.d0.b.j().w("frs_video_activity_guide", 1L);
            }
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.g.c f66852e;

        public c(q qVar, d.a.c.e.g.c cVar) {
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
            this.f66852e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.g.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f66852e) == null) {
                return;
            }
            cVar.d();
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f66853e;

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
                    return;
                }
            }
            this.f66853e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66853e.V().notifyDataSetChanged();
                if (this.f66853e.m0) {
                    return;
                }
                this.f66853e.M.n(this.f66853e.N, this.f66853e.O, this.f66853e.E, true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f66854a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(q qVar, int i2) {
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
            this.f66854a = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f66854a.n0 == null) {
                        this.f66854a.n0 = new d.a.c.k.e.l(new d.a.c.k.e.j());
                    }
                    this.f66854a.n0.q(this.f66854a.r, 2);
                } else if (this.f66854a.n0 != null) {
                    this.f66854a.n0.w();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f66855a;

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
            this.f66855a = qVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                this.f66855a.K(appBarLayout, i2);
                if (this.f66855a.t != null) {
                    this.f66855a.t.p(i2 == 0);
                }
                if (this.f66855a.c0 != i2 && Math.abs(i2) >= 0 && this.f66855a.R() != -1) {
                    if (Math.abs(i2) >= this.f66855a.R()) {
                        if (this.f66855a.a0) {
                            this.f66855a.a0 = false;
                            q qVar = this.f66855a;
                            qVar.I0(qVar.a0);
                        }
                    } else if (!this.f66855a.a0) {
                        this.f66855a.a0 = true;
                        q qVar2 = this.f66855a;
                        qVar2.I0(qVar2.a0);
                    }
                    int Y = this.f66855a.Y() + this.f66855a.e0() + this.f66855a.g0();
                    int totalScrollRange = appBarLayout.getTotalScrollRange() - Y;
                    int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i2);
                    if (totalScrollRange <= 0) {
                        return;
                    }
                    float abs = Math.abs(i2 * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && this.f66855a.c0 - i2 < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        this.f66855a.O1(Math.abs(Y - totalScrollRange2));
                        if (this.f66855a.Q != null) {
                            this.f66855a.Q.setVisibility(0);
                        }
                    } else if (this.f66855a.Q != null) {
                        if (this.f66855a.m0() != UtilHelper.getStatusBarHeight()) {
                            this.f66855a.O1(0);
                        }
                        this.f66855a.Q.setVisibility(8);
                    }
                    if (this.f66855a.y != null) {
                        if (this.f66855a.S) {
                            this.f66855a.y.getBarBgView().setAlpha(abs);
                            this.f66855a.R1(false);
                        } else if (this.f66855a.j0 != null) {
                            this.f66855a.j0.setAlpha(abs);
                        }
                    }
                    this.f66855a.c0 = i2;
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i2));
                    CustomMessage customMessage = new CustomMessage(2921397);
                    if (this.f66855a.f66842a != null && this.f66855a.f66842a.E2() != null && this.f66855a.f66842a.E2().z() != null && (this.f66855a.f66842a.E2().z().f16044b instanceof BaseFragment)) {
                        customMessage.setTag(((BaseFragment) this.f66855a.f66842a.E2().z().f16044b).getUniqueId());
                        customResponsedMessage.setOrginalMessage(customMessage);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.f66855a.t == null || this.f66855a.t.h() <= 0 || Math.abs(i2) < this.f66855a.t.h()) {
                    return;
                }
                this.f66855a.t.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements d.a.r0.b1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f66856a;

        public g(q qVar) {
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
            this.f66856a = qVar;
        }

        @Override // d.a.r0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i3 == i5 || i5 <= 0) {
                return;
            }
            this.f66856a.Z.setMinimumHeight(i3);
        }
    }

    /* loaded from: classes9.dex */
    public class h extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f66857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f66858b;

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
            this.f66858b = qVar;
            this.f66857a = 0;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                super.onRemoveFinished(viewHolder);
                int i2 = this.f66857a - 1;
                this.f66857a = i2;
                if (i2 == 0) {
                    this.f66858b.r.getAdapter().notifyDataSetChanged();
                }
            }
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                this.f66857a++;
                super.onRemoveStarting(viewHolder);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(q qVar, Context context) {
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

    /* loaded from: classes9.dex */
    public class j implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f66859a;

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
            this.f66859a = qVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.f66859a.M != null) {
                    this.f66859a.M.k(view);
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

    /* loaded from: classes9.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f66860e;

        public k(q qVar) {
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
            this.f66860e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f66860e.f66842a.K2();
                if (this.f66860e.f66842a == null || this.f66860e.W == null) {
                    return;
                }
                this.f66860e.f66842a.i3();
                this.f66860e.W.setExpanded(true);
                if (this.f66860e.M != null) {
                    this.f66860e.M.n(this.f66860e.N, this.f66860e.O, false, true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f66861a;

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
            this.f66861a = qVar;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                if (i2 == 0) {
                    this.f66861a.f66842a.V3();
                } else if (i2 != 1 || this.f66861a.f66842a.getPageContext() == null) {
                } else {
                    SelectImageHelper.getAlbumImage(this.f66861a.f66842a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f66862e;

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
            this.f66862e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66862e.m == null) {
                return;
            }
            this.f66862e.n.setVisibility(0);
            this.f66862e.p.setVisibility(0);
            this.f66862e.o.setVisibility(8);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, d.a.s0.u0.m1.e.a aVar, boolean z, d.a.s0.u0.o2.h hVar) {
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
        this.f66842a = null;
        this.f66843b = null;
        this.f66844c = null;
        this.f66845d = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.B = true;
        this.C = true;
        this.D = 0;
        this.E = false;
        this.N = 0;
        this.O = 0;
        this.P = null;
        this.Q = null;
        this.S = false;
        this.U = true;
        this.a0 = true;
        this.b0 = -1;
        this.c0 = -1;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = false;
        this.o0 = new e(this, 2156674);
        this.p0 = new f(this);
        this.q0 = new m(this);
        this.f66842a = frsFragment;
        this.v = onClickListener;
        MessageManager.getInstance().registerListener(this.o0);
        y0(aVar, z);
        this.L = new HashSet<>();
        this.D = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.d0 = TbadkCoreApplication.getInst().getSkinType();
        this.e0 = hVar;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q.b().getParent() != null && this.C : invokeV.booleanValue;
    }

    public void A1() {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.s();
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
            return frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.b();
        }
        return invokeV.booleanValue;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.C = true;
            this.r.setNextPage(this.q);
            this.q.z(this.v);
            int i2 = this.D;
            if (i2 > 0) {
                this.q.J(i2);
            }
            this.q.f();
            this.q.A(this.f66842a.getResources().getString(R.string.list_click_load_more));
        }
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.s0.u0.o2.k kVar = this.t;
            if (kVar != null) {
                return kVar.g() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.m == null) {
            return;
        }
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.q0, 5000L);
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.s0.u0.o2.d dVar = this.G;
            if (dVar == null) {
                return false;
            }
            return dVar.p();
        }
        return invokeV.booleanValue;
    }

    public void D1(l2 l2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, l2Var) == null) {
            if (this.m == null) {
                View D2 = this.f66842a.D2();
                ViewStub viewStub = (ViewStub) D2.findViewById(R.id.yule_game_egg_view_stub);
                this.m = viewStub;
                viewStub.setVisibility(0);
                this.n = (FrameLayout) D2.findViewById(R.id.game_activity_egg_layout);
                this.o = (TbImageView) D2.findViewById(R.id.game_activity_egg);
                this.p = (TbImageView) D2.findViewById(R.id.game_activity_egg_s);
                this.o.setPageId(this.f66842a.getUniqueId());
                this.p.setPageId(this.f66842a.getUniqueId());
                this.o.setDefaultBgResource(R.color.common_color_10022);
                this.o.setDefaultResource(0);
                this.p.setDefaultBgResource(R.color.common_color_10022);
                this.p.setDefaultResource(0);
                this.n.setOnClickListener(this.v);
            }
            this.n.setVisibility(0);
            String a2 = l2Var.a();
            String b2 = l2Var.b();
            this.o.M(a2, 10, false);
            this.p.M(b2, 10, false);
            TbadkCoreApplication.getInst().handler.postDelayed(this.q0, 5000L);
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.s0.u0.m1.d.e0 e0Var = this.s;
            if (e0Var instanceof d.a.s0.u0.m1.d.q) {
                ((d.a.s0.u0.m1.d.q) e0Var).r();
            }
        }
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.r.setVisibility(0);
        }
    }

    public void F0() {
        d.a.s0.u0.m1.d.e0 e0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (e0Var = this.s) == null) {
            return;
        }
        e0Var.notifyDataSetChanged();
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.C = true;
            this.r.setNextPage(this.q);
            int i2 = this.D;
            if (i2 > 0) {
                this.q.J(i2);
            }
            this.q.z(null);
            this.q.O();
        }
    }

    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m0 = z;
            if (this.M == null) {
                return;
            }
            FrsFragment frsFragment = this.f66842a;
            boolean z2 = (frsFragment == null || frsFragment.E2() == null || this.f66842a.E2().z() == null) ? true : this.f66842a.E2().z().f16044b instanceof FrsAllThreadFragment;
            if (!z && z2) {
                this.M.q(true);
                this.M.n(this.N, this.O, this.E, true);
                return;
            }
            this.M.q(false);
            this.M.x();
        }
    }

    public final void G1(int i2) {
        d.a.s0.e0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (dVar = this.f66850i) == null) {
            return;
        }
        dVar.g(i2);
    }

    public void H(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onScrollListener) == null) {
            this.r.addOnScrollListener(onScrollListener);
        }
    }

    public void H0(int i2, int i3) {
        d.a.s0.n2.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || (iVar = this.M) == null) {
            return;
        }
        iVar.m(i2, i3, this.E, 1);
    }

    public void H1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i2) == null) {
            if (this.i0 == null) {
                TextView textView = new TextView(this.f66842a.getActivity());
                this.i0 = textView;
                textView.setGravity(19);
                this.i0.setPadding(d.a.c.e.p.l.g(this.f66842a.getActivity(), R.dimen.ds34), 0, d.a.c.e.p.l.g(this.f66842a.getActivity(), R.dimen.ds34), 0);
                this.i0.setLayoutParams(new ViewGroup.LayoutParams(-1, d.a.c.e.p.l.g(this.f66842a.getActivity(), R.dimen.tbds112)));
                this.i0.setTextSize(0, d.a.c.e.p.l.g(this.f66842a.getActivity(), R.dimen.fontsize30));
                this.i0.setMaxLines(2);
                this.i0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.i0.setTextColor(ContextCompat.getColor(this.f66842a.getActivity(), R.color.CAM_X0101));
            }
            this.h0.setBackgroundColor(i2);
            this.i0.setText(str);
            this.h0.m(this.f66842a.getActivity(), this.i0, 5000);
        }
    }

    public final void I(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || this.f66842a == null) {
            return;
        }
        J(i2);
    }

    public final void I0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || !z || (frsFragment = this.f66842a) == null || frsFragment.Q() == null) {
            return;
        }
        this.f66842a.Q().U();
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.C = false;
            this.r.setNextPage(this.q);
            int i2 = this.D;
            if (i2 > 0) {
                this.q.J(i2);
            }
            this.q.z(null);
            this.q.f();
            this.q.A(this.f66842a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            NavigationBar navigationBar = this.y;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f66842a.getPageContext(), i2);
                if (this.y.getBackground() != null && this.y.getBackground().mutate() != null) {
                    this.y.getBackground().mutate().setAlpha(0);
                }
                SkinManager.setBackgroundColor(this.y.getBarBgView(), R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.y.getBottomLine(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204, i2);
                d.a.s0.e0.d dVar = this.f66850i;
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
            SkinManager.setBackgroundColor(this.P, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.Q, R.color.CAM_X0207);
            R1(true);
        }
    }

    public void J0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.d0 = i2;
            d.a.s0.e.f.b bVar = new d.a.s0.e.f.b(this.f66842a, 4);
            bVar.D(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
            d.a.s0.e.f.a aVar = new d.a.s0.e.f.a(this.f66842a.getPageContext(), 4);
            aVar.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
            TbImageView tbImageView = this.K;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            d.a.s0.u0.m1.d.e0 e0Var = this.s;
            if (e0Var != null) {
                e0Var.b();
                this.s.notifyDataSetChanged();
            }
            d.a.r0.s0.a.a(this.f66842a.getPageContext(), this.f66843b);
            NoNetworkView noNetworkView = this.x;
            if (noNetworkView != null) {
                noNetworkView.c(this.f66842a.getPageContext(), i2);
            }
            PbListView pbListView = this.q;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.q.d(i2);
            }
            TextView textView = this.j0;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            I(i2);
            d.a.s0.u0.m1.e.c cVar = this.H;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
            }
            d.a.s0.u0.o2.d dVar = this.G;
            if (dVar != null) {
                dVar.u(i2);
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.d();
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.c();
            }
            SkinManager.setBackgroundColor(this.f66845d, R.color.CAM_X0202);
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            O();
            d.a.r0.r.s.b bVar = this.u;
            if (bVar != null) {
                bVar.m();
            }
        }
    }

    public final void K(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048599, this, appBarLayout, i2) == null) || (frsFragment = this.f66842a) == null || appBarLayout == null || frsFragment.E2() == null || this.f66842a.getPageContext() == null) {
            return;
        }
        int Y = Y() + e0() + g0();
        int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i2);
        FrsTabViewController E2 = this.f66842a.E2();
        ViewGroup.LayoutParams layoutParams = this.f66845d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        FrsFragment frsFragment2 = this.f66842a;
        boolean z = frsFragment2 != null && frsFragment2.W2();
        if (totalScrollRange <= 0) {
            if (this.l0 != 2) {
                E2.f(2);
            }
            this.l0 = 2;
            marginLayoutParams.topMargin = 0;
        } else if (totalScrollRange > 0 && totalScrollRange <= Y) {
            if (this.l0 != 1) {
                E2.f(1);
            }
            this.l0 = 1;
            marginLayoutParams.topMargin = 0;
        } else {
            if (this.l0 != 0) {
                E2.f(0);
            }
            this.l0 = 0;
            if (z) {
                marginLayoutParams.topMargin = d.a.c.e.p.l.g(this.f66842a.getActivity(), R.dimen.tbds_30);
            } else {
                marginLayoutParams.topMargin = 0;
            }
        }
        if (z) {
            this.f66845d.setLayoutParams(marginLayoutParams);
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o0);
            d.a.s0.n2.i iVar = this.M;
            if (iVar != null) {
                iVar.h();
            }
            d.a.s0.u0.o2.m mVar = this.I;
            if (mVar != null) {
                mVar.c();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.setPageContext(null);
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.setPageContext(null);
            }
            this.s.m();
            this.r.setOnSrollToBottomListener(null);
            this.r.setScrollable(null);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.q0);
            CommonTipView commonTipView = this.F;
            if (commonTipView != null) {
                commonTipView.i();
            }
            this.L.clear();
            d.a.s0.u0.o2.d dVar = this.G;
            if (dVar != null) {
                dVar.r();
            }
            d.a.s0.v3.e eVar = this.V;
            if (eVar != null) {
                eVar.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.h0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.f0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.e();
            }
            d.a.s0.u0.o2.k kVar = this.t;
            if (kVar != null) {
                kVar.m();
            }
        }
    }

    public void K1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                d.a.r0.s.h.b.a(this.f66842a.n(), postWriteCallBackData);
                return;
            }
            if (this.V == null) {
                this.V = new d.a.s0.v3.e(this.f66842a.getActivity(), this.f66843b);
            }
            this.V.g(postWriteCallBackData);
        }
    }

    public void L(String str) {
        d.a.s0.u0.o2.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || (mVar = this.I) == null) {
            return;
        }
        mVar.a(str);
    }

    public boolean L0() {
        InterceptResult invokeV;
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.W != null && (appBarLayoutStickyBehavior = this.X) != null && appBarLayoutStickyBehavior.isSticky()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.r;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                this.X.expandedAppBarLayout(this.W);
                return true;
            }
            d.a.s0.u0.o2.d dVar = this.G;
            return dVar != null && dVar.v();
        }
        return invokeV.booleanValue;
    }

    public void L1() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || d.a.r0.r.d0.b.j().l("frs_video_activity_guide", 0L) != 0 || this.r0 || this.f66842a.getActivity() == null || this.f66842a.getPageContext() == null) {
            return;
        }
        View view = null;
        BdTypeRecyclerView bdTypeRecyclerView = this.r;
        if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.r.getChildCount()) {
            view = this.r.getChildAt(headerViewsCount);
        }
        if (view != null) {
            d.a.c.e.g.d dVar = new d.a.c.e.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new a(this));
            dVar.g(new b(this));
            d.a.c.e.g.c b2 = dVar.b();
            b2.l(false);
            b2.n(this.f66842a.getActivity());
            d.a.c.e.m.e.a().postDelayed(new c(this, b2), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            this.r0 = true;
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.t.e();
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            d.a.s0.u0.o2.d dVar = this.G;
            if (dVar != null) {
                dVar.s();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void M1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || this.G == null) {
            return;
        }
        if (d.a.r0.x.d.h().k()) {
            this.G.A(false);
        } else {
            this.G.A(z);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.k.setVisibility(0);
            this.j.setVisibility(0);
        }
    }

    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
        }
    }

    public void N1() {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.t();
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.u == null && this.f66842a.getPageContext() != null) {
            String[] strArr = {this.f66842a.getPageContext().getPageActivity().getString(R.string.take_photo), this.f66842a.getPageContext().getPageActivity().getString(R.string.album)};
            d.a.r0.r.s.b bVar = new d.a.r0.r.s.b(this.f66842a.getPageContext().getPageActivity());
            this.u = bVar;
            bVar.l(this.f66842a.getPageContext().getPageActivity().getString(R.string.operation));
            this.u.j(strArr, new l(this));
            this.u.c(this.f66842a.getPageContext());
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            I(TbadkCoreApplication.getInst().getSkinType());
            d.a.s0.u0.o2.d dVar = this.G;
            if (dVar != null) {
                dVar.t();
            }
        }
    }

    public final void O1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            View l0 = l0();
            View n0 = n0();
            if (!UtilHelper.canUseStyleImmersiveSticky() || l0 == null || n0 == null || l0.getLayoutParams() == null || n0.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = l0.getLayoutParams();
            int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
            layoutParams.height = statusBarHeight;
            if (statusBarHeight < 0) {
                layoutParams.height = 0;
            }
            l0.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = n0.getLayoutParams();
            layoutParams2.height = i2;
            if (i2 > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            n0.setLayoutParams(layoutParams2);
        }
    }

    public void P() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (frsMultiDelBottomMenuView = this.f0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.a();
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || V() == null) {
            return;
        }
        List<d.a.c.k.e.n> f2 = V().f();
        if (ListUtils.isEmpty(f2)) {
            return;
        }
        for (d.a.c.k.e.n nVar : f2) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.x != 0 && a2Var.w != null && this.f66842a.d0() != null && this.f66842a.d0().d0() != null) {
                    int[] d0 = a2Var.w.d0();
                    a2Var.x = d0[0];
                    a2Var.y = d0[1];
                }
            }
        }
        d.a.c.e.m.e.a().postDelayed(new d(this), 500L);
    }

    public void P1() {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.u();
    }

    public void Q() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (frsMultiDelBottomMenuView = this.f0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.b();
    }

    public void Q0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048618, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && d.a.r0.r.d0.b.j().g("frs_login_tip", true)) {
                if (this.F == null) {
                    this.F = new CommonTipView(this.f66842a.getActivity());
                }
                this.F.setText(R.string.frs_login_tip);
                this.F.j((FrameLayout) T(), TbadkCoreApplication.getInst().getSkinType());
                d.a.r0.r.d0.b.j().t("frs_login_tip", false);
            }
        }
    }

    public final void Q1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (navigationBar = this.y) == null) {
            return;
        }
        float alpha = navigationBar.getBarBgView() != null ? this.y.getBarBgView().getAlpha() : 0.0f;
        float f2 = alpha < 0.5f ? 1.0f - (alpha * 2.0f) : (alpha * 2.0f) - 1.0f;
        if (Float.compare(f2, 0.0f) < 0) {
            f2 = 0.0f;
        }
        if (Float.compare(f2, 1.0f) > 0) {
            f2 = 1.0f;
        }
        TextView textView = this.j0;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            ImageView imageView = this.f66847f;
            if (imageView != null) {
                imageView.setAlpha(f2);
            }
            ImageView imageView2 = this.f66848g;
            if (imageView2 != null) {
                imageView2.setAlpha(f2);
            }
            FrsFragment frsFragment = this.f66842a;
            if (frsFragment != null && frsFragment.E2() != null && this.k0 == 1) {
                this.f66842a.E2().c0(f2);
            }
            MessageRedDotView messageRedDotView = this.f66849h;
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
        View view = this.P;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.Q;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
        View view3 = this.z;
        if (view3 != null) {
            view3.setAlpha(alpha);
        }
    }

    public final int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            AppBarLayout appBarLayout = this.W;
            if (appBarLayout == null) {
                return this.b0;
            }
            int i2 = this.b0;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.W.getChildAt(childCount);
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
            int max = Math.max(0, this.W.getTotalScrollRange() - Math.abs(i3));
            this.b0 = max;
            return max;
        }
        return invokeV.intValue;
    }

    public void R0() {
        d.a.s0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.U && (cVar = this.H) != null) {
                cVar.b(false, false);
            }
            G1(8);
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            M1(false);
            this.r.setVisibility(8);
            this.Y.setVisibility(8);
        }
    }

    public final void R1(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048622, this, z) == null) || (navigationBar = this.y) == null || navigationBar.getBarBgView() == null || !this.S) {
            return;
        }
        if (this.y.getBarBgView().getAlpha() < 0.5f) {
            if (z || this.k0 != 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f66847f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f66848g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.k0 = 0;
            }
        } else if (z || this.k0 != 1) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f66847f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f66848g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), null));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.k0 = 1;
        }
        Q1();
    }

    public View S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f66846e : (View) invokeV.objValue;
    }

    public void S0() {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.t();
    }

    public View T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.A : (View) invokeV.objValue;
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            y0(this.T, this.f66842a.Q2());
            d.a.s0.u0.m1.d.e0 e0Var = this.s;
            if (e0Var != null) {
                e0Var.e();
            }
        }
    }

    public Context U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            FrsFragment frsFragment = this.f66842a;
            if (frsFragment == null) {
                return null;
            }
            return frsFragment.n().getPageActivity();
        }
        return (Context) invokeV.objValue;
    }

    public void U0(d.a.r0.r.q.g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, g0Var) == null) {
            d.a.s0.e.f.a aVar = new d.a.s0.e.f.a(this.f66842a.getPageContext(), 1);
            aVar.j(this.r);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.f66842a.h());
            hashMap.put("forum_id", this.f66842a.i());
            aVar.k(hashMap);
            aVar.i(g0Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        }
    }

    public d.a.s0.u0.m1.d.e0 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.s : (d.a.s0.u0.m1.d.e0) invokeV.objValue;
    }

    public void V0(int i2, boolean z) {
        d.a.s0.e0.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (dVar = this.f66850i) == null) {
            return;
        }
        dVar.e(z, i2);
    }

    public d.a.s0.u0.o2.k W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.t : (d.a.s0.u0.o2.k) invokeV.objValue;
    }

    public void W0() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (noNetworkView = this.x) == null || (bVar = this.w) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public d.a.s0.u0.o2.d X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.G : (d.a.s0.u0.o2.d) invokeV.objValue;
    }

    public void X0() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (frsMoveAreaBottomMenuView = this.g0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.d();
    }

    public final int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.B) {
                return false;
            }
            this.q.A(this.f66842a.getResources().getString(R.string.load_more_must_after_delete));
            this.q.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            d.a.s0.u0.o2.k kVar = this.t;
            if (kVar == null) {
                return false;
            }
            return kVar.i();
        }
        return invokeV.booleanValue;
    }

    public void Z0() {
        d.a.s0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.U && (cVar = this.H) != null) {
                cVar.b(true, false);
            }
            G1(0);
            N();
            M1(this.f66842a.h2());
            this.r.setVisibility(0);
            this.Y.setVisibility(0);
        }
    }

    public BdTypeRecyclerView a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.r : (BdTypeRecyclerView) invokeV.objValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.s.notifyDataSetChanged();
        }
    }

    public View b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            PbListView pbListView = this.q;
            if (pbListView == null) {
                return null;
            }
            return pbListView.b();
        }
        return (View) invokeV.objValue;
    }

    public void b1(int i2) {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048642, this, i2) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.n(i2);
    }

    public View c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            d.a.s0.e0.d dVar = this.f66850i;
            if (dVar != null) {
                return dVar.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void c1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048644, this, z) == null) || (appBarLayout = this.W) == null) {
            return;
        }
        appBarLayout.setExpanded(z);
    }

    public NavigationBar d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.y : (NavigationBar) invokeV.objValue;
    }

    public void d1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048646, this, i2, i3) == null) {
            this.N = i2;
            this.O = i3;
        }
    }

    public final int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            NavigationBar navigationBar = this.y;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void e1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.s.a(str);
        }
    }

    public ObservedChangeLinearLayout f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.R : (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public void f1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048650, this, i2) == null) || (view = this.f66845d) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public final int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (this.x == null || d.a.c.e.p.j.z()) {
                return 0;
            }
            return this.x.getHeight();
        }
        return invokeV.intValue;
    }

    public void g1(boolean z) {
        d.a.s0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048652, this, z) == null) || (cVar = this.H) == null) {
            return;
        }
        cVar.a(z);
    }

    public d.a.s0.n2.i h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.M : (d.a.s0.n2.i) invokeV.objValue;
    }

    public void h1(boolean z, boolean z2) {
        d.a.s0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048654, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.U && (cVar = this.H) != null) {
            cVar.b(z, z2);
        }
    }

    public TextView i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public void i1(r0 r0Var) {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048656, this, r0Var) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.o(r0Var);
    }

    public d.a.s0.u0.m1.e.c j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.H : (d.a.s0.u0.m1.e.c) invokeV.objValue;
    }

    public final void j1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            this.S = t0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.Y;
            if (frsHeaderViewContainer == null || (layoutParams = frsHeaderViewContainer.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            if (this.S) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + Y(), 0, 0);
            }
            this.Y.requestLayout();
        }
    }

    public RelativeLayout k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.f66843b : (RelativeLayout) invokeV.objValue;
    }

    public void k1(boolean z) {
        d.a.s0.u0.m1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.U = z;
            if (z || (cVar = this.H) == null) {
                return;
            }
            cVar.b(false, false);
        }
    }

    public View l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.P : (View) invokeV.objValue;
    }

    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.E = z;
        }
    }

    public final int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            View view = this.P;
            if (view == null) {
                return 0;
            }
            return view.getHeight();
        }
        return invokeV.intValue;
    }

    public void m1(int i2, boolean z) {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048664, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.q(i2, z);
    }

    public View n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.Q : (View) invokeV.objValue;
    }

    public void n1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
            this.B = z;
            if (z) {
                this.q.A(this.f66842a.getResources().getString(R.string.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.r;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.q.b()) {
                    this.q.O();
                    this.f66842a.loadMore();
                    return;
                }
                this.q.f();
                return;
            }
            this.q.A(this.f66842a.getResources().getString(R.string.load_more_must_after_delete));
            this.q.f();
        }
    }

    public ImageView o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.k : (ImageView) invokeV.objValue;
    }

    public void o1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048668, this, i2) == null) || (frsMoveAreaBottomMenuView = this.g0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setVisibility(i2);
    }

    public ImageView p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.j : (ImageView) invokeV.objValue;
    }

    public void p1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048670, this, i2) == null) || (frsMoveAreaBottomMenuView = this.g0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setMoveNumber(i2);
    }

    public void q0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || this.m == null || (frameLayout = this.n) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public void q1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048672, this, i2) == null) || (frsMultiDelBottomMenuView = this.f0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setSelectNumber(i2);
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            this.C = false;
            this.r.setNextPage(null);
        }
    }

    public void r1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048674, this, i2) == null) || (frsMultiDelBottomMenuView = this.f0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setVisibility(i2);
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048675, this, z) == null) || this.H == null) {
            return;
        }
        if (z) {
            h1(false, true);
        } else {
            h1(false, false);
        }
    }

    public void s1(e.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048676, this, cVar) == null) || (frsMultiDelBottomMenuView = this.f0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setDeleteCallback(cVar);
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            d.a.s0.u0.o2.h hVar = this.e0;
            return hVar != null && hVar.A();
        }
        return invokeV.booleanValue;
    }

    public void t1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i2) == null) {
            this.D = i2;
        }
    }

    public void u0(d.a.r0.r.q.d dVar) {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048679, this, dVar) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.d(dVar);
    }

    public void u1(d.a.c.k.e.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, wVar) == null) {
            this.s.d(wVar);
        }
    }

    public void v0() {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048681, this) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.k();
    }

    public void v1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, bVar) == null) {
            this.w = bVar;
            NoNetworkView noNetworkView = this.x;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void w0() {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.l();
    }

    public void w1(boolean z) {
        d.a.s0.u0.o2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048684, this, z) == null) || (kVar = this.t) == null) {
            return;
        }
        kVar.r(z);
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048685, this) == null) && this.J == null) {
            View D2 = this.f66842a.D2();
            this.J = (GifView) D2.findViewById(R.id.gif_real_time);
            TbImageView tbImageView = (TbImageView) D2.findViewById(R.id.tbimg_real_time);
            this.K = tbImageView;
            tbImageView.setPageId(this.f66842a.getUniqueId());
            this.J.setLayerType(1, null);
            this.K.setLayerType(1, null);
        }
    }

    public void x1(ArrayList<d.a.c.k.e.n> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048686, this, arrayList, frsViewData) == null) || frsViewData == null) {
            return;
        }
        ArrayList<d.a.c.k.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            s sVar = new s();
            ArrayList<d.a.c.k.e.n> arrayList2 = new ArrayList<>();
            arrayList2.add(sVar);
            FrsFragment frsFragment = this.f66842a;
            if (frsFragment != null && frsFragment.d0() != null && this.f66842a.d0().V() == 0) {
                sVar.c(this.f66842a.d0().R());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                d.a.c.k.e.n nVar = switchThreadDataToThreadCardInfo.get(i3);
                if (nVar instanceof a2) {
                    ((a2) nVar).w.Y3(i3);
                }
            }
        }
        this.s.g(switchThreadDataToThreadCardInfo, frsViewData);
        d.a.s0.n2.i iVar = this.M;
        if (iVar != null && (i2 = this.N) != 0) {
            iVar.n(i2, this.O, this.E, true);
        }
        FrsFragment frsFragment2 = this.f66842a;
        if (frsFragment2 != null) {
            frsFragment2.r3();
        }
    }

    public final void y0(d.a.s0.u0.m1.e.a aVar, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048687, this, aVar, z) == null) {
            this.T = aVar;
            View D2 = this.f66842a.D2();
            if (this.f66843b == null) {
                this.f66843b = (NoPressedRelativeLayout) D2.findViewById(R.id.frs);
            }
            if (this.f66845d == null) {
                this.f66845d = D2.findViewById(R.id.frs_content_container);
            }
            if (this.f66844c == null) {
                this.f66844c = (CoordinatorLayout) D2.findViewById(R.id.frs_nested_scroll_layout);
            }
            if (this.A == null) {
                this.A = D2.findViewById(R.id.frs_list_content);
            }
            if (this.Z == null) {
                this.Z = (CollapsingToolbarLayout) D2.findViewById(R.id.frs_collapse_layout);
            }
            if (this.Y == null) {
                this.Y = (FrsHeaderViewContainer) D2.findViewById(R.id.header_view_container);
            }
            if (this.t == null) {
                this.t = new d.a.s0.u0.o2.k(this.f66842a);
            }
            if (this.R == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) D2.findViewById(R.id.navigation_bar_wrapperLayout);
                this.R = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new g(this));
            }
            if (this.y == null) {
                NavigationBar navigationBar = (NavigationBar) D2.findViewById(R.id.view_navigation_bar);
                this.y = navigationBar;
                navigationBar.getBarBgView().setAlpha(1.0f);
                this.y.setContentPaddingTop(d.a.c.e.p.l.g(U(), R.dimen.tbds24));
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f66842a.Q2()) {
                this.y.setVisibility(8);
            }
            if (this.z == null) {
                this.z = D2.findViewById(R.id.frs_navi_line);
                d.a.s0.u0.m1.e.b c2 = aVar.c();
                if (c2 != null) {
                    c2.b(this.z);
                }
            }
            if (this.f66846e == null) {
                View addSystemImageButton = this.y.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.f66846e = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.v);
                this.f66847f = (ImageView) this.f66846e.findViewById(R.id.widget_navi_back_button);
            }
            if (this.k == null) {
                this.k = (ImageView) this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.k.setOnClickListener(this.v);
            }
            if (this.f66850i == null) {
                d.a.s0.e0.d dVar = new d.a.s0.e0.d(this.f66842a.getPageContext().getPageActivity());
                this.f66850i = dVar;
                this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, dVar.c(), (View.OnClickListener) null);
                this.f66848g = this.f66850i.b();
                MessageRedDotView a2 = this.f66850i.a();
                this.f66849h = a2;
                a2.setShadowEnabled(false);
                this.f66850i.c().setOnClickListener(this.v);
                this.f66850i.f(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
            }
            if (this.j == null) {
                this.j = (ImageView) this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.j.setOnClickListener(this.v);
            }
            if (this.l == null) {
                TextView textView = (TextView) this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
                this.l = textView;
                textView.setVisibility(8);
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
                int g2 = d.a.c.e.p.l.g(this.f66842a.getActivity(), R.dimen.tbds31);
                drawable.setBounds(0, 0, g2, g2);
                this.l.setCompoundDrawables(null, null, drawable, null);
                SkinManager.setBackgroundResourceSelector(this.l, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
            }
            if (z2) {
                this.y.onChangeSkinType(this.f66842a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.y.getBottomLine(), R.color.CAM_X0204);
            }
            if (this.r == null) {
                this.r = (BdTypeRecyclerView) D2.findViewById(R.id.frs_lv_thread);
            }
            h hVar = new h(this);
            hVar.setSupportsChangeAnimations(false);
            this.r.setItemAnimator(hVar);
            BdTypeRecyclerView bdTypeRecyclerView = this.r;
            bdTypeRecyclerView.setLayoutManager(new i(this, bdTypeRecyclerView.getContext()));
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                d.a.c.k.e.l lVar = new d.a.c.k.e.l(new d.a.c.k.e.j());
                this.n0 = lVar;
                lVar.q(this.r, 2);
            }
            this.r.setScrollable(this.f66842a);
            this.r.setFadingEdgeLength(0);
            this.r.setOverScrollMode(2);
            this.f66843b.setBottomOrderView(this.r);
            this.r.setOnTouchListener(this.f66842a.G1);
            this.r.setRecyclerListener(new j(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.r;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.r.getPaddingBottom());
            if (this.q == null) {
                PbListView pbListView = new PbListView(this.f66842a.getPageContext().getPageActivity());
                this.q = pbListView;
                pbListView.b();
            }
            this.q.o(R.color.transparent);
            this.q.r(d.a.c.e.p.l.g(this.f66842a.getActivity(), R.dimen.tbds182));
            this.q.v();
            this.q.E(R.dimen.tbfontsize33);
            this.q.C(SkinManager.getColor(R.color.CAM_X0109));
            this.q.y(R.color.CAM_X0110);
            this.r.setOnSrollToBottomListener(this.f66842a);
            this.y.setOnClickListener(new k(this));
            boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
            if (this.s == null) {
                this.s = aVar.b(this.f66842a, this.r, isShowBigImage);
            }
            d.a.s0.u0.o2.k kVar = this.t;
            if (kVar != null) {
                kVar.q(1, false);
            }
            if (!z) {
                if (this.x == null) {
                    this.x = new NoNetworkView(this.f66842a.getActivity());
                    this.x.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.R.addView(this.x);
                }
                if (d.a.c.e.p.j.A()) {
                    this.x.setVisibility(8);
                } else {
                    this.x.setVisibility(0);
                }
                this.x.c(this.f66842a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            x0();
            if (this.G == null) {
                d.a.s0.u0.o2.d a3 = aVar.a(this.f66842a, this.f66843b);
                this.G = a3;
                a3.x(this.f66842a.H2());
            }
            if (this.H == null) {
                this.H = aVar.d(this.f66842a, this.f66843b);
                g1(true);
            }
            if (this.P == null) {
                this.P = D2.findViewById(R.id.statebar_view);
            }
            if (this.Q == null) {
                this.Q = D2.findViewById(R.id.statebar_view_holder);
            }
            if (this.M == null) {
                this.M = new d.a.s0.n2.i(this.f66842a.getPageContext(), this.r);
            }
            this.M.p(1);
            this.M.t(this.f66842a.getUniqueId());
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) D2.findViewById(R.id.navigation_cover_tip);
            this.h0 = navigationBarCoverTip;
            if (this.I == null) {
                this.I = new d.a.s0.u0.o2.m(this.f66842a, navigationBarCoverTip);
            }
            if (this.W == null) {
                AppBarLayout appBarLayout = (AppBarLayout) D2.findViewById(R.id.frs_app_bar_layout);
                this.W = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.p0);
                this.a0 = true;
                this.b0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.W.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.X = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) D2.findViewById(R.id.frs_multi_delete_menu_view);
            this.f0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.f66842a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) D2.findViewById(R.id.frs_move_area_menu_view);
            this.g0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.f66842a.getPageContext());
            if (this.j0 == null) {
                this.j0 = this.y.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) this.f66842a.getResources().getDimension(R.dimen.ds20);
                layoutParams2.setMargins(0, dimension, dimension, dimension);
                this.j0.setLayoutParams(layoutParams2);
                this.j0.setPadding(0, 0, this.f66842a.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
                this.j0.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void y1(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048688, this, str) == null) && TextUtils.isEmpty(this.j0.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.j0.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.j0.setText(str2);
            d.a.r0.r.k.c().h(str);
        }
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.m != null && this.p.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void z1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || (navigationBar = this.y) == null || navigationBar.getBarBgView() == null || this.R == null) {
            return;
        }
        j1();
        if (this.S) {
            this.y.getBarBgView().setAlpha(0.0f);
            this.y.hideBottomLine();
        } else {
            View view = this.P;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.Q;
            if (view2 != null) {
                view2.setAlpha(1.0f);
            }
            TextView textView = this.j0;
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
            this.y.getBarBgView().setAlpha(1.0f);
            this.y.showBottomLine();
        }
        J0(this.d0);
    }
}
