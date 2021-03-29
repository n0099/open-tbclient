package d.b.i0.i0.i.d;

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
import d.b.i0.i0.i.c.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f55617a;

    /* renamed from: b  reason: collision with root package name */
    public int f55618b = 1;

    /* renamed from: c  reason: collision with root package name */
    public c f55619c;

    /* renamed from: d  reason: collision with root package name */
    public b f55620d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.c.g.a f55621e;

    /* renamed from: d.b.i0.i0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1288a extends d.b.b.c.g.a {
        public C1288a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.f55617a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (a.this.f55618b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f55609b))) {
                        if (a.this.f55620d != null) {
                            a.this.f55620d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        a.this.f55619c.f55608a = cVar.f55608a;
                        a.this.f55619c.f55609b.addAll(cVar.f55609b);
                        a.this.f55619c.f55610c = cVar.f55610c;
                        a.this.f55619c.f55611d = cVar.f55611d;
                        a.this.f55619c.f55612e = cVar.f55612e;
                        a.this.f55619c.f55613f = cVar.f55613f;
                        if (ListUtils.isEmpty(cVar.f55609b)) {
                            a.this.f55619c.f55614g = false;
                        } else {
                            a.this.f55619c.f55614g = cVar.f55614g;
                            a.c(a.this);
                        }
                        if (a.this.f55620d != null) {
                            a.this.f55620d.a(cVar);
                        }
                    }
                } else if (a.this.f55620d != null) {
                    a.this.f55620d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(c cVar);

        void onError(int i, String str);
    }

    public a(BdUniqueId bdUniqueId) {
        C1288a c1288a = new C1288a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f55621e = c1288a;
        this.f55617a = bdUniqueId;
        c1288a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55621e);
        m();
        l();
        this.f55619c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i = aVar.f55618b;
        aVar.f55618b = i + 1;
        return i;
    }

    public int f() {
        return this.f55618b;
    }

    public c g() {
        return this.f55619c;
    }

    public void h(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f55618b;
        hotUserRankReqMsg.setTag(this.f55617a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void i(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f55618b;
        hotUserRankReqMsg.setTag(this.f55617a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public boolean j() {
        return this.f55619c.f55614g;
    }

    public void k() {
        MessageManager.getInstance().removeMessage(this.f55617a);
        MessageManager.getInstance().unRegisterListener(this.f55617a);
    }

    public final void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, d.b.i0.c3.d0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void m() {
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void n(b bVar) {
        this.f55620d = bVar;
    }
}
