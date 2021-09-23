package com.dxmpay.wallet.passport;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.utils.JsonUtil;
import java.util.Map;
/* loaded from: classes9.dex */
public class LoginImpl implements IWalletLoginListener, NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "LoginImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes9.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f70174e;

        public a(LoginImpl loginImpl, ILoginBackListener iLoginBackListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginImpl, iLoginBackListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70174e = iLoginBackListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onSuccess(WebAuthResult webAuthResult) {
            ILoginBackListener iLoginBackListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, webAuthResult) == null) || (iLoginBackListener = this.f70174e) == null) {
                return;
            }
            iLoginBackListener.onSuccess(0, "");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onFailure(WebAuthResult webAuthResult) {
            ILoginBackListener iLoginBackListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) || (iLoginBackListener = this.f70174e) == null) {
                return;
            }
            iLoginBackListener.onFail(webAuthResult.getResultCode(), webAuthResult.getResultMsg());
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sapiAccount) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1429714911, "Lcom/dxmpay/wallet/passport/LoginImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1429714911, "Lcom/dxmpay/wallet/passport/LoginImpl;");
        }
    }

    public LoginImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        this.mContext = context.getApplicationContext();
    }

    private void loginBaidu(ILoginBackListener iLoginBackListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, iLoginBackListener, str) == null) {
            PassportSDK passportSDK = PassportSDK.getInstance();
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
            if (!TextUtils.isEmpty(str)) {
                JsonUtil.jsonStringToNameValuePairList(str, webLoginDTO.extraParams);
            }
            passportSDK.startLogin(this.mContext, new a(this, iLoginBackListener), webLoginDTO);
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public Map<String, String> getLoginData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? PassLoginUtil.getInstance().getLoginData(this.mContext, str) : (Map) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getLoginStoken(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? PassLoginUtil.getInstance().getLoginStoken(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getLoginToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PassLoginUtil.getInstance().getLoginToken() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public int getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, iLoginBackListener) == null) {
            PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener);
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), iLoginBackListener, Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getOpenLoginToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PassLoginUtil.getInstance().getLoginOpenToken() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void handlerWalletError(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && i2 == 5003) {
            PassLoginUtil.getInstance().logout();
            AccountManager.getInstance(this.mContext).logout();
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? PassLoginUtil.getInstance().isLogin() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isPassLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? PassLoginUtil.getInstance().isPassLogin() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public void login(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iLoginBackListener) == null) {
            loginBaidu(iLoginBackListener, null);
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void onLoginChanaged(Context context, Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, context, map) == null) && map == null) {
            PassLoginUtil.getInstance().logout();
            AccountManager.getInstance(this.mContext).logout();
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public boolean startPage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            BaiduWalletDelegate.getInstance().openH5Module(this.mContext, str, true);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletHostListener2
    public void login(ILoginBackListener iLoginBackListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, iLoginBackListener, str) == null) {
            loginBaidu(iLoginBackListener, str);
        }
    }
}
