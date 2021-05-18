package d.a.k0.v2.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumHttpResMsg;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumReqMsg;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumSocketResMsg;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f62411a;

    /* renamed from: b  reason: collision with root package name */
    public int f62412b = 1;

    /* renamed from: c  reason: collision with root package name */
    public d f62413c;

    /* renamed from: d  reason: collision with root package name */
    public b f62414d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f62415e;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d pageData;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f62411a) {
                if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                    pageData = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
                } else {
                    pageData = responsedMessage instanceof ForbiddenForumSocketResMsg ? ((ForbiddenForumSocketResMsg) responsedMessage).getPageData() : null;
                }
                if (responsedMessage.getError() == 0) {
                    if (c.this.f62412b == 1 && (pageData == null || ListUtils.isEmpty(pageData.f62417a))) {
                        if (c.this.f62414d != null) {
                            c.this.f62414d.a(null);
                        }
                    } else if (pageData != null) {
                        c.this.f62413c.f62417a.addAll(pageData.f62417a);
                        if (ListUtils.isEmpty(pageData.f62417a)) {
                            c.this.f62413c.f62418b = false;
                        } else {
                            c.this.f62413c.f62418b = pageData.f62418b;
                            c.c(c.this);
                        }
                        if (c.this.f62414d != null) {
                            c.this.f62414d.a(pageData);
                        }
                    }
                } else if (c.this.f62414d != null) {
                    c.this.f62414d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(d dVar);

        void onError(int i2, String str);
    }

    public c(BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, 309692);
        this.f62415e = aVar;
        this.f62411a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62415e);
        i();
        h();
        this.f62413c = new d();
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.f62412b;
        cVar.f62412b = i2 + 1;
        return i2;
    }

    public void f(String str) {
        String str2;
        d dVar = this.f62413c;
        if (dVar == null || ListUtils.isEmpty(dVar.f62417a)) {
            return;
        }
        for (d.a.k0.v2.a.b bVar : this.f62413c.f62417a) {
            if (bVar != null && (str2 = bVar.f62410c) != null && str2.equals(str)) {
                this.f62413c.f62417a.remove(bVar);
                return;
            }
        }
    }

    public d g() {
        return this.f62413c;
    }

    public final void h() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, d.a.k0.d3.d0.a.a(TbConfig.URL_GET_FORBIDDEN_FORUM, 309692));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(ForbiddenForumHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void i() {
        d.a.j0.v0.b bVar = new d.a.j0.v0.b(309692);
        bVar.setResponsedClass(ForbiddenForumSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void j() {
        ForbiddenForumReqMsg forbiddenForumReqMsg = new ForbiddenForumReqMsg();
        forbiddenForumReqMsg.pageSize = 20;
        forbiddenForumReqMsg.pageNum = this.f62412b;
        forbiddenForumReqMsg.setTag(this.f62411a);
        MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
    }

    public void k(b bVar) {
        this.f62414d = bVar;
    }
}
