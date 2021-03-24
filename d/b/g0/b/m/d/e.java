package d.b.g0.b.m.d;

import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppQuickLoginDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class e {
    public static SwanAppLoginAndGetMobileDialog a(String str, boolean z, QuickLoginInfo quickLoginInfo, String str2, String str3) {
        SwanAppLoginAndGetMobileDialog swanAppPhoneLoginDialog;
        Bundle bundle = new Bundle();
        if (quickLoginInfo != null && quickLoginInfo.supportQuickLogin) {
            swanAppPhoneLoginDialog = new SwanAppQuickLoginDialog();
        } else {
            swanAppPhoneLoginDialog = new SwanAppPhoneLoginDialog();
        }
        bundle.putString("auth_tip", str);
        bundle.putBoolean("is_night", z);
        bundle.putParcelable("quick_login_info", quickLoginInfo);
        bundle.putString(Constants.APP_ID, str3);
        bundle.putString("launch_from", str2);
        swanAppPhoneLoginDialog.setArguments(bundle);
        return swanAppPhoneLoginDialog;
    }
}
