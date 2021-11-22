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

    /* renamed from: a  reason: collision with root package name */
    public final int f70238a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70239b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f70240c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f70241d;

    /* renamed from: e  reason: collision with root package name */
    public a f70242e;

    /* renamed from: f  reason: collision with root package name */
    public a f70243f;

    /* renamed from: g  reason: collision with root package name */
    public a f70244g;

    /* renamed from: h  reason: collision with root package name */
    public a f70245h;

    /* renamed from: i  reason: collision with root package name */
    public a f70246i;
    public volatile boolean j;
    public int k;

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
        this.f70240c = new Object();
        this.f70241d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f70238a = i2;
        this.f70239b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f70246i;
            if (aVar2 != null) {
                this.f70246i = aVar2.f70237d;
                aVar2.f70237d = null;
                return aVar2;
            }
            synchronized (this.f70241d) {
                aVar = this.f70244g;
                while (aVar == null) {
                    if (!this.j) {
                        this.f70241d.wait();
                        aVar = this.f70244g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f70246i = aVar.f70237d;
                this.f70245h = null;
                this.f70244g = null;
                aVar.f70237d = null;
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
            synchronized (this.f70240c) {
                if (!this.j) {
                    a aVar = this.f70242e;
                    if (aVar == null) {
                        if (this.k < this.f70238a) {
                            this.k++;
                            return new a(this.f70239b);
                        }
                        do {
                            this.f70240c.wait();
                            if (!this.j) {
                                aVar = this.f70242e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f70242e = aVar.f70237d;
                    if (aVar == this.f70243f) {
                        this.f70243f = null;
                    }
                    aVar.f70237d = null;
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
            this.j = true;
            synchronized (this.f70240c) {
                this.f70240c.notifyAll();
            }
            synchronized (this.f70241d) {
                this.f70241d.notifyAll();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f70240c) {
                a aVar2 = this.f70243f;
                if (aVar2 == null) {
                    this.f70243f = aVar;
                    this.f70242e = aVar;
                } else {
                    aVar2.f70237d = aVar;
                    this.f70243f = aVar;
                }
                this.f70240c.notify();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f70241d) {
                a aVar2 = this.f70245h;
                if (aVar2 == null) {
                    this.f70245h = aVar;
                    this.f70244g = aVar;
                    this.f70241d.notify();
                } else {
                    aVar2.f70237d = aVar;
                    this.f70245h = aVar;
                }
            }
        }
    }
}
