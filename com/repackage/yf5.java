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
import com.repackage.sf5;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class yf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tf5 a;
    public final BitmapRegionDecoder b;
    public dg<sf5.a, sf5> c;
    public eg<sf5> d;
    public final ThreadPoolExecutor e;
    public BdAsyncTask<Void, Void, Void> f;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf5 a;

        public a(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf5Var;
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

        public b(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
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
    public class c extends dg<sf5.a, sf5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(yf5 yf5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var, Integer.valueOf(i)};
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
            this.h = yf5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.dg
        /* renamed from: o */
        public void b(boolean z, sf5.a aVar, sf5 sf5Var, sf5 sf5Var2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), aVar, sf5Var, sf5Var2}) == null) || !z || this.h.d == null || sf5Var == null) {
                return;
            }
            sf5Var.a();
            this.h.d.e(sf5Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.dg
        /* renamed from: p */
        public int m(sf5.a aVar, sf5 sf5Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, sf5Var)) == null) {
                if (sf5Var == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(sf5Var.b());
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
        public tf5 d;
        public BitmapRegionDecoder e;
        public dg<sf5.a, sf5> f;
        public uf5 g;
        public yf5 h;

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

        public final void b(yf5 yf5Var, tf5 tf5Var, BitmapRegionDecoder bitmapRegionDecoder, dg<sf5.a, sf5> dgVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, yf5Var, tf5Var, bitmapRegionDecoder, dgVar) == null) {
                this.d = tf5Var;
                this.e = bitmapRegionDecoder;
                this.f = dgVar;
                this.h = yf5Var;
            }
        }

        public final boolean c(Rect rect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) ? rect.right <= rect.left || rect.bottom <= rect.top : invokeL.booleanValue;
        }

        public void d(uf5 uf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uf5Var) == null) {
                this.g = uf5Var;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            sf5 c;
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
                    dg<sf5.a, sf5> dgVar = this.f;
                    dgVar.k((int) (dgVar.g() * 0.8d));
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
                uf5 uf5Var = this.g;
                if (uf5Var != null) {
                    uf5Var.onLoadFinished();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755143703, "Lcom/repackage/yf5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755143703, "Lcom/repackage/yf5;");
        }
    }

    public yf5(tf5 tf5Var, BitmapRegionDecoder bitmapRegionDecoder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tf5Var, bitmapRegionDecoder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tf5Var;
        this.b = bitmapRegionDecoder;
        l45.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.c = new c(this, (int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        eg<sf5> p = l45.k().p(this.a.e());
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

    public dg<sf5.a, sf5> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (dg) invokeV.objValue;
    }

    public eg<sf5> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (eg) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d(true);
            dg<sf5.a, sf5> dgVar = this.c;
            if (dgVar != null) {
                dgVar.k(0);
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
