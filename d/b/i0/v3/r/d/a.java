package d.b.i0.v3.r.d;

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
    public BdUniqueId f63428a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f63429b;

    /* renamed from: c  reason: collision with root package name */
    public String f63430c;

    /* renamed from: d  reason: collision with root package name */
    public b f63431d;

    /* renamed from: e  reason: collision with root package name */
    public String f63432e;

    /* renamed from: f  reason: collision with root package name */
    public String f63433f;

    /* renamed from: g  reason: collision with root package name */
    public int f63434g;

    /* renamed from: h  reason: collision with root package name */
    public String f63435h;
    public BdUniqueId i;
    public d.b.c.c.g.a j;

    /* renamed from: d.b.i0.v3.r.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1679a extends d.b.c.c.g.a {
        public C1679a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || a.this.i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (a.this.f63431d != null) {
                            a.this.f63431d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        a.this.f63429b = getRepostForumHttpResMessage.getForumList();
                        a.this.f63430c = getRepostForumHttpResMessage.getRecommendExtension();
                        a.this.f63434g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        a.this.f63429b = getRepostForumSocketResMessage.getForumList();
                        a.this.f63430c = getRepostForumSocketResMessage.getRecommendExtension();
                        a.this.f63434g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (a.this.f63431d != null) {
                        a.this.f63431d.a(a.this.f63429b, a.this.f63434g);
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
        C1679a c1679a = new C1679a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1679a;
        this.f63428a = bdUniqueId;
        c1679a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.f63432e);
        getRepostForumReqMessage.setThreadContent(this.f63433f);
        getRepostForumReqMessage.setForumId(this.f63435h);
        getRepostForumReqMessage.setTag(this.f63428a);
        getRepostForumReqMessage.setRequestId(this.i);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void i(b bVar) {
        this.f63431d = bVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.i = bdUniqueId;
    }

    public void k(String str) {
        this.f63433f = str;
    }

    public void l(String str) {
        this.f63432e = str;
    }
}
