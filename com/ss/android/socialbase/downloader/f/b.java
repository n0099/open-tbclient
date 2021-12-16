package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements c, d, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f62354b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f62355c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f62356d;

    /* renamed from: e  reason: collision with root package name */
    public a f62357e;

    /* renamed from: f  reason: collision with root package name */
    public a f62358f;

    /* renamed from: g  reason: collision with root package name */
    public a f62359g;

    /* renamed from: h  reason: collision with root package name */
    public a f62360h;

    /* renamed from: i  reason: collision with root package name */
    public a f62361i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f62362j;

    /* renamed from: k  reason: collision with root package name */
    public int f62363k;

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
        this.f62355c = new Object();
        this.f62356d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.f62354b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f62361i;
            if (aVar2 != null) {
                this.f62361i = aVar2.f62353d;
                aVar2.f62353d = null;
                return aVar2;
            }
            synchronized (this.f62356d) {
                aVar = this.f62359g;
                while (aVar == null) {
                    if (!this.f62362j) {
                        this.f62356d.wait();
                        aVar = this.f62359g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f62361i = aVar.f62353d;
                this.f62360h = null;
                this.f62359g = null;
                aVar.f62353d = null;
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
            synchronized (this.f62355c) {
                if (!this.f62362j) {
                    a aVar = this.f62357e;
                    if (aVar == null) {
                        if (this.f62363k < this.a) {
                            this.f62363k++;
                            return new a(this.f62354b);
                        }
                        do {
                            this.f62355c.wait();
                            if (!this.f62362j) {
                                aVar = this.f62357e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f62357e = aVar.f62353d;
                    if (aVar == this.f62358f) {
                        this.f62358f = null;
                    }
                    aVar.f62353d = null;
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
            this.f62362j = true;
            synchronized (this.f62355c) {
                this.f62355c.notifyAll();
            }
            synchronized (this.f62356d) {
                this.f62356d.notifyAll();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f62355c) {
                a aVar2 = this.f62358f;
                if (aVar2 == null) {
                    this.f62358f = aVar;
                    this.f62357e = aVar;
                } else {
                    aVar2.f62353d = aVar;
                    this.f62358f = aVar;
                }
                this.f62355c.notify();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f62356d) {
                a aVar2 = this.f62360h;
                if (aVar2 == null) {
                    this.f62360h = aVar;
                    this.f62359g = aVar;
                    this.f62356d.notify();
                } else {
                    aVar2.f62353d = aVar;
                    this.f62360h = aVar;
                }
            }
        }
    }
}
