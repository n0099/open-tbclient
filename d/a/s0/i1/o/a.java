package d.a.s0.i1.o;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.i1.h.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import protobuf.NewpushGroupRepair;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static a f61802h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f61803a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f61804b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, GroupMsgData> f61805c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Long, NewpushGroupRepair> f61806d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f61807e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<Long> f61808f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f61809g;

    /* renamed from: d.a.s0.i1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class HandlerC1515a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61810a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1515a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61810a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(this.f61810a.f61809g);
                        return;
                    case 10003:
                        if (message.getData() == null || !message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                            return;
                        }
                        this.f61810a.f61808f.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f61811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f61812f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f61813g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f61814h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f61815i;

        public b(a aVar, long j, long j2, int i2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61815i = aVar;
            this.f61811e = j;
            this.f61812f = j2;
            this.f61813g = i2;
            this.f61814h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GroupMsgData groupMsgData = (GroupMsgData) this.f61815i.f61805c.get(Long.valueOf(this.f61811e));
                if (groupMsgData == null) {
                    this.f61815i.q(this.f61811e);
                    return;
                }
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                long j = -1;
                if (listMessage != null && listMessage.size() > 0) {
                    for (int i2 = 0; i2 < listMessage.size(); i2++) {
                        if (j < listMessage.get(i2).getSid()) {
                            j = listMessage.get(i2).getSid();
                        }
                    }
                    listMessage.clear();
                }
                long j2 = j;
                this.f61815i.q(this.f61811e);
                if (j2 > this.f61812f) {
                    this.f61815i.f61806d.put(Long.valueOf(this.f61811e), MessageUtils.makeNewpushGroupRepair(this.f61811e, this.f61813g, this.f61812f, j2, this.f61814h));
                    d.a.s0.i1.m.b.l().s(this.f61811e, 1L, 0L, true);
                    this.f61815i.f61808f.add(Long.valueOf(this.f61811e));
                    this.f61815i.o(this.f61811e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61816a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
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
            this.f61816a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f61816a.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1759502860, "Ld/a/s0/i1/o/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1759502860, "Ld/a/s0/i1/o/a;");
        }
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
        this.f61803a = null;
        this.f61804b = null;
        this.f61805c = null;
        this.f61806d = null;
        this.f61807e = null;
        this.f61808f = null;
        this.f61809g = new c(this, 2005016);
        this.f61803a = new HandlerC1515a(this, Looper.getMainLooper());
        this.f61804b = new Handler(Looper.myLooper());
        this.f61805c = new ConcurrentHashMap<>();
        this.f61806d = new ConcurrentHashMap<>();
        this.f61807e = new ConcurrentHashMap<>();
        this.f61808f = new Vector<>();
        this.f61803a.sendEmptyMessage(10002);
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f61802h == null) {
                synchronized (a.class) {
                    if (f61802h == null) {
                        f61802h = new a();
                    }
                }
            }
            return f61802h;
        }
        return (a) invokeV.objValue;
    }

    public final void g(long j, long j2, int i2, long j3) {
        GroupMsgData groupMsgData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) || (groupMsgData = this.f61805c.get(Long.valueOf(j2))) == null) {
            return;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() != 0) {
            if (this.f61807e.containsKey(Long.valueOf(j2))) {
                return;
            }
            p(j, j2, i2, j3);
            return;
        }
        q(j2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Handler handler = this.f61803a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.f61804b;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            ConcurrentHashMap<Long, Runnable> concurrentHashMap = this.f61807e;
            if (concurrentHashMap != null) {
                for (Map.Entry<Long, Runnable> entry : concurrentHashMap.entrySet()) {
                    q(entry.getKey().longValue());
                }
                this.f61807e.clear();
            }
            ConcurrentHashMap<Long, GroupMsgData> concurrentHashMap2 = this.f61805c;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
            }
            Vector<Long> vector = this.f61808f;
            if (vector != null) {
                vector.clear();
            }
        }
    }

    public NewpushGroupRepair j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (this.f61806d.containsKey(Long.valueOf(j))) {
                return this.f61806d.remove(Long.valueOf(j));
            }
            return null;
        }
        return (NewpushGroupRepair) invokeJ.objValue;
    }

    public final List<ChatMessage> k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            GroupMsgData groupMsgData = this.f61805c.get(Long.valueOf(j));
            LinkedList linkedList = null;
            if (groupMsgData == null) {
                return null;
            }
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage != null && listMessage.size() != 0) {
                linkedList = new LinkedList();
                Iterator<ChatMessage> it = listMessage.iterator();
                long sid = listMessage.get(0).getSid() - 1;
                while (it.hasNext()) {
                    ChatMessage next = it.next();
                    sid++;
                    if (next.getSid() != sid) {
                        break;
                    }
                    it.remove();
                    linkedList.add(next);
                }
            }
            return linkedList;
        }
        return (List) invokeJ.objValue;
    }

    public final boolean l(ChatMessage chatMessage, GroupMsgData groupMsgData) {
        InterceptResult invokeLL;
        LinkedList<ChatMessage> listMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, chatMessage, groupMsgData)) == null) {
            int i2 = 0;
            if (chatMessage == null || groupMsgData == null || (listMessage = groupMsgData.getListMessage()) == null) {
                return false;
            }
            if (listMessage.contains(chatMessage)) {
                return true;
            }
            int size = listMessage.size();
            while (i2 < size) {
                ChatMessage chatMessage2 = listMessage.get(i2);
                if (chatMessage2 != null) {
                    if (chatMessage.getSid() == chatMessage2.getSid()) {
                        return true;
                    }
                    if (chatMessage.getSid() < chatMessage2.getSid()) {
                        break;
                    }
                }
                i2++;
            }
            listMessage.add(i2, chatMessage);
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, groupMsgData, z) == null) || groupMsgData == null || groupMsgData.getGroupInfo() == null || (listMessage = groupMsgData.getListMessage()) == null || listMessage.size() == 0) {
            return;
        }
        long groupId = groupMsgData.getGroupInfo().getGroupId();
        ImMessageCenterPojo g2 = j.f().g(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
        if (!(g2 != null)) {
            if (this.f61808f.contains(Long.valueOf(groupId))) {
                return;
            }
            n(groupMsgData, listMessage, groupId);
            return;
        }
        long sid = g2.getSid();
        long c2 = d.a.s0.i1.w.b.c(g2.getPulled_msgId());
        GroupMsgData groupMsgData2 = this.f61805c.get(Long.valueOf(groupId));
        if (groupMsgData2 == null) {
            groupMsgData2 = new GroupMsgData(groupMsgData.getCmd());
            this.f61805c.put(Long.valueOf(groupId), groupMsgData2);
        }
        Iterator<ChatMessage> it = listMessage.iterator();
        while (it.hasNext()) {
            ChatMessage next = it.next();
            if (next.getSid() > sid) {
                l(next, groupMsgData2);
            }
        }
        listMessage.clear();
        List<ChatMessage> k = k(groupId);
        if (k != null && k.size() > 0) {
            if (!z && sid > 0 && k.get(0).getSid() != 1 + sid) {
                groupMsgData2.getListMessage().addAll(k);
            } else {
                listMessage.addAll(k);
                long sid2 = listMessage.get(listMessage.size() - 1).getSid();
                j2 = listMessage.get(listMessage.size() - 1).getMsgId();
                j = sid2;
                if (z) {
                    this.f61808f.remove(Long.valueOf(groupId));
                }
                if (this.f61808f.contains(Long.valueOf(groupId))) {
                    g(j, groupId, groupMsgData.getGroupInfo().getUserType(), j2);
                    return;
                }
                return;
            }
        }
        j = sid;
        j2 = c2;
        if (z) {
        }
        if (this.f61808f.contains(Long.valueOf(groupId))) {
        }
    }

    public final void n(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{groupMsgData, linkedList, Long.valueOf(j)}) == null) || groupMsgData == null || linkedList == null || linkedList.size() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        bundle.putLong("lastMid", linkedList.get(0).getMsgId());
        if (linkedList.get(0).getSid() > 0) {
            this.f61806d.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
        }
        bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
        Message message = new Message();
        message.what = 10001;
        message.setData(bundle);
        this.f61803a.sendMessage(message);
        linkedList.clear();
        this.f61808f.add(Long.valueOf(j));
        o(j);
    }

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            Message message = new Message();
            message.what = 10003;
            Bundle bundle = new Bundle();
            bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
            message.setData(bundle);
            this.f61803a.sendMessageDelayed(message, 3000L);
        }
    }

    public final void p(long j, long j2, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
            b bVar = new b(this, j2, j, i2, j3);
            this.f61804b.postDelayed(bVar, d.a.s0.i1.o.b.a().b().b());
            this.f61807e.put(Long.valueOf(j2), bVar);
        }
    }

    public final void q(long j) {
        Runnable remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048585, this, j) == null) || (remove = this.f61807e.remove(Long.valueOf(j))) == null) {
            return;
        }
        this.f61804b.removeCallbacks(remove);
    }
}
