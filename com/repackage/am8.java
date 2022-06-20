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
/* loaded from: classes5.dex */
public class am8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final dk8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am8(MainTabActivity mainTabActivity, dk8 dk8Var) {
        super(2921452);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, dk8Var};
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
        this.b = dk8Var;
    }

    public final void a() {
        dk8 dk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bk8 bk8Var = this.a.x;
            if (bk8Var != null) {
                bk8Var.h();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.r == null) {
                mainTabActivity.r = new ov8(mainTabActivity.getPageContext(), this.a.q, "main_tab", 3, null);
                this.a.r.H("8");
            }
            if (this.a.w.d() || (dk8Var = this.b) == null || dk8Var.z() == null || this.b.z().getFragmentTabWidget() == null) {
                return;
            }
            this.a.r.L(false, this.b.z().getTabWrapper(), this.b.z().getFragmentTabWidget().getWriteView());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof sz4) && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
            a();
        }
    }
}
