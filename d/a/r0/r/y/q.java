package d.a.r0.r.y;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q extends l implements i {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final f f56311c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.r0.r.y.c f56312d;

    /* renamed from: e  reason: collision with root package name */
    public final d f56313e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, h> f56314f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, m> f56315g;

    /* renamed from: h  reason: collision with root package name */
    public String f56316h;

    /* renamed from: i  reason: collision with root package name */
    public int f56317i;
    public int j;

    /* loaded from: classes9.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f56318a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f56319b;

        public a(q qVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56319b = qVar;
            this.f56318a = i2;
        }

        @Override // d.a.r0.r.y.k
        public void a(m mVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, mVar, jSONObject) == null) {
                this.f56319b.u(mVar, this.f56318a);
            }
        }

        @Override // d.a.r0.r.y.k
        public void b(int i2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, th) == null) && i2 == 1) {
                if (this.f56318a < q.m.length) {
                    this.f56319b.v();
                }
                int i3 = this.f56318a;
                if (i3 >= 0 && i3 < q.m.length) {
                    this.f56319b.y(String.valueOf(q.m[this.f56318a]), "");
                    return;
                }
                BdLog.e("pingIndex " + this.f56318a + " out of bounds.");
                String t = this.f56319b.t();
                e.b(t, "103", "ping timeout for index " + this.f56318a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(WebView webView, a aVar) {
            this(webView);
        }

        @Override // d.a.r0.r.y.l
        public void c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
                mVar.g(4, null);
            }
        }

        @Override // d.a.r0.r.y.l
        public void e(String str, d.a.r0.r.y.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebView webView) {
            super(webView, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (d.a.r0.r.y.b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final l f56320a;

        /* renamed from: b  reason: collision with root package name */
        public final String f56321b;

        public c(l lVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56320a = lVar;
            this.f56321b = str;
        }

        @Override // d.a.r0.r.y.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                if (TextUtils.isEmpty(optString)) {
                    e.a("scope " + this.f56321b + " not found!");
                    return;
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
                hashMap.put("errMsg", "cmd " + this.f56321b + " not found");
                this.f56320a.c(m.k(optString, hashMap));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<i> f56322a;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56322a = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                i iVar = this.f56322a.get();
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485195319, "Ld/a/r0/r/y/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-485195319, "Ld/a/r0/r/y/q;");
                return;
            }
        }
        k = new int[]{1500, 2000, 3500, 4600, 6000, 8000};
        l = new int[]{201, 202, 203};
        m = new int[]{501, 502, 503};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(WebView webView, d.a.r0.r.y.b bVar) {
        this(webView, new f(), new d.a.r0.r.y.c(), bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((WebView) objArr2[0], (f) objArr2[1], (d.a.r0.r.y.c) objArr2[2], (d.a.r0.r.y.b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static l n(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, d.a.r0.r.y.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), webView, webViewClient, webChromeClient, bVar})) == null) {
            if (!z) {
                return new b(webView, null);
            }
            q qVar = new q(webView, bVar);
            qVar.f56311c.b(webViewClient);
            qVar.f56312d.d(webChromeClient);
            return qVar;
        }
        return (l) invokeCommon.objValue;
    }

    public static l o(boolean z, BridgeWebView bridgeWebView, d.a.r0.r.y.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), bridgeWebView, bVar})) == null) {
            if (!z) {
                return new b(bridgeWebView, null);
            }
            WebViewClient webViewClient = bridgeWebView.webViewClient;
            WebChromeClient webChromeClient = bridgeWebView.chromeClient;
            q qVar = new q(bridgeWebView, bVar);
            qVar.f56311c.b(webViewClient);
            qVar.f56312d.d(webChromeClient);
            return qVar;
        }
        return (l) invokeCommon.objValue;
    }

    @Override // d.a.r0.r.y.i
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                e.a("invalid callbackId.");
                return;
            }
            m remove = this.f56315g.remove(str);
            if (remove != null) {
                e.a("(" + remove.f56303a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.f56304b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
                remove.g(1, null);
            }
        }
    }

    @Override // d.a.r0.r.y.i
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.j + 1;
            this.j = i2;
            HashMap hashMap = new HashMap();
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            hashMap.put("version", "1.0");
            hashMap.put("logid", t());
            int[] iArr = k;
            m(m.i(hashMap, iArr[this.j % iArr.length], new a(this, i2)), true);
            y("100", "");
        }
    }

    @Override // d.a.r0.r.y.l
    public void c(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            m(mVar, mVar.f56307e == 3);
        }
    }

    @Override // d.a.r0.r.y.l
    public void e(String str, d.a.r0.r.y.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, dVar) == null) || this.f56314f.put(str, dVar) == null) {
            return;
        }
        throw new IllegalArgumentException("handler " + str + " exists.");
    }

    public final StringBuilder l() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            jSONObject.put("version", "1.0");
            jSONObject.put("logid", t());
            sb.append(jSONObject.toString());
            sb.append(';');
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public final void m(m mVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, mVar, z) == null) {
            if (!z) {
                if (this.f56317i != 0) {
                    String t = t();
                    e.b(t, "101", "(" + mVar.f56303a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f56304b + ") is called before bridge ready");
                }
                if (TextUtils.isEmpty(mVar.f56303a) || TextUtils.isEmpty(mVar.f56304b)) {
                    e.b(t(), "102", "the alias class or method is empty");
                    mVar.g(3, new IllegalArgumentException("cmd or method is illegal."));
                    return;
                }
            }
            if (!TextUtils.isEmpty(mVar.f56308f)) {
                if (mVar.f56307e != 3) {
                    this.f56315g.put(mVar.f56308f, mVar);
                    if (mVar.f56309g > 0) {
                        d dVar = this.f56313e;
                        dVar.sendMessageDelayed(Message.obtain(dVar, 2, mVar.f56308f), mVar.f56309g);
                    } else if (mVar.f56303a != null || mVar.f56304b != null) {
                        e.a("ignore timeout check for method call (" + mVar.f56303a + StringUtil.ARRAY_ELEMENT_SEPARATOR + mVar.f56304b + ").");
                    }
                } else {
                    e.a("ignore timeout check for response method, callbackId " + mVar.f56308f);
                }
            }
            try {
                String b2 = mVar.b();
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f56300a.evaluateJavascript(b2, null);
                } else {
                    this.f56300a.loadUrl(b2);
                }
                e.a(b2);
            } catch (NullPointerException e2) {
                y("500", e2.getMessage());
            } catch (JSONException e3) {
                if (z) {
                    y("102", e3.getMessage());
                } else {
                    e.a(e3.getMessage());
                }
                mVar.g(2, e3);
            }
        }
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.j = -1;
            int i2 = this.f56317i;
            if (i2 != 2 && i2 != 1) {
                e.a("current status " + this.f56317i + ", broken because url changed to " + str);
                this.f56317i = 2;
            }
            if (p.b(str) && p.a(str)) {
                e.a("current status " + this.f56317i + ", constructing bridge for " + str);
                d.a.r0.r.y.b bVar = this.f56301b;
                if (bVar != null) {
                    bVar.b();
                }
                s(this.f56300a);
                d.a.r0.r.y.b bVar2 = this.f56301b;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f56317i == -1) {
                this.f56300a.getSettings().setJavaScriptEnabled(true);
                this.f56300a.setWebViewClient(this.f56311c);
                this.f56300a.setWebChromeClient(this.f56312d);
                this.f56300a.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f56317i = 1;
                return;
            }
            throw new IllegalStateException("Can't init bridge more than once.");
        }
    }

    public final void s(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, webView) == null) {
            this.f56316h = String.valueOf(System.currentTimeMillis());
            try {
                InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                StringBuilder l2 = l();
                l2.append(new String(bArr));
                webView.loadUrl("javascript:" + l2.toString());
                this.f56313e.sendEmptyMessageDelayed(1, 0L);
            } catch (Throwable th) {
                y("102", th.getMessage());
                e.a(th.toString());
            }
        }
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f56316h : (String) invokeV.objValue;
    }

    public final void u(m mVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, mVar, i2) == null) {
            this.f56317i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (i2 >= 0) {
                int[] iArr = l;
                if (i2 < iArr.length) {
                    y(String.valueOf(iArr[i2]), String.valueOf(currentTimeMillis - mVar.f56310h));
                    return;
                }
            }
            BdLog.e("pingIndex " + i2 + " out of bounds.");
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e.a("reInject for pingIndex " + this.j);
            s(this.f56300a);
        }
    }

    public final void w(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                e.a("invalid callbackId.");
                return;
            }
            this.f56313e.removeMessages(2, str);
            m remove = this.f56315g.remove(str);
            if (remove != null) {
                remove.h(jSONObject);
            }
        }
    }

    public final void x(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, jSONObject2) == null) {
            if (this.f56317i != 0) {
                e.b(t(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
            }
            h hVar = this.f56314f.get(str);
            if (hVar == null) {
                hVar = new c(this, str);
                String t = t();
                e.b(t, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
            }
            hVar.a(str2, jSONObject, jSONObject2);
        }
    }

    public final void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            e.c(t(), str, str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(WebView webView, f fVar, d.a.r0.r.y.c cVar, d.a.r0.r.y.b bVar) {
        super(webView, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, fVar, cVar, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((WebView) objArr2[0], (d.a.r0.r.y.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f56316h = String.valueOf(System.currentTimeMillis());
        this.f56317i = -1;
        this.j = -1;
        this.f56311c = fVar;
        this.f56312d = cVar;
        cVar.c(this);
        this.f56311c.a(this);
        this.f56313e = new d(this);
        this.f56314f = new HashMap<>(16);
        this.f56315g = new HashMap<>(8);
        r();
    }
}
