package d.a.j0.x2;

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
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC1669b f62649a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f62650b;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (b.this.f62649a == null) {
                return;
            }
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                b.this.f62649a.onFailure();
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                b.this.f62649a.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
            }
        }
    }

    /* renamed from: d.a.j0.x2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1669b {
        void a(boolean z, PostPrefixData postPrefixData);

        void onFailure();
    }

    public b(BaseActivity baseActivity, InterfaceC1669b interfaceC1669b) {
        this.f62650b = baseActivity;
        this.f62649a = interfaceC1669b;
        c();
    }

    public void b(String str) {
        if (this.f62650b == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
        httpMessage.addParam("fname", str);
        this.f62650b.sendMessage(httpMessage);
    }

    public void c() {
        if (this.f62650b == null) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/f/forum/getprefix");
        tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        this.f62650b.registerListener(new a(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD));
    }
}
