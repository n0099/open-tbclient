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
    public BdUniqueId f61138a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f61139b;

    /* renamed from: c  reason: collision with root package name */
    public b f61140c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f61141d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f61142e;

    /* renamed from: d.a.n0.m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1493a extends d.a.c.c.g.a {
        public C1493a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f61141d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f61140c != null) {
                            a.this.f61140c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f61139b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f61139b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f61140c != null) {
                        a.this.f61140c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f61139b);
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
        C1493a c1493a = new C1493a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f61142e = c1493a;
        this.f61138a = bdUniqueId;
        c1493a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f61142e);
        this.f61142e.getHttpMessageListener().setSelfListener(true);
        this.f61142e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f61142e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f61138a);
        getBottleForumListReqMessage.setRequestId(this.f61141d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f61140c = bVar;
    }
}
