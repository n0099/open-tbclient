package d.b.i0.e1.o;

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
import d.b.i0.e1.h.j;
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
    public static a f55463h;

    /* renamed from: a  reason: collision with root package name */
    public Handler f55464a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f55465b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, GroupMsgData> f55466c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<Long, NewpushGroupRepair> f55467d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f55468e;

    /* renamed from: f  reason: collision with root package name */
    public Vector<Long> f55469f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f55470g = new c(2005016);

    /* renamed from: d.b.i0.e1.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1269a extends Handler {
        public HandlerC1269a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 10001:
                    MessageUtils.updateGroupNotExist(message.getData());
                    return;
                case 10002:
                    MessageManager.getInstance().registerListener(a.this.f55470g);
                    return;
                case 10003:
                    if (message.getData() == null || !message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                        return;
                    }
                    a.this.f55469f.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f55472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f55473f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55474g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f55475h;

        public b(long j, long j2, int i, long j3) {
            this.f55472e = j;
            this.f55473f = j2;
            this.f55474g = i;
            this.f55475h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupMsgData groupMsgData = (GroupMsgData) a.this.f55466c.get(Long.valueOf(this.f55472e));
            if (groupMsgData == null) {
                a.this.q(this.f55472e);
                return;
            }
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            long j = -1;
            if (listMessage != null && listMessage.size() > 0) {
                for (int i = 0; i < listMessage.size(); i++) {
                    if (j < listMessage.get(i).getSid()) {
                        j = listMessage.get(i).getSid();
                    }
                }
                listMessage.clear();
            }
            long j2 = j;
            a.this.q(this.f55472e);
            if (j2 > this.f55473f) {
                a.this.f55467d.put(Long.valueOf(this.f55472e), MessageUtils.makeNewpushGroupRepair(this.f55472e, this.f55474g, this.f55473f, j2, this.f55475h));
                d.b.i0.e1.m.b.l().s(this.f55472e, 1L, 0L, true);
                a.this.f55469f.add(Long.valueOf(this.f55472e));
                a.this.o(this.f55472e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
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
        this.f55464a = null;
        this.f55465b = null;
        this.f55466c = null;
        this.f55467d = null;
        this.f55468e = null;
        this.f55469f = null;
        this.f55464a = new HandlerC1269a(Looper.getMainLooper());
        this.f55465b = new Handler(Looper.myLooper());
        this.f55466c = new ConcurrentHashMap<>();
        this.f55467d = new ConcurrentHashMap<>();
        this.f55468e = new ConcurrentHashMap<>();
        this.f55469f = new Vector<>();
        this.f55464a.sendEmptyMessage(10002);
    }

    public static a i() {
        if (f55463h == null) {
            synchronized (a.class) {
                if (f55463h == null) {
                    f55463h = new a();
                }
            }
        }
        return f55463h;
    }

    public final void g(long j, long j2, int i, long j3) {
        GroupMsgData groupMsgData = this.f55466c.get(Long.valueOf(j2));
        if (groupMsgData == null) {
            return;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() != 0) {
            if (this.f55468e.containsKey(Long.valueOf(j2))) {
                return;
            }
            p(j, j2, i, j3);
            return;
        }
        q(j2);
    }

    public void h() {
        Handler handler = this.f55464a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.f55465b;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        ConcurrentHashMap<Long, Runnable> concurrentHashMap = this.f55468e;
        if (concurrentHashMap != null) {
            for (Map.Entry<Long, Runnable> entry : concurrentHashMap.entrySet()) {
                q(entry.getKey().longValue());
            }
            this.f55468e.clear();
        }
        ConcurrentHashMap<Long, GroupMsgData> concurrentHashMap2 = this.f55466c;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        Vector<Long> vector = this.f55469f;
        if (vector != null) {
            vector.clear();
        }
    }

    public NewpushGroupRepair j(long j) {
        if (this.f55467d.containsKey(Long.valueOf(j))) {
            return this.f55467d.remove(Long.valueOf(j));
        }
        return null;
    }

    public final List<ChatMessage> k(long j) {
        GroupMsgData groupMsgData = this.f55466c.get(Long.valueOf(j));
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
        int i = 0;
        if (chatMessage == null || groupMsgData == null || (listMessage = groupMsgData.getListMessage()) == null) {
            return false;
        }
        if (listMessage.contains(chatMessage)) {
            return true;
        }
        int size = listMessage.size();
        while (i < size) {
            ChatMessage chatMessage2 = listMessage.get(i);
            if (chatMessage2 != null) {
                if (chatMessage.getSid() == chatMessage2.getSid()) {
                    return true;
                }
                if (chatMessage.getSid() < chatMessage2.getSid()) {
                    break;
                }
            }
            i++;
        }
        listMessage.add(i, chatMessage);
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
            if (this.f55469f.contains(Long.valueOf(groupId))) {
                return;
            }
            n(groupMsgData, listMessage, groupId);
            return;
        }
        long sid = g2.getSid();
        long c2 = d.b.i0.e1.w.b.c(g2.getPulled_msgId());
        GroupMsgData groupMsgData2 = this.f55466c.get(Long.valueOf(groupId));
        if (groupMsgData2 == null) {
            groupMsgData2 = new GroupMsgData(groupMsgData.getCmd());
            this.f55466c.put(Long.valueOf(groupId), groupMsgData2);
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
                    this.f55469f.remove(Long.valueOf(groupId));
                }
                if (this.f55469f.contains(Long.valueOf(groupId))) {
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
        if (this.f55469f.contains(Long.valueOf(groupId))) {
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
            this.f55467d.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
        }
        bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
        Message message = new Message();
        message.what = 10001;
        message.setData(bundle);
        this.f55464a.sendMessage(message);
        linkedList.clear();
        this.f55469f.add(Long.valueOf(j));
        o(j);
    }

    public final void o(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        message.setData(bundle);
        this.f55464a.sendMessageDelayed(message, 3000L);
    }

    public final void p(long j, long j2, int i, long j3) {
        b bVar = new b(j2, j, i, j3);
        this.f55465b.postDelayed(bVar, d.b.i0.e1.o.b.a().b().b());
        this.f55468e.put(Long.valueOf(j2), bVar);
    }

    public final void q(long j) {
        Runnable remove = this.f55468e.remove(Long.valueOf(j));
        if (remove != null) {
            this.f55465b.removeCallbacks(remove);
        }
    }
}
