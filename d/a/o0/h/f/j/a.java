package d.a.o0.h.f.j;

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
import d.a.o0.a.h0.m.j;
import d.a.o0.a.k;
import d.a.o0.a.v2.j0;
import d.a.o0.h.f.b;
import d.a.o0.h.s.a;
import d.a.o0.n.f.c;
import d.a.o0.n.h.h;
import d.a.o0.n.o.f;
import d.a.o0.t.d;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f50492g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.h.f.k.a f50493h;

    /* renamed from: i  reason: collision with root package name */
    public c<h> f50494i;

    /* renamed from: d.a.o0.h.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1101a extends d.a.o0.n.f.b<h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50495e;

        public C1101a(a aVar) {
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
            this.f50495e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hVar)) == null) ? a.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // d.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f50495e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: o */
        public void e(h hVar, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hVar, aVar) == null) {
                super.e(hVar, aVar);
                if (a.j) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + aVar.toString());
                }
                this.f50495e.f50492g.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar) == null) {
                super.i(hVar);
                if (a.j) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
                }
                if (!j0.a(new File(hVar.f51134a), hVar.m)) {
                    if (a.j) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.f50495e.f50492g.a(false);
                    return;
                }
                File a2 = this.f50495e.f50493h.a();
                if (a2.exists()) {
                    d.i(a2);
                } else {
                    d.k(a2);
                }
                boolean T = d.T(hVar.f51134a, a2.getAbsolutePath());
                if (T) {
                    this.f50495e.f50493h.b(hVar.j, hVar.f51142i);
                }
                d.j(hVar.f51134a);
                this.f50495e.f50492g.a(T);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
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
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2112751848, "Ld/a/o0/h/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2112751848, "Ld/a/o0/h/f/j/a;");
                return;
            }
        }
        j = k.f46335a;
    }

    public a(@NonNull d.a.o0.h.f.k.a aVar, @NonNull b bVar) {
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
        this.f50494i = new C1101a(this);
        this.f50492g = bVar;
        this.f50493h = aVar;
    }

    @Override // d.a.o0.n.f.g
    public void B(d.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (j) {
                Log.e("ConsoleJsDownload", "onFetchError: " + aVar.toString());
            }
            this.f50492g.a(false);
        }
    }

    @Override // d.a.o0.n.f.g
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D();
            if (j) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // d.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            if (j) {
                Log.i("ConsoleJsDownload", "onNoPackage");
            }
            this.f50492g.a(false);
        }
    }

    @Override // d.a.o0.n.f.g
    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            super.F(fVar);
            if (j) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // d.a.o0.n.f.g
    public c<h> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50494i : (c) invokeV.objValue;
    }
}
