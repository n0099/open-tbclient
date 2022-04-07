package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public int d;

    public s00() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 2;
        this.d = 0;
    }

    public static s00 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? e(f(str)) : (s00) invokeL.objValue;
    }

    public static s00 b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            s00 s00Var = new s00();
            s00Var.a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            s00Var.d = length;
            if (length < 14) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                s00Var.b = str2;
            }
            return s00Var;
        }
        return (s00) invokeLL.objValue;
    }

    public static boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i >= 14 : invokeI.booleanValue;
    }

    public static s00 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                String str2 = "0";
                String str3 = "0";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!k("ZGV2aWNlaWQ=").equals(next) && !k("dmVy").equals(next)) {
                        str3 = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(k("ZGV2aWNlaWQ="));
                int i = jSONObject.getInt(k("dmVy"));
                int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
                if (!TextUtils.isEmpty(string)) {
                    s00 s00Var = new s00();
                    s00Var.a = string;
                    s00Var.c = i;
                    s00Var.d = length;
                    if (length < 14) {
                        if (!TextUtils.isEmpty(str3)) {
                            str2 = str3;
                        }
                        s00Var.b = str2;
                    }
                    s00Var.c();
                    return s00Var;
                }
            } catch (JSONException e) {
                h20.c(e);
            }
            return null;
        }
        return (s00) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] a = n10.a();
                return new String(j10.c(a, a, b20.b(str.getBytes())));
            } catch (Exception e) {
                h20.c(e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] a = n10.a();
                return b20.a(j10.d(a, a, str.getBytes()), IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException | Exception e) {
                h20.c(e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? new String(b20.b(str.getBytes())) : (String) invokeL.objValue;
    }

    public static boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (g()) {
                str = "O";
            } else if (!i()) {
                return false;
            } else {
                str = "0";
            }
            this.b = str;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d(this.d) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m(this.b) : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h(l()) : (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new JSONObject().put(k("ZGV2aWNlaWQ="), this.a).put(k("aW1laQ=="), this.b).put(k("dmVy"), this.c).toString();
            } catch (JSONException e) {
                h20.c(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
