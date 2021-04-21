package d.b.j0.v3.r.d;

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
    public BdUniqueId f63849a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f63850b;

    /* renamed from: c  reason: collision with root package name */
    public String f63851c;

    /* renamed from: d  reason: collision with root package name */
    public b f63852d;

    /* renamed from: e  reason: collision with root package name */
    public String f63853e;

    /* renamed from: f  reason: collision with root package name */
    public String f63854f;

    /* renamed from: g  reason: collision with root package name */
    public int f63855g;

    /* renamed from: h  reason: collision with root package name */
    public String f63856h;
    public BdUniqueId i;
    public d.b.c.c.g.a j;

    /* renamed from: d.b.j0.v3.r.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1702a extends d.b.c.c.g.a {
        public C1702a(int i, int i2) {
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
                        if (a.this.f63852d != null) {
                            a.this.f63852d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        a.this.f63850b = getRepostForumHttpResMessage.getForumList();
                        a.this.f63851c = getRepostForumHttpResMessage.getRecommendExtension();
                        a.this.f63855g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        a.this.f63850b = getRepostForumSocketResMessage.getForumList();
                        a.this.f63851c = getRepostForumSocketResMessage.getRecommendExtension();
                        a.this.f63855g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (a.this.f63852d != null) {
                        a.this.f63852d.a(a.this.f63850b, a.this.f63855g);
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
        C1702a c1702a = new C1702a(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1702a;
        this.f63849a = bdUniqueId;
        c1702a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
        getRepostForumReqMessage.setThreadTitle(this.f63853e);
        getRepostForumReqMessage.setThreadContent(this.f63854f);
        getRepostForumReqMessage.setForumId(this.f63856h);
        getRepostForumReqMessage.setTag(this.f63849a);
        getRepostForumReqMessage.setRequestId(this.i);
        MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
    }

    public void i(b bVar) {
        this.f63852d = bVar;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.i = bdUniqueId;
    }

    public void k(String str) {
        this.f63854f = str;
    }

    public void l(String str) {
        this.f63853e = str;
    }
}
