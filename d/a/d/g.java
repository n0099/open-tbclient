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
    public d f40480a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40481b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f40482c;

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
                g.this.f40480a.u(eVar);
                if (!eVar.f40476a || eVar.f40479d == null) {
                    return;
                }
                d.a.j0.s2.h0.e.b().d(d.a.j0.s2.h0.h.o(g.this.f40480a, eVar.f40479d));
            }
        }
    }

    public g(d dVar) {
        a aVar = new a(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        this.f40482c = aVar;
        this.f40480a = dVar;
        aVar.setSelfListener(true);
        this.f40482c.setTag(dVar.s());
        MessageManager.getInstance().registerListener(this.f40482c);
    }

    @Override // d.a.d.j
    public void a() {
        if (this.f40481b) {
            return;
        }
        this.f40481b = true;
        AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.f40480a.f40473g);
        afdSyncRequestMessage.setTag(this.f40480a.s());
        MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
    }
}
