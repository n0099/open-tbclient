package d.a.j0.r.a.i;

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
    public static b f59495c = new b();

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1501b f59496a;

    /* renamed from: b  reason: collision with root package name */
    public final HttpMessageListener f59497b = new a(CmdConfigHttp.CMD_GET_SPLASH_INFO);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof SplashHttpResponse) {
                SplashHttpResponse splashHttpResponse = (SplashHttpResponse) httpResponsedMessage;
                if (!splashHttpResponse.hasError() && splashHttpResponse.getErrno() == 0) {
                    if (b.this.f59496a != null) {
                        b.this.f59496a.b(splashHttpResponse.getResultMsg());
                        return;
                    }
                    return;
                }
                BdLog.e("Response of splash has error");
                if (b.this.f59496a != null) {
                    b.this.f59496a.a(splashHttpResponse.getResultMsg());
                    return;
                }
                return;
            }
            BdLog.e("Not response of splash request");
        }
    }

    /* renamed from: d.a.j0.r.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1501b {
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
        return f59495c;
    }

    public void e(TbPageContext<?> tbPageContext, InterfaceC1501b interfaceC1501b, AdInfo adInfo) {
        this.f59496a = interfaceC1501b;
        this.f59497b.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.f59497b);
        SplashHttpRequest.sendRequest(new SplashHttpRequest(tbPageContext.getPageActivity(), adInfo));
    }
}
