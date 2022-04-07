package com.repackage;

import android.view.ViewStub;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class oc8 implements ua8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nc8 a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final Map<String, AdvertAppInfo> i;
    public int j;
    public final int k;
    public final int l;
    public final int m;

    public oc8(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = rg5.h().n();
        this.c = rg5.h().q();
        this.d = rg5.h().k();
        this.e = rg5.h().l() - 1;
        this.f = rg5.h().m();
        this.g = rg5.h().p();
        this.h = rg5.h().o();
        this.j = k98.a("daily_show_count");
        this.i = new HashMap();
        int[] p = oi.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int r = rg5.h().r();
        nc8 nc8Var = new nc8(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", aVar);
        this.a = nc8Var;
        nc8Var.e(r);
        this.a.f(true);
    }

    @Override // com.repackage.ua8
    public AdvertAppInfo d(vb5 vb5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vb5Var)) == null) {
            if (!vb5Var.j && !vb5Var.k) {
                int i = vb5Var.c;
                String str = vb5Var.g;
                int i2 = vb5Var.d;
                int i3 = vb5Var.i;
                float f = vb5Var.f;
                int i4 = vb5Var.h;
                u(i, i2, i3, vb5Var);
                if (this.i.containsKey(str)) {
                    return this.i.get(str);
                }
                if (s(i, i2) && t(i4, f, vb5Var.e)) {
                    AdvertAppInfo i5 = this.a.i();
                    if (i5 != null) {
                        i5.k = "PIC_PAGE_BANNER";
                        i5.position = i;
                        this.i.put(str, i5);
                        int i6 = this.j + 1;
                        this.j = i6;
                        k98.g("daily_show_count", i6);
                    }
                    return i5;
                }
            }
            return null;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // com.repackage.ua8
    public u98 i(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new kc8(viewStub, tbPageContext) : (u98) invokeLL.objValue;
    }

    @Override // com.repackage.ua8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.b();
        }
    }

    public final Map<String, String> r(vb5 vb5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vb5Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", vb5Var.l);
            hashMap.put("forum_name", vb5Var.m);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean s(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            if (i >= this.e && i > i2) {
                return i2 == 0 || i - i2 >= this.f;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final boolean t(int i, float f, float f2) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.b == 4) {
                return true;
            }
            if (f == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f)) {
                return ((int) (((((float) this.l) - f2) / 2.0f) - ((float) i))) > this.m && ((i2 = this.b) == 1 || i2 == 2);
            }
            int i3 = this.b;
            return i3 == 3 || i3 == 1;
        }
        return invokeCommon.booleanValue;
    }

    public final void u(int i, int i2, int i3, vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), vb5Var}) == null) || this.j >= this.h) {
            return;
        }
        this.a.h(this.d);
        if (this.a.j()) {
            return;
        }
        int i4 = i2 == 0 ? this.e : this.f + i2;
        if (i < i2 || i4 >= i3 || i < i4 - this.g) {
            return;
        }
        this.a.d(Math.min(this.h - this.j, this.c), r(vb5Var));
    }
}
