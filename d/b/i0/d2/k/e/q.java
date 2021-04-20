package d.b.i0.d2.k.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.ApplyCopyThreadResponseMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public PbModel f54221a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f54222b;

    /* renamed from: c  reason: collision with root package name */
    public b f54223c = null;

    /* renamed from: d  reason: collision with root package name */
    public final HttpMessageListener f54224d;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    q.this.f54223c.a(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                q.this.f54223c.a(errorCode, errorMessage, tid);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str, String str2);
    }

    public q(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        a aVar = new a(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        this.f54224d = aVar;
        this.f54221a = pbModel;
        this.f54222b = baseFragmentActivity;
        baseFragmentActivity.registerListener(aVar);
    }

    public void b(int i) {
        if (this.f54221a == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        httpMessage.addParam("thread_id", this.f54221a.O0());
        httpMessage.addParam("status", String.valueOf(i));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void c(b bVar) {
        this.f54223c = bVar;
    }
}
