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
public class cp4 implements Comparable<cp4> {
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

    public cp4(int i, int i2) {
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

    public static cp4 b(TbLinkSpanGroup tbLinkSpanGroup, vt6 vt6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, vt6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            cp4 cp4Var = new cp4(tbLinkSpanGroup.e(), 2);
            if (vt6Var == null) {
                return cp4Var;
            }
            if (TextUtils.isEmpty(vt6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1593);
            } else {
                str = vt6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0413);
            }
            cp4Var.d = str;
            cp4Var.c = vt6Var.c();
            cp4Var.m = vt6Var.a();
            if (!ListUtils.isEmpty(vt6Var.b()) && vt6Var.b().get(0) != null) {
                cp4Var.e = vt6Var.b().get(0).a();
            }
            cp4Var.l = vt6Var.f();
            cp4Var.f = vt6Var.d();
            if (vt6Var.e() != null) {
                cp4Var.j = vt6Var.e().a();
                cp4Var.k = vt6Var.e().b();
            }
            tbLinkSpanGroup.A(cp4Var);
            return cp4Var;
        }
        return (cp4) invokeLL.objValue;
    }

    public static cp4 c(TbLinkSpanGroup tbLinkSpanGroup, qw4 qw4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, qw4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            cp4 cp4Var = new cp4(tbLinkSpanGroup.e(), 1);
            if (qw4Var == null) {
                return cp4Var;
            }
            int i = qw4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = qw4Var.j;
                if (cardLinkInfoData != null) {
                    cp4Var.p = cardLinkInfoData;
                    cp4Var.c = cardLinkInfoData.title;
                    cp4Var.e = cardLinkInfoData.imageUrl;
                    cp4Var.l = cardLinkInfoData.tagText;
                    cp4Var.g = cardLinkInfoData.url;
                    cp4Var.i = false;
                    cp4Var.o = i;
                }
            } else {
                cp4Var.c = qw4Var.e;
                cp4Var.e = qw4Var.d;
                cp4Var.l = qw4Var.f;
                cp4Var.f = qw4Var.g;
                cp4Var.g = qw4Var.c;
                cp4Var.n = qw4Var.h;
                String str = qw4Var.i;
                cp4Var.i = i == 1;
                cp4Var.o = qw4Var.b;
            }
            tbLinkSpanGroup.A(cp4Var);
            return cp4Var;
        }
        return (cp4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull cp4 cp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cp4Var)) == null) ? this.q - cp4Var.q : invokeL.intValue;
    }
}
