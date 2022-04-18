package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class s57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(String str, List<CommonMsgPojo> list);

        void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z);
    }

    /* loaded from: classes7.dex */
    public interface c {
        boolean a(String str);
    }

    public static boolean a(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, chatMessage, i)) == null) {
            if (chatMessage.getMsgType() == 11) {
                SystemMsgData l = a97.l(chatMessage);
                return (l == null || l.getIsSelf()) ? false : true;
            } else if (i == 4) {
                return a97.o(chatMessage);
            } else {
                return (chatMessage.getUserInfo() == null || chatMessage.getUserInfo().getUserId() == null || !chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            }
        }
        return invokeLI.booleanValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("agree");
            int optInt2 = jSONObject.optInt("replyme");
            jSONObject.optInt(FeedData.TYPE_ZAN);
            int optInt3 = jSONObject.optInt("fans");
            int optInt4 = jSONObject.optInt("gift");
            int optInt5 = jSONObject.optInt("godfeed");
            int optInt6 = jSONObject.optInt("atme");
            if (jSONObject.optInt(ExternalTransferSpeedStats.FEED_PAGE) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2012118));
            }
            if (optInt5 > 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016324, Integer.valueOf(optInt5)));
            }
            if (optInt >= 0 && optInt2 >= 0 && optInt3 >= 0 && optInt6 >= 0 && optInt4 >= 0) {
                int i = yx4.d().e() > 0 ? optInt4 : 0;
                if (currentAccount == null || currentAccount.length() <= 0) {
                    return;
                }
                int x = wx4.g0().x();
                int w = wx4.g0().w();
                wx4.g0().j0(jSONObject);
                wx4.g0().U(optInt, optInt2, optInt6, x, optInt3, w, i);
            }
        } catch (Exception unused) {
        }
    }

    public static void c(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{groupMsgData, imMessageCenterPojo, bVar, cVar, Boolean.valueOf(z)}) == null) {
            d(groupMsgData, imMessageCenterPojo, bVar, cVar, z, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z, a aVar) {
        ImMessageCenterPojo imMessageCenterPojo2;
        boolean z2;
        String str;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{groupMsgData, imMessageCenterPojo, bVar, cVar, Boolean.valueOf(z), aVar}) == null) {
            a aVar2 = aVar;
            String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
            int customType = groupMsgData.getGroupInfo().getCustomType();
            int userType = groupMsgData.getGroupInfo().getUserType();
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() <= 0) {
                return;
            }
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = null;
            if (imMessageCenterPojo == null) {
                imMessageCenterPojo2 = new ImMessageCenterPojo();
                imMessageCenterPojo2.setCustomGroupType(customType);
                imMessageCenterPojo2.setGid(valueOf);
            } else {
                imMessageCenterPojo2 = imMessageCenterPojo;
            }
            imMessageCenterPojo2.setUserType(userType);
            int unread_count = imMessageCenterPojo2.getUnread_count();
            long pulled_msgId = imMessageCenterPojo2.getPulled_msgId();
            long last_rid = imMessageCenterPojo2.getLast_rid();
            for (ChatMessage chatMessage : listMessage) {
                if (pulled_msgId < chatMessage.getMsgId()) {
                    pulled_msgId = chatMessage.getMsgId();
                }
                if (aVar2 == null || !aVar2.a(chatMessage, imMessageCenterPojo2)) {
                    chatMessage.setLocalData(new MsgLocalData());
                    chatMessage.getLocalData().setStatus((short) 3);
                    CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
                    commonMsgPojo2.setCustomGroupType(customType);
                    if (a(chatMessage, customType)) {
                        commonMsgPojo2.setRead_flag(0);
                    } else {
                        if (commonMsgPojo2.getRid() > last_rid) {
                            unread_count++;
                        }
                        commonMsgPojo2.setRead_flag(1);
                    }
                    linkedList.add(commonMsgPojo2);
                    if (commonMsgPojo == null || commonMsgPojo.getRid() < commonMsgPojo2.getRid()) {
                        commonMsgPojo = commonMsgPojo2;
                    }
                    aVar2 = aVar;
                }
            }
            if (commonMsgPojo != null) {
                commonMsgPojo.checkRidAndSelf();
            }
            if (cVar != null && cVar.a(valueOf)) {
                unread_count = 0;
            }
            imMessageCenterPojo2.setUnread_count(unread_count);
            imMessageCenterPojo2.setPulled_msgId(pulled_msgId);
            if ((customType == 2 || customType == 4) && commonMsgPojo != null && commonMsgPojo.getPrivateOtherUser_infoObj() != null) {
                String portrait = commonMsgPojo.getPrivateOtherUser_infoObj().getPortrait();
                String userName = commonMsgPojo.getPrivateOtherUser_infoObj().getUserName();
                if (!TextUtils.isEmpty(portrait)) {
                    imMessageCenterPojo2.setGroup_head(portrait);
                }
                if (!TextUtils.isEmpty(userName)) {
                    imMessageCenterPojo2.setGroup_name(userName);
                }
                imMessageCenterPojo2.setNameShow(commonMsgPojo.getPrivateOtherUser_infoObj().getName_show());
                imMessageCenterPojo2.setBjhAvatar(commonMsgPojo.getPrivateOtherUser_infoObj().getImBjhAvatar());
            }
            if (commonMsgPojo == null || commonMsgPojo.getRid() < last_rid) {
                z2 = false;
            } else {
                z2 = commonMsgPojo.getRid() > last_rid;
                UserData user_infoObj = commonMsgPojo.getUser_infoObj();
                if (user_infoObj != null) {
                    str = user_infoObj.getName_show();
                    if (TbadkCoreApplication.isLogin()) {
                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                        if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(user_infoObj.getUserId()))) {
                            z3 = true;
                            String u = a97.u(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                            imMessageCenterPojo2.setLastContentRawData(commonMsgPojo.getContent());
                            imMessageCenterPojo2.setLast_rid(commonMsgPojo.getRid());
                            imMessageCenterPojo2.setSid(commonMsgPojo.getSid());
                            imMessageCenterPojo2.setLastTaskId(commonMsgPojo.getTaskId());
                            MessageUtils.makeNewTaskId(imMessageCenterPojo2, linkedList);
                            imMessageCenterPojo2.setLastServiceId(commonMsgPojo.getServiceId());
                            MessageUtils.makeNewServiceId(imMessageCenterPojo2, linkedList);
                            imMessageCenterPojo2.setLast_content(u);
                            imMessageCenterPojo2.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                            imMessageCenterPojo2.setLast_user_name(str);
                            imMessageCenterPojo2.setPushIds(commonMsgPojo.getPushIds());
                            if (imMessageCenterPojo2.getUnread_count() > 0 || z3 || z2) {
                                imMessageCenterPojo2.setIs_hidden(0);
                            }
                            imMessageCenterPojo2.setIsFriend(commonMsgPojo.getIsFriend());
                            imMessageCenterPojo2.setFollowStatus(commonMsgPojo.getFollowStatus());
                            imMessageCenterPojo2.setSend_status(3);
                            BdLog.i("send message status 3");
                        }
                    }
                } else {
                    str = "";
                }
                z3 = false;
                String u2 = a97.u(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                imMessageCenterPojo2.setLastContentRawData(commonMsgPojo.getContent());
                imMessageCenterPojo2.setLast_rid(commonMsgPojo.getRid());
                imMessageCenterPojo2.setSid(commonMsgPojo.getSid());
                imMessageCenterPojo2.setLastTaskId(commonMsgPojo.getTaskId());
                MessageUtils.makeNewTaskId(imMessageCenterPojo2, linkedList);
                imMessageCenterPojo2.setLastServiceId(commonMsgPojo.getServiceId());
                MessageUtils.makeNewServiceId(imMessageCenterPojo2, linkedList);
                imMessageCenterPojo2.setLast_content(u2);
                imMessageCenterPojo2.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                imMessageCenterPojo2.setLast_user_name(str);
                imMessageCenterPojo2.setPushIds(commonMsgPojo.getPushIds());
                if (imMessageCenterPojo2.getUnread_count() > 0) {
                    if (imMessageCenterPojo2.getUnread_count() > 0 || z3 || z2) {
                    }
                    imMessageCenterPojo2.setIsFriend(commonMsgPojo.getIsFriend());
                    imMessageCenterPojo2.setFollowStatus(commonMsgPojo.getFollowStatus());
                    imMessageCenterPojo2.setSend_status(3);
                    BdLog.i("send message status 3");
                }
                if (imMessageCenterPojo2.getUnread_count() > 0 || z3 || z2) {
                }
                imMessageCenterPojo2.setIsFriend(commonMsgPojo.getIsFriend());
                imMessageCenterPojo2.setFollowStatus(commonMsgPojo.getFollowStatus());
                imMessageCenterPojo2.setSend_status(3);
                BdLog.i("send message status 3");
            }
            int i = z ? 0 : unread_count > 0 ? 1 : 2;
            if (bVar != null) {
                bVar.a(valueOf, linkedList);
                bVar.b(imMessageCenterPojo2, i, z2);
            }
        }
    }
}
