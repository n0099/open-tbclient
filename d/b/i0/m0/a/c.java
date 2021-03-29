package d.b.i0.m0.a;

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
    public TbPageContext f56816a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f56817b;

    /* renamed from: c  reason: collision with root package name */
    public b f56818c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f56819d;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null) {
                return;
            }
            boolean z = httpResponsedMessage.getOrginalMessage().getTag() == c.this.f56817b;
            if (c.this.f56818c != null) {
                c.this.f56818c.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, boolean z);
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        a aVar = new a(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS);
        this.f56819d = aVar;
        this.f56816a = tbPageContext;
        this.f56817b = bdUniqueId;
        aVar.setTag(bdUniqueId);
        this.f56816a.registerListener(this.f56819d);
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
        httpMessage.setTag(this.f56817b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(b bVar) {
        this.f56818c = bVar;
    }
}
