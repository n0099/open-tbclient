package d.a.o0.w3.q.d;

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
    public BdUniqueId f66758a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f66759b;

    /* renamed from: c  reason: collision with root package name */
    public String f66760c;

    /* renamed from: d  reason: collision with root package name */
    public b f66761d;

    /* renamed from: e  reason: collision with root package name */
    public String f66762e;

    /* renamed from: f  reason: collision with root package name */
    public String f66763f;

    /* renamed from: g  reason: collision with root package name */
    public int f66764g;

    /* renamed from: h  reason: collision with root package name */
    public String f66765h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f66766i;
    public d.a.c.c.g.a j;

    /* renamed from: d.a.o0.w3.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1778a extends d.a.c.c.g.a {
        public C1778a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.f66766i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f66761d != null) {
                            a.this.f66761d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        a.this.f66759b = getRepostForumHttpResMessage.getForumList();
                        a.this.f66760c = getRepostForumHttpResMessage.getRecommendExtension();
                        a.this.f66764g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        a.this.f66759b = getRepostForumSocketResMessage.getForumList();
                        a.this.f66760c = getRepostForumSocketResMessage.getRecommendExtension();
                        a.this.f66764g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (a.this.f66761d != null) {
                        a.this.f66761d.a(a.this.f66759b, a.this.f66764g);
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
        C1778a c1778a = new C1778a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1778a;
        this.f66758a = bdUniqueId;
        c1778a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.f66762e);
        getRepostForumReqMessage.setThreadContent(this.f66763f);
        getRepostForumReqMessage.setForumId(this.f66765h);
        getRepostForumReqMessage.setTag(this.f66758a);
        getRepostForumReqMessage.setRequestId(this.f66766i);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void i(b bVar) {
        this.f66761d = bVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f66766i = bdUniqueId;
    }

    public void k(String str) {
        this.f66763f = str;
    }

    public void l(String str) {
        this.f66762e = str;
    }
}
