package com.win.opensdk.webviewbase;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import c.m.a.b6;
import c.m.a.c;
import c.m.a.f;
import c.m.a.r0;
import c.m.a.x5;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.InputType;
import com.tachikoma.core.event.base.TKBaseEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
/* loaded from: classes7.dex */
public class AdvancedWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference f44049b;

    /* renamed from: c  reason: collision with root package name */
    public f f44050c;

    /* renamed from: d  reason: collision with root package name */
    public final List f44051d;

    /* renamed from: e  reason: collision with root package name */
    public ValueCallback f44052e;

    /* renamed from: f  reason: collision with root package name */
    public ValueCallback f44053f;

    /* renamed from: g  reason: collision with root package name */
    public long f44054g;

    /* renamed from: h  reason: collision with root package name */
    public String f44055h;
    public int i;
    public WebViewClient j;
    public WebChromeClient k;
    public boolean l;
    public String m;
    public final Map n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1750008885, "Lcom/win/opensdk/webviewbase/AdvancedWebView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1750008885, "Lcom/win/opensdk/webviewbase/AdvancedWebView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44051d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f44051d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f44051d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        d(context);
    }

    public static String getLanguageIso3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return Locale.getDefault().getISO3Language().toLowerCase(Locale.US);
            } catch (MissingResourceException unused) {
                return "eng";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? new String(Base64.decode(str, 0), "UTF-8") : (String) invokeL.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:27:0x005f). Please submit an issue!!! */
    public void a(int i, int i2, Intent intent) {
        Uri[] uriArr;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) && i == this.i) {
            if (i2 != -1) {
                ValueCallback valueCallback = this.f44052e;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this.f44052e = null;
                }
                ValueCallback valueCallback2 = this.f44053f;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(null);
                    this.f44053f = null;
                }
            } else if (intent != null) {
                ValueCallback valueCallback3 = this.f44052e;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(intent.getData());
                    this.f44052e = null;
                } else if (this.f44053f != null) {
                    try {
                    } catch (Exception unused) {
                    }
                    if (intent.getDataString() != null) {
                        uriArr = new Uri[]{Uri.parse(intent.getDataString())};
                    } else {
                        if (Build.VERSION.SDK_INT >= 16 && intent.getClipData() != null) {
                            int itemCount = intent.getClipData().getItemCount();
                            Uri[] uriArr2 = new Uri[itemCount];
                            for (i3 = 0; i3 < itemCount; i3++) {
                                try {
                                    uriArr2[i3] = intent.getClipData().getItemAt(i3).getUri();
                                } catch (Exception unused2) {
                                }
                            }
                            uriArr = uriArr2;
                        }
                        uriArr = null;
                    }
                    this.f44053f.onReceiveValue(uriArr);
                    this.f44053f = null;
                }
            }
        }
    }

    public void b(Activity activity, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, fVar) == null) {
            c(activity, fVar, 51426);
        }
    }

    public void c(Activity activity, f fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, activity, fVar, i) == null) {
            if (activity != null) {
                this.a = new WeakReference(activity);
            } else {
                this.a = null;
            }
            g(fVar, i);
        }
    }

    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || isInEditMode()) {
            return;
        }
        if (context instanceof Activity) {
            this.a = new WeakReference((Activity) context);
        }
        this.f44055h = getLanguageIso3();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setSaveEnabled(true);
        r0.m(this);
        super.setWebViewClient(new x5(this));
        super.setWebChromeClient(new b6(this));
        setDownloadListener(new c(this));
    }

    public void e(ValueCallback valueCallback, ValueCallback valueCallback2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, valueCallback, valueCallback2, z) == null) {
            ValueCallback valueCallback3 = this.f44052e;
            if (valueCallback3 != null) {
                valueCallback3.onReceiveValue(null);
            }
            this.f44052e = valueCallback;
            ValueCallback valueCallback4 = this.f44053f;
            if (valueCallback4 != null) {
                valueCallback4.onReceiveValue(null);
            }
            this.f44053f = valueCallback2;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (z && Build.VERSION.SDK_INT >= 18) {
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            }
            intent.setType(this.m);
            WeakReference weakReference = this.f44049b;
            if (weakReference != null && weakReference.get() != null && Build.VERSION.SDK_INT >= 11) {
                ((Fragment) this.f44049b.get()).startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.i);
                return;
            }
            WeakReference weakReference2 = this.a;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            ((Activity) this.a.get()).startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.i);
        }
    }

    public void f(WebSettings webSettings, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, webSettings, z) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        webSettings.setMixedContentMode(!z ? 1 : 0);
    }

    public void g(f fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, fVar, i) == null) {
            this.f44050c = fVar;
            this.i = i;
        }
    }

    public String getFileUploadPromptLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return this.f44055h.equals("zho") ? j("6YCJ5oup5LiA5Liq5paH5Lu2") : this.f44055h.equals("spa") ? j("RWxpamEgdW4gYXJjaGl2bw==") : this.f44055h.equals("hin") ? j("4KSP4KSVIOCkq+CkvOCkvuCkh+CksiDgpJrgpYHgpKjgpYfgpII=") : this.f44055h.equals("ben") ? j("4KaP4KaV4Kaf4Ka/IOCmq+CmvuCmh+CmsiDgpqjgpr/gprDgp43gpqzgpr7gpprgpqg=") : this.f44055h.equals("ara") ? j("2KfYrtiq2YrYp9ixINmF2YTZgSDZiNin2K3Yrw==") : this.f44055h.equals("por") ? j("RXNjb2xoYSB1bSBhcnF1aXZv") : this.f44055h.equals("rus") ? j("0JLRi9Cx0LXRgNC40YLQtSDQvtC00LjQvSDRhNCw0LnQuw==") : this.f44055h.equals("jpn") ? j("MeODleOCoeOCpOODq+OCkumBuOaKnuOBl+OBpuOBj+OBoOOBleOBhA==") : this.f44055h.equals(TKBaseEvent.TK_PAN_EVENT_NAME) ? j("4KiH4Kmx4KiVIOCoq+CovuCoh+CosiDgqJrgqYHgqKPgqYs=") : this.f44055h.equals("deu") ? j("V8OkaGxlIGVpbmUgRGF0ZWk=") : this.f44055h.equals("jav") ? j("UGlsaWggc2lqaSBiZXJrYXM=") : this.f44055h.equals("msa") ? j("UGlsaWggc2F0dSBmYWls") : this.f44055h.equals(InputType.TEL) ? j("4LCS4LCVIOCwq+CxhuCxluCwsuCxjeCwqOCxgSDgsI7gsILgsJrgsYHgsJXgsYvgsILgsKHgsL8=") : this.f44055h.equals("vie") ? j("Q2jhu41uIG3hu5l0IHThuq1wIHRpbg==") : this.f44055h.equals("kor") ? j("7ZWY64KY7J2YIO2MjOydvOydhCDshKDtg50=") : this.f44055h.equals("fra") ? j("Q2hvaXNpc3NleiB1biBmaWNoaWVy") : this.f44055h.equals("mar") ? j("4KSr4KS+4KSH4KSyIOCkqOCkv+CkteCkoeCkvg==") : this.f44055h.equals("tam") ? j("4K6S4K6w4K+BIOCuleCvh+CuvuCuquCvjeCuquCviCDgrqTgr4fgrrDgr43grrXgr4E=") : this.f44055h.equals("urd") ? j("2KfbjNqpINmB2KfYptmEINmF24zauiDYs9uSINin2YbYqtiu2KfYqCDaqdix24zaug==") : this.f44055h.equals("fas") ? j("2LHYpyDYp9mG2KrYrtin2Kgg2qnZhtuM2K8g24zaqSDZgdin24zZhA==") : this.f44055h.equals("tur") ? j("QmlyIGRvc3lhIHNlw6dpbg==") : this.f44055h.equals("ita") ? j("U2NlZ2xpIHVuIGZpbGU=") : this.f44055h.equals("tha") ? j("4LmA4Lil4Li34Lit4LiB4LmE4Lif4Lil4LmM4Lir4LiZ4Li24LmI4LiH") : this.f44055h.equals("guj") ? j("4KqP4KqVIOCqq+CqvuCqh+CqsuCqqOCrhyDgqqrgqrjgqoLgqqY=") : "Choose a file";
            } catch (Exception unused) {
                return "Choose a file";
            }
        }
        return (String) invokeV.objValue;
    }

    public List getPermittedHostnames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f44051d : (List) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f44054g + 500 >= System.currentTimeMillis() : invokeV.booleanValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (this.f44051d.size() == 0) {
                return true;
            }
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (host != null && host.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%\\[\\]-]*$")) {
                String userInfo = parse.getUserInfo();
                if (userInfo == null || userInfo.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%-]*$")) {
                    for (String str2 : this.f44051d) {
                        if (!host.equals(str2)) {
                            if (host.endsWith("." + str2)) {
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (canGoBack()) {
                goBack();
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                ((ViewGroup) getParent()).removeView(this);
            } catch (Exception unused) {
            }
            try {
                removeAllViews();
            } catch (Exception unused2) {
            }
            destroy();
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (this.n.size() > 0) {
                super.loadUrl(str, this.n);
            } else {
                super.loadUrl(str);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.win.opensdk.webviewbase.AdvancedWebView */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebView
    public void loadUrl(String str, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, map) == null) {
            if (map == null) {
                map = this.n;
            } else if (this.n.size() > 0) {
                map.putAll(this.n);
            }
            super.loadUrl(str, map);
        }
    }

    public void m() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            WeakReference weakReference = this.f44049b;
            if (weakReference == null || weakReference.get() == null || Build.VERSION.SDK_INT < 11 || ((Fragment) this.f44049b.get()).getActivity() == null) {
                WeakReference weakReference2 = this.a;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return;
                }
                activity = (Activity) this.a.get();
            } else {
                activity = ((Fragment) this.f44049b.get()).getActivity();
            }
            getSettings().setGeolocationDatabasePath(activity.getFilesDir().getPath());
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f44054g = System.currentTimeMillis();
        }
    }

    @Override // android.webkit.WebView
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            pauseTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                super.onPause();
            }
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                super.onResume();
            }
            resumeTimers();
        }
    }

    public void setCookiesEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            CookieManager.getInstance().setAcceptCookie(z);
        }
    }

    public void setDesktopMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            WebSettings settings = getSettings();
            String userAgentString = settings.getUserAgentString();
            settings.setUserAgentString(z ? userAgentString.replace("Mobile", "eliboM").replace("Android", "diordnA") : userAgentString.replace("eliboM", "Mobile").replace("diordnA", "Android"));
            settings.setUseWideViewPort(z);
            settings.setLoadWithOverviewMode(z);
            settings.setSupportZoom(z);
            settings.setBuiltInZoomControls(z);
        }
    }

    public void setGeolocationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                getSettings().setJavaScriptEnabled(true);
                getSettings().setGeolocationEnabled(true);
                m();
            }
            this.l = z;
        }
    }

    public void setMixedContentAllowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            f(getSettings(), z);
        }
    }

    public void setThirdPartyCookiesEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, z);
    }

    public void setUploadableFileTypes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.m = str;
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, webChromeClient) == null) {
            this.k = webChromeClient;
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, webViewClient) == null) {
            this.j = webViewClient;
        }
    }
}
