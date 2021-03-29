package d.b.i0.c2.k.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.ApplyCopyThreadResponseMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public PbModel f52736a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f52737b;

    /* renamed from: c  reason: collision with root package name */
    public b f52738c = null;

    /* renamed from: d  reason: collision with root package name */
    public final HttpMessageListener f52739d;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003066 && (httpResponsedMessage instanceof ApplyCopyThreadResponseMessage)) {
                if (httpResponsedMessage.getStatusCode() != 200) {
                    o.this.f52738c.a(-1, null, null);
                    return;
                }
                ApplyCopyThreadResponseMessage applyCopyThreadResponseMessage = (ApplyCopyThreadResponseMessage) httpResponsedMessage;
                String errorMessage = applyCopyThreadResponseMessage.getErrorMessage();
                int errorCode = applyCopyThreadResponseMessage.getErrorCode();
                String tid = applyCopyThreadResponseMessage.getTid();
                if (errorCode == 0) {
                    errorMessage = applyCopyThreadResponseMessage.getRemindMessage();
                }
                o.this.f52738c.a(errorCode, errorMessage, tid);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, String str2);
    }

    public o(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        a aVar = new a(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        this.f52739d = aVar;
        this.f52736a = pbModel;
        this.f52737b = baseFragmentActivity;
        baseFragmentActivity.registerListener(aVar);
    }

    public void b(int i) {
        if (this.f52736a == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        httpMessage.addParam("thread_id", this.f52736a.O0());
        httpMessage.addParam("status", String.valueOf(i));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void c(b bVar) {
        this.f52738c = bVar;
    }
}
