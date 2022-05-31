package com.repackage;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class di4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ei4 a;
    public long b;
    public CustomMessageListener c;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(di4 di4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {di4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = di4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.g();
        }
    }

    public di4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this, 2001371);
        this.a = new ei4();
        MessageManager.getInstance().registerListener(this.c);
        g();
        this.b = ys4.k().m("key_redpacket_pop_last_time", 0L);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d() && e()) {
            f();
        }
    }

    public final boolean c(ii4 ii4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ii4Var)) == null) ? ii4Var != null && this.b >= ii4Var.b() && this.b <= ii4Var.a() : invokeL.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Date date = new Date();
            return date.getTime() >= this.a.b() && date.getTime() <= this.a.a();
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.a.c())) {
                return false;
            }
            Date date = new Date();
            Iterator<ii4> it = this.a.c().iterator();
            while (it.hasNext()) {
                ii4 next = it.next();
                if (date.getTime() >= next.b() && date.getTime() <= next.a() && !c(next)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ki.isEmpty(this.a.d())) {
            return;
        }
        this.b = System.currentTimeMillis();
        ys4.k().x("key_redpacket_pop_last_time", this.b);
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RED_PACKET_POP_WINDOW_SHOW));
        String str = this.a.d() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.e(ys4.k().q("key_redpacket_pop", ""));
        }
    }
}
