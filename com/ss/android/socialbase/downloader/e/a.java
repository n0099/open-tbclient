package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final int f61756b;

    /* renamed from: c  reason: collision with root package name */
    public final int f61757c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f61758d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f61759e;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f61760f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f61761g;

    /* renamed from: h  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f61762h;

    /* renamed from: i  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f61763i;

    /* renamed from: j  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f61764j;

    /* renamed from: k  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f61765k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;
    public final Runnable q;

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61758d = new Object();
        this.f61759e = new Object();
        this.q = new Runnable(this) { // from class: com.ss.android.socialbase.downloader.e.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.f.a d2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Process.setThreadPriority(10);
                    do {
                        try {
                            d2 = this.a.d();
                            d2.f61771c = this.a.a.read(d2.a);
                            this.a.c(d2);
                        } catch (Throwable th) {
                            try {
                                this.a.n = th;
                                th.printStackTrace();
                                synchronized (this.a.f61759e) {
                                    this.a.m = true;
                                    this.a.f61759e.notify();
                                    f.a(this.a.a);
                                    return;
                                }
                            } catch (Throwable th2) {
                                synchronized (this.a.f61759e) {
                                    this.a.m = true;
                                    this.a.f61759e.notify();
                                    f.a(this.a.a);
                                    throw th2;
                                }
                            }
                        }
                    } while (d2.f61771c != -1);
                    synchronized (this.a.f61759e) {
                        this.a.m = true;
                        this.a.f61759e.notify();
                    }
                    f.a(this.a.a);
                }
            }
        };
        this.a = inputStream;
        this.f61756b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f61757c = i3;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            com.ss.android.socialbase.downloader.f.a aVar = this.f61762h;
            if (aVar != null) {
                if (!this.l) {
                    this.f61762h = aVar.f61772d;
                    aVar.f61772d = null;
                    return aVar;
                }
                throw new p("");
            }
            synchronized (this.f61758d) {
                if (!this.l) {
                    com.ss.android.socialbase.downloader.f.a aVar2 = this.f61760f;
                    if (aVar2 == null && this.p < this.f61757c) {
                        this.p++;
                        return new com.ss.android.socialbase.downloader.f.a(this.f61756b);
                    }
                    while (aVar2 == null) {
                        this.f61758d.wait();
                        if (!this.l) {
                            aVar2 = this.f61760f;
                        } else {
                            throw new p("");
                        }
                    }
                    this.f61762h = aVar2.f61772d;
                    this.f61761g = null;
                    this.f61760f = null;
                    aVar2.f61772d = null;
                    return aVar2;
                }
                throw new p("");
            }
        }
        return (com.ss.android.socialbase.downloader.f.a) invokeV.objValue;
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        com.ss.android.socialbase.downloader.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f61765k;
            if (aVar2 != null) {
                this.f61765k = aVar2.f61772d;
                aVar2.f61772d = null;
                return aVar2;
            }
            synchronized (this.f61759e) {
                aVar = this.f61763i;
                if (aVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.f61759e.wait();
                        aVar = this.f61763i;
                    } while (aVar == null);
                    this.f61765k = aVar.f61772d;
                    this.f61764j = null;
                    this.f61763i = null;
                    aVar.f61772d = null;
                } else {
                    this.f61765k = aVar.f61772d;
                    this.f61764j = null;
                    this.f61763i = null;
                    aVar.f61772d = null;
                }
            }
            return aVar;
        }
        return (com.ss.android.socialbase.downloader.f.a) invokeV.objValue;
    }

    private void f() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Throwable th = this.n;
            if (th != null) {
                if (th instanceof p) {
                    throw new BaseException((int) RevenueServerConst.GetUserYbDetailsRequest, "async reader closed!");
                }
                f.a(th, "async_read");
            }
            throw new BaseException(1069, "async reader terminated!");
        }
    }

    private void c() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.o = com.ss.android.socialbase.downloader.downloader.c.q().submit(this.q);
        }
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.f61758d) {
                this.l = true;
                this.f61758d.notify();
            }
            Future future = this.o;
            if (future != null) {
                try {
                    future.cancel(true);
                } catch (Throwable unused) {
                }
                this.o = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.ss.android.socialbase.downloader.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, aVar) == null) {
            synchronized (this.f61759e) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f61764j;
                if (aVar2 == null) {
                    this.f61764j = aVar;
                    this.f61763i = aVar;
                    this.f61759e.notify();
                } else {
                    aVar2.f61772d = aVar;
                    this.f61764j = aVar;
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? e() : (com.ss.android.socialbase.downloader.f.a) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            b(aVar);
        }
    }

    private void b(com.ss.android.socialbase.downloader.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, aVar) == null) {
            synchronized (this.f61758d) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f61761g;
                if (aVar2 == null) {
                    this.f61761g = aVar;
                    this.f61760f = aVar;
                    this.f61758d.notify();
                } else {
                    aVar2.f61772d = aVar;
                    this.f61761g = aVar;
                }
            }
        }
    }
}
