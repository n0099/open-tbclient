package d.b.i0.u2.a;

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
    public BdUniqueId f61292a;

    /* renamed from: b  reason: collision with root package name */
    public int f61293b = 1;

    /* renamed from: c  reason: collision with root package name */
    public d f61294c;

    /* renamed from: d  reason: collision with root package name */
    public b f61295d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.c.g.a f61296e;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d pageData;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f61292a) {
                if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                    pageData = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
                } else {
                    pageData = responsedMessage instanceof ForbiddenForumSocketResMsg ? ((ForbiddenForumSocketResMsg) responsedMessage).getPageData() : null;
                }
                if (responsedMessage.getError() == 0) {
                    if (c.this.f61293b == 1 && (pageData == null || ListUtils.isEmpty(pageData.f61298a))) {
                        if (c.this.f61295d != null) {
                            c.this.f61295d.a(null);
                        }
                    } else if (pageData != null) {
                        c.this.f61294c.f61298a.addAll(pageData.f61298a);
                        if (ListUtils.isEmpty(pageData.f61298a)) {
                            c.this.f61294c.f61299b = false;
                        } else {
                            c.this.f61294c.f61299b = pageData.f61299b;
                            c.c(c.this);
                        }
                        if (c.this.f61295d != null) {
                            c.this.f61295d.a(pageData);
                        }
                    }
                } else if (c.this.f61295d != null) {
                    c.this.f61295d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(d dVar);

        void onError(int i, String str);
    }

    public c(BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, 309692);
        this.f61296e = aVar;
        this.f61292a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f61296e);
        i();
        h();
        this.f61294c = new d();
    }

    public static /* synthetic */ int c(c cVar) {
        int i = cVar.f61293b;
        cVar.f61293b = i + 1;
        return i;
    }

    public void f(String str) {
        String str2;
        d dVar = this.f61294c;
        if (dVar == null || ListUtils.isEmpty(dVar.f61298a)) {
            return;
        }
        for (d.b.i0.u2.a.b bVar : this.f61294c.f61298a) {
            if (bVar != null && (str2 = bVar.f61291c) != null && str2.equals(str)) {
                this.f61294c.f61298a.remove(bVar);
                return;
            }
        }
    }

    public d g() {
        return this.f61294c;
    }

    public final void h() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, d.b.i0.c3.d0.a.a(TbConfig.URL_GET_FORBIDDEN_FORUM, 309692));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(ForbiddenForumHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void i() {
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(309692);
        bVar.setResponsedClass(ForbiddenForumSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void j() {
        ForbiddenForumReqMsg forbiddenForumReqMsg = new ForbiddenForumReqMsg();
        forbiddenForumReqMsg.pageSize = 20;
        forbiddenForumReqMsg.pageNum = this.f61293b;
        forbiddenForumReqMsg.setTag(this.f61292a);
        MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
    }

    public void k(b bVar) {
        this.f61295d = bVar;
    }
}
