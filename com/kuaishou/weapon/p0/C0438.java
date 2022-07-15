package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Camera;
import android.location.Location;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ᴵᴵ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0438 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f614 = "de.robv.android.xposed.XposedHelpers";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String f615 = "de.robv.android.xposed.XposedBridge";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final String f616 = "com.elderdrivers.riru.edxp.config.EdXpConfigGlobal";
    public transient /* synthetic */ FieldHolder $fh;

    public C0438() {
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
    private boolean m923(Context context, String str, Set set) {
        InterceptResult invokeLLL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, context, str, set)) == null) {
            try {
                if (set.size() > 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    return m924(telephonyManager.getClass(), str, set);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m924(Class cls, String str, Set set) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, cls, str, set)) == null) {
            if (str != null) {
                try {
                    if (set.size() > 0 && set.toString().contains(str)) {
                        if (set.toString().contains(cls.getName())) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m925(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, method)) == null) ? method != null && Modifier.isNative(method.getModifiers()) : invokeL.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m926(Context context, int i, Set set) {
        InterceptResult invokeLIL;
        String str;
        boolean m923;
        Class cls;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i, set)) == null) {
            try {
                if (ClassLoader.getSystemClassLoader() != null) {
                    switch (i) {
                        case 13:
                            str = "getDeviceId";
                            m923 = m923(context, str, set);
                            return m923 ? 1 : 0;
                        case 14:
                            str = "getSubscriberId";
                            m923 = m923(context, str, set);
                            return m923 ? 1 : 0;
                        case 15:
                            str = "getSimSerialNumber";
                            m923 = m923(context, str, set);
                            return m923 ? 1 : 0;
                        case 16:
                            cls = Settings.Secure.class;
                            str2 = SharedPreferenceManager.OPERATION_GET_STRING;
                            m923 = m924(cls, str2, set);
                            return m923 ? 1 : 0;
                        case 17:
                            cls = StringBuilder.class;
                            str2 = "toString";
                            m923 = m924(cls, str2, set);
                            return m923 ? 1 : 0;
                        case 18:
                            cls = Method.class;
                            str2 = "invoke";
                            m923 = m924(cls, str2, set);
                            return m923 ? 1 : 0;
                        case 19:
                            cls = WifiInfo.class;
                            str2 = "getMacAddress";
                            m923 = m924(cls, str2, set);
                            return m923 ? 1 : 0;
                        case 20:
                            cls = WifiInfo.class;
                            str2 = "getSSID";
                            m923 = m924(cls, str2, set);
                            return m923 ? 1 : 0;
                        case 21:
                            cls = WifiInfo.class;
                            str2 = "getBSSID";
                            m923 = m924(cls, str2, set);
                            return m923 ? 1 : 0;
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m927() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        boolean m929;
        boolean m9292;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                jSONObject = new JSONObject();
                m929 = m929(Cipher.class, "doFinal", byte[].class);
                jSONObject.put("0", m929 ? 1 : 0);
                boolean m9293 = m929(SecureRandom.class, "setSeed", byte[].class);
                jSONObject.put("1", m9293 ? 1 : 0);
                if (m9293) {
                    m929 = true;
                }
                boolean m9294 = m929(MessageDigest.class, "update", byte[].class);
                jSONObject.put("2", m9294 ? 1 : 0);
                if (m9294) {
                    m929 = true;
                }
                boolean m9295 = m929(MessageDigest.class, "getInstance", String.class);
                jSONObject.put("3", m9295 ? 1 : 0);
                if (m9295) {
                    m929 = true;
                }
                boolean m9296 = m929(Uri.class, "parse", String.class);
                jSONObject.put("4", m9296 ? 1 : 0);
                if (m9296) {
                    m929 = true;
                }
                boolean m9297 = m929(SQLiteDatabase.class, "execSQL", String.class);
                jSONObject.put("5", m9297 ? 1 : 0);
                if (m9297) {
                    m929 = true;
                }
                m9292 = m929(Activity.class, "finish", new Class[0]);
                jSONObject.put("6", m9292 ? 1 : 0);
            } catch (Exception unused) {
            }
            if (m9292 ? true : m929) {
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m928(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (ClassLoader.getSystemClassLoader() != null && set.size() > 0) {
                    jSONObject.put("0", m924(Class.class, "forName", set) ? 1 : 0);
                    jSONObject.put("1", m924(ClassLoader.class, "loadClass", set) ? 1 : 0);
                    jSONObject.put("2", m924(Throwable.class, "getStackTrace", set) ? 1 : 0);
                    jSONObject.put("3", m924(PackageManager.class, C0446.m976("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 2), set) ? 1 : 0);
                    jSONObject.put("4", m924(PackageManager.class, C0446.m976("Z2V0SW5zdGFsbGVkQXBwbGljYXRpb25z", 2), set) ? 1 : 0);
                    jSONObject.put("5", m924(ActivityManager.class, "getRunningServices", set) ? 1 : 0);
                    jSONObject.put("6", m924(JSONObject.class, "toString", set) ? 1 : 0);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m929(Class cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, cls, str, clsArr)) == null) {
            try {
                return m925(C0433.m862(cls, str, clsArr));
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public Set m930(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, set)) == null) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONObject m931() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", m929(TelephonyManager.class, "getDeviceId", new Class[0]) ? 1 : 0);
                jSONObject.put("1", m929(TelephonyManager.class, "getSubscriberId", new Class[0]) ? 1 : 0);
                jSONObject.put("2", m929(TelephonyManager.class, "getSimSerialNumber", new Class[0]) ? 1 : 0);
                jSONObject.put("3", m929(Location.class, "getLatitude", new Class[0]) ? 1 : 0);
                jSONObject.put("4", m929(Location.class, "getLongitude", new Class[0]) ? 1 : 0);
                if (Build.VERSION.SDK_INT >= 26) {
                    jSONObject.put("5", m929(Build.class, "getSerial", new Class[0]) ? 1 : 0);
                } else {
                    jSONObject.put("5", 0);
                }
                jSONObject.put("6", m929(WifiInfo.class, "getMacAddress", new Class[0]) ? 1 : 0);
                jSONObject.put("7", m929(WifiInfo.class, "getBSSID", new Class[0]) ? 1 : 0);
                jSONObject.put("8", m929(WifiInfo.class, "getRssi", new Class[0]) ? 1 : 0);
                jSONObject.put("9", m929(Class.class, "forName", String.class) ? 1 : 0);
                jSONObject.put("10", m929(ActivityManager.class, "getRunningServices", Integer.TYPE) ? 1 : 0);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public JSONObject m932() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                boolean m929 = m929(MediaRecorder.class, "setOutputFile", String.class);
                if (m929) {
                    jSONObject.put("0", m929 ? 1 : 0);
                }
                boolean m9292 = m929(Camera.class, "takePicture", Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class);
                if (m9292) {
                    jSONObject.put("1", m9292 ? 1 : 0);
                }
                boolean m9293 = m929(MediaPlayer.class, "setDataSource", Context.class, Uri.class);
                if (m9293) {
                    jSONObject.put("2", m9293 ? 1 : 0);
                }
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public JSONObject m933() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                jSONObject = new JSONObject();
                boolean m929 = m929(JSONObject.class, "toString", new Class[0]);
                if (m929) {
                    jSONObject.put("0", m929 ? 1 : 0);
                }
                boolean m9292 = m929(TextUtils.class, "isEmpty", CharSequence.class);
                if (m9292) {
                    jSONObject.put("1", m9292 ? 1 : 0);
                }
                boolean m9293 = m929(JSONArray.class, "toString", new Class[0]);
                if (m9293) {
                    jSONObject.put("2", m9293 ? 1 : 0);
                }
                boolean m9294 = m929(Cipher.class, "doFinal", byte[].class);
                if (m9294) {
                    jSONObject.put("3", m9294 ? 1 : 0);
                }
                boolean m9295 = m929(ByteArrayOutputStream.class, "toByteArray", new Class[0]);
                if (m9295) {
                    jSONObject.put("4", m9295 ? 1 : 0);
                }
                boolean m9296 = m929(FileOutputStream.class, AlbumActivityConfig.FROM_WRITE, byte[].class);
                if (m9296) {
                    jSONObject.put("5", m9296 ? 1 : 0);
                }
                boolean m9297 = m929(HttpURLConnection.class, "setRequestProperty", String.class, String.class);
                if (m9297) {
                    jSONObject.put("6", m9297 ? 1 : 0);
                }
            } catch (Exception unused) {
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
        if (r4 != null) goto L34;
     */
    /* renamed from: ʿ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Set<String> m934() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
                    if (str.contains("com.saurik.substrate") || str.contains("XposedBridge.jar")) {
                        hashSet.add(str);
                    }
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

    /* renamed from: ˆ  reason: contains not printable characters */
    public Set<String> m935() {
        Set keySet;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(f615);
                if (loadClass != null) {
                    Field declaredField = loadClass.getDeclaredField("sHookedMethodCallbacks");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(loadClass);
                    if (map == null || (keySet = map.keySet()) == null || keySet.size() <= 0) {
                        return null;
                    }
                    return m930(keySet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public Set<String> m936() {
        Set keySet;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(f614);
                if (loadClass != null) {
                    Field declaredField = loadClass.getDeclaredField("methodCache");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(loadClass);
                    if (map == null || (keySet = map.keySet()) == null || keySet.size() <= 0) {
                        return null;
                    }
                    return m930(keySet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }
}
