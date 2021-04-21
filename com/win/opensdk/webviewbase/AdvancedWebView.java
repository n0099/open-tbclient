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
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.win.opensdk.v2;
import com.win.opensdk.w2;
import com.win.opensdk.x2;
import com.win.opensdk.y2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
/* loaded from: classes7.dex */
public class AdvancedWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f40474a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference f40475b;

    /* renamed from: c  reason: collision with root package name */
    public y2 f40476c;

    /* renamed from: d  reason: collision with root package name */
    public final List f40477d;

    /* renamed from: e  reason: collision with root package name */
    public ValueCallback f40478e;

    /* renamed from: f  reason: collision with root package name */
    public ValueCallback f40479f;

    /* renamed from: g  reason: collision with root package name */
    public long f40480g;

    /* renamed from: h  reason: collision with root package name */
    public String f40481h;
    public int i;
    public WebViewClient j;
    public WebChromeClient k;
    public boolean l;
    public String m;
    public final Map n;

    public AdvancedWebView(Context context) {
        super(context);
        this.f40477d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        a(context);
    }

    public AdvancedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40477d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        a(context);
    }

    public AdvancedWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40477d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        a(context);
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 0), "UTF-8");
    }

    public static String getLanguageIso3() {
        try {
            return Locale.getDefault().getISO3Language().toLowerCase(Locale.US);
        } catch (MissingResourceException unused) {
            return "eng";
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005a -> B:25:0x005b). Please submit an issue!!! */
    public void a(int i, int i2, Intent intent) {
        Uri[] uriArr;
        int i3;
        if (i == this.i) {
            if (i2 != -1) {
                ValueCallback valueCallback = this.f40478e;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this.f40478e = null;
                }
                ValueCallback valueCallback2 = this.f40479f;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(null);
                    this.f40479f = null;
                }
            } else if (intent != null) {
                ValueCallback valueCallback3 = this.f40478e;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(intent.getData());
                    this.f40478e = null;
                } else if (this.f40479f != null) {
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
                    this.f40479f.onReceiveValue(uriArr);
                    this.f40479f = null;
                }
            }
        }
    }

    public void a(Activity activity, y2 y2Var) {
        a(activity, y2Var, 51426);
    }

    public void a(Activity activity, y2 y2Var, int i) {
        if (activity != null) {
            this.f40474a = new WeakReference(activity);
        } else {
            this.f40474a = null;
        }
        a(y2Var, i);
    }

    public void a(Context context) {
        if (isInEditMode()) {
            return;
        }
        if (context instanceof Activity) {
            this.f40474a = new WeakReference((Activity) context);
        }
        this.f40481h = getLanguageIso3();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setSaveEnabled(true);
        String path = context.getFilesDir().getPath();
        String str = path.substring(0, path.lastIndexOf("/")) + "/databases";
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT < 18) {
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
        settings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < 19) {
            settings.setDatabasePath(str);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        setThirdPartyCookiesEnabled(true);
        super.setWebViewClient(new v2(this, context));
        super.setWebChromeClient(new w2(this));
        setDownloadListener(new x2(this));
    }

    public void a(ValueCallback valueCallback, ValueCallback valueCallback2, boolean z) {
        ValueCallback valueCallback3 = this.f40478e;
        if (valueCallback3 != null) {
            valueCallback3.onReceiveValue(null);
        }
        this.f40478e = valueCallback;
        ValueCallback valueCallback4 = this.f40479f;
        if (valueCallback4 != null) {
            valueCallback4.onReceiveValue(null);
        }
        this.f40479f = valueCallback2;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (z && Build.VERSION.SDK_INT >= 18) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        intent.setType(this.m);
        WeakReference weakReference = this.f40475b;
        if (weakReference != null && weakReference.get() != null && Build.VERSION.SDK_INT >= 11) {
            ((Fragment) this.f40475b.get()).startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.i);
            return;
        }
        WeakReference weakReference2 = this.f40474a;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        ((Activity) this.f40474a.get()).startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.i);
    }

    public void a(WebSettings webSettings, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(!z ? 1 : 0);
        }
    }

    public void a(y2 y2Var, int i) {
        this.f40476c = y2Var;
        this.i = i;
    }

    public boolean a() {
        return this.f40480g + 500 >= System.currentTimeMillis();
    }

    public boolean a(String str) {
        if (this.f40477d.size() == 0) {
            return true;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host != null && host.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%\\[\\]-]*$")) {
            String userInfo = parse.getUserInfo();
            if (userInfo == null || userInfo.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%-]*$")) {
                for (String str2 : this.f40477d) {
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

    public boolean b() {
        if (canGoBack()) {
            goBack();
            return false;
        }
        return true;
    }

    public void c() {
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

    public void d() {
        Activity activity;
        WeakReference weakReference = this.f40475b;
        if (weakReference == null || weakReference.get() == null || Build.VERSION.SDK_INT < 11 || ((Fragment) this.f40475b.get()).getActivity() == null) {
            WeakReference weakReference2 = this.f40474a;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            activity = (Activity) this.f40474a.get();
        } else {
            activity = ((Fragment) this.f40475b.get()).getActivity();
        }
        getSettings().setGeolocationDatabasePath(activity.getFilesDir().getPath());
    }

    public void e() {
        this.f40480g = System.currentTimeMillis();
    }

    public String getFileUploadPromptLabel() {
        try {
            return this.f40481h.equals("zho") ? b("6YCJ5oup5LiA5Liq5paH5Lu2") : this.f40481h.equals("spa") ? b("RWxpamEgdW4gYXJjaGl2bw==") : this.f40481h.equals("hin") ? b("4KSP4KSVIOCkq+CkvOCkvuCkh+CksiDgpJrgpYHgpKjgpYfgpII=") : this.f40481h.equals("ben") ? b("4KaP4KaV4Kaf4Ka/IOCmq+CmvuCmh+CmsiDgpqjgpr/gprDgp43gpqzgpr7gpprgpqg=") : this.f40481h.equals("ara") ? b("2KfYrtiq2YrYp9ixINmF2YTZgSDZiNin2K3Yrw==") : this.f40481h.equals("por") ? b("RXNjb2xoYSB1bSBhcnF1aXZv") : this.f40481h.equals("rus") ? b("0JLRi9Cx0LXRgNC40YLQtSDQvtC00LjQvSDRhNCw0LnQuw==") : this.f40481h.equals("jpn") ? b("MeODleOCoeOCpOODq+OCkumBuOaKnuOBl+OBpuOBj+OBoOOBleOBhA==") : this.f40481h.equals("pan") ? b("4KiH4Kmx4KiVIOCoq+CovuCoh+CosiDgqJrgqYHgqKPgqYs=") : this.f40481h.equals("deu") ? b("V8OkaGxlIGVpbmUgRGF0ZWk=") : this.f40481h.equals("jav") ? b("UGlsaWggc2lqaSBiZXJrYXM=") : this.f40481h.equals(IAdRequestParam.MSA) ? b("UGlsaWggc2F0dSBmYWls") : this.f40481h.equals("tel") ? b("4LCS4LCVIOCwq+CxhuCxluCwsuCxjeCwqOCxgSDgsI7gsILgsJrgsYHgsJXgsYvgsILgsKHgsL8=") : this.f40481h.equals("vie") ? b("Q2jhu41uIG3hu5l0IHThuq1wIHRpbg==") : this.f40481h.equals("kor") ? b("7ZWY64KY7J2YIO2MjOydvOydhCDshKDtg50=") : this.f40481h.equals("fra") ? b("Q2hvaXNpc3NleiB1biBmaWNoaWVy") : this.f40481h.equals("mar") ? b("4KSr4KS+4KSH4KSyIOCkqOCkv+CkteCkoeCkvg==") : this.f40481h.equals("tam") ? b("4K6S4K6w4K+BIOCuleCvh+CuvuCuquCvjeCuquCviCDgrqTgr4fgrrDgr43grrXgr4E=") : this.f40481h.equals("urd") ? b("2KfbjNqpINmB2KfYptmEINmF24zauiDYs9uSINin2YbYqtiu2KfYqCDaqdix24zaug==") : this.f40481h.equals("fas") ? b("2LHYpyDYp9mG2KrYrtin2Kgg2qnZhtuM2K8g24zaqSDZgdin24zZhA==") : this.f40481h.equals("tur") ? b("QmlyIGRvc3lhIHNlw6dpbg==") : this.f40481h.equals("ita") ? b("U2NlZ2xpIHVuIGZpbGU=") : this.f40481h.equals("tha") ? b("4LmA4Lil4Li34Lit4LiB4LmE4Lif4Lil4LmM4Lir4LiZ4Li24LmI4LiH") : this.f40481h.equals("guj") ? b("4KqP4KqVIOCqq+CqvuCqh+CqsuCqqOCrhyDgqqrgqrjgqoLgqqY=") : "Choose a file";
        } catch (Exception unused) {
            return "Choose a file";
        }
    }

    public List getPermittedHostnames() {
        return this.f40477d;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (this.n.size() > 0) {
            super.loadUrl(str, this.n);
        } else {
            super.loadUrl(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.win.opensdk.webviewbase.AdvancedWebView */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebView
    public void loadUrl(String str, Map map) {
        if (map == null) {
            map = this.n;
        } else if (this.n.size() > 0) {
            map.putAll(this.n);
        }
        super.loadUrl(str, map);
    }

    @Override // android.webkit.WebView
    public void onPause() {
        pauseTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            super.onPause();
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.onResume();
        }
        resumeTimers();
    }

    public void setCookiesEnabled(boolean z) {
        CookieManager.getInstance().setAcceptCookie(z);
    }

    public void setDesktopMode(boolean z) {
        WebSettings settings = getSettings();
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(z ? userAgentString.replace("Mobile", "eliboM").replace("Android", "diordnA") : userAgentString.replace("eliboM", "Mobile").replace("diordnA", "Android"));
        settings.setUseWideViewPort(z);
        settings.setLoadWithOverviewMode(z);
        settings.setSupportZoom(z);
        settings.setBuiltInZoomControls(z);
    }

    public void setGeolocationEnabled(boolean z) {
        if (z) {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setGeolocationEnabled(true);
            d();
        }
        this.l = z;
    }

    public void setMixedContentAllowed(boolean z) {
        a(getSettings(), z);
    }

    public void setThirdPartyCookiesEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, z);
        }
    }

    public void setUploadableFileTypes(String str) {
        this.m = str;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.k = webChromeClient;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.j = webViewClient;
    }
}
