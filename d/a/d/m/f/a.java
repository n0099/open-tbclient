package d.a.d.m.f;

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
    public b f40512a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40513b;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f40515d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f40516e = new C0531a(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f40514c = BdUniqueId.gen();

    /* renamed from: d.a.d.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0531a extends HttpMessageListener {
        public C0531a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f40513b = false;
            VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
            a.this.f40515d = videoPasterResponseData;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                return;
            }
            if (httpResponsedMessage instanceof VideoPasterResponseData) {
                if (a.this.f40512a != null) {
                    a.this.f40512a.b(videoPasterResponseData.getPasterData());
                }
            } else if (a.this.f40512a != null) {
                a.this.f40512a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2, String str);

        void b(d.a.d.m.e.a aVar);
    }

    public a() {
        this.f40516e.setSelfListener(true);
        this.f40516e.setTag(this.f40514c);
        MessageManager.getInstance().registerListener(this.f40516e);
    }

    public void d() {
        if (this.f40514c != null) {
            MessageManager.getInstance().removeMessage(this.f40514c);
        }
    }

    public VideoPasterResponseData e() {
        return this.f40515d;
    }

    public boolean f() {
        return this.f40513b;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData == null) {
            return;
        }
        this.f40513b = true;
        videoPasterRequestData.setTag(this.f40514c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        if (this.f40516e != null) {
            MessageManager.getInstance().unRegisterListener(this.f40516e);
        }
        if (this.f40512a != null) {
            this.f40512a = null;
        }
    }

    public void i() {
        d();
        this.f40513b = false;
        this.f40515d = null;
    }

    public void j(b bVar) {
        this.f40512a = bVar;
    }
}
