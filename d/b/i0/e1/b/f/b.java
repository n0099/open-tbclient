package d.b.i0.e1.b.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import d.b.b.a.f;
import d.b.h0.r.s.h;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public j f54405a;

    /* renamed from: b  reason: collision with root package name */
    public l f54406b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f54407c;

    /* renamed from: d  reason: collision with root package name */
    public h f54408d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.e1.b.f.a f54409e;

    /* renamed from: f  reason: collision with root package name */
    public c f54410f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f54411g = new C1236b();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.b.h0.r.s.l.c
        public void onClick() {
            b.this.d();
        }
    }

    /* renamed from: d.b.i0.e1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1236b implements l.d {
        public C1236b() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f54410f != null) {
                b.this.f54410f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f54406b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f54406b);
        this.f54408d = hVar;
        hVar.m(this.f54411g);
        ArrayList arrayList = new ArrayList();
        this.f54407c = arrayList;
        arrayList.add(this.f54408d);
        this.f54406b.m(new a());
        this.f54406b.k(this.f54407c);
        this.f54405a = new j(fVar, this.f54406b);
        e();
        f();
    }

    public final void c() {
        if (this.f54409e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f54409e.f54401a);
        httpMessage.addParam("thread_id", this.f54409e.f54402b);
        httpMessage.addParam("post_id", this.f54409e.f54403c);
        httpMessage.addParam("ori_ugc_nid", this.f54409e.f54404d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f54405a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f54405a.dismiss();
    }

    public void e() {
        l lVar = this.f54406b;
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

    public void g(d.b.i0.e1.b.f.a aVar) {
        this.f54409e = aVar;
    }

    public void h(c cVar) {
        this.f54410f = cVar;
    }

    public void i() {
        j jVar = this.f54405a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
