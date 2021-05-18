package d.a.k0.e1.f.l;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.j0.r.q.x0;
import d.a.k0.e1.f.l.a;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f54261a;

    /* loaded from: classes4.dex */
    public static class a implements a.c {
        @Override // d.a.k0.e1.f.l.a.c
        public boolean a(String str) {
            return true;
        }
    }

    public static synchronized g b() {
        g gVar;
        synchronized (g.class) {
            if (f54261a == null) {
                f54261a = new g();
            }
            gVar = f54261a;
        }
        return gVar;
    }

    public static void d(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        d.a.k0.e1.f.l.a.c(groupMsgData, imMessageCenterPojo, bVar, new a(), false);
    }

    public long[] a(GroupMsgData groupMsgData) {
        if (groupMsgData == null || groupMsgData.getGroupInfo() == null) {
            return null;
        }
        long j = 0;
        long groupId = groupMsgData.getGroupInfo().getGroupId();
        Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
        while (it.hasNext()) {
            ChatMessage next = it.next();
            if (next.getMsgId() > j) {
                j = next.getMsgId();
            }
        }
        return new long[]{groupId, j};
    }

    public long c(long j) {
        TbadkSettings inst = TbadkSettings.getInst();
        return inst.loadLong("tb_group_msg_" + j, -1L);
    }

    public void e(GroupMsgData groupMsgData) {
        if (groupMsgData == null || groupMsgData.getGroupInfo() == null) {
            return;
        }
        Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
        while (it.hasNext()) {
            ChatMessage next = it.next();
            if (!TextUtils.isEmpty(next.getStat())) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "push_noti:" + next.getStat(), "taskId:" + next.getTaskId() + ";link:" + next.getLink() + ";uid:" + TbadkCoreApplication.getCurrentAccount());
            }
            if (!TextUtils.isEmpty(next.getLink()) && !TextUtils.isEmpty(next.getStat())) {
                TiebaStatic.pushMsg(next.getMsgId(), 1, next.getLink(), next.getStat());
            }
            CustomMessage customMessage = new CustomMessage(2012100);
            customMessage.setData(new x0(next.getMsgId(), next.getTaskId(), next.getLink(), next.getContent(), next.getStat(), next.getServiceId()));
            MessageManager.getInstance().sendMessage(customMessage);
        }
        if (groupMsgData.getListMessage().size() > 0) {
            TiebaStatic.saveAndUploadMsg();
        }
    }

    public void f(String str, long j) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        inst.saveLong("tb_group_msg_" + str, j);
    }
}
