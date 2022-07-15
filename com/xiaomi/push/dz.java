package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.pose.PoseAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class dz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, context, str, i, str2) == null) {
            al.a(context).a(new ea(context, str, i, str2));
        }
    }

    public static void a(Context context, HashMap<String, String> hashMap) {
        eh m1244a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, hashMap) == null) || (m1244a = ed.a(context).m1244a()) == null) {
            return;
        }
        m1244a.a(context, hashMap);
    }

    public static void b(Context context, HashMap<String, String> hashMap) {
        eh m1244a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, hashMap) == null) || (m1244a = ed.a(context).m1244a()) == null) {
            return;
        }
        m1244a.c(context, hashMap);
    }

    public static void c(Context context, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, i, str2) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, String.valueOf(i));
            hashMap.put("description", str2);
            int a = ed.a(context).a();
            if (a != 1) {
                if (a != 2) {
                    if (a == 3) {
                        a(context, hashMap);
                    }
                }
                c(context, hashMap);
            } else {
                a(context, hashMap);
            }
            b(context, hashMap);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public static void c(Context context, HashMap<String, String> hashMap) {
        eh m1244a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, context, hashMap) == null) || (m1244a = ed.a(context).m1244a()) == null) {
            return;
        }
        m1244a.b(context, hashMap);
    }
}
