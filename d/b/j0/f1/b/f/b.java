package d.b.j0.f1.b.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.DelReplyAtMsgResMsg;
import d.b.c.a.f;
import d.b.i0.r.s.h;
import d.b.i0.r.s.j;
import d.b.i0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public j f56268a;

    /* renamed from: b  reason: collision with root package name */
    public l f56269b;

    /* renamed from: c  reason: collision with root package name */
    public List<h> f56270c;

    /* renamed from: d  reason: collision with root package name */
    public h f56271d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.f1.b.f.a f56272e;

    /* renamed from: f  reason: collision with root package name */
    public c f56273f;

    /* renamed from: g  reason: collision with root package name */
    public l.d f56274g = new C1319b();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.b.i0.r.s.l.c
        public void onClick() {
            b.this.d();
        }
    }

    /* renamed from: d.b.j0.f1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1319b implements l.d {
        public C1319b() {
        }

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            b.this.c();
            if (b.this.f56273f != null) {
                b.this.f56273f.a();
            }
            b.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public b(f fVar) {
        this.f56269b = new l(fVar.getPageActivity());
        h hVar = new h(fVar.getString(R.string.delete), this.f56269b);
        this.f56271d = hVar;
        hVar.m(this.f56274g);
        ArrayList arrayList = new ArrayList();
        this.f56270c = arrayList;
        arrayList.add(this.f56271d);
        this.f56269b.m(new a());
        this.f56269b.k(this.f56270c);
        this.f56268a = new j(fVar, this.f56269b);
        e();
        f();
    }

    public final void c() {
        if (this.f56272e == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
        httpMessage.addParam("type", this.f56272e.f56264a);
        httpMessage.addParam("thread_id", this.f56272e.f56265b);
        httpMessage.addParam("post_id", this.f56272e.f56266c);
        httpMessage.addParam("ori_ugc_nid", this.f56272e.f56267d);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void d() {
        j jVar = this.f56268a;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f56268a.dismiss();
    }

    public void e() {
        l lVar = this.f56269b;
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

    public void g(d.b.j0.f1.b.f.a aVar) {
        this.f56272e = aVar;
    }

    public void h(c cVar) {
        this.f56273f = cVar;
    }

    public void i() {
        j jVar = this.f56268a;
        if (jVar != null) {
            jVar.show();
        }
    }
}
