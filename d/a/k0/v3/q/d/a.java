package d.a.k0.v3.q.d;

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
    public BdUniqueId f62811a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f62812b;

    /* renamed from: c  reason: collision with root package name */
    public String f62813c;

    /* renamed from: d  reason: collision with root package name */
    public b f62814d;

    /* renamed from: e  reason: collision with root package name */
    public String f62815e;

    /* renamed from: f  reason: collision with root package name */
    public String f62816f;

    /* renamed from: g  reason: collision with root package name */
    public int f62817g;

    /* renamed from: h  reason: collision with root package name */
    public String f62818h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f62819i;
    public d.a.c.c.g.a j;

    /* renamed from: d.a.k0.v3.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1704a extends d.a.c.c.g.a {
        public C1704a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.f62819i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f62814d != null) {
                            a.this.f62814d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        a.this.f62812b = getRepostForumHttpResMessage.getForumList();
                        a.this.f62813c = getRepostForumHttpResMessage.getRecommendExtension();
                        a.this.f62817g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        a.this.f62812b = getRepostForumSocketResMessage.getForumList();
                        a.this.f62813c = getRepostForumSocketResMessage.getRecommendExtension();
                        a.this.f62817g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (a.this.f62814d != null) {
                        a.this.f62814d.a(a.this.f62812b, a.this.f62817g);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<SimpleForum> list, int i2);

        void onError();
    }

    public a(BdUniqueId bdUniqueId) {
        C1704a c1704a = new C1704a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1704a;
        this.f62811a = bdUniqueId;
        c1704a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.f62815e);
        getRepostForumReqMessage.setThreadContent(this.f62816f);
        getRepostForumReqMessage.setForumId(this.f62818h);
        getRepostForumReqMessage.setTag(this.f62811a);
        getRepostForumReqMessage.setRequestId(this.f62819i);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void i(b bVar) {
        this.f62814d = bVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f62819i = bdUniqueId;
    }

    public void k(String str) {
        this.f62816f = str;
    }

    public void l(String str) {
        this.f62815e = str;
    }
}
