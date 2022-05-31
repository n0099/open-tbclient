package com.repackage;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class oj8 implements ss4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nj8 a;

    public oj8() {
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

    @Override // com.repackage.ss4
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                b(context, 1);
            } else {
                b(context, 0);
            }
        }
    }

    @Override // com.repackage.ss4
    public void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i)));
        }
    }

    @Override // com.repackage.ss4
    public void c(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createNormalCfg(i, z)));
        }
    }

    @Override // com.repackage.ss4
    public Class<?> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? MainTabActivity.class : (Class) invokeV.objValue;
    }

    @Override // com.repackage.ss4
    public void e(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(context).createRefreshCfg(i, z)));
        }
    }

    @Override // com.repackage.ss4
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? MainTabActivity.class.getName() : (String) invokeV.objValue;
    }

    public void g(nj8 nj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nj8Var) == null) {
            this.a = nj8Var;
        }
    }

    @Override // com.repackage.ss4
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            nj8 nj8Var = this.a;
            if (nj8Var != null) {
                return nj8Var.getCurrentTabType();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
