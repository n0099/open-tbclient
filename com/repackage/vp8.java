package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vp8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final jo8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vp8(MainTabActivity mainTabActivity) {
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
        jo8 jo8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        if (MainTabActivity.syncHasFinish && (jo8Var = this.b) != null && jo8Var.i() != null) {
            this.b.i().b();
        }
        jo8 jo8Var2 = this.b;
        if (jo8Var2 != null && jo8Var2.a() != null && this.b.a().f) {
            this.b.a().g();
        }
        jo8 jo8Var3 = this.b;
        if (jo8Var3 != null && jo8Var3.a() != null && this.b.a().g) {
            this.b.a().f();
        }
        jo8 jo8Var4 = this.b;
        if (jo8Var4 != null && jo8Var4.d() != null) {
            this.b.d().b();
        }
        if (ls4.a().f()) {
            ls4.a().g(this.a.getClass().getName());
            ls4.a().l(false);
        }
        if (ls4.a().e()) {
            ls4.a().b();
            ls4.a().h(this.a.getClass().getName());
            ls4.a().k(false);
        }
    }
}
