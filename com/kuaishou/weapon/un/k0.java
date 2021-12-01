package com.kuaishou.weapon.un;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                String a = z.a();
                if (TextUtils.isEmpty(a) || a.contains("arm64")) {
                    return 0;
                }
                return !a.contains(WebKitFactory.OS_64) ? 1 : 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                Map<String, String> map = System.getenv();
                if (map != null) {
                    JSONObject jSONObject = new JSONObject();
                    Set b2 = b();
                    String packageName = context.getPackageName();
                    for (String str : map.keySet()) {
                        String str2 = map.get(str);
                        if (!str.contains("ANDROID_") && !str.contains("_ROOT") && !str2.contains(packageName) && !b2.contains(str)) {
                            jSONObject.put(str, str2);
                            if (b2.size() > 15) {
                                break;
                            }
                        }
                    }
                    if (jSONObject.length() > 0) {
                        return jSONObject;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static Set b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            HashSet hashSet = new HashSet();
            hashSet.add("BOOTCLASSPATH");
            hashSet.add("DEX2OATBOOTCLASSPATH");
            hashSet.add("PATH");
            hashSet.add("CUST_POLICY_DIRS");
            hashSet.add("SYSTEMSERVERCLASSPATH");
            hashSet.add("OEM_ROOT");
            hashSet.add("ODM_PRODUCT");
            hashSet.add("DOWNLOAD_CACHE");
            hashSet.add("ASEC_MOUNTPOINT");
            hashSet.add("EMULATED_STORAGE_TARGET");
            hashSet.add("EMULATED_STORAGE_SOURCE");
            hashSet.add("SECONDARY_STORAGE");
            hashSet.add("USBOTG_STORAGE");
            hashSet.add("EXTERNAL_STORAGE");
            hashSet.add("LD_PRELOAD");
            hashSet.add("LOOP_MOUNTPOINT");
            hashSet.add("LD_LIBRARY_PATH");
            hashSet.add("BOOTCLASSPATH_EX");
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }
}
