package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vn4 implements Comparable<vn4> {
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
    public CardLinkInfoData p;
    public int q;

    public vn4(int i, int i2) {
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

    public static vn4 b(TbLinkSpanGroup tbLinkSpanGroup, or6 or6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, or6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            vn4 vn4Var = new vn4(tbLinkSpanGroup.e(), 2);
            if (or6Var == null) {
                return vn4Var;
            }
            if (TextUtils.isEmpty(or6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f159b);
            } else {
                str = or6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0402);
            }
            vn4Var.d = str;
            vn4Var.c = or6Var.c();
            vn4Var.m = or6Var.a();
            if (!ListUtils.isEmpty(or6Var.b()) && or6Var.b().get(0) != null) {
                vn4Var.e = or6Var.b().get(0).a();
            }
            vn4Var.l = or6Var.f();
            vn4Var.f = or6Var.d();
            if (or6Var.e() != null) {
                vn4Var.j = or6Var.e().a();
                vn4Var.k = or6Var.e().b();
            }
            tbLinkSpanGroup.y(vn4Var);
            return vn4Var;
        }
        return (vn4) invokeLL.objValue;
    }

    public static vn4 c(TbLinkSpanGroup tbLinkSpanGroup, xu4 xu4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, xu4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            vn4 vn4Var = new vn4(tbLinkSpanGroup.e(), 1);
            if (xu4Var == null) {
                return vn4Var;
            }
            int i = xu4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = xu4Var.j;
                if (cardLinkInfoData != null) {
                    vn4Var.p = cardLinkInfoData;
                    vn4Var.c = cardLinkInfoData.title;
                    vn4Var.e = cardLinkInfoData.imageUrl;
                    vn4Var.l = cardLinkInfoData.tagText;
                    vn4Var.g = cardLinkInfoData.url;
                    vn4Var.i = false;
                    vn4Var.o = i;
                }
            } else {
                vn4Var.c = xu4Var.e;
                vn4Var.e = xu4Var.d;
                vn4Var.l = xu4Var.f;
                vn4Var.f = xu4Var.g;
                vn4Var.g = xu4Var.c;
                vn4Var.n = xu4Var.h;
                String str = xu4Var.i;
                vn4Var.i = i == 1;
                vn4Var.o = xu4Var.b;
            }
            tbLinkSpanGroup.y(vn4Var);
            return vn4Var;
        }
        return (vn4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull vn4 vn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vn4Var)) == null) ? this.q - vn4Var.q : invokeL.intValue;
    }
}
