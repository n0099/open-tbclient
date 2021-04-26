package d.a.i0.s.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import d.a.i0.s.c.n;
import d.a.i0.s.c.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public o f49713a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1070b f49714b;

    /* renamed from: c  reason: collision with root package name */
    public int f49715c;

    /* renamed from: d  reason: collision with root package name */
    public int f49716d;

    /* renamed from: e  reason: collision with root package name */
    public n f49717e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f49718f = new a(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);

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
                b.this.f49713a = channelConfigResponseMessage.getData();
                if (b.this.f49714b != null) {
                    b.this.f49714b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: d.a.i0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1070b {
        void a(boolean z, o oVar);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.f49718f);
        this.f49715c = d.a.i0.r.d0.b.j().k("key_common_category_version", 0);
        this.f49716d = d.a.i0.r.d0.b.j().k("key_special_category_version", 0);
    }

    public n c() {
        n nVar = this.f49717e;
        if (nVar != null) {
            return nVar;
        }
        if (this.f49713a == null) {
            return null;
        }
        n nVar2 = new n();
        o oVar = this.f49713a;
        if (oVar != null && oVar.b() != null && this.f49716d < this.f49713a.b().e()) {
            nVar2.g(this.f49713a.b().a());
            nVar2.h(this.f49713a.b().b());
            nVar2.i(this.f49713a.b().c());
            nVar2.j(this.f49713a.b().d());
            nVar2.f(n.f49609h);
        } else {
            o oVar2 = this.f49713a;
            if (oVar2 != null && oVar2.a() > 0 && this.f49715c < this.f49713a.a()) {
                nVar2.f(n.f49608g);
            } else {
                nVar2.f(n.f49607f);
            }
        }
        this.f49717e = nVar2;
        return nVar2;
    }

    public void d(int i2) {
        if (i2 == n.f49609h) {
            if (this.f49713a.b() != null) {
                d.a.i0.r.d0.b.j().v("key_special_category_version", this.f49713a.b().e());
            }
        } else if (i2 == n.f49608g) {
            d.a.i0.r.d0.b.j().v("key_common_category_version", this.f49713a.a());
        }
    }

    public void e() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }
}
