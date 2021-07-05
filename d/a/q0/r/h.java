package d.a.q0.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f54319a;

    /* renamed from: b  reason: collision with root package name */
    public final int f54320b;

    /* renamed from: c  reason: collision with root package name */
    public final int f54321c;

    /* renamed from: d  reason: collision with root package name */
    public long f54322d;

    /* renamed from: e  reason: collision with root package name */
    public int f54323e;

    public h(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54319a = str;
        this.f54320b = i2;
        this.f54321c = i3;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54319a : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f54320b != 0 && this.f54321c != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.f54322d;
                if (j != 0 && (currentTimeMillis - j) / 1000 <= this.f54320b && this.f54323e >= this.f54321c) {
                    return true;
                }
                long j2 = this.f54322d;
                if (j2 == 0) {
                    this.f54322d = currentTimeMillis;
                } else if ((currentTimeMillis - j2) / 1000 > this.f54320b) {
                    this.f54322d = currentTimeMillis;
                    this.f54323e = 0;
                }
                this.f54323e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f54323e;
            return i2 != 0 && i2 == this.f54321c;
        }
        return invokeV.booleanValue;
    }
}
