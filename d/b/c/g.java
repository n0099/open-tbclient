package d.b.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.AfdSyncRequestMessage;
import com.baidu.afd.AfdSyncResponseMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class g implements j {

    /* renamed from: a  reason: collision with root package name */
    public d f42495a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42496b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f42497c;

    /* loaded from: classes.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                g.this.f42495a.u(eVar);
                if (!eVar.f42491a || eVar.f42494d == null) {
                    return;
                }
                d.b.i0.r2.b0.e.b().d(d.b.i0.r2.b0.h.o(g.this.f42495a, eVar.f42494d));
            }
        }
    }

    public g(d dVar) {
        a aVar = new a(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        this.f42497c = aVar;
        this.f42495a = dVar;
        aVar.setSelfListener(true);
        this.f42497c.setTag(dVar.s());
        MessageManager.getInstance().registerListener(this.f42497c);
    }

    @Override // d.b.c.j
    public void a() {
        if (this.f42496b) {
            return;
        }
        this.f42496b = true;
        AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.f42495a.f42489g);
        afdSyncRequestMessage.setTag(this.f42495a.s());
        MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
    }
}
