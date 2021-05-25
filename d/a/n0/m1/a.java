package d.a.n0.m1;

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
    public BdUniqueId f57449a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f57450b;

    /* renamed from: c  reason: collision with root package name */
    public b f57451c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f57452d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f57453e;

    /* renamed from: d.a.n0.m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1437a extends d.a.c.c.g.a {
        public C1437a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f57452d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f57451c != null) {
                            a.this.f57451c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f57450b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f57450b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f57451c != null) {
                        a.this.f57451c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f57450b);
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
        C1437a c1437a = new C1437a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f57453e = c1437a;
        this.f57449a = bdUniqueId;
        c1437a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f57453e);
        this.f57453e.getHttpMessageListener().setSelfListener(true);
        this.f57453e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f57453e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f57449a);
        getBottleForumListReqMessage.setRequestId(this.f57452d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f57451c = bVar;
    }
}
