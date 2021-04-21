package d.b.j0.v2.a;

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
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f63452a;

    /* renamed from: b  reason: collision with root package name */
    public int f63453b = 1;

    /* renamed from: c  reason: collision with root package name */
    public d f63454c;

    /* renamed from: d  reason: collision with root package name */
    public b f63455d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f63456e;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d pageData;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f63452a) {
                if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                    pageData = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
                } else {
                    pageData = responsedMessage instanceof ForbiddenForumSocketResMsg ? ((ForbiddenForumSocketResMsg) responsedMessage).getPageData() : null;
                }
                if (responsedMessage.getError() == 0) {
                    if (c.this.f63453b == 1 && (pageData == null || ListUtils.isEmpty(pageData.f63458a))) {
                        if (c.this.f63455d != null) {
                            c.this.f63455d.a(null);
                        }
                    } else if (pageData != null) {
                        c.this.f63454c.f63458a.addAll(pageData.f63458a);
                        if (ListUtils.isEmpty(pageData.f63458a)) {
                            c.this.f63454c.f63459b = false;
                        } else {
                            c.this.f63454c.f63459b = pageData.f63459b;
                            c.c(c.this);
                        }
                        if (c.this.f63455d != null) {
                            c.this.f63455d.a(pageData);
                        }
                    }
                } else if (c.this.f63455d != null) {
                    c.this.f63455d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d dVar);

        void onError(int i, String str);
    }

    public c(BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, 309692);
        this.f63456e = aVar;
        this.f63452a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f63456e);
        i();
        h();
        this.f63454c = new d();
    }

    public static /* synthetic */ int c(c cVar) {
        int i = cVar.f63453b;
        cVar.f63453b = i + 1;
        return i;
    }

    public void f(String str) {
        String str2;
        d dVar = this.f63454c;
        if (dVar == null || ListUtils.isEmpty(dVar.f63458a)) {
            return;
        }
        for (d.b.j0.v2.a.b bVar : this.f63454c.f63458a) {
            if (bVar != null && (str2 = bVar.f63451c) != null && str2.equals(str)) {
                this.f63454c.f63458a.remove(bVar);
                return;
            }
        }
    }

    public d g() {
        return this.f63454c;
    }

    public final void h() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, d.b.j0.d3.d0.a.a(TbConfig.URL_GET_FORBIDDEN_FORUM, 309692));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(ForbiddenForumHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void i() {
        d.b.i0.v0.b bVar = new d.b.i0.v0.b(309692);
        bVar.setResponsedClass(ForbiddenForumSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void j() {
        ForbiddenForumReqMsg forbiddenForumReqMsg = new ForbiddenForumReqMsg();
        forbiddenForumReqMsg.pageSize = 20;
        forbiddenForumReqMsg.pageNum = this.f63453b;
        forbiddenForumReqMsg.setTag(this.f63452a);
        MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
    }

    public void k(b bVar) {
        this.f63455d = bVar;
    }
}
