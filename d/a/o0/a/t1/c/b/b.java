package d.a.o0.a.t1.c.b;

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
    public String f47882a;

    /* renamed from: b  reason: collision with root package name */
    public String f47883b;

    /* renamed from: c  reason: collision with root package name */
    public String f47884c;

    /* renamed from: d  reason: collision with root package name */
    public String f47885d;

    /* renamed from: e  reason: collision with root package name */
    public String f47886e;

    /* renamed from: f  reason: collision with root package name */
    public String f47887f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47888g;

    /* renamed from: h  reason: collision with root package name */
    public String f47889h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.a.u.h.b f47890i;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f47882a) || TextUtils.isEmpty(this.f47884c) || TextUtils.isEmpty(this.f47885d) || TextUtils.isEmpty(this.f47887f) || TextUtils.isEmpty(this.f47886e)) ? false : true : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.o0.a.u.h.b bVar = this.f47890i;
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
            sb.append(this.f47882a);
            sb.append('\'');
            sb.append(", providerRootPath='");
            sb.append(this.f47884c);
            sb.append('\'');
            sb.append(", providerVersion='");
            sb.append(this.f47885d);
            sb.append('\'');
            sb.append(", componentId='");
            sb.append(this.f47887f);
            sb.append('\'');
            sb.append(", cb='");
            sb.append(this.f47889h);
            sb.append('\'');
            sb.append(", pageParams=");
            sb.append(this.f47888g);
            sb.append(", swanApiResult=");
            d.a.o0.a.u.h.b bVar = this.f47890i;
            sb.append(bVar == null ? null : bVar.a());
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
