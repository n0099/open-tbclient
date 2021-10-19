package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
public class QQToken {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences f76468g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f76469a;

    /* renamed from: b  reason: collision with root package name */
    public String f76470b;

    /* renamed from: c  reason: collision with root package name */
    public String f76471c;

    /* renamed from: d  reason: collision with root package name */
    public int f76472d;

    /* renamed from: e  reason: collision with root package name */
    public long f76473e;

    /* renamed from: f  reason: collision with root package name */
    public com.tencent.open.utils.a f76474f;

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
        this.f76472d = 1;
        this.f76473e = -1L;
        this.f76469a = str;
    }

    @TargetApi(11)
    public static synchronized SharedPreferences a() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (QQToken.class) {
                if (f76468g == null) {
                    f76468g = f.a().getSharedPreferences("token_info_file", 0);
                }
                sharedPreferences = f76468g;
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    @Deprecated
    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? Base64.encodeToString(l.i(str), 2) : (String) invokeL.objValue;
    }

    @Deprecated
    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            return Base64.encodeToString(l.i(str), 2) + "_spkey";
        }
        return (String) invokeL.objValue;
    }

    public String getAccessToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f76470b : (String) invokeV.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f76469a : (String) invokeV.objValue;
    }

    public int getAuthSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f76472d : invokeV.intValue;
    }

    public long getExpireTimeInSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f76473e : invokeV.longValue;
    }

    public String getOpenId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f76471c : (String) invokeV.objValue;
    }

    public String getOpenIdWithCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String openId = getOpenId();
            try {
                if (TextUtils.isEmpty(openId)) {
                    JSONObject loadSession = loadSession(this.f76469a);
                    if (loadSession != null) {
                        openId = loadSession.getString("openid");
                        if (!TextUtils.isEmpty(openId)) {
                            setOpenId(openId);
                        }
                    }
                    SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.f76469a);
                } else {
                    SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.f76469a);
                }
            } catch (Exception e2) {
                SLog.i("QQToken", "getLocalOpenIdByAppId " + e2.toString());
            }
            return openId;
        }
        return (String) invokeV.objValue;
    }

    public boolean isSessionValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f76470b != null && System.currentTimeMillis() < this.f76473e : invokeV.booleanValue;
    }

    public JSONObject loadSession(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                if (this.f76474f == null) {
                    this.f76474f = new com.tencent.open.utils.a(f.a());
                }
                return a(str, this.f76474f);
            } catch (Exception e2) {
                SLog.i("QQToken", "login loadSession" + e2.toString());
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
                if (this.f76474f == null) {
                    this.f76474f = new com.tencent.open.utils.a(f.a());
                }
                return a(this.f76469a, jSONObject, this.f76474f);
            } catch (Exception e2) {
                SLog.i("QQToken", "login saveSession" + e2.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.f76470b = str;
            this.f76473e = 0L;
            if (str2 != null) {
                this.f76473e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
            }
        }
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f76469a = str;
        }
    }

    public void setAuthSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f76472d = i2;
        }
    }

    public void setOpenId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f76471c = str;
        }
    }

    public static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        InterceptResult invokeLL;
        String b2;
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
                        String c2 = c(str);
                        String string2 = a().getString(c2, "");
                        if (TextUtils.isEmpty(string2)) {
                            String b3 = b(str);
                            String string3 = a().getString(b3, "");
                            if (TextUtils.isEmpty(string3)) {
                                SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                                return null;
                            }
                            try {
                                b2 = JniInterface.d1(string3);
                                if (TextUtils.isEmpty(b2)) {
                                    SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                    a().edit().remove(b3).apply();
                                    return null;
                                }
                                a(str, new JSONObject(b2), aVar);
                                a().edit().remove(b3).apply();
                            } catch (Exception e2) {
                                SLog.e("QQToken", "Catch Exception", e2);
                                a().edit().remove(b3).apply();
                                return null;
                            }
                        } else {
                            try {
                                b2 = JniInterface.d2(string2);
                                a(str, new JSONObject(b2), aVar);
                                a().edit().remove(c2).apply();
                            } catch (Exception e3) {
                                SLog.e("QQToken", "Catch Exception", e3);
                                a().edit().remove(c2).apply();
                                return null;
                            }
                        }
                    } else {
                        b2 = aVar.b(string);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        SLog.i("QQToken", "loadJsonPreference sucess");
                        return jSONObject;
                    } catch (Exception e4) {
                        SLog.i("QQToken", "loadJsonPreference decode " + e4.toString());
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
                            String a2 = a(str);
                            String a3 = aVar.a(jSONObject.toString());
                            if (a2.length() > 6 && a3 != null) {
                                a().edit().putString(a2, a3).commit();
                                SLog.i("QQToken", "saveJsonPreference sucess");
                                return true;
                            }
                            SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                            return false;
                        }
                        SLog.i("QQToken", "expires is null");
                        return false;
                    } catch (Exception e2) {
                        SLog.e("QQToken", "saveJsonPreference exception:" + e2.toString());
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
