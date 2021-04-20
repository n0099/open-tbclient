package d.b.d.m.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f43116a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43117b;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f43119d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f43120e = new C0587a(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f43118c = BdUniqueId.gen();

    /* renamed from: d.b.d.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0587a extends HttpMessageListener {
        public C0587a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f43117b = false;
            VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
            a.this.f43119d = videoPasterResponseData;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                return;
            }
            if (httpResponsedMessage instanceof VideoPasterResponseData) {
                if (a.this.f43116a != null) {
                    a.this.f43116a.b(videoPasterResponseData.getPasterData());
                }
            } else if (a.this.f43116a != null) {
                a.this.f43116a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str);

        void b(d.b.d.m.e.a aVar);
    }

    public a() {
        this.f43120e.setSelfListener(true);
        this.f43120e.setTag(this.f43118c);
        MessageManager.getInstance().registerListener(this.f43120e);
    }

    public void d() {
        if (this.f43118c != null) {
            MessageManager.getInstance().removeMessage(this.f43118c);
        }
    }

    public VideoPasterResponseData e() {
        return this.f43119d;
    }

    public boolean f() {
        return this.f43117b;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData == null) {
            return;
        }
        this.f43117b = true;
        videoPasterRequestData.setTag(this.f43118c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        if (this.f43120e != null) {
            MessageManager.getInstance().unRegisterListener(this.f43120e);
        }
        if (this.f43116a != null) {
            this.f43116a = null;
        }
    }

    public void i() {
        d();
        this.f43117b = false;
        this.f43119d = null;
    }

    public void j(b bVar) {
        this.f43116a = bVar;
    }
}
