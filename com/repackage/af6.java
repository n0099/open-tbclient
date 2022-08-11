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
import com.repackage.hf;
import com.repackage.wr4;
import com.repackage.xk5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public class af6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar A;
    @NonNull
    public final kp6 B;
    public View C;
    public View D;
    public FrameLayout E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean I;
    public CommonTipView J;
    public pr6 K;
    public wj6 L;
    public yr6 M;
    public GifView N;
    public TbImageView O;
    public HashSet<String> P;
    public p88 Q;
    public int R;
    public int S;
    public View T;
    public View U;
    public ObservedChangeLinearLayout V;
    public boolean W;
    public uj6 X;
    public boolean Y;
    public rs8 Z;
    public FrsFragment a;
    public AppBarLayout a0;
    public NoPressedRelativeLayout b;
    public AppBarLayoutStickyBehavior b0;
    public CoordinatorLayout c;
    public FrsHeaderViewContainer c0;
    public View d;
    public CollapsingToolbarLayout d0;
    public View e;
    public boolean e0;
    public ImageView f;
    public int f0;
    public ImageView g;
    public int g0;
    public MessageRedDotView h;
    public int h0;
    public n16 i;
    public tr6 i0;
    public ImageView j;
    public FrsMultiDelBottomMenuView j0;
    public ImageView k;
    public FrsMoveAreaBottomMenuView k0;
    public TextView l;
    public NavigationBarCoverTip l0;
    public ViewStub m;
    public TextView m0;
    public FrameLayout n;
    public TextView n0;
    public TbImageView o;
    public int o0;
    public TbImageView p;
    public int p0;
    public ExposeTagViewCoordinatorLayout q;
    public boolean q0;
    public FrsTabViewPager r;
    public mn r0;
    public PbListView s;
    public wy8 s0;
    public BdTypeRecyclerView t;
    public CustomMessageListener t0;
    public tj6 u;
    public AppBarLayout.OnOffsetChangedListener u0;
    public wr6 v;
    public Runnable v0;
    public wr4 w;
    public boolean w0;
    public View.OnClickListener x;
    public NoNetworkView.b y;
    public NoNetworkView z;

    /* loaded from: classes5.dex */
    public class a implements wr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public a(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        @Override // com.repackage.wr4.c
        public void a(wr4 wr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wr4Var, i, view2) == null) {
                wr4Var.e();
                if (i == 0) {
                    this.a.a.f5();
                } else if (i != 1 || this.a.a.getPageContext() == null) {
                } else {
                    SelectImageHelper.getAlbumImage(this.a.a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public b(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
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

    /* loaded from: classes5.dex */
    public class c implements ff {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public c(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        @Override // com.repackage.ff
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ff
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.ff
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0873, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921b7)).setText(R.string.obfuscated_res_0x7f0f0763);
                this.a.a.getPageContext().getLayoutMode().k(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.repackage.ff
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? qi.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070230) : invokeV.intValue;
        }

        @Override // com.repackage.ff
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? -qi.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f0702e6) : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements hf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.hf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ru4.k().x("frs_video_activity_guide", 1L);
            }
        }

        @Override // com.repackage.hf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf a;

        public e(af6 af6Var, gf gfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, gfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gfVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            gf gfVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gfVar = this.a) == null) {
                return;
            }
            gfVar.d();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public f(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.X().notifyDataSetChanged();
                if (this.a.q0) {
                    return;
                }
                this.a.Q.n(this.a.R, this.a.S, this.a.I, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(af6 af6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, Integer.valueOf(i)};
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
            this.a = af6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.r0 == null) {
                        this.a.r0 = new mn(new kn());
                    }
                    this.a.r0.q(this.a.t, 2);
                } else if (this.a.r0 != null) {
                    this.a.r0.w();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public h(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                this.a.N(appBarLayout, i);
                if (this.a.v != null && this.a.q.hasTargetView()) {
                    this.a.v.s(i == 0 && !this.a.q.canDrag());
                }
                if (this.a.g0 != i && Math.abs(i) >= 0 && this.a.U() != -1) {
                    if (Math.abs(i) >= this.a.U()) {
                        if (this.a.e0) {
                            this.a.e0 = false;
                            af6 af6Var = this.a;
                            af6Var.O0(af6Var.e0);
                        }
                    } else if (!this.a.e0) {
                        this.a.e0 = true;
                        af6 af6Var2 = this.a;
                        af6Var2.O0(af6Var2.e0);
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
                    if (Float.compare(abs, 0.05f) <= 0 && this.a.g0 - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        this.a.W1(Math.abs(a0 - g));
                        if (this.a.U != null) {
                            this.a.U.setVisibility(0);
                        }
                    } else if (this.a.U != null) {
                        if (this.a.q0() != UtilHelper.getStatusBarHeight()) {
                            this.a.W1(0);
                        }
                        this.a.U.setVisibility(8);
                    }
                    if (this.a.A != null) {
                        if (this.a.W) {
                            this.a.A.getBarBgView().setAlpha(abs);
                            this.a.Z1(false);
                            this.a.B.c(abs);
                        } else if (this.a.n0 != null) {
                            this.a.n0.setAlpha(abs);
                        }
                    }
                    this.a.g0 = i;
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i));
                    CustomMessage customMessage = new CustomMessage(2921397);
                    if (this.a.a != null && this.a.a.E3() != null && this.a.a.E3().C() != null && (this.a.a.E3().C().b instanceof BaseFragment)) {
                        customMessage.setTag(((BaseFragment) this.a.a.E3().C().b).getUniqueId());
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

    /* loaded from: classes5.dex */
    public class i implements ch5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public i(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        @Override // com.repackage.ch5
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || i2 == i4 || i4 <= 0) {
                return;
            }
            this.a.d0.setMinimumHeight(i2);
        }
    }

    /* loaded from: classes5.dex */
    public class j extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ af6 b;

        public j(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = af6Var;
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

    /* loaded from: classes5.dex */
    public class k extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(af6 af6Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var, context};
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

    /* loaded from: classes5.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public l(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.a.Q != null) {
                    this.a.Q.k(view2);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.obfuscated_res_0x7f09002d);
                if (playVoiceBnt != null) {
                    playVoiceBnt.k();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.obfuscated_res_0x7f09002b);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
                if (this.a.s0 != null) {
                    this.a.s0.f(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public m(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.K3();
                if (this.a.a == null || this.a.a0 == null) {
                    return;
                }
                this.a.a.q4();
                this.a.a0.setExpanded(true);
                if (this.a.Q != null) {
                    this.a.Q.n(this.a.R, this.a.S, false, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public n(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
        }

        @Override // com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener
        public void onNestedScrollAccepted(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.v != null && this.a.q.hasTargetView()) {
                this.a.v.s(this.a.g0 == 0 && !this.a.q.canDrag());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af6 a;

        public o(af6 af6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af6Var;
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

    public af6(FrsFragment frsFragment, View.OnClickListener onClickListener, uj6 uj6Var, boolean z, tr6 tr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onClickListener, uj6Var, Boolean.valueOf(z), tr6Var};
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
        this.B = jp6.a();
        this.F = true;
        this.G = true;
        this.H = 0;
        this.I = false;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = null;
        this.W = false;
        this.Y = true;
        this.e0 = true;
        this.f0 = -1;
        this.g0 = -1;
        this.o0 = 0;
        this.p0 = 0;
        this.q0 = false;
        this.t0 = new g(this, 2156674);
        this.u0 = new h(this);
        this.v0 = new b(this);
        this.a = frsFragment;
        this.x = onClickListener;
        MessageManager.getInstance().registerListener(this.t0);
        D0(uj6Var, z);
        this.P = new HashSet<>();
        this.H = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.h0 = TbadkCoreApplication.getInst().getSkinType();
        this.i0 = tr6Var;
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
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.n();
    }

    public void A1(xk5.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (frsMultiDelBottomMenuView = this.j0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setDeleteCallback(cVar);
    }

    public void B0() {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.o();
    }

    public void B1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.H = i2;
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.N == null) {
            View C3 = this.a.C3();
            this.N = (GifView) C3.findViewById(R.id.obfuscated_res_0x7f090c86);
            TbImageView tbImageView = (TbImageView) C3.findViewById(R.id.obfuscated_res_0x7f092095);
            this.O = tbImageView;
            tbImageView.setPageId(this.a.getUniqueId());
            this.N.setLayerType(1, null);
            this.O.setLayerType(1, null);
        }
    }

    public void C1(yn ynVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ynVar) == null) {
            this.u.d(ynVar);
        }
    }

    public final void D0(uj6 uj6Var, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, uj6Var, z) == null) {
            this.X = uj6Var;
            View C3 = this.a.C3();
            if (this.b == null) {
                this.b = (NoPressedRelativeLayout) C3.findViewById(R.id.obfuscated_res_0x7f090ac4);
            }
            if (this.d == null) {
                this.d = C3.findViewById(R.id.obfuscated_res_0x7f090af5);
            }
            if (this.c == null) {
                this.c = (CoordinatorLayout) C3.findViewById(R.id.obfuscated_res_0x7f090baa);
            }
            if (this.D == null) {
                this.D = C3.findViewById(R.id.obfuscated_res_0x7f090b84);
            }
            if (this.E == null) {
                this.E = (FrameLayout) C3.findViewById(R.id.obfuscated_res_0x7f090bf0);
            }
            if (this.d0 == null) {
                this.d0 = (CollapsingToolbarLayout) C3.findViewById(R.id.obfuscated_res_0x7f090af3);
            }
            if (this.c0 == null) {
                this.c0 = (FrsHeaderViewContainer) C3.findViewById(R.id.obfuscated_res_0x7f090d3c);
            }
            if (this.v == null) {
                this.v = new wr6(this.a);
            }
            if (this.V == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) C3.findViewById(R.id.obfuscated_res_0x7f09162e);
                this.V = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new i(this));
            }
            this.B.h(this.a, C3, this.x);
            if (this.A == null) {
                this.A = this.B.e();
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.a.S3()) {
                this.A.setVisibility(8);
            }
            if (this.C == null) {
                this.C = C3.findViewById(R.id.obfuscated_res_0x7f090ba9);
                vj6 c2 = uj6Var.c();
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
                this.i = (n16) this.B.a(LogicField.MESSAGE_ICON_CONTROLLER);
                this.g = (ImageView) this.B.a(LogicField.MESSAGE_BTN);
                this.h = (MessageRedDotView) this.B.a(LogicField.MESSAGE_RED_DOT);
            }
            if (this.j == null) {
                this.j = (ImageView) this.B.a(LogicField.SHARE_BTN);
            }
            if (this.l == null) {
                TextView textView = (TextView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d033e, (View.OnClickListener) null);
                this.l = textView;
                textView.setVisibility(8);
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
                int f2 = qi.f(this.a.getActivity(), R.dimen.tbds31);
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
                this.t = (BdTypeRecyclerView) C3.findViewById(R.id.obfuscated_res_0x7f090b8e);
            }
            j jVar = new j(this);
            jVar.setSupportsChangeAnimations(false);
            this.t.setItemAnimator(jVar);
            BdTypeRecyclerView bdTypeRecyclerView = this.t;
            bdTypeRecyclerView.setLayoutManager(new k(this, bdTypeRecyclerView.getContext()));
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                mn mnVar = new mn(new kn());
                this.r0 = mnVar;
                mnVar.q(this.t, 2);
            }
            this.t.setScrollable(this.a);
            this.t.setFadingEdgeLength(0);
            this.t.setOverScrollMode(2);
            this.b.setBottomOrderView(this.t);
            this.t.setOnTouchListener(this.a.N1);
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
            this.s.t(qi.f(this.a.getActivity(), R.dimen.tbds182));
            this.s.x();
            this.s.G(R.dimen.tbfontsize33);
            this.s.E(SkinManager.getColor(R.color.CAM_X0109));
            this.s.A(R.color.CAM_X0110);
            this.t.setOnSrollToBottomListener(this.a);
            this.A.setOnClickListener(new m(this));
            boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
            if (this.u == null) {
                this.u = uj6Var.b(this.a, this.t, isShowBigImage);
            }
            wr6 wr6Var = this.v;
            if (wr6Var != null) {
                wr6Var.t(1, false);
            }
            if (!z) {
                if (this.z == null) {
                    this.z = new NoNetworkView(this.a.getActivity());
                    this.z.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.V.addView(this.z);
                }
                if (oi.A()) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setVisibility(0);
                }
                this.z.d(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            C0();
            if (this.K == null) {
                pr6 a2 = uj6Var.a(this.a, this.b);
                this.K = a2;
                a2.y(this.a.H3());
            }
            if (this.L == null) {
                this.L = uj6Var.d(this.a, this.b);
                n1(true);
            }
            if (this.T == null) {
                this.T = C3.findViewById(R.id.obfuscated_res_0x7f091f2b);
            }
            if (this.U == null) {
                this.U = C3.findViewById(R.id.obfuscated_res_0x7f091f2c);
            }
            if (this.Q == null) {
                this.Q = new p88(this.a.getPageContext(), this.t);
            }
            this.Q.p(2);
            this.Q.u(this.a.getUniqueId());
            if (this.s0 == null) {
                this.s0 = new wy8(this.a.getPageContext(), this.t);
            }
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) C3.findViewById(R.id.obfuscated_res_0x7f091630);
            this.l0 = navigationBarCoverTip;
            if (this.M == null) {
                this.M = new yr6(this.a, navigationBarCoverTip);
            }
            if (this.a0 == null) {
                AppBarLayout appBarLayout = (AppBarLayout) C3.findViewById(R.id.obfuscated_res_0x7f090ad7);
                this.a0 = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.u0);
                this.e0 = true;
                this.f0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.a0.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.b0 = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) C3.findViewById(R.id.obfuscated_res_0x7f090ba2);
            this.j0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) C3.findViewById(R.id.obfuscated_res_0x7f090b9f);
            this.k0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.a.getPageContext());
            if (this.n0 == null) {
                this.n0 = (TextView) this.B.a(LogicField.FOLD_TITLE);
            }
            ExposeTagViewCoordinatorLayout exposeTagViewCoordinatorLayout = (ExposeTagViewCoordinatorLayout) C3.findViewById(R.id.obfuscated_res_0x7f090baa);
            this.q = exposeTagViewCoordinatorLayout;
            exposeTagViewCoordinatorLayout.setListener(new n(this));
            FrsTabViewPager frsTabViewPager = (FrsTabViewPager) C3.findViewById(R.id.obfuscated_res_0x7f090c05);
            this.r = frsTabViewPager;
            frsTabViewPager.addOnPageChangeListener(new o(this));
        }
    }

    public void D1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.y = bVar;
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m != null && this.p.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void E1(boolean z) {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.u(z);
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s.b().getParent() != null && this.G : invokeV.booleanValue;
    }

    public void F1(ArrayList<on> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) || frsViewData == null) {
            return;
        }
        ArrayList<on> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            cf6 cf6Var = new cf6();
            ArrayList<on> arrayList2 = new ArrayList<>();
            arrayList2.add(cf6Var);
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.K0() != null && this.a.K0().Y() == 0) {
                cf6Var.b(this.a.K0().U());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                on onVar = switchThreadDataToThreadCardInfo.get(i3);
                if (onVar instanceof ir4) {
                    ((ir4) onVar).t.setSmartFrsPosition(i3);
                }
            }
        }
        this.u.g(switchThreadDataToThreadCardInfo, frsViewData);
        p88 p88Var = this.Q;
        if (p88Var != null && (i2 = this.R) != 0) {
            p88Var.n(i2, this.S, this.I, true);
        }
        FrsFragment frsFragment2 = this.a;
        if (frsFragment2 != null) {
            frsFragment2.C4();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.j0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setFrsViewData(frsViewData);
        }
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.k0;
            return frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.b();
        }
        return invokeV.booleanValue;
    }

    public void G1(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (textView = this.n0) != null && TextUtils.isEmpty(textView.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.n0.setText("");
                return;
            }
            this.n0.setText(c0(str));
            rn4.c().h(str);
        }
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            wr6 wr6Var = this.v;
            if (wr6Var != null) {
                return wr6Var.j() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void H1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || this.V == null) {
            return;
        }
        q1();
        if (this.W) {
            this.A.getBarBgView().setAlpha(0.0f);
            this.A.hideBottomLine();
        } else {
            View view2 = this.T;
            if (view2 != null) {
                view2.setAlpha(1.0f);
            }
            View view3 = this.U;
            if (view3 != null) {
                view3.setAlpha(1.0f);
            }
            TextView textView = this.n0;
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
            this.A.getBarBgView().setAlpha(1.0f);
            this.A.showBottomLine();
        }
        P0(this.h0);
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            pr6 pr6Var = this.K;
            if (pr6Var == null) {
                return false;
            }
            return pr6Var.q();
        }
        return invokeV.booleanValue;
    }

    public void I1() {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.v();
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            tj6 tj6Var = this.u;
            if (tj6Var instanceof fj6) {
                ((fj6) tj6Var).r();
            }
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.G = true;
            this.t.setNextPage(this.s);
            this.s.B(this.x);
            int i2 = this.H;
            if (i2 > 0) {
                this.s.L(i2);
            }
            this.s.f();
            this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e7));
        }
    }

    public void K(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onScrollListener) == null) {
            this.t.addOnScrollListener(onScrollListener);
        }
    }

    public void K0() {
        tj6 tj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (tj6Var = this.u) == null) {
            return;
        }
        tj6Var.notifyDataSetChanged();
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.m == null) {
            return;
        }
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.v0, 5000L);
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || this.a == null) {
            return;
        }
        M(i2);
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.q0 = z;
            if (this.Q == null) {
                return;
            }
            FrsFragment frsFragment = this.a;
            boolean z2 = (frsFragment == null || frsFragment.E3() == null || this.a.E3().C() == null) ? true : this.a.E3().C().b instanceof FrsAllThreadFragment;
            if (!z && z2) {
                this.Q.r(true);
                this.Q.n(this.R, this.S, this.I, true);
                return;
            }
            this.Q.r(false);
            this.Q.y();
        }
    }

    public void L1(qr4 qr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, qr4Var) == null) {
            if (this.m == null) {
                View C3 = this.a.C3();
                ViewStub viewStub = (ViewStub) C3.findViewById(R.id.obfuscated_res_0x7f092680);
                this.m = viewStub;
                viewStub.setVisibility(0);
                this.n = (FrameLayout) C3.findViewById(R.id.obfuscated_res_0x7f090c43);
                this.o = (TbImageView) C3.findViewById(R.id.obfuscated_res_0x7f090c42);
                this.p = (TbImageView) C3.findViewById(R.id.obfuscated_res_0x7f090c44);
                this.o.setPageId(this.a.getUniqueId());
                this.p.setPageId(this.a.getUniqueId());
                this.o.setDefaultBgResource(R.color.common_color_10022);
                this.o.setDefaultResource(0);
                this.p.setDefaultBgResource(R.color.common_color_10022);
                this.p.setDefaultResource(0);
                this.n.setOnClickListener(this.x);
            }
            this.n.setVisibility(0);
            String a2 = qr4Var.a();
            String b2 = qr4Var.b();
            this.o.K(a2, 10, false);
            this.p.K(b2, 10, false);
            TbadkCoreApplication.getInst().handler.postDelayed(this.v0, 5000L);
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
                n16 n16Var = this.i;
                if (n16Var != null) {
                    n16Var.d(i2);
                }
                if (this.k != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080613, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (this.j != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080614, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            SkinManager.setBackgroundColor(this.T, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.U, R.color.CAM_X0207);
            Z1(true);
        }
    }

    public void M0() {
        wy8 wy8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (wy8Var = this.s0) == null) {
            return;
        }
        wy8Var.c();
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.t.setVisibility(0);
        }
    }

    public final void N(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, appBarLayout, i2) == null) || (frsFragment = this.a) == null || appBarLayout == null || frsFragment.E3() == null || this.a.getPageContext() == null) {
            return;
        }
        int a0 = a0() + i0() + k0();
        int totalScrollRange = (appBarLayout.getTotalScrollRange() - Math.abs(i2)) + this.B.g();
        FrsTabViewController E3 = this.a.E3();
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        FrsFragment frsFragment2 = this.a;
        boolean z = frsFragment2 != null && frsFragment2.b4();
        if (totalScrollRange <= 0) {
            if (this.p0 != 2) {
                E3.f(2);
            }
            this.p0 = 2;
            marginLayoutParams.topMargin = 0;
        } else if (totalScrollRange > 0 && totalScrollRange < a0) {
            if (this.p0 != 1) {
                E3.f(1);
            }
            this.p0 = 1;
            marginLayoutParams.topMargin = 0;
        } else {
            if (this.p0 != 0) {
                E3.f(0);
            }
            this.p0 = 0;
            if (z) {
                marginLayoutParams.topMargin = qi.f(this.a.getActivity(), R.dimen.tbds_30);
            } else {
                marginLayoutParams.topMargin = 0;
            }
        }
        if (z) {
            this.d.setLayoutParams(marginLayoutParams);
        }
    }

    public void N0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) {
            wy8 wy8Var = this.s0;
            if (wy8Var != null) {
                wy8Var.d();
            }
            p88 p88Var = this.Q;
            if (p88Var == null) {
                return;
            }
            p88Var.m(i2, i3, this.I, 1);
            this.Q.p(2);
            this.Q.q(false);
        }
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.G = true;
            this.t.setNextPage(this.s);
            int i2 = this.H;
            if (i2 > 0) {
                this.s.L(i2);
            }
            this.s.B(null);
            this.s.Q();
        }
    }

    public void O(String str) {
        yr6 yr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || (yr6Var = this.M) == null) {
            return;
        }
        yr6Var.a(str);
    }

    public final void O0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || !z || (frsFragment = this.a) == null || frsFragment.o0() == null) {
            return;
        }
        this.a.o0().Z();
    }

    public final void O1(int i2) {
        n16 n16Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || (n16Var = this.i) == null) {
            return;
        }
        n16Var.g(i2);
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.v.h();
        }
    }

    public void P0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.h0 = i2;
            this.B.onChangeSkinType(i2);
            ok5 ok5Var = new ok5(this.a, 4);
            ok5Var.F(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ok5Var));
            nk5 nk5Var = new nk5(this.a.getPageContext(), 4);
            nk5Var.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, nk5Var));
            TbImageView tbImageView = this.O;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            tj6 tj6Var = this.u;
            if (tj6Var != null) {
                tj6Var.b();
                this.u.notifyDataSetChanged();
            }
            fb5.a(this.a.getPageContext(), this.b);
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), i2);
            }
            PbListView pbListView = this.s;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.s.d(i2);
            }
            TextView textView = this.n0;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            L(i2);
            wj6 wj6Var = this.L;
            if (wj6Var != null) {
                wj6Var.onChangeSkinType(i2);
            }
            pr6 pr6Var = this.K;
            if (pr6Var != null) {
                pr6Var.v(i2);
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.j0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.d();
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.k0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.c();
            }
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0202);
        }
    }

    public void P1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048613, this, str, i2) == null) {
            if (this.m0 == null) {
                TextView textView = new TextView(this.a.getActivity());
                this.m0 = textView;
                textView.setGravity(19);
                this.m0.setPadding(qi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, qi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                this.m0.setLayoutParams(new ViewGroup.LayoutParams(-1, qi.f(this.a.getActivity(), R.dimen.tbds112)));
                this.m0.setTextSize(0, qi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07032e));
                this.m0.setMaxLines(2);
                this.m0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.m0.setTextColor(ContextCompat.getColor(this.a.getActivity(), R.color.CAM_X0101));
            }
            this.l0.setBackgroundColor(i2);
            this.m0.setText(str);
            this.l0.m(this.a.getActivity(), this.m0, 5000);
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

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t0);
            p88 p88Var = this.Q;
            if (p88Var != null) {
                p88Var.h();
            }
            yr6 yr6Var = this.M;
            if (yr6Var != null) {
                yr6Var.c();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.j0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.setPageContext(null);
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.k0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.setPageContext(null);
            }
            this.u.m();
            this.t.setOnSrollToBottomListener(null);
            this.t.setScrollable(null);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.v0);
            CommonTipView commonTipView = this.J;
            if (commonTipView != null) {
                commonTipView.i();
            }
            this.P.clear();
            pr6 pr6Var = this.K;
            if (pr6Var != null) {
                pr6Var.s();
            }
            rs8 rs8Var = this.Z;
            if (rs8Var != null) {
                rs8Var.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.l0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.j0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.e();
            }
            wr6 wr6Var = this.v;
            if (wr6Var != null) {
                wr6Var.p();
            }
            wr6 wr6Var2 = this.v;
            if (wr6Var2 != null) {
                wr6Var2.r(null);
            }
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.G = false;
            this.t.setNextPage(this.s);
            int i2 = this.H;
            if (i2 > 0) {
                this.s.L(i2);
            }
            this.s.B(null);
            this.s.f();
            this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && this.w == null && this.a.getPageContext() != null) {
            String[] strArr = {this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1367), this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f024f)};
            wr4 wr4Var = new wr4(this.a.getPageContext().getPageActivity());
            this.w = wr4Var;
            wr4Var.l(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0d03));
            this.w.j(strArr, new a(this));
            this.w.c(this.a.getPageContext());
        }
    }

    public boolean R0() {
        InterceptResult invokeV;
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.a0 != null && (appBarLayoutStickyBehavior = this.b0) != null && appBarLayoutStickyBehavior.isSticky()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                this.b0.expandedAppBarLayout(this.a0);
                return true;
            }
            pr6 pr6Var = this.K;
            return pr6Var != null && pr6Var.w();
        }
        return invokeV.booleanValue;
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            R();
            wr4 wr4Var = this.w;
            if (wr4Var != null) {
                wr4Var.m();
            }
        }
    }

    public void S() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (frsMultiDelBottomMenuView = this.j0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.a();
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            pr6 pr6Var = this.K;
            if (pr6Var != null) {
                pr6Var.t();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void S1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                l05.c(this.a.o(), postWriteCallBackData, 1);
                return;
            }
            if (this.Z == null) {
                this.Z = new rs8(this.a.getActivity(), this.b);
            }
            this.Z.g(postWriteCallBackData);
        }
    }

    public void T() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (frsMultiDelBottomMenuView = this.j0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.b();
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
        }
    }

    public void T1() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || ru4.k().m("frs_video_activity_guide", 0L) != 0 || this.w0 || this.a.getActivity() == null || this.a.getPageContext() == null) {
            return;
        }
        View view2 = null;
        BdTypeRecyclerView bdTypeRecyclerView = this.t;
        if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.t.getChildCount()) {
            view2 = this.t.getChildAt(headerViewsCount);
        }
        if (view2 != null) {
            hf hfVar = new hf();
            hfVar.k(view2);
            hfVar.c(0);
            hfVar.j(true);
            hfVar.i(false);
            hfVar.d(true);
            hfVar.a(new c(this));
            hfVar.h(new d(this));
            gf b2 = hfVar.b();
            b2.k(false);
            b2.m(this.a.getActivity());
            rg.a().postDelayed(new e(this, b2), 4000L);
            this.w0 = true;
        }
    }

    public final int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            AppBarLayout appBarLayout = this.a0;
            if (appBarLayout == null) {
                return this.f0;
            }
            int i2 = this.f0;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.a0.getChildAt(childCount);
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
            int max = Math.max(0, this.a0.getTotalScrollRange() - Math.abs(i3));
            this.f0 = max;
            return max;
        }
        return invokeV.intValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            L(TbadkCoreApplication.getInst().getSkinType());
            pr6 pr6Var = this.K;
            if (pr6Var != null) {
                pr6Var.u();
            }
        }
    }

    public void U1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048628, this, z) == null) || this.K == null) {
            return;
        }
        if (z45.h().k()) {
            this.K.B(false);
        } else {
            this.K.B(z);
        }
    }

    public View V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || X() == null) {
            return;
        }
        List<on> f2 = X().f();
        if (ListUtils.isEmpty(f2)) {
            return;
        }
        for (on onVar : f2) {
            if (onVar instanceof ir4) {
                ir4 ir4Var = (ir4) onVar;
                if (ir4Var.u != 0 && ir4Var.t != null && this.a.K0() != null && this.a.K0().g0() != null) {
                    int[] imageWidthAndHeight = ir4Var.t.getImageWidthAndHeight();
                    ir4Var.u = imageWidthAndHeight[0];
                    ir4Var.v = imageWidthAndHeight[1];
                }
            }
        }
        rg.a().postDelayed(new f(this), 500L);
    }

    public void V1() {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.w();
    }

    public View W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.D : (View) invokeV.objValue;
    }

    public void W0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048633, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && ru4.k().h("frs_login_tip", true)) {
                if (this.J == null) {
                    this.J = new CommonTipView(this.a.getActivity());
                }
                this.J.setText(R.string.obfuscated_res_0x7f0f0720);
                FrameLayout s0 = s0();
                if (s0 != null) {
                    this.J.j(s0, TbadkCoreApplication.getInst().getSkinType());
                    ru4.k().u("frs_login_tip", false);
                }
            }
        }
    }

    public final void W1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
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

    public tj6 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.u : (tj6) invokeV.objValue;
    }

    public void X0() {
        wj6 wj6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (this.Y && (wj6Var = this.L) != null) {
                wj6Var.b(false, false);
            }
            O1(8);
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.j;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            U1(false);
            this.t.setVisibility(8);
            this.c0.setVisibility(8);
        }
    }

    public void X1() {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.x();
    }

    public wr6 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.v : (wr6) invokeV.objValue;
    }

    public void Y0() {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.w();
    }

    public final void Y1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || (navigationBar = this.A) == null) {
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
        TextView textView = this.n0;
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
            if (frsFragment != null && frsFragment.E3() != null && this.o0 == 1) {
                this.a.E3().h0(f2);
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
        View view2 = this.T;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
        View view3 = this.U;
        if (view3 != null) {
            view3.setAlpha(alpha);
        }
        View view4 = this.C;
        if (view4 != null) {
            view4.setAlpha(alpha);
        }
    }

    public pr6 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.K : (pr6) invokeV.objValue;
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            D0(this.X, this.a.S3());
            tj6 tj6Var = this.u;
            if (tj6Var != null) {
                tj6Var.e();
            }
        }
    }

    public final void Z1(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048643, this, z) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || !this.W) {
            return;
        }
        if (this.A.getBarBgView().getAlpha() < 0.5f) {
            if (z || this.o0 != 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080612, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080613, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                ImageView imageView = this.g;
                if (imageView != null) {
                    imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809fb, SkinManager.getColor(R.color.CAM_X0101), null));
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080614, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.o0 = 0;
            }
        } else if (z || this.o0 != 1) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080612, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080613, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ImageView imageView2 = this.g;
            if (imageView2 != null) {
                imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809fb, SkinManager.getColor(R.color.CAM_X0106), null));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080614, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.o0 = 1;
        }
        Y1();
    }

    public final int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void a1(mp4 mp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, mp4Var) == null) {
            nk5 nk5Var = new nk5(this.a.getPageContext(), 1);
            nk5Var.j(this.t);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.a.c());
            hashMap.put("forum_id", this.a.d());
            nk5Var.k(hashMap);
            nk5Var.i(mp4Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, nk5Var));
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            wr6 wr6Var = this.v;
            if (wr6Var == null) {
                return false;
            }
            return wr6Var.l();
        }
        return invokeV.booleanValue;
    }

    public void b1(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            n16 n16Var = this.i;
            if (n16Var != null) {
                n16Var.e(z, i2);
            }
            this.B.d(i2, z);
        }
    }

    public void c1() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (noNetworkView = this.z) == null || (bVar = this.y) == null) {
            return;
        }
        noNetworkView.e(bVar);
    }

    public BdTypeRecyclerView d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.t : (BdTypeRecyclerView) invokeV.objValue;
    }

    public void d1() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || (frsMoveAreaBottomMenuView = this.k0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.d();
    }

    public View e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            PbListView pbListView = this.s;
            if (pbListView == null) {
                return null;
            }
            return pbListView.b();
        }
        return (View) invokeV.objValue;
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (this.F) {
                return false;
            }
            this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a3a));
            this.s.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public View f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            n16 n16Var = this.i;
            if (n16Var != null) {
                return n16Var.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void f1() {
        wj6 wj6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            if (this.Y && (wj6Var = this.L) != null) {
                wj6Var.b(true, false);
            }
            O1(0);
            Q();
            U1(this.a.Y2());
            this.t.setVisibility(0);
            this.c0.setVisibility(0);
        }
    }

    @NonNull
    public kp6 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.B : (kp6) invokeV.objValue;
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.u.notifyDataSetChanged();
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.A : (NavigationBar) invokeV.objValue;
    }

    public void h1(int i2) {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048659, this, i2) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.q(i2);
    }

    public final int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void i1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048661, this, z) == null) || (appBarLayout = this.a0) == null) {
            return;
        }
        appBarLayout.setExpanded(z);
    }

    public ObservedChangeLinearLayout j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.V : (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public void j1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048663, this, i2, i3) == null) {
            this.R = i2;
            this.S = i3;
        }
    }

    public final int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (this.z == null || oi.z()) {
                return 0;
            }
            return this.z.getHeight();
        }
        return invokeV.intValue;
    }

    public void k1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, str) == null) {
            tj6 tj6Var = this.u;
            if (tj6Var instanceof fj6) {
                ((fj6) tj6Var).u(str);
            }
        }
    }

    public p88 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.Q : (p88) invokeV.objValue;
    }

    public void l1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.u.a(str);
        }
    }

    public TextView m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public void m1(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048669, this, i2) == null) || (view2 = this.d) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    public wj6 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.L : (wj6) invokeV.objValue;
    }

    public void n1(boolean z) {
        wj6 wj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048671, this, z) == null) || (wj6Var = this.L) == null) {
            return;
        }
        wj6Var.a(z);
    }

    public RelativeLayout o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.b : (RelativeLayout) invokeV.objValue;
    }

    public void o1(boolean z, boolean z2) {
        wj6 wj6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.Y && (wj6Var = this.L) != null) {
            wj6Var.b(z, z2);
        }
    }

    public View p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.T : (View) invokeV.objValue;
    }

    public void p1(cg6 cg6Var) {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048675, this, cg6Var) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.r(cg6Var);
    }

    public final int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            View view2 = this.T;
            if (view2 == null) {
                return 0;
            }
            return view2.getHeight();
        }
        return invokeV.intValue;
    }

    public final void q1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            this.W = y0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.c0;
            if (frsHeaderViewContainer == null || (layoutParams = frsHeaderViewContainer.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            if (this.W) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070306) + a0(), 0, 0);
            }
            this.c0.requestLayout();
        }
    }

    public View r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.U : (View) invokeV.objValue;
    }

    public void r1(boolean z) {
        wj6 wj6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.Y = z;
            if (z || (wj6Var = this.L) == null) {
                return;
            }
            wj6Var.b(false, false);
        }
    }

    public FrameLayout s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.E : (FrameLayout) invokeV.objValue;
    }

    public void s1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z) == null) {
            this.I = z;
        }
    }

    public ImageView t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.k : (ImageView) invokeV.objValue;
    }

    public void t1(int i2, boolean z) {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.t(i2, z);
    }

    public ImageView u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.j : (ImageView) invokeV.objValue;
    }

    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z) == null) {
            this.F = z;
            if (z) {
                this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a39));
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.s.b()) {
                    this.s.Q();
                    this.a.b();
                    return;
                }
                this.s.f();
                return;
            }
            this.s.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a3a));
            this.s.f();
        }
    }

    public void v0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || this.m == null || (frameLayout = this.n) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public void v1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048687, this, i2) == null) || (frsMoveAreaBottomMenuView = this.k0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setVisibility(i2);
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            this.G = false;
            this.t.setNextPage(null);
        }
    }

    public void w1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048689, this, i2) == null) || (frsMoveAreaBottomMenuView = this.k0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setMoveNumber(i2);
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048690, this, z) == null) || this.L == null) {
            return;
        }
        if (z) {
            o1(false, true);
        } else {
            o1(false, false);
        }
    }

    public void x1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048691, this, i2) == null) || (frsMultiDelBottomMenuView = this.j0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setSelectNumber(i2);
    }

    public final boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            tr6 tr6Var = this.i0;
            return tr6Var != null && tr6Var.G();
        }
        return invokeV.booleanValue;
    }

    public void y1(boolean z) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048693, this, z) == null) || (frsMultiDelBottomMenuView = this.j0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setIsBlockMode(z);
    }

    public void z0(io4 io4Var) {
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048694, this, io4Var) == null) || (wr6Var = this.v) == null) {
            return;
        }
        wr6Var.f(io4Var);
    }

    public void z1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048695, this, i2) == null) || (frsMultiDelBottomMenuView = this.j0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setVisibility(i2);
    }
}
