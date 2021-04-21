package d.b.j0.s1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personExtra.RecommendGodHttpResponseMessage;
import com.baidu.tieba.personExtra.RecommendGodReqMsg;
import com.baidu.tieba.personExtra.RecommendGodSocketResponseMessage;
import d.b.j0.i2.e.q;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f61902a;

    /* renamed from: b  reason: collision with root package name */
    public q f61903b;

    /* renamed from: c  reason: collision with root package name */
    public b f61904c;

    /* renamed from: d  reason: collision with root package name */
    public int f61905d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61906e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f61907f;

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.f61903b = null;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f61902a) {
                if (responsedMessage instanceof RecommendGodSocketResponseMessage) {
                    c.this.f61903b = ((RecommendGodSocketResponseMessage) responsedMessage).recommendGodData;
                } else if (responsedMessage instanceof RecommendGodHttpResponseMessage) {
                    c.this.f61903b = ((RecommendGodHttpResponseMessage) responsedMessage).recommendGodData;
                }
                if (c.this.f61903b != null) {
                    c cVar = c.this;
                    cVar.f61905d = cVar.f61903b.f57594a;
                }
                int error = responsedMessage.getError();
                if (error != 0 || c.this.f61903b == null) {
                    error = 1;
                } else if (ListUtils.isEmpty(c.this.f61903b.f57595b)) {
                    error = c.this.f61906e ? 3 : 2;
                }
                if (c.this.f61904c != null) {
                    c.this.f61904c.a(c.this.f61903b, error);
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
        this.f61907f = aVar;
        this.f61902a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f61907f);
    }

    public void g() {
        MessageManager.getInstance().removeMessage(this.f61902a);
        MessageManager.getInstance().unRegisterListener(this.f61902a);
    }

    public void h(String str) {
        RecommendGodReqMsg recommendGodReqMsg = new RecommendGodReqMsg();
        recommendGodReqMsg.portrait = str;
        if (this.f61905d == 0) {
            this.f61906e = false;
        } else {
            this.f61906e = true;
        }
        recommendGodReqMsg.pageNum = this.f61905d + 1;
        recommendGodReqMsg.setTag(this.f61902a);
        MessageManager.getInstance().sendMessage(recommendGodReqMsg);
    }

    public void i(String str, int i) {
        this.f61905d = i;
        h(str);
    }

    public void j(b bVar) {
        this.f61904c = bVar;
    }
}
