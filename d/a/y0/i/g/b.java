package d.a.y0.i.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.y0.i.e;
import d.a.y0.l.d.d;
import d.a.y0.t.m;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f71110a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f71111b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.y0.l.d.j.c.a f71112c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71113d;

    /* renamed from: e  reason: collision with root package name */
    public int f71114e;

    /* renamed from: f  reason: collision with root package name */
    public int f71115f;

    /* renamed from: g  reason: collision with root package name */
    public String f71116g;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f71117e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f71118f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f71119g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f71120h;

        public a(b bVar, byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71120h = bVar;
            this.f71117e = bArr;
            this.f71118f = i2;
            this.f71119g = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f71120h.f71110a.c(this.f71117e, this.f71118f, this.f71119g);
                } catch (Exception e2) {
                    if (this.f71120h.f71112c == null || this.f71120h.f71113d) {
                        return;
                    }
                    this.f71120h.f71112c.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    /* renamed from: d.a.y0.i.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1971b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f71121e;

        public RunnableC1971b(b bVar) {
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
            this.f71121e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f71121e.f71110a.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (this.f71121e.f71112c == null || this.f71121e.f71113d) {
                        return;
                    }
                    this.f71121e.f71112c.onFinishedWriting(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends d.a.y0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f71122e;

        public c(b bVar) {
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
            this.f71122e = bVar;
        }

        @Override // d.a.y0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f71122e.f71112c == null || this.f71122e.f71113d) {
                return;
            }
            this.f71122e.f71112c.onFinishedWriting(z);
        }
    }

    public b(String str, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71114e = i2;
        this.f71115f = i3;
        this.f71111b = Executors.newSingleThreadExecutor();
        this.f71113d = false;
    }

    public void b() throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f71111b.isShutdown()) {
            return;
        }
        this.f71111b.submit(new RunnableC1971b(this));
        this.f71111b.shutdown();
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f71114e = i2;
            this.f71115f = i3;
            try {
                d.a.y0.l.d.j.a aVar = new d.a.y0.l.d.j.a(i2, i3);
                this.f71110a = aVar;
                aVar.b(this.f71116g);
                this.f71110a.d(new c(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                d.a.y0.l.d.j.c.a aVar2 = this.f71112c;
                if (aVar2 != null) {
                    aVar2.onExceptionThrown(m.g(e2));
                }
            }
        }
    }

    @Override // d.a.y0.i.e
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void d(d.a.y0.l.d.j.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f71112c = aVar;
        }
    }

    public void e(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f71116g = str;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f71113d = true;
            try {
                this.f71111b.shutdownNow();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.y0.i.e
    public int write(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) == null) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            if (!this.f71111b.isShutdown()) {
                this.f71111b.submit(new a(this, copyOf, i2, i3));
            }
            return i3 - i2;
        }
        return invokeLII.intValue;
    }
}
