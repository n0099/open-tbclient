package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialOperation;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755335996, "Lcom/repackage/rw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755335996, "Lcom/repackage/rw2;");
                return;
            }
        }
        a = eh1.a;
    }

    public static String a(String str, long j, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), str2})) == null) {
            u03 L = u03.L();
            String[] strArr = {L != null ? ws1.a(L.N()) : "", str, String.valueOf(j), str2};
            Arrays.sort(strArr);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(strArr[i]);
            }
            try {
                return md3.c("SHA-1", sb.toString().getBytes(), false);
            } catch (NoSuchAlgorithmException e) {
                if (a) {
                    Log.e("SwanPluginHostSign", "getSignature occurs exception:", e);
                    return "";
                }
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(t94 t94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t94Var)) == null) {
            if (t94Var == null) {
                return "";
            }
            String str = t94Var.p;
            JSONObject jSONObject = new JSONObject();
            String uuid = UUID.randomUUID().toString();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                jSONObject.put("noncestr", uuid);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put(SocialOperation.GAME_SIGNATURE, a(uuid, currentTimeMillis, str));
            } catch (JSONException e) {
                mw2.b(Log.getStackTraceString(e));
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(String str, String str2, t94 t94Var) {
        InterceptResult invokeLLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, t94Var)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && t94Var != null) {
                String str3 = t94Var.q;
                if (TextUtils.isEmpty(str3)) {
                    return false;
                }
                try {
                    JSONArray optJSONArray = new JSONObject(str3).optJSONArray(str);
                    if (optJSONArray == null || (length = optJSONArray.length()) == 0) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    return l13.b(new URI(str2).getHost(), arrayList);
                } catch (URISyntaxException | JSONException e) {
                    mw2.b(Log.getStackTraceString(e));
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
