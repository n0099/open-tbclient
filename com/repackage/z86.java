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
import com.repackage.fs4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class z86 extends ds4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext k;
    public Context l;
    public ViewEventCenter m;
    public final fs4 n;
    public u66 o;
    public final List<bs4> p;
    public final fs4.e q;

    /* loaded from: classes7.dex */
    public class a implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        public a(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z86Var;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.a.dismiss();
                if (!oi.z()) {
                    qi.M(this.a.l, R.string.obfuscated_res_0x7f0f0c3e);
                } else if (i == 2) {
                    this.a.m.dispatchMvcEvent(new w85(4, this.a.o, null, null));
                } else if (i == 1) {
                    this.a.m.dispatchMvcEvent(new w85(13, this.a.o, null, null));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z86(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
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
        fs4 fs4Var = new fs4(this.l);
        this.n = fs4Var;
        fs4Var.n(this.q);
        h(this.n);
    }

    public final void o() {
        List<bs4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.o == null || (list = this.p) == null || this.n == null) {
            return;
        }
        list.clear();
        this.p.add(new bs4(1, p(this.o.l() == 1 ? R.string.obfuscated_res_0x7f0f037c : R.string.obfuscated_res_0x7f0f1434, new Object[0]), this.n));
        this.p.add(new bs4(2, p(R.string.obfuscated_res_0x7f0f04ab, new Object[0]), this.n));
        this.n.j(this.p);
    }

    public final String p(int i, Object... objArr) {
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

    public void q() {
        fs4 fs4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fs4Var = this.n) == null) {
            return;
        }
        fs4Var.i();
    }

    public void r(u66 u66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, u66Var) == null) {
            this.o = u66Var;
            o();
        }
    }
}
