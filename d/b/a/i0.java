package d.b.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f69238a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f69239b = ":push";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(413431842, "Ld/b/a/i0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(413431842, "Ld/b/a/i0;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, null)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
        d.b.a.i0.f69238a = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = f69238a;
            if (TextUtils.isEmpty(str)) {
                try {
                    int myPid = Process.myPid();
                    Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            break;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                f69238a = a();
                if (h0.f69234b) {
                    h0.a("getProcessName, " + f69238a, null);
                }
                return f69238a;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str2 == null) {
                str2 = "ISO-8859-1";
            }
            try {
                return URLEncoder.encode(str, str2);
            } catch (UnsupportedEncodingException unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String d(String str, HashMap<String, String> hashMap, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, hashMap, str2)) == null) {
            StringBuilder sb = new StringBuilder(str);
            for (String str3 : hashMap.keySet()) {
                String c2 = c(str3, str2);
                String str4 = hashMap.get(str3);
                String c3 = str4 != null ? c(str4, str2) : "";
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(c2);
                sb.append("=");
                sb.append(c3);
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z)) == null) ? z ? "yes" : "no" : (String) invokeZ.objValue;
    }

    public static boolean f(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static boolean g(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONObject, jSONObject2)) == null) {
            if (jSONObject != null && jSONObject2 != null) {
                return jSONObject.toString().equals(jSONObject2.toString());
            }
            return f(jSONObject, jSONObject2);
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject h(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONObject, jSONObject2)) == null) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (JSONException e2) {
                h0.b(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String b2 = b(context);
            return b2 != null && b2.endsWith(f69239b);
        }
        return invokeL.booleanValue;
    }
}
