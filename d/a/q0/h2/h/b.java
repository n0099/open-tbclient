package d.a.q0.h2.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f57425a;

    /* renamed from: b  reason: collision with root package name */
    public String f57426b;

    /* renamed from: c  reason: collision with root package name */
    public String f57427c;

    /* renamed from: d  reason: collision with root package name */
    public String f57428d;

    /* renamed from: e  reason: collision with root package name */
    public int f57429e;

    /* renamed from: f  reason: collision with root package name */
    public String f57430f;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57429e == 3 : invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57429e == 1 : invokeV.booleanValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f57426b = jSONObject.optString("card_logo");
        this.f57427c = jSONObject.optString("card_name");
        this.f57428d = jSONObject.optString("card_pro");
        this.f57429e = jSONObject.optInt("card_get_status");
        this.f57425a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
        this.f57430f = jSONObject.optString("card_num");
    }

    public void d(SendCardInfo sendCardInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sendCardInfo) == null) || sendCardInfo == null) {
            return;
        }
        this.f57426b = sendCardInfo.card_logo;
        this.f57427c = sendCardInfo.card_name;
        this.f57428d = sendCardInfo.card_pro;
        this.f57429e = sendCardInfo.card_get_status.intValue();
        this.f57425a = sendCardInfo.packet_id.longValue();
    }
}
