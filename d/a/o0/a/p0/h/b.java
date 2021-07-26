package d.a.o0.a.p0.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e0.d;
import d.a.o0.a.k;
import d.a.o0.a.k2.g.h;
import d.a.o0.a.p0.g.c.a;
import d.a.o0.a.v2.q0;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public abstract class b<T extends d.a.o0.a.p0.g.c.a> extends d.a.o0.a.p0.d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47228c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.o0.a.v2.e1.b<Exception>> f47229b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f47230e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47230e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.h("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                d.a.o0.a.p0.h.a b2 = d.a.o0.a.p0.h.a.b(this.f47230e.f47143a);
                d.a.o0.a.p0.g.a aVar = new d.a.o0.a.p0.g.a();
                aVar.f47218a = b2.f47226a;
                aVar.f47219b = b2.f47227b;
                aVar.f47220c = this.f47230e.f47143a.a();
                b bVar = this.f47230e;
                bVar.l(bVar.g(aVar));
            }
        }
    }

    /* renamed from: d.a.o0.a.p0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0874b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f47231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f47232f;

        public RunnableC0874b(b bVar, d.a.o0.a.v2.e1.b bVar2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47231e = bVar2;
            this.f47232f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47231e.onCallback(this.f47232f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1042623560, "Ld/a/o0/a/p0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1042623560, "Ld/a/o0/a/p0/h/b;");
                return;
            }
        }
        f47228c = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull T t) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.p0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47229b = new CopyOnWriteArrayList<>();
    }

    @Override // d.a.o0.a.p0.d.a
    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(super.a(), "preset") : (File) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o("0");
            n(0L);
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/o0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception g(@NonNull d.a.o0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            if (f47228c) {
                Log.d("ExtCore-PresetControl", "doUpdate: preset");
            }
            if (TextUtils.isEmpty(aVar.f47220c)) {
                if (f47228c) {
                    Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
                }
                return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
            }
            long j = aVar.f47219b;
            if (d.a.o0.t.d.U(aVar.f47220c, b(j).getPath())) {
                d.a.o0.a.p0.j.a.b(a(), j);
                n(j);
                o(aVar.f47218a);
                d.a.o0.a.p0.j.a.i(this.f47143a.c(), false);
                return null;
            }
            Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f47220c);
            if (f47228c) {
                Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            }
            return exc;
        }
        return (Exception) invokeL.objValue;
    }

    @NonNull
    public ExtensionCore h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ExtensionCore extensionCore = new ExtensionCore();
            long i2 = i();
            extensionCore.extensionCoreVersionCode = i2;
            extensionCore.extensionCoreVersionName = j();
            extensionCore.extensionCorePath = b(i2).getPath();
            extensionCore.extensionCoreType = 0;
            return extensionCore;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h.a().getLong(this.f47143a.b(), 0L) : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.a().getString(this.f47143a.e(), "") : (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!h().isAvailable()) {
                if (f47228c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate: true, getCurExtensionCore not available.");
                }
                return true;
            } else if (!d.a.o0.a.p0.j.a.h(this.f47143a.c())) {
                if (f47228c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                }
                return false;
            } else {
                d.a.o0.a.p0.h.a b2 = d.a.o0.a.p0.h.a.b(this.f47143a);
                long i2 = i();
                long j = b2.f47227b;
                if (f47228c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + i2 + " newVer: " + j);
                }
                return i2 < j;
            }
        }
        return invokeV.booleanValue;
    }

    public final void l(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            Iterator<d.a.o0.a.v2.e1.b<Exception>> it = this.f47229b.iterator();
            while (it.hasNext()) {
                m(it.next(), exc);
            }
            this.f47229b.clear();
        }
    }

    public final void m(@Nullable d.a.o0.a.v2.e1.b<Exception> bVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, exc) == null) || bVar == null) {
            return;
        }
        q0.b0(new RunnableC0874b(this, bVar, exc));
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            h.a().putLong(this.f47143a.b(), j);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            h.a().putString(this.f47143a.e(), str);
        }
    }

    @SuppressLint({"SwanNewThread"})
    public void p(@Nullable d.a.o0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            d.h("ExtCore-PresetControl", "tryUpdateAsync: start");
            if (!k()) {
                d.h("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
                m(bVar, null);
                return;
            }
            if (this.f47229b.isEmpty()) {
                new Thread(new a(this), "updateExtensionCoreAsync").start();
            }
            if (bVar != null) {
                this.f47229b.add(bVar);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && k()) {
            d.a.o0.a.p0.h.a b2 = d.a.o0.a.p0.h.a.b(this.f47143a);
            d.a.o0.a.p0.g.a aVar = new d.a.o0.a.p0.g.a();
            aVar.f47218a = b2.f47226a;
            aVar.f47219b = b2.f47227b;
            aVar.f47220c = this.f47143a.a();
            l(g(aVar));
        }
    }
}
