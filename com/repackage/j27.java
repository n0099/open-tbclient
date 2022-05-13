package com.repackage;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pu4;
import com.repackage.vz;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class j27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public BdTypeRecyclerView c;
    public BigdaySwipeRefreshLayout d;
    public iy6 e;
    public zy6 f;
    public y45 g;
    public PbListView h;
    public x45 i;
    public z17 j;
    public View k;
    public FrameLayout l;
    public c78 m;
    public NEGFeedBackView.b n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public BdUniqueId t;
    public pu4.h u;
    public pu4.f v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public RecyclerView.RecyclerListener y;
    public RecyclerView.OnScrollListener z;

    /* loaded from: classes6.dex */
    public class a implements pu4.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j27 a;

        public a(j27 j27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j27Var;
        }

        @Override // com.repackage.pu4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.W();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pu4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j27 a;

        public b(j27 j27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j27Var;
        }

        @Override // com.repackage.pu4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.L(true);
                if (this.a.m == null || this.a.q || !this.a.r) {
                    return;
                }
                this.a.m.n(this.a.o, this.a.p, this.a.s, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j27 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.j.c();
                    if (this.a.a.q || !this.a.a.r) {
                        return;
                    }
                    this.a.a.m.n(this.a.a.o, this.a.a.p, this.a.a.s, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j27 j27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j27Var, Integer.valueOf(i)};
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
            this.a = j27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ng.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j27 j27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j27Var, Integer.valueOf(i)};
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
            this.a = j27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (p = this.a.p()) == null || p.c() == null) {
                    return;
                }
                p.c().o(new vz.a(3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j27 a;

        public e(j27 j27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j27Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.m != null) {
                this.a.m.k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).c().stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ j27 b;

        public f(j27 j27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j27Var;
            this.a = -1;
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.b.o = i;
                this.b.p = (i + i2) - 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (i == 0 && this.b.m != null && this.b.r) {
                    this.b.m.m(this.b.o, this.b.p, this.b.s, 1);
                }
                if (this.a == i) {
                    return;
                }
                this.a = i;
                if (i == 1) {
                    this.b.N(true);
                } else {
                    this.b.Y();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i, i2) == null) {
                int i4 = 0;
                if (recyclerView instanceof BdRecyclerView) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i4 = bdRecyclerView.getFirstVisiblePosition();
                    i3 = bdRecyclerView.getLastVisiblePosition();
                } else {
                    i3 = 0;
                }
                a(i4, (i3 - i4) + 1);
            }
        }
    }

    public j27(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.p = 0;
        this.q = false;
        this.r = true;
        this.s = false;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this, 2921420);
        this.x = new d(this, 2921381);
        this.y = new e(this);
        this.z = new f(this);
        this.a = tbPageContext;
        this.t = bdUniqueId;
        this.n = bVar;
        w();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            x45 x45Var = this.i;
            if (x45Var != null) {
                x45Var.n();
            }
            X(null);
            iy6 iy6Var = this.e;
            if (iy6Var != null) {
                iy6Var.Y();
            }
            z17 z17Var = this.j;
            if (z17Var != null) {
                z17Var.d();
            }
            c78 c78Var = this.m;
            if (c78Var != null) {
                c78Var.h();
            }
            o();
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(this.w);
        }
    }

    public void B() {
        z17 z17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (z17Var = this.j) == null) {
            return;
        }
        z17Var.e();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            z(true);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            z(false);
        }
    }

    public void E() {
        c78 c78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (c78Var = this.m) != null && this.r) {
            c78Var.n(this.o, this.p, this.s, true);
        }
    }

    public final boolean F(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void G() {
        z17 z17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (z17Var = this.j) == null) {
            return;
        }
        z17Var.c();
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.w.setTag(this.t);
            MessageManager.getInstance().registerListener(this.w);
            this.x.setTag(this.t);
            MessageManager.getInstance().registerListener(this.x);
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            List<Integer> s = s(str, this.c);
            int intValue = s.get(0).intValue();
            int intValue2 = s.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.c.F(intValue, intValue2);
        }
    }

    public void J(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            z17 z17Var = this.j;
            if (z17Var != null) {
                z17Var.f(list);
            }
            E();
        }
    }

    public void K(pu4.g gVar) {
        iy6 iy6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || (iy6Var = this.e) == null) {
            return;
        }
        iy6Var.e(gVar);
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.r = z;
        }
    }

    public void M(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) || (bdTypeRecyclerView = this.c) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.q = z;
        }
    }

    public void P(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) || (pbListView = this.h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.c.setNextPage(this.h);
        }
        this.h.t(mi.f(this.a.getPageActivity(), R.dimen.tbds178));
        this.h.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1525));
        this.h.B(onClickListener);
        this.h.f();
    }

    public void Q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pbListView = this.h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.c.setNextPage(this.h);
        }
        this.h.t(mi.f(this.a.getPageActivity(), R.dimen.tbds178));
        this.h.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a34));
        this.h.B(null);
        this.h.Q();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || x()) {
            return;
        }
        if (this.i == null) {
            x45 x45Var = new x45(this.a.getPageActivity());
            this.i = x45Var;
            x45Var.onChangeSkinType();
        }
        this.i.attachView(this.b, false);
    }

    public void S(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            if (this.g == null) {
                this.g = new y45(this.a.getPageActivity(), onClickListener);
            }
            this.g.p();
            this.g.m(null);
            this.g.n(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f84));
            this.g.i(R.drawable.new_pic_emotion_08);
            this.g.l(0);
            this.g.attachView(this.l, false);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.g == null) {
                this.g = new y45(this.a.getPageActivity(), null);
            }
            this.g.e();
            this.g.i(R.drawable.new_pic_emotion_03);
            this.g.o(this.a.getString(R.string.obfuscated_res_0x7f0f0c44));
            this.g.attachView(this.l, false);
        }
    }

    public void U() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (pbListView = this.h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.c.setNextPage(this.h);
        }
        this.h.t(mi.f(this.a.getPageActivity(), R.dimen.tbds178));
        this.h.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1528));
        this.h.B(null);
        this.h.f();
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.d.setRefreshing(true);
        }
    }

    public void W() {
        c78 c78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (c78Var = this.m) == null) {
            return;
        }
        c78Var.x();
    }

    public void X(pu4.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.d.z(iVar);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (F(this.c)) {
                N(false);
            } else {
                N(true);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            x45 x45Var = this.i;
            if (x45Var != null) {
                x45Var.r(TbadkCoreApplication.getInst().getSkinType());
                this.i.onChangeSkinType();
            }
            y45 y45Var = this.g;
            if (y45Var != null) {
                y45Var.onChangeSkinType();
            }
            iy6 iy6Var = this.e;
            if (iy6Var != null) {
                iy6Var.H(skinType);
            }
            z17 z17Var = this.j;
            if (z17Var != null) {
                z17Var.c();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            J(new LinkedList());
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.z);
                this.c.setRecyclerListener(null);
            }
            iy6 iy6Var = this.e;
            if (iy6Var != null) {
                iy6Var.g(null);
                this.e.m(null);
            }
        }
    }

    public final ThreadCardViewHolder p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            c78 c78Var = this.m;
            if (c78Var == null || c78Var.j() == null || !(this.m.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.m.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public List<ro> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            z17 z17Var = this.j;
            if (z17Var != null) {
                return z17Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final List<Integer> s(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                ro C = bdTypeRecyclerView.C(i3);
                if (C instanceof yx5) {
                    yx5 yx5Var = (yx5) C;
                    if (yx5Var.getThreadData() != null && yx5Var.getThreadData().getTid().equals(str)) {
                        if (!z) {
                            i = i3;
                        }
                        z = true;
                        i2 = i3;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void t() {
        x45 x45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (x45Var = this.i) == null) {
            return;
        }
        x45Var.dettachView(this.b);
    }

    public void u() {
        y45 y45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (y45Var = this.g) == null) {
            return;
        }
        y45Var.dettachView(this.l);
        this.g = null;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.c.addOnScrollListener(this.z);
            this.c.setRecyclerListener(this.y);
            this.e.g(this.u);
            this.e.m(this.v);
            this.e.a0(this.a.getUniqueId());
            H();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d087c, (ViewGroup) null);
            this.b = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.l = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0923ac);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f0923af);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            c78 c78Var = new c78(this.a, this.c);
            this.m = c78Var;
            c78Var.v(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m.u(this.t);
            this.d = (BigdaySwipeRefreshLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0923b0);
            iy6 iy6Var = new iy6(this.a);
            this.e = iy6Var;
            this.d.setProgressView(iy6Var);
            int i = (int) (this.a.getResources().getDisplayMetrics().density * 86.0f);
            this.d.setCustomDistances(i, i, i * 2);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.h = pbListView;
            pbListView.a();
            this.h.p(R.color.transparent);
            this.h.t(mi.f(this.a.getPageActivity(), R.dimen.tbds178));
            this.h.x();
            this.h.G(R.dimen.tbfontsize36);
            this.h.E(SkinManager.getColor(R.color.CAM_X0109));
            this.h.A(R.color.CAM_X0110);
            this.h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            z17 z17Var = new z17(this.a, this.c);
            this.j = z17Var;
            z17Var.g(this.n);
            this.j.h(this.t);
            zy6 zy6Var = new zy6();
            this.f = zy6Var;
            zy6Var.a(this.t);
            this.j.i(this.f);
            this.k = this.b.findViewById(R.id.obfuscated_res_0x7f0923a9);
            m();
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            x45 x45Var = this.i;
            if (x45Var == null) {
                return false;
            }
            return x45Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void y() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (bdTypeRecyclerView = this.c) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.q = z;
            c78 c78Var = this.m;
            if (c78Var == null) {
                return;
            }
            c78Var.r(!z);
            ThreadCardViewHolder p = p();
            boolean z2 = false;
            if (p != null && p.c() != null) {
                z2 = p.c().o(new vz.a(8, Boolean.valueOf(z)));
            }
            if (z2) {
                return;
            }
            if (z) {
                this.m.x();
            } else if (this.r) {
                this.m.n(this.o, this.p, this.s, true);
            }
        }
    }
}
