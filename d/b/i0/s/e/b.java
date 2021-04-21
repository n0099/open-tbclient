package d.b.i0.s.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import d.b.i0.s.c.n;
import d.b.i0.s.c.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public o f52054a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1131b f52055b;

    /* renamed from: c  reason: collision with root package name */
    public int f52056c;

    /* renamed from: d  reason: collision with root package name */
    public int f52057d;

    /* renamed from: e  reason: collision with root package name */
    public n f52058e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f52059f = new a(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ChannelConfigResponseMessage) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                b.this.f52054a = channelConfigResponseMessage.getData();
                if (b.this.f52055b != null) {
                    b.this.f52055b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: d.b.i0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1131b {
        void a(boolean z, o oVar);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.f52059f);
        this.f52056c = d.b.i0.r.d0.b.j().k("key_common_category_version", 0);
        this.f52057d = d.b.i0.r.d0.b.j().k("key_special_category_version", 0);
    }

    public n c() {
        n nVar = this.f52058e;
        if (nVar != null) {
            return nVar;
        }
        if (this.f52054a == null) {
            return null;
        }
        n nVar2 = new n();
        o oVar = this.f52054a;
        if (oVar != null && oVar.b() != null && this.f52057d < this.f52054a.b().e()) {
            nVar2.g(this.f52054a.b().a());
            nVar2.h(this.f52054a.b().b());
            nVar2.i(this.f52054a.b().c());
            nVar2.j(this.f52054a.b().d());
            nVar2.f(n.f51955h);
        } else {
            o oVar2 = this.f52054a;
            if (oVar2 != null && oVar2.a() > 0 && this.f52056c < this.f52054a.a()) {
                nVar2.f(n.f51954g);
            } else {
                nVar2.f(n.f51953f);
            }
        }
        this.f52058e = nVar2;
        return nVar2;
    }

    public void d(int i) {
        if (i == n.f51955h) {
            if (this.f52054a.b() != null) {
                d.b.i0.r.d0.b.j().v("key_special_category_version", this.f52054a.b().e());
            }
        } else if (i == n.f51954g) {
            d.b.i0.r.d0.b.j().v("key_common_category_version", this.f52054a.a());
        }
    }

    public void e() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }
}
