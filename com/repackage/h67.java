package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.collection.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.rp.service.Service;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.PushCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import protobuf.NewpushRepair;
/* loaded from: classes6.dex */
public class h67 {
    public static /* synthetic */ Interceptable $ic;
    public static h67 q;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public List<GroupUpdateMessage> e;
    public int f;
    public long g;
    public int h;
    public final BdUniqueId i;
    public final Handler j;
    public LongSparseArray<Long> k;
    public LongSparseArray<Long> l;
    public final ja m;
    public final bb n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;

    /* loaded from: classes6.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2008017) {
                zy4.j().m();
                h67.l().z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002) {
                h67.l().o();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ja {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h67 a;

        public c(h67 h67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h67Var;
        }

        @Override // com.repackage.ja
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.ja
        public boolean b(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
                this.a.F();
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.repackage.ja
        public void c(jj jjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jjVar) == null) {
            }
        }

        @Override // com.repackage.ja
        public void d(rj rjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, rjVar) == null) {
            }
        }

        @Override // com.repackage.ja
        public void g(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                this.a.E();
                ba.a().c(map);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h67 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h67 h67Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h67Var, Integer.valueOf(i)};
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
            this.a = h67Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            if (socketResponsedMessage.getCmd() == 1003) {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() == 0) {
                    this.a.A();
                }
            } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (responseOnlineMessage.getError() != 0) {
                    return;
                }
                this.a.e = responseOnlineMessage.getGroupInfos();
                if (a67.o().y()) {
                    this.a.o();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h67 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h67 h67Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h67Var, Integer.valueOf(i)};
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
            this.a = h67Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    this.a.G();
                } else {
                    this.a.H();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h67 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(h67 h67Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h67Var, Integer.valueOf(i)};
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
            this.a = h67Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (this.a.k != null) {
                    this.a.k.clear();
                }
                if (this.a.l != null) {
                    this.a.l.clear();
                }
                this.a.e = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 2) {
                    h67.l().j.removeMessages(2);
                    h67.l().x();
                } else if (i != 3) {
                } else {
                    h67.l().j.removeMessages(3);
                    if (h67.l().h == 3) {
                        h67.l().v();
                    } else {
                        h67.l().x();
                    }
                    h67.l().j.sendMessageDelayed(h67.l().j.obtainMessage(3), h67.l().c);
                }
            }
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755696216, "Lcom/repackage/h67;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755696216, "Lcom/repackage/h67;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2008017));
        MessageManager.getInstance().registerListener(new b(2016002));
        q = null;
    }

    public h67() {
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
        this.a = 900000;
        this.b = 360000;
        this.c = 360000;
        this.d = 0;
        this.f = 0;
        this.g = 0L;
        this.h = 0;
        this.i = BdUniqueId.gen();
        this.j = new g(null);
        this.k = null;
        this.l = null;
        this.m = new c(this);
        this.n = new d(this, 0);
        this.o = new e(this, 2001011);
        this.p = new f(this, 2005016);
    }

    public static synchronized h67 l() {
        InterceptResult invokeV;
        h67 h67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (h67.class) {
                if (q == null) {
                    q = new h67();
                }
                h67Var = q;
            }
            return h67Var;
        }
        return (h67) invokeV.objValue;
    }

    public final synchronized void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.g < Service.TRIGGER_INTERVAL) {
                    return;
                }
                PushCountMessage pushCountMessage = new PushCountMessage();
                pushCountMessage.setPusherCount(this.f);
                pushCountMessage.setUpFlowSize(oj.j().p());
                pushCountMessage.setDownFlowSize(oj.j().i());
                pushCountMessage.setEnterForeCount(TbadkCoreApplication.getInst().getEnterForeCount());
                MessageManager.getInstance().sendMessage(pushCountMessage);
                this.g = System.currentTimeMillis();
                this.f = 0;
                oj.j().d();
                oj.j().e();
                TbadkCoreApplication.getInst().clearEnterForeCount();
            }
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i <= 0) {
            return;
        }
        this.a = i;
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || i <= 0) {
            return;
        }
        this.b = i;
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 1) {
                if (this.d != 2) {
                    this.d = 1;
                }
            } else if (i == 3 || i == 2) {
                this.d = 2;
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j();
            i();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l().c = l().a;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c = this.b;
        }
    }

    public final void h() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (i = this.d) == 0) {
            return;
        }
        if (i == 1) {
            s(0L, 0L, 0L);
        } else {
            x();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.j.removeMessages(3);
            this.j.removeMessages(2);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d = 0;
        }
    }

    public final MessageSyncMessage k(LongSparseArray<Long> longSparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, longSparseArray, i)) == null) {
            MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
            messageSyncMessage.setTag(this.i);
            if (longSparseArray != null && longSparseArray.size() > 0) {
                messageSyncMessage.setGroupMids(longSparseArray);
                NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(longSparseArray);
                if (makeNewpushRepair != null) {
                    messageSyncMessage.setNewpushRepire(makeNewpushRepair);
                }
            } else {
                messageSyncMessage.setGroupMids(a67.o().r());
            }
            LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
            if (msgBPicMaxSize != null) {
                messageSyncMessage.setWidth(msgBPicMaxSize.width);
                messageSyncMessage.setHeight(msgBPicMaxSize.height);
            }
            LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
            if (msgSPicMaxSize != null) {
                messageSyncMessage.setSmallHeight(msgSPicMaxSize.height);
                messageSyncMessage.setSmallWidth(msgSPicMaxSize.width);
            }
            messageSyncMessage.setSyncTypeString(String.valueOf(i));
            return messageSyncMessage;
        }
        return (MessageSyncMessage) invokeLI.objValue;
    }

    public void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            if (context != null) {
                MessageManager.getInstance().registerListener(this.o);
                MessageManager.getInstance().registerListener(this.p);
                cz4.j().p(this.m);
                MessageManager.getInstance().registerListener(1003, this.n);
                MessageManager.getInstance().registerListener(1001, this.n);
                MessageManager.getInstance().registerListener(202101, this.n);
                z();
                return;
            }
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.e == null) {
            return;
        }
        boolean z = false;
        LongSparseArray<Long> r = a67.o().r();
        if (r == null) {
            this.e = null;
            return;
        }
        Iterator<GroupUpdateMessage> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GroupUpdateMessage next = it.next();
            if (next != null && r.get(next.getGroupId()) != null) {
                if (r.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
                    z = true;
                    break;
                }
            }
        }
        this.h = 3;
        if (z) {
            Handler handler = this.j;
            handler.sendMessage(handler.obtainMessage(3));
        } else {
            l().j.sendMessageDelayed(l().j.obtainMessage(3), l().c);
        }
        this.e = null;
    }

    public final void p(LongSparseArray<Long> longSparseArray, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, longSparseArray, i) == null) {
            q(longSparseArray, i, 0L);
        }
    }

    public final void q(LongSparseArray<Long> longSparseArray, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{longSparseArray, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (MessageManager.getInstance().getSocketClient().r() > 10) {
                o85.b(false, true, false);
                Handler handler = this.j;
                handler.sendMessageDelayed(handler.obtainMessage(2), 2000L);
                return;
            }
            boolean t = MessageManager.getInstance().getSocketClient().t(202003, this.i);
            int s = MessageManager.getInstance().getSocketClient().s(202003);
            if (!t && s <= 0) {
                j();
                LongSparseArray<Long> longSparseArray2 = null;
                if (longSparseArray != null && longSparseArray.size() > 0) {
                    longSparseArray2 = new LongSparseArray<>();
                    for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                        long keyAt = longSparseArray.keyAt(i2);
                        longSparseArray2.put(keyAt, Long.valueOf(longSparseArray.get(keyAt).longValue()));
                    }
                }
                MessageSyncMessage k = k(longSparseArray2, i);
                if (i == 3 || i == 2) {
                    k.setNewpushRepire(a67.o().s());
                } else if (i == 1 && j > 0) {
                    k.setNotifyMsgId(j);
                }
                MessageManager.getInstance().sendMessage(k);
                o85.b(true, false, false);
                if (i == 3 || i == 1 || i == 2) {
                    LongSparseArray<Long> longSparseArray3 = this.k;
                    if (longSparseArray3 != null) {
                        longSparseArray3.clear();
                    }
                    LongSparseArray<Long> longSparseArray4 = this.l;
                    if (longSparseArray4 != null) {
                        longSparseArray4.clear();
                        return;
                    }
                    return;
                }
                return;
            }
            o85.b(false, false, true);
            D(i);
        }
    }

    public synchronized void r(LongSparseArray<Long> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, longSparseArray) == null) {
            synchronized (this) {
                if (longSparseArray != null) {
                    if (longSparseArray.size() != 0) {
                        this.h = 4;
                        this.j.removeMessages(3);
                        l().j.sendMessageDelayed(l().j.obtainMessage(3), l().c);
                        p(longSparseArray, 4);
                    }
                }
            }
        }
    }

    public void s(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            t(j, j2, j3, false);
        }
    }

    public synchronized void t(long j, long j2, long j3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                u(j, j2, j3, z, false);
            }
        }
    }

    public synchronized void u(long j, long j2, long j3, boolean z, boolean z2) {
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                this.f++;
                this.h = 1;
                this.j.removeMessages(3);
                l().j.sendMessageDelayed(l().j.obtainMessage(3), l().c);
                if (this.k == null) {
                    LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
                    this.k = longSparseArray;
                    longSparseArray.clear();
                }
                if (this.l == null) {
                    this.l = new LongSparseArray<>();
                }
                LongSparseArray<Long> r = a67.o().r();
                if (0 != j) {
                    Long l = r.get(j);
                    Long l2 = this.k.get(j);
                    if (l == null) {
                        longValue = (l2 != null && l2.longValue() < j2) ? l2.longValue() : j2;
                    } else {
                        longValue = l.longValue();
                    }
                    if (longValue > 0) {
                        this.k.put(j, Long.valueOf(longValue));
                    }
                }
                if (this.k != null && this.k.size() > 0) {
                    for (int i = 0; i < this.k.size(); i++) {
                        long keyAt = this.k.keyAt(i);
                        Long l3 = r.get(keyAt);
                        if (l3 != null && l3.longValue() > 0) {
                            this.k.put(keyAt, l3);
                        }
                    }
                }
                if (!z) {
                    if (j > 0 && j2 > 0) {
                        if (this.l.get(j) == null) {
                            this.l.put(j, Long.valueOf(j2));
                        } else {
                            long longValue2 = this.l.get(j).longValue();
                            if (longValue2 <= j2) {
                                longValue2 = j2;
                            }
                            this.l.put(j, Long.valueOf(longValue2));
                        }
                    }
                    int size = this.k.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < size; i2++) {
                        long keyAt2 = this.k.keyAt(i2);
                        if (this.k.valueAt(i2).longValue() >= (this.l.get(keyAt2) != null ? this.l.get(keyAt2).longValue() : 0L)) {
                            arrayList.add(Long.valueOf(j));
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.k.remove(((Long) it.next()).longValue());
                    }
                }
                if (this.k.size() == 0) {
                    j();
                    this.l.clear();
                    return;
                }
                if (z2) {
                    q(this.k, 1, j2);
                } else {
                    p(this.k, 1);
                }
            }
        }
    }

    public synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this) {
                y(3);
            }
        }
    }

    public void w(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            f87.a(j2);
            u(j, j2, j3, false, true);
        }
    }

    public synchronized void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                y(2);
            }
        }
    }

    public final synchronized void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            synchronized (this) {
                this.h = i;
                p(null, i);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
            if (socketGetMsgStratgy.length == 2) {
                C(socketGetMsgStratgy[0] * 1000);
                B(socketGetMsgStratgy[1] * 1000);
            }
        }
    }
}
