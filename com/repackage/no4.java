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
public class no4 implements Comparable<no4> {
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

    public no4(int i, int i2) {
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

    public static no4 b(TbLinkSpanGroup tbLinkSpanGroup, ft6 ft6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, ft6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            no4 no4Var = new no4(tbLinkSpanGroup.e(), 2);
            if (ft6Var == null) {
                return no4Var;
            }
            if (TextUtils.isEmpty(ft6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f154f);
            } else {
                str = ft6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0407);
            }
            no4Var.d = str;
            no4Var.c = ft6Var.c();
            no4Var.m = ft6Var.a();
            if (!ListUtils.isEmpty(ft6Var.b()) && ft6Var.b().get(0) != null) {
                no4Var.e = ft6Var.b().get(0).a();
            }
            no4Var.l = ft6Var.f();
            no4Var.f = ft6Var.d();
            if (ft6Var.e() != null) {
                no4Var.j = ft6Var.e().a();
                no4Var.k = ft6Var.e().b();
            }
            tbLinkSpanGroup.y(no4Var);
            return no4Var;
        }
        return (no4) invokeLL.objValue;
    }

    public static no4 c(TbLinkSpanGroup tbLinkSpanGroup, lv4 lv4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, lv4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            no4 no4Var = new no4(tbLinkSpanGroup.e(), 1);
            if (lv4Var == null) {
                return no4Var;
            }
            no4Var.c = lv4Var.e;
            no4Var.e = lv4Var.d;
            no4Var.l = lv4Var.f;
            no4Var.f = lv4Var.g;
            no4Var.g = lv4Var.c;
            no4Var.n = lv4Var.h;
            String str = lv4Var.i;
            no4Var.i = lv4Var.b == 1;
            no4Var.o = lv4Var.b;
            tbLinkSpanGroup.y(no4Var);
            return no4Var;
        }
        return (no4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull no4 no4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, no4Var)) == null) ? this.p - no4Var.p : invokeL.intValue;
    }
}
