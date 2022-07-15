package com.repackage;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class bd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ad7 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof ad7)) {
                return null;
            }
            return (ad7) iLegoAdvert;
        }
        return (ad7) invokeL.objValue;
    }

    public static void b(ad7 ad7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, ad7Var) == null) || ad7Var == null || ad7Var.getParallelCharge() == null) {
            return;
        }
        jy0.b(ad7Var.getParallelCharge().b);
        Iterator<String> it = ad7Var.getParallelCharge().c.iterator();
        while (it.hasNext()) {
            jy0.b(it.next());
        }
    }

    public static void c(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, advertAppInfo) == null) && d(a(advertAppInfo))) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.EXCEPTION).k("1").l(DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_DISABLE).p(advertAppInfo.g);
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.h;
            if (iLegoAdvert != null) {
                clogBuilder.m(String.valueOf(iLegoAdvert.getGoodsStyle()));
            }
            iy0.b(clogBuilder);
        }
    }

    public static boolean d(ad7 ad7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ad7Var)) == null) {
            if (ad7Var == null || ad7Var.getParallelCharge() == null) {
                return false;
            }
            String str = ad7Var.getParallelCharge().a;
            jy0.b(str);
            boolean z = !TextUtils.isEmpty(str);
            Iterator<String> it = ad7Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                z = z || !TextUtils.isEmpty(next);
                jy0.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
