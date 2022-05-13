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
public class qo8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final tm8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo8(MainTabActivity mainTabActivity, tm8 tm8Var) {
        super(2921452);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, tm8Var};
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
        this.b = tm8Var;
    }

    public final void a() {
        tm8 tm8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            rm8 rm8Var = this.a.mMainTabTopicTipController;
            if (rm8Var != null) {
                rm8Var.h();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.mWriteTab == null) {
                mainTabActivity.mWriteTab = new ey8(mainTabActivity.getPageContext(), this.a.rootView, "main_tab", 3, null);
                this.a.mWriteTab.H("8");
            }
            if (this.a.mUegForwardCheckController.d() || (tm8Var = this.b) == null || tm8Var.z() == null || this.b.z().getFragmentTabWidget() == null) {
                return;
            }
            this.a.mWriteTab.L(false, this.b.z().getTabWrapper(), this.b.z().getFragmentTabWidget().getWriteView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h05) && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
            a();
        }
    }
}
