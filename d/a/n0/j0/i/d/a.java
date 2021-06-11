package d.a.n0.j0.i.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankHttpResMsg;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankReqMsg;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankSocketResMsg;
import d.a.n0.j0.i.c.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f59671a;

    /* renamed from: b  reason: collision with root package name */
    public int f59672b = 1;

    /* renamed from: c  reason: collision with root package name */
    public c f59673c;

    /* renamed from: d  reason: collision with root package name */
    public b f59674d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f59675e;

    /* renamed from: d.a.n0.j0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1434a extends d.a.c.c.g.a {
        public C1434a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.f59671a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (a.this.f59672b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f59663b))) {
                        if (a.this.f59674d != null) {
                            a.this.f59674d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        a.this.f59673c.f59662a = cVar.f59662a;
                        a.this.f59673c.f59663b.addAll(cVar.f59663b);
                        a.this.f59673c.f59664c = cVar.f59664c;
                        a.this.f59673c.f59665d = cVar.f59665d;
                        a.this.f59673c.f59666e = cVar.f59666e;
                        a.this.f59673c.f59667f = cVar.f59667f;
                        if (ListUtils.isEmpty(cVar.f59663b)) {
                            a.this.f59673c.f59668g = false;
                        } else {
                            a.this.f59673c.f59668g = cVar.f59668g;
                            a.c(a.this);
                        }
                        if (a.this.f59674d != null) {
                            a.this.f59674d.a(cVar);
                        }
                    }
                } else if (a.this.f59674d != null) {
                    a.this.f59674d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(c cVar);

        void onError(int i2, String str);
    }

    public a(BdUniqueId bdUniqueId) {
        C1434a c1434a = new C1434a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f59675e = c1434a;
        this.f59671a = bdUniqueId;
        c1434a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f59675e);
        m();
        l();
        this.f59673c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f59672b;
        aVar.f59672b = i2 + 1;
        return i2;
    }

    public int f() {
        return this.f59672b;
    }

    public c g() {
        return this.f59673c;
    }

    public void h(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f59672b;
        hotUserRankReqMsg.setTag(this.f59671a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void i(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f59672b;
        hotUserRankReqMsg.setTag(this.f59671a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public boolean j() {
        return this.f59673c.f59668g;
    }

    public void k() {
        MessageManager.getInstance().removeMessage(this.f59671a);
        MessageManager.getInstance().unRegisterListener(this.f59671a);
    }

    public final void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, d.a.n0.e3.d0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void m() {
        d.a.m0.v0.b bVar = new d.a.m0.v0.b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void n(b bVar) {
        this.f59674d = bVar;
    }
}
