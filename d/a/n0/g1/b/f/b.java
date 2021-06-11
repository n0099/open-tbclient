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
    public j f58733a;

    /* renamed from: b  reason: collision with root package name */
    public l f58734b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f58735c;

    /* renamed from: d  reason: collision with root package name */
    public h f58736d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.g1.b.f.a f58737e;

    /* renamed from: f  reason: collision with root package name */
    public c f58738f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f58739g = new C1404b();

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
    public class C1404b implements l.d {
        public C1404b() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f58738f != null) {
                b.this.f58738f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f58734b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f58734b);
        this.f58736d = hVar;
        hVar.m(this.f58739g);
        ArrayList arrayList = new ArrayList();
        this.f58735c = arrayList;
        arrayList.add(this.f58736d);
        this.f58734b.m(new a());
        this.f58734b.k(this.f58735c);
        this.f58733a = new j(fVar, this.f58734b);
        e();
        f();
    }

    public final void c() {
        if (this.f58737e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f58737e.f58729a);
        httpMessage.addParam("thread_id", this.f58737e.f58730b);
        httpMessage.addParam("post_id", this.f58737e.f58731c);
        httpMessage.addParam("ori_ugc_nid", this.f58737e.f58732d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f58733a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f58733a.dismiss();
    }

    public void e() {
        l lVar = this.f58734b;
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
        this.f58737e = aVar;
    }

    public void h(c cVar) {
        this.f58738f = cVar;
    }

    public void i() {
        j jVar = this.f58733a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
