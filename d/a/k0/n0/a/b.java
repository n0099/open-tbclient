package d.a.k0.n0.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.forbidden.fans.GetForbiddenFansResponse;
import d.a.j0.r.q.z0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public z0 f57591a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.k0.n0.a.a> f57592b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC1432b f57593c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f57594d = new a(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);

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
                b.this.f57591a = getForbiddenFansResponse.getPageData();
                if (b.this.f57592b == null) {
                    b.this.f57592b = new ArrayList();
                }
                if (b.this.f57591a != null) {
                    if (b.this.f57591a.a() == 1) {
                        b.this.f57592b.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        b.this.f57592b.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (b.this.f57593c != null) {
                    b.this.f57593c.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), b.this.f57592b);
                }
            }
        }
    }

    /* renamed from: d.a.k0.n0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1432b {
        void a(int i2, String str, ArrayList<d.a.k0.n0.a.a> arrayList);
    }

    public b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.GET_FORBIDDEN_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetForbiddenFansResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f57594d);
    }

    public boolean f() {
        z0 z0Var = this.f57591a;
        return z0Var != null && z0Var.b() == 1;
    }

    public void g() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void h() {
        z0 z0Var = this.f57591a;
        if (z0Var == null || z0Var.b() == 1) {
            z0 z0Var2 = this.f57591a;
            int a2 = z0Var2 != null ? 1 + z0Var2.a() : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, a2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void i() {
        MessageManager.getInstance().unRegisterListener(this.f57594d);
    }

    public void j(InterfaceC1432b interfaceC1432b) {
        this.f57593c = interfaceC1432b;
    }
}
