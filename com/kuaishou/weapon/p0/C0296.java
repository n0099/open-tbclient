package com.kuaishou.weapon.p0;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʻʿ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0296 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0296() {
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
    public static int m141(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics != null) {
                    return displayMetrics.densityDpi;
                }
                return -1;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (r3 != null) goto L33;
     */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject m142() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            DataInputStream dataInputStream = null;
            try {
                DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("lsmod").getInputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                try {
                                    break;
                                } catch (IOException unused) {
                                }
                            } else if (!TextUtils.isEmpty(readLine)) {
                                String m155 = C0298.m155(readLine);
                                if (m155.contains("-") && m155.contains(ParamableElem.DIVIDE_PARAM)) {
                                    String[] split = m155.replace(";;;", ParamableElem.DIVIDE_PARAM).split(ParamableElem.DIVIDE_PARAM);
                                    if (split.length > 1) {
                                        jSONObject.put(split[0], split[1]);
                                    }
                                }
                            }
                        } catch (Throwable unused2) {
                            dataInputStream = dataInputStream2;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                        }
                    }
                    dataInputStream2.close();
                } catch (Throwable unused4) {
                    bufferedReader = null;
                }
            } catch (Throwable unused5) {
                bufferedReader = null;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused6) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m143() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                str = Locale.getDefault().toString();
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m144(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m145() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = statFs.getBlockSize() * statFs.getBlockCount();
                return String.valueOf(j);
            }
            j = 0;
            return String.valueOf(j);
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static JSONObject m146() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                TimeZone timeZone = Calendar.getInstance().getTimeZone();
                if (timeZone != null) {
                    jSONObject.put("0", String.valueOf(timeZone.getOffset(System.currentTimeMillis()) / 1000));
                    jSONObject.put("1", timeZone.getID());
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
