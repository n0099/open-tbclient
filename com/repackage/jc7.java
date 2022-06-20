package com.repackage;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class jc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ic7 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof ic7)) {
                return null;
            }
            return (ic7) iLegoAdvert;
        }
        return (ic7) invokeL.objValue;
    }

    public static void b(ic7 ic7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, ic7Var) == null) || ic7Var == null || ic7Var.getParallelCharge() == null) {
            return;
        }
        wx0.b(ic7Var.getParallelCharge().b);
        Iterator<String> it = ic7Var.getParallelCharge().c.iterator();
        while (it.hasNext()) {
            wx0.b(it.next());
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
            vx0.c(clogBuilder);
        }
    }

    public static boolean d(ic7 ic7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ic7Var)) == null) {
            if (ic7Var == null || ic7Var.getParallelCharge() == null) {
                return false;
            }
            String str = ic7Var.getParallelCharge().a;
            wx0.b(str);
            boolean z = !TextUtils.isEmpty(str);
            Iterator<String> it = ic7Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                z = z || !TextUtils.isEmpty(next);
                wx0.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
