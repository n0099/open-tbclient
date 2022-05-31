package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oq4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mq4 a;
    public oq4 b;
    public String c;
    public String[] d;
    public String e;
    public oq4.e f;
    public b9 g;

    public hd6(b9 b9Var) {
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

    public static hd6 c(b9 b9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, b9Var)) == null) ? new hd6(b9Var) : (hd6) invokeL.objValue;
    }

    public final List<kq4> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                kq4 kq4Var = new kq4(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    kq4Var.q(R.color.CAM_X0304);
                    kq4Var.p();
                }
                arrayList.add(kq4Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        mq4 mq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mq4Var = this.a) == null) {
            return;
        }
        mq4Var.dismiss();
    }

    public hd6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (hd6) invokeL.objValue;
    }

    public hd6 e(oq4.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f = eVar;
            return this;
        }
        return (hd6) invokeL.objValue;
    }

    public hd6 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (hd6) invokeL.objValue;
    }

    public hd6 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (hd6) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            oq4 oq4Var = new oq4(this.g.getPageActivity());
            this.b = oq4Var;
            oq4Var.q(this.c);
            this.b.n(this.f);
            this.b.j(a(this.d));
            this.b.l(li.f(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f070712));
            mq4 mq4Var = new mq4(this.g, this.b);
            this.a = mq4Var;
            mq4Var.m();
        }
    }
}
