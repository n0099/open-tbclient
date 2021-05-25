package d.a.n0.r2;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpReqMsg;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpResMsg;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final WebView f59931a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f59932b;

    /* renamed from: f  reason: collision with root package name */
    public String f59936f;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f59933c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f59934d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f59935e = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f59937g = new C1565a(CmdConfigHttp.CMD_WEB_HTTP_PROXY);

    /* renamed from: d.a.n0.r2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1565a extends HttpMessageListener {
        public C1565a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            String str2;
            String str3;
            String str4;
            String s;
            if (!(httpResponsedMessage instanceof QuickWebViewHttpResMsg)) {
                return;
            }
            int i2 = 0;
            QuickWebViewHttpResMsg quickWebViewHttpResMsg = (QuickWebViewHttpResMsg) httpResponsedMessage;
            String str5 = null;
            if (quickWebViewHttpResMsg.getOrginalMessage() instanceof QuickWebViewHttpReqMsg) {
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = (QuickWebViewHttpReqMsg) quickWebViewHttpResMsg.getOrginalMessage();
                if (!StringUtils.isNull(quickWebViewHttpReqMsg.url)) {
                    String str6 = quickWebViewHttpReqMsg.url;
                    long j = quickWebViewHttpReqMsg.begin;
                    str = quickWebViewHttpReqMsg.module;
                    String str7 = quickWebViewHttpReqMsg.jsCallbackMethod;
                    if (TextUtils.isEmpty(str7)) {
                        String str8 = (String) a.this.f59934d.remove(str6);
                        TextUtils.isEmpty(str8);
                        str7 = str8;
                        i2 = 1;
                    }
                    a.this.f59933c.remove(str6);
                    str5 = str7;
                    str2 = str6;
                    if (!quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                        str4 = quickWebViewHttpResMsg.getResult();
                        str3 = BasicPushStatus.SUCCESS_CODE;
                    } else {
                        str3 = quickWebViewHttpResMsg.getError() + "";
                        str4 = "\"\"";
                    }
                    s = b.q().s(str);
                    if (s == null) {
                        s = "0.0.0.0";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(StringUtil.ARRAY_START);
                    sb.append("\"status\":");
                    sb.append("\"");
                    sb.append(str3);
                    sb.append("\"");
                    sb.append(",");
                    sb.append("\"data\":");
                    sb.append(str4);
                    sb.append(",");
                    sb.append("\"cache_version\":");
                    sb.append("\"");
                    sb.append(s);
                    sb.append("\"");
                    sb.append(",");
                    sb.append("\"cache\":");
                    sb.append("\"");
                    sb.append(i2);
                    sb.append("\"");
                    sb.append("}");
                    if (!StringUtils.isNull(str5)) {
                        a.this.f59935e.put(str2, sb.toString());
                        return;
                    } else {
                        a.this.g(str5, sb.toString());
                        return;
                    }
                }
            }
            str = "";
            str2 = null;
            if (!quickWebViewHttpResMsg.isSuccess()) {
            }
            str3 = quickWebViewHttpResMsg.getError() + "";
            str4 = "\"\"";
            s = b.q().s(str);
            if (s == null) {
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(StringUtil.ARRAY_START);
            sb2.append("\"status\":");
            sb2.append("\"");
            sb2.append(str3);
            sb2.append("\"");
            sb2.append(",");
            sb2.append("\"data\":");
            sb2.append(str4);
            sb2.append(",");
            sb2.append("\"cache_version\":");
            sb2.append("\"");
            sb2.append(s);
            sb2.append("\"");
            sb2.append(",");
            sb2.append("\"cache\":");
            sb2.append("\"");
            sb2.append(i2);
            sb2.append("\"");
            sb2.append("}");
            if (!StringUtils.isNull(str5)) {
            }
        }
    }

    public a(WebView webView) {
        this.f59931a = webView;
        this.f59936f = webView.getSettings().getUserAgentString();
        BdUniqueId gen = BdUniqueId.gen();
        this.f59932b = gen;
        this.f59937g.setTag(gen);
        this.f59937g.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f59937g);
    }

    public void e() {
        MessageManager.getInstance().unRegisterListener(this.f59932b);
        MessageManager.getInstance().removeMessage(this.f59932b);
        this.f59933c.clear();
        this.f59933c = null;
        this.f59934d.clear();
        this.f59934d = null;
        this.f59935e.clear();
        this.f59935e = null;
    }

    public void f(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        if (quickWebViewBridgeData == null || StringUtils.isNull(quickWebViewBridgeData.url) || StringUtils.isNull(quickWebViewBridgeData.type)) {
            return;
        }
        String remove = this.f59935e.remove(quickWebViewBridgeData.url);
        if (!StringUtils.isNull(remove) && str != null) {
            g(str, remove);
        } else if (this.f59933c.contains(quickWebViewBridgeData.url)) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f59934d.put(quickWebViewBridgeData.url, str);
        } else {
            QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
            quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
            quickWebViewHttpReqMsg.module = quickWebViewBridgeData.module;
            quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
            quickWebViewHttpReqMsg.jsCallbackMethod = str;
            quickWebViewHttpReqMsg.setTag(this.f59932b);
            CookieSyncManager.createInstance(this.f59931a.getContext());
            String cookie = CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME);
            if (!TextUtils.isEmpty(cookie)) {
                HashMap<String, String> headers = quickWebViewHttpReqMsg.getHeaders();
                if (headers != null) {
                    String str2 = headers.get("Cookie");
                    if (!TextUtils.isEmpty(str2)) {
                        cookie = str2.endsWith(";") ? str2 + cookie : str2 + ";" + cookie;
                    }
                    quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                } else {
                    quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                }
            }
            quickWebViewHttpReqMsg.setUserAgent(this.f59936f);
            quickWebViewHttpReqMsg.addCookie("cache_version", b.q().s(quickWebViewBridgeData.module));
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_WEB_HTTP_PROXY, quickWebViewBridgeData.url);
            tbHttpMessageTask.setResponsedClass(QuickWebViewHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setPriority(4);
            if (quickWebViewBridgeData.type.toLowerCase().equals("post")) {
                Map<String, String> map = quickWebViewBridgeData.data;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : quickWebViewBridgeData.data.entrySet()) {
                        quickWebViewHttpReqMsg.addParam(entry.getKey(), entry.getValue());
                    }
                }
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            } else {
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            }
            MessageManager.getInstance().sendMessage(quickWebViewHttpReqMsg, tbHttpMessageTask);
            this.f59933c.add(quickWebViewBridgeData.url);
        }
    }

    public final void g(String str, String str2) {
        WebView webView = this.f59931a;
        if (webView != null) {
            webView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }
}
