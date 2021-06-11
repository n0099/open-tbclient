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
    public d f43222a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43223b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f43224c;

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
                g.this.f43222a.q(eVar);
                if (!eVar.f43218a || eVar.f43221d == null) {
                    return;
                }
                d.a.n0.t2.i0.e.b().d(d.a.n0.t2.i0.g.o(g.this.f43222a, eVar.f43221d));
            }
        }
    }

    public g(d dVar) {
        a aVar = new a(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        this.f43224c = aVar;
        this.f43222a = dVar;
        aVar.setSelfListener(true);
        this.f43224c.setTag(dVar.o());
        MessageManager.getInstance().registerListener(this.f43224c);
    }

    @Override // d.a.d.j
    public void a() {
        if (this.f43223b) {
            return;
        }
        this.f43223b = true;
        AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.f43222a.f43215g);
        afdSyncRequestMessage.setTag(this.f43222a.o());
        MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
    }
}
