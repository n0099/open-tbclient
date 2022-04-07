package com.repackage;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ho> b;
    public zo c;
    public b66 d;
    public c66 e;
    public d66 f;
    public List<uo> g;
    public rx5<BaseCardInfo> h;

    /* loaded from: classes5.dex */
    public class a extends rx5<BaseCardInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a66 b;

        public a(a66 a66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a66Var;
        }

        @Override // com.repackage.rx5
        public void a(View view2, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) && baseCardInfo != null && (baseCardInfo instanceof h66)) {
                ArrayList arrayList = new ArrayList();
                String title = ((h66) baseCardInfo).getTitle();
                for (uo uoVar : this.b.g) {
                    if (uoVar instanceof h66) {
                        h66 h66Var = (h66) uoVar;
                        if (title.equals(h66Var.getTitle())) {
                            List<g66> q = h66Var.q();
                            arrayList.add(uoVar);
                            arrayList.addAll(q);
                        } else {
                            List<g66> m = h66Var.m();
                            arrayList.add(uoVar);
                            arrayList.addAll(m);
                        }
                    }
                }
                i66 i66Var = new i66();
                i66Var.a = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(i66Var);
                if (arrayList.size() > 0) {
                    this.b.c.setData(arrayList);
                }
            }
        }
    }

    public a66(TbPageContext tbPageContext, zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.a = tbPageContext;
        this.c = zoVar;
        c();
        this.c.a(this.b);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            b66 b66Var = new b66(this.a);
            this.d = b66Var;
            this.b.add(b66Var);
            c66 c66Var = new c66(this.a, this.h);
            this.e = c66Var;
            this.b.add(c66Var);
            d66 d66Var = new d66(this.a);
            this.f = d66Var;
            this.b.add(d66Var);
        }
    }

    public void d() {
        zo zoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (zoVar = this.c) == null) {
            return;
        }
        zoVar.getListAdapter().notifyDataSetChanged();
    }

    public void e(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.g = list;
            this.c.setData(list);
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            for (ho hoVar : this.b) {
                hoVar.X(bdUniqueId);
            }
        }
    }
}
