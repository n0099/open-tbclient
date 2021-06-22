package d.a.o0.f1.o;

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
import d.a.o0.f1.h.j;
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
    public static a f58459h;

    /* renamed from: a  reason: collision with root package name */
    public Handler f58460a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f58461b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, GroupMsgData> f58462c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Long, NewpushGroupRepair> f58463d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f58464e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<Long> f58465f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f58466g = new c(2005016);

    /* renamed from: d.a.o0.f1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1381a extends Handler {
        public HandlerC1381a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 10001:
                    MessageUtils.updateGroupNotExist(message.getData());
                    return;
                case 10002:
                    MessageManager.getInstance().registerListener(a.this.f58466g);
                    return;
                case 10003:
                    if (message.getData() == null || !message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                        return;
                    }
                    a.this.f58465f.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f58468e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f58469f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f58470g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f58471h;

        public b(long j, long j2, int i2, long j3) {
            this.f58468e = j;
            this.f58469f = j2;
            this.f58470g = i2;
            this.f58471h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupMsgData groupMsgData = (GroupMsgData) a.this.f58462c.get(Long.valueOf(this.f58468e));
            if (groupMsgData == null) {
                a.this.q(this.f58468e);
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
            a.this.q(this.f58468e);
            if (j2 > this.f58469f) {
                a.this.f58463d.put(Long.valueOf(this.f58468e), MessageUtils.makeNewpushGroupRepair(this.f58468e, this.f58470g, this.f58469f, j2, this.f58471h));
                d.a.o0.f1.m.b.l().s(this.f58468e, 1L, 0L, true);
                a.this.f58465f.add(Long.valueOf(this.f58468e));
                a.this.o(this.f58468e);
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
        this.f58460a = null;
        this.f58461b = null;
        this.f58462c = null;
        this.f58463d = null;
        this.f58464e = null;
        this.f58465f = null;
        this.f58460a = new HandlerC1381a(Looper.getMainLooper());
        this.f58461b = new Handler(Looper.myLooper());
        this.f58462c = new ConcurrentHashMap<>();
        this.f58463d = new ConcurrentHashMap<>();
        this.f58464e = new ConcurrentHashMap<>();
        this.f58465f = new Vector<>();
        this.f58460a.sendEmptyMessage(10002);
    }

    public static a i() {
        if (f58459h == null) {
            synchronized (a.class) {
                if (f58459h == null) {
                    f58459h = new a();
                }
            }
        }
        return f58459h;
    }

    public final void g(long j, long j2, int i2, long j3) {
        GroupMsgData groupMsgData = this.f58462c.get(Long.valueOf(j2));
        if (groupMsgData == null) {
            return;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() != 0) {
            if (this.f58464e.containsKey(Long.valueOf(j2))) {
                return;
            }
            p(j, j2, i2, j3);
            return;
        }
        q(j2);
    }

    public void h() {
        Handler handler = this.f58460a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.f58461b;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        ConcurrentHashMap<Long, Runnable> concurrentHashMap = this.f58464e;
        if (concurrentHashMap != null) {
            for (Map.Entry<Long, Runnable> entry : concurrentHashMap.entrySet()) {
                q(entry.getKey().longValue());
            }
            this.f58464e.clear();
        }
        ConcurrentHashMap<Long, GroupMsgData> concurrentHashMap2 = this.f58462c;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        Vector<Long> vector = this.f58465f;
        if (vector != null) {
            vector.clear();
        }
    }

    public NewpushGroupRepair j(long j) {
        if (this.f58463d.containsKey(Long.valueOf(j))) {
            return this.f58463d.remove(Long.valueOf(j));
        }
        return null;
    }

    public final List<ChatMessage> k(long j) {
        GroupMsgData groupMsgData = this.f58462c.get(Long.valueOf(j));
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
            if (this.f58465f.contains(Long.valueOf(groupId))) {
                return;
            }
            n(groupMsgData, listMessage, groupId);
            return;
        }
        long sid = g2.getSid();
        long c2 = d.a.o0.f1.w.b.c(g2.getPulled_msgId());
        GroupMsgData groupMsgData2 = this.f58462c.get(Long.valueOf(groupId));
        if (groupMsgData2 == null) {
            groupMsgData2 = new GroupMsgData(groupMsgData.getCmd());
            this.f58462c.put(Long.valueOf(groupId), groupMsgData2);
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
                    this.f58465f.remove(Long.valueOf(groupId));
                }
                if (this.f58465f.contains(Long.valueOf(groupId))) {
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
        if (this.f58465f.contains(Long.valueOf(groupId))) {
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
            this.f58463d.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
        }
        bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
        Message message = new Message();
        message.what = 10001;
        message.setData(bundle);
        this.f58460a.sendMessage(message);
        linkedList.clear();
        this.f58465f.add(Long.valueOf(j));
        o(j);
    }

    public final void o(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        message.setData(bundle);
        this.f58460a.sendMessageDelayed(message, 3000L);
    }

    public final void p(long j, long j2, int i2, long j3) {
        b bVar = new b(j2, j, i2, j3);
        this.f58461b.postDelayed(bVar, d.a.o0.f1.o.b.a().b().b());
        this.f58464e.put(Long.valueOf(j2), bVar);
    }

    public final void q(long j) {
        Runnable remove = this.f58464e.remove(Long.valueOf(j));
        if (remove != null) {
            this.f58461b.removeCallbacks(remove);
        }
    }
}
