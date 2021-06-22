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
    public b f43357a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43358b;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f43360d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f43361e = new C0577a(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f43359c = BdUniqueId.gen();

    /* renamed from: d.a.d.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0577a extends HttpMessageListener {
        public C0577a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f43358b = false;
            VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
            a.this.f43360d = videoPasterResponseData;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                return;
            }
            if (httpResponsedMessage instanceof VideoPasterResponseData) {
                if (a.this.f43357a != null) {
                    a.this.f43357a.b(videoPasterResponseData.getPasterData());
                }
            } else if (a.this.f43357a != null) {
                a.this.f43357a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2, String str);

        void b(d.a.d.m.e.a aVar);
    }

    public a() {
        this.f43361e.setSelfListener(true);
        this.f43361e.setTag(this.f43359c);
        MessageManager.getInstance().registerListener(this.f43361e);
    }

    public void d() {
        if (this.f43359c != null) {
            MessageManager.getInstance().removeMessage(this.f43359c);
        }
    }

    public VideoPasterResponseData e() {
        return this.f43360d;
    }

    public boolean f() {
        return this.f43358b;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData == null) {
            return;
        }
        this.f43358b = true;
        videoPasterRequestData.setTag(this.f43359c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        if (this.f43361e != null) {
            MessageManager.getInstance().unRegisterListener(this.f43361e);
        }
        if (this.f43357a != null) {
            this.f43357a = null;
        }
    }

    public void i() {
        d();
        this.f43358b = false;
        this.f43360d = null;
    }

    public void j(b bVar) {
        this.f43357a = bVar;
    }
}
