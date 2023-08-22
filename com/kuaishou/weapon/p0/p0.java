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
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
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
/* loaded from: classes10.dex */
public class p0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "de.robv.android.xposed.XposedHelpers";
    public static final String b = "de.robv.android.xposed.XposedBridge";
    public static final String c = "com.elderdrivers.riru.edxp.config.EdXpConfigGlobal";
    public transient /* synthetic */ FieldHolder $fh;

    public p0() {
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

    private boolean a(Context context, String str, Set set) {
        InterceptResult invokeLLL;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, context, str, set)) == null) {
            try {
                if (set.size() > 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    return a(telephonyManager.getClass(), str, set);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean a(Class cls, String str, Set set) {
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

    private boolean a(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, method)) == null) ? method != null && Modifier.isNative(method.getModifiers()) : invokeL.booleanValue;
    }

    public int a(Context context, int i, Set set) {
        InterceptResult invokeLIL;
        String str;
        boolean a2;
        Class cls;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i, set)) == null) {
            try {
                if (ClassLoader.getSystemClassLoader() != null) {
                    switch (i) {
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
                            str2 = DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST;
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

    public JSONObject a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        boolean a2;
        boolean a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                jSONObject = new JSONObject();
                a2 = a(Cipher.class, "doFinal", byte[].class);
                jSONObject.put("0", a2 ? 1 : 0);
                boolean a4 = a(SecureRandom.class, "setSeed", byte[].class);
                jSONObject.put("1", a4 ? 1 : 0);
                if (a4) {
                    a2 = true;
                }
                boolean a5 = a(MessageDigest.class, StickerDataChangeType.UPDATE, byte[].class);
                jSONObject.put("2", a5 ? 1 : 0);
                if (a5) {
                    a2 = true;
                }
                boolean a6 = a(MessageDigest.class, "getInstance", String.class);
                jSONObject.put("3", a6 ? 1 : 0);
                if (a6) {
                    a2 = true;
                }
                boolean a7 = a(Uri.class, "parse", String.class);
                jSONObject.put("4", a7 ? 1 : 0);
                if (a7) {
                    a2 = true;
                }
                boolean a8 = a(SQLiteDatabase.class, "execSQL", String.class);
                jSONObject.put("5", a8 ? 1 : 0);
                if (a8) {
                    a2 = true;
                }
                a3 = a(Activity.class, "finish", new Class[0]);
                jSONObject.put("6", a3 ? 1 : 0);
            } catch (Exception unused) {
            }
            if (a3 ? true : a2) {
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject a(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (ClassLoader.getSystemClassLoader() != null && set.size() > 0) {
                    jSONObject.put("0", a(Class.class, "forName", set) ? 1 : 0);
                    jSONObject.put("1", a(ClassLoader.class, "loadClass", set) ? 1 : 0);
                    jSONObject.put("2", a(Throwable.class, "getStackTrace", set) ? 1 : 0);
                    jSONObject.put("3", a(PackageManager.class, d.b("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 2), set) ? 1 : 0);
                    jSONObject.put("4", a(PackageManager.class, d.b("Z2V0SW5zdGFsbGVkQXBwbGljYXRpb25z", 2), set) ? 1 : 0);
                    jSONObject.put("5", a(ActivityManager.class, "getRunningServices", set) ? 1 : 0);
                    jSONObject.put("6", a(JSONObject.class, "toString", set) ? 1 : 0);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public boolean a(Class cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, cls, str, clsArr)) == null) {
            try {
                return a(h1.b(cls, str, clsArr));
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public Set b(Set set) {
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

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
                jSONObject.put("9", a(Class.class, "forName", String.class) ? 1 : 0);
                jSONObject.put("10", a(ActivityManager.class, "getRunningServices", Integer.TYPE) ? 1 : 0);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                boolean a2 = a(MediaRecorder.class, "setOutputFile", String.class);
                if (a2) {
                    jSONObject.put("0", a2 ? 1 : 0);
                }
                boolean a3 = a(Camera.class, "takePicture", Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class);
                if (a3) {
                    jSONObject.put("1", a3 ? 1 : 0);
                }
                boolean a4 = a(MediaPlayer.class, "setDataSource", Context.class, Uri.class);
                if (a4) {
                    jSONObject.put("2", a4 ? 1 : 0);
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

    public JSONObject d() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                jSONObject = new JSONObject();
                boolean a2 = a(JSONObject.class, "toString", new Class[0]);
                if (a2) {
                    jSONObject.put("0", a2 ? 1 : 0);
                }
                boolean a3 = a(TextUtils.class, "isEmpty", CharSequence.class);
                if (a3) {
                    jSONObject.put("1", a3 ? 1 : 0);
                }
                boolean a4 = a(JSONArray.class, "toString", new Class[0]);
                if (a4) {
                    jSONObject.put("2", a4 ? 1 : 0);
                }
                boolean a5 = a(Cipher.class, "doFinal", byte[].class);
                if (a5) {
                    jSONObject.put("3", a5 ? 1 : 0);
                }
                boolean a6 = a(ByteArrayOutputStream.class, "toByteArray", new Class[0]);
                if (a6) {
                    jSONObject.put("4", a6 ? 1 : 0);
                }
                boolean a7 = a(FileOutputStream.class, "write", byte[].class);
                if (a7) {
                    jSONObject.put("5", a7 ? 1 : 0);
                }
                boolean a8 = a(HttpURLConnection.class, "setRequestProperty", String.class, String.class);
                if (a8) {
                    jSONObject.put("6", a8 ? 1 : 0);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Set<String> e() {
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

    public Set<String> f() {
        Set keySet;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(b);
                if (loadClass != null) {
                    Field declaredField = loadClass.getDeclaredField("sHookedMethodCallbacks");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(loadClass);
                    if (map == null || (keySet = map.keySet()) == null || keySet.size() <= 0) {
                        return null;
                    }
                    return b(keySet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public Set<String> g() {
        Set keySet;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(a);
                if (loadClass != null) {
                    Field declaredField = loadClass.getDeclaredField("methodCache");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(loadClass);
                    if (map == null || (keySet = map.keySet()) == null || keySet.size() <= 0) {
                        return null;
                    }
                    return b(keySet);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }
}
