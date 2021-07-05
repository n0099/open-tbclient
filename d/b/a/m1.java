package d.b.a;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class m1 extends h1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final long[] f71701e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public long f71702d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413435717, "Ld/b/a/m1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413435717, "Ld/b/a/m1;");
                return;
            }
        }
        f71701e = new long[]{60000};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(j1 j1Var) {
        super(j1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((j1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.b.a.h1
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.b.a.h1
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71702d + 60000 : invokeV.longValue;
    }

    @Override // d.b.a.h1
    public long[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f71701e : (long[]) invokeV.objValue;
    }

    @Override // d.b.a.h1
    public boolean d() {
        InterceptResult invokeV;
        Bundle b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            p1 m = this.f71678a.m();
            if (m != null && (b2 = m.b(currentTimeMillis, 50000L)) != null) {
                AppLog.onEventV3("play_session", b2);
                AppLog.flush();
            }
            if (this.f71678a.j().D() != 0) {
                JSONObject j = this.f71678a.j().j();
                if (j != null) {
                    boolean m2 = this.f71678a.h().m(j);
                    this.f71702d = System.currentTimeMillis();
                    return m2;
                }
                h0.b(null);
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.b.a.h1
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "p" : (String) invokeV.objValue;
    }
}
