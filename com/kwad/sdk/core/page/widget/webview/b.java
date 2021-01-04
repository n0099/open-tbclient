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
import com.baidu.platform.comapi.map.MapBundleKey;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.kwad.sdk.utils.as;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends KSApiWebView {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f9674b = {"getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait"};

    /* renamed from: a  reason: collision with root package name */
    private Boolean f9675a;
    private final HashMap<String, Object> c;
    private String d;

    public b(Context context) {
        super(context);
        this.c = new HashMap<>();
        this.d = null;
        d();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new HashMap<>();
        this.d = null;
        d();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new HashMap<>();
        this.d = null;
        d();
    }

    private Class<?> a(Object obj) {
        Class<?> cls = obj.getClass();
        return cls == Integer.class ? Integer.TYPE : cls == Boolean.class ? Boolean.TYPE : String.class;
    }

    private void a(ValueCallback<String> valueCallback) {
        try {
            if (TextUtils.isEmpty(this.d)) {
                return;
            }
            as.a(this, this.d, valueCallback);
        } catch (Exception e) {
        }
    }

    private void a(String str, Object obj, StringBuilder sb) {
        Method[] methods;
        if (TextUtils.isEmpty(str) || obj == null || sb == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        sb.append("if(typeof(window.").append(str).append(")!='undefined'){");
        sb.append("}else {");
        sb.append("    window.").append(str).append("={");
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (!a(name)) {
                sb.append("        ").append(name).append(":function(");
                int length = method.getParameterTypes().length;
                if (length > 0) {
                    int i = length - 1;
                    for (int i2 = 0; i2 < i; i2++) {
                        sb.append("arg").append(i2).append(",");
                    }
                    sb.append("arg").append(length - 1);
                }
                sb.append(") {");
                if (method.getReturnType() != Void.TYPE) {
                    sb.append("            return ").append("prompt('").append("MyApp:").append("'+");
                } else {
                    sb.append("            prompt('").append("MyApp:").append("'+");
                }
                sb.append("JSON.stringify({");
                sb.append(MapBundleKey.MapObjKey.OBJ_SL_OBJ).append(":'").append(str).append("',");
                sb.append("func").append(":'").append(name).append("',");
                sb.append("args").append(":[");
                if (length > 0) {
                    int i3 = length - 1;
                    for (int i4 = 0; i4 < i3; i4++) {
                        sb.append("arg").append(i4).append(",");
                    }
                    sb.append("arg").append(i3);
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
        } catch (IllegalAccessException e) {
            com.kwad.sdk.core.d.a.a(e);
        } catch (IllegalArgumentException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        } catch (NoSuchMethodException e3) {
            com.kwad.sdk.core.d.a.a(e3);
        } catch (InvocationTargetException e4) {
            com.kwad.sdk.core.d.a.a(e4);
        }
    }

    private boolean a(JsPromptResult jsPromptResult, String str, String str2, Object[] objArr) {
        boolean z = true;
        Object obj = this.c.get(str);
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
            Object invoke = obj.getClass().getMethod(str2, clsArr).invoke(obj, objArr);
            jsPromptResult.confirm(invoke == null || invoke.getClass() == Void.TYPE ? "" : invoke.toString());
        } catch (NoSuchMethodException e) {
            com.kwad.sdk.core.d.a.a(e);
            z = false;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            z = false;
        }
        jsPromptResult.cancel();
        return z;
    }

    private boolean a(String str) {
        for (String str2 : f9674b) {
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
            if (b() && !c()) {
                a("removeJavascriptInterface", "searchBoxJavaBridge_");
                a("removeJavascriptInterface", "accessibility");
                a("removeJavascriptInterface", "accessibilityTraversal");
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    private boolean f() {
        return ((AccessibilityManager) getContext().getApplicationContext().getSystemService("accessibility")).isEnabled();
    }

    private String g() {
        if (this.c.size() == 0) {
            this.d = null;
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:(function JsAddJavascriptInterface_(){");
        for (Map.Entry<String, Object> entry : this.c.entrySet()) {
            try {
                a(entry.getKey(), entry.getValue(), sb);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
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
        } catch (Exception e) {
        }
    }

    public void a() {
        if (Build.VERSION.SDK_INT == 17 && this.f9675a == null && f()) {
            this.f9675a = true;
            setAccessibilityEnabled(false);
        }
    }

    public void a(WebView webView) {
        if (webView instanceof b) {
            a(webView, (ValueCallback<String>) null);
        }
    }

    public void a(WebView webView, ValueCallback<String> valueCallback) {
        if (!TextUtils.isEmpty(this.d)) {
            a(valueCallback);
            return;
        }
        this.d = g();
        a(valueCallback);
    }

    public void a(Object obj, String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.put(str, obj);
        a(this, valueCallback);
    }

    public boolean a(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        int length;
        if (str2.startsWith("MyApp:")) {
            try {
                JSONObject jSONObject = new JSONObject(str2.substring("MyApp:".length()));
                String string = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                String string2 = jSONObject.getString("func");
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
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
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
        this.c.put(str, obj);
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
        } catch (Exception e) {
            String stackTraceString = Log.getStackTraceString(e);
            if (!stackTraceString.contains("android.content.pm.PackageManager$NameNotFoundException") && !stackTraceString.contains("java.lang.RuntimeException: Cannot load WebView") && !stackTraceString.contains("android.webkit.WebViewFactory$MissingWebViewPackageException: Failed to load WebView provider: No WebView installed")) {
                throw e;
            }
            try {
                destroy();
            } catch (Exception e2) {
            }
        }
    }
}
