package com.repackage;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.room.RoomMasterTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.h02;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ng3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755470505, "Lcom/repackage/ng3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755470505, "Lcom/repackage/ng3;");
                return;
            }
        }
        a = eh1.a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String n = t03.J().r().V().n("mPage");
            if (TextUtils.isEmpty(n)) {
                return str;
            }
            try {
                List<String> c = me3.c(new URI(n).getRawQuery());
                if (c.size() > 0) {
                    for (int i = 0; i < c.size(); i++) {
                        String str2 = c.get(i);
                        if (!TextUtils.isEmpty(str2)) {
                            String[] split = str2.split("=");
                            if (split.length > 1) {
                                str = me3.a(str, split[0], split[1]);
                            }
                        }
                    }
                }
                return str;
            } catch (URISyntaxException e) {
                if (a) {
                    e.printStackTrace();
                }
                ux1.i("SwanWebModeUtils", "appendWebUrlQuery: " + e.getMessage());
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"BDOfflineUrl"})
    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (h02.b.a()) {
                str = d() + "?appKey=" + t03.J().r().getAppId();
            }
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String e = e();
            String valueOf = String.valueOf(mg3.c().g());
            String a2 = a(str);
            String c = c();
            ux1.i("SwanWebModeUtils", "appendWebUrlQuery: launchUrl : " + a2 + " rawPath : " + c);
            return Uri.parse(a2).buildUpon().path(c).appendQueryParameter("_swebfr", e).appendQueryParameter("_swebcode", valueOf).appendQueryParameter("_swebHost", bk2.n().a()).build().toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String n = t03.J().r().V().n("mPage");
            if (TextUtils.isEmpty(n)) {
                return "";
            }
            try {
                return new URI(n).getPath();
            } catch (URISyntaxException e) {
                if (a) {
                    e.printStackTrace();
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String string = i93.a().getString("web_mode_host_key", "");
            return TextUtils.isEmpty(string) ? "http://radar.bcc-szth.baidu.com:8312" : string;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? oe3.G() ? "41" : RoomMasterTable.DEFAULT_ID : (String) invokeV.objValue;
    }

    public static boolean f(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            String optString = jSONObject.optString("invokeFrom");
            return !TextUtils.isEmpty(optString) && TextUtils.equals(optString, "swanWeb");
        }
        return invokeL.booleanValue;
    }

    public static boolean g(nc3 nc3Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, nc3Var, i)) == null) {
            if (i == 6) {
                return true;
            }
            if (nc3Var == null) {
                return false;
            }
            return nc3Var.h() == 1013 || nc3Var.h() == 1015;
        }
        return invokeLI.booleanValue;
    }
}
