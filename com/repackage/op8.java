package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class op8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final co8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public op8(MainTabActivity mainTabActivity) {
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
        this.b = mainTabActivity.mLogicController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        co8 co8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        if (MainTabActivity.syncHasFinish && (co8Var = this.b) != null && co8Var.i() != null) {
            this.b.i().b();
        }
        co8 co8Var2 = this.b;
        if (co8Var2 != null && co8Var2.a() != null && this.b.a().f) {
            this.b.a().g();
        }
        co8 co8Var3 = this.b;
        if (co8Var3 != null && co8Var3.a() != null && this.b.a().g) {
            this.b.a().f();
        }
        co8 co8Var4 = this.b;
        if (co8Var4 != null && co8Var4.d() != null) {
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
    }
}
