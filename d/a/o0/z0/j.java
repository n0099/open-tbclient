package d.a.o0.z0;

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
    public Handler f53674a;

    /* renamed from: b  reason: collision with root package name */
    public long f53675b;

    /* renamed from: c  reason: collision with root package name */
    public long f53676c;

    /* renamed from: d  reason: collision with root package name */
    public long f53677d;

    /* renamed from: e  reason: collision with root package name */
    public long f53678e;

    /* renamed from: f  reason: collision with root package name */
    public long f53679f;

    /* renamed from: g  reason: collision with root package name */
    public long f53680g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53681h;

    /* renamed from: i  reason: collision with root package name */
    public b f53682i;
    public Runnable j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f53683e;

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
            this.f53683e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f53683e.f53680g > this.f53683e.f53679f) {
                    j jVar = this.f53683e;
                    jVar.f53679f = currentTimeMillis - jVar.f53677d;
                    j jVar2 = this.f53683e;
                    jVar2.f53680g = jVar2.f53679f;
                }
                long j = currentTimeMillis - this.f53683e.f53679f;
                this.f53683e.f53676c += this.f53683e.f53677d;
                if (this.f53683e.f53676c < this.f53683e.f53675b) {
                    this.f53683e.f53674a.postDelayed(this.f53683e.j, (this.f53683e.f53677d * 2) - j);
                    if (this.f53683e.f53682i != null) {
                        this.f53683e.f53682i.a(this.f53683e.f53675b, this.f53683e.f53675b - this.f53683e.f53676c);
                    }
                } else {
                    j jVar3 = this.f53683e;
                    jVar3.f53676c = jVar3.f53675b;
                    this.f53683e.m();
                }
                this.f53683e.f53679f = currentTimeMillis;
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
        this.f53674a = new Handler(Looper.getMainLooper());
        this.f53681h = false;
        this.j = new a(this);
        this.f53675b = j;
        this.f53677d = j2;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f53682i) == null) {
            return;
        }
        bVar.b(this.f53675b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53676c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f53681h) {
            return;
        }
        this.f53681h = true;
        this.f53680g = System.currentTimeMillis();
        this.f53674a.removeCallbacks(this.j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f53681h) {
            this.f53681h = false;
            this.f53674a.postDelayed(this.j, this.f53677d - (this.f53680g - this.f53679f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f53682i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f53678e = currentTimeMillis;
            this.f53679f = currentTimeMillis;
            b bVar = this.f53682i;
            if (bVar != null) {
                long j = this.f53675b;
                bVar.a(j, j - this.f53676c);
            }
            this.f53674a.postDelayed(this.j, this.f53677d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f53681h = false;
            long j = this.f53678e;
            this.f53679f = j;
            this.f53680g = j;
            this.f53674a.removeCallbacks(this.j);
        }
    }
}
