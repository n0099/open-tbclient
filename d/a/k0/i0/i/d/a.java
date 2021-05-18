package d.a.k0.i0.i.d;

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
import d.a.k0.i0.i.c.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f55798a;

    /* renamed from: b  reason: collision with root package name */
    public int f55799b = 1;

    /* renamed from: c  reason: collision with root package name */
    public c f55800c;

    /* renamed from: d  reason: collision with root package name */
    public b f55801d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f55802e;

    /* renamed from: d.a.k0.i0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1360a extends d.a.c.c.g.a {
        public C1360a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.f55798a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (a.this.f55799b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f55790b))) {
                        if (a.this.f55801d != null) {
                            a.this.f55801d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        a.this.f55800c.f55789a = cVar.f55789a;
                        a.this.f55800c.f55790b.addAll(cVar.f55790b);
                        a.this.f55800c.f55791c = cVar.f55791c;
                        a.this.f55800c.f55792d = cVar.f55792d;
                        a.this.f55800c.f55793e = cVar.f55793e;
                        a.this.f55800c.f55794f = cVar.f55794f;
                        if (ListUtils.isEmpty(cVar.f55790b)) {
                            a.this.f55800c.f55795g = false;
                        } else {
                            a.this.f55800c.f55795g = cVar.f55795g;
                            a.c(a.this);
                        }
                        if (a.this.f55801d != null) {
                            a.this.f55801d.a(cVar);
                        }
                    }
                } else if (a.this.f55801d != null) {
                    a.this.f55801d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
        C1360a c1360a = new C1360a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f55802e = c1360a;
        this.f55798a = bdUniqueId;
        c1360a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55802e);
        m();
        l();
        this.f55800c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f55799b;
        aVar.f55799b = i2 + 1;
        return i2;
    }

    public int f() {
        return this.f55799b;
    }

    public c g() {
        return this.f55800c;
    }

    public void h(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f55799b;
        hotUserRankReqMsg.setTag(this.f55798a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void i(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f55799b;
        hotUserRankReqMsg.setTag(this.f55798a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public boolean j() {
        return this.f55800c.f55795g;
    }

    public void k() {
        MessageManager.getInstance().removeMessage(this.f55798a);
        MessageManager.getInstance().unRegisterListener(this.f55798a);
    }

    public final void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, d.a.k0.d3.d0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void m() {
        d.a.j0.v0.b bVar = new d.a.j0.v0.b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void n(b bVar) {
        this.f55801d = bVar;
    }
}
