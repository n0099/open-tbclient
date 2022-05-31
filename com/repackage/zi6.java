package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class zi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public BdTypeRecyclerView b;
    public mb6 c;
    public List<wm> d;
    public ej6 e;
    public lj6 f;
    public gj6 g;
    public kj6 h;
    public fj6 i;
    public jj6 j;
    public hj6 k;
    public ij6 l;
    public xf6 m;
    public jf6 n;
    public uf6 o;
    public rf6 p;
    public if6 q;
    public sf6 r;
    public dj6 s;

    /* loaded from: classes7.dex */
    public class a extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi6 b;

        public a(zi6 zi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi6 b;

        public b(zi6 zi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi6 b;

        public c(zi6 zi6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zi6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    public zi6(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LinkedList();
        c(frsItemTabFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
    }

    public final void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new wt4(4, threadData.getPositionInFrsItemTab(), 1)));
    }

    public void c(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsItemTabFragment, bdTypeRecyclerView) == null) {
            this.a = frsItemTabFragment;
            this.g = new gj6(frsItemTabFragment.getPageContext(), vj6.b, frsItemTabFragment.getUniqueId());
            this.h = new kj6(frsItemTabFragment.getPageContext(), wj6.b, frsItemTabFragment.getUniqueId());
            this.f = new lj6(frsItemTabFragment.getPageContext(), xj6.b, frsItemTabFragment.getUniqueId());
            this.e = new ej6(frsItemTabFragment.getPageContext(), tj6.b, frsItemTabFragment.getUniqueId());
            this.i = new fj6(frsItemTabFragment.getPageContext(), uj6.c, frsItemTabFragment.getUniqueId());
            this.j = new jj6(frsItemTabFragment.getPageContext(), sj6.c, frsItemTabFragment.getUniqueId());
            this.k = new hj6(frsItemTabFragment.getPageContext(), sj6.d, frsItemTabFragment.getUniqueId());
            this.l = new ij6(frsItemTabFragment.getPageContext(), sj6.e, frsItemTabFragment.getUniqueId());
            xf6 xf6Var = new xf6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_USER_NORMAL, frsItemTabFragment.getUniqueId());
            this.m = xf6Var;
            xf6Var.g0(true);
            this.m.setFrom(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK);
            jf6 jf6Var = new jf6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsItemTabFragment.getUniqueId());
            this.n = jf6Var;
            jf6Var.i0(new a(this));
            uf6 uf6Var = new uf6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsItemTabFragment.getUniqueId());
            this.o = uf6Var;
            uf6Var.i0(new b(this));
            rf6 rf6Var = new rf6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsItemTabFragment.getUniqueId());
            this.p = rf6Var;
            rf6Var.i0(new c(this));
            this.q = new if6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, frsItemTabFragment.getUniqueId());
            this.r = new sf6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsItemTabFragment.getUniqueId());
            this.c = new mb6(frsItemTabFragment.getPageContext(), nb6.b);
            this.s = new dj6(frsItemTabFragment.getPageContext().getPageActivity(), rj6.c);
            this.d.add(this.i);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.d.add(this.j);
            this.d.add(this.k);
            this.d.add(this.l);
            this.d.add(this.m);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.r);
            this.d.add(this.c);
            this.d.add(this.s);
            for (wm wmVar : this.d) {
                if (wmVar instanceof fb6) {
                    ((fb6) wmVar).h0(bdTypeRecyclerView);
                }
                if (wmVar instanceof lw5) {
                    ((lw5) wmVar).r(frsItemTabFragment.a);
                }
            }
            i();
            bdTypeRecyclerView.a(this.d);
            j();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e() {
        fj6 fj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fj6Var = this.i) == null) {
            return;
        }
        fj6Var.H();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (wm wmVar : this.d) {
                if (wmVar instanceof fb6) {
                    ((fb6) wmVar).c0();
                } else if (wmVar instanceof h78) {
                    ((h78) wmVar).onDestroy();
                }
            }
        }
    }

    public void g(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            i();
            this.b.setData(arrayList);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        dj6 dj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (dj6Var = this.s) == null) {
            return;
        }
        dj6Var.b0(bdUniqueId);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null || ListUtils.isEmpty(this.d)) {
            return;
        }
        for (wm wmVar : this.d) {
            if (wmVar instanceof pm6) {
                pm6 pm6Var = (pm6) wmVar;
                if (pm6Var.i() != null) {
                    pm6Var.i().a = this.a.f;
                    pm6Var.i().c = this.a.d;
                    pm6Var.i().d = this.a.e;
                    pm6Var.i().e = this.a.a;
                    pm6Var.i().h = this.a.b;
                }
            }
        }
    }
}
