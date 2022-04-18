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
import com.repackage.b52;
import com.repackage.e52;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class z42 extends x42 implements s42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p42 b;
    public m42 c;
    public File d;
    public b e;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ z42 d;

        public a(z42 z42Var, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z42Var, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = z42Var;
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
    public class c implements b52.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public m42 a;
        public String b;

        /* loaded from: classes7.dex */
        public class a implements n42 {
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

            @Override // com.repackage.n42
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    mg4.L(this.a);
                }
            }
        }

        public c(z42 z42Var, m42 m42Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z42Var, m42Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m42Var;
            this.b = str;
        }

        @Override // com.repackage.b52.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.a.a(this.b, file, new a(this, file));
                } catch (Exception e) {
                    if (s42.a) {
                        Log.d("HybridIntercept", Log.getStackTraceString(e));
                    }
                }
            }
        }

        @Override // com.repackage.b52.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && s42.a) {
                Log.e("HybridIntercept", "writer file fail, file = " + file);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z42(@NonNull Context context, m42 m42Var) {
        super(context, m42Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m42Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m42) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = o42.a().f();
        this.d = new File(o42.a().b(), "image_temp");
        this.c = m42Var;
        if (m42Var == null) {
            h(context);
        }
    }

    @Override // com.repackage.e52
    public WebResourceResponse a(@NonNull e52.a aVar) {
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
            m42 m42Var = this.c;
            if (m42Var != null && !m42Var.isClosed()) {
                inputStream = this.c.get(f);
            }
            if (inputStream != null) {
                if (s42.a) {
                    Log.d("HybridIntercept", "adopt cached image, url = " + f);
                }
                return new WebResourceResponse(aVar.getMimeType(), "UTF-8", inputStream);
            }
            y42 a2 = c52.a(f, g(aVar));
            if (a2 != null && (i = a2.a) >= 400 && this.e != null) {
                d(f, i, a2.b);
            }
            WebResourceResponse c2 = c(a2);
            if (c2 != null && c2.getData() != null) {
                c2.setData(new d52(c2.getData(), new b52(new File(this.d, o42.a().d().a(f)), new c(this, this.c, f))));
            }
            if (s42.a) {
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

    public final WebResourceResponse c(y42 y42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y42Var)) == null) {
            if (y42Var == null) {
                return null;
            }
            String str = y42Var.e;
            if (str != null && str.toLowerCase().contains("html")) {
                y42Var.e = SapiWebView.DATA_MIME_TYPE;
                y42Var.d = "UTF-8";
            }
            if (qc3.f()) {
                return new WebResourceResponse(y42Var.e, y42Var.d, y42Var.a, y42Var.b, y42Var.c, y42Var.f);
            }
            return new WebResourceResponse(y42Var.e, "UTF-8", y42Var.f);
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final void d(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2) == null) {
            de3.q().post(new a(this, str, i, str2));
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
            if (s42.a) {
                Log.d("HybridIntercept", "remote request url = " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> g(@NonNull e52.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            Map<String, String> requestHeaders = aVar.getRequestHeaders();
            if (requestHeaders == null) {
                requestHeaders = new HashMap<>();
            }
            String f = f93.l().f(f(aVar.d()), requestHeaders.get("Cookie"));
            if (!TextUtils.isEmpty(f)) {
                requestHeaders.put("Cookie", f);
                if (s42.a) {
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
            File b2 = o42.a().b();
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                b2 = new File(b2, e);
            }
            if (s42.a) {
                Log.d("HybridIntercept", "init default disk cache provider, path = " + b2);
            }
            mg4.l(b2);
            this.c = qj2.U().b(context, b2, o42.a().g());
        }
    }

    public boolean i(@NonNull e52.a aVar) {
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
