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
/* loaded from: classes5.dex */
public class k0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "Y29tLmp0anNiLnZpcnR1YWxkd3Nx";
    public static final String B = "Y29tLnR4eS5hbnl3aGVyZQ==";
    public static final String C = "Y29tLmRpbmd3ZWkueHVuaWpp";
    public static final String D = "bWUud2Vpc2h1LmV4cA==";
    public static final String E = "Y29tLnZhcmlhYmxlLmFwa2hvb2s=";
    public static final String F = "ZXUuZmFpcmNvZGUueGx1YQ==";
    public static final String G = "Y29tLnRvcGpvaG53dS5tYWdpc2s=";
    public static final String H = "Y29tLndpbmQuY290dGVy";
    public static final String I = "bW9iaS5hY3BtLmluc3BlY2thZ2U=";
    public static final String a = "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==";
    public static final String b = "Y29tLmJ1c2NvZGUud2hhdHNpbnB1dA==";
    public static final String c = "b3JnLmF1dG9qcy5hdXRvanM=";
    public static final String d = "ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=";
    public static final String e = "Y29tLnNhbmZlbmdhbmRyb2lkLmRhdGFmaWx0ZXI=";
    public static final String f = "aXQuZXZpbHNvY2tldC5kc3Bsb2l0";
    public static final String g = "dWsuZGlnaXRhbHNxdWlkLm5ldHNwb29mZXI=";
    public static final String h = "Y29tLm13ci5keg==";
    public static final String i = "Y29tLm1ldGFzcGxvaXQuc3RhZ2U=";
    public static final String j = "Y29tLng4enMuc2FuZGJveA==";
    public static final String k = "Y29tLmYxcGxheWVy";
    public static final String l = "Y29tLmNvZmZhY2UuaXZhZGVy";
    public static final String m = "Y29tLmRldmljZS5lbXVsYXRvci5wcnA=";
    public static final String n = "Y29tLnVuaXF1ZS5tb2JpbGVmYWtlcg==";
    public static final String o = "bmV0LmdkaS5tb2R1bGUuYXBweA==";
    public static final String p = "b3JnLm1va2VlLm1rc2V0dGluZ3M=";
    public static final String q = "Y29tLm1pbmkubGl2ZS5saXZl";
    public static final String r = "dG9wLm5pdW5haWp1bi5ibGFja2JveGEzMg==";
    public static final String s = "dG9wLm5pdW5haWp1bi5ibGFja2JveGE2NA==";
    public static final String t = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDMy";
    public static final String u = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDY0";
    public static final String v = "enBwLndqeS56cG9zZWQuaW5zdGFsbGVy";
    public static final String w = "Y29tLnNrLnNwcm9tb3Rlcg==";
    public static final String x = "Y29tLnNlc2FtZS5wcm94eQ==";
    public static final String y = "b3JnLnNhbmRyb3Byb3h5LmRyb255";
    public static final String z = "aW8ueHVkd29mdGVuY2VudG1t";
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

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                String[] strArr = {"/data/dalvik-cache/xposed_XResourcesSuperClass.dex", "data/dalvik-cache/xposed_XTypedArraySuperClass.dex", "/system/bin/androVM-prop", "/system/bin/nemuVM-prop", "/system/bin/ldmountsf", "/system/bin/noxspeedup", "/system/bin/nox-vbox-sf", "/system/bin/nox-prop", "/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd", "/system/bin/ttVM-prop", "/system/bin/3btrans", "/system/bin/droid4x-prop", "/ueventd.nox.rc", "/init.nox.rc"};
                for (int i2 = 0; i2 < 20; i2++) {
                    sb.append(new File(strArr[i2]).exists() ? "1" : "0");
                }
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v3 int)] */
    private JSONObject a(Context context, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, list)) == null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (a(context, list.get(i2))) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(i2);
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

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (!str.contains(".")) {
                    str = new String(d.a(str.getBytes(), 2));
                }
                context.getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private JSONObject m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (a(context, a)) {
                    jSONObject.put("0", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (a(context, p)) {
                    jSONObject.put("0", 1);
                }
                if (a(context, q)) {
                    jSONObject.put("1", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (a(context, f)) {
                    jSONObject.put("0", 1);
                }
                if (a(context, g)) {
                    jSONObject.put("1", 1);
                }
                if (a(context, h)) {
                    jSONObject.put("2", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (a(context, j)) {
                    jSONObject.put("0", 1);
                }
                if (a(context, k)) {
                    jSONObject.put("1", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (a(context, l)) {
                    jSONObject.put("0", 1);
                }
                if (a(context, m)) {
                    jSONObject.put("1", 1);
                }
                if (a(context, n)) {
                    jSONObject.put("2", 1);
                }
                if (a(context, o)) {
                    jSONObject.put("3", 1);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(r);
                arrayList.add(s);
                JSONObject a2 = a(context, arrayList);
                if (a2 != null) {
                    if (a2.length() > 0) {
                        return a2;
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

    public int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? a(context, i) ? 1 : 0 : invokeL.intValue;
    }

    public JSONObject c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(x);
                arrayList.add(y);
                JSONObject a2 = a(context, arrayList);
                if (a2 != null) {
                    if (a2.length() > 0) {
                        return a2;
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

    public JSONObject d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(t);
                arrayList.add(u);
                arrayList.add(H);
                arrayList.add(I);
                JSONObject a2 = a(context, arrayList);
                if (a2 != null) {
                    if (a2.length() > 0) {
                        return a2;
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

    public JSONObject e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(z);
                arrayList.add(A);
                arrayList.add(B);
                arrayList.add(C);
                arrayList.add(D);
                JSONObject a2 = a(context, arrayList);
                if (a2 != null) {
                    if (a2.length() > 0) {
                        return a2;
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

    public JSONObject f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(v);
                arrayList.add(w);
                arrayList.add(E);
                arrayList.add(F);
                arrayList.add(G);
                JSONObject a2 = a(context, arrayList);
                if (a2 != null) {
                    if (a2.length() > 0) {
                        return a2;
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

    public JSONObject g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            try {
                JSONObject n2 = n(context);
                if (n2 != null) {
                    if (n2.length() > 0) {
                        return n2;
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

    public JSONObject h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            try {
                JSONObject m2 = m(context);
                if (m2 != null) {
                    if (m2.length() > 0) {
                        return m2;
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

    public JSONObject i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", a(context, a) ? 1 : 0);
                jSONObject.put("1", a(context, b) ? 1 : 0);
                jSONObject.put("2", a(context, c) ? 1 : 0);
                jSONObject.put("3", a(context, d) ? 1 : 0);
                jSONObject.put("4", a(context, e) ? 1 : 0);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            try {
                JSONObject o2 = o(context);
                if (o2 != null) {
                    if (o2.length() > 0) {
                        return o2;
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

    public JSONObject k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            try {
                JSONObject p2 = p(context);
                if (p2 != null) {
                    if (p2.length() > 0) {
                        return p2;
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

    public JSONObject l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            try {
                JSONObject q2 = q(context);
                if (q2 != null) {
                    if (q2.length() > 0) {
                        return q2;
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
