package d.b.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.AfdSyncRequestMessage;
import com.baidu.afd.AfdSyncResponseMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class g implements j {

    /* renamed from: a  reason: collision with root package name */
    public d f43246a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43247b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpMessageListener f43248c;

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
                g.this.f43246a.u(eVar);
                if (!eVar.f43242a || eVar.f43245d == null) {
                    return;
                }
                d.b.j0.s2.f0.e.b().d(d.b.j0.s2.f0.h.o(g.this.f43246a, eVar.f43245d));
            }
        }
    }

    public g(d dVar) {
        a aVar = new a(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        this.f43248c = aVar;
        this.f43246a = dVar;
        aVar.setSelfListener(true);
        this.f43248c.setTag(dVar.s());
        MessageManager.getInstance().registerListener(this.f43248c);
    }

    @Override // d.b.d.j
    public void a() {
        if (this.f43247b) {
            return;
        }
        this.f43247b = true;
        AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.f43246a.f43240g);
        afdSyncRequestMessage.setTag(this.f43246a.s());
        MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
    }
}
