package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.webkit.sdk.WebChromeClient;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.kwad.sdk.utils.as;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends KSApiWebView {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f34358b = {"getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait"};

    /* renamed from: a  reason: collision with root package name */
    public Boolean f34359a;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, Object> f34360c;

    /* renamed from: d  reason: collision with root package name */
    public String f34361d;

    public b(Context context) {
        super(context);
        this.f34360c = new HashMap<>();
        this.f34361d = null;
        d();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34360c = new HashMap<>();
        this.f34361d = null;
        d();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34360c = new HashMap<>();
        this.f34361d = null;
        d();
    }

    private Class<?> a(Object obj) {
        Class<?> cls = obj.getClass();
        return cls == Integer.class ? Integer.TYPE : cls == Boolean.class ? Boolean.TYPE : String.class;
    }

    private void a(ValueCallback<String> valueCallback) {
        try {
            if (TextUtils.isEmpty(this.f34361d)) {
                return;
            }
            as.a(this, this.f34361d, valueCallback);
        } catch (Exception unused) {
        }
    }

    private void a(String str, Object obj, StringBuilder sb) {
        Method[] methods;
        String str2;
        if (TextUtils.isEmpty(str) || obj == null || sb == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        sb.append("if(typeof(window.");
        sb.append(str);
        sb.append(")!='undefined'){");
        sb.append("}else {");
        sb.append("    window.");
        sb.append(str);
        sb.append("={");
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (!a(name)) {
                sb.append("        ");
                sb.append(name);
                sb.append(":function(");
                int length = method.getParameterTypes().length;
                if (length > 0) {
                    int i = length - 1;
                    int i2 = 0;
                    while (true) {
                        sb.append("arg");
                        if (i2 >= i) {
                            break;
                        }
                        sb.append(i2);
                        sb.append(",");
                        i2++;
                    }
                    sb.append(i);
                }
                sb.append(") {");
                if (method.getReturnType() != Void.TYPE) {
                    sb.append("            return ");
                    str2 = "prompt('";
                } else {
                    str2 = "            prompt('";
                }
                sb.append(str2);
                sb.append("MyApp:");
                sb.append("'+");
                sb.append("JSON.stringify({");
                sb.append("obj");
                sb.append(":'");
                sb.append(str);
                sb.append("',");
                sb.append(WebChromeClient.KEY_FUNCTION_NAME);
                sb.append(":'");
                sb.append(name);
                sb.append("',");
                sb.append("args");
                sb.append(":[");
                if (length > 0) {
                    int i3 = length - 1;
                    int i4 = 0;
                    while (true) {
                        sb.append("arg");
                        if (i4 >= i3) {
                            break;
                        }
                        sb.append(i4);
                        sb.append(",");
                        i4++;
                    }
                    sb.append(i3);
                }
                sb.append("]})");
                sb.append(");");
                sb.append("        }, ");
            }
        }
        sb.append("    };");
        sb.append("}");
    }

    private void a(String str, String str2) {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod(str, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, str2);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045 A[Catch: NoSuchMethodException | Exception -> 0x004e, NoSuchMethodException -> 0x0050, TryCatch #2 {NoSuchMethodException | Exception -> 0x004e, blocks: (B:15:0x0026, B:17:0x0034, B:25:0x0049, B:24:0x0045), top: B:33:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(JsPromptResult jsPromptResult, String str, String str2, Object[] objArr) {
        Object invoke;
        boolean z;
        Object obj = this.f34360c.get(str);
        boolean z2 = false;
        if (obj == null) {
            jsPromptResult.cancel();
            return false;
        }
        Class<?>[] clsArr = null;
        int length = objArr != null ? objArr.length : 0;
        if (length > 0) {
            clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = a(objArr[i]);
            }
        }
        try {
            invoke = obj.getClass().getMethod(str2, clsArr).invoke(obj, objArr);
        } catch (NoSuchMethodException | Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (invoke != null && invoke.getClass() != Void.TYPE) {
            z = false;
            jsPromptResult.confirm(!z ? "" : invoke.toString());
            z2 = true;
            jsPromptResult.cancel();
            return z2;
        }
        z = true;
        jsPromptResult.confirm(!z ? "" : invoke.toString());
        z2 = true;
        jsPromptResult.cancel();
        return z2;
    }

    private boolean a(String str) {
        for (String str2 : f34358b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        e();
    }

    private boolean e() {
        try {
            if (!b() || c()) {
                return false;
            }
            a("removeJavascriptInterface", "searchBoxJavaBridge_");
            a("removeJavascriptInterface", "accessibility");
            a("removeJavascriptInterface", "accessibilityTraversal");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean f() {
        return ((AccessibilityManager) getContext().getApplicationContext().getSystemService("accessibility")).isEnabled();
    }

    private String g() {
        if (this.f34360c.size() == 0) {
            this.f34361d = null;
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:(function JsAddJavascriptInterface_(){");
        for (Map.Entry<String, Object> entry : this.f34360c.entrySet()) {
            try {
                a(entry.getKey(), entry.getValue(), sb);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        sb.append("})()");
        return sb.toString();
    }

    private void setAccessibilityEnabled(boolean z) {
        try {
            Method declaredMethod = AccessibilityManager.class.getDeclaredMethod("setAccessibilityState", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke((AccessibilityManager) getContext().getApplicationContext().getSystemService("accessibility"), Boolean.valueOf(z));
            declaredMethod.setAccessible(false);
        } catch (Exception unused) {
        }
    }

    public void a() {
        if (Build.VERSION.SDK_INT == 17 && this.f34359a == null && f()) {
            this.f34359a = Boolean.TRUE;
            setAccessibilityEnabled(false);
        }
    }

    public void a(WebView webView) {
        if (webView instanceof b) {
            a(webView, (ValueCallback<String>) null);
        }
    }

    public void a(WebView webView, ValueCallback<String> valueCallback) {
        if (!TextUtils.isEmpty(this.f34361d)) {
            a(valueCallback);
            return;
        }
        this.f34361d = g();
        a(valueCallback);
    }

    public void a(Object obj, String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f34360c.put(str, obj);
        a(this, valueCallback);
    }

    public boolean a(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        int length;
        if (str2.startsWith("MyApp:")) {
            try {
                JSONObject jSONObject = new JSONObject(str2.substring(6));
                String string = jSONObject.getString("obj");
                String string2 = jSONObject.getString(WebChromeClient.KEY_FUNCTION_NAME);
                JSONArray jSONArray = jSONObject.getJSONArray("args");
                Object[] objArr = null;
                if (jSONArray != null && (length = jSONArray.length()) > 0) {
                    objArr = new Object[length];
                    for (int i = 0; i < length; i++) {
                        objArr[i] = jSONArray.get(i);
                    }
                }
                if (a(jsPromptResult, string, string2, objArr)) {
                    return true;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            jsPromptResult.cancel();
            return false;
        }
        return false;
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f34360c.put(str, obj);
        a(this, (ValueCallback<String>) null);
    }

    public boolean b() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public boolean c() {
        return Build.VERSION.SDK_INT >= 17;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
        com.kwad.sdk.core.d.a.d("loadUrl", DataEntryUrlBox.TYPE + str + Integer.toHexString(hashCode()));
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i) {
        try {
            super.setOverScrollMode(i);
        } catch (Exception e2) {
            String stackTraceString = Log.getStackTraceString(e2);
            if (!stackTraceString.contains("android.content.pm.PackageManager$NameNotFoundException") && !stackTraceString.contains("java.lang.RuntimeException: Cannot load WebView") && !stackTraceString.contains("android.webkit.WebViewFactory$MissingWebViewPackageException: Failed to load WebView provider: No WebView installed")) {
                throw e2;
            }
            try {
                destroy();
            } catch (Exception unused) {
            }
        }
    }
}
