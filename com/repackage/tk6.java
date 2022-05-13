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
public class tk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public BdTypeRecyclerView b;
    public wc6 c;
    public List<eo> d;
    public yk6 e;
    public fl6 f;
    public al6 g;
    public el6 h;
    public zk6 i;
    public dl6 j;
    public bl6 k;
    public cl6 l;
    public gh6 m;
    public sg6 n;
    public dh6 o;
    public ah6 p;
    public rg6 q;
    public bh6 r;
    public xk6 s;

    /* loaded from: classes7.dex */
    public class a extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tk6 b;

        public a(tk6 tk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
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
    public class b extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tk6 b;

        public b(tk6 tk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
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
    public class c extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tk6 b;

        public c(tk6 tk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void b(View view2, ThreadData threadData, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData, obj) == null) {
                super.b(view2, threadData, obj);
                this.b.b(threadData);
            }
        }
    }

    public tk6(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new gv4(4, threadData.getPositionInFrsItemTab(), 1)));
    }

    public void c(FrsItemTabFragment frsItemTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsItemTabFragment, bdTypeRecyclerView) == null) {
            this.a = frsItemTabFragment;
            this.g = new al6(frsItemTabFragment.getPageContext(), pl6.b, frsItemTabFragment.getUniqueId());
            this.h = new el6(frsItemTabFragment.getPageContext(), ql6.b, frsItemTabFragment.getUniqueId());
            this.f = new fl6(frsItemTabFragment.getPageContext(), rl6.b, frsItemTabFragment.getUniqueId());
            this.e = new yk6(frsItemTabFragment.getPageContext(), nl6.b, frsItemTabFragment.getUniqueId());
            this.i = new zk6(frsItemTabFragment.getPageContext(), ol6.c, frsItemTabFragment.getUniqueId());
            this.j = new dl6(frsItemTabFragment.getPageContext(), ml6.c, frsItemTabFragment.getUniqueId());
            this.k = new bl6(frsItemTabFragment.getPageContext(), ml6.d, frsItemTabFragment.getUniqueId());
            this.l = new cl6(frsItemTabFragment.getPageContext(), ml6.e, frsItemTabFragment.getUniqueId());
            gh6 gh6Var = new gh6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_USER_NORMAL, frsItemTabFragment.getUniqueId());
            this.m = gh6Var;
            gh6Var.g0(true);
            this.m.setFrom(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK);
            sg6 sg6Var = new sg6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsItemTabFragment.getUniqueId());
            this.n = sg6Var;
            sg6Var.i0(new a(this));
            dh6 dh6Var = new dh6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsItemTabFragment.getUniqueId());
            this.o = dh6Var;
            dh6Var.i0(new b(this));
            ah6 ah6Var = new ah6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsItemTabFragment.getUniqueId());
            this.p = ah6Var;
            ah6Var.i0(new c(this));
            this.q = new rg6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, frsItemTabFragment.getUniqueId());
            this.r = new bh6(frsItemTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsItemTabFragment.getUniqueId());
            this.c = new wc6(frsItemTabFragment.getPageContext(), xc6.b);
            this.s = new xk6(frsItemTabFragment.getPageContext().getPageActivity(), ll6.c);
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
            for (eo eoVar : this.d) {
                if (eoVar instanceof pc6) {
                    ((pc6) eoVar).h0(bdTypeRecyclerView);
                }
                if (eoVar instanceof sx5) {
                    ((sx5) eoVar).r(frsItemTabFragment.a);
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
        zk6 zk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (zk6Var = this.i) == null) {
            return;
        }
        zk6Var.H();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (eo eoVar : this.d) {
                if (eoVar instanceof pc6) {
                    ((pc6) eoVar).c0();
                } else if (eoVar instanceof aa8) {
                    ((aa8) eoVar).onDestroy();
                }
            }
        }
    }

    public void g(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            i();
            this.b.setData(arrayList);
        }
    }

    public void h(BdUniqueId bdUniqueId) {
        xk6 xk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (xk6Var = this.s) == null) {
            return;
        }
        xk6Var.b0(bdUniqueId);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof pc6) {
                ((pc6) eoVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null || ListUtils.isEmpty(this.d)) {
            return;
        }
        for (eo eoVar : this.d) {
            if (eoVar instanceof jo6) {
                jo6 jo6Var = (jo6) eoVar;
                if (jo6Var.i() != null) {
                    jo6Var.i().a = this.a.f;
                    jo6Var.i().c = this.a.d;
                    jo6Var.i().d = this.a.e;
                    jo6Var.i().e = this.a.a;
                    jo6Var.i().h = this.a.b;
                }
            }
        }
    }
}
