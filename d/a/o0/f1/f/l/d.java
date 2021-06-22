package d.a.o0.f1.f.l;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import d.a.o0.f1.f.l.a;
/* loaded from: classes4.dex */
public class d {

    /* loaded from: classes4.dex */
    public static class a implements a.c {
        @Override // d.a.o0.f1.f.l.a.c
        public boolean a(String str) {
            return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(1) && str.equals(ChatStatusManager.getInst().getCurId(1));
        }
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        d.a.o0.f1.f.l.a.c(groupMsgData, imMessageCenterPojo, bVar, new a(), ChatStatusManager.getInst().getIsOpen(4));
    }
}
