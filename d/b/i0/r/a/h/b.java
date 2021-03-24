package d.b.i0.r.a.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.SplashHttpRequest;
import com.baidu.tieba.advert.sdk.data.SplashHttpResponse;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static b f59680c = new b();

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1498b f59681a;

    /* renamed from: b  reason: collision with root package name */
    public final HttpMessageListener f59682b = new a(CmdConfigHttp.CMD_GET_SPLASH_INFO);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof SplashHttpResponse) {
                SplashHttpResponse splashHttpResponse = (SplashHttpResponse) httpResponsedMessage;
                if (!splashHttpResponse.hasError() && splashHttpResponse.getErrno() == 0) {
                    if (b.this.f59681a != null) {
                        b.this.f59681a.b(splashHttpResponse.getResultMsg());
                        return;
                    }
                    return;
                }
                BdLog.e("Response of splash has error");
                if (b.this.f59681a != null) {
                    b.this.f59681a.a(splashHttpResponse.getResultMsg());
                    return;
                }
                return;
            }
            BdLog.e("Not response of splash request");
        }
    }

    /* renamed from: d.b.i0.r.a.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1498b {
        void a(String str);

        void b(String str);
    }

    public static String b() {
        return "http://baichuan.baidu.com/rs/adpmobile/downloadstatistics";
    }

    public static String c() {
        return "http://baichuan.baidu.com/rs/adpmobile/successdisplaystatistics";
    }

    public static b d() {
        return f59680c;
    }

    public void e(TbPageContext<?> tbPageContext, InterfaceC1498b interfaceC1498b, AdInfo adInfo) {
        this.f59681a = interfaceC1498b;
        this.f59682b.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.f59682b);
        SplashHttpRequest.sendRequest(new SplashHttpRequest(tbPageContext.getPageActivity(), adInfo));
    }
}
