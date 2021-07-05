package d.a.s0.h3.o0.d.f;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class b extends d.a.s0.h3.o0.d.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public volatile d f61406g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f61407h;

    /* renamed from: i  reason: collision with root package name */
    public int f61408i;

    /* loaded from: classes9.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f61409e;

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
            this.f61409e = 0;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                Thread thread = new Thread(runnable);
                thread.setName("VideoUploadThread@" + this.f61409e);
                this.f61409e = this.f61409e + 1;
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* renamed from: d.a.s0.h3.o0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1496b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RandomAccessFile f61410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f61411f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f61412g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f61413h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f61414i;
        public final /* synthetic */ int j;
        public final /* synthetic */ CountDownLatch k;
        public final /* synthetic */ b l;

        public RunnableC1496b(b bVar, RandomAccessFile randomAccessFile, ArrayList arrayList, int i2, int i3, String str, int i4, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, randomAccessFile, arrayList, Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar;
            this.f61410e = randomAccessFile;
            this.f61411f = arrayList;
            this.f61412g = i2;
            this.f61413h = i3;
            this.f61414i = str;
            this.j = i4;
            this.k = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d h2 = this.l.h(this.f61410e, ((Integer) this.f61411f.get(this.f61412g)).intValue(), this.f61413h, this.f61414i);
                if (h2 != null) {
                    if (h2.f61417b != 0) {
                        this.l.f61406g.f61417b = h2.f61417b;
                        this.l.f61406g.f61418c = h2.f61418c;
                    }
                    if (!StringUtils.isNull(h2.f61416a)) {
                        this.l.f61406g.f61416a = h2.f61416a;
                    }
                    synchronized (this.l) {
                        b.k(this.l);
                        this.l.d((int) (((this.l.f61408i * 50.0f) / this.j) + 30.0f));
                    }
                }
                this.k.countDown();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, int i2, int i3, long j, String str2) {
        super(str, i2, i3, j, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61406g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i2 = bVar.f61408i;
        bVar.f61408i = i2 + 1;
        return i2;
    }

    @Override // d.a.s0.h3.o0.d.f.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61407h = true;
        }
    }

    @Override // d.a.s0.h3.o0.d.f.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (!this.f61407h && this.f61406g.f61417b == 0 && StringUtils.isNull(this.f61406g.f61416a)) ? false : true : invokeV.booleanValue;
    }

    @Override // d.a.s0.h3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, str, i2)) == null) {
            int size = arrayList.size();
            CountDownLatch countDownLatch = new CountDownLatch(size);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f61401b), r.f7745a);
                for (int i3 = 0; i3 < size; i3++) {
                    threadPoolExecutor.execute(new RunnableC1496b(this, randomAccessFile, arrayList, i3, i2, str, size, countDownLatch));
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                threadPoolExecutor.shutdown();
                try {
                    randomAccessFile.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return this.f61406g;
            } catch (FileNotFoundException unused) {
                return this.f61406g;
            }
        }
        return (d) invokeLLI.objValue;
    }
}
