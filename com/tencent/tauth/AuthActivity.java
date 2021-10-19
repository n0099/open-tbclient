package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
/* loaded from: classes10.dex */
public class AuthActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_KEY = "action";
    public static final String ACTION_SHARE_PRIZE = "sharePrize";

    /* renamed from: a  reason: collision with root package name */
    public static int f76830a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-434153907, "Lcom/tencent/tauth/AuthActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-434153907, "Lcom/tencent/tauth/AuthActivity;");
        }
    }

    public AuthActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void a(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, uri) == null) {
            SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
            if (uri != null && uri.toString() != null) {
                String str = "";
                if (!uri.toString().equals("")) {
                    String uri2 = uri.toString();
                    Bundle a2 = l.a(uri2.substring(uri2.indexOf("#") + 1));
                    if (a2 == null) {
                        SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                        finish();
                        return;
                    }
                    String string = a2.getString("action");
                    SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                    if (string == null) {
                        finish();
                        return;
                    } else if (!string.equals("shareToQQ") && !string.equals("shareToQzone") && !string.equals("sendToMyComputer") && !string.equals("shareToTroopBar")) {
                        if (string.equals("addToQQFavorites")) {
                            Intent intent = getIntent();
                            intent.putExtras(a2);
                            intent.putExtra(Constants.KEY_ACTION, "action_share");
                            IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string);
                            if (listnerWithAction != null) {
                                UIListenerManager.getInstance().handleDataToListener(intent, listnerWithAction);
                            }
                            finish();
                            return;
                        } else if (string.equals(ACTION_SHARE_PRIZE)) {
                            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                            try {
                                str = l.d(a2.getString("response")).getString("activityid");
                            } catch (Exception e2) {
                                SLog.e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e2);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                                Bundle bundle = new Bundle();
                                bundle.putString("activityid", str);
                                launchIntentForPackage.putExtras(bundle);
                            }
                            startActivity(launchIntentForPackage);
                            finish();
                            return;
                        } else if (string.equals("sdkSetAvatar")) {
                            boolean booleanExtra = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                            Intent intent2 = new Intent(this, AssistActivity.class);
                            intent2.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_AVATAR);
                            intent2.putExtra(Constants.KEY_STAY, booleanExtra);
                            intent2.putExtras(a2);
                            intent2.setFlags(603979776);
                            startActivity(intent2);
                            finish();
                            return;
                        } else if ("sdkSetDynamicAvatar".equals(string)) {
                            boolean booleanExtra2 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                            Intent intent3 = new Intent(this, AssistActivity.class);
                            intent3.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                            intent3.putExtra(Constants.KEY_STAY, booleanExtra2);
                            intent3.putExtras(a2);
                            intent3.setFlags(603979776);
                            startActivity(intent3);
                            finish();
                            return;
                        } else if (string.equals("sdkSetEmotion")) {
                            boolean booleanExtra3 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                            Intent intent4 = new Intent(this, AssistActivity.class);
                            intent4.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_EMOTION);
                            intent4.putExtra(Constants.KEY_STAY, booleanExtra3);
                            intent4.putExtras(a2);
                            intent4.setFlags(603979776);
                            startActivity(intent4);
                            finish();
                            return;
                        } else if (string.equals("bindGroup")) {
                            SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                            boolean booleanExtra4 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                            Intent intent5 = new Intent(this, AssistActivity.class);
                            intent5.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_BIND_GROUP);
                            intent5.putExtra(Constants.KEY_STAY, booleanExtra4);
                            intent5.putExtras(a2);
                            intent5.setFlags(603979776);
                            startActivity(intent5);
                            finish();
                            return;
                        } else if (string.equals("joinGroup")) {
                            SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                            boolean booleanExtra5 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                            Intent intent6 = new Intent(this, AssistActivity.class);
                            intent6.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_JOIN_GROUP);
                            intent6.putExtra(Constants.KEY_STAY, booleanExtra5);
                            intent6.putExtras(a2);
                            intent6.setFlags(603979776);
                            startActivity(intent6);
                            finish();
                            return;
                        } else {
                            finish();
                            return;
                        }
                    } else {
                        if (string.equals("shareToQzone") && i.a((Context) this, "com.tencent.mobileqq") != null && i.c(this, "5.2.0") < 0) {
                            int i2 = f76830a + 1;
                            f76830a = i2;
                            if (i2 == 2) {
                                f76830a = 0;
                                finish();
                                return;
                            }
                        }
                        SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                        Intent intent7 = new Intent(this, AssistActivity.class);
                        intent7.putExtras(a2);
                        intent7.setFlags(603979776);
                        startActivity(intent7);
                        finish();
                        return;
                    }
                }
            }
            SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() == null) {
                SLog.w("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
                finish();
                return;
            }
            Uri uri = null;
            try {
                uri = getIntent().getData();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            SLog.v("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + uri);
            try {
                a(uri);
            } catch (Exception e3) {
                e3.printStackTrace();
                finish();
            }
        }
    }
}
