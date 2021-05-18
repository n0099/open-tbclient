package d.a.k0.l1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.likedForum.GetBottleForumListHttpResMessage;
import com.baidu.tieba.likedForum.GetBottleForumListReqMessage;
import com.baidu.tieba.likedForum.GetBottleForumListSocketResMessage;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f57259a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f57260b;

    /* renamed from: c  reason: collision with root package name */
    public b f57261c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f57262d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f57263e;

    /* renamed from: d.a.k0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1419a extends d.a.c.c.g.a {
        public C1419a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f57262d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f57261c != null) {
                            a.this.f57261c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f57260b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f57260b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f57261c != null) {
                        a.this.f57261c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f57260b);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, int i2, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        C1419a c1419a = new C1419a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f57263e = c1419a;
        this.f57259a = bdUniqueId;
        c1419a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f57263e);
        this.f57263e.getHttpMessageListener().setSelfListener(true);
        this.f57263e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f57263e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f57259a);
        getBottleForumListReqMessage.setRequestId(this.f57262d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f57261c = bVar;
    }
}
