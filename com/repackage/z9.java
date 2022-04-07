package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w9;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes7.dex */
public class z9 extends r9<SocketMessage, SocketMessageTask> implements ga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w9.a b;
    public final LinkedList<x9> c;
    public final LinkedList<x9> d;
    public final LinkedList<x9> e;
    public ga f;
    public boolean g;
    public u9 h;
    public long i;
    public int j;

    /* loaded from: classes7.dex */
    public class a implements w9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z9 a;

        public a(z9 z9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z9Var;
        }

        @Override // com.repackage.w9.a
        public void a(w9.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.a.w(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1935050456, "Lcom/repackage/z9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1935050456, "Lcom/repackage/z9$b;");
                    return;
                }
            }
            int[] iArr = new int[SocketMessageTask.DupLicateMode.values().length];
            a = iArr;
            try {
                iArr[SocketMessageTask.DupLicateMode.REMOVE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SocketMessageTask.DupLicateMode.REMOVE_WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SocketMessageTask.DupLicateMode.REMOVE_ME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z9(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = null;
        this.g = true;
        this.h = null;
        this.i = 0L;
        this.j = 0;
        BdSocketLinkService.setConnStateCallBack(this);
        this.b = new a(this);
    }

    public void A(x9 x9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, x9Var) == null) {
            if (x9Var != null && x9Var.i() && x9Var.p() < x9Var.l()) {
                v9.j(this.c, this.e, x9Var);
                u9 u9Var = this.h;
                if (u9Var != null) {
                    u9Var.b(true, "timeout seq = " + x9Var.q());
                }
                ba.c("queue", x9Var.m(), x9Var.q(), "onSendTimeOut", aa.t, String.valueOf(x9Var.p()));
                return;
            }
            C(x9Var);
            v(x9Var, aa.m, null);
            E();
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(x9 x9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x9Var) == null) || x9Var == null) {
            return;
        }
        x9Var.w();
        v9.n(x9Var, this.c);
        v9.n(x9Var, this.d);
        v9.n(x9Var, this.e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o9
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            oi.c();
            if (socketMessage == null || socketMessageTask == null) {
                return;
            }
            if (m(socketMessage, socketMessageTask.a())) {
                ba.c("queue", socketMessage, 0, "sendMessage", aa.q, "duplicate message be removed");
                return;
            }
            x9 x9Var = new x9(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                ba.c("queue", socketMessage, 0, "sendMessage", aa.z, "user manual close socket");
                x9Var.a(aa.z);
            } else if (!BdSocketLinkService.isAvailable()) {
                ba.c("queue", socketMessage, 0, "sendMessage", aa.p, "isManualBlock message be removed");
                x9Var.a(aa.p);
            } else {
                ba.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                v9.h(x9Var, this.d);
                E();
            }
        }
    }

    public final void E() {
        x9 f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (f = v9.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            ba.c("queue", f.m(), 0, "sendNext", aa.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.g || f.n() <= -3) {
            BdSocketLinkService.sendMessage(f);
        }
    }

    public void F(ga gaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gaVar) == null) {
            this.f = gaVar;
        }
    }

    public void G(u9 u9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, u9Var) == null) {
            this.h = u9Var;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = this.g;
            this.g = false;
            ba.a("queue", 0, 0, "unBlockMessageQueue", aa.s, "Queue block has release");
            if (z) {
                E();
            }
        }
    }

    @Override // com.repackage.ga
    public void a(String str) {
        ga gaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (gaVar = this.f) == null) {
            return;
        }
        gaVar.a(str);
    }

    @Override // com.repackage.ga
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            ga gaVar = this.f;
            if (gaVar != null) {
                gaVar.b(i, str);
            }
            u9 u9Var = this.h;
            if (u9Var != null) {
                u9Var.a();
            }
            if (oi.C() && !v9.a(this.e) && !v9.a(this.d) && !v9.a(this.c) && BdSocketLinkService.isAvailable()) {
                v9.b(this.c);
                v9.i(this.d, this.e);
                v9.i(this.d, this.c);
                while (true) {
                    x9 k = v9.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, aa.o, null);
                }
                if (v9.q(this.d) > 0) {
                    ba.a("queue", 0, 0, "onClose", aa.u, "have retry message, MessageQueue:reconnect");
                    BdSocketLinkService.startService(false, "have retry message");
                    return true;
                }
                return false;
            }
            j();
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.repackage.ga
    public void c(jj jjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jjVar) == null) {
            E();
            ga gaVar = this.f;
            if (gaVar != null) {
                gaVar.c(jjVar);
            }
        }
    }

    @Override // com.repackage.ga
    public void d(rj rjVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, rjVar) == null) || rjVar == null || (bArr = rjVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            ea c = da.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            ba.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            x9 o = o(b2, h);
            if (o != null) {
                o.m = rjVar.b;
                o.n = rjVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && v9.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h == 0 || (o != null && o.k() == b2)) {
                new w9(c, o, this.b, h).execute(new String[0]);
            } else if (o != null) {
                v(o, aa.A, null);
            }
            ga gaVar = this.f;
            if (gaVar != null) {
                gaVar.d(rjVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = kh.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            ba.a("queue", 0, 0, "onBinaryMesssage", aa.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.repackage.o9
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.repackage.ga
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            y9.a().c(map);
            u9 u9Var = this.h;
            if (u9Var != null) {
                u9Var.e();
            }
            this.g = true;
            ba.a("queue", 0, 0, "onConnected", aa.y, "Queue blocked");
            ga gaVar = this.f;
            if (gaVar != null) {
                gaVar.g(map);
            }
        }
    }

    @Override // com.repackage.o9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            v9.m(this.c, i, bdUniqueId);
            v9.m(this.d, i, bdUniqueId);
            v9.m(this.e, i, bdUniqueId);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            k(this.c);
            k(this.d);
            k(this.e);
        }
    }

    public final void k(LinkedList<x9> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            x9 l = v9.l(linkedList);
            if (l == null) {
                return;
            }
            l.w();
            v(l, aa.o, null);
        }
    }

    public final void l(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, socketResponsedMessage) == null) {
            this.a.dispatchResponsedMessage(socketResponsedMessage);
        }
    }

    public final boolean m(SocketMessage socketMessage, SocketMessageTask.DupLicateMode dupLicateMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, socketMessage, dupLicateMode)) == null) {
            if (socketMessage != null) {
                int cmd = socketMessage.getCmd();
                int i = b.a[dupLicateMode.ordinal()];
                if (i == 1) {
                    v9.o(this.d, cmd);
                    v9.o(this.c, cmd);
                    v9.o(this.e, cmd);
                    return false;
                } else if (i == 2) {
                    v9.o(this.d, cmd);
                    return false;
                } else if (i != 3) {
                    return false;
                } else {
                    return v9.e(this.d, cmd) || v9.e(this.c, cmd) || v9.e(this.e, cmd);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean n(SocketMessage socketMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, socketMessage)) == null) {
            if (socketMessage == null || !(socketMessage instanceof t9)) {
                return false;
            }
            t9 t9Var = (t9) socketMessage;
            return v9.d(this.d, t9Var, socketMessage.getCmd()) || v9.d(this.c, t9Var, socketMessage.getCmd()) || v9.d(this.e, t9Var, socketMessage.getCmd());
        }
        return invokeL.booleanValue;
    }

    public final x9 o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                x9 p = v9.p(i2, this.c);
                if (p == null && (p = v9.p(i2, this.e)) == null && (p = v9.p(i2, this.d)) == null) {
                    ba.a("queue", i, i2, "findSenderData", aa.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                ba.a("queue", i, i2, "findSenderData", aa.v, "received ack message");
                return p;
            }
            return null;
        }
        return (x9) invokeII.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.i : invokeV.longValue;
    }

    public u9 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.h : (u9) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? BdAsyncTask.getTaskNum(w9.e()) : invokeV.intValue;
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) ? BdAsyncTask.getTaskNum(String.valueOf(i), w9.e()) : invokeI.intValue;
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) ? v9.c(this.d, i, bdUniqueId) || v9.c(this.c, i, bdUniqueId) || v9.c(this.e, i, bdUniqueId) : invokeIL.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? BdSocketLinkService.isOpen() && !this.g && BdSocketLinkService.isAvailable() : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(x9 x9Var, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048604, this, x9Var, i, str) == null) || x9Var == null || x9Var.m() == null) {
            return;
        }
        int cmd = x9Var.m().getCmd();
        int q = x9Var.q();
        ba.c("queue", x9Var.m(), q, "onMessageSendFail", i, str + " retryTime-" + x9Var.p());
        SocketMessageTask t = x9Var != null ? x9Var.t() : null;
        if (t == null) {
            t = (SocketMessageTask) this.a.findTask(cmd);
        }
        if (t != null && t.getResponsedClass() != null) {
            try {
                socketResponsedMessage = t.getResponsedClass().newInstance();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                try {
                    socketResponsedMessage = t.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(cmd));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            if (socketResponsedMessage != null) {
                return;
            }
            socketResponsedMessage.setError(i);
            if (str == null) {
                socketResponsedMessage.setErrorString(aa.i(i));
            } else {
                socketResponsedMessage.setErrorString(str);
            }
            socketResponsedMessage.setOrginalMessage(x9Var.m());
            ba.c("queue", x9Var.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
            this.a.dispatchResponsedMessage(socketResponsedMessage);
            return;
        }
        socketResponsedMessage = null;
        if (socketResponsedMessage != null) {
        }
    }

    public final void w(w9.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) || bVar == null) {
            return;
        }
        x9 x9Var = bVar.b;
        if (x9Var != null) {
            v(x9Var, aa.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        ba.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public void x(int i, x9 x9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, x9Var) == null) {
            if (i == 2) {
                if (x9Var.r() != null) {
                    i2 = x9Var.r().getErrorCode();
                } else {
                    i2 = aa.i;
                }
            } else {
                i2 = aa.n;
            }
            String i3 = aa.i(i2);
            C(x9Var);
            v(x9Var, i2, i3);
        }
    }

    public void y(x9 x9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, x9Var) == null) {
        }
    }

    public void z(x9 x9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, x9Var) == null) || x9Var == null) {
            return;
        }
        if (x9Var.v()) {
            x9Var.h();
            v9.j(this.d, this.c, x9Var);
            return;
        }
        v9.n(x9Var, this.d);
    }
}
