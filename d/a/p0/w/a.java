package d.a.p0.w;

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
    public static final ThreadLocal<a> f65668g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f65669a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f65670b;

    /* renamed from: c  reason: collision with root package name */
    public final C1819a f65671c;

    /* renamed from: d  reason: collision with root package name */
    public c f65672d;

    /* renamed from: e  reason: collision with root package name */
    public long f65673e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65674f;

    /* renamed from: d.a.p0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1819a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65675a;

        public C1819a(a aVar) {
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
            this.f65675a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65675a.f65673e = SystemClock.uptimeMillis();
                a aVar = this.f65675a;
                aVar.h(aVar.f65673e);
                if (this.f65675a.f65670b.size() > 0) {
                    this.f65675a.j().a();
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
        public final C1819a f65676a;

        public c(C1819a c1819a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1819a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65676a = c1819a;
        }

        public abstract void a();
    }

    /* loaded from: classes8.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f65677b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f65678c;

        /* renamed from: d  reason: collision with root package name */
        public long f65679d;

        /* renamed from: d.a.p0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1820a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f65680e;

            public RunnableC1820a(d dVar) {
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
                this.f65680e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f65680e.f65679d = SystemClock.uptimeMillis();
                    this.f65680e.f65676a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1819a c1819a) {
            super(c1819a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1819a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1819a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65679d = -1L;
            this.f65677b = new RunnableC1820a(this);
            this.f65678c = new Handler(Looper.myLooper());
        }

        @Override // d.a.p0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65678c.postDelayed(this.f65677b, Math.max(10 - (SystemClock.uptimeMillis() - this.f65679d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes8.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f65681b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f65682c;

        /* renamed from: d.a.p0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class Choreographer$FrameCallbackC1821a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f65683e;

            public Choreographer$FrameCallbackC1821a(e eVar) {
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
                this.f65683e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    this.f65683e.f65676a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C1819a c1819a) {
            super(c1819a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1819a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1819a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65681b = Choreographer.getInstance();
            this.f65682c = new Choreographer$FrameCallbackC1821a(this);
        }

        @Override // d.a.p0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65681b.postFrameCallback(this.f65682c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(88321052, "Ld/a/p0/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(88321052, "Ld/a/p0/w/a;");
                return;
            }
        }
        f65668g = new ThreadLocal<>();
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
        this.f65669a = new SimpleArrayMap<>();
        this.f65670b = new ArrayList<>();
        this.f65671c = new C1819a(this);
        this.f65673e = 0L;
        this.f65674f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f65668g.get() == null) {
                f65668g.set(new a());
            }
            return f65668g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j) == null) {
            if (this.f65670b.size() == 0) {
                j().a();
            }
            if (!this.f65670b.contains(bVar)) {
                this.f65670b.add(bVar);
            }
            if (j > 0) {
                this.f65669a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f65674f) {
            for (int size = this.f65670b.size() - 1; size >= 0; size--) {
                if (this.f65670b.get(size) == null) {
                    this.f65670b.remove(size);
                }
            }
            this.f65674f = false;
        }
    }

    public final void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f65670b.size(); i2++) {
                b bVar = this.f65670b.get(i2);
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
            if (this.f65672d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f65672d = new e(this.f65671c);
                } else {
                    this.f65672d = new d(this.f65671c);
                }
            }
            return this.f65672d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j)) == null) {
            Long l = this.f65669a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j) {
                this.f65669a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f65669a.remove(bVar);
            int indexOf = this.f65670b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f65670b.set(indexOf, null);
                this.f65674f = true;
            }
        }
    }
}
