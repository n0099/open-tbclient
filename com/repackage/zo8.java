package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.PriorityOrganizer;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zo8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final mn8 b;
    public vp8 c;
    public wp8 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zo8(MainTabActivity mainTabActivity, mn8 mn8Var) {
        super(2921728);
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
        this.c = new vp8(mainTabActivity.getPageContext(), mn8Var, mainTabActivity);
        wp8 wp8Var = new wp8(mainTabActivity.getPageContext(), mn8Var, mainTabActivity);
        this.d = wp8Var;
        PriorityOrganizer.r(this.c, wp8Var);
        setPriority(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        mn8 mn8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921728 || (mn8Var = this.b) == null || mn8Var.B() == null || this.c.w(true)) {
            return;
        }
        this.c.F(true);
        this.a.P0().u(this.c);
    }
}
