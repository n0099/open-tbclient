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
import com.baidu.tbadk.core.BaseFragment;
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
import com.repackage.gu4;
import com.repackage.ny;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class l27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.RecyclerListener A;
    public RecyclerView.OnScrollListener B;
    public BaseFragment a;
    public TbPageContext b;
    public View c;
    public BdTypeRecyclerView d;
    public BigdaySwipeRefreshLayout e;
    public ky6 f;
    public bz6 g;
    public l55 h;
    public PbListView i;
    public k55 j;
    public b27 k;
    public View l;
    public FrameLayout m;
    public i68 n;
    public NEGFeedBackView.b o;
    public iu6 p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public BdUniqueId v;
    public gu4.h w;
    public gu4.f x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes6.dex */
    public class a implements gu4.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 a;

        public a(l27 l27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l27Var;
        }

        @Override // com.repackage.gu4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.Y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements gu4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 a;

        public b(l27 l27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l27Var;
        }

        @Override // com.repackage.gu4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.N(true);
                if (this.a.n == null || this.a.s || !this.a.t) {
                    return;
                }
                this.a.n.n(this.a.q, this.a.r, this.a.u, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 a;

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
                    this.a.a.k.c();
                    this.a.a.A();
                    if (this.a.a.s || !this.a.a.t) {
                        return;
                    }
                    this.a.a.n.n(this.a.a.q, this.a.a.r, this.a.a.u, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l27 l27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var, Integer.valueOf(i)};
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
            this.a = l27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                qg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l27 l27Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var, Integer.valueOf(i)};
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
            this.a = l27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder q;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (q = this.a.q()) == null || q.b() == null) {
                    return;
                }
                q.b().o(new ny.a(3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 a;

        public e(l27 l27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l27Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.n != null) {
                this.a.n.k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ l27 b;

        public f(l27 l27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l27Var;
            this.a = -1;
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.b.q = i;
                this.b.r = (i + i2) - 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (i == 0 && this.b.n != null && this.b.t) {
                    this.b.n.m(this.b.q, this.b.r, this.b.u, 1);
                }
                if (this.a == i) {
                    return;
                }
                this.a = i;
                if (i == 1) {
                    this.b.P(true);
                } else {
                    this.b.a0();
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
                if (this.b.p != null) {
                    this.b.p.j();
                }
            }
        }
    }

    public l27(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.t = true;
        this.u = false;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this, 2921420);
        this.z = new d(this, 2921381);
        this.A = new e(this);
        this.B = new f(this);
        this.a = baseFragment;
        this.b = tbPageContext;
        this.v = bdUniqueId;
        this.o = bVar;
        x();
    }

    public void A() {
        iu6 iu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iu6Var = this.p) == null) {
            return;
        }
        iu6Var.f();
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.s = z;
            i68 i68Var = this.n;
            if (i68Var == null) {
                return;
            }
            i68Var.r(!z);
            ThreadCardViewHolder q = q();
            boolean z2 = false;
            if (q != null && q.b() != null) {
                z2 = q.b().o(new ny.a(8, Boolean.valueOf(z)));
            }
            if (z2) {
                return;
            }
            if (z) {
                this.n.x();
            } else if (this.t) {
                this.n.n(this.q, this.r, this.u, true);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k55 k55Var = this.j;
            if (k55Var != null) {
                k55Var.n();
            }
            Z(null);
            ky6 ky6Var = this.f;
            if (ky6Var != null) {
                ky6Var.Z();
            }
            b27 b27Var = this.k;
            if (b27Var != null) {
                b27Var.d();
            }
            i68 i68Var = this.n;
            if (i68Var != null) {
                i68Var.h();
            }
            p();
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public void D() {
        b27 b27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (b27Var = this.k) == null) {
            return;
        }
        b27Var.e();
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            B(true);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            B(false);
        }
    }

    public void G() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (i68Var = this.n) != null && this.t) {
            i68Var.n(this.q, this.r, this.u, true);
        }
    }

    public final boolean H(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b27 b27Var = this.k;
            if (b27Var != null) {
                b27Var.c();
            }
            A();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.y.setTag(this.v);
            MessageManager.getInstance().registerListener(this.y);
            this.z.setTag(this.v);
            MessageManager.getInstance().registerListener(this.z);
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            List<Integer> t = t(str, this.d);
            int intValue = t.get(0).intValue();
            int intValue2 = t.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.d.E(intValue, intValue2);
        }
    }

    public void L(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            b27 b27Var = this.k;
            if (b27Var != null) {
                b27Var.f(list);
            }
            G();
        }
    }

    public void M(gu4.g gVar) {
        ky6 ky6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) || (ky6Var = this.f) == null) {
            return;
        }
        ky6Var.f(gVar);
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.t = z;
        }
    }

    public void O(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.s = z;
        }
    }

    public void R(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) || (pbListView = this.i) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.i);
        }
        this.i.t(pi.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.i.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f14ec));
        this.i.B(onClickListener);
        this.i.f();
    }

    public void S() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.i) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.i);
        }
        this.i.t(pi.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.i.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0a18));
        this.i.B(null);
        this.i.Q();
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || y()) {
            return;
        }
        if (this.j == null) {
            k55 k55Var = new k55(this.b.getPageActivity());
            this.j = k55Var;
            k55Var.onChangeSkinType();
        }
        this.j.attachView(this.c, false);
    }

    public void U(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            if (this.h == null) {
                this.h = new l55(this.b.getPageActivity(), onClickListener);
            }
            this.h.p();
            this.h.m(null);
            this.h.n(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0f84));
            this.h.i(R.drawable.new_pic_emotion_08);
            this.h.l(0);
            this.h.attachView(this.m, false);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.h == null) {
                this.h = new l55(this.b.getPageActivity(), null);
            }
            this.h.e();
            this.h.i(R.drawable.new_pic_emotion_03);
            this.h.o(this.b.getString(R.string.obfuscated_res_0x7f0f0c30));
            this.h.attachView(this.m, false);
        }
    }

    public void W() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (pbListView = this.i) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.i);
        }
        this.i.t(pi.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.i.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f14ef));
        this.i.B(null);
        this.i.f();
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.e.setRefreshing(true);
        }
    }

    public void Y() {
        i68 i68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (i68Var = this.n) == null) {
            return;
        }
        i68Var.x();
    }

    public void Z(gu4.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iVar) == null) {
            this.e.z(iVar);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (H(this.d)) {
                P(false);
            } else {
                P(true);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            k55 k55Var = this.j;
            if (k55Var != null) {
                k55Var.r(TbadkCoreApplication.getInst().getSkinType());
                this.j.onChangeSkinType();
            }
            l55 l55Var = this.h;
            if (l55Var != null) {
                l55Var.onChangeSkinType();
            }
            ky6 ky6Var = this.f;
            if (ky6Var != null) {
                ky6Var.H(skinType);
            }
            b27 b27Var = this.k;
            if (b27Var != null) {
                b27Var.c();
            }
            A();
            iu6 iu6Var = this.p;
            if (iu6Var != null) {
                iu6Var.n();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            L(new LinkedList());
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.B);
                this.d.setRecyclerListener(null);
            }
            ky6 ky6Var = this.f;
            if (ky6Var != null) {
                ky6Var.g(null);
                this.f.m(null);
            }
        }
    }

    public final ThreadCardViewHolder q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            i68 i68Var = this.n;
            if (i68Var == null || i68Var.j() == null || !(this.n.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.n.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public List<nn> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            b27 b27Var = this.k;
            if (b27Var != null) {
                return b27Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public final List<Integer> t(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                nn B = bdTypeRecyclerView.B(i3);
                if (B instanceof ny5) {
                    ny5 ny5Var = (ny5) B;
                    if (ny5Var.getThreadData() != null && ny5Var.getThreadData().getTid().equals(str)) {
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

    public void u() {
        k55 k55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (k55Var = this.j) == null) {
            return;
        }
        k55Var.dettachView(this.c);
    }

    public void v() {
        l55 l55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (l55Var = this.h) == null) {
            return;
        }
        l55Var.dettachView(this.m);
        this.h = null;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.addOnScrollListener(this.B);
            this.d.setRecyclerListener(this.A);
            this.f.g(this.w);
            this.f.m(this.x);
            this.f.b0(this.b.getUniqueId());
            J();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            View inflate = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0896, (ViewGroup) null);
            this.c = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0923e8);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f0923eb);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.b.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.d.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.p = new iu6(this.m, this.d);
            if (this.a.getArguments() != null) {
                this.p.p(this.a.getArguments().getString("tab_name"));
            }
            this.p.o(this.b);
            i68 i68Var = new i68(this.b, this.d);
            this.n = i68Var;
            i68Var.v(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.n.u(this.v);
            this.e = (BigdaySwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0923ec);
            ky6 ky6Var = new ky6(this.b);
            this.f = ky6Var;
            this.e.setProgressView(ky6Var);
            int i = (int) (this.b.getResources().getDisplayMetrics().density * 86.0f);
            this.e.setCustomDistances(i, i, i * 2);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.i = pbListView;
            pbListView.a();
            this.i.p(R.color.transparent);
            this.i.t(pi.f(this.b.getPageActivity(), R.dimen.tbds178));
            this.i.x();
            this.i.G(R.dimen.tbfontsize36);
            this.i.E(SkinManager.getColor(R.color.CAM_X0109));
            this.i.A(R.color.CAM_X0110);
            this.i.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            b27 b27Var = new b27(this.b, this.d);
            this.k = b27Var;
            b27Var.g(this.o);
            this.k.h(this.v);
            bz6 bz6Var = new bz6();
            this.g = bz6Var;
            bz6Var.a(this.v);
            this.k.i(this.g);
            this.l = this.c.findViewById(R.id.obfuscated_res_0x7f0923e5);
            n();
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            k55 k55Var = this.j;
            if (k55Var == null) {
                return false;
            }
            return k55Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void z() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
    }
}
