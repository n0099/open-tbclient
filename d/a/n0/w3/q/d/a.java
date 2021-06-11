package d.a.n0.w3.q.d;

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
    public BdUniqueId f66633a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f66634b;

    /* renamed from: c  reason: collision with root package name */
    public String f66635c;

    /* renamed from: d  reason: collision with root package name */
    public b f66636d;

    /* renamed from: e  reason: collision with root package name */
    public String f66637e;

    /* renamed from: f  reason: collision with root package name */
    public String f66638f;

    /* renamed from: g  reason: collision with root package name */
    public int f66639g;

    /* renamed from: h  reason: collision with root package name */
    public String f66640h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f66641i;
    public d.a.c.c.g.a j;

    /* renamed from: d.a.n0.w3.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1774a extends d.a.c.c.g.a {
        public C1774a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.f66641i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f66636d != null) {
                            a.this.f66636d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        a.this.f66634b = getRepostForumHttpResMessage.getForumList();
                        a.this.f66635c = getRepostForumHttpResMessage.getRecommendExtension();
                        a.this.f66639g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        a.this.f66634b = getRepostForumSocketResMessage.getForumList();
                        a.this.f66635c = getRepostForumSocketResMessage.getRecommendExtension();
                        a.this.f66639g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (a.this.f66636d != null) {
                        a.this.f66636d.a(a.this.f66634b, a.this.f66639g);
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
        C1774a c1774a = new C1774a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1774a;
        this.f66633a = bdUniqueId;
        c1774a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.f66637e);
        getRepostForumReqMessage.setThreadContent(this.f66638f);
        getRepostForumReqMessage.setForumId(this.f66640h);
        getRepostForumReqMessage.setTag(this.f66633a);
        getRepostForumReqMessage.setRequestId(this.f66641i);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void i(b bVar) {
        this.f66636d = bVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f66641i = bdUniqueId;
    }

    public void k(String str) {
        this.f66638f = str;
    }

    public void l(String str) {
        this.f66637e = str;
    }
}
