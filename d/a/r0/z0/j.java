package d.a.r0.z0;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f56953a;

    /* renamed from: b  reason: collision with root package name */
    public long f56954b;

    /* renamed from: c  reason: collision with root package name */
    public long f56955c;

    /* renamed from: d  reason: collision with root package name */
    public long f56956d;

    /* renamed from: e  reason: collision with root package name */
    public long f56957e;

    /* renamed from: f  reason: collision with root package name */
    public long f56958f;

    /* renamed from: g  reason: collision with root package name */
    public long f56959g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56960h;

    /* renamed from: i  reason: collision with root package name */
    public b f56961i;
    public Runnable j;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f56962e;

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
            this.f56962e = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f56962e.f56959g > this.f56962e.f56958f) {
                    j jVar = this.f56962e;
                    jVar.f56958f = currentTimeMillis - jVar.f56956d;
                    j jVar2 = this.f56962e;
                    jVar2.f56959g = jVar2.f56958f;
                }
                long j = currentTimeMillis - this.f56962e.f56958f;
                this.f56962e.f56955c += this.f56962e.f56956d;
                if (this.f56962e.f56955c < this.f56962e.f56954b) {
                    this.f56962e.f56953a.postDelayed(this.f56962e.j, (this.f56962e.f56956d * 2) - j);
                    if (this.f56962e.f56961i != null) {
                        this.f56962e.f56961i.a(this.f56962e.f56954b, this.f56962e.f56954b - this.f56962e.f56955c);
                    }
                } else {
                    j jVar3 = this.f56962e;
                    jVar3.f56955c = jVar3.f56954b;
                    this.f56962e.m();
                }
                this.f56962e.f56958f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f56953a = new Handler(Looper.getMainLooper());
        this.f56960h = false;
        this.j = new a(this);
        this.f56954b = j;
        this.f56956d = j2;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f56961i) == null) {
            return;
        }
        bVar.b(this.f56954b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56955c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f56960h) {
            return;
        }
        this.f56960h = true;
        this.f56959g = System.currentTimeMillis();
        this.f56953a.removeCallbacks(this.j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f56960h) {
            this.f56960h = false;
            this.f56953a.postDelayed(this.j, this.f56956d - (this.f56959g - this.f56958f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f56961i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f56957e = currentTimeMillis;
            this.f56958f = currentTimeMillis;
            b bVar = this.f56961i;
            if (bVar != null) {
                long j = this.f56954b;
                bVar.a(j, j - this.f56955c);
            }
            this.f56953a.postDelayed(this.j, this.f56956d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f56960h = false;
            long j = this.f56957e;
            this.f56958f = j;
            this.f56959g = j;
            this.f56953a.removeCallbacks(this.j);
        }
    }
}
