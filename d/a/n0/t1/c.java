package d.a.n0.t1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personExtra.RecommendGodHttpResponseMessage;
import com.baidu.tieba.personExtra.RecommendGodReqMsg;
import com.baidu.tieba.personExtra.RecommendGodSocketResponseMessage;
import d.a.n0.j2.e.q;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f64575a;

    /* renamed from: b  reason: collision with root package name */
    public q f64576b;

    /* renamed from: c  reason: collision with root package name */
    public b f64577c;

    /* renamed from: d  reason: collision with root package name */
    public int f64578d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64579e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f64580f;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.f64576b = null;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f64575a) {
                if (responsedMessage instanceof RecommendGodSocketResponseMessage) {
                    c.this.f64576b = ((RecommendGodSocketResponseMessage) responsedMessage).recommendGodData;
                } else if (responsedMessage instanceof RecommendGodHttpResponseMessage) {
                    c.this.f64576b = ((RecommendGodHttpResponseMessage) responsedMessage).recommendGodData;
                }
                if (c.this.f64576b != null) {
                    c cVar = c.this;
                    cVar.f64578d = cVar.f64576b.f60129a;
                }
                int error = responsedMessage.getError();
                if (error != 0 || c.this.f64576b == null) {
                    error = 1;
                } else if (ListUtils.isEmpty(c.this.f64576b.f60130b)) {
                    error = c.this.f64579e ? 3 : 2;
                }
                if (c.this.f64577c != null) {
                    c.this.f64577c.a(c.this.f64576b, error);
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
        this.f64580f = aVar;
        this.f64575a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f64580f);
    }

    public void g() {
        MessageManager.getInstance().removeMessage(this.f64575a);
        MessageManager.getInstance().unRegisterListener(this.f64575a);
    }

    public void h(String str) {
        RecommendGodReqMsg recommendGodReqMsg = new RecommendGodReqMsg();
        recommendGodReqMsg.portrait = str;
        if (this.f64578d == 0) {
            this.f64579e = false;
        } else {
            this.f64579e = true;
        }
        recommendGodReqMsg.pageNum = this.f64578d + 1;
        recommendGodReqMsg.setTag(this.f64575a);
        MessageManager.getInstance().sendMessage(recommendGodReqMsg);
    }

    public void i(String str, int i2) {
        this.f64578d = i2;
        h(str);
    }

    public void j(b bVar) {
        this.f64577c = bVar;
    }
}
