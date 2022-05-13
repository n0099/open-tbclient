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
/* loaded from: classes7.dex */
public class wo4 implements Comparable<wo4> {
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

    public wo4(int i, int i2) {
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

    public static wo4 b(TbLinkSpanGroup tbLinkSpanGroup, hs6 hs6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, hs6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            wo4 wo4Var = new wo4(tbLinkSpanGroup.e(), 2);
            if (hs6Var == null) {
                return wo4Var;
            }
            if (TextUtils.isEmpty(hs6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f157b);
            } else {
                str = hs6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f040d);
            }
            wo4Var.d = str;
            wo4Var.c = hs6Var.c();
            wo4Var.m = hs6Var.a();
            if (!ListUtils.isEmpty(hs6Var.b()) && hs6Var.b().get(0) != null) {
                wo4Var.e = hs6Var.b().get(0).a();
            }
            wo4Var.l = hs6Var.f();
            wo4Var.f = hs6Var.d();
            if (hs6Var.e() != null) {
                wo4Var.j = hs6Var.e().a();
                wo4Var.k = hs6Var.e().b();
            }
            tbLinkSpanGroup.y(wo4Var);
            return wo4Var;
        }
        return (wo4) invokeLL.objValue;
    }

    public static wo4 c(TbLinkSpanGroup tbLinkSpanGroup, xv4 xv4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, xv4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            wo4 wo4Var = new wo4(tbLinkSpanGroup.e(), 1);
            if (xv4Var == null) {
                return wo4Var;
            }
            wo4Var.c = xv4Var.e;
            wo4Var.e = xv4Var.d;
            wo4Var.l = xv4Var.f;
            wo4Var.f = xv4Var.g;
            wo4Var.g = xv4Var.c;
            wo4Var.n = xv4Var.h;
            String str = xv4Var.i;
            wo4Var.i = xv4Var.b == 1;
            wo4Var.o = xv4Var.b;
            tbLinkSpanGroup.y(wo4Var);
            return wo4Var;
        }
        return (wo4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull wo4 wo4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wo4Var)) == null) ? this.p - wo4Var.p : invokeL.intValue;
    }
}
