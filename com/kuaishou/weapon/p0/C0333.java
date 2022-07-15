package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼי  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0333 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public String f106;

    /* renamed from: ʼ  reason: contains not printable characters */
    public String f107;

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f108;

    /* renamed from: ʾ  reason: contains not printable characters */
    public String f109;

    /* renamed from: ʿ  reason: contains not printable characters */
    public String f110;

    /* renamed from: ˆ  reason: contains not printable characters */
    public String f111;

    /* renamed from: ˈ  reason: contains not printable characters */
    public String f112;

    /* renamed from: ˉ  reason: contains not printable characters */
    public String f113;

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f114;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f115;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f116;

    /* renamed from: ˏ  reason: contains not printable characters */
    public String f117;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x000c: INVOKE  (r1v1 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public C0333(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.f114 = sb.toString();
        this.f108 = str;
        this.f112 = str2;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m249(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                String str = WeaponHI.sKDeviceId;
                if (!TextUtils.isEmpty(str)) {
                    C0453.f720 = 1;
                    return str;
                }
            } catch (Exception unused) {
            }
            try {
                C0374 m389 = C0374.m389(context);
                boolean m408 = m389.m408("a1_p_s_p_s");
                boolean m4082 = m389.m408("a1_p_s_p_s_c_b");
                if (m408 || m4082) {
                    String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                    if (!TextUtils.isEmpty(str2)) {
                        C0453.f720 = 3;
                        return str2;
                    }
                }
            } catch (Exception unused2) {
            }
            C0453.f720 = 4;
            return "";
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    private JSONObject m250() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("1", this.f106);
                jSONObject.put("2", this.f107);
                jSONObject.put("3", this.f108);
                jSONObject.put("4", this.f109);
                jSONObject.put("5", this.f110);
                jSONObject.put("6", this.f111);
                jSONObject.put("7", this.f112);
                jSONObject.put("8", this.f113);
                jSONObject.put("9", this.f114);
                jSONObject.put("11", this.f115);
                jSONObject.put("12", this.f117);
                jSONObject.put("13", "com.kuaishou.weapon");
                jSONObject.put("14", WeaponHI.sKSSdkver);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: י  reason: contains not printable characters */
    public static String m251() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
            } catch (Exception unused) {
                return "UNKNOWN_PRODUCT";
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m252() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f117 : (String) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m253(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                m262(m249(context));
                m274(m251());
                m258(C0433.m891(context));
                m256(C0433.m890(context));
                m268(C0433.m892(context));
                m272("5.0.0");
                m264(C0310.m205(context));
                m254(WeaponHI.sKSAppkey);
                return m250();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m254(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f117 = str;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m255() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f110 : (String) invokeV.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m256(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f110 = str;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m257() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f109 : (String) invokeV.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m258(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f109 = str;
        }
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public String m259() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f116 : (String) invokeV.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public void m260(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f116 = str;
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public String m261() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f106 : (String) invokeV.objValue;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public void m262(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f106 = str;
        }
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public String m263() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f115 : (String) invokeV.objValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public void m264(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f115 = str;
        }
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public String m265() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f108 : (String) invokeV.objValue;
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public void m266(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f108 = str;
        }
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public String m267() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f111 : (String) invokeV.objValue;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    public void m268(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f111 = str;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m269() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f112 : (String) invokeV.objValue;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m270(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f112 = str;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m271() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f113 : (String) invokeV.objValue;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m272(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f113 = str;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m273() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f107 : (String) invokeV.objValue;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m274(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f107 = str;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m275() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f114 : (String) invokeV.objValue;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m276(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f114 = str;
        }
    }
}
