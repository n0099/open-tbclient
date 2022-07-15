package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class dq7 implements ow4 {
    public static /* synthetic */ Interceptable $ic;
    public static dq7 a;
    public transient /* synthetic */ FieldHolder $fh;

    public dq7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized dq7 d() {
        InterceptResult invokeV;
        dq7 dq7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (dq7.class) {
                if (a == null) {
                    a = new dq7();
                }
                dq7Var = a;
            }
            return dq7Var;
        }
        return (dq7) invokeV.objValue;
    }

    @Override // com.repackage.ow4
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                SapiAccountManager.getInstance().logout();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.repackage.ow4
    public void b(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountData) == null) {
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (TextUtils.isEmpty(accountData.getID()) || loginAccounts == null || loginAccounts.size() <= 0) {
                return;
            }
            for (SapiAccount sapiAccount : loginAccounts) {
                if (accountData.getID().equals(sapiAccount.uid)) {
                    SapiAccountManager.getInstance().validate(sapiAccount);
                    return;
                }
            }
        }
    }

    @Override // com.repackage.ow4
    public void c(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            if (accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) {
                SapiAccountManager.getInstance().logout();
                return;
            }
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (loginAccounts == null || loginAccounts.size() <= 0) {
                return;
            }
            for (SapiAccount sapiAccount : loginAccounts) {
                if (accountData.getID().equals(sapiAccount.uid)) {
                    SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                    return;
                }
            }
        }
    }
}
