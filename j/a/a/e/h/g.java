package j.a.a.e.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagTagInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            RLog.info("PayAmountHelper", "countPayAmountMargin targetAmount:" + d2 + " accountAmount:" + d3);
            double d4 = (d2 - d3) / 100.0d;
            double d5 = 1.0d;
            if (d4 > 1.0d) {
                if (d4 <= 1.0d || d4 > 10.0d) {
                    if (d4 % 10.0d > 0.0d) {
                        d4 = (((int) (d4 / 10.0d)) + 1) * 10;
                    }
                    d5 = d4;
                } else {
                    d5 = Math.ceil(d4);
                }
            }
            RLog.info("PayAmountHelper", "countPayAmountMargin amountMarginCount:" + d5);
            return (int) d5;
        }
        return invokeCommon.intValue;
    }

    public static int b(List<j.a.a.e.f.c> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i2)) == null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).b() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public static j.a.a.e.f.c c(List<j.a.a.e.f.c> list, PayUIKitConfig payUIKitConfig, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{list, payUIKitConfig, Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            RLog.info("PayAmountHelper", "createPayAmount targetAmount:" + d2 + " accountAmount:" + d3);
            if (list == null || list.isEmpty()) {
                return null;
            }
            int a = a(d2, d3);
            RLog.info("PayAmountHelper", "countPayAmountMargin amountMargin:" + a);
            int b2 = b(list, a);
            RLog.info("PayAmountHelper", "findPayAmountPositionFromConfigList position:" + b2);
            if (b2 >= 0) {
                d(list, b2);
            } else {
                f(list, payUIKitConfig, a);
            }
            return list.get(0);
        }
        return (j.a.a.e.f.c) invokeCommon.objValue;
    }

    public static void d(List<j.a.a.e.f.c> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, list, i2) == null) {
            RLog.info("PayAmountHelper", "movePayAmountList position:" + i2);
            RLog.debug("PayAmountHelper", "movePayAmountList configAmountList:" + list);
            if (i2 != 0) {
                list.add(0, list.remove(i2));
            }
            if (list.get(0).a.giftBagTagInfos != null && !list.get(0).a.giftBagTagInfos.isEmpty()) {
                list.get(0).a.giftBagTagInfos.get(0).tag = "推荐";
                return;
            }
            GiftBagTagInfo giftBagTagInfo = new GiftBagTagInfo();
            giftBagTagInfo.tag = "推荐";
            list.get(0).a.giftBagTagInfos = new ArrayList();
            list.get(0).a.giftBagTagInfos.add(giftBagTagInfo);
        }
    }

    public static boolean e(j.a.a.e.f.c cVar) {
        InterceptResult invokeL;
        ProductInfo productInfo;
        List<GiftBagsInfo> list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar)) == null) ? (cVar == null || (productInfo = cVar.a) == null || (list = productInfo.giftbags) == null || list.isEmpty()) ? false : true : invokeL.booleanValue;
    }

    public static void f(List<j.a.a.e.f.c> list, PayUIKitConfig payUIKitConfig, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, list, payUIKitConfig, i2) == null) {
            RLog.debug("PayAmountHelper", "replacePayAmountList configAmountList:" + list);
            if (i2 > 500000) {
                i2 = 500000;
            }
            j.a.a.e.f.c a = b.a(i2 * 100, payUIKitConfig);
            RLog.info("PayAmountHelper", "createPayAmount customPayAmount:" + a);
            if (e(list.get(0))) {
                list.remove(list.size() - 1);
            } else if (e(list.get(list.size() - 1))) {
                list.remove(0);
            } else {
                list.remove(0);
            }
            GiftBagTagInfo giftBagTagInfo = new GiftBagTagInfo();
            giftBagTagInfo.tag = "推荐";
            a.a.giftBagTagInfos = new ArrayList();
            a.a.giftBagTagInfos.add(giftBagTagInfo);
            list.add(0, a);
        }
    }
}
