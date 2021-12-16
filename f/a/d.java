package f.a;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TimeUnit a;

    /* renamed from: b  reason: collision with root package name */
    public long f64024b;

    /* renamed from: c  reason: collision with root package name */
    public long f64025c;

    public d(TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timeUnit};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64024b = SystemClock.elapsedRealtime();
        this.a = timeUnit;
        this.f64025c = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:9:0x001d, B:11:0x0023, B:24:0x004b, B:25:0x0050, B:12:0x0025, B:14:0x002d, B:15:0x0030, B:17:0x0038, B:18:0x003a, B:19:0x003c, B:21:0x0042, B:27:0x0062), top: B:36:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:9:0x001d, B:11:0x0023, B:24:0x004b, B:25:0x0050, B:12:0x0025, B:14:0x002d, B:15:0x0030, B:17:0x0038, B:18:0x003a, B:19:0x003c, B:21:0x0042, B:27:0x0062), top: B:36:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        InterceptResult invokeV;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (String) invokeV.objValue;
        }
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f64024b) + this.f64025c;
        try {
            if (elapsedRealtime >= 0 && elapsedRealtime <= 86400000) {
                if (this.a != TimeUnit.MILLISECONDS) {
                    if (this.a == TimeUnit.SECONDS) {
                        f3 = ((float) elapsedRealtime) / 1000.0f;
                    } else {
                        if (this.a == TimeUnit.MINUTES) {
                            f2 = ((float) elapsedRealtime) / 1000.0f;
                        } else if (this.a == TimeUnit.HOURS) {
                            f2 = (((float) elapsedRealtime) / 1000.0f) / 60.0f;
                        }
                        f3 = f2 / 60.0f;
                    }
                    return f3 >= 0.0f ? String.valueOf(0) : String.format(Locale.CHINA, "%.3f", Float.valueOf(f3));
                }
                f3 = (float) elapsedRealtime;
                if (f3 >= 0.0f) {
                }
            } else {
                return String.valueOf(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return String.valueOf(0);
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64025c : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64024b : invokeV.longValue;
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f64025c = j2;
        }
    }

    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.f64024b = j2;
        }
    }
}
