package d.a.q0.h.f.j;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.m.j;
import d.a.q0.a.k;
import d.a.q0.a.v2.j0;
import d.a.q0.h.f.b;
import d.a.q0.h.s.a;
import d.a.q0.n.f.c;
import d.a.q0.n.h.h;
import d.a.q0.n.o.f;
import d.a.q0.t.d;
import java.io.File;
import java.util.Set;
/* loaded from: classes8.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f53290g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h.f.k.a f53291h;

    /* renamed from: i  reason: collision with root package name */
    public c<h> f53292i;

    /* renamed from: d.a.q0.h.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1143a extends d.a.q0.n.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f53293e;

        public C1143a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53293e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? a.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // d.a.q0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f53293e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: o */
        public void e(h hVar, d.a.q0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
                super.e(hVar, aVar);
                if (a.j) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + aVar.toString());
                }
                this.f53293e.f53290g.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (a.j) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
                }
                if (!j0.a(new File(hVar.f53932a), hVar.m)) {
                    if (a.j) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.f53293e.f53290g.a(false);
                    return;
                }
                File a2 = this.f53293e.f53291h.a();
                if (a2.exists()) {
                    d.i(a2);
                } else {
                    d.k(a2);
                }
                boolean T = d.T(hVar.f53932a, a2.getAbsolutePath());
                if (T) {
                    this.f53293e.f53291h.b(hVar.j, hVar.f53940i);
                }
                d.j(hVar.f53932a);
                this.f53293e.f53290g.a(T);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
                super.c(hVar);
                if (a.j) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.n.f.b, d.a.q0.n.f.c
        /* renamed from: r */
        public void f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
                super.f(hVar);
                if (a.j) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1411687270, "Ld/a/q0/h/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1411687270, "Ld/a/q0/h/f/j/a;");
                return;
            }
        }
        j = k.f49133a;
    }

    public a(@NonNull d.a.q0.h.f.k.a aVar, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53292i = new C1143a(this);
        this.f53290g = bVar;
        this.f53291h = aVar;
    }

    @Override // d.a.q0.n.f.g
    public void B(d.a.q0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (j) {
                Log.e("ConsoleJsDownload", "onFetchError: " + aVar.toString());
            }
            this.f53290g.a(false);
        }
    }

    @Override // d.a.q0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            if (j) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // d.a.q0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            if (j) {
                Log.i("ConsoleJsDownload", "onNoPackage");
            }
            this.f53290g.a(false);
        }
    }

    @Override // d.a.q0.n.f.g
    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            if (j) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // d.a.q0.n.f.g
    public c<h> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53292i : (c) invokeV.objValue;
    }
}
