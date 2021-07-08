package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class Oauth2AccessToken {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_PHONE_NUM = "phone_num";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_UID = "uid";
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle bundle;
    public String mAccessToken;
    public long mExpiresTime;
    public String mPhoneNum;
    public String mRefreshToken;
    public String mUid;

    public Oauth2AccessToken() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
    }

    public static String getString(Bundle bundle, String str, String str2) {
        InterceptResult invokeLLL;
        String string;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, bundle, str, str2)) == null) ? (bundle == null || (string = bundle.getString(str)) == null) ? str2 : string : (String) invokeLLL.objValue;
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.indexOf(StringUtil.ARRAY_START) < 0) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
                oauth2AccessToken.setUid(jSONObject.optString("uid"));
                oauth2AccessToken.setToken(jSONObject.optString("access_token"));
                oauth2AccessToken.setExpiresIn(jSONObject.optString("expires_in"));
                oauth2AccessToken.setRefreshToken(jSONObject.optString("refresh_token"));
                oauth2AccessToken.setPhoneNum(jSONObject.optString(KEY_PHONE_NUM));
                return oauth2AccessToken;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Oauth2AccessToken) invokeL.objValue;
    }

    private void setPhoneNum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            this.mPhoneNum = str;
        }
    }

    public Bundle getBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bundle : (Bundle) invokeV.objValue;
    }

    public long getExpiresTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mExpiresTime : invokeV.longValue;
    }

    public String getPhoneNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPhoneNum : (String) invokeV.objValue;
    }

    public String getRefreshToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRefreshToken : (String) invokeV.objValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAccessToken : (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mUid : (String) invokeV.objValue;
    }

    public boolean isSessionValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.mAccessToken) : invokeV.booleanValue;
    }

    public void setBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            this.bundle = bundle;
        }
    }

    public void setExpiresIn(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str) || str.equals("0")) {
            return;
        }
        setExpiresTime(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
    }

    public void setExpiresTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.mExpiresTime = j;
        }
    }

    public void setRefreshToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mRefreshToken = str;
        }
    }

    public void setToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mAccessToken = str;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mUid = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "uid: " + this.mUid + StringUtil.ARRAY_ELEMENT_SEPARATOR + "access_token: " + this.mAccessToken + StringUtil.ARRAY_ELEMENT_SEPARATOR + "refresh_token: " + this.mRefreshToken + StringUtil.ARRAY_ELEMENT_SEPARATOR + KEY_PHONE_NUM + ": " + this.mPhoneNum + StringUtil.ARRAY_ELEMENT_SEPARATOR + "expires_in: " + Long.toString(this.mExpiresTime);
        }
        return (String) invokeV.objValue;
    }

    @Deprecated
    public Oauth2AccessToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
        if (str == null || str.indexOf(StringUtil.ARRAY_START) < 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setUid(jSONObject.optString("uid"));
            setToken(jSONObject.optString("access_token"));
            setExpiresIn(jSONObject.optString("expires_in"));
            setRefreshToken(jSONObject.optString("refresh_token"));
            setPhoneNum(jSONObject.optString(KEY_PHONE_NUM));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            if (bundle != null) {
                Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
                oauth2AccessToken.setUid(getString(bundle, "uid", ""));
                oauth2AccessToken.setToken(getString(bundle, "access_token", ""));
                oauth2AccessToken.setExpiresIn(getString(bundle, "expires_in", ""));
                oauth2AccessToken.setRefreshToken(getString(bundle, "refresh_token", ""));
                oauth2AccessToken.setPhoneNum(getString(bundle, KEY_PHONE_NUM, ""));
                oauth2AccessToken.setBundle(bundle);
                return oauth2AccessToken;
            }
            return null;
        }
        return (Oauth2AccessToken) invokeL.objValue;
    }

    public Oauth2AccessToken(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mUid = "";
        this.mAccessToken = "";
        this.mRefreshToken = "";
        this.mExpiresTime = 0L;
        this.mPhoneNum = "";
        this.mAccessToken = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.mExpiresTime = currentTimeMillis;
        if (str2 != null) {
            this.mExpiresTime = currentTimeMillis + (Long.parseLong(str2) * 1000);
        }
    }
}
