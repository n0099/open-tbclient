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
    public b f43254a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43255b;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f43257d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f43258e = new C0574a(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f43256c = BdUniqueId.gen();

    /* renamed from: d.a.d.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0574a extends HttpMessageListener {
        public C0574a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f43255b = false;
            VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
            a.this.f43257d = videoPasterResponseData;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                return;
            }
            if (httpResponsedMessage instanceof VideoPasterResponseData) {
                if (a.this.f43254a != null) {
                    a.this.f43254a.b(videoPasterResponseData.getPasterData());
                }
            } else if (a.this.f43254a != null) {
                a.this.f43254a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2, String str);

        void b(d.a.d.m.e.a aVar);
    }

    public a() {
        this.f43258e.setSelfListener(true);
        this.f43258e.setTag(this.f43256c);
        MessageManager.getInstance().registerListener(this.f43258e);
    }

    public void d() {
        if (this.f43256c != null) {
            MessageManager.getInstance().removeMessage(this.f43256c);
        }
    }

    public VideoPasterResponseData e() {
        return this.f43257d;
    }

    public boolean f() {
        return this.f43255b;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData == null) {
            return;
        }
        this.f43255b = true;
        videoPasterRequestData.setTag(this.f43256c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        if (this.f43258e != null) {
            MessageManager.getInstance().unRegisterListener(this.f43258e);
        }
        if (this.f43254a != null) {
            this.f43254a = null;
        }
    }

    public void i() {
        d();
        this.f43255b = false;
        this.f43257d = null;
    }

    public void j(b bVar) {
        this.f43254a = bVar;
    }
}
