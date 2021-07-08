package d.a.z.a.i;

import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f68648a;

    /* renamed from: b  reason: collision with root package name */
    public long f68649b;

    /* renamed from: c  reason: collision with root package name */
    public long f68650c;

    /* renamed from: d  reason: collision with root package name */
    public long f68651d;

    /* renamed from: e  reason: collision with root package name */
    public long f68652e;

    /* renamed from: f  reason: collision with root package name */
    public long f68653f;

    /* renamed from: g  reason: collision with root package name */
    public long f68654g;

    /* renamed from: h  reason: collision with root package name */
    public long f68655h;

    /* renamed from: i  reason: collision with root package name */
    public long f68656i;
    public long j;
    public String k;
    public String l;
    public boolean m;
    public StringBuilder n;

    public c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68653f = 1000L;
        this.m = false;
        this.n = new StringBuilder();
        this.k = str;
        this.l = str2;
        e();
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            Log.d(str, str2);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f68655h;
            this.f68656i = currentTimeMillis;
            this.j = this.f68654g;
            this.f68655h = 0L;
            this.f68654g = 0L;
            if (this.m) {
                a(this.k, String.format("%s, PeriodTime: %d, Times: %d", this.l, Long.valueOf(currentTimeMillis), Long.valueOf(this.j)));
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String format = String.format("%s, Total: %d, Times: %d, Min: %d, Max: %d, Average：%f", this.l, Long.valueOf(this.f68651d), Long.valueOf(this.f68652e), Long.valueOf(this.f68650c), Long.valueOf(this.f68649b), Float.valueOf(((float) this.f68651d) / ((float) this.f68652e)));
            if (this.m) {
                a(this.k, format);
            }
            return format;
        }
        return (String) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f68648a == 0) {
                this.f68648a = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f68648a;
            this.f68651d += currentTimeMillis;
            this.f68652e++;
            if (currentTimeMillis > this.f68649b) {
                this.f68649b = currentTimeMillis;
            } else if (currentTimeMillis < this.f68650c) {
                this.f68650c = currentTimeMillis;
            }
            if (this.m) {
                if (this.n.length() > 0) {
                    StringBuilder sb = this.n;
                    sb.delete(0, sb.length());
                }
                this.n.append(this.l);
                for (int i2 = (int) ((currentTimeMillis - 33) / 5); i2 > 0; i2--) {
                    this.n.append(IStringUtil.EXTENSION_SEPARATOR);
                }
                this.n.append(currentTimeMillis);
                a(this.k, this.n.toString());
            }
            this.f68654g++;
            if (this.f68653f > 0 && System.currentTimeMillis() - this.f68655h > this.f68653f) {
                b();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f68648a = currentTimeMillis2;
            if (this.f68655h == 0) {
                this.f68655h = currentTimeMillis2;
                this.f68654g = 0L;
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f68648a = 0L;
            this.f68651d = 0L;
            this.f68652e = 0L;
            this.f68649b = Long.MIN_VALUE;
            this.f68650c = Long.MAX_VALUE;
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f68653f = j;
        }
    }
}
