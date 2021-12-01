package j.a.a.e.n;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, int i3, PayUIKitConfig payUIKitConfig, Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig, activity, str, str2}) == null) {
            RLog.info("PayWebActivityUtils", "startPayWebActivity walletshow");
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                if (TextUtils.isEmpty(str)) {
                    RLog.error("PayWebActivityUtils", "startActivity error url null", new Object[0]);
                    return;
                }
                str2 = (str2 == null || str2.isEmpty()) ? "" : "";
                Intent intent = new Intent(activity, PayCommonWebActivity.class);
                intent.putExtra(H5PayConstant.EXTRA_TITLE, str2);
                intent.putExtra(H5PayConstant.EXTRA_URL, str);
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, i2);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, i3);
                if (str.equals(j.a.a.e.l.e.c(payUIKitConfig))) {
                    RLog.debug("PayWebActivityUtils", "startPayWebActivity is wallet");
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 1);
                }
                activity.startActivity(intent);
                return;
            }
            RLog.error("PayWebActivityUtils", "startPayWebActivity error mPayUIKitConfig null", new Object[0]);
        }
    }
}
