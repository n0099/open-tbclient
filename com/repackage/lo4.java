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
public class lo4 implements Comparable<lo4> {
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

    public lo4(int i, int i2) {
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

    public static lo4 b(TbLinkSpanGroup tbLinkSpanGroup, cs6 cs6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, cs6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            lo4 lo4Var = new lo4(tbLinkSpanGroup.e(), 2);
            if (cs6Var == null) {
                return lo4Var;
            }
            if (TextUtils.isEmpty(cs6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f154c);
            } else {
                str = cs6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0408);
            }
            lo4Var.d = str;
            lo4Var.c = cs6Var.c();
            lo4Var.m = cs6Var.a();
            if (!ListUtils.isEmpty(cs6Var.b()) && cs6Var.b().get(0) != null) {
                lo4Var.e = cs6Var.b().get(0).a();
            }
            lo4Var.l = cs6Var.f();
            lo4Var.f = cs6Var.d();
            if (cs6Var.e() != null) {
                lo4Var.j = cs6Var.e().a();
                lo4Var.k = cs6Var.e().b();
            }
            tbLinkSpanGroup.y(lo4Var);
            return lo4Var;
        }
        return (lo4) invokeLL.objValue;
    }

    public static lo4 c(TbLinkSpanGroup tbLinkSpanGroup, wv4 wv4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, wv4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            lo4 lo4Var = new lo4(tbLinkSpanGroup.e(), 1);
            if (wv4Var == null) {
                return lo4Var;
            }
            int i = wv4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = wv4Var.j;
                if (cardLinkInfoData != null) {
                    lo4Var.p = cardLinkInfoData;
                    lo4Var.c = cardLinkInfoData.title;
                    lo4Var.e = cardLinkInfoData.imageUrl;
                    lo4Var.l = cardLinkInfoData.tagText;
                    lo4Var.g = cardLinkInfoData.url;
                    lo4Var.i = false;
                    lo4Var.o = i;
                }
            } else {
                lo4Var.c = wv4Var.e;
                lo4Var.e = wv4Var.d;
                lo4Var.l = wv4Var.f;
                lo4Var.f = wv4Var.g;
                lo4Var.g = wv4Var.c;
                lo4Var.n = wv4Var.h;
                String str = wv4Var.i;
                lo4Var.i = i == 1;
                lo4Var.o = wv4Var.b;
            }
            tbLinkSpanGroup.y(lo4Var);
            return lo4Var;
        }
        return (lo4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull lo4 lo4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lo4Var)) == null) ? this.q - lo4Var.q : invokeL.intValue;
    }
}
