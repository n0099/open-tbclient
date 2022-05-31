package com.repackage;

import android.text.TextUtils;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                JSONObject optJSONObject2 = new JSONObject(str).optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                if (optJSONObject2 != null && optJSONObject2.has(SpeedStatsUtils.UBC_VALUE_SPLASH) && (optJSONObject = optJSONObject2.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH)) != null && optJSONObject.has("src_ext_info")) {
                    return new JSONObject(optJSONObject.optString("src_ext_info")).has("query_ret_code");
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static List<z91> b(JSONArray jSONArray, String str, boolean z) throws ParseError {
        InterceptResult invokeLLZ;
        List<z91> j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, jSONArray, str, z)) == null) {
            if (jSONArray == null || jSONArray.length() == 0 || (j = z91.j(jSONArray)) == null || j.size() == 0) {
                return null;
            }
            if (z) {
                for (z91 z91Var : j) {
                    z91Var.y = true;
                }
            } else {
                HashMap<String, z91> s = x91.s();
                if (s != null && s.size() != 0) {
                    x91.h(j);
                    x91.C(j);
                } else {
                    x91.C(j);
                }
                x91.z(j);
            }
            return j;
        }
        return (List) invokeLLZ.objValue;
    }

    public static List<z91> c(String str, String str2) throws ParseError {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return d(new JSONObject(str), str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                    throw new ParseError(1, "afd/entry retun invalid json");
                }
            }
            throw new ParseError(1, "afd/entry retun null");
        }
        return (List) invokeLL.objValue;
    }

    public static List<z91> d(JSONObject jSONObject, String str) throws ParseError {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, str)) == null) {
            List<z91> arrayList = new ArrayList<>();
            if (jSONObject != null) {
                if (jSONObject.optInt("errno", 0) <= 0 && (optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME)) != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH);
                    JSONArray optJSONArray = optJSONObject.optJSONArray(LaunchStatsUtils.AD);
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("cmd");
                        SplashStyleRecorder.b(optJSONObject2.optJSONObject("style_desc"));
                        y91.H(optJSONObject2.optString("src_ext_info"));
                        if (TextUtils.equals("update", optString)) {
                            y91.G(optJSONObject2.optString("src_ext_info"));
                            arrayList = b(optJSONArray, str, false);
                            String optString2 = optJSONObject2.optString("empty_ext_info");
                            if (!TextUtils.isEmpty(optString2)) {
                                ox0.a().b("splash_sp_name").j("empty_ext_info", optString2, false);
                            }
                        } else if (TextUtils.equals("query", optString)) {
                            int optInt = optJSONObject2.optInt("realTimeLoading");
                            int optInt2 = optJSONObject2.optInt("isCPC");
                            if (optInt != 1 && optInt2 != 1) {
                                String optString3 = optJSONObject2.optString("ukey");
                                if (TextUtils.isEmpty(optString3)) {
                                    BaseVM.h(32);
                                    return arrayList;
                                }
                                List<z91> v = x91.v();
                                if (v == null) {
                                    return arrayList;
                                }
                                Iterator<z91> it = v.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    z91 next = it.next();
                                    if (TextUtils.equals(next.c, optString3)) {
                                        gx0.b(arrayList, next);
                                        break;
                                    }
                                }
                                if (arrayList.size() == 0) {
                                    BaseVM.h(64);
                                }
                            } else {
                                List<z91> b = b(optJSONArray, str, true);
                                if (b == null || b.size() == 0) {
                                    BaseVM.h(128);
                                }
                                arrayList = b;
                            }
                            if (arrayList != null && arrayList.size() > 0 && arrayList.get(0) != null) {
                                arrayList.get(0).D = optInt == 1 ? 1 : 0;
                            }
                        }
                    }
                    return arrayList;
                }
                return null;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
