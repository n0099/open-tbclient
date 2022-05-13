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
public class kd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static jd7 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof jd7)) {
                return null;
            }
            return (jd7) iLegoAdvert;
        }
        return (jd7) invokeL.objValue;
    }

    public static void b(jd7 jd7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jd7Var) == null) || jd7Var == null || jd7Var.getParallelCharge() == null) {
            return;
        }
        fz0.b(jd7Var.getParallelCharge().b);
        Iterator<String> it = jd7Var.getParallelCharge().c.iterator();
        while (it.hasNext()) {
            fz0.b(it.next());
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
            ez0.c(clogBuilder);
        }
    }

    public static boolean d(jd7 jd7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jd7Var)) == null) {
            if (jd7Var == null || jd7Var.getParallelCharge() == null) {
                return false;
            }
            String str = jd7Var.getParallelCharge().a;
            fz0.b(str);
            boolean z = !TextUtils.isEmpty(str);
            Iterator<String> it = jd7Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                z = z || !TextUtils.isEmpty(next);
                fz0.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
