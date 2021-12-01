package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b implements c, d, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f61773b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f61774c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f61775d;

    /* renamed from: e  reason: collision with root package name */
    public a f61776e;

    /* renamed from: f  reason: collision with root package name */
    public a f61777f;

    /* renamed from: g  reason: collision with root package name */
    public a f61778g;

    /* renamed from: h  reason: collision with root package name */
    public a f61779h;

    /* renamed from: i  reason: collision with root package name */
    public a f61780i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f61781j;

    /* renamed from: k  reason: collision with root package name */
    public int f61782k;

    public b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61774c = new Object();
        this.f61775d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.f61773b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f61780i;
            if (aVar2 != null) {
                this.f61780i = aVar2.f61772d;
                aVar2.f61772d = null;
                return aVar2;
            }
            synchronized (this.f61775d) {
                aVar = this.f61778g;
                while (aVar == null) {
                    if (!this.f61781j) {
                        this.f61775d.wait();
                        aVar = this.f61778g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f61780i = aVar.f61772d;
                this.f61779h = null;
                this.f61778g = null;
                aVar.f61772d = null;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f61774c) {
                if (!this.f61781j) {
                    a aVar = this.f61776e;
                    if (aVar == null) {
                        if (this.f61782k < this.a) {
                            this.f61782k++;
                            return new a(this.f61773b);
                        }
                        do {
                            this.f61774c.wait();
                            if (!this.f61781j) {
                                aVar = this.f61776e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f61776e = aVar.f61772d;
                    if (aVar == this.f61777f) {
                        this.f61777f = null;
                    }
                    aVar.f61772d = null;
                    return aVar;
                }
                throw new p("obtain");
            }
        }
        return (a) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f61781j = true;
            synchronized (this.f61774c) {
                this.f61774c.notifyAll();
            }
            synchronized (this.f61775d) {
                this.f61775d.notifyAll();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f61774c) {
                a aVar2 = this.f61777f;
                if (aVar2 == null) {
                    this.f61777f = aVar;
                    this.f61776e = aVar;
                } else {
                    aVar2.f61772d = aVar;
                    this.f61777f = aVar;
                }
                this.f61774c.notify();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f61775d) {
                a aVar2 = this.f61779h;
                if (aVar2 == null) {
                    this.f61779h = aVar;
                    this.f61778g = aVar;
                    this.f61775d.notify();
                } else {
                    aVar2.f61772d = aVar;
                    this.f61779h = aVar;
                }
            }
        }
    }
}
