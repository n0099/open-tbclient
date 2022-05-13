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
import com.repackage.yr4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class y66 extends wr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext k;
    public Context l;
    public ViewEventCenter m;
    public final yr4 n;
    public s46 o;
    public final List<ur4> p;
    public final yr4.e q;

    /* loaded from: classes7.dex */
    public class a implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y66 a;

        public a(y66 y66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y66Var;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                this.a.dismiss();
                if (!ki.z()) {
                    mi.M(this.a.l, R.string.obfuscated_res_0x7f0f0c2e);
                } else if (i == 2) {
                    this.a.m.dispatchMvcEvent(new i75(4, this.a.o, null, null));
                } else if (i == 1) {
                    this.a.m.dispatchMvcEvent(new i75(13, this.a.o, null, null));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y66(TbPageContext tbPageContext, ViewEventCenter viewEventCenter) {
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
                super((b9) newInitContext.callArgs[0]);
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
        yr4 yr4Var = new yr4(this.l);
        this.n = yr4Var;
        yr4Var.n(this.q);
        i(this.n);
    }

    public final void q() {
        List<ur4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.o == null || (list = this.p) == null || this.n == null) {
            return;
        }
        list.clear();
        this.p.add(new ur4(1, r(this.o.m() == 1 ? R.string.obfuscated_res_0x7f0f037f : R.string.obfuscated_res_0x7f0f142c, new Object[0]), this.n));
        this.p.add(new ur4(2, r(R.string.obfuscated_res_0x7f0f049d, new Object[0]), this.n));
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
        yr4 yr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (yr4Var = this.n) == null) {
            return;
        }
        yr4Var.i();
    }

    public void t(s46 s46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s46Var) == null) {
            this.o = s46Var;
            q();
        }
    }
}
