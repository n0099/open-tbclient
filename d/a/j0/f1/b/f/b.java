package d.a.j0.f1.b.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import d.a.c.a.f;
import d.a.i0.r.s.h;
import d.a.i0.r.s.j;
import d.a.i0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public j f54149a;

    /* renamed from: b  reason: collision with root package name */
    public l f54150b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f54151c;

    /* renamed from: d  reason: collision with root package name */
    public h f54152d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.f1.b.f.a f54153e;

    /* renamed from: f  reason: collision with root package name */
    public c f54154f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f54155g = new C1258b();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.a.i0.r.s.l.c
        public void onClick() {
            b.this.d();
        }
    }

    /* renamed from: d.a.j0.f1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1258b implements l.d {
        public C1258b() {
        }

        @Override // d.a.i0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f54154f != null) {
                b.this.f54154f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f54150b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f54150b);
        this.f54152d = hVar;
        hVar.m(this.f54155g);
        ArrayList arrayList = new ArrayList();
        this.f54151c = arrayList;
        arrayList.add(this.f54152d);
        this.f54150b.m(new a());
        this.f54150b.k(this.f54151c);
        this.f54149a = new j(fVar, this.f54150b);
        e();
        f();
    }

    public final void c() {
        if (this.f54153e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f54153e.f54145a);
        httpMessage.addParam("thread_id", this.f54153e.f54146b);
        httpMessage.addParam("post_id", this.f54153e.f54147c);
        httpMessage.addParam("ori_ugc_nid", this.f54153e.f54148d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f54149a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f54149a.dismiss();
    }

    public void e() {
        l lVar = this.f54150b;
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

    public void g(d.a.j0.f1.b.f.a aVar) {
        this.f54153e = aVar;
    }

    public void h(c cVar) {
        this.f54154f = cVar;
    }

    public void i() {
        j jVar = this.f54149a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
