package d.b.i0.x2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.sharewrite.ForumPrefixResponsedMessage;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1709b f63957a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f63958b;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (b.this.f63957a == null) {
                return;
            }
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                b.this.f63957a.onFailure();
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                b.this.f63957a.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
            }
        }
    }

    /* renamed from: d.b.i0.x2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1709b {
        void a(boolean z, PostPrefixData postPrefixData);

        void onFailure();
    }

    public b(BaseActivity baseActivity, InterfaceC1709b interfaceC1709b) {
        this.f63958b = baseActivity;
        this.f63957a = interfaceC1709b;
        c();
    }

    public void b(String str) {
        if (this.f63958b == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
        httpMessage.addParam("fname", str);
        this.f63958b.sendMessage(httpMessage);
    }

    public void c() {
        if (this.f63958b == null) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/f/forum/getprefix");
        tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        this.f63958b.registerListener(new a(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD));
    }
}
