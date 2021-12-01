package com.dxmpay.wallet.base.datamodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class AccountManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILE_PREFERENCE_ACCOUNT = "account";
    public static final String PREFERENCES_NAME_PRE = "o2o_service.preferences";
    public static final String TAG = "AccountManager";
    public static AccountManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public final SharedPreferences mPreferences;
    public String mbfbToken;

    /* loaded from: classes12.dex */
    public class User implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountManager this$0;
        public String tokenValue;
        public int userType;

        public User(AccountManager accountManager, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountManager, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = accountManager;
            this.userType = i2;
            this.tokenValue = str;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("user_type", this.userType);
                    jSONObject.put("token_value", this.tokenValue);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public AccountManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
        this.mPreferences = context.getSharedPreferences("account", 0);
    }

    private void delScanCodeSP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
        }
    }

    public static synchronized AccountManager getInstance(Context context) {
        InterceptResult invokeL;
        AccountManager accountManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (AccountManager.class) {
                if (sInstance == null) {
                    sInstance = new AccountManager(context.getApplicationContext());
                }
                accountManager = sInstance;
            }
            return accountManager;
        }
        return (AccountManager) invokeL.objValue;
    }

    public String getBduss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? WalletLoginHelper.getInstance().getLoginToken() : (String) invokeV.objValue;
    }

    public String getBfbToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.mbfbToken;
            if (str == null) {
                String str2 = "mtoken 为NULL mPreferences=" + this.mPreferences;
                return this.mPreferences.getString("token", null);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getFileNamePrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String localEncrypt1 = SecurePay.getInstance().localEncrypt1(WalletLoginHelper.getInstance().getPassUid());
            if (TextUtils.isEmpty(localEncrypt1)) {
                return "";
            }
            String str = "PREFERENCES_NAME_PRE: uid " + localEncrypt1;
            return Md5Utils.toMD5(localEncrypt1);
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> getLoginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? WalletLoginHelper.getInstance().getLoginData() : (Map) invokeV.objValue;
    }

    public int getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? WalletLoginHelper.getInstance().getLoginType() : invokeV.intValue;
    }

    public String getOpenBduss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? WalletLoginHelper.getInstance().getOpenLoginToken() : (String) invokeV.objValue;
    }

    public void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            delScanCodeSP();
        }
    }

    public void setBfbToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            String str2 = "setBfbToken=" + str;
            this.mbfbToken = str;
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.putString("token", str);
            edit.apply();
        }
    }
}
