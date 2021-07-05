package d.a.r0.b1.i.c;

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
import d.a.r0.b1.i.a.a;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.r0.b1.i.a.b f54983a;

    /* renamed from: b  reason: collision with root package name */
    public final BitmapRegionDecoder f54984b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.k.a<a.C1227a, d.a.r0.b1.i.a.a> f54985c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.k.b<d.a.r0.b1.i.a.a> f54986d;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadPoolExecutor f54987e;

    /* renamed from: f  reason: collision with root package name */
    public BdAsyncTask<Void, Void, Void> f54988f;

    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f54989a;

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
            this.f54989a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                try {
                    this.f54989a.f54987e.shutdownNow();
                    this.f54989a.f54987e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f54989a.f54984b != null) {
                    this.f54989a.f54984b.recycle();
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
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

    /* renamed from: d.a.r0.b1.i.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1229c extends d.a.c.e.k.a<a.C1227a, d.a.r0.b1.i.a.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f54990h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1229c(c cVar, int i2) {
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
            this.f54990h = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, a.C1227a c1227a, d.a.r0.b1.i.a.a aVar, d.a.r0.b1.i.a.a aVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), c1227a, aVar, aVar2}) == null) || !z || this.f54990h.f54986d == null || aVar == null) {
                return;
            }
            aVar.a();
            this.f54990h.f54986d.e(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: p */
        public int m(a.C1227a c1227a, d.a.r0.b1.i.a.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, c1227a, aVar)) == null) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.b());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f54991e;

        /* renamed from: f  reason: collision with root package name */
        public int f54992f;

        /* renamed from: g  reason: collision with root package name */
        public int f54993g;

        /* renamed from: h  reason: collision with root package name */
        public d.a.r0.b1.i.a.b f54994h;

        /* renamed from: i  reason: collision with root package name */
        public BitmapRegionDecoder f54995i;
        public d.a.c.e.k.a<a.C1227a, d.a.r0.b1.i.a.a> j;
        public d.a.r0.b1.i.b.a k;
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
            this.f54991e = i2;
            this.f54992f = i3;
            this.f54993g = i4;
        }

        public final void b(c cVar, d.a.r0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, d.a.c.e.k.a<a.C1227a, d.a.r0.b1.i.a.a> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, cVar, bVar, bitmapRegionDecoder, aVar) == null) {
                this.f54994h = bVar;
                this.f54995i = bitmapRegionDecoder;
                this.j = aVar;
                this.l = cVar;
            }
        }

        public final boolean c(Rect rect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) ? rect.right <= rect.left || rect.bottom <= rect.top : invokeL.booleanValue;
        }

        public void d(d.a.r0.b1.i.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.k = aVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.r0.b1.i.a.a c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.j != null && this.f54994h.b(this.f54991e, this.f54992f, this.f54993g)) {
                Rect j = this.f54994h.j(this.f54991e, this.f54992f, this.f54993g);
                this.f54994h.a(j);
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
                        c2 = this.f54994h.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    d.a.c.e.k.a<a.C1227a, d.a.r0.b1.i.a.a> aVar = this.j;
                    aVar.k((int) (aVar.g() * 0.8d));
                    System.gc();
                    try {
                        c2 = this.f54994h.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.f54993g;
                options.inBitmap = c2.b();
                options.inMutable = true;
                System.currentTimeMillis();
                Bitmap decodeRegion = this.f54995i.decodeRegion(j, options);
                if (decodeRegion == null) {
                    options.inBitmap = null;
                    decodeRegion = this.f54995i.decodeRegion(j, options);
                    if (decodeRegion == null) {
                        return;
                    }
                }
                decodeRegion.prepareToDraw();
                c2.h(decodeRegion);
                c2.j(this.f54991e, this.f54992f, this.f54993g);
                this.j.h(c2.d(), c2);
                d.a.r0.b1.i.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.onLoadFinished();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(801339070, "Ld/a/r0/b1/i/c/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(801339070, "Ld/a/r0/b1/i/c/c;");
        }
    }

    public c(d.a.r0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
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
        this.f54983a = bVar;
        this.f54984b = bitmapRegionDecoder;
        d.a.r0.a0.c.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.f54987e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.f54985c = new C1229c(this, (int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        d.a.c.e.k.b<d.a.r0.b1.i.a.a> p = d.a.r0.a0.c.k().p(this.f54983a.e());
        this.f54986d = p;
        p.f(6);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f54987e.purge();
            if (z && this.f54988f == null) {
                a aVar = new a(this);
                this.f54988f = aVar;
                aVar.execute(new Void[0]);
            }
        }
    }

    public d.a.c.e.k.a<a.C1227a, d.a.r0.b1.i.a.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54985c : (d.a.c.e.k.a) invokeV.objValue;
    }

    public d.a.c.e.k.b<d.a.r0.b1.i.a.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54986d : (d.a.c.e.k.b) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d(true);
            d.a.c.e.k.a<a.C1227a, d.a.r0.b1.i.a.a> aVar = this.f54985c;
            if (aVar != null) {
                aVar.k(0);
                this.f54985c.a();
                this.f54985c = null;
            }
            this.f54986d = null;
        }
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && this.f54988f == null) {
            dVar.b(this, this.f54983a, this.f54984b, e());
            this.f54987e.submit(dVar);
        }
    }
}
