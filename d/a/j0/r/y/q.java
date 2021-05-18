package d.a.j0.r.y;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.TbEnum;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.connect.common.Constants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q extends l implements i {
    public static final int[] k = {1500, 2000, 3500, 4600, 6000, 8000};
    public static final int[] l = {201, 202, 203};
    public static final int[] m = {501, 502, 503};

    /* renamed from: c  reason: collision with root package name */
    public final f f50323c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.j0.r.y.c f50324d;

    /* renamed from: e  reason: collision with root package name */
    public final d f50325e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, h> f50326f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, m> f50327g;

    /* renamed from: h  reason: collision with root package name */
    public String f50328h;

    /* renamed from: i  reason: collision with root package name */
    public int f50329i;
    public int j;

    /* loaded from: classes3.dex */
    public class a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f50330a;

        public a(int i2) {
            this.f50330a = i2;
        }

        @Override // d.a.j0.r.y.k
        public void a(m mVar, JSONObject jSONObject) {
            q.this.u(mVar, this.f50330a);
        }

        @Override // d.a.j0.r.y.k
        public void b(int i2, Throwable th) {
            if (i2 != 1) {
                return;
            }
            if (this.f50330a < q.m.length) {
                q.this.v();
            }
            int i3 = this.f50330a;
            if (i3 >= 0 && i3 < q.m.length) {
                q.this.y(String.valueOf(q.m[this.f50330a]), "");
                return;
            }
            BdLog.e("pingIndex " + this.f50330a + " out of bounds.");
            String t = q.this.t();
            e.b(t, TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + this.f50330a);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends l {
        public /* synthetic */ b(WebView webView, a aVar) {
            this(webView);
        }

        @Override // d.a.j0.r.y.l
        public void c(m mVar) {
            mVar.g(4, null);
        }

        @Override // d.a.j0.r.y.l
        public void e(String str, d.a.j0.r.y.d dVar) {
        }

        public b(WebView webView) {
            super(webView, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public final l f50332a;

        /* renamed from: b  reason: collision with root package name */
        public final String f50333b;

        public c(l lVar, String str) {
            this.f50332a = lVar;
            this.f50333b = str;
        }

        @Override // d.a.j0.r.y.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.a("scope " + this.f50333b + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
            hashMap.put("errMsg", "cmd " + this.f50333b + " not found");
            this.f50332a.c(m.k(optString, hashMap));
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<i> f50334a;

        public d(i iVar) {
            this.f50334a = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.f50334a.get();
            if (iVar == null) {
                e.a("TimeHandler got null bridge reference.");
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                iVar.b();
            } else if (i2 == 2) {
                iVar.a((String) message.obj);
            } else {
                throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    public q(WebView webView, d.a.j0.r.y.b bVar) {
        this(webView, new f(), new d.a.j0.r.y.c(), bVar);
    }

    public static l n(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, d.a.j0.r.y.b bVar) {
        if (!z) {
            return new b(webView, null);
        }
        q qVar = new q(webView, bVar);
        qVar.f50323c.b(webViewClient);
        qVar.f50324d.d(webChromeClient);
        return qVar;
    }

    public static l o(boolean z, BridgeWebView bridgeWebView, d.a.j0.r.y.b bVar) {
        if (!z) {
            return new b(bridgeWebView, null);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.f50323c.b(webViewClient);
        qVar.f50324d.d(webChromeClient);
        return qVar;
    }

    @Override // d.a.j0.r.y.i
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            e.a("invalid callbackId.");
            return;
        }
        m remove = this.f50327g.remove(str);
        if (remove != null) {
            e.a("(" + remove.f50315a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.f50316b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
            remove.g(1, null);
        }
    }

    @Override // d.a.j0.r.y.i
    public void b() {
        int i2 = this.j + 1;
        this.j = i2;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.PARAM_PLATFORM, "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", t());
        int[] iArr = k;
        m(m.i(hashMap, iArr[this.j % iArr.length], new a(i2)), true);
        y("100", "");
    }

    @Override // d.a.j0.r.y.l
    public void c(m mVar) {
        m(mVar, mVar.f50319e == 3);
    }

    @Override // d.a.j0.r.y.l
    public void e(String str, d.a.j0.r.y.d dVar) {
        if (this.f50326f.put(str, dVar) == null) {
            return;
        }
        throw new IllegalArgumentException("handler " + str + " exists.");
    }

    public final StringBuilder l() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.PARAM_PLATFORM, "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", t());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    public final void m(m mVar, boolean z) {
        if (!z) {
            if (this.f50329i != 0) {
                String t = t();
                e.b(t, "101", "(" + mVar.f50315a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f50316b + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.f50315a) || TextUtils.isEmpty(mVar.f50316b)) {
                e.b(t(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                mVar.g(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.f50320f)) {
            if (mVar.f50319e != 3) {
                this.f50327g.put(mVar.f50320f, mVar);
                if (mVar.f50321g > 0) {
                    d dVar = this.f50325e;
                    dVar.sendMessageDelayed(Message.obtain(dVar, 2, mVar.f50320f), mVar.f50321g);
                } else if (mVar.f50315a != null || mVar.f50316b != null) {
                    e.a("ignore timeout check for method call (" + mVar.f50315a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f50316b + ").");
                }
            } else {
                e.a("ignore timeout check for response method, callbackId " + mVar.f50320f);
            }
        }
        try {
            String b2 = mVar.b();
            if (Build.VERSION.SDK_INT >= 19) {
                this.f50312a.evaluateJavascript(b2, null);
            } else {
                this.f50312a.loadUrl(b2);
            }
            e.a(b2);
        } catch (NullPointerException e2) {
            y("500", e2.getMessage());
        } catch (JSONException e3) {
            if (z) {
                y(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, e3.getMessage());
            } else {
                e.a(e3.getMessage());
            }
            mVar.g(2, e3);
        }
    }

    public String p(String str, String str2) {
        e.a("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                w(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                x(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                w(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                String t = t();
                e.b(t, TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e2) {
            e.b(t(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e2.getMessage());
            return null;
        }
    }

    public void q(String str) {
        this.j = -1;
        int i2 = this.f50329i;
        if (i2 != 2 && i2 != 1) {
            e.a("current status " + this.f50329i + ", broken because url changed to " + str);
            this.f50329i = 2;
        }
        if (p.b(str) && p.a(str)) {
            e.a("current status " + this.f50329i + ", constructing bridge for " + str);
            d.a.j0.r.y.b bVar = this.f50313b;
            if (bVar != null) {
                bVar.b();
            }
            s(this.f50312a);
            d.a.j0.r.y.b bVar2 = this.f50313b;
            if (bVar2 != null) {
                bVar2.a();
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void r() {
        if (this.f50329i == -1) {
            this.f50312a.getSettings().setJavaScriptEnabled(true);
            this.f50312a.setWebViewClient(this.f50323c);
            this.f50312a.setWebChromeClient(this.f50324d);
            this.f50312a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f50329i = 1;
            return;
        }
        throw new IllegalStateException("Can't init bridge more than once.");
    }

    public final void s(WebView webView) {
        this.f50328h = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder l2 = l();
            l2.append(new String(bArr));
            webView.loadUrl("javascript:" + l2.toString());
            this.f50325e.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            y(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
            e.a(th.toString());
        }
    }

    public final String t() {
        return this.f50328h;
    }

    public final void u(m mVar, int i2) {
        this.f50329i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 >= 0) {
            int[] iArr = l;
            if (i2 < iArr.length) {
                y(String.valueOf(iArr[i2]), String.valueOf(currentTimeMillis - mVar.f50322h));
                return;
            }
        }
        BdLog.e("pingIndex " + i2 + " out of bounds.");
    }

    public final void v() {
        e.a("reInject for pingIndex " + this.j);
        s(this.f50312a);
    }

    public final void w(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.a("invalid callbackId.");
            return;
        }
        this.f50325e.removeMessages(2, str);
        m remove = this.f50327g.remove(str);
        if (remove != null) {
            remove.h(jSONObject);
        }
    }

    public final void x(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.f50329i != 0) {
            e.b(t(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
        }
        h hVar = this.f50326f.get(str);
        if (hVar == null) {
            hVar = new c(this, str);
            String t = t();
            e.b(t, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    public final void y(String str, String str2) {
        e.c(t(), str, str2);
    }

    public q(WebView webView, f fVar, d.a.j0.r.y.c cVar, d.a.j0.r.y.b bVar) {
        super(webView, bVar);
        this.f50328h = String.valueOf(System.currentTimeMillis());
        this.f50329i = -1;
        this.j = -1;
        this.f50323c = fVar;
        this.f50324d = cVar;
        cVar.c(this);
        this.f50323c.a(this);
        this.f50325e = new d(this);
        this.f50326f = new HashMap<>(16);
        this.f50327g = new HashMap<>(8);
        r();
    }
}
