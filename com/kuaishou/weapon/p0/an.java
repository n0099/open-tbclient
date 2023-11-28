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
public class an {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "de.robv.android.xposed.XposedHelpers";
    public static final String b = "de.robv.android.xposed.XposedBridge";
    public static final String c = "com.elderdrivers.riru.edxp.config.EdXpConfigGlobal";
    public transient /* synthetic */ FieldHolder $fh;

    public an() {
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
                if (set.size() <= 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, method)) == null) {
            if (method != null && Modifier.isNative(method.getModifiers())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(Context context, int i, Set set) {
        InterceptResult invokeLIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i, set)) == null) {
            if (ClassLoader.getSystemClassLoader() != null) {
                switch (i) {
                    case 13:
                        z = a(context, "getDeviceId", set);
                        break;
                    case 14:
                        z = a(context, "getSubscriberId", set);
                        break;
                    case 15:
                        z = a(context, "getSimSerialNumber", set);
                        break;
                    case 16:
                        z = a(Settings.Secure.class, "getString", set);
                        break;
                    case 17:
                        z = a(StringBuilder.class, "toString", set);
                        break;
                    case 18:
                        z = a(Method.class, DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, set);
                        break;
                    case 19:
                        z = a(WifiInfo.class, "getMacAddress", set);
                        break;
                    case 20:
                        z = a(WifiInfo.class, "getSSID", set);
                        break;
                    case 21:
                        z = a(WifiInfo.class, "getBSSID", set);
                        break;
                }
                if (z) {
                    return 0;
                }
                return 1;
            }
            z = false;
            if (z) {
            }
        } else {
            return invokeLIL.intValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
        if (r4 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Set<String> a() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
                    if (str.contains("com.saurik.substrate")) {
                        hashSet.add(str);
                    } else if (str.contains("XposedBridge.jar")) {
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
            if (hashSet.size() <= 0) {
                return null;
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public Set a(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, set)) == null) {
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
                    hashSet.add(((Method) obj).getName());
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public boolean a(Class cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, cls, str, clsArr)) == null) {
            try {
                return a(bh.a(cls, str, clsArr));
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public Set<String> b() {
        Set keySet;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(b);
                if (loadClass != null) {
                    Field declaredField = loadClass.getDeclaredField("sHookedMethodCallbacks");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(loadClass);
                    if (map != null && (keySet = map.keySet()) != null && keySet.size() > 0) {
                        return a(keySet);
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public Set<String> c() {
        Set keySet;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(a);
                if (loadClass != null) {
                    Field declaredField = loadClass.getDeclaredField("methodCache");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(loadClass);
                    if (map != null && (keySet = map.keySet()) != null && keySet.size() > 0) {
                        return a(keySet);
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public JSONObject b(Set set) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, set)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (ClassLoader.getSystemClassLoader() != null && set.size() > 0) {
                    int i7 = 1;
                    if (a(Class.class, "forName", set)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    jSONObject.put("0", i);
                    if (a(ClassLoader.class, "loadClass", set)) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    jSONObject.put("1", i2);
                    if (a(Throwable.class, "getStackTrace", set)) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    jSONObject.put("2", i3);
                    if (a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 2), set)) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    jSONObject.put("3", i4);
                    if (a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkQXBwbGljYXRpb25z", 2), set)) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    jSONObject.put("4", i5);
                    if (a(ActivityManager.class, "getRunningServices", set)) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    jSONObject.put("5", i6);
                    if (!a(JSONObject.class, "toString", set)) {
                        i7 = 0;
                    }
                    jSONObject.put("6", i7);
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject d() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                int i11 = 0;
                if (a(TelephonyManager.class, "getDeviceId", new Class[0])) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("0", i);
                if (a(TelephonyManager.class, "getSubscriberId", new Class[0])) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("1", i2);
                if (a(TelephonyManager.class, "getSimSerialNumber", new Class[0])) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("2", i3);
                if (a(Location.class, "getLatitude", new Class[0])) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject.put("3", i4);
                if (a(Location.class, "getLongitude", new Class[0])) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                jSONObject.put("4", i5);
                if (Build.VERSION.SDK_INT >= 26) {
                    if (a(Build.class, "getSerial", new Class[0])) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    jSONObject.put("5", i10);
                } else {
                    jSONObject.put("5", 0);
                }
                if (a(WifiInfo.class, "getMacAddress", new Class[0])) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                jSONObject.put("6", i6);
                if (a(WifiInfo.class, "getBSSID", new Class[0])) {
                    i7 = 1;
                } else {
                    i7 = 0;
                }
                jSONObject.put("7", i7);
                if (a(WifiInfo.class, "getRssi", new Class[0])) {
                    i8 = 1;
                } else {
                    i8 = 0;
                }
                jSONObject.put("8", i8);
                if (a(Class.class, "forName", String.class)) {
                    i9 = 1;
                } else {
                    i9 = 0;
                }
                jSONObject.put("9", i9);
                if (a(ActivityManager.class, "getRunningServices", Integer.TYPE)) {
                    i11 = 1;
                }
                jSONObject.put("10", i11);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                jSONObject = new JSONObject();
                z = true;
                int i7 = 0;
                boolean a2 = a(Cipher.class, "doFinal", byte[].class);
                if (a2) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("0", i);
                boolean a3 = a(SecureRandom.class, "setSeed", byte[].class);
                if (a3) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("1", i2);
                if (a3) {
                    a2 = true;
                }
                boolean a4 = a(MessageDigest.class, StickerDataChangeType.UPDATE, byte[].class);
                if (a4) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("2", i3);
                if (a4) {
                    a2 = true;
                }
                boolean a5 = a(MessageDigest.class, "getInstance", String.class);
                if (a5) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject.put("3", i4);
                if (a5) {
                    a2 = true;
                }
                boolean a6 = a(Uri.class, "parse", String.class);
                if (a6) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                jSONObject.put("4", i5);
                if (a6) {
                    a2 = true;
                }
                boolean a7 = a(SQLiteDatabase.class, "execSQL", String.class);
                if (a7) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                jSONObject.put("5", i6);
                if (a7) {
                    a2 = true;
                }
                boolean a8 = a(Activity.class, "finish", new Class[0]);
                if (a8) {
                    i7 = 1;
                }
                jSONObject.put("6", i7);
                if (!a8) {
                    z = a2;
                }
            } catch (Exception unused) {
            }
            if (!z) {
                return null;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                jSONObject = new JSONObject();
                int i7 = 0;
                boolean a2 = a(JSONObject.class, "toString", new Class[0]);
                if (a2) {
                    if (a2) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    jSONObject.put("0", i6);
                }
                boolean a3 = a(TextUtils.class, "isEmpty", CharSequence.class);
                if (a3) {
                    if (a3) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    jSONObject.put("1", i5);
                }
                boolean a4 = a(JSONArray.class, "toString", new Class[0]);
                if (a4) {
                    if (a4) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    jSONObject.put("2", i4);
                }
                boolean a5 = a(Cipher.class, "doFinal", byte[].class);
                if (a5) {
                    if (a5) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    jSONObject.put("3", i3);
                }
                boolean a6 = a(ByteArrayOutputStream.class, "toByteArray", new Class[0]);
                if (a6) {
                    if (a6) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    jSONObject.put("4", i2);
                }
                boolean a7 = a(FileOutputStream.class, "write", byte[].class);
                if (a7) {
                    if (a7) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    jSONObject.put("5", i);
                }
                boolean a8 = a(HttpURLConnection.class, "setRequestProperty", String.class, String.class);
                if (a8) {
                    if (a8) {
                        i7 = 1;
                    }
                    jSONObject.put("6", i7);
                }
            } catch (Exception unused) {
            }
            if (jSONObject.length() <= 0) {
                return null;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject e() {
        int i;
        int i2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                int i3 = 1;
                boolean a2 = a(MediaRecorder.class, "setOutputFile", String.class);
                if (a2) {
                    if (a2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    jSONObject.put("0", i2);
                }
                boolean a3 = a(Camera.class, "takePicture", Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class);
                if (a3) {
                    if (a3) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    jSONObject.put("1", i);
                }
                boolean a4 = a(MediaPlayer.class, "setDataSource", Context.class, Uri.class);
                if (a4) {
                    if (!a4) {
                        i3 = 0;
                    }
                    jSONObject.put("2", i3);
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
}
