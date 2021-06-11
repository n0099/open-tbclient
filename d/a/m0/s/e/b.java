package d.a.m0.s.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import d.a.m0.s.c.n;
import d.a.m0.s.c.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public o f54282a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1210b f54283b;

    /* renamed from: c  reason: collision with root package name */
    public int f54284c;

    /* renamed from: d  reason: collision with root package name */
    public int f54285d;

    /* renamed from: e  reason: collision with root package name */
    public n f54286e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f54287f = new a(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.f54282a = channelConfigResponseMessage.getData();
                if (b.this.f54283b != null) {
                    b.this.f54283b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: d.a.m0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1210b {
        void a(boolean z, o oVar);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.f54287f);
        this.f54284c = d.a.m0.r.d0.b.j().k("key_common_category_version", 0);
        this.f54285d = d.a.m0.r.d0.b.j().k("key_special_category_version", 0);
    }

    public n c() {
        n nVar = this.f54286e;
        if (nVar != null) {
            return nVar;
        }
        if (this.f54282a == null) {
            return null;
        }
        n nVar2 = new n();
        o oVar = this.f54282a;
        if (oVar != null && oVar.b() != null && this.f54285d < this.f54282a.b().e()) {
            nVar2.g(this.f54282a.b().a());
            nVar2.h(this.f54282a.b().b());
            nVar2.i(this.f54282a.b().c());
            nVar2.j(this.f54282a.b().d());
            nVar2.f(n.f54171h);
        } else {
            o oVar2 = this.f54282a;
            if (oVar2 != null && oVar2.a() > 0 && this.f54284c < this.f54282a.a()) {
                nVar2.f(n.f54170g);
            } else {
                nVar2.f(n.f54169f);
            }
        }
        this.f54286e = nVar2;
        return nVar2;
    }

    public void d(int i2) {
        if (i2 == n.f54171h) {
            if (this.f54282a.b() != null) {
                d.a.m0.r.d0.b.j().v("key_special_category_version", this.f54282a.b().e());
            }
        } else if (i2 == n.f54170g) {
            d.a.m0.r.d0.b.j().v("key_common_category_version", this.f54282a.a());
        }
    }

    public void e() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }
}
