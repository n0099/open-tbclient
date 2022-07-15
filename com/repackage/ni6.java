package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ni6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<an> a;
    public BdTypeRecyclerView b;
    public qi6 c;
    public pi6 d;
    public oi6 e;

    public ni6(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumRulesShowActivity, bdTypeRecyclerView) == null) {
            this.b = bdTypeRecyclerView;
            this.c = new qi6(forumRulesShowActivity, ui6.m);
            this.d = new pi6(forumRulesShowActivity, vi6.d);
            this.e = new oi6(forumRulesShowActivity, ti6.f);
            this.a.add(this.c);
            this.a.add(this.d);
            this.a.add(this.e);
            bdTypeRecyclerView.a(this.a);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    public void c(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            pi6 pi6Var = this.d;
            if (pi6Var != null) {
                pi6Var.d0(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            qi6 qi6Var = this.c;
            if (qi6Var != null) {
                qi6Var.setFrom(str);
            }
            oi6 oi6Var = this.e;
            if (oi6Var != null) {
                oi6Var.setFrom(str);
            }
        }
    }
}
