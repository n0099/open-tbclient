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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.A2;
import com.win.opensdk.B2;
import com.win.opensdk.M;
import com.win.opensdk.y2;
import com.win.opensdk.z2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
/* loaded from: classes10.dex */
public class AdvancedWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference a;
    public WeakReference b;
    public B2 c;
    public final List d;
    public ValueCallback e;
    public ValueCallback f;
    public long g;
    public String h;
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
        this.d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        a(context);
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
        this.d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        a(context);
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
        this.d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        a(context);
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? new String(Base64.decode(str, 0), "UTF-8") : (String) invokeL.objValue;
    }

    public static String getLanguageIso3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                return Locale.getDefault().getISO3Language().toLowerCase(Locale.US);
            } catch (MissingResourceException unused) {
                return "eng";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:27:0x005f). Please submit an issue!!! */
    public void a(int i, int i2, Intent intent) {
        Uri[] uriArr;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) && i == this.i) {
            if (i2 != -1) {
                ValueCallback valueCallback = this.e;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this.e = null;
                }
                ValueCallback valueCallback2 = this.f;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(null);
                    this.f = null;
                }
            } else if (intent != null) {
                ValueCallback valueCallback3 = this.e;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(intent.getData());
                    this.e = null;
                } else if (this.f != null) {
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
                    this.f.onReceiveValue(uriArr);
                    this.f = null;
                }
            }
        }
    }

    public void a(Activity activity, B2 b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, b2) == null) {
            a(activity, b2, 51426);
        }
    }

    public void a(Activity activity, B2 b2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, activity, b2, i) == null) {
            if (activity != null) {
                this.a = new WeakReference(activity);
            } else {
                this.a = null;
            }
            a(b2, i);
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, context) == null) || isInEditMode()) {
            return;
        }
        if (context instanceof Activity) {
            this.a = new WeakReference((Activity) context);
        }
        this.h = getLanguageIso3();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setSaveEnabled(true);
        M.a(this);
        super.setWebViewClient(new y2(this));
        super.setWebChromeClient(new z2(this));
        setDownloadListener(new A2(this));
    }

    public void a(ValueCallback valueCallback, ValueCallback valueCallback2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, valueCallback, valueCallback2, z) == null) {
            ValueCallback valueCallback3 = this.e;
            if (valueCallback3 != null) {
                valueCallback3.onReceiveValue(null);
            }
            this.e = valueCallback;
            ValueCallback valueCallback4 = this.f;
            if (valueCallback4 != null) {
                valueCallback4.onReceiveValue(null);
            }
            this.f = valueCallback2;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (z && Build.VERSION.SDK_INT >= 18) {
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            }
            intent.setType(this.m);
            WeakReference weakReference = this.b;
            if (weakReference != null && weakReference.get() != null && Build.VERSION.SDK_INT >= 11) {
                ((Fragment) this.b.get()).startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.i);
                return;
            }
            WeakReference weakReference2 = this.a;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            ((Activity) this.a.get()).startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.i);
        }
    }

    public void a(WebSettings webSettings, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, webSettings, z) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        webSettings.setMixedContentMode(!z ? 1 : 0);
    }

    public void a(B2 b2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, b2, i) == null) {
            this.c = b2;
            this.i = i;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g + 500 >= System.currentTimeMillis() : invokeV.booleanValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.d.size() == 0) {
                return true;
            }
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (host != null && host.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%\\[\\]-]*$")) {
                String userInfo = parse.getUserInfo();
                if (userInfo == null || userInfo.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%-]*$")) {
                    for (String str2 : this.d) {
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

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (canGoBack()) {
                goBack();
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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

    public void d() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            WeakReference weakReference = this.b;
            if (weakReference == null || weakReference.get() == null || Build.VERSION.SDK_INT < 11 || ((Fragment) this.b.get()).getActivity() == null) {
                WeakReference weakReference2 = this.a;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return;
                }
                activity = (Activity) this.a.get();
            } else {
                activity = ((Fragment) this.b.get()).getActivity();
            }
            getSettings().setGeolocationDatabasePath(activity.getFilesDir().getPath());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = System.currentTimeMillis();
        }
    }

    public String getFileUploadPromptLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                return this.h.equals("zho") ? b("6YCJ5oup5LiA5Liq5paH5Lu2") : this.h.equals("spa") ? b("RWxpamEgdW4gYXJjaGl2bw==") : this.h.equals("hin") ? b("4KSP4KSVIOCkq+CkvOCkvuCkh+CksiDgpJrgpYHgpKjgpYfgpII=") : this.h.equals("ben") ? b("4KaP4KaV4Kaf4Ka/IOCmq+CmvuCmh+CmsiDgpqjgpr/gprDgp43gpqzgpr7gpprgpqg=") : this.h.equals("ara") ? b("2KfYrtiq2YrYp9ixINmF2YTZgSDZiNin2K3Yrw==") : this.h.equals("por") ? b("RXNjb2xoYSB1bSBhcnF1aXZv") : this.h.equals("rus") ? b("0JLRi9Cx0LXRgNC40YLQtSDQvtC00LjQvSDRhNCw0LnQuw==") : this.h.equals("jpn") ? b("MeODleOCoeOCpOODq+OCkumBuOaKnuOBl+OBpuOBj+OBoOOBleOBhA==") : this.h.equals("pan") ? b("4KiH4Kmx4KiVIOCoq+CovuCoh+CosiDgqJrgqYHgqKPgqYs=") : this.h.equals("deu") ? b("V8OkaGxlIGVpbmUgRGF0ZWk=") : this.h.equals("jav") ? b("UGlsaWggc2lqaSBiZXJrYXM=") : this.h.equals("msa") ? b("UGlsaWggc2F0dSBmYWls") : this.h.equals("tel") ? b("4LCS4LCVIOCwq+CxhuCxluCwsuCxjeCwqOCxgSDgsI7gsILgsJrgsYHgsJXgsYvgsILgsKHgsL8=") : this.h.equals("vie") ? b("Q2jhu41uIG3hu5l0IHThuq1wIHRpbg==") : this.h.equals("kor") ? b("7ZWY64KY7J2YIO2MjOydvOydhCDshKDtg50=") : this.h.equals("fra") ? b("Q2hvaXNpc3NleiB1biBmaWNoaWVy") : this.h.equals("mar") ? b("4KSr4KS+4KSH4KSyIOCkqOCkv+CkteCkoeCkvg==") : this.h.equals("tam") ? b("4K6S4K6w4K+BIOCuleCvh+CuvuCuquCvjeCuquCviCDgrqTgr4fgrrDgr43grrXgr4E=") : this.h.equals("urd") ? b("2KfbjNqpINmB2KfYptmEINmF24zauiDYs9uSINin2YbYqtiu2KfYqCDaqdix24zaug==") : this.h.equals("fas") ? b("2LHYpyDYp9mG2KrYrtin2Kgg2qnZhtuM2K8g24zaqSDZgdin24zZhA==") : this.h.equals("tur") ? b("QmlyIGRvc3lhIHNlw6dpbg==") : this.h.equals("ita") ? b("U2NlZ2xpIHVuIGZpbGU=") : this.h.equals("tha") ? b("4LmA4Lil4Li34Lit4LiB4LmE4Lif4Lil4LmM4Lir4LiZ4Li24LmI4LiH") : this.h.equals("guj") ? b("4KqP4KqVIOCqq+CqvuCqh+CqsuCqqOCrhyDgqqrgqrjgqoLgqqY=") : "Choose a file";
            } catch (Exception unused) {
                return "Choose a file";
            }
        }
        return (String) invokeV.objValue;
    }

    public List getPermittedHostnames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
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
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, map) == null) {
            if (map == null) {
                map = this.n;
            } else if (this.n.size() > 0) {
                map.putAll(this.n);
            }
            super.loadUrl(str, map);
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
                d();
            }
            this.l = z;
        }
    }

    public void setMixedContentAllowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            a(getSettings(), z);
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
