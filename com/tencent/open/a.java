package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class a {
    protected HashMap<String, b> a = new HashMap<>();

    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0357a {
        protected WeakReference<WebView> a;
        protected long b;
        protected String c;

        public C0357a(WebView webView, long j, String str) {
            this.a = new WeakReference<>(webView);
            this.b = j;
            this.c = str;
        }

        public void a(Object obj) {
            WebView webView = this.a.get();
            if (webView != null) {
                String str = "'undefined'";
                if (obj instanceof String) {
                    str = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
                } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                    str = obj.toString();
                } else if (obj instanceof Boolean) {
                    str = obj.toString();
                }
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + str + "});");
            }
        }

        public void a() {
            WebView webView = this.a.get();
            if (webView != null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
            }
        }

        public void a(String str) {
            WebView webView = this.a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public void call(String str, List<String> list, C0357a c0357a) {
            Object invoke;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            Method method = null;
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method2 = declaredMethods[i];
                if (method2.getName().equals(str) && method2.getParameterTypes().length == list.size()) {
                    method = method2;
                    break;
                }
                try {
                    i++;
                } catch (Exception e) {
                    f.b("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + ((Object) null), e);
                    if (c0357a != null) {
                        c0357a.a();
                        return;
                    }
                    return;
                }
            }
            if (method != null) {
                switch (list.size()) {
                    case 0:
                        invoke = method.invoke(this, new Object[0]);
                        break;
                    case 1:
                        invoke = method.invoke(this, list.get(0));
                        break;
                    case 2:
                        invoke = method.invoke(this, list.get(0), list.get(1));
                        break;
                    case 3:
                        invoke = method.invoke(this, list.get(0), list.get(1), list.get(2));
                        break;
                    case 4:
                        invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3));
                        break;
                    case 5:
                        invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                        break;
                    default:
                        invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
                        break;
                }
                Class<?> returnType = method.getReturnType();
                f.b("openSDK_LOG.JsBridge", "-->call, result: " + invoke + " | ReturnType: " + returnType.getName());
                if ("void".equals(returnType.getName()) || returnType == Void.class) {
                    if (c0357a != null) {
                        c0357a.a((Object) null);
                    }
                } else if (c0357a != null && customCallback()) {
                    c0357a.a(invoke != null ? invoke.toString() : null);
                }
            } else if (c0357a != null) {
                c0357a.a();
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0357a c0357a) {
        f.a("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), HTTP.UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        b bVar = this.a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0357a);
            return;
        }
        f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (c0357a != null) {
            c0357a.a();
        }
    }

    public boolean a(WebView webView, String str) {
        f.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() >= 6) {
                List<String> subList = arrayList.subList(4, arrayList.size() - 1);
                C0357a c0357a = new C0357a(webView, 4L, str);
                webView.getUrl();
                a((String) arrayList.get(2), (String) arrayList.get(3), subList, c0357a);
                return true;
            }
            return false;
        }
        return false;
    }
}
