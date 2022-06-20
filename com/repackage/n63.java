package com.repackage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a63;
import com.repackage.pk2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n63 extends sv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755517594, "Lcom/repackage/n63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755517594, "Lcom/repackage/n63;");
                return;
            }
        }
        f = cg1.a;
    }

    public n63() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean e(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? TextUtils.isEmpty(str) || TextUtils.equals("0", str) : invokeL.booleanValue;
    }

    public static void f(String str, String str2, @Nullable JSONObject jSONObject) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, str, str2, jSONObject) == null) && e(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            String str3 = StringUtil.NULL_STRING;
            if (str2 == null) {
                str2 = StringUtil.NULL_STRING;
            }
            try {
                jSONObject2.put("version", str2);
                jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str == null ? StringUtil.NULL_STRING : str);
                sz2 M = sz2.M();
                if (M != null) {
                    pk2.a Y = M.Y();
                    jSONObject2.put("launchInfo", Y == null ? StringUtil.NULL_STRING : Y.I1());
                    SwanAppActivity x = M.x();
                    pk2 pk2Var = null;
                    if (x != null && (intent = x.getIntent()) != null) {
                        pk2Var = pk2.d1(intent);
                    }
                    if (pk2Var != null) {
                        str3 = pk2Var.I1();
                    }
                    jSONObject2.put("launchInfoIntent", str3);
                } else {
                    jSONObject2.put("swanApp", StringUtil.NULL_STRING);
                }
                jSONObject2.put("stackTrace", md3.y());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
            }
            nw2 z = rz2.K().z();
            if (z != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                z.W(bundle, n63.class);
            }
        }
    }

    @Override // com.repackage.sv2
    public void b(@NonNull Bundle bundle) {
        p62 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            String string = bundle.getString("key_swan_appid", "");
            String string2 = bundle.getString("key_report_info", "");
            String str = TextUtils.isEmpty(string2) ? "" : string2;
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                if (f) {
                    Log.e("VersionBusinessUbc", "execCall: ", e);
                }
                e.printStackTrace();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (!TextUtils.isEmpty(string) && (o = SwanAppDbControl.f(AppRuntime.getAppContext()).o(string)) != null) {
                try {
                    jSONObject.put("appDbInfo", o.a());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (f) {
                Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
            }
            a63.b bVar = new a63.b(10002);
            bVar.i(jSONObject.toString());
            bVar.m();
            c();
        }
    }
}
