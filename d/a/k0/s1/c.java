package d.a.k0.s1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personExtra.RecommendGodHttpResponseMessage;
import com.baidu.tieba.personExtra.RecommendGodReqMsg;
import com.baidu.tieba.personExtra.RecommendGodSocketResponseMessage;
import d.a.k0.i2.e.q;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f60781a;

    /* renamed from: b  reason: collision with root package name */
    public q f60782b;

    /* renamed from: c  reason: collision with root package name */
    public b f60783c;

    /* renamed from: d  reason: collision with root package name */
    public int f60784d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60785e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f60786f;

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.f60782b = null;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f60781a) {
                if (responsedMessage instanceof RecommendGodSocketResponseMessage) {
                    c.this.f60782b = ((RecommendGodSocketResponseMessage) responsedMessage).recommendGodData;
                } else if (responsedMessage instanceof RecommendGodHttpResponseMessage) {
                    c.this.f60782b = ((RecommendGodHttpResponseMessage) responsedMessage).recommendGodData;
                }
                if (c.this.f60782b != null) {
                    c cVar = c.this;
                    cVar.f60784d = cVar.f60782b.f56256a;
                }
                int error = responsedMessage.getError();
                if (error != 0 || c.this.f60782b == null) {
                    error = 1;
                } else if (ListUtils.isEmpty(c.this.f60782b.f56257b)) {
                    error = c.this.f60785e ? 3 : 2;
                }
                if (c.this.f60783c != null) {
                    c.this.f60783c.a(c.this.f60782b, error);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(q qVar, int i2);
    }

    public c(BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684);
        this.f60786f = aVar;
        this.f60781a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60786f);
    }

    public void g() {
        MessageManager.getInstance().removeMessage(this.f60781a);
        MessageManager.getInstance().unRegisterListener(this.f60781a);
    }

    public void h(String str) {
        RecommendGodReqMsg recommendGodReqMsg = new RecommendGodReqMsg();
        recommendGodReqMsg.portrait = str;
        if (this.f60784d == 0) {
            this.f60785e = false;
        } else {
            this.f60785e = true;
        }
        recommendGodReqMsg.pageNum = this.f60784d + 1;
        recommendGodReqMsg.setTag(this.f60781a);
        MessageManager.getInstance().sendMessage(recommendGodReqMsg);
    }

    public void i(String str, int i2) {
        this.f60784d = i2;
        h(str);
    }

    public void j(b bVar) {
        this.f60783c = bVar;
    }
}
