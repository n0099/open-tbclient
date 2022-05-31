package com.repackage;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class ya7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xa7 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof xa7)) {
                return null;
            }
            return (xa7) iLegoAdvert;
        }
        return (xa7) invokeL.objValue;
    }

    public static void b(xa7 xa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, xa7Var) == null) || xa7Var == null || xa7Var.getParallelCharge() == null) {
            return;
        }
        sx0.b(xa7Var.getParallelCharge().b);
        Iterator<String> it = xa7Var.getParallelCharge().c.iterator();
        while (it.hasNext()) {
            sx0.b(it.next());
        }
    }

    public static void c(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, advertAppInfo) == null) && d(a(advertAppInfo))) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.EXCEPTION).i("1").j(DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_DISABLE).n(advertAppInfo.g);
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.h;
            if (iLegoAdvert != null) {
                clogBuilder.k(String.valueOf(iLegoAdvert.getGoodsStyle()));
            }
            rx0.c(clogBuilder);
        }
    }

    public static boolean d(xa7 xa7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xa7Var)) == null) {
            if (xa7Var == null || xa7Var.getParallelCharge() == null) {
                return false;
            }
            String str = xa7Var.getParallelCharge().a;
            sx0.b(str);
            boolean z = !TextUtils.isEmpty(str);
            Iterator<String> it = xa7Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                z = z || !TextUtils.isEmpty(next);
                sx0.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
