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
public class i77 {
    public static /* synthetic */ Interceptable $ic;
    public static i77 q;
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
    public final ga m;
    public final ya n;
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
                cz4.j().m();
                i77.l().w();
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
                i77.l().o();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ga {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i77 a;

        public c(i77 i77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i77Var;
        }

        @Override // com.repackage.ga
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.ga
        public boolean b(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
                this.a.C();
                return false;
            }
            return invokeIL.booleanValue;
        }

        @Override // com.repackage.ga
        public void c(jj jjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jjVar) == null) {
            }
        }

        @Override // com.repackage.ga
        public void d(rj rjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, rjVar) == null) {
            }
        }

        @Override // com.repackage.ga
        public void g(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                this.a.B();
                y9.a().c(map);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i77 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i77 i77Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i77Var, Integer.valueOf(i)};
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
            this.a = i77Var;
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
                    this.a.x();
                }
            } else if (socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (responseOnlineMessage.getError() != 0) {
                    return;
                }
                this.a.e = responseOnlineMessage.getGroupInfos();
                if (b77.p().A()) {
                    this.a.o();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i77 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(i77 i77Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i77Var, Integer.valueOf(i)};
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
            this.a = i77Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    this.a.D();
                } else {
                    this.a.E();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i77 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(i77 i77Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i77Var, Integer.valueOf(i)};
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
            this.a = i77Var;
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
                    i77.l().j.removeMessages(2);
                    i77.l().u();
                } else if (i != 3) {
                } else {
                    i77.l().j.removeMessages(3);
                    if (i77.l().h == 3) {
                        i77.l().t();
                    } else {
                        i77.l().u();
                    }
                    i77.l().j.sendMessageDelayed(i77.l().j.obtainMessage(3), i77.l().c);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755665464, "Lcom/repackage/i77;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755665464, "Lcom/repackage/i77;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2008017));
        MessageManager.getInstance().registerListener(new b(2016002));
        q = null;
    }

    public i77() {
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

    public static synchronized i77 l() {
        InterceptResult invokeV;
        i77 i77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (i77.class) {
                if (q == null) {
                    q = new i77();
                }
                i77Var = q;
            }
            return i77Var;
        }
        return (i77) invokeV.objValue;
    }

    public final void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == 1) {
                if (this.d != 2) {
                    this.d = 1;
                }
            } else if (i == 3 || i == 2) {
                this.d = 2;
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j();
            i();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l().c = l().a;
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = this.b;
        }
    }

    public final void h() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (i = this.d) == 0) {
            return;
        }
        if (i == 1) {
            r(0L, 0L, 0L);
        } else {
            u();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.removeMessages(3);
            this.j.removeMessages(2);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d = 0;
        }
    }

    public final MessageSyncMessage k(LongSparseArray<Long> longSparseArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, longSparseArray, i)) == null) {
            MessageSyncMessage messageSyncMessage = new MessageSyncMessage();
            messageSyncMessage.setTag(this.i);
            if (longSparseArray != null && longSparseArray.size() > 0) {
                messageSyncMessage.setGroupMids(longSparseArray);
                NewpushRepair makeNewpushRepair = MessageUtils.makeNewpushRepair(longSparseArray);
                if (makeNewpushRepair != null) {
                    messageSyncMessage.setNewpushRepire(makeNewpushRepair);
                }
            } else {
                messageSyncMessage.setGroupMids(b77.p().s());
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
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            if (context != null) {
                MessageManager.getInstance().registerListener(this.o);
                MessageManager.getInstance().registerListener(this.p);
                fz4.j().p(this.m);
                MessageManager.getInstance().registerListener(1003, this.n);
                MessageManager.getInstance().registerListener(1001, this.n);
                MessageManager.getInstance().registerListener(202101, this.n);
                w();
                return;
            }
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.e == null) {
            return;
        }
        boolean z = false;
        LongSparseArray<Long> s = b77.p().s();
        if (s == null) {
            this.e = null;
            return;
        }
        Iterator<GroupUpdateMessage> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GroupUpdateMessage next = it.next();
            if (next != null && s.get(next.getGroupId()) != null) {
                if (s.get(next.getGroupId()).longValue() < next.getLastMsgId()) {
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
        if (interceptable == null || interceptable.invokeLI(1048588, this, longSparseArray, i) == null) {
            if (MessageManager.getInstance().getSocketClient().r() > 10) {
                q85.b(false, true, false);
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
                    k.setNewpushRepire(b77.p().t());
                }
                MessageManager.getInstance().sendMessage(k);
                q85.b(true, false, false);
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
            q85.b(false, false, true);
            A(i);
        }
    }

    public synchronized void q(LongSparseArray<Long> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, longSparseArray) == null) {
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

    public void r(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            s(j, j2, j3, false);
        }
    }

    public synchronized void s(long j, long j2, long j3, boolean z) {
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)}) == null) {
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
                LongSparseArray<Long> s = b77.p().s();
                if (0 != j) {
                    Long l = s.get(j);
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
                        Long l3 = s.get(keyAt);
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
                p(this.k, 1);
            }
        }
    }

    public synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                v(3);
            }
        }
    }

    public synchronized void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                v(2);
            }
        }
    }

    public final synchronized void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            synchronized (this) {
                this.h = i;
                p(null, i);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int[] socketGetMsgStratgy = TbadkCoreApplication.getInst().getSocketGetMsgStratgy();
            if (socketGetMsgStratgy.length == 2) {
                z(socketGetMsgStratgy[0] * 1000);
                y(socketGetMsgStratgy[1] * 1000);
            }
        }
    }

    public final synchronized void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || i <= 0) {
            return;
        }
        this.a = i;
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || i <= 0) {
            return;
        }
        this.b = i;
    }
}
