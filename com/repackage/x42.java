package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.repackage.c52;
import com.repackage.z42;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class x42 extends v42 implements q42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n42 b;
    public k42 c;
    public File d;
    public b e;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ x42 d;

        public a(x42 x42Var, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = x42Var;
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.e.onError(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onError(String str, int i, String str2);
    }

    /* loaded from: classes7.dex */
    public class c implements z42.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k42 a;
        public String b;

        /* loaded from: classes7.dex */
        public class a implements l42 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File a;

            public a(c cVar, File file) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, file};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = file;
            }

            @Override // com.repackage.l42
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    jg4.L(this.a);
                }
            }
        }

        public c(x42 x42Var, k42 k42Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x42Var, k42Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k42Var;
            this.b = str;
        }

        @Override // com.repackage.z42.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.a.a(this.b, file, new a(this, file));
                } catch (Exception e) {
                    if (q42.a) {
                        Log.d("HybridIntercept", Log.getStackTraceString(e));
                    }
                }
            }
        }

        @Override // com.repackage.z42.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && q42.a) {
                Log.e("HybridIntercept", "writer file fail, file = " + file);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x42(@NonNull Context context, k42 k42Var) {
        super(context, k42Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, k42Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (k42) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = m42.a().f();
        this.d = new File(m42.a().b(), "image_temp");
        this.c = k42Var;
        if (k42Var == null) {
            h(context);
        }
    }

    @Override // com.repackage.c52
    public WebResourceResponse a(@NonNull c52.a aVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String d = aVar.d();
            if (!i(aVar)) {
                return aVar.b(d, aVar.getRequestHeaders(), aVar.c());
            }
            String f = f(d);
            InputStream inputStream = null;
            k42 k42Var = this.c;
            if (k42Var != null && !k42Var.isClosed()) {
                inputStream = this.c.get(f);
            }
            if (inputStream != null) {
                if (q42.a) {
                    Log.d("HybridIntercept", "adopt cached image, url = " + f);
                }
                return new WebResourceResponse(aVar.getMimeType(), "UTF-8", inputStream);
            }
            w42 a2 = a52.a(f, g(aVar));
            if (a2 != null && (i = a2.a) >= 400 && this.e != null) {
                d(f, i, a2.b);
            }
            WebResourceResponse c2 = c(a2);
            if (c2 != null && c2.getData() != null) {
                c2.setData(new b52(c2.getData(), new z42(new File(this.d, m42.a().d().a(f)), new c(this, this.c, f))));
            }
            if (q42.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("download image, response = ");
                sb.append(c2 != null);
                sb.append(" ; url = ");
                sb.append(f);
                Log.e("HybridIntercept", sb.toString());
            }
            return c2;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final WebResourceResponse c(w42 w42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w42Var)) == null) {
            if (w42Var == null) {
                return null;
            }
            String str = w42Var.e;
            if (str != null && str.toLowerCase().contains("html")) {
                w42Var.e = SapiWebView.DATA_MIME_TYPE;
                w42Var.d = "UTF-8";
            }
            if (oc3.f()) {
                return new WebResourceResponse(w42Var.e, w42Var.d, w42Var.a, w42Var.b, w42Var.c, w42Var.f);
            }
            return new WebResourceResponse(w42Var.e, "UTF-8", w42Var.f);
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final void d(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2) == null) {
            be3.q().post(new a(this, str, i, str2));
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "image" : (String) invokeV.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.startsWith("intercept") && str.length() > 9) {
                str = str.substring(9);
            }
            if (q42.a) {
                Log.d("HybridIntercept", "remote request url = " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> g(@NonNull c52.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            Map<String, String> requestHeaders = aVar.getRequestHeaders();
            if (requestHeaders == null) {
                requestHeaders = new HashMap<>();
            }
            String f = d93.l().f(f(aVar.d()), requestHeaders.get("Cookie"));
            if (!TextUtils.isEmpty(f)) {
                requestHeaders.put("Cookie", f);
                if (q42.a) {
                    Log.d("HybridIntercept", "addCookiesToHeader cookie: " + f);
                }
            }
            return requestHeaders;
        }
        return (Map) invokeL.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            File b2 = m42.a().b();
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                b2 = new File(b2, e);
            }
            if (q42.a) {
                Log.d("HybridIntercept", "init default disk cache provider, path = " + b2);
            }
            jg4.l(b2);
            this.c = oj2.U().b(context, b2, m42.a().g());
        }
    }

    public boolean i(@NonNull c52.a aVar) {
        InterceptResult invokeL;
        Map<String, String> requestHeaders;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar.c()) {
                return this.b.a(aVar) && (requestHeaders = aVar.getRequestHeaders()) != null && requestHeaders.containsKey("Accept") && (str = requestHeaders.get("Accept")) != null && str.startsWith("image");
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
