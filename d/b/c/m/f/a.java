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
    public b f42526a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42527b;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f42529d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f42530e = new C0558a(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f42528c = BdUniqueId.gen();

    /* renamed from: d.b.c.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0558a extends HttpMessageListener {
        public C0558a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f42527b = false;
            VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
            a.this.f42529d = videoPasterResponseData;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                return;
            }
            if (httpResponsedMessage instanceof VideoPasterResponseData) {
                if (a.this.f42526a != null) {
                    a.this.f42526a.b(videoPasterResponseData.getPasterData());
                }
            } else if (a.this.f42526a != null) {
                a.this.f42526a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str);

        void b(d.b.c.m.e.a aVar);
    }

    public a() {
        this.f42530e.setSelfListener(true);
        this.f42530e.setTag(this.f42528c);
        MessageManager.getInstance().registerListener(this.f42530e);
    }

    public void d() {
        if (this.f42528c != null) {
            MessageManager.getInstance().removeMessage(this.f42528c);
        }
    }

    public VideoPasterResponseData e() {
        return this.f42529d;
    }

    public boolean f() {
        return this.f42527b;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData == null) {
            return;
        }
        this.f42527b = true;
        videoPasterRequestData.setTag(this.f42528c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        if (this.f42530e != null) {
            MessageManager.getInstance().unRegisterListener(this.f42530e);
        }
        if (this.f42526a != null) {
            this.f42526a = null;
        }
    }

    public void i() {
        d();
        this.f42527b = false;
        this.f42529d = null;
    }

    public void j(b bVar) {
        this.f42526a = bVar;
    }
}
