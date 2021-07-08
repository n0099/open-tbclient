package d.a.o0.b1.i.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.b1.i.a.a;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.o0.b1.i.a.b f51688a;

    /* renamed from: b  reason: collision with root package name */
    public final BitmapRegionDecoder f51689b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.k.a<a.C1176a, d.a.o0.b1.i.a.a> f51690c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.k.b<d.a.o0.b1.i.a.a> f51691d;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadPoolExecutor f51692e;

    /* renamed from: f  reason: collision with root package name */
    public BdAsyncTask<Void, Void, Void> f51693f;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f51694a;

        public a(c cVar) {
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
            this.f51694a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                try {
                    this.f51694a.f51692e.shutdownNow();
                    this.f51694a.f51692e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f51694a.f51689b != null) {
                    this.f51694a.f51689b.recycle();
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements RejectedExecutionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
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
                }
            }
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
            }
        }
    }

    /* renamed from: d.a.o0.b1.i.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1178c extends d.a.c.e.k.a<a.C1176a, d.a.o0.b1.i.a.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f51695h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1178c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51695h = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, a.C1176a c1176a, d.a.o0.b1.i.a.a aVar, d.a.o0.b1.i.a.a aVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), c1176a, aVar, aVar2}) == null) || !z || this.f51695h.f51691d == null || aVar == null) {
                return;
            }
            aVar.a();
            this.f51695h.f51691d.e(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: p */
        public int m(a.C1176a c1176a, d.a.o0.b1.i.a.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, c1176a, aVar)) == null) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.b());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f51696e;

        /* renamed from: f  reason: collision with root package name */
        public int f51697f;

        /* renamed from: g  reason: collision with root package name */
        public int f51698g;

        /* renamed from: h  reason: collision with root package name */
        public d.a.o0.b1.i.a.b f51699h;

        /* renamed from: i  reason: collision with root package name */
        public BitmapRegionDecoder f51700i;
        public d.a.c.e.k.a<a.C1176a, d.a.o0.b1.i.a.a> j;
        public d.a.o0.b1.i.b.a k;
        public c l;

        public d(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51696e = i2;
            this.f51697f = i3;
            this.f51698g = i4;
        }

        public final void b(c cVar, d.a.o0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, d.a.c.e.k.a<a.C1176a, d.a.o0.b1.i.a.a> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, cVar, bVar, bitmapRegionDecoder, aVar) == null) {
                this.f51699h = bVar;
                this.f51700i = bitmapRegionDecoder;
                this.j = aVar;
                this.l = cVar;
            }
        }

        public final boolean c(Rect rect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) ? rect.right <= rect.left || rect.bottom <= rect.top : invokeL.booleanValue;
        }

        public void d(d.a.o0.b1.i.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.k = aVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.o0.b1.i.a.a c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.j != null && this.f51699h.b(this.f51696e, this.f51697f, this.f51698g)) {
                Rect j = this.f51699h.j(this.f51696e, this.f51697f, this.f51698g);
                this.f51699h.a(j);
                if (c(j)) {
                    return;
                }
                try {
                    c2 = this.l.f().b();
                    if (c2 != null) {
                        if (!c2.g(j)) {
                            System.currentTimeMillis();
                            c2.a();
                        }
                    } else {
                        c2 = this.f51699h.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    d.a.c.e.k.a<a.C1176a, d.a.o0.b1.i.a.a> aVar = this.j;
                    aVar.k((int) (aVar.g() * 0.8d));
                    System.gc();
                    try {
                        c2 = this.f51699h.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.f51698g;
                options.inBitmap = c2.b();
                options.inMutable = true;
                System.currentTimeMillis();
                Bitmap decodeRegion = this.f51700i.decodeRegion(j, options);
                if (decodeRegion == null) {
                    options.inBitmap = null;
                    decodeRegion = this.f51700i.decodeRegion(j, options);
                    if (decodeRegion == null) {
                        return;
                    }
                }
                decodeRegion.prepareToDraw();
                c2.h(decodeRegion);
                c2.j(this.f51696e, this.f51697f, this.f51698g);
                this.j.h(c2.d(), c2);
                d.a.o0.b1.i.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.onLoadFinished();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(414090913, "Ld/a/o0/b1/i/c/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(414090913, "Ld/a/o0/b1/i/c/c;");
        }
    }

    public c(d.a.o0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bitmapRegionDecoder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51688a = bVar;
        this.f51689b = bitmapRegionDecoder;
        d.a.o0.a0.c.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.f51692e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.f51690c = new C1178c(this, (int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        d.a.c.e.k.b<d.a.o0.b1.i.a.a> p = d.a.o0.a0.c.k().p(this.f51688a.e());
        this.f51691d = p;
        p.f(6);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f51692e.purge();
            if (z && this.f51693f == null) {
                a aVar = new a(this);
                this.f51693f = aVar;
                aVar.execute(new Void[0]);
            }
        }
    }

    public d.a.c.e.k.a<a.C1176a, d.a.o0.b1.i.a.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51690c : (d.a.c.e.k.a) invokeV.objValue;
    }

    public d.a.c.e.k.b<d.a.o0.b1.i.a.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51691d : (d.a.c.e.k.b) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d(true);
            d.a.c.e.k.a<a.C1176a, d.a.o0.b1.i.a.a> aVar = this.f51690c;
            if (aVar != null) {
                aVar.k(0);
                this.f51690c.a();
                this.f51690c = null;
            }
            this.f51691d = null;
        }
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && this.f51693f == null) {
            dVar.b(this, this.f51688a, this.f51689b, e());
            this.f51692e.submit(dVar);
        }
    }
}
