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
    public final int f69318a;

    /* renamed from: b  reason: collision with root package name */
    public final int f69319b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f69320c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f69321d;

    /* renamed from: e  reason: collision with root package name */
    public a f69322e;

    /* renamed from: f  reason: collision with root package name */
    public a f69323f;

    /* renamed from: g  reason: collision with root package name */
    public a f69324g;

    /* renamed from: h  reason: collision with root package name */
    public a f69325h;

    /* renamed from: i  reason: collision with root package name */
    public a f69326i;
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
        this.f69320c = new Object();
        this.f69321d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f69318a = i2;
        this.f69319b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f69326i;
            if (aVar2 != null) {
                this.f69326i = aVar2.f69317d;
                aVar2.f69317d = null;
                return aVar2;
            }
            synchronized (this.f69321d) {
                aVar = this.f69324g;
                while (aVar == null) {
                    if (!this.j) {
                        this.f69321d.wait();
                        aVar = this.f69324g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f69326i = aVar.f69317d;
                this.f69325h = null;
                this.f69324g = null;
                aVar.f69317d = null;
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
            synchronized (this.f69320c) {
                if (!this.j) {
                    a aVar = this.f69322e;
                    if (aVar == null) {
                        if (this.k < this.f69318a) {
                            this.k++;
                            return new a(this.f69319b);
                        }
                        do {
                            this.f69320c.wait();
                            if (!this.j) {
                                aVar = this.f69322e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f69322e = aVar.f69317d;
                    if (aVar == this.f69323f) {
                        this.f69323f = null;
                    }
                    aVar.f69317d = null;
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
            synchronized (this.f69320c) {
                this.f69320c.notifyAll();
            }
            synchronized (this.f69321d) {
                this.f69321d.notifyAll();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f69320c) {
                a aVar2 = this.f69323f;
                if (aVar2 == null) {
                    this.f69323f = aVar;
                    this.f69322e = aVar;
                } else {
                    aVar2.f69317d = aVar;
                    this.f69323f = aVar;
                }
                this.f69320c.notify();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f69321d) {
                a aVar2 = this.f69325h;
                if (aVar2 == null) {
                    this.f69325h = aVar;
                    this.f69324g = aVar;
                    this.f69321d.notify();
                } else {
                    aVar2.f69317d = aVar;
                    this.f69325h = aVar;
                }
            }
        }
    }
}
