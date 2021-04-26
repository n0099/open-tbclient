package d.a.i0.r.y;

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
    public final f f49504c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.i0.r.y.c f49505d;

    /* renamed from: e  reason: collision with root package name */
    public final d f49506e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, h> f49507f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, m> f49508g;

    /* renamed from: h  reason: collision with root package name */
    public String f49509h;

    /* renamed from: i  reason: collision with root package name */
    public int f49510i;
    public int j;

    /* loaded from: classes3.dex */
    public class a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f49511a;

        public a(int i2) {
            this.f49511a = i2;
        }

        @Override // d.a.i0.r.y.k
        public void a(m mVar, JSONObject jSONObject) {
            q.this.u(mVar, this.f49511a);
        }

        @Override // d.a.i0.r.y.k
        public void b(int i2, Throwable th) {
            if (i2 != 1) {
                return;
            }
            if (this.f49511a < q.m.length) {
                q.this.v();
            }
            int i3 = this.f49511a;
            if (i3 >= 0 && i3 < q.m.length) {
                q.this.y(String.valueOf(q.m[this.f49511a]), "");
                return;
            }
            BdLog.e("pingIndex " + this.f49511a + " out of bounds.");
            String t = q.this.t();
            e.b(t, TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + this.f49511a);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends l {
        public /* synthetic */ b(WebView webView, a aVar) {
            this(webView);
        }

        @Override // d.a.i0.r.y.l
        public void c(m mVar) {
            mVar.g(4, null);
        }

        @Override // d.a.i0.r.y.l
        public void e(String str, d.a.i0.r.y.d dVar) {
        }

        public b(WebView webView) {
            super(webView, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public final l f49513a;

        /* renamed from: b  reason: collision with root package name */
        public final String f49514b;

        public c(l lVar, String str) {
            this.f49513a = lVar;
            this.f49514b = str;
        }

        @Override // d.a.i0.r.y.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.a("scope " + this.f49514b + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
            hashMap.put("errMsg", "cmd " + this.f49514b + " not found");
            this.f49513a.c(m.k(optString, hashMap));
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<i> f49515a;

        public d(i iVar) {
            this.f49515a = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.f49515a.get();
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

    public q(WebView webView, d.a.i0.r.y.b bVar) {
        this(webView, new f(), new d.a.i0.r.y.c(), bVar);
    }

    public static l n(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, d.a.i0.r.y.b bVar) {
        if (!z) {
            return new b(webView, null);
        }
        q qVar = new q(webView, bVar);
        qVar.f49504c.b(webViewClient);
        qVar.f49505d.d(webChromeClient);
        return qVar;
    }

    public static l o(boolean z, BridgeWebView bridgeWebView, d.a.i0.r.y.b bVar) {
        if (!z) {
            return new b(bridgeWebView, null);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.f49504c.b(webViewClient);
        qVar.f49505d.d(webChromeClient);
        return qVar;
    }

    @Override // d.a.i0.r.y.i
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            e.a("invalid callbackId.");
            return;
        }
        m remove = this.f49508g.remove(str);
        if (remove != null) {
            e.a("(" + remove.f49496a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.f49497b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
            remove.g(1, null);
        }
    }

    @Override // d.a.i0.r.y.i
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

    @Override // d.a.i0.r.y.l
    public void c(m mVar) {
        m(mVar, mVar.f49500e == 3);
    }

    @Override // d.a.i0.r.y.l
    public void e(String str, d.a.i0.r.y.d dVar) {
        if (this.f49507f.put(str, dVar) == null) {
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
            if (this.f49510i != 0) {
                String t = t();
                e.b(t, "101", "(" + mVar.f49496a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f49497b + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.f49496a) || TextUtils.isEmpty(mVar.f49497b)) {
                e.b(t(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                mVar.g(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.f49501f)) {
            if (mVar.f49500e != 3) {
                this.f49508g.put(mVar.f49501f, mVar);
                if (mVar.f49502g > 0) {
                    d dVar = this.f49506e;
                    dVar.sendMessageDelayed(Message.obtain(dVar, 2, mVar.f49501f), mVar.f49502g);
                } else if (mVar.f49496a != null || mVar.f49497b != null) {
                    e.a("ignore timeout check for method call (" + mVar.f49496a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f49497b + ").");
                }
            } else {
                e.a("ignore timeout check for response method, callbackId " + mVar.f49501f);
            }
        }
        try {
            String b2 = mVar.b();
            if (Build.VERSION.SDK_INT >= 19) {
                this.f49493a.evaluateJavascript(b2, null);
            } else {
                this.f49493a.loadUrl(b2);
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
        int i2 = this.f49510i;
        if (i2 != 2 && i2 != 1) {
            e.a("current status " + this.f49510i + ", broken because url changed to " + str);
            this.f49510i = 2;
        }
        if (p.b(str) && p.a(str)) {
            e.a("current status " + this.f49510i + ", constructing bridge for " + str);
            d.a.i0.r.y.b bVar = this.f49494b;
            if (bVar != null) {
                bVar.b();
            }
            s(this.f49493a);
            d.a.i0.r.y.b bVar2 = this.f49494b;
            if (bVar2 != null) {
                bVar2.a();
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void r() {
        if (this.f49510i == -1) {
            this.f49493a.getSettings().setJavaScriptEnabled(true);
            this.f49493a.setWebViewClient(this.f49504c);
            this.f49493a.setWebChromeClient(this.f49505d);
            this.f49493a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f49510i = 1;
            return;
        }
        throw new IllegalStateException("Can't init bridge more than once.");
    }

    public final void s(WebView webView) {
        this.f49509h = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder l2 = l();
            l2.append(new String(bArr));
            webView.loadUrl("javascript:" + l2.toString());
            this.f49506e.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            y(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
            e.a(th.toString());
        }
    }

    public final String t() {
        return this.f49509h;
    }

    public final void u(m mVar, int i2) {
        this.f49510i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 >= 0) {
            int[] iArr = l;
            if (i2 < iArr.length) {
                y(String.valueOf(iArr[i2]), String.valueOf(currentTimeMillis - mVar.f49503h));
                return;
            }
        }
        BdLog.e("pingIndex " + i2 + " out of bounds.");
    }

    public final void v() {
        e.a("reInject for pingIndex " + this.j);
        s(this.f49493a);
    }

    public final void w(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.a("invalid callbackId.");
            return;
        }
        this.f49506e.removeMessages(2, str);
        m remove = this.f49508g.remove(str);
        if (remove != null) {
            remove.h(jSONObject);
        }
    }

    public final void x(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.f49510i != 0) {
            e.b(t(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
        }
        h hVar = this.f49507f.get(str);
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

    public q(WebView webView, f fVar, d.a.i0.r.y.c cVar, d.a.i0.r.y.b bVar) {
        super(webView, bVar);
        this.f49509h = String.valueOf(System.currentTimeMillis());
        this.f49510i = -1;
        this.j = -1;
        this.f49504c = fVar;
        this.f49505d = cVar;
        cVar.c(this);
        this.f49504c.a(this);
        this.f49506e = new d(this);
        this.f49507f = new HashMap<>(16);
        this.f49508g = new HashMap<>(8);
        r();
    }
}
