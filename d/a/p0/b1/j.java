package d.a.p0.b1;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f52085a;

    /* renamed from: b  reason: collision with root package name */
    public long f52086b;

    /* renamed from: c  reason: collision with root package name */
    public long f52087c;

    /* renamed from: d  reason: collision with root package name */
    public long f52088d;

    /* renamed from: e  reason: collision with root package name */
    public long f52089e;

    /* renamed from: f  reason: collision with root package name */
    public long f52090f;

    /* renamed from: g  reason: collision with root package name */
    public long f52091g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52092h;

    /* renamed from: i  reason: collision with root package name */
    public b f52093i;
    public Runnable j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f52094e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52094e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f52094e.f52091g > this.f52094e.f52090f) {
                    j jVar = this.f52094e;
                    jVar.f52090f = currentTimeMillis - jVar.f52088d;
                    j jVar2 = this.f52094e;
                    jVar2.f52091g = jVar2.f52090f;
                }
                long j = currentTimeMillis - this.f52094e.f52090f;
                this.f52094e.f52087c += this.f52094e.f52088d;
                if (this.f52094e.f52087c < this.f52094e.f52086b) {
                    this.f52094e.f52085a.postDelayed(this.f52094e.j, (this.f52094e.f52088d * 2) - j);
                    if (this.f52094e.f52093i != null) {
                        this.f52094e.f52093i.a(this.f52094e.f52086b, this.f52094e.f52086b - this.f52094e.f52087c);
                    }
                } else {
                    j jVar3 = this.f52094e;
                    jVar3.f52087c = jVar3.f52086b;
                    this.f52094e.m();
                }
                this.f52094e.f52090f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(long j, long j2);

        void b(long j);
    }

    public j(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52085a = new Handler(Looper.getMainLooper());
        this.f52092h = false;
        this.j = new a(this);
        this.f52086b = j;
        this.f52088d = j2;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f52093i) == null) {
            return;
        }
        bVar.b(this.f52086b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52087c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f52092h) {
            return;
        }
        this.f52092h = true;
        this.f52091g = System.currentTimeMillis();
        this.f52085a.removeCallbacks(this.j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f52092h) {
            this.f52092h = false;
            this.f52085a.postDelayed(this.j, this.f52088d - (this.f52091g - this.f52090f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f52093i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f52089e = currentTimeMillis;
            this.f52090f = currentTimeMillis;
            b bVar = this.f52093i;
            if (bVar != null) {
                long j = this.f52086b;
                bVar.a(j, j - this.f52087c);
            }
            this.f52085a.postDelayed(this.j, this.f52088d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f52092h = false;
            long j = this.f52089e;
            this.f52090f = j;
            this.f52091g = j;
            this.f52085a.removeCallbacks(this.j);
        }
    }
}
