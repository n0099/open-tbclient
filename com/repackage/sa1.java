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
public class sa1 {
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

    public static List<za1> b(JSONArray jSONArray, String str, boolean z) throws ParseError {
        InterceptResult invokeLLZ;
        List<za1> j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, jSONArray, str, z)) == null) {
            if (jSONArray == null || jSONArray.length() == 0 || (j = za1.j(jSONArray)) == null || j.size() == 0) {
                return null;
            }
            if (z) {
                for (za1 za1Var : j) {
                    za1Var.y = true;
                }
            } else {
                HashMap<String, za1> u = xa1.u();
                if (u != null && u.size() != 0) {
                    xa1.j(j);
                    xa1.E(j);
                } else {
                    xa1.E(j);
                }
                xa1.B(j);
            }
            wa1.m().g();
            return j;
        }
        return (List) invokeLLZ.objValue;
    }

    public static List<za1> c(String str, String str2) throws ParseError {
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

    public static List<za1> d(JSONObject jSONObject, String str) throws ParseError {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, str)) == null) {
            List<za1> arrayList = new ArrayList<>();
            if (jSONObject != null) {
                if (jSONObject.optInt("errno", 0) <= 0 && (optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME)) != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH);
                    JSONArray optJSONArray = optJSONObject.optJSONArray(LaunchStatsUtils.AD);
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("cmd");
                        SplashStyleRecorder.b(optJSONObject2.optJSONObject("style_desc"));
                        ya1.J(optJSONObject2.optString("src_ext_info"));
                        if (TextUtils.equals("update", optString)) {
                            ya1.I(optJSONObject2.optString("src_ext_info"));
                            arrayList = b(optJSONArray, str, false);
                            String optString2 = optJSONObject2.optString("empty_ext_info");
                            if (!TextUtils.isEmpty(optString2)) {
                                fy0.a().b("splash_sp_name").j("empty_ext_info", optString2, false);
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
                                List<za1> x = xa1.x();
                                if (x == null) {
                                    return arrayList;
                                }
                                Iterator<za1> it = x.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    za1 next = it.next();
                                    if (TextUtils.equals(next.c, optString3)) {
                                        xx0.b(arrayList, next);
                                        break;
                                    }
                                }
                                if (arrayList.size() == 0) {
                                    BaseVM.h(64);
                                }
                            } else {
                                List<za1> b = b(optJSONArray, str, true);
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
