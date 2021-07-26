package d.a.o0.a.a1;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.i;
import d.a.o0.a.a2.m;
import d.a.o0.a.f1.e.f.c;
import d.a.o0.a.k;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class g extends m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f43832i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, f> f43833f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.o0.a.f1.e.f.c f43834g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.o0.a.f1.e.f.c f43835h;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f43836e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43836e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.g(this.f43836e);
                this.f43836e.f43833f.put(fVar.f43841e, fVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.c1.a f43837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f43838f;

        public b(g gVar, d.a.o0.a.v2.c1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43838f = gVar;
            this.f43837e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if ("on_progress".equals(str)) {
                    this.f43838f.A((i.a) new i.a("installer_on_progress").u(" event_params_installer_progress", this.f43837e.j()));
                } else if ("pump_finish".equals(str)) {
                    this.f43838f.q("installer_on_pump_finish");
                } else if (ConstantHelper.LOG_FINISH.equals(str)) {
                    this.f43838f.q("installer_on_finish");
                } else if ("start".equals(str)) {
                    this.f43838f.q("installer_on_start");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.c1.a f43839e;

        public c(g gVar, d.a.o0.a.v2.c1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43839e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f43839e.d(fVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                fVar.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean[] f43840e;

        public e(g gVar, boolean[] zArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, zArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43840e = zArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean[] zArr = this.f43840e;
                zArr[0] = fVar.c() & zArr[0];
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class f implements d.a.o0.a.v2.e1.b<Pipe.SourceChannel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final String f43841e;

        /* renamed from: f  reason: collision with root package name */
        public final Bundle f43842f;

        /* renamed from: g  reason: collision with root package name */
        public g f43843g;

        public f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43842f = new Bundle();
            this.f43841e = str;
        }

        public Bundle b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43842f : (Bundle) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b().getBoolean("flag_is_ok") : invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: d */
        public void onCallback(Pipe.SourceChannel sourceChannel) {
            g gVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sourceChannel) == null) && (gVar = this.f43843g) != null && f(sourceChannel, gVar.f43834g.C())) {
                h();
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public abstract boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle);

        public final void g(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
                this.f43843g = gVar;
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f43842f.putBoolean("flag_is_ok", true);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f43841e : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(503527196, "Ld/a/o0/a/a1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(503527196, "Ld/a/o0/a/a1/g;");
                return;
            }
        }
        f43832i = k.f46335a;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43833f = new HashMap();
        this.f43834g = new c.a();
        this.f43835h = new c.a();
    }

    public g f(f... fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVarArr)) == null) {
            d.a.o0.a.v2.e1.a.d(new a(this), fVarArr);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f43834g.D(bundle);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final void h(d.a.o0.a.v2.e1.b<f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            d.a.o0.a.v2.e1.a.c(bVar, this.f43833f.values());
        }
    }

    public synchronized g i(ReadableByteChannel readableByteChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, readableByteChannel)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f43835h.b();
                d.a.o0.a.v2.c1.a aVar = new d.a.o0.a.v2.c1.a();
                aVar.o(32768);
                aVar.q(30L, TimeUnit.SECONDS);
                aVar.g(this.f43834g.C());
                aVar.p(new b(this, aVar));
                h(new c(this, aVar));
                k("connect: " + readableByteChannel + " at: " + currentTimeMillis);
                aVar.h(readableByteChannel);
                boolean j = j();
                if (f43832i) {
                    k("allOk: " + j + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (!j) {
                    h(new d(this));
                }
            }
            return this;
        }
        return (g) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f43833f.isEmpty() || this.f43835h.e("flag_is_ok", false)) {
                return true;
            }
            boolean[] zArr = {true};
            h(new e(this, zArr));
            this.f43835h.s("flag_is_ok", zArr[0]);
            return zArr[0];
        }
        return invokeV.booleanValue;
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && f43832i) {
            d.a.o0.a.f1.g.a.d(this.f43834g.o("launch_id", "")).f(str).b("SwanInstaller");
            Log.i("SwanInstaller", str);
        }
    }
}
