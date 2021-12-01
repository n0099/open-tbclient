package com.kuaishou.weapon.un;

import android.content.Context;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f56753b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f56754c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(534997549, "Lcom/kuaishou/weapon/un/m0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(534997549, "Lcom/kuaishou/weapon/un/m0;");
                return;
            }
        }
        a = u1.a("x8aN0czB1Y3CzcfRzMrHjdvTzNDGx43708zQxsfrxs/TxtHQ");
        f56753b = u1.a("x8aN0czB1Y3CzcfRzMrHjdvTzNDGx43708zQxsfh0crHxMY=");
        f56754c = u1.a("wMzOjcbPx8bRx9HK1cbR0I3RytHWjcbH29ONwMzNxcrEjebH+9PgzM3FysTkz8zBws8=");
    }

    public m0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private boolean a(Context context, String str, Set set) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, str, set)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return false;
                }
                return a(telephonyManager.getClass(), str, set);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean a(Class cls, String str, Set set) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, cls, str, set)) == null) {
            if (str != null) {
                try {
                    if (set.size() <= 0 || !set.toString().contains(str)) {
                        return false;
                    }
                    return set.toString().contains(cls.getName());
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    private boolean a(Class cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, cls, str, clsArr)) == null) {
            try {
                return a(e.b(cls, str, clsArr));
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean a(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, method)) == null) ? method != null && Modifier.isNative(method.getModifiers()) : invokeL.booleanValue;
    }

    public int a(Context context, int i2, Set set) {
        InterceptResult invokeLIL;
        String str;
        boolean a2;
        Class cls;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, set)) == null) {
            try {
                if (ClassLoader.getSystemClassLoader() != null) {
                    switch (i2) {
                        case 13:
                            str = "getDeviceId";
                            a2 = a(context, str, set);
                            return a2 ? 1 : 0;
                        case 14:
                            str = "getSubscriberId";
                            a2 = a(context, str, set);
                            return a2 ? 1 : 0;
                        case 15:
                            str = "getSimSerialNumber";
                            a2 = a(context, str, set);
                            return a2 ? 1 : 0;
                        case 16:
                            cls = Settings.Secure.class;
                            str2 = "getString";
                            a2 = a(cls, str2, set);
                            return a2 ? 1 : 0;
                        case 17:
                            cls = StringBuilder.class;
                            str2 = "toString";
                            a2 = a(cls, str2, set);
                            return a2 ? 1 : 0;
                        case 18:
                            cls = Method.class;
                            str2 = "invoke";
                            a2 = a(cls, str2, set);
                            return a2 ? 1 : 0;
                        case 19:
                            cls = WifiInfo.class;
                            str2 = "getMacAddress";
                            a2 = a(cls, str2, set);
                            return a2 ? 1 : 0;
                        case 20:
                            cls = WifiInfo.class;
                            str2 = "getSSID";
                            a2 = a(cls, str2, set);
                            return a2 ? 1 : 0;
                        case 21:
                            cls = WifiInfo.class;
                            str2 = "getBSSID";
                            a2 = a(cls, str2, set);
                            return a2 ? 1 : 0;
                        default:
                            return 0;
                    }
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeLIL.intValue;
    }

    public Set a(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            HashSet hashSet = new HashSet();
            for (Object obj : set) {
                if (obj instanceof String) {
                    if (obj != null) {
                        String str = (String) obj;
                        if (!str.startsWith("android.app.ResourcesManager#") && !str.startsWith("android.view.LayoutInflater#")) {
                        }
                    }
                    hashSet.add(obj);
                } else if (obj instanceof Method) {
                    obj = ((Method) obj).getName();
                    hashSet.add(obj);
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", a(TelephonyManager.class, "getDeviceId", new Class[0]) ? 1 : 0);
                jSONObject.put("1", a(TelephonyManager.class, "getSubscriberId", new Class[0]) ? 1 : 0);
                jSONObject.put("2", a(TelephonyManager.class, "getSimSerialNumber", new Class[0]) ? 1 : 0);
                jSONObject.put("3", a(Location.class, "getLatitude", new Class[0]) ? 1 : 0);
                jSONObject.put("4", a(Location.class, "getLongitude", new Class[0]) ? 1 : 0);
                if (Build.VERSION.SDK_INT >= 26) {
                    jSONObject.put("5", a(Build.class, "getSerial", new Class[0]) ? 1 : 0);
                } else {
                    jSONObject.put("5", 0);
                }
                jSONObject.put("6", a(WifiInfo.class, "getMacAddress", new Class[0]) ? 1 : 0);
                jSONObject.put("7", a(WifiInfo.class, "getBSSID", new Class[0]) ? 1 : 0);
                jSONObject.put("8", a(WifiInfo.class, "getRssi", new Class[0]) ? 1 : 0);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
        if (r4 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Set<String> b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashSet hashSet = new HashSet();
            BufferedReader bufferedReader2 = null;
            try {
                HashSet<String> hashSet2 = new HashSet();
                bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                            hashSet2.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                for (String str : hashSet2) {
                    if (!str.contains(u1.a("wMzOjdDC1tHKyI3Q1sHQ19HC18Y=")) && !str.contains(u1.a("+9PM0MbH4dHKx8TGjcnC0Q=="))) {
                    }
                    hashSet.add(str);
                }
            } catch (Exception unused3) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused4) {
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        }
        return (Set) invokeV.objValue;
    }

    public Set<String> c() {
        Set keySet;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(f56753b);
                if (loadClass != null) {
                    Field declaredField = loadClass.getDeclaredField("sHookedMethodCallbacks");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(loadClass);
                    if (map == null || (keySet = map.keySet()) == null || keySet.size() <= 0) {
                        return null;
                    }
                    return a(keySet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public Set<String> d() {
        Set keySet;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(a);
                if (loadClass != null) {
                    Field declaredField = loadClass.getDeclaredField("methodCache");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(loadClass);
                    if (map == null || (keySet = map.keySet()) == null || keySet.size() <= 0) {
                        return null;
                    }
                    return a(keySet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }
}
