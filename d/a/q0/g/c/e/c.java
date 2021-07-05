package d.a.q0.g.c.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f52969e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Download f52970a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f52971b;

    /* renamed from: c  reason: collision with root package name */
    public d f52972c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.g.c.f.b f52973d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f52974e;

        /* renamed from: f  reason: collision with root package name */
        public String f52975f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.g.c.a.n().t(this.f52975f);
                d.a.q0.g.c.a.n().l(this.f52974e);
                d.a.q0.g.c.a.n().k();
            }
        }

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52974e = str;
            this.f52975f = str2;
        }
    }

    /* renamed from: d.a.q0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class RunnableC1119c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f52976e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f52977f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.q0.g.c.f.a f52978g;

        public /* synthetic */ RunnableC1119c(Download download, JSONObject jSONObject, d.a.q0.g.c.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.g.c.a.n().G(this.f52977f);
                d.a.q0.g.c.i.c.a(this.f52976e.getKeyByUser(), "installApp", null, null, new d.a.q0.g.c.i.a(this.f52977f));
                d.a.q0.g.c.a.n().r(AppRuntime.getAppContext(), this.f52976e.getUrl(), this.f52976e.getKeyByUser(), this.f52978g);
            }
        }

        public RunnableC1119c(@NonNull Download download, JSONObject jSONObject, @NonNull d.a.q0.g.c.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {download, jSONObject, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52976e = download;
            this.f52977f = jSONObject;
            this.f52978g = aVar;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f52979a;

        /* renamed from: b  reason: collision with root package name */
        public String f52980b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f52981c;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52981c = cVar;
        }

        @Override // d.a.q0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f52980b = str;
            }
        }

        @Override // d.a.q0.g.c.f.b
        public void b(d.a.q0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (c.f52969e) {
                    Log.d("InstallAppLocal", "onResult mPackageName:" + this.f52979a);
                }
                this.f52981c.d(bVar);
                d.a.q0.g.c.c.b.f52916d.execute(new b(this.f52980b, this.f52979a, null));
            }
        }

        @Override // d.a.q0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f52979a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1054433345, "Ld/a/q0/g/c/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1054433345, "Ld/a/q0/g/c/e/c;");
                return;
            }
        }
        f52969e = k.f49133a;
    }

    public c(Download download, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {download, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52970a = download;
        this.f52971b = jSONObject;
        this.f52972c = new d(this);
    }

    public void c(d.a.q0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f52973d = bVar;
            d.a.q0.g.c.c.b.f52916d.execute(new RunnableC1119c(this.f52970a, this.f52971b, this.f52972c, null));
        }
    }

    public final void d(d.a.q0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            d.a.q0.g.c.f.b bVar2 = this.f52973d;
            if (bVar2 != null) {
                bVar2.b(bVar);
            }
            if (bVar != null && !bVar.d()) {
                d.a.q0.g.c.i.c.a(this.f52970a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new d.a.q0.g.c.i.a(this.f52971b));
            }
            if (this.f52972c != null) {
                d.a.q0.g.c.a.n().B(this.f52970a.getKeyByUser(), this.f52972c);
                this.f52972c = null;
            }
        }
    }
}
