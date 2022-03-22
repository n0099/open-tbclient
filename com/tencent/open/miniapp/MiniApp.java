package com.tencent.open.miniapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class MiniApp extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MINIAPP_CONTEXT_NULL = -6;
    public static final int MINIAPP_ID_EMPTY = -1;
    public static final int MINIAPP_ID_NOT_DIGIT = -4;
    public static final int MINIAPP_SHOULD_DOWNLOAD = -2;
    public static final String MINIAPP_SRC_ID = "21";
    public static final int MINIAPP_SRC_ID_NOT_DIGIT = -3;
    public static final int MINIAPP_SUCCESS = 0;
    public static final String MINIAPP_TYPE_NORMAL = "mini_program_or_game";
    public static final int MINIAPP_UNKNOWN_TYPE = -5;
    public static final String MINIAPP_VERSION_DEVELOP = "develop";
    public static final String MINIAPP_VERSION_RELEASE = "release";
    public static final String MINIAPP_VERSION_TRIAL = "trial";
    public static final int MINIAPP_VERSION_WRONG = -7;
    public static final List<String> OPEN_CONNECT_DEMO_MINI_APP_VERSIONS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1894433705, "Lcom/tencent/open/miniapp/MiniApp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1894433705, "Lcom/tencent/open/miniapp/MiniApp;");
                return;
            }
        }
        OPEN_CONNECT_DEMO_MINI_APP_VERSIONS = Arrays.asList(MINIAPP_VERSION_DEVELOP, MINIAPP_VERSION_TRIAL, "release");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniApp(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar, qQToken};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c) objArr2[0], (QQToken) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, str, str2, str3, str4, str5})) == null) {
            if (activity == null) {
                SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_CONTEXT_NULL : -6");
                return -6;
            } else if (!MINIAPP_TYPE_NORMAL.equals(str)) {
                SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_UNKNOWN_TYPE : -5");
                return -5;
            } else if (TextUtils.isEmpty(str2)) {
                SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_EMPTY : -1");
                return -1;
            } else {
                for (int i = 0; i < str2.length(); i++) {
                    if (!Character.isDigit(str2.charAt(i))) {
                        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_NOT_DIGIT : -4");
                        return -4;
                    }
                }
                if (str4 == null) {
                    str4 = "";
                }
                if (!OPEN_CONNECT_DEMO_MINI_APP_VERSIONS.contains(str5)) {
                    SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_VERSION_WRONG : -7");
                    return -7;
                } else if (l.e(activity)) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(String.format("mqqapi://connect_miniapp/launch?app_type=%1$s&mini_app_id=%2$s&version=1&src_type=app&app_name=%3$s&app_id=%4$s&src_id=%5$s&mini_app_path=%6$s&mini_app_type=%7$s&open_id=%8$s", str, str2, l.l(i.a((Context) activity)), l.l(this.f43645c.getAppId()), str3, l.l(str4), l.l(str5), l.l(this.f43645c.getOpenId()))));
                    intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                    activity.startActivity(intent);
                    SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SUCCESS : 0");
                    return 0;
                } else {
                    try {
                        new TDialog(activity, "", a(""), null, this.f43645c).show();
                    } catch (RuntimeException e2) {
                        SLog.e("openSDK_LOG.MiniApp", "Show download dialog exception:" + e2.getMessage());
                    }
                    SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SHOULD_DOWNLOAD : -2");
                    return -2;
                }
            }
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniApp(Context context, QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, qQToken};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniApp(QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qQToken};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
