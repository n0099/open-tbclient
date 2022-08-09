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
import com.repackage.aa;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes6.dex */
public class da extends v9<SocketMessage, SocketMessageTask> implements ka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aa.a b;
    public final LinkedList<ba> c;
    public final LinkedList<ba> d;
    public final LinkedList<ba> e;
    public ka f;
    public boolean g;
    public y9 h;
    public long i;
    public int j;

    /* loaded from: classes6.dex */
    public class a implements aa.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ da a;

        public a(da daVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {daVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = daVar;
        }

        @Override // com.repackage.aa.a
        public void a(aa.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.a.w(bVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1954176278, "Lcom/repackage/da$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1954176278, "Lcom/repackage/da$b;");
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
    public da(MessageManager messageManager) {
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

    public void A(ba baVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baVar) == null) {
            if (baVar != null && baVar.i() && baVar.p() < baVar.l()) {
                z9.j(this.c, this.e, baVar);
                y9 y9Var = this.h;
                if (y9Var != null) {
                    y9Var.b(true, "timeout seq = " + baVar.q());
                }
                fa.c("queue", baVar.m(), baVar.q(), "onSendTimeOut", ea.t, String.valueOf(baVar.p()));
                return;
            }
            C(baVar);
            v(baVar, ea.m, null);
            E();
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public final void C(ba baVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baVar) == null) || baVar == null) {
            return;
        }
        baVar.w();
        z9.n(baVar, this.c);
        z9.n(baVar, this.d);
        z9.n(baVar, this.e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.s9
    /* renamed from: D */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, socketMessage, socketMessageTask) == null) {
            qi.c();
            if (socketMessage == null || socketMessageTask == null) {
                return;
            }
            if (m(socketMessage, socketMessageTask.a())) {
                fa.c("queue", socketMessage, 0, "sendMessage", ea.q, "duplicate message be removed");
                return;
            }
            ba baVar = new ba(socketMessage, socketMessageTask, this);
            if (BdSocketLinkService.hasAbsoluteClose()) {
                fa.c("queue", socketMessage, 0, "sendMessage", ea.z, "user manual close socket");
                baVar.a(ea.z);
            } else if (!BdSocketLinkService.isAvailable()) {
                fa.c("queue", socketMessage, 0, "sendMessage", ea.p, "isManualBlock message be removed");
                baVar.a(ea.p);
            } else {
                fa.c("queue", socketMessage, 0, "sendMessage", 0, "socketclient: send message");
                z9.h(baVar, this.d);
                E();
            }
        }
    }

    public final void E() {
        ba f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (f = z9.f(this.d)) == null) {
            return;
        }
        if (BdSocketLinkService.isClose()) {
            fa.c("queue", f.m(), 0, "sendNext", ea.r, "");
            BdSocketLinkService.startService(false, "send message");
        } else if (!this.g || f.n() <= -3) {
            BdSocketLinkService.sendMessage(f);
        }
    }

    public void F(ka kaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kaVar) == null) {
            this.f = kaVar;
        }
    }

    public void G(y9 y9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, y9Var) == null) {
            this.h = y9Var;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = this.g;
            this.g = false;
            fa.a("queue", 0, 0, "unBlockMessageQueue", ea.s, "Queue block has release");
            if (z) {
                E();
            }
        }
    }

    @Override // com.repackage.ka
    public void a(String str) {
        ka kaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (kaVar = this.f) == null) {
            return;
        }
        kaVar.a(str);
    }

    @Override // com.repackage.ka
    public boolean b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, str)) == null) {
            ka kaVar = this.f;
            if (kaVar != null) {
                kaVar.b(i, str);
            }
            y9 y9Var = this.h;
            if (y9Var != null) {
                y9Var.a();
            }
            if (qi.D() && !z9.a(this.e) && !z9.a(this.d) && !z9.a(this.c) && BdSocketLinkService.isAvailable()) {
                z9.b(this.c);
                z9.i(this.d, this.e);
                z9.i(this.d, this.c);
                while (true) {
                    ba k = z9.k(this.d);
                    if (k == null) {
                        break;
                    }
                    k.w();
                    v(k, ea.o, null);
                }
                if (z9.q(this.d) > 0) {
                    fa.a("queue", 0, 0, "onClose", ea.u, "have retry message, MessageQueue:reconnect");
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

    @Override // com.repackage.ka
    public void c(kj kjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kjVar) == null) {
            E();
            ka kaVar = this.f;
            if (kaVar != null) {
                kaVar.c(kjVar);
            }
        }
    }

    @Override // com.repackage.ka
    public void d(sj sjVar) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sjVar) == null) || sjVar == null || (bArr = sjVar.a) == null) {
            return;
        }
        this.i = System.currentTimeMillis();
        try {
            ia c = ha.f().c(bArr);
            this.j = 0;
            int b2 = c.a.b();
            int h = c.a.h();
            fa.a("queue", b2, h, "onBinaryMesssage", 0, "onBinaryMesssage succ size = " + bArr.length);
            ba o = o(b2, h);
            if (o != null) {
                o.m = sjVar.b;
                o.n = sjVar.c;
            }
            if (this.h != null) {
                if (c.a.b() == this.h.c() && z9.i(this.d, this.e)) {
                    E();
                }
                this.h.e();
            }
            if (h == 0 || (o != null && o.k() == b2)) {
                new aa(c, o, this.b, h).execute(new String[0]);
            } else if (o != null) {
                v(o, ea.A, null);
            }
            ka kaVar = this.f;
            if (kaVar != null) {
                kaVar.d(sjVar);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2000986));
        } catch (CoderException unused) {
            int q = mh.o().q("alert_protobuf", 2);
            int i = this.j + 1;
            this.j = i;
            if (i >= q) {
                BdStatisticsManager.getInstance().alert("alert_protobuf", "protbuf");
            }
            fa.a("queue", 0, 0, "onBinaryMesssage", ea.j, "onBinaryMesssage decodeHeader error");
        }
    }

    @Override // com.repackage.s9
    public LinkedList<SocketMessage> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, bdUniqueId)) == null) {
            return null;
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.repackage.ka
    public void g(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            ca.a().c(map);
            y9 y9Var = this.h;
            if (y9Var != null) {
                y9Var.e();
            }
            this.g = true;
            fa.a("queue", 0, 0, "onConnected", ea.y, "Queue blocked");
            ka kaVar = this.f;
            if (kaVar != null) {
                kaVar.g(map);
            }
        }
    }

    @Override // com.repackage.s9
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, bdUniqueId) == null) {
            z9.m(this.c, i, bdUniqueId);
            z9.m(this.d, i, bdUniqueId);
            z9.m(this.e, i, bdUniqueId);
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

    public final void k(LinkedList<ba> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, linkedList) != null) {
            return;
        }
        while (true) {
            ba l = z9.l(linkedList);
            if (l == null) {
                return;
            }
            l.w();
            v(l, ea.o, null);
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
                    z9.o(this.d, cmd);
                    z9.o(this.c, cmd);
                    z9.o(this.e, cmd);
                    return false;
                } else if (i == 2) {
                    z9.o(this.d, cmd);
                    return false;
                } else if (i != 3) {
                    return false;
                } else {
                    return z9.e(this.d, cmd) || z9.e(this.c, cmd) || z9.e(this.e, cmd);
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
            if (socketMessage == null || !(socketMessage instanceof x9)) {
                return false;
            }
            x9 x9Var = (x9) socketMessage;
            return z9.d(this.d, x9Var, socketMessage.getCmd()) || z9.d(this.c, x9Var, socketMessage.getCmd()) || z9.d(this.e, x9Var, socketMessage.getCmd());
        }
        return invokeL.booleanValue;
    }

    public final ba o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048597, this, i, i2)) == null) {
            if (i2 != 0) {
                ba p = z9.p(i2, this.c);
                if (p == null && (p = z9.p(i2, this.e)) == null && (p = z9.p(i2, this.d)) == null) {
                    fa.a("queue", i, i2, "findSenderData", ea.w, "original message removed , responsedMessage not dispatchMessage");
                    return p;
                }
                fa.a("queue", i, i2, "findSenderData", ea.v, "received ack message");
                return p;
            }
            return null;
        }
        return (ba) invokeII.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.i : invokeV.longValue;
    }

    public y9 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.h : (y9) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? BdAsyncTask.getTaskNum(aa.e()) : invokeV.intValue;
    }

    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) ? BdAsyncTask.getTaskNum(String.valueOf(i), aa.e()) : invokeI.intValue;
    }

    public boolean t(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, bdUniqueId)) == null) ? z9.c(this.d, i, bdUniqueId) || z9.c(this.c, i, bdUniqueId) || z9.c(this.e, i, bdUniqueId) : invokeIL.booleanValue;
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
    public void v(ba baVar, int i, String str) {
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048604, this, baVar, i, str) == null) || baVar == null || baVar.m() == null) {
            return;
        }
        int cmd = baVar.m().getCmd();
        int q = baVar.q();
        fa.c("queue", baVar.m(), q, "onMessageSendFail", i, str + " retryTime-" + baVar.p());
        SocketMessageTask t = baVar != null ? baVar.t() : null;
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
                socketResponsedMessage.setErrorString(ea.i(i));
            } else {
                socketResponsedMessage.setErrorString(str);
            }
            socketResponsedMessage.setOrginalMessage(baVar.m());
            fa.c("queue", baVar.m(), q, "onMessageSendFail", i, "onMessageSendFail class = " + socketResponsedMessage.getClass().getName());
            this.a.dispatchResponsedMessage(socketResponsedMessage);
            return;
        }
        socketResponsedMessage = null;
        if (socketResponsedMessage != null) {
        }
    }

    public final void w(aa.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) || bVar == null) {
            return;
        }
        ba baVar = bVar.b;
        if (baVar != null) {
            v(baVar, ea.c, null);
            return;
        }
        SocketResponsedMessage socketResponsedMessage = bVar.a;
        if (socketResponsedMessage == null) {
            return;
        }
        fa.c("queue", socketResponsedMessage.getOrginalMessage(), 0, "onReceiveMessage", 0, "unpack succ");
        l(socketResponsedMessage);
    }

    public void x(int i, ba baVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i, baVar) == null) {
            if (i == 2) {
                if (baVar.r() != null) {
                    i2 = baVar.r().getErrorCode();
                } else {
                    i2 = ea.i;
                }
            } else {
                i2 = ea.n;
            }
            String i3 = ea.i(i2);
            C(baVar);
            v(baVar, i2, i3);
        }
    }

    public void y(ba baVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, baVar) == null) {
        }
    }

    public void z(ba baVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, baVar) == null) || baVar == null) {
            return;
        }
        if (baVar.v()) {
            baVar.h();
            z9.j(this.d, this.c, baVar);
            return;
        }
        z9.n(baVar, this.d);
    }
}
