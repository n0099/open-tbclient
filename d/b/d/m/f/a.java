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
    public b f43276a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43277b;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f43279d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f43280e = new C0592a(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f43278c = BdUniqueId.gen();

    /* renamed from: d.b.d.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0592a extends HttpMessageListener {
        public C0592a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f43277b = false;
            VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
            a.this.f43279d = videoPasterResponseData;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                return;
            }
            if (httpResponsedMessage instanceof VideoPasterResponseData) {
                if (a.this.f43276a != null) {
                    a.this.f43276a.b(videoPasterResponseData.getPasterData());
                }
            } else if (a.this.f43276a != null) {
                a.this.f43276a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str);

        void b(d.b.d.m.e.a aVar);
    }

    public a() {
        this.f43280e.setSelfListener(true);
        this.f43280e.setTag(this.f43278c);
        MessageManager.getInstance().registerListener(this.f43280e);
    }

    public void d() {
        if (this.f43278c != null) {
            MessageManager.getInstance().removeMessage(this.f43278c);
        }
    }

    public VideoPasterResponseData e() {
        return this.f43279d;
    }

    public boolean f() {
        return this.f43277b;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData == null) {
            return;
        }
        this.f43277b = true;
        videoPasterRequestData.setTag(this.f43278c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        if (this.f43280e != null) {
            MessageManager.getInstance().unRegisterListener(this.f43280e);
        }
        if (this.f43276a != null) {
            this.f43276a = null;
        }
    }

    public void i() {
        d();
        this.f43277b = false;
        this.f43279d = null;
    }

    public void j(b bVar) {
        this.f43276a = bVar;
    }
}
