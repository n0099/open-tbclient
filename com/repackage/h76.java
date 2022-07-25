package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.or4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h76 extends mr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext k;
    public Context l;
    public ViewEventCenter m;
    public final or4 n;
    public c56 o;
    public final List<kr4> p;
    public final or4.e q;

    /* loaded from: classes6.dex */
    public class a implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h76 a;

        public a(h76 h76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h76Var;
        }

        @Override // com.repackage.or4.e
        public void N(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                this.a.dismiss();
                if (!ni.z()) {
                    pi.N(this.a.l, R.string.obfuscated_res_0x7f0f0c18);
                } else if (i == 2) {
                    this.a.m.dispatchMvcEvent(new y75(4, this.a.o, null, null));
                } else if (i == 1) {
                    this.a.m.dispatchMvcEvent(new y75(13, this.a.o, null, null));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h76(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.k = tbPageContext;
        this.l = tbPageContext.getPageActivity();
        this.m = viewEventCenter;
        this.p = new ArrayList();
        or4 or4Var = new or4(this.l);
        this.n = or4Var;
        or4Var.n(this.q);
        i(this.n);
    }

    public final void q() {
        List<kr4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.o == null || (list = this.p) == null || this.n == null) {
            return;
        }
        list.clear();
        this.p.add(new kr4(1, r(this.o.k() == 1 ? R.string.obfuscated_res_0x7f0f0376 : R.string.obfuscated_res_0x7f0f13f4, new Object[0]), this.n));
        this.p.add(new kr4(2, r(R.string.obfuscated_res_0x7f0f049e, new Object[0]), this.n));
        this.n.j(this.p);
    }

    public final String r(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, objArr)) == null) {
            Context context = this.l;
            if (context == null) {
                return null;
            }
            return context.getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public void s() {
        or4 or4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (or4Var = this.n) == null) {
            return;
        }
        or4Var.i();
    }

    public void t(c56 c56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c56Var) == null) {
            this.o = c56Var;
            q();
        }
    }
}
