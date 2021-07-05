package d.a.r0.s.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f56468a;

    /* renamed from: b  reason: collision with root package name */
    public String f56469b;

    /* renamed from: c  reason: collision with root package name */
    public String f56470c;

    /* renamed from: d  reason: collision with root package name */
    public String f56471d;

    /* renamed from: e  reason: collision with root package name */
    public String f56472e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56473f;

    public y() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.isEmpty(this.f56469b) || this.f56468a <= 0 : invokeV.booleanValue;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null || jSONObject == null) {
            return;
        }
        this.f56468a = jSONObject.optInt("tab_type");
        this.f56469b = jSONObject.optString("tab_name");
        this.f56470c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f56471d = jSONObject.optString("tab_url");
        this.f56472e = jSONObject.optString("tab_version");
    }
}
