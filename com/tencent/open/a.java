package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.baidu.android.common.others.IStringUtil;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public HashMap<String, b> a = new HashMap<>();

    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0729a {
        public WeakReference<WebView> a;
        public long b;
        public String c;

        public C0729a(WebView webView, long j, String str) {
            this.a = new WeakReference<>(webView);
            this.b = j;
            this.c = str;
        }

        public void a() {
            WebView webView = this.a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
        }

        public void a(Object obj) {
            String obj2;
            WebView webView = this.a.get();
            if (webView == null) {
                return;
            }
            if (obj instanceof String) {
                String replace = ((String) obj).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("'", "\\'");
                obj2 = "'" + ((Object) replace) + "'";
            } else if (!(obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Float)) {
                if (obj instanceof Boolean) {
                    obj2 = obj.toString();
                } else {
                    obj2 = "'undefined'";
                }
            } else {
                obj2 = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a(String str) {
            WebView webView = this.a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public boolean customCallback() {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x013c, code lost:
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013f, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(String str, List<String> list, C0729a c0729a) {
            String str2;
            Method method;
            Object invoke;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                str2 = null;
                if (i < length) {
                    method = declaredMethods[i];
                    if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                        break;
                    }
                    i++;
                } else {
                    method = null;
                    break;
                }
            }
            if (method != null) {
                try {
                    int size = list.size();
                    if (size != 0) {
                        if (size != 1) {
                            if (size != 2) {
                                if (size != 3) {
                                    if (size != 4) {
                                        if (size != 5) {
                                            invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
                                        } else {
                                            invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                                        }
                                    } else {
                                        invoke = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3));
                                    }
                                } else {
                                    invoke = method.invoke(this, list.get(0), list.get(1), list.get(2));
                                }
                            } else {
                                invoke = method.invoke(this, list.get(0), list.get(1));
                            }
                        } else {
                            invoke = method.invoke(this, list.get(0));
                        }
                    } else {
                        invoke = method.invoke(this, new Object[0]);
                    }
                    Class<?> returnType = method.getReturnType();
                    SLog.d("openSDK_LOG.JsBridge", "-->call, result: " + invoke + " | ReturnType: " + returnType.getName());
                    if (!"void".equals(returnType.getName()) && returnType != Void.class) {
                        if (c0729a != null && customCallback()) {
                            if (invoke != null) {
                                str2 = invoke.toString();
                            }
                            c0729a.a(str2);
                        }
                    }
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                    if (c0729a != null) {
                        c0729a.a();
                    }
                }
            } else if (c0729a != null) {
                c0729a.a();
            }
        }
    }

    public void a(b bVar, String str) {
        this.a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0729a c0729a) {
        SLog.v("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        b bVar = this.a.get(str);
        if (bVar != null) {
            SLog.d("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, c0729a);
            return;
        }
        SLog.d("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (c0729a != null) {
            c0729a.a();
        }
    }

    public boolean a(WebView webView, String str) {
        SLog.v("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        C0729a c0729a = new C0729a(webView, 4L, str);
        webView.getUrl();
        a((String) arrayList.get(2), (String) arrayList.get(3), subList, c0729a);
        return true;
    }
}
