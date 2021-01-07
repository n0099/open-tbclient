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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, b> f13666a = new HashMap<>();

    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1280a {

        /* renamed from: a  reason: collision with root package name */
        protected WeakReference<WebView> f13669a;

        /* renamed from: b  reason: collision with root package name */
        protected long f13670b;
        protected String c;

        public C1280a(WebView webView, long j, String str) {
            this.f13669a = new WeakReference<>(webView);
            this.f13670b = j;
            this.c = str;
        }

        public void a(Object obj) {
            WebView webView = this.f13669a.get();
            if (webView != null) {
                String str = "'undefined'";
                if (obj instanceof String) {
                    str = "'" + ((Object) ((String) obj).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("'", "\\'")) + "'";
                } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                    str = obj.toString();
                } else if (obj instanceof Boolean) {
                    str = obj.toString();
                }
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f13670b + ",{'r':0,'result':" + str + "});");
            }
        }

        public void a() {
            WebView webView = this.f13669a.get();
            if (webView != null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f13670b + ",{'r':1,'result':'no such method'})");
            }
        }

        public void a(String str) {
            WebView webView = this.f13669a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public void call(String str, List<String> list, C1280a c1280a) {
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
                    if (c1280a != null) {
                        c1280a.a();
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
                    if (c1280a != null) {
                        c1280a.a((Object) null);
                    }
                } else if (c1280a != null && customCallback()) {
                    c1280a.a(invoke != null ? invoke.toString() : null);
                }
            } else if (c1280a != null) {
                c1280a.a();
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    public void a(b bVar, String str) {
        this.f13666a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C1280a c1280a) {
        f.a("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        b bVar = this.f13666a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c1280a);
            return;
        }
        f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (c1280a != null) {
            c1280a.a();
        }
    }

    public boolean a(WebView webView, String str) {
        f.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
            ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
            if (arrayList.size() >= 6) {
                List<String> subList = arrayList.subList(4, arrayList.size() - 1);
                C1280a c1280a = new C1280a(webView, 4L, str);
                webView.getUrl();
                a((String) arrayList.get(2), (String) arrayList.get(3), subList, c1280a);
                return true;
            }
            return false;
        }
        return false;
    }
}
