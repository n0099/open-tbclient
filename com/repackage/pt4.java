package com.repackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import androidx.print.PrintHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pt4 extends kt4 implements ht4 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public final et4 c;
    public final bt4 d;
    public final d e;
    public final HashMap<String, gt4> f;
    public final HashMap<String, lt4> g;
    public String h;
    public int i;
    public int j;

    /* loaded from: classes6.dex */
    public class a implements jt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ pt4 b;

        public a(pt4 pt4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pt4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pt4Var;
            this.a = i;
        }

        @Override // com.repackage.jt4
        public void a(lt4 lt4Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, lt4Var, jSONObject) == null) {
                this.b.t(lt4Var, this.a);
            }
        }

        @Override // com.repackage.jt4
        public void b(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, th) == null) && i == 1) {
                if (this.a < pt4.m.length) {
                    this.b.u();
                }
                int i2 = this.a;
                if (i2 >= 0 && i2 < pt4.m.length) {
                    this.b.x(String.valueOf(pt4.m[this.a]), "");
                    return;
                }
                BdLog.e("pingIndex " + this.a + " out of bounds.");
                String s = this.b.s();
                dt4.b(s, TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends kt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(WebView webView, a aVar) {
            this(webView);
        }

        @Override // com.repackage.kt4
        public void c(lt4 lt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lt4Var) == null) {
                lt4Var.g(4, null);
            }
        }

        @Override // com.repackage.kt4
        public void e(String str, ct4 ct4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, ct4Var) == null) {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (at4) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements gt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final kt4 a;
        public final String b;

        public c(kt4 kt4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kt4Var;
            this.b = str;
        }

        @Override // com.repackage.gt4
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                if (TextUtils.isEmpty(optString)) {
                    dt4.a("scope " + this.b + " not found!");
                    return;
                }
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
                hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "cmd " + this.b + " not found");
                this.a.c(lt4.k(optString, hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ht4> a;

        public d(ht4 ht4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(ht4Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                ht4 ht4Var = this.a.get();
                if (ht4Var == null) {
                    dt4.a("TimeHandler got null bridge reference.");
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    ht4Var.b();
                } else if (i == 2) {
                    ht4Var.a((String) message.obj);
                } else {
                    throw new IllegalArgumentException("Invalid message.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755398399, "Lcom/repackage/pt4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755398399, "Lcom/repackage/pt4;");
                return;
            }
        }
        k = new int[]{1500, 2000, PrintHelper.MAX_PRINT_SIZE, 4600, 6000, 8000};
        l = new int[]{201, 202, 203};
        m = new int[]{501, 502, 503};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public pt4(WebView webView, at4 at4Var) {
        this(webView, new et4(), new bt4(), at4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, at4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((WebView) objArr2[0], (et4) objArr2[1], (bt4) objArr2[2], (at4) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static kt4 m(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, at4 at4Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), webView, webViewClient, webChromeClient, at4Var})) == null) {
            if (!z) {
                return new b(webView, null);
            }
            pt4 pt4Var = new pt4(webView, at4Var);
            pt4Var.c.b(webViewClient);
            pt4Var.d.d(webChromeClient);
            return pt4Var;
        }
        return (kt4) invokeCommon.objValue;
    }

    public static kt4 n(boolean z, BridgeWebView bridgeWebView, at4 at4Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), bridgeWebView, at4Var})) == null) {
            if (!z) {
                return new b(bridgeWebView, null);
            }
            WebViewClient webViewClient = bridgeWebView.webViewClient;
            WebChromeClient webChromeClient = bridgeWebView.chromeClient;
            pt4 pt4Var = new pt4(bridgeWebView, at4Var);
            pt4Var.c.b(webViewClient);
            pt4Var.d.d(webChromeClient);
            return pt4Var;
        }
        return (kt4) invokeCommon.objValue;
    }

    @Override // com.repackage.ht4
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                dt4.a("invalid callbackId.");
                return;
            }
            lt4 remove = this.g.remove(str);
            if (remove != null) {
                dt4.a("(" + remove.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + remove.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + ") timeout.");
                remove.g(1, null);
            }
        }
    }

    @Override // com.repackage.ht4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.j + 1;
            this.j = i;
            HashMap hashMap = new HashMap();
            hashMap.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            hashMap.put("version", "1.0");
            hashMap.put("logid", s());
            int[] iArr = k;
            l(lt4.i(hashMap, iArr[this.j % iArr.length], new a(this, i)), true);
            x("100", "");
        }
    }

    @Override // com.repackage.kt4
    public void c(lt4 lt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lt4Var) == null) {
            l(lt4Var, lt4Var.e == 3);
        }
    }

    @Override // com.repackage.kt4
    public void e(String str, ct4 ct4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, ct4Var) == null) || this.f.put(str, ct4Var) == null) {
            return;
        }
        throw new IllegalArgumentException("handler " + str + " exists.");
    }

    public final StringBuilder k() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            jSONObject.put("version", "1.0");
            jSONObject.put("logid", s());
            sb.append(jSONObject.toString());
            sb.append(WebvttCueParser.CHAR_SEMI_COLON);
            return sb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public final void l(lt4 lt4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, lt4Var, z) == null) {
            if (!z) {
                if (this.i != 0) {
                    String s = s();
                    dt4.b(s, "101", "(" + lt4Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + lt4Var.b + ") is called before bridge ready");
                }
                if (TextUtils.isEmpty(lt4Var.a) || TextUtils.isEmpty(lt4Var.b)) {
                    dt4.b(s(), "102", "the alias class or method is empty");
                    lt4Var.g(3, new IllegalArgumentException("cmd or method is illegal."));
                    return;
                }
            }
            if (!TextUtils.isEmpty(lt4Var.f)) {
                if (lt4Var.e != 3) {
                    this.g.put(lt4Var.f, lt4Var);
                    if (lt4Var.g > 0) {
                        d dVar = this.e;
                        dVar.sendMessageDelayed(Message.obtain(dVar, 2, lt4Var.f), lt4Var.g);
                    } else if (lt4Var.a != null || lt4Var.b != null) {
                        dt4.a("ignore timeout check for method call (" + lt4Var.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + lt4Var.b + ").");
                    }
                } else {
                    dt4.a("ignore timeout check for response method, callbackId " + lt4Var.f);
                }
            }
            try {
                String b2 = lt4Var.b();
                if (Build.VERSION.SDK_INT >= 19) {
                    this.a.evaluateJavascript(b2, null);
                } else {
                    this.a.loadUrl(b2);
                }
                dt4.a(b2);
            } catch (NullPointerException e) {
                x("500", e.getMessage());
            } catch (JSONException e2) {
                if (z) {
                    x("102", e2.getMessage());
                } else {
                    dt4.a(e2.getMessage());
                }
                lt4Var.g(2, e2);
            }
        }
    }

    public String o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            dt4.a("got js prompt in url:" + str + " with content:" + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("messageType");
                if ("ping".equals(optString)) {
                    v(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
                } else if ("request".equals(optString)) {
                    w(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
                } else if ("response".equals(optString)) {
                    v(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
                } else {
                    String s = s();
                    dt4.b(s, TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
                }
                return null;
            } catch (JSONException e) {
                dt4.b(s(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.j = -1;
            int i = this.i;
            if (i != 2 && i != 1) {
                dt4.a("current status " + this.i + ", broken because url changed to " + str);
                this.i = 2;
            }
            if (ot4.b(str) && ot4.a(str)) {
                dt4.a("current status " + this.i + ", constructing bridge for " + str);
                at4 at4Var = this.b;
                if (at4Var != null) {
                    at4Var.b();
                }
                r(this.a);
                at4 at4Var2 = this.b;
                if (at4Var2 != null) {
                    at4Var2.a();
                }
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.i == -1) {
                this.a.getSettings().setJavaScriptEnabled(true);
                this.a.setWebViewClient(this.c);
                this.a.setWebChromeClient(this.d);
                this.a.removeJavascriptInterface("searchBoxJavaBridge_");
                this.i = 1;
                return;
            }
            throw new IllegalStateException("Can't init bridge more than once.");
        }
    }

    public final void r(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, webView) == null) {
            this.h = String.valueOf(System.currentTimeMillis());
            try {
                InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                StringBuilder k2 = k();
                k2.append(new String(bArr));
                webView.loadUrl("javascript:" + k2.toString());
                this.e.sendEmptyMessageDelayed(1, 0L);
            } catch (Throwable th) {
                x("102", th.getMessage());
                dt4.a(th.toString());
            }
        }
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final void t(lt4 lt4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, lt4Var, i) == null) {
            this.i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (i >= 0) {
                int[] iArr = l;
                if (i < iArr.length) {
                    x(String.valueOf(iArr[i]), String.valueOf(currentTimeMillis - lt4Var.h));
                    return;
                }
            }
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            dt4.a("reInject for pingIndex " + this.j);
            r(this.a);
        }
    }

    public final void v(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                dt4.a("invalid callbackId.");
                return;
            }
            this.e.removeMessages(2, str);
            lt4 remove = this.g.remove(str);
            if (remove != null) {
                remove.h(jSONObject);
            }
        }
    }

    public final void w(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, jSONObject2) == null) {
            if (this.i != 0) {
                dt4.b(s(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
            }
            gt4 gt4Var = this.f.get(str);
            if (gt4Var == null) {
                gt4Var = new c(this, str);
                String s = s();
                dt4.b(s, TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
            }
            gt4Var.a(str2, jSONObject, jSONObject2);
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            dt4.c(s(), str, str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pt4(WebView webView, et4 et4Var, bt4 bt4Var, at4 at4Var) {
        super(webView, at4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, et4Var, bt4Var, at4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((WebView) objArr2[0], (at4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = String.valueOf(System.currentTimeMillis());
        this.i = -1;
        this.j = -1;
        this.c = et4Var;
        this.d = bt4Var;
        bt4Var.c(this);
        this.c.a(this);
        this.e = new d(this);
        this.f = new HashMap<>(16);
        this.g = new HashMap<>(8);
        q();
    }
}
