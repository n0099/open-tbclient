package com.repackage;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class eu3 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755725170, "Lcom/repackage/eu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755725170, "Lcom/repackage/eu3;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("494433", ".mp3");
        a.put("524946", ".wav");
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b : bArr) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (upperCase.length() < 2) {
                    sb.append(0);
                }
                sb.append(upperCase);
            }
            String sb2 = sb.toString();
            if (tg1.a) {
                Log.e("AudioDataUtils", "audio buffer header: " + sb2);
            }
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f)) == null) ? f <= 1.0f && f >= 0.0f : invokeF.booleanValue;
    }

    public static cu3 c(fu3 fu3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fu3Var)) == null) {
            cu3 cu3Var = new cu3();
            cu3Var.a = fu3Var.b;
            cu3Var.e = fu3Var.autoplay;
            cu3Var.f = fu3Var.loop;
            cu3Var.c = fu3Var.src;
            cu3Var.d = fu3Var.startTime;
            cu3Var.g = fu3Var.obeyMuteSwitch;
            cu3Var.i = fu3Var.volume;
            cu3Var.j = i().toString();
            return cu3Var;
        }
        return (cu3) invokeL.objValue;
    }

    public static String d(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            String substring = lastIndexOf != -1 ? str.substring(lastIndexOf) : "";
            return "/" + j03.f0() + "/" + str.hashCode() + substring;
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = tc2.p() + "/usr";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return File.separator + "bdata" + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String e = e();
            return (!j() || TextUtils.isEmpty(e)) ? AppRuntime.getAppContext().getCacheDir().getAbsolutePath() : e;
        }
        return (String) invokeV.objValue;
    }

    public static String h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr == null || 3 > bArr.length) {
                return "";
            }
            byte[] bArr2 = new byte[3];
            for (int i = 0; i < 3; i++) {
                bArr2[i] = bArr[i];
            }
            return a.get(a(bArr2));
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("onCanplay", "canplay");
                jSONObject.put("onPlay", "play");
                jSONObject.put("onEnded", "ended");
                jSONObject.put(MissionEvent.MESSAGE_PAUSE, "pause");
                jSONObject.put("onSeeking", "seeking");
                jSONObject.put("onSeeked", "seeked");
                jSONObject.put(MissionEvent.MESSAGE_STOP, IntentConfig.STOP);
                jSONObject.put("onError", "error");
                jSONObject.put("onTimeUpdate", "timeupdate");
                jSONObject.put("onBufferingUpdate", "buffered");
                jSONObject.put("onWaiting", "waiting");
            } catch (Exception e) {
                if (tg1.a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? "mounted".equals(Environment.getExternalStorageState()) : invokeV.booleanValue;
    }
}
