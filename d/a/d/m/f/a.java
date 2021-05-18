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
    public b f39757a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39758b;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f39760d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f39761e = new C0518a(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f39759c = BdUniqueId.gen();

    /* renamed from: d.a.d.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0518a extends HttpMessageListener {
        public C0518a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            a.this.f39758b = false;
            VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
            a.this.f39760d = videoPasterResponseData;
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                return;
            }
            if (httpResponsedMessage instanceof VideoPasterResponseData) {
                if (a.this.f39757a != null) {
                    a.this.f39757a.b(videoPasterResponseData.getPasterData());
                }
            } else if (a.this.f39757a != null) {
                a.this.f39757a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2, String str);

        void b(d.a.d.m.e.a aVar);
    }

    public a() {
        this.f39761e.setSelfListener(true);
        this.f39761e.setTag(this.f39759c);
        MessageManager.getInstance().registerListener(this.f39761e);
    }

    public void d() {
        if (this.f39759c != null) {
            MessageManager.getInstance().removeMessage(this.f39759c);
        }
    }

    public VideoPasterResponseData e() {
        return this.f39760d;
    }

    public boolean f() {
        return this.f39758b;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        if (videoPasterRequestData == null) {
            return;
        }
        this.f39758b = true;
        videoPasterRequestData.setTag(this.f39759c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        if (this.f39761e != null) {
            MessageManager.getInstance().unRegisterListener(this.f39761e);
        }
        if (this.f39757a != null) {
            this.f39757a = null;
        }
    }

    public void i() {
        d();
        this.f39758b = false;
        this.f39760d = null;
    }

    public void j(b bVar) {
        this.f39757a = bVar;
    }
}
