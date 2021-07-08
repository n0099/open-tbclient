package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.pose.PoseAR;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class dw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65536, null, context, str, i2, str2) == null) {
            ai.a(context).a(new dx(context, str, i2, str2));
        }
    }

    public static void a(Context context, HashMap<String, String> hashMap) {
        ee m283a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, hashMap) == null) || (m283a = ea.a(context).m283a()) == null) {
            return;
        }
        m283a.a(context, hashMap);
    }

    public static void b(Context context, HashMap<String, String> hashMap) {
        ee m283a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, hashMap) == null) || (m283a = ea.a(context).m283a()) == null) {
            return;
        }
        m283a.c(context, hashMap);
    }

    public static void c(Context context, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, i2, str2) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, String.valueOf(i2));
            hashMap.put("description", str2);
            int a2 = ea.a(context).a();
            if (a2 != 1) {
                if (a2 != 2) {
                    if (a2 == 3) {
                        a(context, hashMap);
                    }
                }
                c(context, hashMap);
            } else {
                a(context, hashMap);
            }
            b(context, hashMap);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public static void c(Context context, HashMap<String, String> hashMap) {
        ee m283a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, hashMap) == null) || (m283a = ea.a(context).m283a()) == null) {
            return;
        }
        m283a.b(context, hashMap);
    }
}
