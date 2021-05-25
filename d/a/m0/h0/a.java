package d.a.m0.h0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
/* loaded from: classes3.dex */
public class a {
    public static void a(long j, String str) {
        RequestPassFriendMessage requestPassFriendMessage = new RequestPassFriendMessage();
        requestPassFriendMessage.setFriendId(j, str);
        MessageManager.getInstance().sendMessage(requestPassFriendMessage);
    }
}
