package d.b.i0.f1.b.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import d.b.c.a.f;
import d.b.h0.r.s.h;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public j f55847a;

    /* renamed from: b  reason: collision with root package name */
    public l f55848b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f55849c;

    /* renamed from: d  reason: collision with root package name */
    public h f55850d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.f1.b.f.a f55851e;

    /* renamed from: f  reason: collision with root package name */
    public c f55852f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f55853g = new C1296b();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.b.h0.r.s.l.c
        public void onClick() {
            b.this.d();
        }
    }

    /* renamed from: d.b.i0.f1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1296b implements l.d {
        public C1296b() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f55852f != null) {
                b.this.f55852f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f55848b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f55848b);
        this.f55850d = hVar;
        hVar.m(this.f55853g);
        ArrayList arrayList = new ArrayList();
        this.f55849c = arrayList;
        arrayList.add(this.f55850d);
        this.f55848b.m(new a());
        this.f55848b.k(this.f55849c);
        this.f55847a = new j(fVar, this.f55848b);
        e();
        f();
    }

    public final void c() {
        if (this.f55851e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f55851e.f55843a);
        httpMessage.addParam("thread_id", this.f55851e.f55844b);
        httpMessage.addParam("post_id", this.f55851e.f55845c);
        httpMessage.addParam("ori_ugc_nid", this.f55851e.f55846d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f55847a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f55847a.dismiss();
    }

    public void e() {
        l lVar = this.f55848b;
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

    public void g(d.b.i0.f1.b.f.a aVar) {
        this.f55851e = aVar;
    }

    public void h(c cVar) {
        this.f55852f = cVar;
    }

    public void i() {
        j jVar = this.f55847a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
