package d.b.i0.r1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personExtra.RecommendGodHttpResponseMessage;
import com.baidu.tieba.personExtra.RecommendGodReqMsg;
import com.baidu.tieba.personExtra.RecommendGodSocketResponseMessage;
import d.b.i0.h2.e.q;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f59740a;

    /* renamed from: b  reason: collision with root package name */
    public q f59741b;

    /* renamed from: c  reason: collision with root package name */
    public b f59742c;

    /* renamed from: d  reason: collision with root package name */
    public int f59743d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59744e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.g.a f59745f;

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.f59741b = null;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f59740a) {
                if (responsedMessage instanceof RecommendGodSocketResponseMessage) {
                    c.this.f59741b = ((RecommendGodSocketResponseMessage) responsedMessage).recommendGodData;
                } else if (responsedMessage instanceof RecommendGodHttpResponseMessage) {
                    c.this.f59741b = ((RecommendGodHttpResponseMessage) responsedMessage).recommendGodData;
                }
                if (c.this.f59741b != null) {
                    c cVar = c.this;
                    cVar.f59743d = cVar.f59741b.f55315a;
                }
                int error = responsedMessage.getError();
                if (error != 0 || c.this.f59741b == null) {
                    error = 1;
                } else if (ListUtils.isEmpty(c.this.f59741b.f55316b)) {
                    error = c.this.f59744e ? 3 : 2;
                }
                if (c.this.f59742c != null) {
                    c.this.f59742c.a(c.this.f59741b, error);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(q qVar, int i);
    }

    public c(BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684);
        this.f59745f = aVar;
        this.f59740a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f59745f);
    }

    public void g() {
        MessageManager.getInstance().removeMessage(this.f59740a);
        MessageManager.getInstance().unRegisterListener(this.f59740a);
    }

    public void h(String str) {
        RecommendGodReqMsg recommendGodReqMsg = new RecommendGodReqMsg();
        recommendGodReqMsg.portrait = str;
        if (this.f59743d == 0) {
            this.f59744e = false;
        } else {
            this.f59744e = true;
        }
        recommendGodReqMsg.pageNum = this.f59743d + 1;
        recommendGodReqMsg.setTag(this.f59740a);
        MessageManager.getInstance().sendMessage(recommendGodReqMsg);
    }

    public void i(String str, int i) {
        this.f59743d = i;
        h(str);
    }

    public void j(b bVar) {
        this.f59742c = bVar;
    }
}
