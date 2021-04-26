package d.a.j0.l1;

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
    public BdUniqueId f56552a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f56553b;

    /* renamed from: c  reason: collision with root package name */
    public b f56554c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f56555d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f56556e;

    /* renamed from: d.a.j0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1347a extends d.a.c.c.g.a {
        public C1347a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f56555d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f56554c != null) {
                            a.this.f56554c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f56553b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f56553b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f56554c != null) {
                        a.this.f56554c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f56553b);
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
        C1347a c1347a = new C1347a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f56556e = c1347a;
        this.f56552a = bdUniqueId;
        c1347a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f56556e);
        this.f56556e.getHttpMessageListener().setSelfListener(true);
        this.f56556e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f56556e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f56552a);
        getBottleForumListReqMessage.setRequestId(this.f56555d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f56554c = bVar;
    }
}
