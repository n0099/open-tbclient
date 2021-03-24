package d.b.h0.s.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import d.b.h0.s.c.l;
import d.b.h0.s.c.m;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public m f51300a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1095b f51301b;

    /* renamed from: c  reason: collision with root package name */
    public int f51302c;

    /* renamed from: d  reason: collision with root package name */
    public int f51303d;

    /* renamed from: e  reason: collision with root package name */
    public l f51304e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f51305f = new a(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);

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
                b.this.f51300a = channelConfigResponseMessage.getData();
                if (b.this.f51301b != null) {
                    b.this.f51301b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: d.b.h0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1095b {
        void a(boolean z, m mVar);
    }

    public b() {
        MessageManager.getInstance().registerListener(this.f51305f);
        this.f51302c = d.b.h0.r.d0.b.i().j("key_common_category_version", 0);
        this.f51303d = d.b.h0.r.d0.b.i().j("key_special_category_version", 0);
    }

    public l c() {
        l lVar = this.f51304e;
        if (lVar != null) {
            return lVar;
        }
        if (this.f51300a == null) {
            return null;
        }
        l lVar2 = new l();
        m mVar = this.f51300a;
        if (mVar != null && mVar.b() != null && this.f51303d < this.f51300a.b().e()) {
            lVar2.g(this.f51300a.b().a());
            lVar2.h(this.f51300a.b().b());
            lVar2.i(this.f51300a.b().c());
            lVar2.j(this.f51300a.b().d());
            lVar2.f(l.f51192h);
        } else {
            m mVar2 = this.f51300a;
            if (mVar2 != null && mVar2.a() > 0 && this.f51302c < this.f51300a.a()) {
                lVar2.f(l.f51191g);
            } else {
                lVar2.f(l.f51190f);
            }
        }
        this.f51304e = lVar2;
        return lVar2;
    }

    public void d(int i) {
        if (i == l.f51192h) {
            if (this.f51300a.b() != null) {
                d.b.h0.r.d0.b.i().u("key_special_category_version", this.f51300a.b().e());
            }
        } else if (i == l.f51191g) {
            d.b.h0.r.d0.b.i().u("key_common_category_version", this.f51300a.a());
        }
    }

    public void e() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
    }
}
