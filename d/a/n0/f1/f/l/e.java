package d.a.n0.f1.f.l;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.n0.f1.f.l.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* loaded from: classes4.dex */
    public static class a implements a.c {
        @Override // d.a.n0.f1.f.l.a.c
        public boolean a(String str) {
            return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(0) && str.equals(ChatStatusManager.getInst().getCurId(0));
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements a.InterfaceC1311a {
        @Override // d.a.n0.f1.f.l.a.InterfaceC1311a
        public boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo) {
            if (chatMessage == null || chatMessage.getMsgType() != 22) {
                return false;
            }
            if (d.a.n0.f1.w.c.p(chatMessage)) {
                return true;
            }
            long a2 = e.a(chatMessage);
            if (a2 > imMessageCenterPojo.getRead_msgId()) {
                imMessageCenterPojo.setRead_msgId(a2);
            }
            return true;
        }
    }

    public static long a(ChatMessage chatMessage) {
        JSONObject optJSONObject;
        if (chatMessage != null) {
            if (chatMessage.getMsgType() == 22) {
                try {
                    String content = chatMessage.getContent();
                    if (TextUtils.isEmpty(content)) {
                        return -1L;
                    }
                    JSONObject jSONObject = new JSONObject(content);
                    String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    if (TextUtils.isEmpty(optString) || !optString.equals("22001") || (optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM)) == null || optJSONObject.optLong(TbEnum.SystemMessage.KEY_GROUP_ID) != d.a.n0.f1.s.a.f54696i.longValue()) {
                        return -1L;
                    }
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return d.a.n0.f1.w.b.a(optJSONObject.optLong("readMsgId"));
        }
        return -1L;
    }

    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        d.a.n0.f1.f.l.a.d(groupMsgData, imMessageCenterPojo, bVar, new a(), ChatStatusManager.getInst().getIsOpen(5), new b());
    }
}
