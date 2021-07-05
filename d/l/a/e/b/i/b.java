package d.l.a.e.b.i;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.f.p;
/* loaded from: classes10.dex */
public class b implements c, d, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f74763a;

    /* renamed from: b  reason: collision with root package name */
    public final int f74764b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f74765c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f74766d;

    /* renamed from: e  reason: collision with root package name */
    public a f74767e;

    /* renamed from: f  reason: collision with root package name */
    public a f74768f;

    /* renamed from: g  reason: collision with root package name */
    public a f74769g;

    /* renamed from: h  reason: collision with root package name */
    public a f74770h;

    /* renamed from: i  reason: collision with root package name */
    public a f74771i;
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
        this.f74765c = new Object();
        this.f74766d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f74763a = i2;
        this.f74764b = i3;
    }

    @Override // d.l.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f74771i;
            if (aVar2 != null) {
                this.f74771i = aVar2.f74762d;
                aVar2.f74762d = null;
                return aVar2;
            }
            synchronized (this.f74766d) {
                aVar = this.f74769g;
                while (aVar == null) {
                    if (!this.j) {
                        this.f74766d.wait();
                        aVar = this.f74769g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f74771i = aVar.f74762d;
                this.f74770h = null;
                this.f74769g = null;
                aVar.f74762d = null;
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
            synchronized (this.f74765c) {
                if (!this.j) {
                    a aVar = this.f74767e;
                    if (aVar == null) {
                        if (this.k < this.f74763a) {
                            this.k++;
                            return new a(this.f74764b);
                        }
                        do {
                            this.f74765c.wait();
                            if (!this.j) {
                                aVar = this.f74767e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f74767e = aVar.f74762d;
                    if (aVar == this.f74768f) {
                        this.f74768f = null;
                    }
                    aVar.f74762d = null;
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
            synchronized (this.f74765c) {
                this.f74765c.notifyAll();
            }
            synchronized (this.f74766d) {
                this.f74766d.notifyAll();
            }
        }
    }

    @Override // d.l.a.e.b.i.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f74765c) {
                a aVar2 = this.f74768f;
                if (aVar2 == null) {
                    this.f74768f = aVar;
                    this.f74767e = aVar;
                } else {
                    aVar2.f74762d = aVar;
                    this.f74768f = aVar;
                }
                this.f74765c.notify();
            }
        }
    }

    @Override // d.l.a.e.b.i.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f74766d) {
                a aVar2 = this.f74770h;
                if (aVar2 == null) {
                    this.f74770h = aVar;
                    this.f74769g = aVar;
                    this.f74766d.notify();
                } else {
                    aVar2.f74762d = aVar;
                    this.f74770h = aVar;
                }
            }
        }
    }
}
