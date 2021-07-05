package d.a.q0.a.p.e.j;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49927h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f49928a;

    /* renamed from: b  reason: collision with root package name */
    public long f49929b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f49930c;

    /* renamed from: d  reason: collision with root package name */
    public long f49931d;

    /* renamed from: e  reason: collision with root package name */
    public long f49932e;

    /* renamed from: f  reason: collision with root package name */
    public long f49933f;

    /* renamed from: g  reason: collision with root package name */
    public String f49934g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2059141758, "Ld/a/q0/a/p/e/j/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2059141758, "Ld/a/q0/a/p/e/j/d;");
                return;
            }
        }
        f49927h = k.f49133a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49934g = "1";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f49934g;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? "unknown" : "fip" : "ftp" : "fcp" : "fmp";
        }
        return (String) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.f49933f;
            if (j > 0) {
                return j;
            }
            long[] jArr = {this.f49931d, this.f49932e, this.f49929b};
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < 3; i2++) {
                long j3 = jArr[i2];
                if (j3 > 0 && j3 < j2) {
                    j2 = j3;
                }
            }
            if (j2 != Long.MAX_VALUE) {
                this.f49933f = j2;
            }
            return this.f49933f;
        }
        return invokeV.longValue;
    }

    public String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? j == this.f49931d ? "2" : j == this.f49932e ? "3" : (j != this.f49929b && j == this.f49930c) ? "0" : "1" : (String) invokeJ.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f49930c > 0 && this.f49930c != this.f49931d && this.f49930c != this.f49932e && this.f49930c != this.f49929b) {
                if (f49927h) {
                    Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f49930c);
                }
            } else if (this.f49931d > 0) {
                if (f49927h) {
                    Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f49931d);
                }
                this.f49930c = this.f49931d;
                this.f49934g = "2";
            } else if (this.f49932e > 0) {
                if (f49927h) {
                    Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f49932e);
                }
                this.f49930c = this.f49932e;
                this.f49934g = "3";
            } else if (this.f49929b > 0) {
                if (f49927h) {
                    Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f49929b);
                }
                this.f49930c = this.f49929b;
                this.f49934g = "1";
            } else if (f49927h) {
                throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "WebViewPaintTiming{fp=" + this.f49928a + ", fcp=" + this.f49929b + ", fmp=" + this.f49930c + ", ftp=" + this.f49931d + ", fip=" + this.f49932e + ", mMinCache=" + this.f49933f + ", fmpType='" + this.f49934g + "', fmpTypeName='" + a() + "'}";
        }
        return (String) invokeV.objValue;
    }
}
