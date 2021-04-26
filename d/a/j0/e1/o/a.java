package d.a.j0.e1.o;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import d.a.j0.e1.h.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import protobuf.NewpushGroupRepair;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: h  reason: collision with root package name */
    public static a f53748h;

    /* renamed from: a  reason: collision with root package name */
    public Handler f53749a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f53750b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, GroupMsgData> f53751c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Long, NewpushGroupRepair> f53752d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f53753e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<Long> f53754f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f53755g = new c(2005016);

    /* renamed from: d.a.j0.e1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1231a extends Handler {
        public HandlerC1231a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 10001:
                    MessageUtils.updateGroupNotExist(message.getData());
                    return;
                case 10002:
                    MessageManager.getInstance().registerListener(a.this.f53755g);
                    return;
                case 10003:
                    if (message.getData() == null || !message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                        return;
                    }
                    a.this.f53754f.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f53757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f53758f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53759g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f53760h;

        public b(long j, long j2, int i2, long j3) {
            this.f53757e = j;
            this.f53758f = j2;
            this.f53759g = i2;
            this.f53760h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupMsgData groupMsgData = (GroupMsgData) a.this.f53751c.get(Long.valueOf(this.f53757e));
            if (groupMsgData == null) {
                a.this.q(this.f53757e);
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
            a.this.q(this.f53757e);
            if (j2 > this.f53758f) {
                a.this.f53752d.put(Long.valueOf(this.f53757e), MessageUtils.makeNewpushGroupRepair(this.f53757e, this.f53759g, this.f53758f, j2, this.f53760h));
                d.a.j0.e1.m.b.l().s(this.f53757e, 1L, 0L, true);
                a.this.f53754f.add(Long.valueOf(this.f53757e));
                a.this.o(this.f53757e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            a.this.h();
        }
    }

    public a() {
        this.f53749a = null;
        this.f53750b = null;
        this.f53751c = null;
        this.f53752d = null;
        this.f53753e = null;
        this.f53754f = null;
        this.f53749a = new HandlerC1231a(Looper.getMainLooper());
        this.f53750b = new Handler(Looper.myLooper());
        this.f53751c = new ConcurrentHashMap<>();
        this.f53752d = new ConcurrentHashMap<>();
        this.f53753e = new ConcurrentHashMap<>();
        this.f53754f = new Vector<>();
        this.f53749a.sendEmptyMessage(10002);
    }

    public static a i() {
        if (f53748h == null) {
            synchronized (a.class) {
                if (f53748h == null) {
                    f53748h = new a();
                }
            }
        }
        return f53748h;
    }

    public final void g(long j, long j2, int i2, long j3) {
        GroupMsgData groupMsgData = this.f53751c.get(Long.valueOf(j2));
        if (groupMsgData == null) {
            return;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() != 0) {
            if (this.f53753e.containsKey(Long.valueOf(j2))) {
                return;
            }
            p(j, j2, i2, j3);
            return;
        }
        q(j2);
    }

    public void h() {
        Handler handler = this.f53749a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.f53750b;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        ConcurrentHashMap<Long, Runnable> concurrentHashMap = this.f53753e;
        if (concurrentHashMap != null) {
            for (Map.Entry<Long, Runnable> entry : concurrentHashMap.entrySet()) {
                q(entry.getKey().longValue());
            }
            this.f53753e.clear();
        }
        ConcurrentHashMap<Long, GroupMsgData> concurrentHashMap2 = this.f53751c;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        Vector<Long> vector = this.f53754f;
        if (vector != null) {
            vector.clear();
        }
    }

    public NewpushGroupRepair j(long j) {
        if (this.f53752d.containsKey(Long.valueOf(j))) {
            return this.f53752d.remove(Long.valueOf(j));
        }
        return null;
    }

    public final List<ChatMessage> k(long j) {
        GroupMsgData groupMsgData = this.f53751c.get(Long.valueOf(j));
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

    public final boolean l(ChatMessage chatMessage, GroupMsgData groupMsgData) {
        LinkedList<ChatMessage> listMessage;
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

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        long j;
        long j2;
        if (groupMsgData == null || groupMsgData.getGroupInfo() == null || (listMessage = groupMsgData.getListMessage()) == null || listMessage.size() == 0) {
            return;
        }
        long groupId = groupMsgData.getGroupInfo().getGroupId();
        ImMessageCenterPojo g2 = j.f().g(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
        if (!(g2 != null)) {
            if (this.f53754f.contains(Long.valueOf(groupId))) {
                return;
            }
            n(groupMsgData, listMessage, groupId);
            return;
        }
        long sid = g2.getSid();
        long c2 = d.a.j0.e1.w.b.c(g2.getPulled_msgId());
        GroupMsgData groupMsgData2 = this.f53751c.get(Long.valueOf(groupId));
        if (groupMsgData2 == null) {
            groupMsgData2 = new GroupMsgData(groupMsgData.getCmd());
            this.f53751c.put(Long.valueOf(groupId), groupMsgData2);
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
                    this.f53754f.remove(Long.valueOf(groupId));
                }
                if (this.f53754f.contains(Long.valueOf(groupId))) {
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
        if (this.f53754f.contains(Long.valueOf(groupId))) {
        }
    }

    public final void n(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData == null || linkedList == null || linkedList.size() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        bundle.putLong("lastMid", linkedList.get(0).getMsgId());
        if (linkedList.get(0).getSid() > 0) {
            this.f53752d.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
        }
        bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
        Message message = new Message();
        message.what = 10001;
        message.setData(bundle);
        this.f53749a.sendMessage(message);
        linkedList.clear();
        this.f53754f.add(Long.valueOf(j));
        o(j);
    }

    public final void o(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        message.setData(bundle);
        this.f53749a.sendMessageDelayed(message, 3000L);
    }

    public final void p(long j, long j2, int i2, long j3) {
        b bVar = new b(j2, j, i2, j3);
        this.f53750b.postDelayed(bVar, d.a.j0.e1.o.b.a().b().b());
        this.f53753e.put(Long.valueOf(j2), bVar);
    }

    public final void q(long j) {
        Runnable remove = this.f53753e.remove(Long.valueOf(j));
        if (remove != null) {
            this.f53750b.removeCallbacks(remove);
        }
    }
}
