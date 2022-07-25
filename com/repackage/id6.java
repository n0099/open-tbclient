package com.repackage;

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
import androidx.annotation.NonNull;
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
import com.baidu.tieba.frs.shrinkhead.LogicField;
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
import com.repackage.fr4;
import com.repackage.gf;
import com.repackage.kj5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class id6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar A;
    @NonNull
    public final rn6 B;
    public View C;
    public View D;
    public boolean E;
    public boolean F;
    public int G;
    public boolean H;
    public CommonTipView I;
    public wp6 J;
    public di6 K;
    public fq6 L;
    public GifView M;
    public TbImageView N;
    public HashSet<String> O;
    public i68 P;
    public int Q;
    public int R;
    public View S;
    public View T;
    public ObservedChangeLinearLayout U;
    public boolean V;
    public bi6 W;
    public boolean X;
    public aq8 Y;
    public AppBarLayout Z;
    public FrsFragment a;
    public AppBarLayoutStickyBehavior a0;
    public NoPressedRelativeLayout b;
    public FrsHeaderViewContainer b0;
    public CoordinatorLayout c;
    public CollapsingToolbarLayout c0;
    public View d;
    public boolean d0;
    public View e;
    public int e0;
    public ImageView f;
    public int f0;
    public ImageView g;
    public int g0;
    public MessageRedDotView h;
    public aq6 h0;
    public vz5 i;
    public FrsMultiDelBottomMenuView i0;
    public ImageView j;
    public FrsMoveAreaBottomMenuView j0;
    public ImageView k;
    public NavigationBarCoverTip k0;
    public TextView l;
    public TextView l0;
    public ViewStub m;
    public TextView m0;
    public FrameLayout n;
    public int n0;
    public TbImageView o;
    public int o0;
    public TbImageView p;
    public boolean p0;
    public ExposeTagViewCoordinatorLayout q;
    public ln q0;
    public FrsTabViewPager r;
    public gw8 r0;
    public PbListView s;
    public CustomMessageListener s0;
    public BdTypeRecyclerView t;
    public AppBarLayout.OnOffsetChangedListener t0;
    public ai6 u;
    public Runnable u0;
    public dq6 v;
    public boolean v0;
    public fr4 w;
    public View.OnClickListener x;
    public NoNetworkView.b y;
    public NoNetworkView z;

    /* loaded from: classes6.dex */
    public class a implements fr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public a(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // com.repackage.fr4.c
        public void a(fr4 fr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fr4Var, i, view2) == null) {
                fr4Var.e();
                if (i == 0) {
                    this.a.a.d5();
                } else if (i != 1 || this.a.a.getPageContext() == null) {
                } else {
                    SelectImageHelper.getAlbumImage(this.a.a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public b(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.m == null) {
                return;
            }
            this.a.n.setVisibility(0);
            this.a.p.setVisibility(0);
            this.a.o.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ef {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public c(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // com.repackage.ef
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ef
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ef
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0849, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920bb)).setText(R.string.obfuscated_res_0x7f0f0754);
                this.a.a.getPageContext().getLayoutMode().j(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.repackage.ef
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? pi.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070230) : invokeV.intValue;
        }

        @Override // com.repackage.ef
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? -pi.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f0702e6) : invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements gf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.gf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yt4.k().x("frs_video_activity_guide", 1L);
            }
        }

        @Override // com.repackage.gf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff a;

        public e(id6 id6Var, ff ffVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var, ffVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ffVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ff ffVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ffVar = this.a) == null) {
                return;
            }
            ffVar.d();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public f(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.X().notifyDataSetChanged();
                if (this.a.p0) {
                    return;
                }
                this.a.P.n(this.a.Q, this.a.R, this.a.H, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(id6 id6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var, Integer.valueOf(i)};
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
            this.a = id6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.q0 == null) {
                        this.a.q0 = new ln(new jn());
                    }
                    this.a.q0.q(this.a.t, 2);
                } else if (this.a.q0 != null) {
                    this.a.q0.w();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public h(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                this.a.N(appBarLayout, i);
                if (this.a.v != null && this.a.q.hasTargetView()) {
                    this.a.v.s(i == 0 && !this.a.q.canDrag());
                }
                if (this.a.f0 != i && Math.abs(i) >= 0 && this.a.U() != -1) {
                    if (Math.abs(i) >= this.a.U()) {
                        if (this.a.d0) {
                            this.a.d0 = false;
                            id6 id6Var = this.a;
                            id6Var.N0(id6Var.d0);
                        }
                    } else if (!this.a.d0) {
                        this.a.d0 = true;
                        id6 id6Var2 = this.a;
                        id6Var2.N0(id6Var2.d0);
                    }
                    int a0 = this.a.a0() + this.a.i0() + this.a.k0();
                    int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
                    int totalScrollRange2 = (appBarLayout.getTotalScrollRange() - a0) + this.a.B.g();
                    int g = totalScrollRange + this.a.B.g();
                    if (totalScrollRange2 <= 0) {
                        return;
                    }
                    float abs = Math.abs(i * 1.0f) / totalScrollRange2;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && this.a.f0 - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        this.a.U1(Math.abs(a0 - g));
                        if (this.a.T != null) {
                            this.a.T.setVisibility(0);
                        }
                    } else if (this.a.T != null) {
                        if (this.a.q0() != UtilHelper.getStatusBarHeight()) {
                            this.a.U1(0);
                        }
                        this.a.T.setVisibility(8);
                    }
                    if (this.a.A != null) {
                        if (this.a.V) {
                            this.a.A.getBarBgView().setAlpha(abs);
                            this.a.X1(false);
                            this.a.B.c(abs);
                        } else if (this.a.m0 != null) {
                            this.a.m0.setAlpha(abs);
                        }
                    }
                    this.a.f0 = i;
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i));
                    CustomMessage customMessage = new CustomMessage(2921397);
                    if (this.a.a != null && this.a.a.D3() != null && this.a.a.D3().C() != null && (this.a.a.D3().C().b instanceof BaseFragment)) {
                        customMessage.setTag(((BaseFragment) this.a.a.D3().C().b).getUniqueId());
                        customResponsedMessage.setOrginalMessage(customMessage);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.a.v == null || this.a.v.k() <= 0 || Math.abs(i) < this.a.v.k()) {
                    return;
                }
                this.a.v.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements dg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public i(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // com.repackage.dg5
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || i2 == i4 || i4 <= 0) {
                return;
            }
            this.a.c0.setMinimumHeight(i2);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ id6 b;

        public j(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = id6Var;
            this.a = 0;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                super.onRemoveFinished(viewHolder);
                int i = this.a - 1;
                this.a = i;
                if (i == 0) {
                    this.b.t.getAdapter().notifyDataSetChanged();
                }
            }
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                this.a++;
                super.onRemoveStarting(viewHolder);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(id6 id6Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes6.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public l(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.a.P != null) {
                    this.a.P.k(view2);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.obfuscated_res_0x7f090029);
                if (playVoiceBnt != null) {
                    playVoiceBnt.k();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.obfuscated_res_0x7f090027);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
                if (this.a.r0 != null) {
                    this.a.r0.f(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public m(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.J3();
                if (this.a.a == null || this.a.Z == null) {
                    return;
                }
                this.a.a.p4();
                this.a.Z.setExpanded(true);
                if (this.a.P != null) {
                    this.a.P.n(this.a.Q, this.a.R, false, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public n(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener
        public void onNestedScrollAccepted(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.v != null && this.a.q.hasTargetView()) {
                this.a.v.s(this.a.f0 == 0 && !this.a.q.canDrag());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;

        public o(id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id6Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.v != null && this.a.q.hasTargetView()) {
                this.a.v.s(false);
                this.a.q.clearTargetView();
            }
        }
    }

    public id6(FrsFragment frsFragment, View.OnClickListener onClickListener, bi6 bi6Var, boolean z, aq6 aq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onClickListener, bi6Var, Boolean.valueOf(z), aq6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = qn6.a();
        this.E = true;
        this.F = true;
        this.G = 0;
        this.H = false;
        this.Q = 0;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.V = false;
        this.X = true;
        this.d0 = true;
        this.e0 = -1;
        this.f0 = -1;
        this.n0 = 0;
        this.o0 = 0;
        this.p0 = false;
        this.s0 = new g(this, 2156674);
        this.t0 = new h(this);
        this.u0 = new b(this);
        this.a = frsFragment;
        this.x = onClickListener;
        MessageManager.getInstance().registerListener(this.s0);
        C0(bi6Var, z);
        this.O = new HashSet<>();
        this.G = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.g0 = TbadkCoreApplication.getInst().getSkinType();
        this.h0 = aq6Var;
    }

    @NonNull
    public static String c0(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                return fixedBarText + "吧";
            }
            return UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
        }
        return (String) invokeL.objValue;
    }

    public void A0() {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.o();
    }

    public void A1(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xnVar) == null) {
            this.u.d(xnVar);
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.M == null) {
            View C3 = this.a.C3();
            this.M = (GifView) C3.findViewById(R.id.obfuscated_res_0x7f090c45);
            TbImageView tbImageView = (TbImageView) C3.findViewById(R.id.obfuscated_res_0x7f091f99);
            this.N = tbImageView;
            tbImageView.setPageId(this.a.getUniqueId());
            this.M.setLayerType(1, null);
            this.N.setLayerType(1, null);
        }
    }

    public void B1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.y = bVar;
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public final void C0(bi6 bi6Var, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bi6Var, z) == null) {
            this.W = bi6Var;
            View C3 = this.a.C3();
            if (this.b == null) {
                this.b = (NoPressedRelativeLayout) C3.findViewById(R.id.obfuscated_res_0x7f090a89);
            }
            if (this.d == null) {
                this.d = C3.findViewById(R.id.obfuscated_res_0x7f090aba);
            }
            if (this.c == null) {
                this.c = (CoordinatorLayout) C3.findViewById(R.id.obfuscated_res_0x7f090b6f);
            }
            if (this.D == null) {
                this.D = C3.findViewById(R.id.obfuscated_res_0x7f090b49);
            }
            if (this.c0 == null) {
                this.c0 = (CollapsingToolbarLayout) C3.findViewById(R.id.obfuscated_res_0x7f090ab8);
            }
            if (this.b0 == null) {
                this.b0 = (FrsHeaderViewContainer) C3.findViewById(R.id.obfuscated_res_0x7f090cf7);
            }
            if (this.v == null) {
                this.v = new dq6(this.a);
            }
            if (this.U == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) C3.findViewById(R.id.obfuscated_res_0x7f091571);
                this.U = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new i(this));
            }
            this.B.h(this.a, C3, this.x);
            if (this.A == null) {
                this.A = this.B.e();
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.a.R3()) {
                this.A.setVisibility(8);
            }
            if (this.C == null) {
                this.C = C3.findViewById(R.id.obfuscated_res_0x7f090b6e);
                ci6 c2 = bi6Var.c();
                if (c2 != null) {
                    c2.b(this.C);
                }
            }
            if (this.e == null) {
                this.e = (View) this.B.a(LogicField.BACK_BTN);
                this.f = (ImageView) this.B.a(LogicField.BACK_IV);
            }
            if (this.k == null) {
                this.k = (ImageView) this.B.a(LogicField.SEARCH_BTN);
            }
            if (this.i == null) {
                this.i = (vz5) this.B.a(LogicField.MESSAGE_ICON_CONTROLLER);
                this.g = (ImageView) this.B.a(LogicField.MESSAGE_BTN);
                this.h = (MessageRedDotView) this.B.a(LogicField.MESSAGE_RED_DOT);
            }
            if (this.j == null) {
                this.j = (ImageView) this.B.a(LogicField.SHARE_BTN);
            }
            if (this.l == null) {
                TextView textView = (TextView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d033c, (View.OnClickListener) null);
                this.l = textView;
                textView.setVisibility(8);
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
                int f2 = pi.f(this.a.getActivity(), R.dimen.tbds31);
                drawable.setBounds(0, 0, f2, f2);
                this.l.setCompoundDrawables(null, null, drawable, null);
                SkinManager.setBackgroundResourceSelector(this.l, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            }
            if (z2) {
                this.A.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.A.getBottomLine(), R.color.CAM_X0204);
            }
            if (this.t == null) {
                this.t = (BdTypeRecyclerView) C3.findViewById(R.id.obfuscated_res_0x7f090b53);
            }
            j jVar = new j(this);
            jVar.setSupportsChangeAnimations(false);
            this.t.setItemAnimator(jVar);
            BdTypeRecyclerView bdTypeRecyclerView = this.t;
            bdTypeRecyclerView.setLayoutManager(new k(this, bdTypeRecyclerView.getContext()));
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                ln lnVar = new ln(new jn());
                this.q0 = lnVar;
                lnVar.q(this.t, 2);
            }
            this.t.setScrollable(this.a);
            this.t.setFadingEdgeLength(0);
            this.t.setOverScrollMode(2);
            this.b.setBottomOrderView(this.t);
            this.t.setOnTouchListener(this.a.L1);
            this.t.setRecyclerListener(new l(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.t;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.t.getPaddingBottom());
            if (this.s == null) {
                PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
                this.s = pbListView;
                pbListView.b();
            }
            this.s.p(R.color.transparent);
            this.s.t(pi.f(this.a.getActivity(), R.dimen.tbds182));
            this.s.x();
            this.s.G(R.dimen.tbfontsize33);
            this.s.E(SkinManager.getColor(R.color.CAM_X0109));
            this.s.A(R.color.CAM_X0110);
            this.t.setOnSrollToBottomListener(this.a);
            this.A.setOnClickListener(new m(this));
            boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
            if (this.u == null) {
                this.u = bi6Var.b(this.a, this.t, isShowBigImage);
            }
            dq6 dq6Var = this.v;
            if (dq6Var != null) {
                dq6Var.t(1, false);
            }
            if (!z) {
                if (this.z == null) {
                    this.z = new NoNetworkView(this.a.getActivity());
                    this.z.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.U.addView(this.z);
                }
                if (ni.A()) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setVisibility(0);
                }
                this.z.d(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            B0();
            if (this.J == null) {
                wp6 a2 = bi6Var.a(this.a, this.b);
                this.J = a2;
                a2.x(this.a.G3());
            }
            if (this.K == null) {
                this.K = bi6Var.d(this.a, this.b);
                l1(true);
            }
            if (this.S == null) {
                this.S = C3.findViewById(R.id.obfuscated_res_0x7f091e38);
            }
            if (this.T == null) {
                this.T = C3.findViewById(R.id.obfuscated_res_0x7f091e39);
            }
            if (this.P == null) {
                this.P = new i68(this.a.getPageContext(), this.t);
            }
            this.P.p(2);
            this.P.u(this.a.getUniqueId());
            if (this.r0 == null) {
                this.r0 = new gw8(this.a.getPageContext(), this.t);
            }
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) C3.findViewById(R.id.obfuscated_res_0x7f091573);
            this.k0 = navigationBarCoverTip;
            if (this.L == null) {
                this.L = new fq6(this.a, navigationBarCoverTip);
            }
            if (this.Z == null) {
                AppBarLayout appBarLayout = (AppBarLayout) C3.findViewById(R.id.obfuscated_res_0x7f090a9c);
                this.Z = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.t0);
                this.d0 = true;
                this.e0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Z.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.a0 = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) C3.findViewById(R.id.obfuscated_res_0x7f090b67);
            this.i0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) C3.findViewById(R.id.obfuscated_res_0x7f090b64);
            this.j0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.a.getPageContext());
            if (this.m0 == null) {
                this.m0 = (TextView) this.B.a(LogicField.FOLD_TITLE);
            }
            ExposeTagViewCoordinatorLayout exposeTagViewCoordinatorLayout = (ExposeTagViewCoordinatorLayout) C3.findViewById(R.id.obfuscated_res_0x7f090b6f);
            this.q = exposeTagViewCoordinatorLayout;
            exposeTagViewCoordinatorLayout.setListener(new n(this));
            FrsTabViewPager frsTabViewPager = (FrsTabViewPager) C3.findViewById(R.id.obfuscated_res_0x7f090bc9);
            this.r = frsTabViewPager;
            frsTabViewPager.addOnPageChangeListener(new o(this));
        }
    }

    public void C1(boolean z) {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.u(z);
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m != null && this.p.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void D1(ArrayList<nn> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, arrayList, frsViewData) == null) || frsViewData == null) {
            return;
        }
        ArrayList<nn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            kd6 kd6Var = new kd6();
            ArrayList<nn> arrayList2 = new ArrayList<>();
            arrayList2.add(kd6Var);
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.L0() != null && this.a.L0().Z() == 0) {
                kd6Var.b(this.a.L0().V());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                nn nnVar = switchThreadDataToThreadCardInfo.get(i3);
                if (nnVar instanceof rq4) {
                    ((rq4) nnVar).s.setSmartFrsPosition(i3);
                }
            }
        }
        this.u.g(switchThreadDataToThreadCardInfo, frsViewData);
        i68 i68Var = this.P;
        if (i68Var != null && (i2 = this.Q) != 0) {
            i68Var.n(i2, this.R, this.H, true);
        }
        FrsFragment frsFragment2 = this.a;
        if (frsFragment2 != null) {
            frsFragment2.A4();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.i0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setFrsViewData(frsViewData);
        }
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.s.b().getParent() != null && this.F : invokeV.booleanValue;
    }

    public void E1(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (textView = this.m0) != null && TextUtils.isEmpty(textView.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.m0.setText("");
                return;
            }
            this.m0.setText(c0(str));
            an4.c().h(str);
        }
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.j0;
            return frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.b();
        }
        return invokeV.booleanValue;
    }

    public void F1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || this.U == null) {
            return;
        }
        o1();
        if (this.V) {
            this.A.getBarBgView().setAlpha(0.0f);
            this.A.hideBottomLine();
        } else {
            View view2 = this.S;
            if (view2 != null) {
                view2.setAlpha(1.0f);
            }
            View view3 = this.T;
            if (view3 != null) {
                view3.setAlpha(1.0f);
            }
            TextView textView = this.m0;
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
            this.A.getBarBgView().setAlpha(1.0f);
            this.A.showBottomLine();
        }
        O0(this.g0);
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            dq6 dq6Var = this.v;
            if (dq6Var != null) {
                return dq6Var.j() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void G1() {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.v();
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            wp6 wp6Var = this.J;
            if (wp6Var == null) {
                return false;
            }
            return wp6Var.p();
        }
        return invokeV.booleanValue;
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.F = true;
            this.t.setNextPage(this.s);
            this.s.B(this.x);
            int i2 = this.G;
            if (i2 > 0) {
                this.s.L(i2);
            }
            this.s.f();
            this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ce));
        }
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ai6 ai6Var = this.u;
            if (ai6Var instanceof mh6) {
                ((mh6) ai6Var).r();
            }
        }
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.m == null) {
            return;
        }
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.u0, 5000L);
    }

    public void J0() {
        ai6 ai6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (ai6Var = this.u) == null) {
            return;
        }
        ai6Var.notifyDataSetChanged();
    }

    public void J1(zq4 zq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, zq4Var) == null) {
            if (this.m == null) {
                View C3 = this.a.C3();
                ViewStub viewStub = (ViewStub) C3.findViewById(R.id.obfuscated_res_0x7f09255a);
                this.m = viewStub;
                viewStub.setVisibility(0);
                this.n = (FrameLayout) C3.findViewById(R.id.obfuscated_res_0x7f090c02);
                this.o = (TbImageView) C3.findViewById(R.id.obfuscated_res_0x7f090c01);
                this.p = (TbImageView) C3.findViewById(R.id.obfuscated_res_0x7f090c03);
                this.o.setPageId(this.a.getUniqueId());
                this.p.setPageId(this.a.getUniqueId());
                this.o.setDefaultBgResource(R.color.common_color_10022);
                this.o.setDefaultResource(0);
                this.p.setDefaultBgResource(R.color.common_color_10022);
                this.p.setDefaultResource(0);
                this.n.setOnClickListener(this.x);
            }
            this.n.setVisibility(0);
            String a2 = zq4Var.a();
            String b2 = zq4Var.b();
            this.o.J(a2, 10, false);
            this.p.J(b2, 10, false);
            TbadkCoreApplication.getInst().handler.postDelayed(this.u0, 5000L);
        }
    }

    public void K(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onScrollListener) == null) {
            this.t.addOnScrollListener(onScrollListener);
        }
    }

    public void K0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.p0 = z;
            if (this.P == null) {
                return;
            }
            FrsFragment frsFragment = this.a;
            boolean z2 = (frsFragment == null || frsFragment.D3() == null || this.a.D3().C() == null) ? true : this.a.D3().C().b instanceof FrsAllThreadFragment;
            if (!z && z2) {
                this.P.r(true);
                this.P.n(this.Q, this.R, this.H, true);
                return;
            }
            this.P.r(false);
            this.P.y();
        }
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.t.setVisibility(0);
        }
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || this.a == null) {
            return;
        }
        M(i2);
    }

    public void L0() {
        gw8 gw8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (gw8Var = this.r0) == null) {
            return;
        }
        gw8Var.c();
    }

    public void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.F = true;
            this.t.setNextPage(this.s);
            int i2 = this.G;
            if (i2 > 0) {
                this.s.L(i2);
            }
            this.s.B(null);
            this.s.Q();
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                if (this.A.getBackground() != null && this.A.getBackground().mutate() != null) {
                    this.A.getBackground().mutate().setAlpha(0);
                }
                SkinManager.setBackgroundColor(this.A.getBarBgView(), R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.A.getBottomLine(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.C, R.color.CAM_X0204, i2);
                vz5 vz5Var = this.i;
                if (vz5Var != null) {
                    vz5Var.d(i2);
                }
                if (this.k != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f08060e, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (this.j != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f08060f, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            SkinManager.setBackgroundColor(this.S, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.T, R.color.CAM_X0207);
            X1(true);
        }
    }

    public void M0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
            gw8 gw8Var = this.r0;
            if (gw8Var != null) {
                gw8Var.d();
            }
            i68 i68Var = this.P;
            if (i68Var == null) {
                return;
            }
            i68Var.m(i2, i3, this.H, 1);
            this.P.p(2);
            this.P.q(false);
        }
    }

    public final void M1(int i2) {
        vz5 vz5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || (vz5Var = this.i) == null) {
            return;
        }
        vz5Var.g(i2);
    }

    public final void N(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, appBarLayout, i2) == null) || (frsFragment = this.a) == null || appBarLayout == null || frsFragment.D3() == null || this.a.getPageContext() == null) {
            return;
        }
        int a0 = a0() + i0() + k0();
        int totalScrollRange = (appBarLayout.getTotalScrollRange() - Math.abs(i2)) + this.B.g();
        FrsTabViewController D3 = this.a.D3();
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        FrsFragment frsFragment2 = this.a;
        boolean z = frsFragment2 != null && frsFragment2.a4();
        if (totalScrollRange <= 0) {
            if (this.o0 != 2) {
                D3.f(2);
            }
            this.o0 = 2;
            marginLayoutParams.topMargin = 0;
        } else if (totalScrollRange > 0 && totalScrollRange < a0) {
            if (this.o0 != 1) {
                D3.f(1);
            }
            this.o0 = 1;
            marginLayoutParams.topMargin = 0;
        } else {
            if (this.o0 != 0) {
                D3.f(0);
            }
            this.o0 = 0;
            if (z) {
                marginLayoutParams.topMargin = pi.f(this.a.getActivity(), R.dimen.tbds_30);
            } else {
                marginLayoutParams.topMargin = 0;
            }
        }
        if (z) {
            this.d.setLayoutParams(marginLayoutParams);
        }
    }

    public final void N0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || !z || (frsFragment = this.a) == null || frsFragment.p0() == null) {
            return;
        }
        this.a.p0().X();
    }

    public void N1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048607, this, str, i2) == null) {
            if (this.l0 == null) {
                TextView textView = new TextView(this.a.getActivity());
                this.l0 = textView;
                textView.setGravity(19);
                this.l0.setPadding(pi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, pi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                this.l0.setLayoutParams(new ViewGroup.LayoutParams(-1, pi.f(this.a.getActivity(), R.dimen.tbds112)));
                this.l0.setTextSize(0, pi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07032e));
                this.l0.setMaxLines(2);
                this.l0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.l0.setTextColor(ContextCompat.getColor(this.a.getActivity(), R.color.CAM_X0101));
            }
            this.k0.setBackgroundColor(i2);
            this.l0.setText(str);
            this.k0.m(this.a.getActivity(), this.l0, 5000);
        }
    }

    public void O(String str) {
        fq6 fq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || (fq6Var = this.L) == null) {
            return;
        }
        fq6Var.a(str);
    }

    public void O0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.g0 = i2;
            this.B.onChangeSkinType(i2);
            bj5 bj5Var = new bj5(this.a, 4);
            bj5Var.D(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bj5Var));
            aj5 aj5Var = new aj5(this.a.getPageContext(), 4);
            aj5Var.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aj5Var));
            TbImageView tbImageView = this.N;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            ai6 ai6Var = this.u;
            if (ai6Var != null) {
                ai6Var.b();
                this.u.notifyDataSetChanged();
            }
            ha5.a(this.a.getPageContext(), this.b);
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), i2);
            }
            PbListView pbListView = this.s;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.s.d(i2);
            }
            TextView textView = this.m0;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            L(i2);
            di6 di6Var = this.K;
            if (di6Var != null) {
                di6Var.onChangeSkinType(i2);
            }
            wp6 wp6Var = this.J;
            if (wp6Var != null) {
                wp6Var.u(i2);
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.i0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.d();
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.j0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.c();
            }
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0202);
        }
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.F = false;
            this.t.setNextPage(this.s);
            int i2 = this.G;
            if (i2 > 0) {
                this.s.L(i2);
            }
            this.s.B(null);
            this.s.f();
            this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09cf));
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.v.h();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.s0);
            i68 i68Var = this.P;
            if (i68Var != null) {
                i68Var.h();
            }
            fq6 fq6Var = this.L;
            if (fq6Var != null) {
                fq6Var.c();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.i0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.setPageContext(null);
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.j0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.setPageContext(null);
            }
            this.u.m();
            this.t.setOnSrollToBottomListener(null);
            this.t.setScrollable(null);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.u0);
            CommonTipView commonTipView = this.I;
            if (commonTipView != null) {
                commonTipView.i();
            }
            this.O.clear();
            wp6 wp6Var = this.J;
            if (wp6Var != null) {
                wp6Var.r();
            }
            aq8 aq8Var = this.Y;
            if (aq8Var != null) {
                aq8Var.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.k0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.i0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.e();
            }
            dq6 dq6Var = this.v;
            if (dq6Var != null) {
                dq6Var.p();
            }
        }
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            R();
            fr4 fr4Var = this.w;
            if (fr4Var != null) {
                fr4Var.m();
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.j;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.Z != null && (appBarLayoutStickyBehavior = this.a0) != null && appBarLayoutStickyBehavior.isSticky()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                this.a0.expandedAppBarLayout(this.Z);
                return true;
            }
            wp6 wp6Var = this.J;
            return wp6Var != null && wp6Var.v();
        }
        return invokeV.booleanValue;
    }

    public void Q1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                qz4.c(this.a.o(), postWriteCallBackData, 1);
                return;
            }
            if (this.Y == null) {
                this.Y = new aq8(this.a.getActivity(), this.b);
            }
            this.Y.g(postWriteCallBackData);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && this.w == null && this.a.getPageContext() != null) {
            String[] strArr = {this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f132b), this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f024c)};
            fr4 fr4Var = new fr4(this.a.getPageContext().getPageActivity());
            this.w = fr4Var;
            fr4Var.l(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0cdd));
            this.w.j(strArr, new a(this));
            this.w.c(this.a.getPageContext());
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            wp6 wp6Var = this.J;
            if (wp6Var != null) {
                wp6Var.s();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void R1() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || yt4.k().m("frs_video_activity_guide", 0L) != 0 || this.v0 || this.a.getActivity() == null || this.a.getPageContext() == null) {
            return;
        }
        View view2 = null;
        BdTypeRecyclerView bdTypeRecyclerView = this.t;
        if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.t.getChildCount()) {
            view2 = this.t.getChildAt(headerViewsCount);
        }
        if (view2 != null) {
            gf gfVar = new gf();
            gfVar.j(view2);
            gfVar.c(0);
            gfVar.i(true);
            gfVar.h(false);
            gfVar.d(true);
            gfVar.a(new c(this));
            gfVar.g(new d(this));
            ff b2 = gfVar.b();
            b2.k(false);
            b2.m(this.a.getActivity());
            qg.a().postDelayed(new e(this, b2), 4000L);
            this.v0 = true;
        }
    }

    public void S() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.a();
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
        }
    }

    public void S1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048622, this, z) == null) || this.J == null) {
            return;
        }
        if (d45.h().k()) {
            this.J.A(false);
        } else {
            this.J.A(z);
        }
    }

    public void T() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.b();
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            L(TbadkCoreApplication.getInst().getSkinType());
            wp6 wp6Var = this.J;
            if (wp6Var != null) {
                wp6Var.t();
            }
        }
    }

    public void T1() {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.w();
    }

    public final int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            AppBarLayout appBarLayout = this.Z;
            if (appBarLayout == null) {
                return this.e0;
            }
            int i2 = this.e0;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.Z.getChildAt(childCount);
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
            int max = Math.max(0, this.Z.getTotalScrollRange() - Math.abs(i3));
            this.e0 = max;
            return max;
        }
        return invokeV.intValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || X() == null) {
            return;
        }
        List<nn> f2 = X().f();
        if (ListUtils.isEmpty(f2)) {
            return;
        }
        for (nn nnVar : f2) {
            if (nnVar instanceof rq4) {
                rq4 rq4Var = (rq4) nnVar;
                if (rq4Var.t != 0 && rq4Var.s != null && this.a.L0() != null && this.a.L0().h0() != null) {
                    int[] imageWidthAndHeight = rq4Var.s.getImageWidthAndHeight();
                    rq4Var.t = imageWidthAndHeight[0];
                    rq4Var.u = imageWidthAndHeight[1];
                }
            }
        }
        qg.a().postDelayed(new f(this), 500L);
    }

    public final void U1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            View p0 = p0();
            View r0 = r0();
            if (!UtilHelper.canUseStyleImmersiveSticky() || p0 == null || r0 == null || p0.getLayoutParams() == null || r0.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = p0.getLayoutParams();
            int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
            layoutParams.height = statusBarHeight;
            if (statusBarHeight < 0) {
                layoutParams.height = 0;
            }
            p0.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = r0.getLayoutParams();
            layoutParams2.height = i2;
            if (i2 > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            r0.setLayoutParams(layoutParams2);
        }
    }

    public View V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void V0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048630, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && yt4.k().h("frs_login_tip", true)) {
                if (this.I == null) {
                    this.I = new CommonTipView(this.a.getActivity());
                }
                this.I.setText(R.string.obfuscated_res_0x7f0f0711);
                this.I.j((FrameLayout) W(), TbadkCoreApplication.getInst().getSkinType());
                yt4.k().u("frs_login_tip", false);
            }
        }
    }

    public void V1() {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.x();
    }

    public View W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.D : (View) invokeV.objValue;
    }

    public void W0() {
        di6 di6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.X && (di6Var = this.K) != null) {
                di6Var.b(false, false);
            }
            M1(8);
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.j;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            S1(false);
            this.t.setVisibility(8);
            this.b0.setVisibility(8);
        }
    }

    public final void W1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (navigationBar = this.A) == null) {
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
        TextView textView = this.m0;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setAlpha(f2);
            }
            ImageView imageView2 = this.g;
            if (imageView2 != null) {
                imageView2.setAlpha(f2);
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.D3() != null && this.n0 == 1) {
                this.a.D3().h0(f2);
            }
            MessageRedDotView messageRedDotView = this.h;
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
        View view2 = this.S;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
        View view3 = this.T;
        if (view3 != null) {
            view3.setAlpha(alpha);
        }
        View view4 = this.C;
        if (view4 != null) {
            view4.setAlpha(alpha);
        }
    }

    public ai6 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.u : (ai6) invokeV.objValue;
    }

    public void X0() {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.w();
    }

    public final void X1(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048637, this, z) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || !this.V) {
            return;
        }
        if (this.A.getBarBgView().getAlpha() < 0.5f) {
            if (z || this.n0 != 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08060d, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f08060e, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                ImageView imageView = this.g;
                if (imageView != null) {
                    imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d9, SkinManager.getColor(R.color.CAM_X0101), null));
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f08060f, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.n0 = 0;
            }
        } else if (z || this.n0 != 1) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08060d, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f08060e, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ImageView imageView2 = this.g;
            if (imageView2 != null) {
                imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d9, SkinManager.getColor(R.color.CAM_X0106), null));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f08060f, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.n0 = 1;
        }
        W1();
    }

    public dq6 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.v : (dq6) invokeV.objValue;
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            C0(this.W, this.a.R3());
            ai6 ai6Var = this.u;
            if (ai6Var != null) {
                ai6Var.e();
            }
        }
    }

    public wp6 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.J : (wp6) invokeV.objValue;
    }

    public void Z0(vo4 vo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, vo4Var) == null) {
            aj5 aj5Var = new aj5(this.a.getPageContext(), 1);
            aj5Var.j(this.t);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.a.c());
            hashMap.put("forum_id", this.a.d());
            aj5Var.k(hashMap);
            aj5Var.i(vo4Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aj5Var));
        }
    }

    public final int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void a1(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            vz5 vz5Var = this.i;
            if (vz5Var != null) {
                vz5Var.e(z, i2);
            }
            this.B.d(i2, z);
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            dq6 dq6Var = this.v;
            if (dq6Var == null) {
                return false;
            }
            return dq6Var.l();
        }
        return invokeV.booleanValue;
    }

    public void b1() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (noNetworkView = this.z) == null || (bVar = this.y) == null) {
            return;
        }
        noNetworkView.e(bVar);
    }

    public void c1() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (frsMoveAreaBottomMenuView = this.j0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.d();
    }

    public BdTypeRecyclerView d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.t : (BdTypeRecyclerView) invokeV.objValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (this.E) {
                return false;
            }
            this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a16));
            this.s.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public View e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            PbListView pbListView = this.s;
            if (pbListView == null) {
                return null;
            }
            return pbListView.b();
        }
        return (View) invokeV.objValue;
    }

    public void e1() {
        di6 di6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            if (this.X && (di6Var = this.K) != null) {
                di6Var.b(true, false);
            }
            M1(0);
            Q();
            S1(this.a.Z2());
            this.t.setVisibility(0);
            this.b0.setVisibility(0);
        }
    }

    public View f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            vz5 vz5Var = this.i;
            if (vz5Var != null) {
                return vz5Var.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            this.u.notifyDataSetChanged();
        }
    }

    @NonNull
    public rn6 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.B : (rn6) invokeV.objValue;
    }

    public void g1(int i2) {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048654, this, i2) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.q(i2);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null) {
                return null;
            }
            return frsFragment.o().getPageActivity();
        }
        return (Context) invokeV.objValue;
    }

    public NavigationBar h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.A : (NavigationBar) invokeV.objValue;
    }

    public void h1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048657, this, z) == null) || (appBarLayout = this.Z) == null) {
            return;
        }
        appBarLayout.setExpanded(z);
    }

    public final int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void i1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048659, this, i2, i3) == null) {
            this.Q = i2;
            this.R = i3;
        }
    }

    public ObservedChangeLinearLayout j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.U : (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public void j1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.u.a(str);
        }
    }

    public final int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.z == null || ni.z()) {
                return 0;
            }
            return this.z.getHeight();
        }
        return invokeV.intValue;
    }

    public void k1(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048663, this, i2) == null) || (view2 = this.d) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    public i68 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.P : (i68) invokeV.objValue;
    }

    public void l1(boolean z) {
        di6 di6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048665, this, z) == null) || (di6Var = this.K) == null) {
            return;
        }
        di6Var.a(z);
    }

    public TextView m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public void m1(boolean z, boolean z2) {
        di6 di6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048667, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.X && (di6Var = this.K) != null) {
            di6Var.b(z, z2);
        }
    }

    public di6 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.K : (di6) invokeV.objValue;
    }

    public void n1(ke6 ke6Var) {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, ke6Var) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.r(ke6Var);
    }

    public RelativeLayout o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.b : (RelativeLayout) invokeV.objValue;
    }

    public final void o1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            this.V = x0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.b0;
            if (frsHeaderViewContainer == null || (layoutParams = frsHeaderViewContainer.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            if (this.V) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070306) + a0(), 0, 0);
            }
            this.b0.requestLayout();
        }
    }

    public View p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.S : (View) invokeV.objValue;
    }

    public void p1(boolean z) {
        di6 di6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            this.X = z;
            if (z || (di6Var = this.K) == null) {
                return;
            }
            di6Var.b(false, false);
        }
    }

    public final int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            View view2 = this.S;
            if (view2 == null) {
                return 0;
            }
            return view2.getHeight();
        }
        return invokeV.intValue;
    }

    public void q1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            this.H = z;
        }
    }

    public View r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.T : (View) invokeV.objValue;
    }

    public void r1(int i2, boolean z) {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.t(i2, z);
    }

    public ImageView s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.k : (ImageView) invokeV.objValue;
    }

    public void s1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.E = z;
            if (z) {
                this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a15));
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.s.b()) {
                    this.s.Q();
                    this.a.b();
                    return;
                }
                this.s.f();
                return;
            }
            this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a16));
            this.s.f();
        }
    }

    public ImageView t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.j : (ImageView) invokeV.objValue;
    }

    public void t1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048681, this, i2) == null) || (frsMoveAreaBottomMenuView = this.j0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setVisibility(i2);
    }

    public void u0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048682, this) == null) || this.m == null || (frameLayout = this.n) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public void u1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048683, this, i2) == null) || (frsMoveAreaBottomMenuView = this.j0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setMoveNumber(i2);
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.F = false;
            this.t.setNextPage(null);
        }
    }

    public void v1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048685, this, i2) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setSelectNumber(i2);
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048686, this, z) == null) || this.K == null) {
            return;
        }
        if (z) {
            m1(false, true);
        } else {
            m1(false, false);
        }
    }

    public void w1(boolean z) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048687, this, z) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setIsBlockMode(z);
    }

    public final boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            aq6 aq6Var = this.h0;
            return aq6Var != null && aq6Var.E();
        }
        return invokeV.booleanValue;
    }

    public void x1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048689, this, i2) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setVisibility(i2);
    }

    public void y0(rn4 rn4Var) {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048690, this, rn4Var) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.f(rn4Var);
    }

    public void y1(kj5.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, cVar) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setDeleteCallback(cVar);
    }

    public void z0() {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || (dq6Var = this.v) == null) {
            return;
        }
        dq6Var.n();
    }

    public void z1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i2) == null) {
            this.G = i2;
        }
    }
}
