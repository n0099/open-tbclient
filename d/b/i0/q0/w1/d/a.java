package d.b.i0.q0.w1.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.model.FrsAddSubCommentResponseMessage;
import com.baidu.tieba.frs.gamesubpb.model.FrsDeleteSubCommentResponseMessage;
import com.baidu.tieba.frs.gamesubpb.model.FrsSelectSubCommentReponseMessage;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameSubPbActivity f60340a;

    /* renamed from: b  reason: collision with root package name */
    public d f60341b;

    /* renamed from: e  reason: collision with root package name */
    public String f60344e;

    /* renamed from: f  reason: collision with root package name */
    public int f60345f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60347h;
    public boolean i;

    /* renamed from: d  reason: collision with root package name */
    public String f60343d = "0";

    /* renamed from: g  reason: collision with root package name */
    public int f60346g = 1;
    public HttpMessageListener j = new C1509a(0);
    public HttpMessageListener k = new b(0);
    public HttpMessageListener l = new c(0);

    /* renamed from: c  reason: collision with root package name */
    public List<n> f60342c = new ArrayList();

    /* renamed from: d.b.i0.q0.w1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1509a extends HttpMessageListener {
        public C1509a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.f60341b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsSelectSubCommentReponseMessage)) {
                FrsSelectSubCommentReponseMessage frsSelectSubCommentReponseMessage = (FrsSelectSubCommentReponseMessage) httpResponsedMessage;
                if (frsSelectSubCommentReponseMessage.getSelectSubCommentData() != null) {
                    if (1003379 == httpResponsedMessage.getCmd()) {
                        a.this.f60347h = frsSelectSubCommentReponseMessage.getSelectSubCommentData().f60354b;
                        if (!a.this.i || 1 == frsSelectSubCommentReponseMessage.getSelectSubCommentData().f60353a) {
                            a.this.f60342c.clear();
                        } else {
                            a.f(a.this);
                        }
                        if (!ListUtils.isEmpty(frsSelectSubCommentReponseMessage.getSelectSubCommentData().f60356d)) {
                            a.this.f60342c.addAll(frsSelectSubCommentReponseMessage.getSelectSubCommentData().f60356d);
                        }
                        a.this.f60341b.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.f60347h, a.this.i, frsSelectSubCommentReponseMessage.getSelectSubCommentData().f60355c, a.this.f60342c);
                    }
                    a.this.i = false;
                }
            }
            a.this.f60341b.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), false, a.this.i, null, null);
            a.this.i = false;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.f60341b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsAddSubCommentResponseMessage)) {
                FrsAddSubCommentResponseMessage frsAddSubCommentResponseMessage = (FrsAddSubCommentResponseMessage) httpResponsedMessage;
                if (frsAddSubCommentResponseMessage.getSubCommentData() != null) {
                    if (1003380 == httpResponsedMessage.getCmd()) {
                        a.this.f60341b.b(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsAddSubCommentResponseMessage.getSubCommentData());
                        return;
                    }
                    return;
                }
            }
            a.this.f60341b.b(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.f60341b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsDeleteSubCommentResponseMessage)) {
                FrsDeleteSubCommentResponseMessage frsDeleteSubCommentResponseMessage = (FrsDeleteSubCommentResponseMessage) httpResponsedMessage;
                if (frsDeleteSubCommentResponseMessage.getSubCommentData() != null) {
                    if (1003381 == httpResponsedMessage.getCmd()) {
                        a.this.f60341b.c(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsDeleteSubCommentResponseMessage.getSubCommentData());
                        return;
                    }
                    return;
                }
            }
            a.this.f60341b.c(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i, String str, boolean z2, boolean z3, d.b.i0.q0.w1.d.b bVar, List<n> list);

        void b(boolean z, int i, String str, d.b.i0.q0.w1.d.d dVar);

        void c(boolean z, int i, String str, d.b.i0.q0.w1.d.d dVar);
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, int i, String str) {
        this.f60340a = frsGameSubPbActivity;
        this.f60345f = i;
        this.f60344e = str;
        k();
        i();
        j();
    }

    public static /* synthetic */ int f(a aVar) {
        int i = aVar.f60346g;
        aVar.f60346g = i + 1;
        return i;
    }

    public void h(boolean z) {
        if (!z || this.f60347h) {
            this.i = z;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_SUB_COMMENT);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 1 + this.f60346g : 1);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("forum_id", this.f60345f);
            httpMessage.addParam("main_tower_id", this.f60344e);
            httpMessage.addParam(ImageViewerConfig.LAST_ID, this.f60343d);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void i() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/addSubComment");
        tbHttpMessageTask.setResponsedClass(FrsAddSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f60340a.registerListener(CmdConfigHttp.CMD_ADD_SUB_COMMENT, this.k);
    }

    public final void j() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/deleteSubComment");
        tbHttpMessageTask.setResponsedClass(FrsDeleteSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f60340a.registerListener(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, this.l);
    }

    public final void k() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/selectSubComment");
        tbHttpMessageTask.setResponsedClass(FrsSelectSubCommentReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f60340a.registerListener(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, this.j);
    }

    public void l(d dVar) {
        this.f60341b = dVar;
    }

    public void m(String str) {
        this.f60343d = str;
    }
}
