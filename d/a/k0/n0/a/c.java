package d.a.k0.n0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57596a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f57597b;

    /* renamed from: c  reason: collision with root package name */
    public b f57598c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f57599d;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            boolean z = httpResponsedMessage.getOrginalMessage().getTag() == c.this.f57597b;
            if (c.this.f57598c != null) {
                c.this.f57598c.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, boolean z);
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS);
        this.f57599d = aVar;
        this.f57596a = tbPageContext;
        this.f57597b = bdUniqueId;
        aVar.setTag(bdUniqueId);
        this.f57596a.registerListener(this.f57599d);
        c();
    }

    public final void c() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.REMOVE_MULTI_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void d() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS);
        httpMessage.setTag(this.f57597b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(b bVar) {
        this.f57598c = bVar;
    }
}
