package d.b.i0.u3.r.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.write.transmit.model.GetRepostForumHttpResMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumReqMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumSocketResMessage;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f61690a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f61691b;

    /* renamed from: c  reason: collision with root package name */
    public String f61692c;

    /* renamed from: d  reason: collision with root package name */
    public b f61693d;

    /* renamed from: e  reason: collision with root package name */
    public String f61694e;

    /* renamed from: f  reason: collision with root package name */
    public String f61695f;

    /* renamed from: g  reason: collision with root package name */
    public int f61696g;

    /* renamed from: h  reason: collision with root package name */
    public String f61697h;
    public BdUniqueId i;
    public d.b.b.c.g.a j;

    /* renamed from: d.b.i0.u3.r.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1619a extends d.b.b.c.g.a {
        public C1619a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f61693d != null) {
                            a.this.f61693d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        a.this.f61691b = getRepostForumHttpResMessage.getForumList();
                        a.this.f61692c = getRepostForumHttpResMessage.getRecommendExtension();
                        a.this.f61696g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        a.this.f61691b = getRepostForumSocketResMessage.getForumList();
                        a.this.f61692c = getRepostForumSocketResMessage.getRecommendExtension();
                        a.this.f61696g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (a.this.f61693d != null) {
                        a.this.f61693d.a(a.this.f61691b, a.this.f61696g);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<SimpleForum> list, int i);

        void onError();
    }

    public a(BdUniqueId bdUniqueId) {
        C1619a c1619a = new C1619a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1619a;
        this.f61690a = bdUniqueId;
        c1619a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.f61694e);
        getRepostForumReqMessage.setThreadContent(this.f61695f);
        getRepostForumReqMessage.setForumId(this.f61697h);
        getRepostForumReqMessage.setTag(this.f61690a);
        getRepostForumReqMessage.setRequestId(this.i);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void i(b bVar) {
        this.f61693d = bVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.i = bdUniqueId;
    }

    public void k(String str) {
        this.f61695f = str;
    }

    public void l(String str) {
        this.f61694e = str;
    }
}
