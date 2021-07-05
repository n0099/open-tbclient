package d.a.s0.i3.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f62036a;

    /* renamed from: b  reason: collision with root package name */
    public int f62037b;

    /* renamed from: c  reason: collision with root package name */
    public long f62038c;

    /* renamed from: d  reason: collision with root package name */
    public int f62039d;

    /* renamed from: e  reason: collision with root package name */
    public String f62040e;

    /* renamed from: f  reason: collision with root package name */
    public String f62041f;

    public b() {
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
        this.f62038c = 3000L;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f62039d;
            return i2 == 2 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62039d == 1 : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f62039d;
            return i2 == 3 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f62036a = jSONObject.optInt("id", 0);
        jSONObject.optLong("update_time", 0L);
        jSONObject.optLong("start_time", 0L);
        jSONObject.optLong(ResultTB.ENDTIME, 0L);
        this.f62039d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
        this.f62037b = jSONObject.optInt("show_status", 0);
        this.f62040e = jSONObject.optString("resource_url");
        this.f62041f = jSONObject.optString("link_url");
    }
}
