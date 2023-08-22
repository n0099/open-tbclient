package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public class l3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l3() {
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

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, null)) != null) {
            return invokeV.intValue;
        }
        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = (FileInputStream) Class.forName("java.io.FileInputStream").getConstructor(String.class).newInstance("/sys/class/power_supply/usb/online");
            if (fileInputStream != null) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream), 1000);
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        if (TextUtils.equals(readLine, "1")) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable unused) {
                            }
                            return 1;
                        }
                    }
                    bufferedReader = bufferedReader2;
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return 0;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return 0;
        } catch (Throwable unused5) {
        }
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), str, 0);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str.contains("http")) {
                str = str.replace("https://", "").replace("http://", "");
            }
            return str.contains("/") ? str.substring(0, str.indexOf("/")) : str;
        }
        return (String) invokeL.objValue;
    }

    public static Set a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) context.getSystemService("accessibility")).getInstalledAccessibilityServiceList();
                HashSet hashSet = new HashSet();
                for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
                    if (accessibilityServiceInfo != null && !TextUtils.isEmpty(accessibilityServiceInfo.getId())) {
                        hashSet.add(accessibilityServiceInfo.getId());
                    }
                }
                if (hashSet.size() > 0) {
                    return hashSet;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static Set a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONArray)) == null) {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        HashSet hashSet = new HashSet();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(jSONArray.get(i));
                        }
                        return hashSet;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (Set) invokeL.objValue;
    }

    public static Set b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
                HashSet hashSet = new HashSet();
                for (InputMethodInfo inputMethodInfo : inputMethodList) {
                    hashSet.add(inputMethodInfo.getId().split("/")[0]);
                }
                if (hashSet.size() <= 0) {
                    return null;
                }
                return hashSet;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeL.objValue;
    }

    public static int c(Context context) {
        int i;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                if (configuration.keyboard != 1) {
                    if (configuration.hardKeyboardHidden != 2) {
                        i = 0;
                        return i ^ 1;
                    }
                }
                i = 1;
                return i ^ 1;
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return a(context, "pointer_location");
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                return a(context, "show_touches");
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
