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
/* loaded from: classes7.dex */
public class wm8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final al8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wm8(MainTabActivity mainTabActivity, al8 al8Var) {
        super(2921452);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, al8Var};
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
        this.b = al8Var;
    }

    public final void a() {
        al8 al8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yk8 yk8Var = this.a.x;
            if (yk8Var != null) {
                yk8Var.h();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.r == null) {
                mainTabActivity.r = new pw8(mainTabActivity.getPageContext(), this.a.q, "main_tab", 3, null);
                this.a.r.E("8");
            }
            if (this.a.w.d() || (al8Var = this.b) == null || al8Var.B() == null || this.b.B().getFragmentTabWidget() == null) {
                return;
            }
            this.a.r.I(false, this.b.B().getTabWrapper(), this.b.B().getFragmentTabWidget().getWriteView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof t05) && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
            a();
        }
    }
}
