package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ln4 implements Comparable<ln4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public int p;

    public ln4(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
    }

    public static ln4 b(TbLinkSpanGroup tbLinkSpanGroup, lq6 lq6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, lq6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ln4 ln4Var = new ln4(tbLinkSpanGroup.e(), 2);
            if (lq6Var == null) {
                return ln4Var;
            }
            if (TextUtils.isEmpty(lq6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1592);
            } else {
                str = lq6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0411);
            }
            ln4Var.d = str;
            ln4Var.c = lq6Var.c();
            ln4Var.m = lq6Var.a();
            if (!ListUtils.isEmpty(lq6Var.b()) && lq6Var.b().get(0) != null) {
                ln4Var.e = lq6Var.b().get(0).a();
            }
            ln4Var.l = lq6Var.f();
            ln4Var.f = lq6Var.d();
            if (lq6Var.e() != null) {
                ln4Var.j = lq6Var.e().a();
                ln4Var.k = lq6Var.e().b();
            }
            tbLinkSpanGroup.y(ln4Var);
            return ln4Var;
        }
        return (ln4) invokeLL.objValue;
    }

    public static ln4 c(TbLinkSpanGroup tbLinkSpanGroup, nu4 nu4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, nu4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ln4 ln4Var = new ln4(tbLinkSpanGroup.e(), 1);
            if (nu4Var == null) {
                return ln4Var;
            }
            ln4Var.c = nu4Var.e;
            ln4Var.e = nu4Var.d;
            ln4Var.l = nu4Var.f;
            ln4Var.f = nu4Var.g;
            ln4Var.g = nu4Var.c;
            ln4Var.n = nu4Var.h;
            String str = nu4Var.i;
            ln4Var.i = nu4Var.b == 1;
            ln4Var.o = nu4Var.b;
            tbLinkSpanGroup.y(ln4Var);
            return ln4Var;
        }
        return (ln4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ln4 ln4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ln4Var)) == null) ? this.p - ln4Var.p : invokeL.intValue;
    }
}
