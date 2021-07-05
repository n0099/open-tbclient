package d.a.q0.a.t1.c.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50680a;

    /* renamed from: b  reason: collision with root package name */
    public String f50681b;

    /* renamed from: c  reason: collision with root package name */
    public String f50682c;

    /* renamed from: d  reason: collision with root package name */
    public String f50683d;

    /* renamed from: e  reason: collision with root package name */
    public String f50684e;

    /* renamed from: f  reason: collision with root package name */
    public String f50685f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f50686g;

    /* renamed from: h  reason: collision with root package name */
    public String f50687h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.a.u.h.b f50688i;

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
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f50680a) || TextUtils.isEmpty(this.f50682c) || TextUtils.isEmpty(this.f50683d) || TextUtils.isEmpty(this.f50685f) || TextUtils.isEmpty(this.f50684e)) ? false : true : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.q0.a.u.h.b bVar = this.f50688i;
            return (bVar == null || bVar.isSuccess()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SwanPluginFunPageModel{providerAppKey='");
            sb.append(this.f50680a);
            sb.append('\'');
            sb.append(", providerRootPath='");
            sb.append(this.f50682c);
            sb.append('\'');
            sb.append(", providerVersion='");
            sb.append(this.f50683d);
            sb.append('\'');
            sb.append(", componentId='");
            sb.append(this.f50685f);
            sb.append('\'');
            sb.append(", cb='");
            sb.append(this.f50687h);
            sb.append('\'');
            sb.append(", pageParams=");
            sb.append(this.f50686g);
            sb.append(", swanApiResult=");
            d.a.q0.a.u.h.b bVar = this.f50688i;
            sb.append(bVar == null ? null : bVar.a());
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
