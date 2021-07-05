package d.a.s0.w;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f68884g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f68885a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f68886b;

    /* renamed from: c  reason: collision with root package name */
    public final C1861a f68887c;

    /* renamed from: d  reason: collision with root package name */
    public c f68888d;

    /* renamed from: e  reason: collision with root package name */
    public long f68889e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68890f;

    /* renamed from: d.a.s0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1861a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68891a;

        public C1861a(a aVar) {
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
            this.f68891a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68891a.f68889e = SystemClock.uptimeMillis();
                a aVar = this.f68891a;
                aVar.h(aVar.f68889e);
                if (this.f68891a.f68886b.size() > 0) {
                    this.f68891a.j().a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        boolean a(long j);
    }

    /* loaded from: classes9.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final C1861a f68892a;

        public c(C1861a c1861a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1861a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68892a = c1861a;
        }

        public abstract void a();
    }

    /* loaded from: classes9.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f68893b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f68894c;

        /* renamed from: d  reason: collision with root package name */
        public long f68895d;

        /* renamed from: d.a.s0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1862a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f68896e;

            public RunnableC1862a(d dVar) {
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
                this.f68896e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f68896e.f68895d = SystemClock.uptimeMillis();
                    this.f68896e.f68892a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1861a c1861a) {
            super(c1861a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1861a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1861a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68895d = -1L;
            this.f68893b = new RunnableC1862a(this);
            this.f68894c = new Handler(Looper.myLooper());
        }

        @Override // d.a.s0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68894c.postDelayed(this.f68893b, Math.max(10 - (SystemClock.uptimeMillis() - this.f68895d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes9.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f68897b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f68898c;

        /* renamed from: d.a.s0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class Choreographer$FrameCallbackC1863a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68899e;

            public Choreographer$FrameCallbackC1863a(e eVar) {
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
                this.f68899e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    this.f68899e.f68892a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C1861a c1861a) {
            super(c1861a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1861a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1861a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68897b = Choreographer.getInstance();
            this.f68898c = new Choreographer$FrameCallbackC1863a(this);
        }

        @Override // d.a.s0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68897b.postFrameCallback(this.f68898c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1544135201, "Ld/a/s0/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1544135201, "Ld/a/s0/w/a;");
                return;
            }
        }
        f68884g = new ThreadLocal<>();
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
        this.f68885a = new SimpleArrayMap<>();
        this.f68886b = new ArrayList<>();
        this.f68887c = new C1861a(this);
        this.f68889e = 0L;
        this.f68890f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f68884g.get() == null) {
                f68884g.set(new a());
            }
            return f68884g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j) == null) {
            if (this.f68886b.size() == 0) {
                j().a();
            }
            if (!this.f68886b.contains(bVar)) {
                this.f68886b.add(bVar);
            }
            if (j > 0) {
                this.f68885a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f68890f) {
            for (int size = this.f68886b.size() - 1; size >= 0; size--) {
                if (this.f68886b.get(size) == null) {
                    this.f68886b.remove(size);
                }
            }
            this.f68890f = false;
        }
    }

    public final void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f68886b.size(); i2++) {
                b bVar = this.f68886b.get(i2);
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
            if (this.f68888d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f68888d = new e(this.f68887c);
                } else {
                    this.f68888d = new d(this.f68887c);
                }
            }
            return this.f68888d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j)) == null) {
            Long l = this.f68885a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j) {
                this.f68885a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f68885a.remove(bVar);
            int indexOf = this.f68886b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f68886b.set(indexOf, null);
                this.f68890f = true;
            }
        }
    }
}
