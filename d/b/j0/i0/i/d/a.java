package d.b.j0.i0.i.d;

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
import d.b.j0.i0.i.c.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f57161a;

    /* renamed from: b  reason: collision with root package name */
    public int f57162b = 1;

    /* renamed from: c  reason: collision with root package name */
    public c f57163c;

    /* renamed from: d  reason: collision with root package name */
    public b f57164d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f57165e;

    /* renamed from: d.b.j0.i0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1349a extends d.b.c.c.g.a {
        public C1349a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.f57161a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (a.this.f57162b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f57153b))) {
                        if (a.this.f57164d != null) {
                            a.this.f57164d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        a.this.f57163c.f57152a = cVar.f57152a;
                        a.this.f57163c.f57153b.addAll(cVar.f57153b);
                        a.this.f57163c.f57154c = cVar.f57154c;
                        a.this.f57163c.f57155d = cVar.f57155d;
                        a.this.f57163c.f57156e = cVar.f57156e;
                        a.this.f57163c.f57157f = cVar.f57157f;
                        if (ListUtils.isEmpty(cVar.f57153b)) {
                            a.this.f57163c.f57158g = false;
                        } else {
                            a.this.f57163c.f57158g = cVar.f57158g;
                            a.c(a.this);
                        }
                        if (a.this.f57164d != null) {
                            a.this.f57164d.a(cVar);
                        }
                    }
                } else if (a.this.f57164d != null) {
                    a.this.f57164d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
        C1349a c1349a = new C1349a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f57165e = c1349a;
        this.f57161a = bdUniqueId;
        c1349a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f57165e);
        m();
        l();
        this.f57163c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i = aVar.f57162b;
        aVar.f57162b = i + 1;
        return i;
    }

    public int f() {
        return this.f57162b;
    }

    public c g() {
        return this.f57163c;
    }

    public void h(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f57162b;
        hotUserRankReqMsg.setTag(this.f57161a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void i(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f57162b;
        hotUserRankReqMsg.setTag(this.f57161a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public boolean j() {
        return this.f57163c.f57158g;
    }

    public void k() {
        MessageManager.getInstance().removeMessage(this.f57161a);
        MessageManager.getInstance().unRegisterListener(this.f57161a);
    }

    public final void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, d.b.j0.d3.d0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void m() {
        d.b.i0.v0.b bVar = new d.b.i0.v0.b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void n(b bVar) {
        this.f57164d = bVar;
    }
}
