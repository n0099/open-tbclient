package com.repackage;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yr3 extends mr3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755132233, "Lcom/repackage/yr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755132233, "Lcom/repackage/yr3;");
                return;
            }
        }
        c = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yr3() {
        super("startPermissionsPage");
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

    @Override // com.repackage.mr3
    public hr1 a(JSONObject jSONObject, lc2 lc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, lc2Var)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 != null && a0.x() != null) {
                String str = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str)) {
                    str = str.toLowerCase(Locale.US);
                }
                if (TextUtils.equals(str, RomUtils.MANUFACTURER_OPPO)) {
                    try {
                        Intent intent = new Intent(a0.x().getPackageName());
                        intent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
                        a0.x().startActivity(intent);
                    } catch (Exception e) {
                        if (c) {
                            e.printStackTrace();
                        }
                        lc3.f(a0.x());
                    }
                } else {
                    lc3.g(a0.x());
                }
                lc2Var.a(null);
            } else if (c) {
                Log.d("StartPermissionsPage", "swan or activity is null");
            }
            return null;
        }
        return (hr1) invokeLL.objValue;
    }
}
