package d.a.q0.w;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f66325g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f66326a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f66327b;

    /* renamed from: c  reason: collision with root package name */
    public final C1822a f66328c;

    /* renamed from: d  reason: collision with root package name */
    public c f66329d;

    /* renamed from: e  reason: collision with root package name */
    public long f66330e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66331f;

    /* renamed from: d.a.q0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1822a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66332a;

        public C1822a(a aVar) {
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
            this.f66332a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66332a.f66330e = SystemClock.uptimeMillis();
                a aVar = this.f66332a;
                aVar.h(aVar.f66330e);
                if (this.f66332a.f66327b.size() > 0) {
                    this.f66332a.j().a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        boolean a(long j);
    }

    /* loaded from: classes8.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final C1822a f66333a;

        public c(C1822a c1822a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1822a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66333a = c1822a;
        }

        public abstract void a();
    }

    /* loaded from: classes8.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f66334b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f66335c;

        /* renamed from: d  reason: collision with root package name */
        public long f66336d;

        /* renamed from: d.a.q0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1823a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f66337e;

            public RunnableC1823a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66337e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f66337e.f66336d = SystemClock.uptimeMillis();
                    this.f66337e.f66333a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1822a c1822a) {
            super(c1822a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1822a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1822a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66336d = -1L;
            this.f66334b = new RunnableC1823a(this);
            this.f66335c = new Handler(Looper.myLooper());
        }

        @Override // d.a.q0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66335c.postDelayed(this.f66334b, Math.max(10 - (SystemClock.uptimeMillis() - this.f66336d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes8.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f66338b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f66339c;

        /* renamed from: d.a.q0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class Choreographer$FrameCallbackC1824a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f66340e;

            public Choreographer$FrameCallbackC1824a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66340e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    this.f66340e.f66333a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C1822a c1822a) {
            super(c1822a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1822a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1822a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66338b = Choreographer.getInstance();
            this.f66339c = new Choreographer$FrameCallbackC1824a(this);
        }

        @Override // d.a.q0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66338b.postFrameCallback(this.f66339c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975824733, "Ld/a/q0/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975824733, "Ld/a/q0/w/a;");
                return;
            }
        }
        f66325g = new ThreadLocal<>();
    }

    public a() {
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
        this.f66326a = new SimpleArrayMap<>();
        this.f66327b = new ArrayList<>();
        this.f66328c = new C1822a(this);
        this.f66330e = 0L;
        this.f66331f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f66325g.get() == null) {
                f66325g.set(new a());
            }
            return f66325g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j) == null) {
            if (this.f66327b.size() == 0) {
                j().a();
            }
            if (!this.f66327b.contains(bVar)) {
                this.f66327b.add(bVar);
            }
            if (j > 0) {
                this.f66326a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f66331f) {
            for (int size = this.f66327b.size() - 1; size >= 0; size--) {
                if (this.f66327b.get(size) == null) {
                    this.f66327b.remove(size);
                }
            }
            this.f66331f = false;
        }
    }

    public final void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f66327b.size(); i2++) {
                b bVar = this.f66327b.get(i2);
                if (bVar != null && k(bVar, uptimeMillis)) {
                    bVar.a(j);
                }
            }
            g();
        }
    }

    public final c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f66329d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f66329d = new e(this.f66328c);
                } else {
                    this.f66329d = new d(this.f66328c);
                }
            }
            return this.f66329d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j)) == null) {
            Long l = this.f66326a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j) {
                this.f66326a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f66326a.remove(bVar);
            int indexOf = this.f66327b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f66327b.set(indexOf, null);
                this.f66331f = true;
            }
        }
    }
}
