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
    public BdUniqueId f61293a;

    /* renamed from: b  reason: collision with root package name */
    public int f61294b = 1;

    /* renamed from: c  reason: collision with root package name */
    public d f61295c;

    /* renamed from: d  reason: collision with root package name */
    public b f61296d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.c.g.a f61297e;

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
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f61293a) {
                if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                    pageData = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
                } else {
                    pageData = responsedMessage instanceof ForbiddenForumSocketResMsg ? ((ForbiddenForumSocketResMsg) responsedMessage).getPageData() : null;
                }
                if (responsedMessage.getError() == 0) {
                    if (c.this.f61294b == 1 && (pageData == null || ListUtils.isEmpty(pageData.f61299a))) {
                        if (c.this.f61296d != null) {
                            c.this.f61296d.a(null);
                        }
                    } else if (pageData != null) {
                        c.this.f61295c.f61299a.addAll(pageData.f61299a);
                        if (ListUtils.isEmpty(pageData.f61299a)) {
                            c.this.f61295c.f61300b = false;
                        } else {
                            c.this.f61295c.f61300b = pageData.f61300b;
                            c.c(c.this);
                        }
                        if (c.this.f61296d != null) {
                            c.this.f61296d.a(pageData);
                        }
                    }
                } else if (c.this.f61296d != null) {
                    c.this.f61296d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
        this.f61297e = aVar;
        this.f61293a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f61297e);
        i();
        h();
        this.f61295c = new d();
    }

    public static /* synthetic */ int c(c cVar) {
        int i = cVar.f61294b;
        cVar.f61294b = i + 1;
        return i;
    }

    public void f(String str) {
        String str2;
        d dVar = this.f61295c;
        if (dVar == null || ListUtils.isEmpty(dVar.f61299a)) {
            return;
        }
        for (d.b.i0.u2.a.b bVar : this.f61295c.f61299a) {
            if (bVar != null && (str2 = bVar.f61292c) != null && str2.equals(str)) {
                this.f61295c.f61299a.remove(bVar);
                return;
            }
        }
    }

    public d g() {
        return this.f61295c;
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
        forbiddenForumReqMsg.pageNum = this.f61294b;
        forbiddenForumReqMsg.setTag(this.f61293a);
        MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
    }

    public void k(b bVar) {
        this.f61296d = bVar;
    }
}
