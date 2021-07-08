package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.j;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class QQToken {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f38741f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f38742a;

    /* renamed from: b  reason: collision with root package name */
    public String f38743b;

    /* renamed from: c  reason: collision with root package name */
    public String f38744c;

    /* renamed from: d  reason: collision with root package name */
    public int f38745d;

    /* renamed from: e  reason: collision with root package name */
    public long f38746e;

    public QQToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38745d = 1;
        this.f38746e = -1L;
        this.f38742a = str;
    }

    @TargetApi(11)
    public static synchronized SharedPreferences a() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (QQToken.class) {
                if (f38741f == null) {
                    f38741f = e.a().getSharedPreferences("token_info_file", 0);
                }
                sharedPreferences = f38741f;
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public String getAccessToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38743b : (String) invokeV.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38742a : (String) invokeV.objValue;
    }

    public int getAuthSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38745d : invokeV.intValue;
    }

    public long getExpireTimeInSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38746e : invokeV.longValue;
    }

    public String getOpenId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38744c : (String) invokeV.objValue;
    }

    public boolean isSessionValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38743b != null && System.currentTimeMillis() < this.f38746e : invokeV.booleanValue;
    }

    public JSONObject loadSession(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return a(str);
            } catch (Exception e2) {
                f.c("QQToken", "login loadSession" + e2.toString());
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void saveSession(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            try {
                a(this.f38742a, jSONObject);
            } catch (Exception e2) {
                f.c("QQToken", "login saveSession" + e2.toString());
            }
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.f38743b = str;
            this.f38746e = 0L;
            if (str2 != null) {
                this.f38746e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
            }
        }
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f38742a = str;
        }
    }

    public void setAuthSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f38745d = i2;
        }
    }

    public void setOpenId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f38744c = str;
        }
    }

    public static synchronized JSONObject a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (QQToken.class) {
                if (e.a() == null) {
                    f.c("QQToken", "loadJsonPreference context null");
                    return null;
                } else if (str == null) {
                    return null;
                } else {
                    String string = a().getString(Base64.encodeToString(j.i(str), 2), null);
                    if (string == null) {
                        f.c("QQToken", "loadJsonPreference encoded value null");
                        return null;
                    }
                    try {
                        return new JSONObject(d.b(string, "asdfghjk"));
                    } catch (Exception e2) {
                        f.c("QQToken", "loadJsonPreference decode" + e2.toString());
                        return null;
                    }
                }
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static synchronized void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, jSONObject) == null) {
            synchronized (QQToken.class) {
                if (e.a() == null) {
                    f.c("QQToken", "saveJsonPreference context null");
                } else if (str == null || jSONObject == null) {
                } else {
                    try {
                        String string = jSONObject.getString("expires_in");
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        jSONObject.put("expires_time", System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String encodeToString = Base64.encodeToString(j.i(str), 2);
                        String a2 = d.a(jSONObject.toString(), "asdfghjk");
                        if (encodeToString != null && a2 != null) {
                            a().edit().putString(encodeToString, a2).commit();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
