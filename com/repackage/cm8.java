package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cm8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final qk8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cm8(MainTabActivity mainTabActivity) {
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
        qk8 qk8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        if (MainTabActivity.W && (qk8Var = this.b) != null && qk8Var.h() != null) {
            this.b.h().b();
        }
        qk8 qk8Var2 = this.b;
        if (qk8Var2 != null && qk8Var2.a() != null && this.b.a().f) {
            this.b.a().g();
        }
        qk8 qk8Var3 = this.b;
        if (qk8Var3 != null && qk8Var3.a() != null && this.b.a().g) {
            this.b.a().f();
        }
        qk8 qk8Var4 = this.b;
        if (qk8Var4 != null && qk8Var4.d() != null) {
            this.b.d().b();
        }
        if (xr4.a().f()) {
            xr4.a().g(this.a.getClass().getName());
            xr4.a().l(false);
        }
        if (xr4.a().e()) {
            xr4.a().b();
            xr4.a().h(this.a.getClass().getName());
            xr4.a().k(false);
        }
    }
}
