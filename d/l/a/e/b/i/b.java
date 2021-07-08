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
    public final int f71815a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71816b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f71817c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f71818d;

    /* renamed from: e  reason: collision with root package name */
    public a f71819e;

    /* renamed from: f  reason: collision with root package name */
    public a f71820f;

    /* renamed from: g  reason: collision with root package name */
    public a f71821g;

    /* renamed from: h  reason: collision with root package name */
    public a f71822h;

    /* renamed from: i  reason: collision with root package name */
    public a f71823i;
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
        this.f71817c = new Object();
        this.f71818d = new Object();
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.f71815a = i2;
        this.f71816b = i3;
    }

    @Override // d.l.a.e.b.i.d
    @NonNull
    public a a() throws p, InterruptedException {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar2 = this.f71823i;
            if (aVar2 != null) {
                this.f71823i = aVar2.f71814d;
                aVar2.f71814d = null;
                return aVar2;
            }
            synchronized (this.f71818d) {
                aVar = this.f71821g;
                while (aVar == null) {
                    if (!this.j) {
                        this.f71818d.wait();
                        aVar = this.f71821g;
                    } else {
                        throw new p("read");
                    }
                }
                this.f71823i = aVar.f71814d;
                this.f71822h = null;
                this.f71821g = null;
                aVar.f71814d = null;
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
            synchronized (this.f71817c) {
                if (!this.j) {
                    a aVar = this.f71819e;
                    if (aVar == null) {
                        if (this.k < this.f71815a) {
                            this.k++;
                            return new a(this.f71816b);
                        }
                        do {
                            this.f71817c.wait();
                            if (!this.j) {
                                aVar = this.f71819e;
                            } else {
                                throw new p("obtain");
                            }
                        } while (aVar == null);
                    }
                    this.f71819e = aVar.f71814d;
                    if (aVar == this.f71820f) {
                        this.f71820f = null;
                    }
                    aVar.f71814d = null;
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
            synchronized (this.f71817c) {
                this.f71817c.notifyAll();
            }
            synchronized (this.f71818d) {
                this.f71818d.notifyAll();
            }
        }
    }

    @Override // d.l.a.e.b.i.c
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this.f71817c) {
                a aVar2 = this.f71820f;
                if (aVar2 == null) {
                    this.f71820f = aVar;
                    this.f71819e = aVar;
                } else {
                    aVar2.f71814d = aVar;
                    this.f71820f = aVar;
                }
                this.f71817c.notify();
            }
        }
    }

    @Override // d.l.a.e.b.i.e
    public void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f71818d) {
                a aVar2 = this.f71822h;
                if (aVar2 == null) {
                    this.f71822h = aVar;
                    this.f71821g = aVar;
                    this.f71818d.notify();
                } else {
                    aVar2.f71814d = aVar;
                    this.f71822h = aVar;
                }
            }
        }
    }
}
