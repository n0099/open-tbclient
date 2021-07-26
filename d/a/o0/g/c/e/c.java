package d.a.o0.g.c.e;

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
import d.a.o0.a.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f50171e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Download f50172a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f50173b;

    /* renamed from: c  reason: collision with root package name */
    public d f50174c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.g.c.f.b f50175d;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f50176e;

        /* renamed from: f  reason: collision with root package name */
        public String f50177f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.g.c.a.n().t(this.f50177f);
                d.a.o0.g.c.a.n().l(this.f50176e);
                d.a.o0.g.c.a.n().k();
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
            this.f50176e = str;
            this.f50177f = str2;
        }
    }

    /* renamed from: d.a.o0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1077c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f50178e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f50179f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.o0.g.c.f.a f50180g;

        public /* synthetic */ RunnableC1077c(Download download, JSONObject jSONObject, d.a.o0.g.c.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.g.c.a.n().G(this.f50179f);
                d.a.o0.g.c.i.c.a(this.f50178e.getKeyByUser(), "installApp", null, null, new d.a.o0.g.c.i.a(this.f50179f));
                d.a.o0.g.c.a.n().r(AppRuntime.getAppContext(), this.f50178e.getUrl(), this.f50178e.getKeyByUser(), this.f50180g);
            }
        }

        public RunnableC1077c(@NonNull Download download, JSONObject jSONObject, @NonNull d.a.o0.g.c.f.a aVar) {
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
            this.f50178e = download;
            this.f50179f = jSONObject;
            this.f50180g = aVar;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f50181a;

        /* renamed from: b  reason: collision with root package name */
        public String f50182b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f50183c;

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
            this.f50183c = cVar;
        }

        @Override // d.a.o0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f50182b = str;
            }
        }

        @Override // d.a.o0.g.c.f.b
        public void b(d.a.o0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (c.f50171e) {
                    Log.d("InstallAppLocal", "onResult mPackageName:" + this.f50181a);
                }
                this.f50183c.d(bVar);
                d.a.o0.g.c.c.b.f50118d.execute(new b(this.f50182b, this.f50181a, null));
            }
        }

        @Override // d.a.o0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f50181a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(353368767, "Ld/a/o0/g/c/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(353368767, "Ld/a/o0/g/c/e/c;");
                return;
            }
        }
        f50171e = k.f46335a;
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
        this.f50172a = download;
        this.f50173b = jSONObject;
        this.f50174c = new d(this);
    }

    public void c(d.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f50175d = bVar;
            d.a.o0.g.c.c.b.f50118d.execute(new RunnableC1077c(this.f50172a, this.f50173b, this.f50174c, null));
        }
    }

    public final void d(d.a.o0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            d.a.o0.g.c.f.b bVar2 = this.f50175d;
            if (bVar2 != null) {
                bVar2.b(bVar);
            }
            if (bVar != null && !bVar.d()) {
                d.a.o0.g.c.i.c.a(this.f50172a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new d.a.o0.g.c.i.a(this.f50173b));
            }
            if (this.f50174c != null) {
                d.a.o0.g.c.a.n().B(this.f50172a.getKeyByUser(), this.f50174c);
                this.f50174c = null;
            }
        }
    }
}
