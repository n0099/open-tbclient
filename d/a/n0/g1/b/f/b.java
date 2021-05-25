package d.a.n0.g1.b.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import d.a.c.a.f;
import d.a.m0.r.s.h;
import d.a.m0.r.s.j;
import d.a.m0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public j f55044a;

    /* renamed from: b  reason: collision with root package name */
    public l f55045b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f55046c;

    /* renamed from: d  reason: collision with root package name */
    public h f55047d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.g1.b.f.a f55048e;

    /* renamed from: f  reason: collision with root package name */
    public c f55049f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f55050g = new C1348b();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.a.m0.r.s.l.c
        public void onClick() {
            b.this.d();
        }
    }

    /* renamed from: d.a.n0.g1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1348b implements l.d {
        public C1348b() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f55049f != null) {
                b.this.f55049f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f55045b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f55045b);
        this.f55047d = hVar;
        hVar.m(this.f55050g);
        ArrayList arrayList = new ArrayList();
        this.f55046c = arrayList;
        arrayList.add(this.f55047d);
        this.f55045b.m(new a());
        this.f55045b.k(this.f55046c);
        this.f55044a = new j(fVar, this.f55045b);
        e();
        f();
    }

    public final void c() {
        if (this.f55048e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f55048e.f55040a);
        httpMessage.addParam("thread_id", this.f55048e.f55041b);
        httpMessage.addParam("post_id", this.f55048e.f55042c);
        httpMessage.addParam("ori_ugc_nid", this.f55048e.f55043d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f55044a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f55044a.dismiss();
    }

    public void e() {
        l lVar = this.f55045b;
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

    public void g(d.a.n0.g1.b.f.a aVar) {
        this.f55048e = aVar;
    }

    public void h(c cVar) {
        this.f55049f = cVar;
    }

    public void i() {
        j jVar = this.f55044a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
