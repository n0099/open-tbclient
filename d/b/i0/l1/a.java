package d.b.i0.l1;

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
    public BdUniqueId f58122a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f58123b;

    /* renamed from: c  reason: collision with root package name */
    public b f58124c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f58125d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f58126e;

    /* renamed from: d.b.i0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1385a extends d.b.c.c.g.a {
        public C1385a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f58125d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f58124c != null) {
                            a.this.f58124c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f58123b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f58123b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f58124c != null) {
                        a.this.f58124c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f58123b);
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
        C1385a c1385a = new C1385a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f58126e = c1385a;
        this.f58122a = bdUniqueId;
        c1385a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f58126e);
        this.f58126e.getHttpMessageListener().setSelfListener(true);
        this.f58126e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f58126e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f58122a);
        getBottleForumListReqMessage.setRequestId(this.f58125d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f58124c = bVar;
    }
}
