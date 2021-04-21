package d.b.j0.e1.m;

import androidx.collection.LongSparseArray;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tieba.im.message.MessageSyncMessage;
import d.b.c.c.f.k;
/* loaded from: classes4.dex */
public class c extends k {
    public c() {
        super(202003);
    }

    public SocketMessage a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        StringBuilder sb = new StringBuilder(200);
        if (socketMessage instanceof MessageSyncMessage) {
            MessageSyncMessage messageSyncMessage = (MessageSyncMessage) socketMessage;
            LongSparseArray<Long> groupMids = messageSyncMessage.getGroupMids();
            for (int i = 0; i < groupMids.size(); i++) {
                sb.append(groupMids.keyAt(i));
                sb.append("-");
                sb.append(groupMids.valueAt(i));
                sb.append(FieldBuilder.SE);
            }
            d.b.i0.r.z.a.a("im", socketMessage.getClientLogID(), 202003, "sendMsg", 0, null, "reason", "pull" + messageSyncMessage.getSyncTypeString(), "comment", sb.toString());
        }
        return socketMessage;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // d.b.c.c.f.f
    public /* bridge */ /* synthetic */ SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        SocketMessage socketMessage2 = socketMessage;
        a(socketMessage2, socketMessageTask);
        return socketMessage2;
    }
}
