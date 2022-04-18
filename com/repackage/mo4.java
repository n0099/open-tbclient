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
public class mo4 implements Comparable<mo4> {
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

    public mo4(int i, int i2) {
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

    public static mo4 b(TbLinkSpanGroup tbLinkSpanGroup, ht6 ht6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, ht6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            mo4 mo4Var = new mo4(tbLinkSpanGroup.e(), 2);
            if (ht6Var == null) {
                return mo4Var;
            }
            if (TextUtils.isEmpty(ht6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f154e);
            } else {
                str = ht6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0407);
            }
            mo4Var.d = str;
            mo4Var.c = ht6Var.c();
            mo4Var.m = ht6Var.a();
            if (!ListUtils.isEmpty(ht6Var.b()) && ht6Var.b().get(0) != null) {
                mo4Var.e = ht6Var.b().get(0).a();
            }
            mo4Var.l = ht6Var.f();
            mo4Var.f = ht6Var.d();
            if (ht6Var.e() != null) {
                mo4Var.j = ht6Var.e().a();
                mo4Var.k = ht6Var.e().b();
            }
            tbLinkSpanGroup.y(mo4Var);
            return mo4Var;
        }
        return (mo4) invokeLL.objValue;
    }

    public static mo4 c(TbLinkSpanGroup tbLinkSpanGroup, kv4 kv4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, kv4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            mo4 mo4Var = new mo4(tbLinkSpanGroup.e(), 1);
            if (kv4Var == null) {
                return mo4Var;
            }
            mo4Var.c = kv4Var.e;
            mo4Var.e = kv4Var.d;
            mo4Var.l = kv4Var.f;
            mo4Var.f = kv4Var.g;
            mo4Var.g = kv4Var.c;
            mo4Var.n = kv4Var.h;
            String str = kv4Var.i;
            mo4Var.i = kv4Var.b == 1;
            mo4Var.o = kv4Var.b;
            tbLinkSpanGroup.y(mo4Var);
            return mo4Var;
        }
        return (mo4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull mo4 mo4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mo4Var)) == null) ? this.p - mo4Var.p : invokeL.intValue;
    }
}
