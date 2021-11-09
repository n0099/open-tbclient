package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f69294a;

    /* renamed from: b  reason: collision with root package name */
    public final int f69295b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69296c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f69297d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f69298e;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f69299f;

    /* renamed from: g  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f69300g;

    /* renamed from: h  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f69301h;

    /* renamed from: i  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.f.a f69302i;
    public com.ss.android.socialbase.downloader.f.a j;
    public com.ss.android.socialbase.downloader.f.a k;
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
        this.f69297d = new Object();
        this.f69298e = new Object();
        this.q = new Runnable(this) { // from class: com.ss.android.socialbase.downloader.e.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f69303a;

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
                this.f69303a = this;
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
                            d2 = this.f69303a.d();
                            d2.f69316c = this.f69303a.f69294a.read(d2.f69314a);
                            this.f69303a.c(d2);
                        } catch (Throwable th) {
                            try {
                                this.f69303a.n = th;
                                th.printStackTrace();
                                synchronized (this.f69303a.f69298e) {
                                    this.f69303a.m = true;
                                    this.f69303a.f69298e.notify();
                                    f.a(this.f69303a.f69294a);
                                    return;
                                }
                            } catch (Throwable th2) {
                                synchronized (this.f69303a.f69298e) {
                                    this.f69303a.m = true;
                                    this.f69303a.f69298e.notify();
                                    f.a(this.f69303a.f69294a);
                                    throw th2;
                                }
                            }
                        }
                    } while (d2.f69316c != -1);
                    synchronized (this.f69303a.f69298e) {
                        this.f69303a.m = true;
                        this.f69303a.f69298e.notify();
                    }
                    f.a(this.f69303a.f69294a);
                }
            }
        };
        this.f69294a = inputStream;
        this.f69295b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f69296c = i3;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            com.ss.android.socialbase.downloader.f.a aVar = this.f69301h;
            if (aVar != null) {
                if (!this.l) {
                    this.f69301h = aVar.f69317d;
                    aVar.f69317d = null;
                    return aVar;
                }
                throw new p("");
            }
            synchronized (this.f69297d) {
                if (!this.l) {
                    com.ss.android.socialbase.downloader.f.a aVar2 = this.f69299f;
                    if (aVar2 == null && this.p < this.f69296c) {
                        this.p++;
                        return new com.ss.android.socialbase.downloader.f.a(this.f69295b);
                    }
                    while (aVar2 == null) {
                        this.f69297d.wait();
                        if (!this.l) {
                            aVar2 = this.f69299f;
                        } else {
                            throw new p("");
                        }
                    }
                    this.f69301h = aVar2.f69317d;
                    this.f69300g = null;
                    this.f69299f = null;
                    aVar2.f69317d = null;
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
            com.ss.android.socialbase.downloader.f.a aVar2 = this.k;
            if (aVar2 != null) {
                this.k = aVar2.f69317d;
                aVar2.f69317d = null;
                return aVar2;
            }
            synchronized (this.f69298e) {
                aVar = this.f69302i;
                if (aVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.f69298e.wait();
                        aVar = this.f69302i;
                    } while (aVar == null);
                    this.k = aVar.f69317d;
                    this.j = null;
                    this.f69302i = null;
                    aVar.f69317d = null;
                } else {
                    this.k = aVar.f69317d;
                    this.j = null;
                    this.f69302i = null;
                    aVar.f69317d = null;
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
            synchronized (this.f69297d) {
                this.l = true;
                this.f69297d.notify();
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
            synchronized (this.f69298e) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.j;
                if (aVar2 == null) {
                    this.j = aVar;
                    this.f69302i = aVar;
                    this.f69298e.notify();
                } else {
                    aVar2.f69317d = aVar;
                    this.j = aVar;
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
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aVar) == null) {
            synchronized (this.f69297d) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f69300g;
                if (aVar2 == null) {
                    this.f69300g = aVar;
                    this.f69299f = aVar;
                    this.f69297d.notify();
                } else {
                    aVar2.f69317d = aVar;
                    this.f69300g = aVar;
                }
            }
        }
    }
}
