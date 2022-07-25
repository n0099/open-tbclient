package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.pose.PoseAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class dy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Uri a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            return Uri.parse("content://" + str).buildUpon().appendPath(str2).build();
        }
        return (Uri) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? Base64.encodeToString(bp.m205a(str), 2) : (String) invokeL.objValue;
    }

    public static String a(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : hashMap.keySet()) {
                    jSONObject.put(str, hashMap.get(str));
                }
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? bp.b(Base64.decode(str, 2)) : (String) invokeL.objValue;
    }

    public static String b(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hashMap)) == null) {
            HashMap hashMap2 = new HashMap();
            if (hashMap != null) {
                hashMap2.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, hashMap.get(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) + "");
                hashMap2.put("description", hashMap.get("description") + "");
                String str = hashMap.get("awake_info");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        hashMap2.put("__planId__", String.valueOf(jSONObject.opt("__planId__")));
                        hashMap2.put("flow_id", String.valueOf(jSONObject.opt("flow_id")));
                        hashMap2.put("jobkey", String.valueOf(jSONObject.opt("jobkey")));
                        hashMap2.put("msg_id", String.valueOf(jSONObject.opt("msg_id")));
                        hashMap2.put("A", String.valueOf(jSONObject.opt("awake_app")));
                        hashMap2.put("B", String.valueOf(jSONObject.opt("awakened_app")));
                        hashMap2.put("module", String.valueOf(jSONObject.opt("awake_type")));
                    } catch (JSONException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
            }
            return a(hashMap2);
        }
        return (String) invokeL.objValue;
    }
}
