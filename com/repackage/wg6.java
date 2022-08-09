package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
public class wg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ds4 a;
    public fs4 b;
    public String c;
    public String[] d;
    public String e;
    public fs4.e f;
    public d9 g;

    public wg6(d9 d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = d9Var;
    }

    public static wg6 c(d9 d9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, d9Var)) == null) ? new wg6(d9Var) : (wg6) invokeL.objValue;
    }

    public final List<bs4> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                bs4 bs4Var = new bs4(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    bs4Var.q(R.color.CAM_X0304);
                    bs4Var.p();
                }
                arrayList.add(bs4Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        ds4 ds4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ds4Var = this.a) == null) {
            return;
        }
        ds4Var.dismiss();
    }

    public wg6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (wg6) invokeL.objValue;
    }

    public wg6 e(fs4.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f = eVar;
            return this;
        }
        return (wg6) invokeL.objValue;
    }

    public wg6 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (wg6) invokeL.objValue;
    }

    public wg6 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (wg6) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            fs4 fs4Var = new fs4(this.g.getPageActivity());
            this.b = fs4Var;
            fs4Var.q(this.c);
            this.b.n(this.f);
            this.b.j(a(this.d));
            this.b.l(qi.f(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f07075d));
            ds4 ds4Var = new ds4(this.g, this.b);
            this.a = ds4Var;
            ds4Var.k();
        }
    }
}
