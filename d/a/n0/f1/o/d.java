package d.a.n0.f1.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import com.baidu.tieba.im.push.PushResponseMessage;
import d.a.c.c.f.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends j {
    public d() {
        super(202009);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.f.g
    /* renamed from: c */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof PushResponseMessage) {
            if (socketResponsedMessage.getError() == 110000) {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
            }
            PushResponseMessage pushResponseMessage = (PushResponseMessage) socketResponsedMessage;
            if (pushResponseMessage.getNotificationData() != null && TbadkCoreApplication.getInst().isInBackground()) {
                CustomMessage customMessage = new CustomMessage(2012100);
                customMessage.setData(pushResponseMessage.getNotificationData());
                MessageManager.getInstance().sendMessage(customMessage);
                return null;
            }
            List<GroupMsgData> groupMsg = pushResponseMessage.getGroupMsg();
            if (groupMsg != null && groupMsg.size() > 0) {
                for (GroupMsgData groupMsgData : groupMsg) {
                    if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(groupMsgData);
                    }
                }
            }
            return socketResponsedMessage;
        }
        return null;
    }
}
