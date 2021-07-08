package d.f.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f70832a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70833b;

    /* renamed from: c  reason: collision with root package name */
    public long f70834c;

    /* renamed from: d  reason: collision with root package name */
    public long f70835d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f70836a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1499130361, "Ld/f/d/a/p$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1499130361, "Ld/f/d/a/p$a;");
                    return;
                }
            }
            int[] iArr = new int[TimeUnit.values().length];
            f70836a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70836a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f70836a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f70836a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f70836a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f70836a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f70836a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70832a = t.b();
    }

    public static String a(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, timeUnit)) == null) {
            switch (a.f70836a[timeUnit.ordinal()]) {
                case 1:
                    return NotificationStyle.NOTIFICATION_STYLE;
                case 2:
                    return "μs";
                case 3:
                    return "ms";
                case 4:
                    return "s";
                case 5:
                    return "min";
                case 6:
                    return "h";
                case 7:
                    return "d";
                default:
                    throw new AssertionError();
            }
        }
        return (String) invokeL.objValue;
    }

    public static TimeUnit b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.DAYS;
            }
            if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.HOURS;
            }
            if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.MINUTES;
            }
            if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.SECONDS;
            }
            if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.MILLISECONDS;
            }
            if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
                return TimeUnit.MICROSECONDS;
            }
            return TimeUnit.NANOSECONDS;
        }
        return (TimeUnit) invokeJ.objValue;
    }

    public static p c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            p pVar = new p();
            pVar.h();
            return pVar;
        }
        return (p) invokeV.objValue;
    }

    public static p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new p() : (p) invokeV.objValue;
    }

    public long e(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, timeUnit)) == null) ? timeUnit.convert(f(), TimeUnit.NANOSECONDS) : invokeL.longValue;
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70833b ? (this.f70832a.a() - this.f70835d) + this.f70834c : this.f70834c : invokeV.longValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70833b : invokeV.booleanValue;
    }

    public p h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n.x(!this.f70833b, "This stopwatch is already running.");
            this.f70833b = true;
            this.f70835d = this.f70832a.a();
            return this;
        }
        return (p) invokeV.objValue;
    }

    public p i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long a2 = this.f70832a.a();
            n.x(this.f70833b, "This stopwatch is already stopped.");
            this.f70833b = false;
            this.f70834c += a2 - this.f70835d;
            return this;
        }
        return (p) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long f2 = f();
            TimeUnit b2 = b(f2);
            double convert = f2 / TimeUnit.NANOSECONDS.convert(1L, b2);
            return m.b(convert) + " " + a(b2);
        }
        return (String) invokeV.objValue;
    }
}
