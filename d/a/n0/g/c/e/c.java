package d.a.n0.g.c.e;

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
import d.a.n0.a.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49667e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Download f49668a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f49669b;

    /* renamed from: c  reason: collision with root package name */
    public d f49670c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g.c.f.b f49671d;

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
        public String f49672e;

        /* renamed from: f  reason: collision with root package name */
        public String f49673f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.g.c.a.n().t(this.f49673f);
                d.a.n0.g.c.a.n().l(this.f49672e);
                d.a.n0.g.c.a.n().k();
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
            this.f49672e = str;
            this.f49673f = str2;
        }
    }

    /* renamed from: d.a.n0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1068c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f49674e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f49675f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.n0.g.c.f.a f49676g;

        public /* synthetic */ RunnableC1068c(Download download, JSONObject jSONObject, d.a.n0.g.c.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.g.c.a.n().G(this.f49675f);
                d.a.n0.g.c.i.c.a(this.f49674e.getKeyByUser(), "installApp", null, null, new d.a.n0.g.c.i.a(this.f49675f));
                d.a.n0.g.c.a.n().r(AppRuntime.getAppContext(), this.f49674e.getUrl(), this.f49674e.getKeyByUser(), this.f49676g);
            }
        }

        public RunnableC1068c(@NonNull Download download, JSONObject jSONObject, @NonNull d.a.n0.g.c.f.a aVar) {
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
            this.f49674e = download;
            this.f49675f = jSONObject;
            this.f49676g = aVar;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.n0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f49677a;

        /* renamed from: b  reason: collision with root package name */
        public String f49678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f49679c;

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
            this.f49679c = cVar;
        }

        @Override // d.a.n0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f49678b = str;
            }
        }

        @Override // d.a.n0.g.c.f.b
        public void b(d.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (c.f49667e) {
                    Log.d("InstallAppLocal", "onResult mPackageName:" + this.f49677a);
                }
                this.f49679c.d(bVar);
                d.a.n0.g.c.c.b.f49614d.execute(new b(this.f49678b, this.f49677a, null));
            }
        }

        @Override // d.a.n0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f49677a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2144647170, "Ld/a/n0/g/c/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2144647170, "Ld/a/n0/g/c/e/c;");
                return;
            }
        }
        f49667e = k.f45831a;
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
        this.f49668a = download;
        this.f49669b = jSONObject;
        this.f49670c = new d(this);
    }

    public void c(d.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f49671d = bVar;
            d.a.n0.g.c.c.b.f49614d.execute(new RunnableC1068c(this.f49668a, this.f49669b, this.f49670c, null));
        }
    }

    public final void d(d.a.n0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            d.a.n0.g.c.f.b bVar2 = this.f49671d;
            if (bVar2 != null) {
                bVar2.b(bVar);
            }
            if (bVar != null && !bVar.d()) {
                d.a.n0.g.c.i.c.a(this.f49668a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new d.a.n0.g.c.i.a(this.f49669b));
            }
            if (this.f49670c != null) {
                d.a.n0.g.c.a.n().B(this.f49668a.getKeyByUser(), this.f49670c);
                this.f49670c = null;
            }
        }
    }
}
