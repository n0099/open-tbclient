package d.a.k0.f1.b.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import d.a.c.a.f;
import d.a.j0.r.s.h;
import d.a.j0.r.s.j;
import d.a.j0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public j f54856a;

    /* renamed from: b  reason: collision with root package name */
    public l f54857b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f54858c;

    /* renamed from: d  reason: collision with root package name */
    public h f54859d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.f1.b.f.a f54860e;

    /* renamed from: f  reason: collision with root package name */
    public c f54861f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f54862g = new C1330b();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.a.j0.r.s.l.c
        public void onClick() {
            b.this.d();
        }
    }

    /* renamed from: d.a.k0.f1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1330b implements l.d {
        public C1330b() {
        }

        @Override // d.a.j0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f54861f != null) {
                b.this.f54861f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f54857b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f54857b);
        this.f54859d = hVar;
        hVar.m(this.f54862g);
        ArrayList arrayList = new ArrayList();
        this.f54858c = arrayList;
        arrayList.add(this.f54859d);
        this.f54857b.m(new a());
        this.f54857b.k(this.f54858c);
        this.f54856a = new j(fVar, this.f54857b);
        e();
        f();
    }

    public final void c() {
        if (this.f54860e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f54860e.f54852a);
        httpMessage.addParam("thread_id", this.f54860e.f54853b);
        httpMessage.addParam("post_id", this.f54860e.f54854c);
        httpMessage.addParam("ori_ugc_nid", this.f54860e.f54855d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f54856a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f54856a.dismiss();
    }

    public void e() {
        l lVar = this.f54857b;
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

    public void g(d.a.k0.f1.b.f.a aVar) {
        this.f54860e = aVar;
    }

    public void h(c cVar) {
        this.f54861f = cVar;
    }

    public void i() {
        j jVar = this.f54856a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
