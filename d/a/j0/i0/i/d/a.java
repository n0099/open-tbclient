package d.a.j0.i0.i.d;

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
import d.a.j0.i0.i.c.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f55091a;

    /* renamed from: b  reason: collision with root package name */
    public int f55092b = 1;

    /* renamed from: c  reason: collision with root package name */
    public c f55093c;

    /* renamed from: d  reason: collision with root package name */
    public b f55094d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f55095e;

    /* renamed from: d.a.j0.i0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1288a extends d.a.c.c.g.a {
        public C1288a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == a.this.f55091a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (a.this.f55092b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f55083b))) {
                        if (a.this.f55094d != null) {
                            a.this.f55094d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        a.this.f55093c.f55082a = cVar.f55082a;
                        a.this.f55093c.f55083b.addAll(cVar.f55083b);
                        a.this.f55093c.f55084c = cVar.f55084c;
                        a.this.f55093c.f55085d = cVar.f55085d;
                        a.this.f55093c.f55086e = cVar.f55086e;
                        a.this.f55093c.f55087f = cVar.f55087f;
                        if (ListUtils.isEmpty(cVar.f55083b)) {
                            a.this.f55093c.f55088g = false;
                        } else {
                            a.this.f55093c.f55088g = cVar.f55088g;
                            a.c(a.this);
                        }
                        if (a.this.f55094d != null) {
                            a.this.f55094d.a(cVar);
                        }
                    }
                } else if (a.this.f55094d != null) {
                    a.this.f55094d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
        C1288a c1288a = new C1288a(CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f55095e = c1288a;
        this.f55091a = bdUniqueId;
        c1288a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f55095e);
        m();
        l();
        this.f55093c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f55092b;
        aVar.f55092b = i2 + 1;
        return i2;
    }

    public int f() {
        return this.f55092b;
    }

    public c g() {
        return this.f55093c;
    }

    public void h(long j) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.forumId = j;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f55092b;
        hotUserRankReqMsg.setTag(this.f55091a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public void i(String str) {
        HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
        hotUserRankReqMsg.category = str;
        hotUserRankReqMsg.pageSize = 20;
        hotUserRankReqMsg.pageNum = this.f55092b;
        hotUserRankReqMsg.setTag(this.f55091a);
        MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
    }

    public boolean j() {
        return this.f55093c.f55088g;
    }

    public void k() {
        MessageManager.getInstance().removeMessage(this.f55091a);
        MessageManager.getInstance().unRegisterListener(this.f55091a);
    }

    public final void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, d.a.j0.d3.d0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void m() {
        d.a.i0.v0.b bVar = new d.a.i0.v0.b(309652);
        bVar.setResponsedClass(HotUserRankSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void n(b bVar) {
        this.f55094d = bVar;
    }
}
