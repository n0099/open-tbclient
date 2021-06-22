package d.a.o0.t1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personExtra.RecommendGodHttpResponseMessage;
import com.baidu.tieba.personExtra.RecommendGodReqMsg;
import com.baidu.tieba.personExtra.RecommendGodSocketResponseMessage;
import d.a.o0.j2.e.q;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f64700a;

    /* renamed from: b  reason: collision with root package name */
    public q f64701b;

    /* renamed from: c  reason: collision with root package name */
    public b f64702c;

    /* renamed from: d  reason: collision with root package name */
    public int f64703d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64704e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f64705f;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.f64701b = null;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f64700a) {
                if (responsedMessage instanceof RecommendGodSocketResponseMessage) {
                    c.this.f64701b = ((RecommendGodSocketResponseMessage) responsedMessage).recommendGodData;
                } else if (responsedMessage instanceof RecommendGodHttpResponseMessage) {
                    c.this.f64701b = ((RecommendGodHttpResponseMessage) responsedMessage).recommendGodData;
                }
                if (c.this.f64701b != null) {
                    c cVar = c.this;
                    cVar.f64703d = cVar.f64701b.f60254a;
                }
                int error = responsedMessage.getError();
                if (error != 0 || c.this.f64701b == null) {
                    error = 1;
                } else if (ListUtils.isEmpty(c.this.f64701b.f60255b)) {
                    error = c.this.f64704e ? 3 : 2;
                }
                if (c.this.f64702c != null) {
                    c.this.f64702c.a(c.this.f64701b, error);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(q qVar, int i2);
    }

    public c(BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684);
        this.f64705f = aVar;
        this.f64700a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f64705f);
    }

    public void g() {
        MessageManager.getInstance().removeMessage(this.f64700a);
        MessageManager.getInstance().unRegisterListener(this.f64700a);
    }

    public void h(String str) {
        RecommendGodReqMsg recommendGodReqMsg = new RecommendGodReqMsg();
        recommendGodReqMsg.portrait = str;
        if (this.f64703d == 0) {
            this.f64704e = false;
        } else {
            this.f64704e = true;
        }
        recommendGodReqMsg.pageNum = this.f64703d + 1;
        recommendGodReqMsg.setTag(this.f64700a);
        MessageManager.getInstance().sendMessage(recommendGodReqMsg);
    }

    public void i(String str, int i2) {
        this.f64703d = i2;
        h(str);
    }

    public void j(b bVar) {
        this.f64702c = bVar;
    }
}
