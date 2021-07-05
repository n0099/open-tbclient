package d.a.r0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f56698a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56699b;

    public d() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f56698a = jSONObject.optInt("is_business_account") == 1;
        this.f56699b = jSONObject.optInt("is_forum_business_account") == 1;
        jSONObject.optString("business_name");
        jSONObject.optString("identifi_explain");
    }

    public void b(BusinessAccountInfo businessAccountInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, businessAccountInfo) == null) || businessAccountInfo == null) {
            return;
        }
        this.f56698a = businessAccountInfo.is_business_account.intValue() == 1;
        this.f56699b = businessAccountInfo.is_forum_business_account.intValue() == 1;
        String str = businessAccountInfo.business_name;
        String str2 = businessAccountInfo.identifi_explain;
    }
}
