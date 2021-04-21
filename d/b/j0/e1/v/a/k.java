package d.b.j0.e1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.chat.officialBar.RequestLocalHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseLocalHistoryMessage;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes4.dex */
public class k implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage != null && (customMessage instanceof RequestLocalHistoryMessage)) {
            d.b.c.e.d.l<byte[]> d2 = d.b.i0.r.r.a.f().d("tb.im_official_history");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            byte[] bArr = d2.get(currentAccount + "@" + ((RequestLocalHistoryMessage) customMessage).getData());
            if (bArr == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            try {
                QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHistoryMsgResIdl.class);
                if (queryHistoryMsgResIdl.data.res != null) {
                    for (MsgInfo msgInfo : queryHistoryMsgResIdl.data.res) {
                        ResponseHistoryMessage.a aVar = new ResponseHistoryMessage.a();
                        if (msgInfo != null) {
                            Date date = new Date();
                            date.setTime(msgInfo.sendTime.longValue() * 1000);
                            aVar.f17567a = d.b.c.e.p.k.getDateStringMouth(date);
                            aVar.f17568b = msgInfo.type.intValue();
                            aVar.f17569c = msgInfo.content;
                            aVar.f17570d = msgInfo.id.intValue();
                            linkedList.add(aVar);
                        }
                    }
                }
                return new ResponseLocalHistoryMessage(linkedList);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
