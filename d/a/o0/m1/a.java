package d.a.o0.m1;

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
    public BdUniqueId f61263a;

    /* renamed from: b  reason: collision with root package name */
    public List<ForumInfo> f61264b;

    /* renamed from: c  reason: collision with root package name */
    public b f61265c = null;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f61266d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f61267e;

    /* renamed from: d.a.o0.m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1497a extends d.a.c.c.g.a {
        public C1497a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetBottleForumListHttpResMessage;
            if (z || (responsedMessage instanceof GetBottleForumListSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetBottleForumListReqMessage) || a.this.f61266d == ((GetBottleForumListReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f61265c != null) {
                            a.this.f61265c.a(false, responsedMessage.getError(), responsedMessage.getErrorString(), null);
                            return;
                        }
                        return;
                    }
                    if (z) {
                        a.this.f61264b = ((GetBottleForumListHttpResMessage) responsedMessage).getBottleForumList();
                    }
                    if (responsedMessage instanceof GetBottleForumListSocketResMessage) {
                        a.this.f61264b = ((GetBottleForumListSocketResMessage) responsedMessage).getBottleForumList();
                    }
                    if (a.this.f61265c != null) {
                        a.this.f61265c.a(true, responsedMessage.getError(), responsedMessage.getErrorString(), a.this.f61264b);
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
        C1497a c1497a = new C1497a(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
        this.f61267e = c1497a;
        this.f61263a = bdUniqueId;
        c1497a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f61267e);
        this.f61267e.getHttpMessageListener().setSelfListener(true);
        this.f61267e.getSocketMessageListener().setSelfListener(true);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f61267e);
    }

    public boolean f() {
        GetBottleForumListReqMessage getBottleForumListReqMessage = new GetBottleForumListReqMessage();
        getBottleForumListReqMessage.setTag(this.f61263a);
        getBottleForumListReqMessage.setRequestId(this.f61266d);
        MessageManager.getInstance().sendMessage(getBottleForumListReqMessage);
        return false;
    }

    public void g(b bVar) {
        this.f61265c = bVar;
    }
}
