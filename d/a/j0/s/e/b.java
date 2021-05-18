package d.a.j0.s.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import d.a.j0.s.c.n;
import d.a.j0.s.c.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public o f50532a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1145b f50533b;

    /* renamed from: c  reason: collision with root package name */
    public int f50534c;

    /* renamed from: d  reason: collision with root package name */
    public int f50535d;

    /* renamed from: e  reason: collision with root package name */
    public n f50536e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f50537f = new a(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);

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
                b.this.f50532a = channelConfigResponseMessage.getData();
                if (b.this.f50533b != null) {
                    b.this.f50533b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: d.a.j0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1145b {
        void a(boolean z, o oVar);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.f50537f);
        this.f50534c = d.a.j0.r.d0.b.j().k("key_common_category_version", 0);
        this.f50535d = d.a.j0.r.d0.b.j().k("key_special_category_version", 0);
    }

    public n c() {
        n nVar = this.f50536e;
        if (nVar != null) {
            return nVar;
        }
        if (this.f50532a == null) {
            return null;
        }
        n nVar2 = new n();
        o oVar = this.f50532a;
        if (oVar != null && oVar.b() != null && this.f50535d < this.f50532a.b().e()) {
            nVar2.g(this.f50532a.b().a());
            nVar2.h(this.f50532a.b().b());
            nVar2.i(this.f50532a.b().c());
            nVar2.j(this.f50532a.b().d());
            nVar2.f(n.f50428h);
        } else {
            o oVar2 = this.f50532a;
            if (oVar2 != null && oVar2.a() > 0 && this.f50534c < this.f50532a.a()) {
                nVar2.f(n.f50427g);
            } else {
                nVar2.f(n.f50426f);
            }
        }
        this.f50536e = nVar2;
        return nVar2;
    }

    public void d(int i2) {
        if (i2 == n.f50428h) {
            if (this.f50532a.b() != null) {
                d.a.j0.r.d0.b.j().v("key_special_category_version", this.f50532a.b().e());
            }
        } else if (i2 == n.f50427g) {
            d.a.j0.r.d0.b.j().v("key_common_category_version", this.f50532a.a());
        }
    }

    public void e() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }
}
