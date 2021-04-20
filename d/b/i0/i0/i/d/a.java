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
    public BdUniqueId f56740a;

    /* renamed from: b  reason: collision with root package name */
    public int f56741b = 1;

    /* renamed from: c  reason: collision with root package name */
    public c f56742c;

    /* renamed from: d  reason: collision with root package name */
    public b f56743d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f56744e;

    /* renamed from: d.b.i0.i0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1326a extends d.b.c.c.g.a {
        public C1326a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.f56740a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (a.this.f56741b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f56732b))) {
                        if (a.this.f56743d != null) {
                            a.this.f56743d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        a.this.f56742c.f56731a = cVar.f56731a;
                        a.this.f56742c.f56732b.addAll(cVar.f56732b);
                        a.this.f56742c.f56733c = cVar.f56733c;
                        a.this.f56742c.f56734d = cVar.f56734d;
                        a.this.f56742c.f56735e = cVar.f56735e;
                        a.this.f56742c.f56736f = cVar.f56736f;
                        if (ListUtils.isEmpty(cVar.f56732b)) {
                            a.this.f56742c.f56737g = false;
                        } else {
                            a.this.f56742c.f56737g = cVar.f56737g;
                            a.c(a.this);
                        }
                        if (a.this.f56743d != null) {
                            a.this.f56743d.a(cVar);
                        }
                    }
                } else if (a.this.f56743d != null) {
                    a.this.f56743d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
        C1326a c1326a = new C1326a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f56744e = c1326a;
        this.f56740a = bdUniqueId;
        c1326a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f56744e);
        m();
        l();
        this.f56742c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i = aVar.f56741b;
        aVar.f56741b = i + 1;
        return i;
    }

    public int f() {
        return this.f56741b;
    }

    public c g() {
        return this.f56742c;
    }

    public void h(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f56741b;
        hotUserRankReqMsg.setTag(this.f56740a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void i(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f56741b;
        hotUserRankReqMsg.setTag(this.f56740a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public boolean j() {
        return this.f56742c.f56737g;
    }

    public void k() {
        MessageManager.getInstance().removeMessage(this.f56740a);
        MessageManager.getInstance().unRegisterListener(this.f56740a);
    }

    public final void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, d.b.i0.d3.d0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
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
        this.f56743d = bVar;
    }
}
