package d.a.k0.q0.w1.d;

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
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsGameSubPbActivity f59614a;

    /* renamed from: b  reason: collision with root package name */
    public d f59615b;

    /* renamed from: e  reason: collision with root package name */
    public String f59618e;

    /* renamed from: f  reason: collision with root package name */
    public int f59619f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59621h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59622i;

    /* renamed from: d  reason: collision with root package name */
    public String f59617d = "0";

    /* renamed from: g  reason: collision with root package name */
    public int f59620g = 1;
    public HttpMessageListener j = new C1545a(0);
    public HttpMessageListener k = new b(0);
    public HttpMessageListener l = new c(0);

    /* renamed from: c  reason: collision with root package name */
    public List<n> f59616c = new ArrayList();

    /* renamed from: d.a.k0.q0.w1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1545a extends HttpMessageListener {
        public C1545a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.f59615b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsSelectSubCommentReponseMessage)) {
                FrsSelectSubCommentReponseMessage frsSelectSubCommentReponseMessage = (FrsSelectSubCommentReponseMessage) httpResponsedMessage;
                if (frsSelectSubCommentReponseMessage.getSelectSubCommentData() != null) {
                    if (1003379 == httpResponsedMessage.getCmd()) {
                        a.this.f59621h = frsSelectSubCommentReponseMessage.getSelectSubCommentData().f59629b;
                        if (!a.this.f59622i || 1 == frsSelectSubCommentReponseMessage.getSelectSubCommentData().f59628a) {
                            a.this.f59616c.clear();
                        } else {
                            a.f(a.this);
                        }
                        if (!ListUtils.isEmpty(frsSelectSubCommentReponseMessage.getSelectSubCommentData().f59631d)) {
                            a.this.f59616c.addAll(frsSelectSubCommentReponseMessage.getSelectSubCommentData().f59631d);
                        }
                        a.this.f59615b.a(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), a.this.f59621h, a.this.f59622i, frsSelectSubCommentReponseMessage.getSelectSubCommentData().f59630c, a.this.f59616c);
                    }
                    a.this.f59622i = false;
                }
            }
            a.this.f59615b.a(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), false, a.this.f59622i, null, null);
            a.this.f59622i = false;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.f59615b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsAddSubCommentResponseMessage)) {
                FrsAddSubCommentResponseMessage frsAddSubCommentResponseMessage = (FrsAddSubCommentResponseMessage) httpResponsedMessage;
                if (frsAddSubCommentResponseMessage.getSubCommentData() != null) {
                    if (1003380 == httpResponsedMessage.getCmd()) {
                        a.this.f59615b.b(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsAddSubCommentResponseMessage.getSubCommentData());
                        return;
                    }
                    return;
                }
            }
            a.this.f59615b.b(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (a.this.f59615b == null) {
                return;
            }
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof FrsDeleteSubCommentResponseMessage)) {
                FrsDeleteSubCommentResponseMessage frsDeleteSubCommentResponseMessage = (FrsDeleteSubCommentResponseMessage) httpResponsedMessage;
                if (frsDeleteSubCommentResponseMessage.getSubCommentData() != null) {
                    if (1003381 == httpResponsedMessage.getCmd()) {
                        a.this.f59615b.c(true, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), frsDeleteSubCommentResponseMessage.getSubCommentData());
                        return;
                    }
                    return;
                }
            }
            a.this.f59615b.c(false, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), null);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i2, String str, boolean z2, boolean z3, d.a.k0.q0.w1.d.b bVar, List<n> list);

        void b(boolean z, int i2, String str, d.a.k0.q0.w1.d.d dVar);

        void c(boolean z, int i2, String str, d.a.k0.q0.w1.d.d dVar);
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, int i2, String str) {
        this.f59614a = frsGameSubPbActivity;
        this.f59619f = i2;
        this.f59618e = str;
        k();
        i();
        j();
    }

    public static /* synthetic */ int f(a aVar) {
        int i2 = aVar.f59620g;
        aVar.f59620g = i2 + 1;
        return i2;
    }

    public void h(boolean z) {
        if (!z || this.f59621h) {
            this.f59622i = z;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SELECT_SUB_COMMENT);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 1 + this.f59620g : 1);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("forum_id", this.f59619f);
            httpMessage.addParam("main_tower_id", this.f59618e);
            httpMessage.addParam(ImageViewerConfig.LAST_ID, this.f59617d);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void i() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/addSubComment");
        tbHttpMessageTask.setResponsedClass(FrsAddSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f59614a.registerListener(CmdConfigHttp.CMD_ADD_SUB_COMMENT, this.k);
    }

    public final void j() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/deleteSubComment");
        tbHttpMessageTask.setResponsedClass(FrsDeleteSubCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f59614a.registerListener(CmdConfigHttp.CMD_DELETE_SUB_COMMENT, this.l);
    }

    public final void k() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, TbConfig.SERVER_ADDRESS + "game/client/selectSubComment");
        tbHttpMessageTask.setResponsedClass(FrsSelectSubCommentReponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f59614a.registerListener(CmdConfigHttp.CMD_SELECT_SUB_COMMENT, this.j);
    }

    public void l(d dVar) {
        this.f59615b = dVar;
    }

    public void m(String str) {
        this.f59617d = str;
    }
}
