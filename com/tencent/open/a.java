package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.baidu.android.common.others.IStringUtil;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f40015a = new HashMap<>();

    /* loaded from: classes7.dex */
    public static class b {
        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(String str, List<String> list, C0516a c0516a) {
            Method method;
            Object invoke;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                }
                i2++;
            }
            if (method == null) {
                if (c0516a != null) {
                    c0516a.a();
                    return;
                }
                return;
            }
            try {
                int size = list.size();
                if (size != 0) {
                    invoke = size != 1 ? size != 2 ? size != 3 ? size != 4 ? size != 5 ? method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)) : method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3)) : method.invoke(this, list.get(0), list.get(1), list.get(2)) : method.invoke(this, list.get(0), list.get(1)) : method.invoke(this, list.get(0));
                } else {
                    invoke = method.invoke(this, new Object[0]);
                }
                Class<?> returnType = method.getReturnType();
                f.b("openSDK_LOG.JsBridge", "-->call, result: " + invoke + " | ReturnType: " + returnType.getName());
                if (!"void".equals(returnType.getName()) && returnType != Void.class) {
                    if (c0516a == null || !customCallback()) {
                        return;
                    }
                    c0516a.a(invoke != null ? invoke.toString() : null);
                }
            } catch (Exception e2) {
                f.b("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e2);
                if (c0516a != null) {
                    c0516a.a();
                }
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.f40015a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0516a c0516a) {
        f.a("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        b bVar = this.f40015a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0516a);
            return;
        }
        f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (c0516a != null) {
            c0516a.a();
        }
    }

    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0516a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<WebView> f40025a;

        /* renamed from: b  reason: collision with root package name */
        public long f40026b;

        /* renamed from: c  reason: collision with root package name */
        public String f40027c;

        public C0516a(WebView webView, long j, String str) {
            this.f40025a = new WeakReference<>(webView);
            this.f40026b = j;
            this.f40027c = str;
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.f40025a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                String replace = ((String) obj).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("'", "\\'");
                obj2 = "'" + ((Object) replace) + "'";
            } else if (!(obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Float)) {
                obj2 = obj instanceof Boolean ? obj.toString() : "'undefined'";
            } else {
                obj2 = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f40026b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a() {
            WebView webView = this.f40025a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f40026b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView = this.f40025a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    public boolean a(WebView webView, String str) {
        f.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() < 6) {
                return false;
            }
            List<String> subList = arrayList.subList(4, arrayList.size() - 1);
            C0516a c0516a = new C0516a(webView, 4L, str);
            webView.getUrl();
            a((String) arrayList.get(2), (String) arrayList.get(3), subList, c0516a);
            return true;
        }
        return false;
    }
}
