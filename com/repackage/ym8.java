package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ym8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final nl8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ym8(MainTabActivity mainTabActivity) {
        super(2921636);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
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
        this.b = mainTabActivity.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        nl8 nl8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        if (MainTabActivity.W && (nl8Var = this.b) != null && nl8Var.h() != null) {
            this.b.h().a();
        }
        nl8 nl8Var2 = this.b;
        if (nl8Var2 != null && nl8Var2.d() != null) {
            this.b.d().b();
        }
        if (ms4.a().f()) {
            ms4.a().g(this.a.getClass().getName());
            ms4.a().l(false);
        }
        if (ms4.a().e()) {
            ms4.a().b();
            ms4.a().h(this.a.getClass().getName());
            ms4.a().k(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921567, null));
    }
}
