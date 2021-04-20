package d.b.i0.g0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.easterEgg.RnSyncResponseMessage;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.g0.e.a f56071a;

    /* renamed from: b  reason: collision with root package name */
    public b f56072b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f56073c = new a(CmdConfigHttp.CMD_GET_RN_SYNC);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof RnSyncResponseMessage) {
                RnSyncResponseMessage rnSyncResponseMessage = (RnSyncResponseMessage) httpResponsedMessage;
                d.this.f56071a = rnSyncResponseMessage.getData();
                if (d.this.f56072b != null) {
                    d.this.f56072b.a(rnSyncResponseMessage.isSuccess(), rnSyncResponseMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, d.b.i0.g0.e.a aVar);
    }

    public d() {
        MessageManager.getInstance().registerListener(this.f56073c);
    }

    public void c() {
        MessageManager.getInstance().unRegisterListener(this.f56073c);
    }

    public void d(b bVar) {
        this.f56072b = bVar;
    }

    public void e() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_RN_SYNC));
    }
}
