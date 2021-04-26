package d.a.j0.d2.k.e;

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
    public PbModel f52451a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f52452b;

    /* renamed from: c  reason: collision with root package name */
    public b f52453c = null;

    /* renamed from: d  reason: collision with root package name */
    public final HttpMessageListener f52454d;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    q.this.f52453c.a(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                q.this.f52453c.a(errorCode, errorMessage, tid);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, String str, String str2);
    }

    public q(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        a aVar = new a(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        this.f52454d = aVar;
        this.f52451a = pbModel;
        this.f52452b = baseFragmentActivity;
        baseFragmentActivity.registerListener(aVar);
    }

    public void b(int i2) {
        if (this.f52451a == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        httpMessage.addParam("thread_id", this.f52451a.O0());
        httpMessage.addParam("status", String.valueOf(i2));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void c(b bVar) {
        this.f52453c = bVar;
    }
}
