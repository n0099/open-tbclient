package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.searchbox.live.interfaces.data.UserAccount;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class be7 implements AccountManagerService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AccountManagerService.AccountStatusChangedListener a;
    public AccountManagerService.LoginResultListener b;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ be7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(be7 be7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = be7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (this.a.b != null) {
                    this.a.b.onResult(this.a.isLogin(2) ? 0 : -2);
                }
                if (this.a.a != null) {
                    this.a.a.onAccountStatusChanged(this.a.isLogin(2));
                }
            }
        }
    }

    public be7() {
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
        MessageManager.getInstance().registerListener(new a(this, 2005016));
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public void addLoginStatusChangedListener(AccountManagerService.AccountStatusChangedListener accountStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, accountStatusChangedListener) == null) {
            this.a = accountStatusChangedListener;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public UserAccount getAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            UserAccount userAccount = new UserAccount();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                userAccount.setDisplayname(currentAccountInfo.getAccountNameShow());
                userAccount.setBduss(currentAccountInfo.getBDUSS());
                userAccount.setUid(currentAccountInfo.getID());
                userAccount.setProtrait(TbConfig.getBigPhotoAdress() + currentAccountInfo.getPortrait());
                userAccount.setNickName(currentAccountInfo.getAccountNameShow());
                userAccount.setUk(getSocialEncryption(currentAccountInfo.getID(), "baiduuid_"));
            }
            return userAccount;
        }
        return (UserAccount) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public String getSocialDecrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                return SocialEncodeUtils.getSocialDecrypt(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public String getSocialEncryption(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String str3 = "";
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                str3 = SocialEncodeUtils.getSocialEncryption(str, str2);
                return URLEncoder.encode(str3, IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str3;
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            UserAccount account = getAccount();
            return account != null ? account.getUid() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public boolean isLogin(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? TbadkCoreApplication.isLogin() : invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public void login(Context context, AccountManagerService.LoginResultListener loginResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, loginResultListener) == null) {
            this.b = loginResultListener;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public void removeLoginStatusChangedListener(AccountManagerService.AccountStatusChangedListener accountStatusChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, accountStatusChangedListener) == null) {
            this.a = null;
        }
    }
}
