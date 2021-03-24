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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f56450a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f56451b;

    /* renamed from: c  reason: collision with root package name */
    public b f56452c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f56453d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.c.g.a f56454e;

    /* renamed from: d.b.i0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1322a extends d.b.b.c.g.a {
        public C1322a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f56453d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f56452c != null) {
                            a.this.f56452c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f56451b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f56451b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f56452c != null) {
                        a.this.f56452c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f56451b);
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
        C1322a c1322a = new C1322a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f56454e = c1322a;
        this.f56450a = bdUniqueId;
        c1322a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f56454e);
        this.f56454e.getHttpMessageListener().setSelfListener(true);
        this.f56454e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f56454e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f56450a);
        getBottleForumListReqMessage.setRequestId(this.f56453d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f56452c = bVar;
    }
}
