package d.b.i0.m0.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.forbidden.fans.GetForbiddenFansResponse;
import d.b.h0.r.q.z0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public z0 f56810a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.b.i0.m0.a.a> f56811b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC1339b f56812c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f56813d = new a(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                b.this.f56810a = getForbiddenFansResponse.getPageData();
                if (b.this.f56811b == null) {
                    b.this.f56811b = new ArrayList();
                }
                if (b.this.f56810a != null) {
                    if (b.this.f56810a.a() == 1) {
                        b.this.f56811b.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        b.this.f56811b.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (b.this.f56812c != null) {
                    b.this.f56812c.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), b.this.f56811b);
                }
            }
        }
    }

    /* renamed from: d.b.i0.m0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1339b {
        void a(int i, String str, ArrayList<d.b.i0.m0.a.a> arrayList);
    }

    public b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.GET_FORBIDDEN_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetForbiddenFansResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f56813d);
    }

    public boolean f() {
        z0 z0Var = this.f56810a;
        return z0Var != null && z0Var.b() == 1;
    }

    public void g() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void h() {
        z0 z0Var = this.f56810a;
        if (z0Var == null || z0Var.b() == 1) {
            z0 z0Var2 = this.f56810a;
            int a2 = z0Var2 != null ? 1 + z0Var2.a() : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, a2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void i() {
        MessageManager.getInstance().unRegisterListener(this.f56813d);
    }

    public void j(InterfaceC1339b interfaceC1339b) {
        this.f56812c = interfaceC1339b;
    }
}
