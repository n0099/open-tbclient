package d.b.i0.v2.a;

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
    public BdUniqueId f63031a;

    /* renamed from: b  reason: collision with root package name */
    public int f63032b = 1;

    /* renamed from: c  reason: collision with root package name */
    public d f63033c;

    /* renamed from: d  reason: collision with root package name */
    public b f63034d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.g.a f63035e;

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
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.f63031a) {
                if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                    pageData = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
                } else {
                    pageData = responsedMessage instanceof ForbiddenForumSocketResMsg ? ((ForbiddenForumSocketResMsg) responsedMessage).getPageData() : null;
                }
                if (responsedMessage.getError() == 0) {
                    if (c.this.f63032b == 1 && (pageData == null || ListUtils.isEmpty(pageData.f63037a))) {
                        if (c.this.f63034d != null) {
                            c.this.f63034d.a(null);
                        }
                    } else if (pageData != null) {
                        c.this.f63033c.f63037a.addAll(pageData.f63037a);
                        if (ListUtils.isEmpty(pageData.f63037a)) {
                            c.this.f63033c.f63038b = false;
                        } else {
                            c.this.f63033c.f63038b = pageData.f63038b;
                            c.c(c.this);
                        }
                        if (c.this.f63034d != null) {
                            c.this.f63034d.a(pageData);
                        }
                    }
                } else if (c.this.f63034d != null) {
                    c.this.f63034d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
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
        this.f63035e = aVar;
        this.f63031a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f63035e);
        i();
        h();
        this.f63033c = new d();
    }

    public static /* synthetic */ int c(c cVar) {
        int i = cVar.f63032b;
        cVar.f63032b = i + 1;
        return i;
    }

    public void f(String str) {
        String str2;
        d dVar = this.f63033c;
        if (dVar == null || ListUtils.isEmpty(dVar.f63037a)) {
            return;
        }
        for (d.b.i0.v2.a.b bVar : this.f63033c.f63037a) {
            if (bVar != null && (str2 = bVar.f63030c) != null && str2.equals(str)) {
                this.f63033c.f63037a.remove(bVar);
                return;
            }
        }
    }

    public d g() {
        return this.f63033c;
    }

    public final void h() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, d.b.i0.d3.d0.a.a(TbConfig.URL_GET_FORBIDDEN_FORUM, 309692));
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
        forbiddenForumReqMsg.pageNum = this.f63032b;
        forbiddenForumReqMsg.setTag(this.f63031a);
        MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
    }

    public void k(b bVar) {
        this.f63034d = bVar;
    }
}
