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
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class QQToken {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    public static SharedPreferences g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public long e;
    public com.tencent.open.utils.a f;

    public QQToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 1;
        this.e = -1L;
        this.a = str;
    }

    @TargetApi(11)
    public static synchronized SharedPreferences a() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (QQToken.class) {
                if (g == null) {
                    g = f.a().getSharedPreferences("token_info_file", 0);
                }
                sharedPreferences = g;
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    @Deprecated
    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? Base64.encodeToString(l.i(str), 2) : (String) invokeL.objValue;
    }

    @Deprecated
    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return Base64.encodeToString(l.i(str), 2) + "_spkey";
        }
        return (String) invokeL.objValue;
    }

    public String getAccessToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int getAuthSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : invokeV.intValue;
    }

    public long getExpireTimeInSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : invokeV.longValue;
    }

    public String getOpenId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String getOpenIdWithCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String openId = getOpenId();
            try {
                if (TextUtils.isEmpty(openId)) {
                    JSONObject loadSession = loadSession(this.a);
                    if (loadSession != null) {
                        openId = loadSession.getString("openid");
                        if (!TextUtils.isEmpty(openId)) {
                            setOpenId(openId);
                        }
                    }
                    SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.a);
                } else {
                    SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.a);
                }
            } catch (Exception e) {
                SLog.i("QQToken", "getLocalOpenIdByAppId " + e.toString());
            }
            return openId;
        }
        return (String) invokeV.objValue;
    }

    public boolean isSessionValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b != null && System.currentTimeMillis() < this.e : invokeV.booleanValue;
    }

    public JSONObject loadSession(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                if (this.f == null) {
                    this.f = new com.tencent.open.utils.a(f.a());
                }
                return a(str, this.f);
            } catch (Exception e) {
                SLog.i("QQToken", "login loadSession" + e.toString());
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void removeSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            SharedPreferences.Editor edit = a().edit();
            edit.remove(c(str));
            edit.remove(c(str));
            edit.remove(a(str));
            edit.apply();
            SLog.i("QQToken", "removeSession sucess");
        }
    }

    public boolean saveSession(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            try {
                if (this.f == null) {
                    this.f = new com.tencent.open.utils.a(f.a());
                }
                return a(this.a, jSONObject, this.f);
            } catch (Exception e) {
                SLog.i("QQToken", "login saveSession" + e.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.b = str;
            this.e = 0L;
            if (str2 != null) {
                this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
            }
        }
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.a = str;
        }
    }

    public void setAuthSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.d = i;
        }
    }

    public void setOpenId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.c = str;
        }
    }

    public static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        InterceptResult invokeLL;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, aVar)) == null) {
            synchronized (QQToken.class) {
                if (f.a() == null) {
                    SLog.i("QQToken", "loadJsonPreference context null");
                    return null;
                } else if (str == null) {
                    SLog.i("QQToken", "loadJsonPreference prefKey is null");
                    return null;
                } else {
                    String string = a().getString(a(str), "");
                    if (TextUtils.isEmpty(string)) {
                        if (!JniInterface.isJniOk) {
                            i.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                            JniInterface.loadSo();
                        }
                        if (!JniInterface.isJniOk) {
                            SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                            return null;
                        }
                        String c = c(str);
                        String string2 = a().getString(c, "");
                        if (TextUtils.isEmpty(string2)) {
                            String b2 = b(str);
                            String string3 = a().getString(b2, "");
                            if (TextUtils.isEmpty(string3)) {
                                SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                                return null;
                            }
                            try {
                                b = JniInterface.d1(string3);
                                if (TextUtils.isEmpty(b)) {
                                    SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                    a().edit().remove(b2).apply();
                                    return null;
                                }
                                a(str, new JSONObject(b), aVar);
                                a().edit().remove(b2).apply();
                            } catch (Exception e) {
                                SLog.e("QQToken", "Catch Exception", e);
                                a().edit().remove(b2).apply();
                                return null;
                            }
                        } else {
                            try {
                                b = JniInterface.d2(string2);
                                a(str, new JSONObject(b), aVar);
                                a().edit().remove(c).apply();
                            } catch (Exception e2) {
                                SLog.e("QQToken", "Catch Exception", e2);
                                a().edit().remove(c).apply();
                                return null;
                            }
                        }
                    } else {
                        b = aVar.b(string);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(b);
                        SLog.i("QQToken", "loadJsonPreference sucess");
                        return jSONObject;
                    } catch (Exception e3) {
                        SLog.i("QQToken", "loadJsonPreference decode " + e3.toString());
                        return null;
                    }
                }
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, jSONObject, aVar)) == null) {
            synchronized (QQToken.class) {
                if (f.a() == null) {
                    SLog.i("QQToken", "saveJsonPreference context null");
                    return false;
                } else if (str != null && jSONObject != null) {
                    try {
                        String string = jSONObject.getString("expires_in");
                        if (!TextUtils.isEmpty(string)) {
                            jSONObject.put("expires_time", System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                            String a = a(str);
                            String a2 = aVar.a(jSONObject.toString());
                            if (a.length() > 6 && a2 != null) {
                                a().edit().putString(a, a2).commit();
                                SLog.i("QQToken", "saveJsonPreference sucess");
                                return true;
                            }
                            SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                            return false;
                        }
                        SLog.i("QQToken", "expires is null");
                        return false;
                    } catch (Exception e) {
                        SLog.e("QQToken", "saveJsonPreference exception:" + e.toString());
                        return false;
                    }
                } else {
                    SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
                    return false;
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return Base64.encodeToString(l.i(str), 2) + "_aes_google";
        }
        return (String) invokeL.objValue;
    }
}
