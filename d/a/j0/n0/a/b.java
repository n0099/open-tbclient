package d.a.j0.n0.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.forbidden.fans.GetForbiddenFansResponse;
import d.a.i0.r.q.z0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public z0 f56884a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.j0.n0.a.a> f56885b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC1360b f56886c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f56887d = new a(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                b.this.f56884a = getForbiddenFansResponse.getPageData();
                if (b.this.f56885b == null) {
                    b.this.f56885b = new ArrayList();
                }
                if (b.this.f56884a != null) {
                    if (b.this.f56884a.a() == 1) {
                        b.this.f56885b.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        b.this.f56885b.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (b.this.f56886c != null) {
                    b.this.f56886c.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), b.this.f56885b);
                }
            }
        }
    }

    /* renamed from: d.a.j0.n0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1360b {
        void a(int i2, String str, ArrayList<d.a.j0.n0.a.a> arrayList);
    }

    public b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.GET_FORBIDDEN_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetForbiddenFansResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f56887d);
    }

    public boolean f() {
        z0 z0Var = this.f56884a;
        return z0Var != null && z0Var.b() == 1;
    }

    public void g() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void h() {
        z0 z0Var = this.f56884a;
        if (z0Var == null || z0Var.b() == 1) {
            z0 z0Var2 = this.f56884a;
            int a2 = z0Var2 != null ? 1 + z0Var2.a() : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, a2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void i() {
        MessageManager.getInstance().unRegisterListener(this.f56887d);
    }

    public void j(InterfaceC1360b interfaceC1360b) {
        this.f56886c = interfaceC1360b;
    }
}
