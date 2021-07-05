package d.a.s0.a2.j;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
import com.baidu.tieba.myCollection.message.ResponseQueryCollectUpdateNumMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.c.g.c;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f57261d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f57262a;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public final Handler f57263b;

    /* renamed from: c  reason: collision with root package name */
    public final c f57264c;

    /* renamed from: d.a.s0.a2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class HandlerC1300a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57265a;

        public HandlerC1300a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57265a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                this.f57265a.f57262a = System.currentTimeMillis();
                MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
                this.f57265a.f57263b.sendMessageDelayed(this.f57265a.f57263b.obtainMessage(1), 1800000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
                d.a.r0.s.d.b.g0().a0(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-241117520, "Ld/a/s0/a2/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-241117520, "Ld/a/s0/a2/j/a;");
                return;
            }
        }
        d.a.s0.h3.d0.a.g(303005, ResponseQueryCollectUpdateNumMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        f57261d = null;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57262a = 0L;
        this.f57263b = new HandlerC1300a(this);
        this.f57264c = new b(this, 303005);
        MessageManager.getInstance().registerListener(this.f57264c);
    }

    public static synchronized a d() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            synchronized (a.class) {
                if (f57261d == null) {
                    f57261d = new a();
                }
                aVar = f57261d;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57263b.removeMessages(1);
            this.f57263b.removeMessages(2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57262a = 0L;
            c();
            f();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f57262a;
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis >= 1800000) {
                Handler handler = this.f57263b;
                handler.sendMessageDelayed(handler.obtainMessage(1), 10000L);
            } else {
                long j = 1800000 - currentTimeMillis;
                Handler handler2 = this.f57263b;
                handler2.sendMessageDelayed(handler2.obtainMessage(1), j);
            }
            this.f57262a = System.currentTimeMillis();
        }
    }
}
