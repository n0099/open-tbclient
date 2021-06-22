package d.a.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.AfdSyncRequestMessage;
import com.baidu.afd.AfdSyncResponseMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class g implements j {

    /* renamed from: a  reason: collision with root package name */
    public d f43325a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43326b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f43327c;

    /* loaded from: classes.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                g.this.f43325a.q(eVar);
                if (!eVar.f43321a || eVar.f43324d == null) {
                    return;
                }
                d.a.o0.t2.i0.e.b().d(d.a.o0.t2.i0.g.o(g.this.f43325a, eVar.f43324d));
            }
        }
    }

    public g(d dVar) {
        a aVar = new a(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        this.f43327c = aVar;
        this.f43325a = dVar;
        aVar.setSelfListener(true);
        this.f43327c.setTag(dVar.o());
        MessageManager.getInstance().registerListener(this.f43327c);
    }

    @Override // d.a.d.j
    public void a() {
        if (this.f43326b) {
            return;
        }
        this.f43326b = true;
        AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.f43325a.f43318g);
        afdSyncRequestMessage.setTag(this.f43325a.o());
        MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
    }
}
