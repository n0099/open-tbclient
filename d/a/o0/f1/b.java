package d.a.o0.f1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.push.PushResponseMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
import d.a.c.c.f.j;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static class a extends j {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
        @Override // d.a.c.c.f.g
        public /* bridge */ /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
            SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
            c(socketResponsedMessage2);
            return socketResponsedMessage2;
        }

        public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof PushNotifyMessageDecoder) {
                PushNotifyMessageDecoder pushNotifyMessageDecoder = (PushNotifyMessageDecoder) socketResponsedMessage;
                if (pushNotifyMessageDecoder.getMsgList() != null) {
                    Iterator<PushNotifyMessage> it = pushNotifyMessageDecoder.getMsgList().iterator();
                    while (it.hasNext()) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(it.next());
                    }
                }
            }
            return socketResponsedMessage;
        }
    }

    public static void a() {
        b();
        c();
    }

    public static void b() {
        c.b(104102, ResponseUpdateMaskInfoMessage.class, false);
        c.b(202003, ResponsePullMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c.b(202009, PushResponseMessage.class, false);
        c.b(202006, PushNotifyMessageDecoder.class, false);
        c.b(104103, ResponseGetMaskInfoMessage.class, false);
        c.b(304100, ResponseAddFriendMessage.class, false);
        c.b(304102, ResponseDeleteFriendMessage.class, false);
        c.b(304103, ResponseApplyMessage.class, false);
        c.b(205002, ResponseCommitInviteMessage.class, false);
        c.b(104104, ResponseCheckUserMaskMessage.class, false);
        MessageManager.getInstance().registerStickyMode(2001120);
    }

    public static boolean c() {
        MessageManager.getInstance().addResponsedMessageRule(new a(202006));
        MessageManager.getInstance().addResponsedMessageRule(new d.a.o0.f1.m.d());
        MessageManager.getInstance().addResponsedMessageRule(new d.a.o0.f1.o.d());
        MessageManager.getInstance().addMessageRule(new d.a.o0.f1.m.c());
        return true;
    }
}
