package d.a.n0.a.h0.o.h.g;

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
import d.a.n0.a.h0.o.h.g.d;
import d.a.n0.a.v2.q0;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class a implements d.a.n0.a.h0.o.h.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.a.h0.o.h.c.a f45102b;

    /* renamed from: c  reason: collision with root package name */
    public File f45103c;

    /* renamed from: d  reason: collision with root package name */
    public b f45104d;

    /* renamed from: d.a.n0.a.h0.o.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0759a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45105e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45106f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45107g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f45108h;

        public RunnableC0759a(a aVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45108h = aVar;
            this.f45105e = str;
            this.f45106f = i2;
            this.f45107g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45108h.f45104d.onError(this.f45105e, this.f45106f, this.f45107g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onError(String str, int i2, String str2);
    }

    /* loaded from: classes7.dex */
    public class c implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.n0.a.h0.o.h.c.a f45109a;

        /* renamed from: b  reason: collision with root package name */
        public String f45110b;

        /* renamed from: d.a.n0.a.h0.o.h.g.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0760a implements d.a.n0.a.h0.o.h.c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f45111a;

            public C0760a(c cVar, File file) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, file};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45111a = file;
            }

            @Override // d.a.n0.a.h0.o.h.c.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.n0.t.d.K(this.f45111a);
                }
            }
        }

        public c(a aVar, d.a.n0.a.h0.o.h.c.a aVar2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45109a = aVar2;
            this.f45110b = str;
        }

        @Override // d.a.n0.a.h0.o.h.g.d.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.f45109a.a(this.f45110b, file, new C0760a(this, file));
                } catch (Exception e2) {
                    if (d.a.n0.a.h0.o.h.e.a.f45098a) {
                        Log.d("HybridIntercept", Log.getStackTraceString(e2));
                    }
                }
            }
        }

        @Override // d.a.n0.a.h0.o.h.g.d.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && d.a.n0.a.h0.o.h.e.a.f45098a) {
                Log.e("HybridIntercept", "writer file fail, file = " + file);
            }
        }
    }

    public a(@NonNull Context context, d.a.n0.a.h0.o.h.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45103c = new File(d.a.n0.a.h0.o.h.d.a.a().b(), "image_temp");
        this.f45102b = aVar;
        if (aVar == null) {
            g(context);
        }
    }

    public final WebResourceResponse b(d.a.n0.a.h0.o.h.g.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            String str = bVar.f45116e;
            if (str != null && str.toLowerCase().contains("html")) {
                bVar.f45116e = SapiWebView.DATA_MIME_TYPE;
                bVar.f45115d = "UTF-8";
            }
            if (d.a.n0.a.v2.d.f()) {
                return new WebResourceResponse(bVar.f45116e, bVar.f45115d, bVar.f45112a, bVar.f45113b, bVar.f45114c, bVar.f45117f);
            }
            return new WebResourceResponse(bVar.f45116e, "UTF-8", bVar.f45117f);
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final void c(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
            q0.q().post(new RunnableC0759a(this, str, i2, str2));
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.startsWith("intercept") && str.length() > 9) {
                str = str.substring(9);
            }
            if (d.a.n0.a.h0.o.h.e.a.f45098a) {
                Log.d("HybridIntercept", "real request url = " + str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> f(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) ? gVar.getRequestHeaders() : (Map) invokeL.objValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            File b2 = d.a.n0.a.h0.o.h.d.a.a().b();
            String d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                b2 = new File(b2, d2);
            }
            if (d.a.n0.a.h0.o.h.e.a.f45098a) {
                Log.d("HybridIntercept", "init default disk cache provider, path = " + b2);
            }
            d.a.n0.t.d.k(b2);
            this.f45102b = d.a.n0.a.c1.a.P().b(context, b2, d.a.n0.a.h0.o.h.d.a.a().g());
        }
    }

    public WebResourceResponse h(@NonNull g gVar) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gVar)) == null) {
            String d2 = gVar.d();
            if (!i(gVar)) {
                return gVar.b(d2, gVar.getRequestHeaders(), gVar.c());
            }
            String e2 = e(d2);
            InputStream inputStream = null;
            d.a.n0.a.h0.o.h.c.a aVar = this.f45102b;
            if (aVar != null && !aVar.isClosed()) {
                inputStream = this.f45102b.get(e2);
            }
            if (inputStream != null) {
                if (d.a.n0.a.h0.o.h.e.a.f45098a) {
                    Log.d("HybridIntercept", "adopt cached image, url = " + e2);
                }
                return new WebResourceResponse(gVar.getMimeType(), "UTF-8", inputStream);
            }
            d.a.n0.a.h0.o.h.g.b a2 = e.a(e2, f(gVar));
            if (a2 != null && (i2 = a2.f45112a) >= 400 && this.f45104d != null) {
                c(e2, i2, a2.f45113b);
            }
            WebResourceResponse b2 = b(a2);
            if (b2 != null && b2.getData() != null) {
                b2.setData(new f(b2.getData(), new d(new File(this.f45103c, d.a.n0.a.h0.o.h.d.a.a().d().a(e2)), new c(this, this.f45102b, e2))));
            }
            if (d.a.n0.a.h0.o.h.e.a.f45098a) {
                StringBuilder sb = new StringBuilder();
                sb.append("download image, response = ");
                sb.append(b2 != null);
                sb.append(" ; url = ");
                sb.append(e2);
                Log.e("HybridIntercept", sb.toString());
            }
            return b2;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public abstract boolean i(@NonNull g gVar);
}
