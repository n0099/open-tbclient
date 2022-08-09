package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kp8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final mn8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kp8(MainTabActivity mainTabActivity, mn8 mn8Var) {
        super(2921452);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, mn8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mn8Var;
    }

    public final void a() {
        mn8 mn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            kn8 kn8Var = this.a.x;
            if (kn8Var != null) {
                kn8Var.h();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.r == null) {
                mainTabActivity.r = new fz8(mainTabActivity.getPageContext(), this.a.q, "main_tab", 3, null);
                this.a.r.E("8");
            }
            if (this.a.w.d() || (mn8Var = this.b) == null || mn8Var.B() == null || this.b.B().getFragmentTabWidget() == null) {
                return;
            }
            this.a.r.I(false, this.b.B().getTabWrapper(), this.b.B().getFragmentTabWidget().getWriteView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof p15) && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
            a();
        }
    }
}
