package d.l.a.e.b.i;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes8.dex */
public class b implements c, d, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f72269a;

    /* renamed from: b  reason: collision with root package name */
    public final int f72270b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f72271c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f72272d;

    /* renamed from: e  reason: collision with root package name */
    public a f72273e;

    /* renamed from: f  reason: collision with root package name */
    public a f72274f;

    /* renamed from: g  reason: collision with root package name */
    public a f72275g;

    /* renamed from: h  reason: collision with root package name */
    public a f72276h;

    /* renamed from: i  reason: collision with root package name */
    public a f72277i;
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
        this.f72271c = new Object();
        this.f72272d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f72269a = i2;
        this.f72270b = i3;
    }

    @Override // d.l.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f72277i;
            if (aVar2 != null) {
                this.f72277i = aVar2.f72268d;
                aVar2.f72268d = null;
                return aVar2;
            }
            synchronized (this.f72272d) {
                aVar = this.f72275g;
                while (aVar == null) {
                    if (!this.j) {
                        this.f72272d.wait();
                        aVar = this.f72275g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f72277i = aVar.f72268d;
                this.f72276h = null;
                this.f72275g = null;
                aVar.f72268d = null;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    @Override // d.l.a.e.b.i.c
    @NonNull
    public a b() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.f72271c) {
                if (!this.j) {
                    a aVar = this.f72273e;
                    if (aVar == null) {
                        if (this.k < this.f72269a) {
                            this.k++;
                            return new a(this.f72270b);
                        }
                        do {
                            this.f72271c.wait();
                            if (!this.j) {
                                aVar = this.f72273e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f72273e = aVar.f72268d;
                    if (aVar == this.f72274f) {
                        this.f72274f = null;
                    }
                    aVar.f72268d = null;
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
            synchronized (this.f72271c) {
                this.f72271c.notifyAll();
            }
            synchronized (this.f72272d) {
                this.f72272d.notifyAll();
            }
        }
    }

    @Override // d.l.a.e.b.i.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f72271c) {
                a aVar2 = this.f72274f;
                if (aVar2 == null) {
                    this.f72274f = aVar;
                    this.f72273e = aVar;
                } else {
                    aVar2.f72268d = aVar;
                    this.f72274f = aVar;
                }
                this.f72271c.notify();
            }
        }
    }

    @Override // d.l.a.e.b.i.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f72272d) {
                a aVar2 = this.f72276h;
                if (aVar2 == null) {
                    this.f72276h = aVar;
                    this.f72275g = aVar;
                    this.f72272d.notify();
                } else {
                    aVar2.f72268d = aVar;
                    this.f72276h = aVar;
                }
            }
        }
    }
}
