package com.repackage;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wr3 extends zs3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755191815, "Lcom/repackage/wr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755191815, "Lcom/repackage/wr3;");
                return;
            }
        }
        c = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wr3() {
        super("checkAppInstalled");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.zs3
    public us1 a(@NonNull JSONObject jSONObject, @NonNull yd2 yd2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, yd2Var)) == null) {
            if (c) {
                Log.d("checkAppInstalled", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                yd2Var.onFail(31010, "package name is empty");
                return null;
            }
            try {
                PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(optString, 0);
                if (c) {
                    Log.d("checkAppInstalled", "packageInfo: " + packageInfo);
                }
                if (packageInfo != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                    jSONObject3.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
                    jSONObject2.put("data", jSONObject3);
                    yd2Var.a(jSONObject2);
                } else {
                    yd2Var.onFail(31016, "no package info");
                }
            } catch (Exception unused) {
                yd2Var.onFail(31011, "app is not installed");
            }
            return null;
        }
        return (us1) invokeLL.objValue;
    }
}
