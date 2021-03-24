package d.b.c.m.f;

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
    public b f42525a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42526b;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f42528d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f42529e = new C0557a(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f42527c = BdUniqueId.gen();

    /* renamed from: d.b.c.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0557a extends HttpMessageListener {
        public C0557a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f42526b = false;
            VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
            a.this.f42528d = videoPasterResponseData;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                return;
            }
            if (httpResponsedMessage instanceof VideoPasterResponseData) {
                if (a.this.f42525a != null) {
                    a.this.f42525a.b(videoPasterResponseData.getPasterData());
                }
            } else if (a.this.f42525a != null) {
                a.this.f42525a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str);

        void b(d.b.c.m.e.a aVar);
    }

    public a() {
        this.f42529e.setSelfListener(true);
        this.f42529e.setTag(this.f42527c);
        MessageManager.getInstance().registerListener(this.f42529e);
    }

    public void d() {
        if (this.f42527c != null) {
            MessageManager.getInstance().removeMessage(this.f42527c);
        }
    }

    public VideoPasterResponseData e() {
        return this.f42528d;
    }

    public boolean f() {
        return this.f42526b;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData == null) {
            return;
        }
        this.f42526b = true;
        videoPasterRequestData.setTag(this.f42527c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        if (this.f42529e != null) {
            MessageManager.getInstance().unRegisterListener(this.f42529e);
        }
        if (this.f42525a != null) {
            this.f42525a = null;
        }
    }

    public void i() {
        d();
        this.f42526b = false;
        this.f42528d = null;
    }

    public void j(b bVar) {
        this.f42525a = bVar;
    }
}
