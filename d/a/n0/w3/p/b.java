package d.a.n0.w3.p;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.write.share.CheckRequest;
import com.baidu.tieba.write.share.CheckResponse;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f62890a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.w3.p.a f62891b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f62892c = new a(CmdConfigHttp.CMD_CHECK_SHARE_SDK);

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof CheckResponse) {
                c checkResponseData = ((CheckResponse) httpResponsedMessage).getCheckResponseData();
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    httpResponsedMessage.setErrorString(TbadkCoreApplication.getInst().getString(R.string.share_sdk_check_no_resp));
                }
                if (b.this.f62891b != null) {
                    b.this.f62891b.a(checkResponseData, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    public b(BdUniqueId bdUniqueId) {
        this.f62890a = bdUniqueId;
        b();
    }

    public final void b() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(c());
        this.f62892c.setTag(this.f62890a);
        messageManager.registerListener(this.f62892c);
    }

    public final HttpMessageTask c() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_SHARE_SDK, TbConfig.CHECK_SHARE_SDK_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setRetry(3);
        tbHttpMessageTask.setResponsedClass(CheckResponse.class);
        return tbHttpMessageTask;
    }

    public void d(String str, String str2) {
        if (StringUtils.isNull(str)) {
            d.a.n0.w3.p.a aVar = this.f62891b;
            if (aVar != null) {
                aVar.a(null, -2112, TbadkCoreApplication.getInst().getString(R.string.check_share_sdk_appkey_null));
                return;
            }
            return;
        }
        MessageManager.getInstance().removeHttpMessage(this.f62890a);
        CheckRequest checkRequest = new CheckRequest();
        checkRequest.setTag(this.f62890a);
        checkRequest.setAppkey(str);
        checkRequest.setAppletsKey(str2);
        MessageManager.getInstance().sendMessage(checkRequest);
    }

    public void e(d.a.n0.w3.p.a aVar) {
        this.f62891b = aVar;
    }
}
