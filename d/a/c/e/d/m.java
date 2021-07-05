package d.a.c.e.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.e;
import d.a.c.e.d.l;
/* loaded from: classes8.dex */
public class m<T> implements l.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f44109a;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f44110b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44111c;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l.a f44113f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f44114g;

        public a(m mVar, String str, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44114g = mVar;
            this.f44112e = str;
            this.f44113f = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: d.a.c.e.d.l$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44113f.a(this.f44112e, this.f44114g.get(this.f44112e));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f44116f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f44117g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ m f44118h;

        public b(m mVar, String str, Object obj, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, str, obj, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44118h = mVar;
            this.f44115e = str;
            this.f44116f = obj;
            this.f44117g = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: d.a.c.e.d.m */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44118h.e(this.f44115e, this.f44116f, this.f44117g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f44120f;

        public c(m mVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44120f = mVar;
            this.f44119e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44120f.remove(this.f44119e);
            }
        }
    }

    public m(String str, k<T> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44109a = false;
        this.f44111c = str;
        this.f44110b = kVar;
    }

    @Override // d.a.c.e.d.l
    public void a(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, t) == null) {
            i(str, t, 315532800000L);
        }
    }

    @Override // d.a.c.e.d.l.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f44110b.g(this.f44111c);
            l();
        }
    }

    @Override // d.a.c.e.d.l.c
    public k<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44110b : (k) invokeV.objValue;
    }

    @Override // d.a.c.e.d.l
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            d.a.c.e.m.h.a().b(new c(this, str));
        }
    }

    @Override // d.a.c.e.d.l
    public void e(String str, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, t, Long.valueOf(j)}) == null) {
            if (str != null) {
                if (j <= 315532800000L) {
                    j += System.currentTimeMillis();
                }
                long j2 = j;
                if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
                    if (!this.f44109a) {
                        BdLog.detailException("access db in main thread!", new Exception());
                    } else {
                        throw new RuntimeException("access db in main thread!");
                    }
                }
                if (j2 <= System.currentTimeMillis()) {
                    remove(str);
                    return;
                } else {
                    this.f44110b.f(this.f44111c, str, t, j2);
                    return;
                }
            }
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
    }

    @Override // d.a.c.e.d.l
    public void f(String str, l.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, aVar) == null) {
            d.a.c.e.m.h.a().b(new a(this, str, aVar));
        }
    }

    @Override // d.a.c.e.d.l
    public void g(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, t) == null) {
            e(str, t, 315532800000L);
        }
    }

    @Override // d.a.c.e.d.l
    public T get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
                if (!this.f44109a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            return this.f44110b.e(this.f44111c, str);
        }
        return (T) invokeL.objValue;
    }

    @Override // d.a.c.e.d.l
    public l.b<T> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
                if (!this.f44109a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            return this.f44110b.d(this.f44111c, str);
        }
        return (l.b) invokeL.objValue;
    }

    @Override // d.a.c.e.d.l
    public void i(String str, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, t, Long.valueOf(j)}) == null) {
            d.a.c.e.m.h.a().b(new b(this, str, t, j));
        }
    }

    @Override // d.a.c.e.d.l.c
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f44111c : (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f44110b.a(this.f44111c);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e b2 = c().b();
            if (b2 instanceof e.b) {
                ((e.b) b2).release();
            }
        }
    }

    @Override // d.a.c.e.d.l
    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (BdBaseApplication.getInst().isDebugMode() && d.a.c.e.p.l.C()) {
                if (!this.f44109a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            this.f44110b.c(this.f44111c, str);
        }
    }
}
