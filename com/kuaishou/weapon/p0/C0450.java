package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ﹳ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0450 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f657 = "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==";

    /* renamed from: ʻʻ  reason: contains not printable characters */
    public static final String f658 = "Y29tLmRpbmd3ZWkueHVuaWpp";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String f659 = "Y29tLmJ1c2NvZGUud2hhdHNpbnB1dA==";

    /* renamed from: ʼʼ  reason: contains not printable characters */
    public static final String f660 = "Y29tLnZhcmlhYmxlLmFwa2hvb2s=";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final String f661 = "b3JnLmF1dG9qcy5hdXRvanM=";

    /* renamed from: ʽʽ  reason: contains not printable characters */
    public static final String f662 = "bWUud2Vpc2h1LmV4cA==";

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final String f663 = "ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=";

    /* renamed from: ʾʾ  reason: contains not printable characters */
    public static final String f664 = "Y29tLnRvcGpvaG53dS5tYWdpc2s=";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final String f665 = "Y29tLnNhbmZlbmdhbmRyb2lkLmRhdGFmaWx0ZXI=";

    /* renamed from: ʿʿ  reason: contains not printable characters */
    public static final String f666 = "ZXUuZmFpcmNvZGUueGx1YQ==";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final String f667 = "aXQuZXZpbHNvY2tldC5kc3Bsb2l0";

    /* renamed from: ˆˆ  reason: contains not printable characters */
    public static final String f668 = "bW9iaS5hY3BtLmluc3BlY2thZ2U=";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final String f669 = "dWsuZGlnaXRhbHNxdWlkLm5ldHNwb29mZXI=";

    /* renamed from: ˉ  reason: contains not printable characters */
    public static final String f670 = "Y29tLm13ci5keg==";

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final String f671 = "Y29tLm1ldGFzcGxvaXQuc3RhZ2U=";

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final String f672 = "Y29tLng4enMuc2FuZGJveA==";

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String f673 = "Y29tLmYxcGxheWVy";

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String f674 = "Y29tLmNvZmZhY2UuaXZhZGVy";

    /* renamed from: ˑ  reason: contains not printable characters */
    public static final String f675 = "Y29tLmRldmljZS5lbXVsYXRvci5wcnA=";

    /* renamed from: י  reason: contains not printable characters */
    public static final String f676 = "Y29tLnVuaXF1ZS5tb2JpbGVmYWtlcg==";

    /* renamed from: ـ  reason: contains not printable characters */
    public static final String f677 = "bmV0LmdkaS5tb2R1bGUuYXBweA==";

    /* renamed from: ــ  reason: contains not printable characters */
    public static final String f678 = "Y29tLndpbmQuY290dGVy";

    /* renamed from: ٴ  reason: contains not printable characters */
    public static final String f679 = "b3JnLm1va2VlLm1rc2V0dGluZ3M=";

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static final String f680 = "Y29tLm1pbmkubGl2ZS5saXZl";

    /* renamed from: ᐧᐧ  reason: contains not printable characters */
    public static final String f681 = "Y29tLmp0anNiLnZpcnR1YWxkd3Nx";

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static final String f682 = "dG9wLm5pdW5haWp1bi5ibGFja2JveGEzMg==";

    /* renamed from: ᴵᴵ  reason: contains not printable characters */
    public static final String f683 = "Y29tLnR4eS5hbnl3aGVyZQ==";

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static final String f684 = "dG9wLm5pdW5haWp1bi5ibGFja2JveGE2NA==";

    /* renamed from: ᵔ  reason: contains not printable characters */
    public static final String f685 = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDMy";

    /* renamed from: ᵢ  reason: contains not printable characters */
    public static final String f686 = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDY0";

    /* renamed from: ⁱ  reason: contains not printable characters */
    public static final String f687 = "enBwLndqeS56cG9zZWQuaW5zdGFsbGVy";

    /* renamed from: ﹳ  reason: contains not printable characters */
    public static final String f688 = "Y29tLnNrLnNwcm9tb3Rlcg==";

    /* renamed from: ﹶ  reason: contains not printable characters */
    public static final String f689 = "Y29tLnNlc2FtZS5wcm94eQ==";

    /* renamed from: ﾞ  reason: contains not printable characters */
    public static final String f690 = "b3JnLnNhbmRyb3Byb3h5LmRyb255";

    /* renamed from: ﾞﾞ  reason: contains not printable characters */
    public static final String f691 = "aW8ueHVkd29mdGVuY2VudG1t";
    public transient /* synthetic */ FieldHolder $fh;

    public C0450() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m983() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                String[] strArr = {"/data/dalvik-cache/xposed_XResourcesSuperClass.dex", "data/dalvik-cache/xposed_XTypedArraySuperClass.dex", "/system/bin/androVM-prop", "/system/bin/nemuVM-prop", "/system/bin/ldmountsf", "/system/bin/noxspeedup", "/system/bin/nox-vbox-sf", "/system/bin/nox-prop", "/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd", "/system/bin/ttVM-prop", "/system/bin/3btrans", "/system/bin/droid4x-prop", "/ueventd.nox.rc", "/init.nox.rc"};
                for (int i = 0; i < 20; i++) {
                    sb.append(new File(strArr[i]).exists() ? "1" : "0");
                }
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v3 int)] */
    /* renamed from: ʻ  reason: contains not printable characters */
    private JSONObject m984(Context context, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, list)) == null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        for (int i = 0; i < list.size(); i++) {
                            if (m985(context, list.get(i))) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(i);
                                jSONObject.put(sb.toString(), 1);
                            }
                        }
                        return jSONObject;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m985(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (!str.contains(".")) {
                    str = new String(C0446.m974(str.getBytes(), 2));
                }
                context.getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    private JSONObject m986(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (m985(context, f657)) {
                    jSONObject.put("0", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: י  reason: contains not printable characters */
    private JSONObject m987(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (m985(context, f679)) {
                    jSONObject.put("0", 1);
                }
                if (m985(context, f680)) {
                    jSONObject.put("1", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ـ  reason: contains not printable characters */
    private JSONObject m988(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (m985(context, f667)) {
                    jSONObject.put("0", 1);
                }
                if (m985(context, f669)) {
                    jSONObject.put("1", 1);
                }
                if (m985(context, f670)) {
                    jSONObject.put("2", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ٴ  reason: contains not printable characters */
    private JSONObject m989(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (m985(context, f672)) {
                    jSONObject.put("0", 1);
                }
                if (m985(context, f673)) {
                    jSONObject.put("1", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    private JSONObject m990(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (m985(context, f674)) {
                    jSONObject.put("0", 1);
                }
                if (m985(context, f675)) {
                    jSONObject.put("1", 1);
                }
                if (m985(context, f676)) {
                    jSONObject.put("2", 1);
                }
                if (m985(context, f677)) {
                    jSONObject.put("3", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m991(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(f682);
                arrayList.add(f684);
                JSONObject m984 = m984(context, arrayList);
                if (m984 != null) {
                    if (m984.length() > 0) {
                        return m984;
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public int m992(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? m985(context, f671) ? 1 : 0 : invokeL.intValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public JSONObject m993(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(f689);
                arrayList.add(f690);
                JSONObject m984 = m984(context, arrayList);
                if (m984 != null) {
                    if (m984.length() > 0) {
                        return m984;
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

    /* renamed from: ʾ  reason: contains not printable characters */
    public JSONObject m994(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(f685);
                arrayList.add(f686);
                arrayList.add(f678);
                arrayList.add(f668);
                JSONObject m984 = m984(context, arrayList);
                if (m984 != null) {
                    if (m984.length() > 0) {
                        return m984;
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

    /* renamed from: ʿ  reason: contains not printable characters */
    public JSONObject m995(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(f691);
                arrayList.add(f681);
                arrayList.add(f683);
                arrayList.add(f658);
                arrayList.add(f662);
                JSONObject m984 = m984(context, arrayList);
                if (m984 != null) {
                    if (m984.length() > 0) {
                        return m984;
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

    /* renamed from: ˆ  reason: contains not printable characters */
    public JSONObject m996(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(f687);
                arrayList.add(f688);
                arrayList.add(f660);
                arrayList.add(f666);
                arrayList.add(f664);
                JSONObject m984 = m984(context, arrayList);
                if (m984 != null) {
                    if (m984.length() > 0) {
                        return m984;
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

    /* renamed from: ˈ  reason: contains not printable characters */
    public JSONObject m997(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            try {
                JSONObject m987 = m987(context);
                if (m987 != null) {
                    if (m987.length() > 0) {
                        return m987;
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

    /* renamed from: ˉ  reason: contains not printable characters */
    public JSONObject m998(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            try {
                JSONObject m986 = m986(context);
                if (m986 != null) {
                    if (m986.length() > 0) {
                        return m986;
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

    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONObject m999(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", m985(context, f657) ? 1 : 0);
                jSONObject.put("1", m985(context, f659) ? 1 : 0);
                jSONObject.put("2", m985(context, f661) ? 1 : 0);
                jSONObject.put("3", m985(context, f663) ? 1 : 0);
                jSONObject.put("4", m985(context, f665) ? 1 : 0);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public JSONObject m1000(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            try {
                JSONObject m988 = m988(context);
                if (m988 != null) {
                    if (m988.length() > 0) {
                        return m988;
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

    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m1001(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            try {
                JSONObject m989 = m989(context);
                if (m989 != null) {
                    if (m989.length() > 0) {
                        return m989;
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

    /* renamed from: ˏ  reason: contains not printable characters */
    public JSONObject m1002(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            try {
                JSONObject m990 = m990(context);
                if (m990 != null) {
                    if (m990.length() > 0) {
                        return m990;
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
}
