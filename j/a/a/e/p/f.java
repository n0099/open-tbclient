package j.a.a.e.p;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(PayFlowType payFlowType, int i2, int i3, PayUIKitConfig payUIKitConfig, Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{payFlowType, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig, activity, str, str2}) == null) {
            boolean z = false;
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                if (TextUtils.isEmpty(str)) {
                    RLog.error("PayWebActivityUtils", "startPayWebActivity error url null", new Object[0]);
                    return;
                }
                String str3 = (str2 == null || str2.isEmpty()) ? "" : str2;
                Intent intent = new Intent(activity, PayCommonWebActivity.class);
                intent.putExtra(H5PayConstant.EXTRA_TITLE, str3);
                intent.putExtra(H5PayConstant.EXTRA_URL, str);
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, i2);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, i3);
                if (str.equals(j.a.a.e.n.e.c(payUIKitConfig))) {
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 1);
                    z = true;
                }
                RLog.info("PayWebActivityUtils", "startPayWebActivity payFlowType:" + payFlowType + " isWalletActivity:" + z);
                if (TextUtils.isEmpty(str2)) {
                    str2 = p.a(str);
                }
                PayCommonWebActivity.startWebActivity(activity, payFlowType, intent, i2, i3, str2);
                return;
            }
            RLog.error("PayWebActivityUtils", "startPayWebActivity error mPayUIKitConfig null", new Object[0]);
        }
    }
}
