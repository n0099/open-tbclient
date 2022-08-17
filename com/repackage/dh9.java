package com.repackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class dh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.fun.module.csj.g0 a(TTNativeAd tTNativeAd) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tTNativeAd)) == null) {
            int imageMode = tTNativeAd.getImageMode();
            if (imageMode == 15) {
                i = R.layout.obfuscated_res_0x7f0d0361;
            } else if (imageMode != 16) {
                if (imageMode != 166) {
                    if (imageMode == 2) {
                        i = R.layout.obfuscated_res_0x7f0d035f;
                    } else if (imageMode == 3) {
                        i = R.layout.obfuscated_res_0x7f0d035d;
                    } else if (imageMode == 4) {
                        i = R.layout.obfuscated_res_0x7f0d035c;
                    } else if (imageMode != 5) {
                        return null;
                    }
                }
                i = R.layout.obfuscated_res_0x7f0d035e;
            } else {
                i = R.layout.obfuscated_res_0x7f0d0360;
            }
            com.fun.module.csj.g0 g0Var = (com.fun.module.csj.g0) LayoutInflater.from(FunAdSdk.getAppContext()).inflate(i, (ViewGroup) null);
            g0Var.a(tTNativeAd);
            return g0Var;
        }
        return (com.fun.module.csj.g0) invokeL.objValue;
    }

    public static String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("personal_ads_type", z ? "1" : "0");
            if (hashMap.isEmpty()) {
                return "";
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry entry : hashMap.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", entry.getKey());
                    jSONObject.put("value", entry.getValue());
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e) {
                LogPrinter.e(e);
                return "";
            }
        }
        return (String) invokeZ.objValue;
    }
}
