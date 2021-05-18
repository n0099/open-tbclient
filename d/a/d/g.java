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
    public d f39725a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39726b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f39727c;

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
                g.this.f39725a.u(eVar);
                if (!eVar.f39721a || eVar.f39724d == null) {
                    return;
                }
                d.a.k0.s2.i0.e.b().d(d.a.k0.s2.i0.g.o(g.this.f39725a, eVar.f39724d));
            }
        }
    }

    public g(d dVar) {
        a aVar = new a(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        this.f39727c = aVar;
        this.f39725a = dVar;
        aVar.setSelfListener(true);
        this.f39727c.setTag(dVar.s());
        MessageManager.getInstance().registerListener(this.f39727c);
    }

    @Override // d.a.d.j
    public void a() {
        if (this.f39726b) {
            return;
        }
        this.f39726b = true;
        AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.f39725a.f39718g);
        afdSyncRequestMessage.setTag(this.f39725a.s());
        MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
    }
}
