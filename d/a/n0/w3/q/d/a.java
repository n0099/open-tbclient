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
    public BdUniqueId f62918a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f62919b;

    /* renamed from: c  reason: collision with root package name */
    public String f62920c;

    /* renamed from: d  reason: collision with root package name */
    public b f62921d;

    /* renamed from: e  reason: collision with root package name */
    public String f62922e;

    /* renamed from: f  reason: collision with root package name */
    public String f62923f;

    /* renamed from: g  reason: collision with root package name */
    public int f62924g;

    /* renamed from: h  reason: collision with root package name */
    public String f62925h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f62926i;
    public d.a.c.c.g.a j;

    /* renamed from: d.a.n0.w3.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1717a extends d.a.c.c.g.a {
        public C1717a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.f62926i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f62921d != null) {
                            a.this.f62921d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        a.this.f62919b = getRepostForumHttpResMessage.getForumList();
                        a.this.f62920c = getRepostForumHttpResMessage.getRecommendExtension();
                        a.this.f62924g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        a.this.f62919b = getRepostForumSocketResMessage.getForumList();
                        a.this.f62920c = getRepostForumSocketResMessage.getRecommendExtension();
                        a.this.f62924g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (a.this.f62921d != null) {
                        a.this.f62921d.a(a.this.f62919b, a.this.f62924g);
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
        C1717a c1717a = new C1717a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1717a;
        this.f62918a = bdUniqueId;
        c1717a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.f62922e);
        getRepostForumReqMessage.setThreadContent(this.f62923f);
        getRepostForumReqMessage.setForumId(this.f62925h);
        getRepostForumReqMessage.setTag(this.f62918a);
        getRepostForumReqMessage.setRequestId(this.f62926i);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void i(b bVar) {
        this.f62921d = bVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f62926i = bdUniqueId;
    }

    public void k(String str) {
        this.f62923f = str;
    }

    public void l(String str) {
        this.f62922e = str;
    }
}
