package d.a.k0.e1.f.l;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.k0.e1.f.l.a;
import d.a.k0.e1.h.j;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {

    /* loaded from: classes4.dex */
    public static class a implements a.c {
        @Override // d.a.k0.e1.f.l.a.c
        public boolean a(String str) {
            return true;
        }
    }

    public static GroupNewsPojo a(ChatMessage chatMessage) {
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        try {
            if (content.startsWith("[")) {
                return null;
            }
            String optString = new JSONObject(content).optString(TbEnum.SystemMessage.KEY_EVENT_ID);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            GroupNewsPojo groupNewsPojo = new GroupNewsPojo(chatMessage, optString);
            groupNewsPojo.setOriginalPushMsg(chatMessage);
            return groupNewsPojo;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static LinkedList<GroupNewsPojo> b(LinkedList<ChatMessage> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
        Iterator<ChatMessage> it = linkedList.iterator();
        while (it.hasNext()) {
            GroupNewsPojo a2 = a(it.next());
            if (a2 != null) {
                linkedList2.add(a2);
            }
        }
        return linkedList2;
    }

    public static String c(String str, String str2) {
        String optString;
        String optString2;
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString3 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG);
            JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (!str.equals("apply_join_group")) {
                return "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str) ? optString3 : "";
            }
            if (true != jSONObject.isNull("notice_id")) {
                optString = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                String optString4 = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                str3 = optString4;
            } else if (optJSONObject != null) {
                optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                str3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                optString2 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
            } else {
                optString = "";
                optString2 = optString;
                str3 = optString2;
            }
            ImMessageCenterPojo i2 = d.a.k0.e1.k.b.o().i(optString, 1);
            if (i2 != null) {
                optString2 = i2.getGroup_name();
            }
            if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(str3)) {
                return "";
            }
            return str3 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + optString2;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return "";
        }
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str);
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && str.equals("apply_join_group");
    }

    public static void f(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        d.a.k0.e1.f.l.a.c(groupMsgData, imMessageCenterPojo, bVar, new a(), false);
    }

    public static void g(GroupMsgData groupMsgData) {
        LinkedList<GroupNewsPojo> b2 = b(groupMsgData.getListMessage());
        if (b2 == null || b2.isEmpty()) {
            return;
        }
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        Iterator<GroupNewsPojo> it = b2.iterator();
        GroupNewsPojo groupNewsPojo = null;
        GroupNewsPojo groupNewsPojo2 = null;
        long j = 0;
        while (it.hasNext()) {
            GroupNewsPojo next = it.next();
            if (!TextUtils.isEmpty(next.getNotice_id())) {
                long parseLong = Long.parseLong(next.getNotice_id());
                if (parseLong > j) {
                    j = parseLong;
                }
                if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().a(next)) {
                    if (d(next.getCmd())) {
                        linkedList.add(next);
                        if (groupNewsPojo == null || parseLong > Long.parseLong(groupNewsPojo.getNotice_id())) {
                            groupNewsPojo = next;
                        }
                    } else if (e(next.getCmd())) {
                        linkedList.add(next);
                        if (groupNewsPojo2 == null || parseLong > Long.parseLong(groupNewsPojo2.getNotice_id())) {
                            groupNewsPojo2 = next;
                        }
                    }
                }
            }
        }
        d.a.k0.e1.h.d.f().n(linkedList);
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
        imMessageCenterPojo.setIs_hidden(1);
        imMessageCenterPojo.setCustomGroupType(-2);
        imMessageCenterPojo.setPulled_msgId(j);
        j.f().j(imMessageCenterPojo);
        if (groupNewsPojo != null) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.GROUP_UPDATE);
            imMessageCenterPojo2.setCustomGroupType(-3);
            imMessageCenterPojo2.setUnread_count(1);
            imMessageCenterPojo2.setLast_rid(d.a.c.e.m.b.f(groupNewsPojo.getNotice_id(), 0L));
            imMessageCenterPojo2.setLast_content_time(groupNewsPojo.getTime());
            imMessageCenterPojo2.setLast_content(groupNewsPojo.getContent());
            imMessageCenterPojo2.setIs_hidden(0);
            j.f().k(imMessageCenterPojo2, 2);
        }
        if (groupNewsPojo2 != null) {
            ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
            imMessageCenterPojo3.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
            imMessageCenterPojo3.setCustomGroupType(-4);
            imMessageCenterPojo3.setUnread_count(1);
            imMessageCenterPojo3.setLast_rid(d.a.c.e.m.b.f(groupNewsPojo2.getNotice_id(), 0L));
            imMessageCenterPojo3.setLast_content_time(groupNewsPojo2.getTime());
            imMessageCenterPojo3.setLast_content(groupNewsPojo2.getContent());
            imMessageCenterPojo3.setIs_hidden(0);
            j.f().k(imMessageCenterPojo3, 2);
        }
        Iterator<GroupNewsPojo> it2 = b2.iterator();
        while (it2.hasNext()) {
            GroupNewsPojo next2 = it2.next();
            if (next2 != null && (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().a(next2))) {
                PushMessage newInstance = PushMessage.newInstance(next2);
                if (newInstance != null) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(newInstance);
                }
            }
        }
    }
}
