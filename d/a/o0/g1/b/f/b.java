package d.a.o0.g1.b.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import d.a.c.a.f;
import d.a.n0.r.s.h;
import d.a.n0.r.s.j;
import d.a.n0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public j f58858a;

    /* renamed from: b  reason: collision with root package name */
    public l f58859b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f58860c;

    /* renamed from: d  reason: collision with root package name */
    public h f58861d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.g1.b.f.a f58862e;

    /* renamed from: f  reason: collision with root package name */
    public c f58863f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f58864g = new C1408b();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.a.n0.r.s.l.c
        public void onClick() {
            b.this.d();
        }
    }

    /* renamed from: d.a.o0.g1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1408b implements l.d {
        public C1408b() {
        }

        @Override // d.a.n0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f58863f != null) {
                b.this.f58863f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f58859b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f58859b);
        this.f58861d = hVar;
        hVar.m(this.f58864g);
        ArrayList arrayList = new ArrayList();
        this.f58860c = arrayList;
        arrayList.add(this.f58861d);
        this.f58859b.m(new a());
        this.f58859b.k(this.f58860c);
        this.f58858a = new j(fVar, this.f58859b);
        e();
        f();
    }

    public final void c() {
        if (this.f58862e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f58862e.f58854a);
        httpMessage.addParam("thread_id", this.f58862e.f58855b);
        httpMessage.addParam("post_id", this.f58862e.f58856c);
        httpMessage.addParam("ori_ugc_nid", this.f58862e.f58857d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f58858a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f58858a.dismiss();
    }

    public void e() {
        l lVar = this.f58859b;
        if (lVar != null) {
            lVar.j();
        }
    }

    public final void f() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void g(d.a.o0.g1.b.f.a aVar) {
        this.f58862e = aVar;
    }

    public void h(c cVar) {
        this.f58863f = cVar;
    }

    public void i() {
        j jVar = this.f58858a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
