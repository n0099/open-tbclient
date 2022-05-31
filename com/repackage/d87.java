package com.repackage;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imMessageCenter.mention.MsgReminderHttpRespMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d87 {
    public static /* synthetic */ Interceptable $ic;
    public static d87 d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpMessageListener a;
    public long b;
    public final Handler c;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d87 d87Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d87Var, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c87 msgData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage) && (msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData()) != null) {
                if (msgData.b() >= 0) {
                    cx4.f0().Y(msgData.b());
                }
                if (msgData.e() >= 0) {
                    cx4.f0().d0(msgData.e());
                }
                if (msgData.d() >= 0) {
                    cx4.f0().b0(msgData.d());
                }
                if (msgData.a() >= 0) {
                    cx4.f0().X(msgData.a());
                }
                if (msgData.c() >= 0) {
                    cx4.f0().Z(msgData.c());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d87 a;

        public b(d87 d87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d87Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                int i = message.arg1;
                this.a.b = System.currentTimeMillis();
                boolean z = !MessageManager.getInstance().getSocketClient().u();
                if (i == 2 || (z && ji.z())) {
                    this.a.h();
                }
                this.a.g(1, 600000L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755813458, "Lcom/repackage/d87;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755813458, "Lcom/repackage/d87;");
                return;
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_REMINDER_CMD, TbConfig.SERVER_ADDRESS + "c/s/msg");
        tbHttpMessageTask.setResponsedClass(MsgReminderHttpRespMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public d87() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new a(this, CmdConfigHttp.MSG_REMINDER_CMD);
        this.b = 0L;
        this.c = new b(this);
        MessageManager.getInstance().registerListener(this.a);
    }

    public static synchronized d87 e() {
        InterceptResult invokeV;
        d87 d87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (d87.class) {
                if (d == null) {
                    d = new d87();
                }
                d87Var = d;
            }
            return d87Var;
        }
        return (d87) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.removeMessages(1);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = 0L;
            d();
            i();
        }
    }

    public final void g(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            Message obtainMessage = this.c.obtainMessage(1);
            obtainMessage.arg1 = i;
            this.c.sendMessageDelayed(obtainMessage, j);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.MSG_REMINDER_CMD));
        }
    }

    public void i() {
        long j;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.b;
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis >= 600000) {
                i = 2;
                j = 10000;
            } else {
                j = 600000 - currentTimeMillis;
                i = 1;
            }
            g(i, j);
            this.b = System.currentTimeMillis();
        }
    }
}
