package d.e.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class g implements Printer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f72056a;

    /* renamed from: b  reason: collision with root package name */
    public long f72057b;

    /* renamed from: c  reason: collision with root package name */
    public long f72058c;

    /* renamed from: d  reason: collision with root package name */
    public b f72059d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f72060e;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f72061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f72062f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f72063g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f72064h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f72065i;

        public a(g gVar, long j, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72065i = gVar;
            this.f72061e = j;
            this.f72062f = j2;
            this.f72063g = j3;
            this.f72064h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72065i.f72059d.a(this.f72061e, this.f72062f, this.f72063g, this.f72064h);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72056a = 3000L;
        this.f72057b = 0L;
        this.f72058c = 0L;
        this.f72059d = null;
        if (bVar != null) {
            this.f72059d = bVar;
            this.f72056a = j;
            this.f72060e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? j - this.f72057b > this.f72056a : invokeJ.booleanValue;
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            e.b().post(new a(this, this.f72057b, j, this.f72058c, SystemClock.currentThreadTimeMillis()));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.f().f72045b != null) {
                c.f().f72045b.c();
            }
            if (c.f().f72046c != null) {
                c.f().f72046c.c();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.f().f72045b != null) {
                c.f().f72045b.d();
            }
            if (c.f().f72046c != null) {
                c.f().f72046c.d();
            }
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f72060e && Debug.isDebuggerConnected()) {
                return;
            }
            if (str.charAt(0) == '>') {
                this.f72057b = System.currentTimeMillis();
                this.f72058c = SystemClock.currentThreadTimeMillis();
                d();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (b(currentTimeMillis)) {
                c(currentTimeMillis);
            }
            e();
        }
    }
}
