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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public j f54406a;

    /* renamed from: b  reason: collision with root package name */
    public l f54407b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f54408c;

    /* renamed from: d  reason: collision with root package name */
    public h f54409d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.e1.b.f.a f54410e;

    /* renamed from: f  reason: collision with root package name */
    public c f54411f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f54412g = new C1237b();

    /* loaded from: classes3.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.b.h0.r.s.l.c
        public void onClick() {
            b.this.d();
        }
    }

    /* renamed from: d.b.i0.e1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1237b implements l.d {
        public C1237b() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f54411f != null) {
                b.this.f54411f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f54407b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f54407b);
        this.f54409d = hVar;
        hVar.m(this.f54412g);
        ArrayList arrayList = new ArrayList();
        this.f54408c = arrayList;
        arrayList.add(this.f54409d);
        this.f54407b.m(new a());
        this.f54407b.k(this.f54408c);
        this.f54406a = new j(fVar, this.f54407b);
        e();
        f();
    }

    public final void c() {
        if (this.f54410e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f54410e.f54402a);
        httpMessage.addParam("thread_id", this.f54410e.f54403b);
        httpMessage.addParam("post_id", this.f54410e.f54404c);
        httpMessage.addParam("ori_ugc_nid", this.f54410e.f54405d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f54406a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f54406a.dismiss();
    }

    public void e() {
        l lVar = this.f54407b;
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
        this.f54410e = aVar;
    }

    public void h(c cVar) {
        this.f54411f = cVar;
    }

    public void i() {
        j jVar = this.f54406a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
