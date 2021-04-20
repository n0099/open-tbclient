package d.b.h0.s.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import d.b.h0.s.c.n;
import d.b.h0.s.c.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public o f51718a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1109b f51719b;

    /* renamed from: c  reason: collision with root package name */
    public int f51720c;

    /* renamed from: d  reason: collision with root package name */
    public int f51721d;

    /* renamed from: e  reason: collision with root package name */
    public n f51722e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f51723f = new a(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);

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
                b.this.f51718a = channelConfigResponseMessage.getData();
                if (b.this.f51719b != null) {
                    b.this.f51719b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: d.b.h0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1109b {
        void a(boolean z, o oVar);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.f51723f);
        this.f51720c = d.b.h0.r.d0.b.j().k("key_common_category_version", 0);
        this.f51721d = d.b.h0.r.d0.b.j().k("key_special_category_version", 0);
    }

    public n c() {
        n nVar = this.f51722e;
        if (nVar != null) {
            return nVar;
        }
        if (this.f51718a == null) {
            return null;
        }
        n nVar2 = new n();
        o oVar = this.f51718a;
        if (oVar != null && oVar.b() != null && this.f51721d < this.f51718a.b().e()) {
            nVar2.g(this.f51718a.b().a());
            nVar2.h(this.f51718a.b().b());
            nVar2.i(this.f51718a.b().c());
            nVar2.j(this.f51718a.b().d());
            nVar2.f(n.f51619h);
        } else {
            o oVar2 = this.f51718a;
            if (oVar2 != null && oVar2.a() > 0 && this.f51720c < this.f51718a.a()) {
                nVar2.f(n.f51618g);
            } else {
                nVar2.f(n.f51617f);
            }
        }
        this.f51722e = nVar2;
        return nVar2;
    }

    public void d(int i) {
        if (i == n.f51619h) {
            if (this.f51718a.b() != null) {
                d.b.h0.r.d0.b.j().v("key_special_category_version", this.f51718a.b().e());
            }
        } else if (i == n.f51618g) {
            d.b.h0.r.d0.b.j().v("key_common_category_version", this.f51718a.a());
        }
    }

    public void e() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }
}
