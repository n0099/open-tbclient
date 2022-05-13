package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.wallet.CurrencySwitchTDouYBeanDialog;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public CurrencySwitchTDouYBeanDialog b;

    public nn8(MainTabActivity mainTabActivity, tm8 tm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, tm8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b == null && TbadkCoreApplication.isLogin() && CurrencySwitchUtil.isNeedConfirmTDouToYBeanSwitchOpen()) {
            CurrencySwitchTDouYBeanDialog currencySwitchTDouYBeanDialog = new CurrencySwitchTDouYBeanDialog(this.a.getPageContext());
            this.b = currencySwitchTDouYBeanDialog;
            currencySwitchTDouYBeanDialog.showDialog();
        }
    }

    public void b() {
        CurrencySwitchTDouYBeanDialog currencySwitchTDouYBeanDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (currencySwitchTDouYBeanDialog = this.b) == null) {
            return;
        }
        currencySwitchTDouYBeanDialog.onDestroy();
    }
}
