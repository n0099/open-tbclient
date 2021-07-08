package d.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class n1 extends h1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final long[] f68813d;

    /* renamed from: e  reason: collision with root package name */
    public static final long[] f68814e;

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f68815f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413436678, "Ld/b/a/n1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413436678, "Ld/b/a/n1;");
                return;
            }
        }
        f68813d = new long[]{60000, 60000, 60000, AppConfig.TIMESTAMP_AVAILABLE_DURATION, AppConfig.TIMESTAMP_AVAILABLE_DURATION, AppConfig.TIMESTAMP_AVAILABLE_DURATION, 180000, 180000};
        f68814e = new long[]{180000, 180000, 360000, 360000, 540000, 540000};
        f68815f = new long[]{10000, 10000, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(j1 j1Var) {
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
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.b.a.h1
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f68781a.j().E() + (this.f68781a.m().i() ? Constants.IM_TRACK_DURATION_MS : 43200000);
        }
        return invokeV.longValue;
    }

    @Override // d.b.a.h1
    public long[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int D = this.f68781a.j().D();
            if (D != 0) {
                if (D != 1) {
                    if (D != 2) {
                        h0.b(null);
                        return f68814e;
                    }
                    return f68813d;
                }
                return f68814e;
            }
            return f68815f;
        }
        return (long[]) invokeV.objValue;
    }

    @Override // d.b.a.h1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject c2 = this.f68781a.j().c();
            if (c2 != null) {
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("header", c2);
                jSONObject.put("_gen_time", System.currentTimeMillis());
                JSONObject e2 = n.e(o.a(this.f68781a.f(), this.f68781a.j().c(), this.f68781a.n().getRegisterUri(), true, AppLog.getIAppParam()), jSONObject);
                if (e2 != null) {
                    return this.f68781a.j().i(e2, e2.optString("device_id", ""), e2.optString("install_id", ""), e2.optString("ssid", ""));
                }
                return false;
            }
            h0.b(null);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.b.a.h1
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.baidu.mapsdkplatform.comapi.map.r.f7762a : (String) invokeV.objValue;
    }
}
