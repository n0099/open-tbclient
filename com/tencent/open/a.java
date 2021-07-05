package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f41861a;

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x0140, code lost:
            r13.a((java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0143, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(String str, List<String> list, C0563a c0563a) {
            Method method;
            Object invoke;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, list, c0563a) == null) {
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
                    if (c0563a != null) {
                        c0563a.a();
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
                        if (c0563a == null || !customCallback()) {
                            return;
                        }
                        c0563a.a(invoke != null ? invoke.toString() : null);
                    }
                } catch (Exception e2) {
                    f.b("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e2);
                    if (c0563a != null) {
                        c0563a.a();
                    }
                }
            }
        }

        public boolean customCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41861a = new HashMap<>();
    }

    public void a(b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            this.f41861a.put(str, bVar);
        }
    }

    public void a(String str, String str2, List<String> list, C0563a c0563a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, list, c0563a) == null) {
            f.a("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    list.set(i2, URLDecoder.decode(list.get(i2), "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            b bVar = this.f41861a.get(str);
            if (bVar != null) {
                f.b("openSDK_LOG.JsBridge", "call----");
                bVar.call(str2, list, c0563a);
                return;
            }
            f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (c0563a != null) {
                c0563a.a();
            }
        }
    }

    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0563a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<WebView> f41871a;

        /* renamed from: b  reason: collision with root package name */
        public long f41872b;

        /* renamed from: c  reason: collision with root package name */
        public String f41873c;

        public C0563a(WebView webView, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41871a = new WeakReference<>(webView);
            this.f41872b = j;
            this.f41873c = str;
        }

        public void a(Object obj) {
            WebView webView;
            String obj2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || (webView = this.f41871a.get()) == null) {
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
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f41872b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void a() {
            WebView webView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (webView = this.f41871a.get()) == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f41872b + ",{'r':1,'result':'no such method'})");
        }

        public void a(String str) {
            WebView webView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (webView = this.f41871a.get()) == null) {
                return;
            }
            webView.loadUrl("javascript:" + str);
        }
    }

    public boolean a(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
            f.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
            if (str != null && Uri.parse(str).getScheme().equals("jsbridge")) {
                ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
                if (arrayList.size() < 6) {
                    return false;
                }
                List<String> subList = arrayList.subList(4, arrayList.size() - 1);
                C0563a c0563a = new C0563a(webView, 4L, str);
                webView.getUrl();
                a((String) arrayList.get(2), (String) arrayList.get(3), subList, c0563a);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
