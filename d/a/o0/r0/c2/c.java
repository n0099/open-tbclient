package d.a.o0.r0.c2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.live.FrsLiveTipResponseMessage;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public b f62246a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f62247b = new a(CmdConfigHttp.FRS_LIVE_TIP_CMD);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof FrsLiveTipResponseMessage) || httpResponsedMessage.getError() != 0 || c.this.f62246a == null) {
                return;
            }
            c.this.f62246a.a((FrsLiveTipResponseMessage) httpResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage);
    }

    public c(b bVar) {
        this.f62246a = bVar;
        d();
        MessageManager.getInstance().registerListener(this.f62247b);
    }

    public void b(int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_LIVE_TIP_CMD);
        httpMessage.addParam("forum_id", i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void c() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_LIVE_TIP_CMD);
        MessageManager.getInstance().unRegisterListener(this.f62247b);
    }

    public final void d() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LIVE_TIP_CMD, TbConfig.FRS_LIVE_TIP_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsLiveTipResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
