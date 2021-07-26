package d.a.o0.a.m2.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e0.d;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f46644c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.o0.a.v2.e1.b<Exception>> f46645a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.o0.a.v2.e1.b<Exception>> f46646b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46647e;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46647e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.h("PresetSwanCoreUpdater", "onPresetCheck start.");
                d.a.o0.a.m2.e.a.s(this.f46647e);
                d.h("PresetSwanCoreUpdater", "onPresetCheck end.");
            }
        }
    }

    /* renamed from: d.a.o0.a.m2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0824b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46648e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f46649f;

        public RunnableC0824b(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46649f = bVar;
            this.f46648e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.h("PresetSwanCoreUpdater", "onPresetUpdate start.");
                b bVar = this.f46649f;
                int i2 = this.f46648e;
                bVar.c(i2, d.a.o0.a.m2.e.a.t(i2));
                d.h("PresetSwanCoreUpdater", "onPresetUpdate end.");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f46650e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f46651f;

        public c(b bVar, d.a.o0.a.v2.e1.b bVar2, Exception exc) {
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
            this.f46650e = bVar2;
            this.f46651f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46650e.onCallback(this.f46651f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(647001622, "Ld/a/o0/a/m2/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(647001622, "Ld/a/o0/a/m2/e/b;");
                return;
            }
        }
        boolean z = k.f46335a;
    }

    public b() {
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
        this.f46645a = new ArrayList<>();
        this.f46646b = new ArrayList<>();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f46644c == null) {
                synchronized (b.class) {
                    if (f46644c == null) {
                        f46644c = new b();
                    }
                }
            }
            return f46644c;
        }
        return (b) invokeV.objValue;
    }

    public final void c(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, exc) == null) {
            synchronized (b.class) {
                try {
                    if (i2 == 0) {
                        Iterator<d.a.o0.a.v2.e1.b<Exception>> it = this.f46645a.iterator();
                        while (it.hasNext()) {
                            d(it.next(), exc);
                        }
                        this.f46645a.clear();
                    } else if (i2 == 1) {
                        Iterator<d.a.o0.a.v2.e1.b<Exception>> it2 = this.f46646b.iterator();
                        while (it2.hasNext()) {
                            d(it2.next(), exc);
                        }
                        this.f46646b.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void d(d.a.o0.a.v2.e1.b<Exception> bVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, exc) == null) || bVar == null) {
            return;
        }
        q0.b0(new c(this, bVar, exc));
    }

    public void e(d.a.o0.a.v2.e1.b<Exception> bVar, int i2) {
        ArrayList<d.a.o0.a.v2.e1.b<Exception>> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) {
            d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync start.");
            synchronized (b.class) {
                boolean q = d.a.o0.a.m2.e.a.q(i2);
                d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync isNeedUpdateStatus = " + q);
                if (!q && i2 == 0 && !d.a.o0.a.m2.e.a.r(i2)) {
                    d.a.o0.a.m2.e.a.w(true, i2);
                    new Thread(new a(this, i2), "onPresetCheck").start();
                }
                if (!q) {
                    d(bVar, null);
                    return;
                }
                if (i2 == 1) {
                    arrayList = this.f46646b;
                } else {
                    arrayList = this.f46645a;
                }
                if (arrayList.isEmpty()) {
                    new Thread(new RunnableC0824b(this, i2), "updateSwanCoreAsync").start();
                }
                arrayList.add(bVar);
                d.h("PresetSwanCoreUpdater", "updateSwanCoreAsync end.");
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (b.class) {
                c(i2, d.a.o0.a.m2.e.a.t(i2));
            }
        }
    }
}
