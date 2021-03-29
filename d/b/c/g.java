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
    public d f42496a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42497b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f42498c;

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
                g.this.f42496a.u(eVar);
                if (!eVar.f42492a || eVar.f42495d == null) {
                    return;
                }
                d.b.i0.r2.b0.e.b().d(d.b.i0.r2.b0.h.o(g.this.f42496a, eVar.f42495d));
            }
        }
    }

    public g(d dVar) {
        a aVar = new a(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        this.f42498c = aVar;
        this.f42496a = dVar;
        aVar.setSelfListener(true);
        this.f42498c.setTag(dVar.s());
        MessageManager.getInstance().registerListener(this.f42498c);
    }

    @Override // d.b.c.j
    public void a() {
        if (this.f42497b) {
            return;
        }
        this.f42497b = true;
        AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.f42496a.f42490g);
        afdSyncRequestMessage.setTag(this.f42496a.s());
        MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
    }
}
