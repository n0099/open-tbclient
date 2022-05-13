package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class so8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final gn8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public so8(MainTabActivity mainTabActivity) {
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
        gn8 gn8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
            return;
        }
        if (MainTabActivity.syncHasFinish && (gn8Var = this.b) != null && gn8Var.i() != null) {
            this.b.i().b();
        }
        gn8 gn8Var2 = this.b;
        if (gn8Var2 != null && gn8Var2.a() != null && this.b.a().f) {
            this.b.a().g();
        }
        gn8 gn8Var3 = this.b;
        if (gn8Var3 != null && gn8Var3.a() != null && this.b.a().g) {
            this.b.a().f();
        }
        gn8 gn8Var4 = this.b;
        if (gn8Var4 != null && gn8Var4.d() != null) {
            this.b.d().b();
        }
        if (ys4.a().f()) {
            ys4.a().g(this.a.getClass().getName());
            ys4.a().l(false);
        }
        if (ys4.a().e()) {
            ys4.a().b();
            ys4.a().h(this.a.getClass().getName());
            ys4.a().k(false);
        }
    }
}
