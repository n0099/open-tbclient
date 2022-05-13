package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yr4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class qe6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wr4 a;
    public yr4 b;
    public String c;
    public String[] d;
    public String e;
    public yr4.e f;
    public b9 g;

    public qe6(b9 b9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = b9Var;
    }

    public static qe6 c(b9 b9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, b9Var)) == null) ? new qe6(b9Var) : (qe6) invokeL.objValue;
    }

    public final List<ur4> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                ur4 ur4Var = new ur4(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    ur4Var.q(R.color.CAM_X0304);
                    ur4Var.p();
                }
                arrayList.add(ur4Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        wr4 wr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (wr4Var = this.a) == null) {
            return;
        }
        wr4Var.dismiss();
    }

    public qe6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (qe6) invokeL.objValue;
    }

    public qe6 e(yr4.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f = eVar;
            return this;
        }
        return (qe6) invokeL.objValue;
    }

    public qe6 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (qe6) invokeL.objValue;
    }

    public qe6 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (qe6) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            yr4 yr4Var = new yr4(this.g.getPageActivity());
            this.b = yr4Var;
            yr4Var.q(this.c);
            this.b.n(this.f);
            this.b.j(a(this.d));
            this.b.l(mi.f(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f070712));
            wr4 wr4Var = new wr4(this.g, this.b);
            this.a = wr4Var;
            wr4Var.m();
        }
    }
}
