package d.a.n0.h0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.easterEgg.RnSyncResponseMessage;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.h0.e.a f59052a;

    /* renamed from: b  reason: collision with root package name */
    public b f59053b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f59054c = new a(CmdConfigHttp.CMD_GET_RN_SYNC);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof RnSyncResponseMessage) {
                RnSyncResponseMessage rnSyncResponseMessage = (RnSyncResponseMessage) httpResponsedMessage;
                d.this.f59052a = rnSyncResponseMessage.getData();
                if (d.this.f59053b != null) {
                    d.this.f59053b.a(rnSyncResponseMessage.isSuccess(), rnSyncResponseMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, d.a.n0.h0.e.a aVar);
    }

    public d() {
        MessageManager.getInstance().registerListener(this.f59054c);
    }

    public void c() {
        MessageManager.getInstance().unRegisterListener(this.f59054c);
    }

    public void d(b bVar) {
        this.f59053b = bVar;
    }

    public void e() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_RN_SYNC));
    }
}
