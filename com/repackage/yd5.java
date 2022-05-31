package com.repackage;

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
import com.repackage.sd5;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class yd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final td5 a;
    public final BitmapRegionDecoder b;
    public zf<sd5.a, sd5> c;
    public ag<sd5> d;
    public final ThreadPoolExecutor e;
    public BdAsyncTask<Void, Void, Void> f;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd5 a;

        public a(yd5 yd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                try {
                    this.a.e.shutdownNow();
                    this.a.e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.a.b != null) {
                    this.a.b.recycle();
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

        public b(yd5 yd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes7.dex */
    public class c extends zf<sd5.a, sd5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(yd5 yd5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = yd5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zf
        /* renamed from: o */
        public void b(boolean z, sd5.a aVar, sd5 sd5Var, sd5 sd5Var2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), aVar, sd5Var, sd5Var2}) == null) || !z || this.h.d == null || sd5Var == null) {
                return;
            }
            sd5Var.a();
            this.h.d.e(sd5Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zf
        /* renamed from: p */
        public int m(sd5.a aVar, sd5 sd5Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, sd5Var)) == null) {
                if (sd5Var == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(sd5Var.b());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public td5 d;
        public BitmapRegionDecoder e;
        public zf<sd5.a, sd5> f;
        public ud5 g;
        public yd5 h;

        public d(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final void b(yd5 yd5Var, td5 td5Var, BitmapRegionDecoder bitmapRegionDecoder, zf<sd5.a, sd5> zfVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, yd5Var, td5Var, bitmapRegionDecoder, zfVar) == null) {
                this.d = td5Var;
                this.e = bitmapRegionDecoder;
                this.f = zfVar;
                this.h = yd5Var;
            }
        }

        public final boolean c(Rect rect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) ? rect.right <= rect.left || rect.bottom <= rect.top : invokeL.booleanValue;
        }

        public void d(ud5 ud5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ud5Var) == null) {
                this.g = ud5Var;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            sd5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f != null && this.d.b(this.a, this.b, this.c)) {
                Rect j = this.d.j(this.a, this.b, this.c);
                this.d.a(j);
                if (c(j)) {
                    return;
                }
                try {
                    c = this.h.f().b();
                    if (c != null) {
                        if (!c.g(j)) {
                            System.currentTimeMillis();
                            c.a();
                        }
                    } else {
                        c = this.d.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    zf<sd5.a, sd5> zfVar = this.f;
                    zfVar.k((int) (zfVar.g() * 0.8d));
                    System.gc();
                    try {
                        c = this.d.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.c;
                options.inBitmap = c.b();
                options.inMutable = true;
                System.currentTimeMillis();
                Bitmap decodeRegion = this.e.decodeRegion(j, options);
                if (decodeRegion == null) {
                    options.inBitmap = null;
                    decodeRegion = this.e.decodeRegion(j, options);
                    if (decodeRegion == null) {
                        return;
                    }
                }
                decodeRegion.prepareToDraw();
                c.h(decodeRegion);
                c.j(this.a, this.b, this.c);
                this.f.h(c.d(), c);
                ud5 ud5Var = this.g;
                if (ud5Var != null) {
                    ud5Var.onLoadFinished();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755145625, "Lcom/repackage/yd5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755145625, "Lcom/repackage/yd5;");
        }
    }

    public yd5(td5 td5Var, BitmapRegionDecoder bitmapRegionDecoder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {td5Var, bitmapRegionDecoder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = td5Var;
        this.b = bitmapRegionDecoder;
        u25.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.c = new c(this, (int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        ag<sd5> p = u25.k().p(this.a.e());
        this.d = p;
        p.f(6);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.e.purge();
            if (z && this.f == null) {
                a aVar = new a(this);
                this.f = aVar;
                aVar.execute(new Void[0]);
            }
        }
    }

    public zf<sd5.a, sd5> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (zf) invokeV.objValue;
    }

    public ag<sd5> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (ag) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d(true);
            zf<sd5.a, sd5> zfVar = this.c;
            if (zfVar != null) {
                zfVar.k(0);
                this.c.a();
                this.c = null;
            }
            this.d = null;
        }
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && this.f == null) {
            dVar.b(this, this.a, this.b, e());
            this.e.submit(dVar);
        }
    }
}
