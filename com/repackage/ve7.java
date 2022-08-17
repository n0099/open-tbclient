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
public class ve7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ue7 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof ue7)) {
                return null;
            }
            return (ue7) iLegoAdvert;
        }
        return (ue7) invokeL.objValue;
    }

    public static void b(ue7 ue7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, ue7Var) == null) || ue7Var == null || ue7Var.getParallelCharge() == null) {
            return;
        }
        iy0.b(ue7Var.getParallelCharge().b);
        Iterator<String> it = ue7Var.getParallelCharge().c.iterator();
        while (it.hasNext()) {
            iy0.b(it.next());
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
            hy0.b(clogBuilder);
        }
    }

    public static boolean d(ue7 ue7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ue7Var)) == null) {
            if (ue7Var == null || ue7Var.getParallelCharge() == null) {
                return false;
            }
            String str = ue7Var.getParallelCharge().a;
            iy0.b(str);
            boolean z = !TextUtils.isEmpty(str);
            Iterator<String> it = ue7Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                z = z || !TextUtils.isEmpty(next);
                iy0.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
