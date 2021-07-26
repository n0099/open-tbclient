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
/* loaded from: classes8.dex */
public class g implements Printer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69613a;

    /* renamed from: b  reason: collision with root package name */
    public long f69614b;

    /* renamed from: c  reason: collision with root package name */
    public long f69615c;

    /* renamed from: d  reason: collision with root package name */
    public b f69616d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f69617e;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f69618e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f69619f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f69620g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f69621h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f69622i;

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
            this.f69622i = gVar;
            this.f69618e = j;
            this.f69619f = j2;
            this.f69620g = j3;
            this.f69621h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f69622i.f69616d.a(this.f69618e, this.f69619f, this.f69620g, this.f69621h);
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f69613a = 3000L;
        this.f69614b = 0L;
        this.f69615c = 0L;
        this.f69616d = null;
        if (bVar != null) {
            this.f69616d = bVar;
            this.f69613a = j;
            this.f69617e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? j - this.f69614b > this.f69613a : invokeJ.booleanValue;
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            e.b().post(new a(this, this.f69614b, j, this.f69615c, SystemClock.currentThreadTimeMillis()));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (c.f().f69602b != null) {
                c.f().f69602b.c();
            }
            if (c.f().f69603c != null) {
                c.f().f69603c.c();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c.f().f69602b != null) {
                c.f().f69602b.d();
            }
            if (c.f().f69603c != null) {
                c.f().f69603c.d();
            }
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (this.f69617e && Debug.isDebuggerConnected()) {
                return;
            }
            if (str.charAt(0) == '>') {
                this.f69614b = System.currentTimeMillis();
                this.f69615c = SystemClock.currentThreadTimeMillis();
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
