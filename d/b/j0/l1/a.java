package d.b.j0.l1;

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
    public BdUniqueId f58543a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f58544b;

    /* renamed from: c  reason: collision with root package name */
    public b f58545c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f58546d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f58547e;

    /* renamed from: d.b.j0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1408a extends d.b.c.c.g.a {
        public C1408a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f58546d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f58545c != null) {
                            a.this.f58545c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f58544b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f58544b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f58545c != null) {
                        a.this.f58545c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f58544b);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        C1408a c1408a = new C1408a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f58547e = c1408a;
        this.f58543a = bdUniqueId;
        c1408a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f58547e);
        this.f58547e.getHttpMessageListener().setSelfListener(true);
        this.f58547e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f58547e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f58543a);
        getBottleForumListReqMessage.setRequestId(this.f58546d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f58545c = bVar;
    }
}
