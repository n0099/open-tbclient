package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class e89 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, HashMap> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str);

        void b();

        void c(String str);

        void d();

        void e(boolean z);

        void f(boolean z);

        void g(int i);

        void h();

        void i();

        void j(String str);

        void k(int i);

        void onRecordEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755783605, "Lcom/repackage/e89;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755783605, "Lcom/repackage/e89;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "capture_timer_clear");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "capture_timer_start");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sex_type", Integer.valueOf(i));
            hashMap.put("event_name", "sex_event");
            hashMap.put("event_data", hashMap2);
            return hashMap;
        }
        return (HashMap) invokeI.objValue;
    }

    public static HashMap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (a.get(str) != null) {
                return a.get(str);
            }
            HashMap hashMap = null;
            char c = 65535;
            switch (str.hashCode()) {
                case -1909077165:
                    if (str.equals("startRecord")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1848594969:
                    if (str.equals("pauseRecord")) {
                        c = 1;
                        break;
                    }
                    break;
                case -815530368:
                    if (str.equals("resetRecord")) {
                        c = 2;
                        break;
                    }
                    break;
                case -793791417:
                    if (str.equals("startOverRecord")) {
                        c = 5;
                        break;
                    }
                    break;
                case 473974106:
                    if (str.equals("capture_timer_clear")) {
                        c = 3;
                        break;
                    }
                    break;
                case 488985455:
                    if (str.equals("capture_timer_start")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                hashMap = h();
            } else if (c == 1) {
                hashMap = f();
            } else if (c == 2) {
                hashMap = g();
            } else if (c == 3) {
                hashMap = a();
            } else if (c == 4) {
                hashMap = b();
            } else if (c == 5) {
                hashMap = i();
            }
            if (hashMap != null) {
                a.put(str, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap e(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Double.valueOf(d)})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_name", "audio_volume");
            hashMap.put("event_data", String.valueOf(Math.ceil(d)));
            return hashMap;
        }
        return (HashMap) invokeCommon.objValue;
    }

    public static HashMap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "game_pause");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_name", "recorder_video");
            hashMap2.put("event_data", hashMap);
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "game_reset");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_name", "recorder_video");
            hashMap2.put("event_data", hashMap);
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "game_start");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_name", "recorder_video");
            hashMap2.put("event_data", hashMap);
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", "game_start_over");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_name", "recorder_video");
            hashMap2.put("event_data", hashMap);
            return hashMap2;
        }
        return (HashMap) invokeV.objValue;
    }

    public static void j(HashMap<String, Object> hashMap, a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, hashMap, aVar) == null) || c89.f(hashMap) || aVar == null || (obj = hashMap.get("event_name")) == null || !(obj instanceof String)) {
            return;
        }
        String str = (String) obj;
        char c = 65535;
        int i = 0;
        switch (str.hashCode()) {
            case -1903331025:
                if (str.equals("show_text")) {
                    c = 0;
                    break;
                }
                break;
            case -1768834290:
                if (str.equals("game_end")) {
                    c = 4;
                    break;
                }
                break;
            case -1584838740:
                if (str.equals("filter_adjust_enable")) {
                    c = 11;
                    break;
                }
                break;
            case -1272940549:
                if (str.equals("game_is_ready")) {
                    c = '\n';
                    break;
                }
                break;
            case -708270859:
                if (str.equals("phone_shake")) {
                    c = 1;
                    break;
                }
                break;
            case -672934016:
                if (str.equals("case_reset")) {
                    c = 5;
                    break;
                }
                break;
            case -548493597:
                if (str.equals("need_volume")) {
                    c = '\t';
                    break;
                }
                break;
            case 902635637:
                if (str.equals("child_status")) {
                    c = '\b';
                    break;
                }
                break;
            case 967087977:
                if (str.equals("game_pause")) {
                    c = 2;
                    break;
                }
                break;
            case 969912325:
                if (str.equals("game_score")) {
                    c = 3;
                    break;
                }
                break;
            case 1000807605:
                if (str.equals("game_http")) {
                    c = '\f';
                    break;
                }
                break;
            case 1001154298:
                if (str.equals("game_time")) {
                    c = 7;
                    break;
                }
                break;
            case 1076032614:
                if (str.equals("need_face")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (hashMap.get("text_content") instanceof String) {
                    aVar.c((String) hashMap.get("text_content"));
                    return;
                }
                return;
            case 1:
                aVar.d();
                return;
            case 2:
            case 3:
                if (hashMap.get("game_score") != null) {
                    aVar.a(hashMap.get("game_score").toString());
                    return;
                }
                return;
            case 4:
                if (hashMap.get("game_score") != null) {
                    aVar.a(hashMap.get("game_score").toString());
                }
                aVar.onRecordEnd();
                return;
            case 5:
                aVar.h();
                return;
            case 6:
                aVar.b();
                return;
            case 7:
                if (hashMap.get("text_content") instanceof Float) {
                    try {
                        i = ((Float) hashMap.get("text_content")).intValue();
                    } catch (Exception e) {
                        x79.g(e);
                    }
                    aVar.g(i);
                    return;
                }
                return;
            case '\b':
                if (hashMap.get("isDefaultChild") != null) {
                    String obj2 = hashMap.get("isDefaultChild").toString();
                    if (!TextUtils.equals(obj2, "1.0") && !TextUtils.equals(obj2, "1")) {
                        r3 = false;
                    }
                    aVar.f(r3);
                    return;
                }
                return;
            case '\t':
                if (hashMap.get("volume_ability") != null) {
                    aVar.e(b89.a(hashMap.get("volume_ability").toString(), 0.0f) == 1.0f);
                    return;
                }
                return;
            case '\n':
                aVar.i();
                return;
            case 11:
                if (hashMap.get("globalBeautyMakeupFilter") == null || !(hashMap.get("globalBeautyMakeupFilter") instanceof Float)) {
                    return;
                }
                aVar.k(((Float) hashMap.get("globalBeautyMakeupFilter")).intValue());
                return;
            case '\f':
                if (hashMap.get("set_content") != null) {
                    aVar.j(hashMap.get("set_content").toString());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
