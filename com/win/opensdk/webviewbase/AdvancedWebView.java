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
import com.win.opensdk.es;
import com.win.opensdk.ev;
import com.win.opensdk.ey;
import com.win.opensdk.fb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
/* loaded from: classes14.dex */
public class AdvancedWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f8178a;
    public WeakReference b;
    public final List d;
    public ValueCallback e;
    public ValueCallback f;
    public long g;
    public String h;
    public int i;
    public boolean l;
    public String m;
    public final Map n;
    public fb qmu;
    public WebViewClient qmv;
    public WebChromeClient qmw;

    static {
        String[] strArr = {"org.mozilla.firefox", "com.android.chrome", "com.opera.browser", "org.mozilla.firefox_beta", "com.chrome.beta", "com.opera.browser.beta"};
    }

    public AdvancedWebView(Context context) {
        super(context);
        this.d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        a(context);
    }

    public AdvancedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new LinkedList();
        this.i = 51426;
        this.m = "*/*";
        this.n = new HashMap();
        a(context);
    }

    public AdvancedWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new LinkedList();
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
        } catch (MissingResourceException e) {
            return "eng";
        }
    }

    public void a(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == this.i) {
            if (i2 != -1) {
                ValueCallback valueCallback = this.e;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                    this.e = null;
                    return;
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
                        if (intent.getDataString() != null) {
                            uriArr = new Uri[]{Uri.parse(intent.getDataString())};
                        } else if (Build.VERSION.SDK_INT < 16 || intent.getClipData() == null) {
                            uriArr = null;
                        } else {
                            int itemCount = intent.getClipData().getItemCount();
                            uriArr = new Uri[itemCount];
                            for (int i3 = 0; i3 < itemCount; i3++) {
                                try {
                                    uriArr[i3] = intent.getClipData().getItemAt(i3).getUri();
                                } catch (Exception e) {
                                }
                            }
                        }
                    } catch (Exception e2) {
                        uriArr = null;
                    }
                    this.f.onReceiveValue(uriArr);
                    this.f = null;
                }
            }
        }
    }

    public void a(Activity activity, fb fbVar) {
        a(activity, fbVar, 51426);
    }

    public void a(Activity activity, fb fbVar, int i) {
        if (activity != null) {
            this.f8178a = new WeakReference(activity);
        } else {
            this.f8178a = null;
        }
        a(fbVar, i);
    }

    public void a(ValueCallback valueCallback, ValueCallback valueCallback2, boolean z) {
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
        WeakReference weakReference2 = this.f8178a;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        ((Activity) this.f8178a.get()).startActivityForResult(Intent.createChooser(intent, getFileUploadPromptLabel()), this.i);
    }

    public void a(WebSettings webSettings, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(!z ? 1 : 0);
        }
    }

    public void a(fb fbVar, int i) {
        this.qmu = fbVar;
        this.i = i;
    }

    public boolean a() {
        return this.g + 500 >= System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str) {
        if (this.d.size() == 0) {
            return true;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host != null && host.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%\\[\\]-]*$")) {
            String userInfo = parse.getUserInfo();
            if (userInfo == null || userInfo.matches("^[a-zA-Z0-9._!~*')(;:&=+$,%-]*$")) {
                for (String str2 : this.d) {
                    if (host.equals(str2) || host.endsWith("." + str2)) {
                        return true;
                    }
                    while (r4.hasNext()) {
                    }
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
        } catch (Exception e) {
        }
        try {
            removeAllViews();
        } catch (Exception e2) {
        }
        destroy();
    }

    public void d() {
        Activity activity;
        WeakReference weakReference = this.b;
        if (weakReference == null || weakReference.get() == null || Build.VERSION.SDK_INT < 11 || ((Fragment) this.b.get()).getActivity() == null) {
            WeakReference weakReference2 = this.f8178a;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            activity = (Activity) this.f8178a.get();
        } else {
            activity = ((Fragment) this.b.get()).getActivity();
        }
        getSettings().setGeolocationDatabasePath(activity.getFilesDir().getPath());
    }

    public void e() {
        this.g = System.currentTimeMillis();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x01da -> B:5:0x0012). Please submit an issue!!! */
    public String getFileUploadPromptLabel() {
        if (this.h.equals("zho")) {
            return b("6YCJ5oup5LiA5Liq5paH5Lu2");
        } else if (this.h.equals("spa")) {
            return b("RWxpamEgdW4gYXJjaGl2bw==");
        } else {
            if (this.h.equals("hin")) {
                return b("4KSP4KSVIOCkq+CkvOCkvuCkh+CksiDgpJrgpYHgpKjgpYfgpII=");
            }
            if (this.h.equals("ben")) {
                return b("4KaP4KaV4Kaf4Ka/IOCmq+CmvuCmh+CmsiDgpqjgpr/gprDgp43gpqzgpr7gpprgpqg=");
            }
            if (this.h.equals("ara")) {
                return b("2KfYrtiq2YrYp9ixINmF2YTZgSDZiNin2K3Yrw==");
            }
            if (this.h.equals("por")) {
                return b("RXNjb2xoYSB1bSBhcnF1aXZv");
            }
            if (this.h.equals("rus")) {
                return b("0JLRi9Cx0LXRgNC40YLQtSDQvtC00LjQvSDRhNCw0LnQuw==");
            }
            if (this.h.equals("jpn")) {
                return b("MeODleOCoeOCpOODq+OCkumBuOaKnuOBl+OBpuOBj+OBoOOBleOBhA==");
            }
            if (this.h.equals("pan")) {
                return b("4KiH4Kmx4KiVIOCoq+CovuCoh+CosiDgqJrgqYHgqKPgqYs=");
            }
            if (this.h.equals("deu")) {
                return b("V8OkaGxlIGVpbmUgRGF0ZWk=");
            }
            if (this.h.equals("jav")) {
                return b("UGlsaWggc2lqaSBiZXJrYXM=");
            }
            if (this.h.equals("msa")) {
                return b("UGlsaWggc2F0dSBmYWls");
            }
            if (this.h.equals("tel")) {
                return b("4LCS4LCVIOCwq+CxhuCxluCwsuCxjeCwqOCxgSDgsI7gsILgsJrgsYHgsJXgsYvgsILgsKHgsL8=");
            }
            if (this.h.equals("vie")) {
                return b("Q2jhu41uIG3hu5l0IHThuq1wIHRpbg==");
            }
            if (this.h.equals("kor")) {
                return b("7ZWY64KY7J2YIO2MjOydvOydhCDshKDtg50=");
            }
            if (this.h.equals("fra")) {
                return b("Q2hvaXNpc3NleiB1biBmaWNoaWVy");
            }
            if (this.h.equals("mar")) {
                return b("4KSr4KS+4KSH4KSyIOCkqOCkv+CkteCkoeCkvg==");
            }
            if (this.h.equals("tam")) {
                return b("4K6S4K6w4K+BIOCuleCvh+CuvuCuquCvjeCuquCviCDgrqTgr4fgrrDgr43grrXgr4E=");
            }
            if (this.h.equals("urd")) {
                return b("2KfbjNqpINmB2KfYptmEINmF24zauiDYs9uSINin2YbYqtiu2KfYqCDaqdix24zaug==");
            }
            if (this.h.equals("fas")) {
                return b("2LHYpyDYp9mG2KrYrtin2Kgg2qnZhtuM2K8g24zaqSDZgdin24zZhA==");
            }
            if (this.h.equals("tur")) {
                return b("QmlyIGRvc3lhIHNlw6dpbg==");
            }
            if (this.h.equals("ita")) {
                return b("U2NlZ2xpIHVuIGZpbGU=");
            }
            if (this.h.equals("tha")) {
                return b("4LmA4Lil4Li34Lit4LiB4LmE4Lif4Lil4LmM4Lir4LiZ4Li24LmI4LiH");
            }
            if (this.h.equals("guj")) {
                return b("4KqP4KqVIOCqq+CqvuCqh+CqsuCqqOCrhyDgqqrgqrjgqoLgqqY=");
            }
            return "Choose a file";
        }
    }

    public List getPermittedHostnames() {
        return this.d;
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
        settings.setUserAgentString(z ? settings.getUserAgentString().replace("Mobile", "eliboM").replace("Android", "diordnA") : settings.getUserAgentString().replace("eliboM", "Mobile").replace("diordnA", "Android"));
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
        this.qmw = webChromeClient;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.qmv = webViewClient;
    }

    public void a(Context context) {
        if (!isInEditMode()) {
            if (context instanceof Activity) {
                this.f8178a = new WeakReference((Activity) context);
            }
            this.h = getLanguageIso3();
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
            super.setWebViewClient(new es(this, context));
            super.setWebChromeClient(new ev(this));
            setDownloadListener(new ey(this));
        }
    }
}
