package d.b.i0.k1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.likedForum.GetBottleForumListHttpResMessage;
import com.baidu.tieba.likedForum.GetBottleForumListReqMessage;
import com.baidu.tieba.likedForum.GetBottleForumListSocketResMessage;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f56451a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f56452b;

    /* renamed from: c  reason: collision with root package name */
    public b f56453c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f56454d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.c.g.a f56455e;

    /* renamed from: d.b.i0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1323a extends d.b.b.c.g.a {
        public C1323a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f56454d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f56453c != null) {
                            a.this.f56453c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f56452b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f56452b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f56453c != null) {
                        a.this.f56453c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f56452b);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, int i, String str, List<ForumInfo> list);
    }

    public a(BdUniqueId bdUniqueId) {
        C1323a c1323a = new C1323a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f56455e = c1323a;
        this.f56451a = bdUniqueId;
        c1323a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f56455e);
        this.f56455e.getHttpMessageListener().setSelfListener(true);
        this.f56455e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f56455e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f56451a);
        getBottleForumListReqMessage.setRequestId(this.f56454d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f56453c = bVar;
    }
}
