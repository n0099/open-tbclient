package d.b.i0.d1.m;

import androidx.collection.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.MessageSyncMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import d.b.b.c.f.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends j {
    public d() {
        super(202003);
    }

    public final void c(GroupMsgData groupMsgData) {
        if (groupMsgData == null || groupMsgData.getGroupInfo() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(groupMsgData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.c.f.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        MessageSyncMessage messageSyncMessage = null;
        if (socketResponsedMessage instanceof ResponsePullMessage) {
            if (socketResponsedMessage.getOrginalMessage() != null && (socketResponsedMessage.getOrginalMessage() instanceof MessageSyncMessage)) {
                messageSyncMessage = (MessageSyncMessage) socketResponsedMessage.getOrginalMessage();
            }
            if (messageSyncMessage != null) {
                d.b.h0.r.z.a.a("im", messageSyncMessage.getClientLogID(), messageSyncMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
            }
            if (socketResponsedMessage.getError() == 110000) {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
            }
            ResponsePullMessage responsePullMessage = (ResponsePullMessage) socketResponsedMessage;
            List<GroupMsgData> groupMsg = responsePullMessage.getGroupMsg();
            if (groupMsg != null && groupMsg.size() > 0) {
                for (GroupMsgData groupMsgData : groupMsg) {
                    if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
                        c(groupMsgData);
                    }
                }
            }
            if (!e(responsePullMessage)) {
                b.l().n();
            }
            return socketResponsedMessage;
        }
        return null;
    }

    public final boolean e(ResponsePullMessage responsePullMessage) {
        Long l;
        Long l2;
        if (responsePullMessage != null && responsePullMessage.getGroupMsg() != null && responsePullMessage.getGroupMsg().size() != 0 && !responsePullMessage.hasError()) {
            List<GroupMsgData> groupMsg = responsePullMessage.getGroupMsg();
            if (!(responsePullMessage.getOrginalMessage() instanceof MessageSyncMessage)) {
                return false;
            }
            MessageSyncMessage messageSyncMessage = (MessageSyncMessage) responsePullMessage.getOrginalMessage();
            if (messageSyncMessage.getGroupMids() != null && messageSyncMessage.getGroupMids().size() != 0) {
                LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
                LongSparseArray<Long> r = d.b.i0.d1.k.b.o().r();
                boolean z = false;
                for (GroupMsgData groupMsgData : groupMsg) {
                    if (groupMsgData != null && groupMsgData.getGroupInfo() != null && d.b.i0.d1.k.c.a(groupMsgData.getGroupInfo().getCustomType()) && (l = r.get(groupMsgData.getGroupInfo().getGroupId())) != null && (l2 = messageSyncMessage.getGroupMids().get(groupMsgData.getGroupInfo().getGroupId())) != null) {
                        if (l.longValue() > l2.longValue()) {
                            z = true;
                        }
                        if (groupMsgData.hasMore()) {
                            longSparseArray.put(groupMsgData.getGroupInfo().getGroupId(), l);
                        }
                    }
                }
                if (z && longSparseArray.size() > 0) {
                    b.l().q(longSparseArray);
                    return true;
                }
            }
        }
        return false;
    }
}
