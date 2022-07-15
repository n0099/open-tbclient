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
/* loaded from: classes6.dex */
public class ko4 implements Comparable<ko4> {
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

    public ko4(int i, int i2) {
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

    public static ko4 b(TbLinkSpanGroup tbLinkSpanGroup, cs6 cs6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, cs6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ko4 ko4Var = new ko4(tbLinkSpanGroup.e(), 2);
            if (cs6Var == null) {
                return ko4Var;
            }
            if (TextUtils.isEmpty(cs6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f159d);
            } else {
                str = cs6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0409);
            }
            ko4Var.d = str;
            ko4Var.c = cs6Var.c();
            ko4Var.m = cs6Var.a();
            if (!ListUtils.isEmpty(cs6Var.b()) && cs6Var.b().get(0) != null) {
                ko4Var.e = cs6Var.b().get(0).a();
            }
            ko4Var.l = cs6Var.f();
            ko4Var.f = cs6Var.d();
            if (cs6Var.e() != null) {
                ko4Var.j = cs6Var.e().a();
                ko4Var.k = cs6Var.e().b();
            }
            tbLinkSpanGroup.y(ko4Var);
            return ko4Var;
        }
        return (ko4) invokeLL.objValue;
    }

    public static ko4 c(TbLinkSpanGroup tbLinkSpanGroup, vv4 vv4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, vv4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ko4 ko4Var = new ko4(tbLinkSpanGroup.e(), 1);
            if (vv4Var == null) {
                return ko4Var;
            }
            int i = vv4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = vv4Var.j;
                if (cardLinkInfoData != null) {
                    ko4Var.p = cardLinkInfoData;
                    ko4Var.c = cardLinkInfoData.title;
                    ko4Var.e = cardLinkInfoData.imageUrl;
                    ko4Var.l = cardLinkInfoData.tagText;
                    ko4Var.g = cardLinkInfoData.url;
                    ko4Var.i = false;
                    ko4Var.o = i;
                }
            } else {
                ko4Var.c = vv4Var.e;
                ko4Var.e = vv4Var.d;
                ko4Var.l = vv4Var.f;
                ko4Var.f = vv4Var.g;
                ko4Var.g = vv4Var.c;
                ko4Var.n = vv4Var.h;
                String str = vv4Var.i;
                ko4Var.i = i == 1;
                ko4Var.o = vv4Var.b;
            }
            tbLinkSpanGroup.y(ko4Var);
            return ko4Var;
        }
        return (ko4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ko4 ko4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ko4Var)) == null) ? this.q - ko4Var.q : invokeL.intValue;
    }
}
