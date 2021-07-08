package d.a.n0.a.t1.c.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f47378a;

    /* renamed from: b  reason: collision with root package name */
    public String f47379b;

    /* renamed from: c  reason: collision with root package name */
    public String f47380c;

    /* renamed from: d  reason: collision with root package name */
    public String f47381d;

    /* renamed from: e  reason: collision with root package name */
    public String f47382e;

    /* renamed from: f  reason: collision with root package name */
    public String f47383f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47384g;

    /* renamed from: h  reason: collision with root package name */
    public String f47385h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.a.u.h.b f47386i;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f47378a) || TextUtils.isEmpty(this.f47380c) || TextUtils.isEmpty(this.f47381d) || TextUtils.isEmpty(this.f47383f) || TextUtils.isEmpty(this.f47382e)) ? false : true : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.n0.a.u.h.b bVar = this.f47386i;
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
            sb.append(this.f47378a);
            sb.append('\'');
            sb.append(", providerRootPath='");
            sb.append(this.f47380c);
            sb.append('\'');
            sb.append(", providerVersion='");
            sb.append(this.f47381d);
            sb.append('\'');
            sb.append(", componentId='");
            sb.append(this.f47383f);
            sb.append('\'');
            sb.append(", cb='");
            sb.append(this.f47385h);
            sb.append('\'');
            sb.append(", pageParams=");
            sb.append(this.f47384g);
            sb.append(", swanApiResult=");
            d.a.n0.a.u.h.b bVar = this.f47386i;
            sb.append(bVar == null ? null : bVar.a());
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
