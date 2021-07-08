package d.a.n0.a.p.e.j;

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
import d.a.n0.a.k;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46625h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f46626a;

    /* renamed from: b  reason: collision with root package name */
    public long f46627b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f46628c;

    /* renamed from: d  reason: collision with root package name */
    public long f46629d;

    /* renamed from: e  reason: collision with root package name */
    public long f46630e;

    /* renamed from: f  reason: collision with root package name */
    public long f46631f;

    /* renamed from: g  reason: collision with root package name */
    public String f46632g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1355616517, "Ld/a/n0/a/p/e/j/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1355616517, "Ld/a/n0/a/p/e/j/d;");
                return;
            }
        }
        f46625h = k.f45831a;
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
        this.f46632g = "1";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f46632g;
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
            long j = this.f46631f;
            if (j > 0) {
                return j;
            }
            long[] jArr = {this.f46629d, this.f46630e, this.f46627b};
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < 3; i2++) {
                long j3 = jArr[i2];
                if (j3 > 0 && j3 < j2) {
                    j2 = j3;
                }
            }
            if (j2 != Long.MAX_VALUE) {
                this.f46631f = j2;
            }
            return this.f46631f;
        }
        return invokeV.longValue;
    }

    public String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? j == this.f46629d ? "2" : j == this.f46630e ? "3" : (j != this.f46627b && j == this.f46628c) ? "0" : "1" : (String) invokeJ.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f46628c > 0 && this.f46628c != this.f46629d && this.f46628c != this.f46630e && this.f46628c != this.f46627b) {
                if (f46625h) {
                    Log.d("WebViewPaintTiming", "tryCalibrateFmp: miss with real fmp=" + this.f46628c);
                }
            } else if (this.f46629d > 0) {
                if (f46625h) {
                    Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with ftp=" + this.f46629d);
                }
                this.f46628c = this.f46629d;
                this.f46632g = "2";
            } else if (this.f46630e > 0) {
                if (f46625h) {
                    Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fip=" + this.f46630e);
                }
                this.f46628c = this.f46630e;
                this.f46632g = "3";
            } else if (this.f46627b > 0) {
                if (f46625h) {
                    Log.d("WebViewPaintTiming", "tryCalibrateFmp: hit with fcp=" + this.f46627b);
                }
                this.f46628c = this.f46627b;
                this.f46632g = "1";
            } else if (f46625h) {
                throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "WebViewPaintTiming{fp=" + this.f46626a + ", fcp=" + this.f46627b + ", fmp=" + this.f46628c + ", ftp=" + this.f46629d + ", fip=" + this.f46630e + ", mMinCache=" + this.f46631f + ", fmpType='" + this.f46632g + "', fmpTypeName='" + a() + "'}";
        }
        return (String) invokeV.objValue;
    }
}
