package d.a.j0.v3.q.d;

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
    public BdUniqueId f62087a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f62088b;

    /* renamed from: c  reason: collision with root package name */
    public String f62089c;

    /* renamed from: d  reason: collision with root package name */
    public b f62090d;

    /* renamed from: e  reason: collision with root package name */
    public String f62091e;

    /* renamed from: f  reason: collision with root package name */
    public String f62092f;

    /* renamed from: g  reason: collision with root package name */
    public int f62093g;

    /* renamed from: h  reason: collision with root package name */
    public String f62094h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f62095i;
    public d.a.c.c.g.a j;

    /* renamed from: d.a.j0.v3.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1639a extends d.a.c.c.g.a {
        public C1639a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.f62095i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f62090d != null) {
                            a.this.f62090d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        a.this.f62088b = getRepostForumHttpResMessage.getForumList();
                        a.this.f62089c = getRepostForumHttpResMessage.getRecommendExtension();
                        a.this.f62093g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        a.this.f62088b = getRepostForumSocketResMessage.getForumList();
                        a.this.f62089c = getRepostForumSocketResMessage.getRecommendExtension();
                        a.this.f62093g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (a.this.f62090d != null) {
                        a.this.f62090d.a(a.this.f62088b, a.this.f62093g);
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
        C1639a c1639a = new C1639a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1639a;
        this.f62087a = bdUniqueId;
        c1639a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.f62091e);
        getRepostForumReqMessage.setThreadContent(this.f62092f);
        getRepostForumReqMessage.setForumId(this.f62094h);
        getRepostForumReqMessage.setTag(this.f62087a);
        getRepostForumReqMessage.setRequestId(this.f62095i);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void i(b bVar) {
        this.f62090d = bVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.f62095i = bdUniqueId;
    }

    public void k(String str) {
        this.f62092f = str;
    }

    public void l(String str) {
        this.f62091e = str;
    }
}
