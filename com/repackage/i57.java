package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d57;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements d57.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.d57.c
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public static GroupNewsPojo a(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatMessage)) == null) {
            String content = chatMessage.getContent();
            if (TextUtils.isEmpty(content)) {
                return null;
            }
            try {
                if (content.startsWith(PreferencesUtil.LEFT_MOUNT)) {
                    return null;
                }
                String optString = new JSONObject(content).optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                GroupNewsPojo groupNewsPojo = new GroupNewsPojo(chatMessage, optString);
                groupNewsPojo.setOriginalPushMsg(chatMessage);
                return groupNewsPojo;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (GroupNewsPojo) invokeL.objValue;
    }

    public static LinkedList<GroupNewsPojo> b(LinkedList<ChatMessage> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, linkedList)) == null) {
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
        return (LinkedList) invokeL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        String optString;
        String optString2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
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
                ImMessageCenterPojo i = s67.o().i(optString, 1);
                if (i != null) {
                    optString2 = i.getGroup_name();
                }
                if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(str3)) {
                    return "";
                }
                return str3 + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f14ab) + optString2;
            } catch (Exception e) {
                BdLog.detailException(e);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? !TextUtils.isEmpty(str) && "group_intro_change' , 'group_level_up' , 'group_name_change' , 'group_notice_change' , 'dismiss_group' , 'kick_out' , 'group_event_info' , 'group_activitys_change".contains(str) : invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? !TextUtils.isEmpty(str) && str.equals("apply_join_group") : invokeL.booleanValue;
    }

    public static void f(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, d57.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, groupMsgData, imMessageCenterPojo, bVar) == null) {
            d57.d(groupMsgData, imMessageCenterPojo, bVar, new a(), false);
        }
    }

    public static void g(GroupMsgData groupMsgData) {
        LinkedList<GroupNewsPojo> b;
        PushMessage newInstance;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, groupMsgData) == null) || (b = b(groupMsgData.getListMessage())) == null || b.isEmpty()) {
            return;
        }
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        Iterator<GroupNewsPojo> it = b.iterator();
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
                if (d(next.getCmd())) {
                    linkedList.add(next);
                    if (groupNewsPojo2 == null || parseLong > Long.parseLong(groupNewsPojo2.getNotice_id())) {
                        groupNewsPojo2 = next;
                    }
                } else if (e(next.getCmd())) {
                    linkedList.add(next);
                    if (groupNewsPojo == null || parseLong > Long.parseLong(groupNewsPojo.getNotice_id())) {
                        groupNewsPojo = next;
                    }
                }
            }
        }
        v57.f().m(linkedList);
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
        imMessageCenterPojo.setIs_hidden(1);
        imMessageCenterPojo.setCustomGroupType(-2);
        imMessageCenterPojo.setPulled_msgId(j);
        b67.f().k(imMessageCenterPojo);
        if (groupNewsPojo != null) {
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
            imMessageCenterPojo2.setCustomGroupType(-4);
            imMessageCenterPojo2.setUnread_count(1);
            imMessageCenterPojo2.setLast_rid(ng.g(groupNewsPojo.getNotice_id(), 0L));
            imMessageCenterPojo2.setLast_content_time(groupNewsPojo.getTime());
            imMessageCenterPojo2.setLast_content(groupNewsPojo.getContent());
            imMessageCenterPojo2.setIs_hidden(0);
            b67.f().l(imMessageCenterPojo2, 2);
        }
        Iterator<GroupNewsPojo> it2 = b.iterator();
        while (it2.hasNext()) {
            GroupNewsPojo next2 = it2.next();
            if (next2 != null && (newInstance = PushMessage.newInstance(next2)) != null) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(newInstance);
            }
        }
    }
}
