package d.a.r0.r.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
import tbclient.ActInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55855a;

    /* renamed from: b  reason: collision with root package name */
    public int f55856b;

    /* renamed from: c  reason: collision with root package name */
    public int f55857c;

    /* renamed from: d  reason: collision with root package name */
    public int f55858d;

    /* renamed from: e  reason: collision with root package name */
    public String f55859e;

    /* renamed from: f  reason: collision with root package name */
    public int f55860f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55861g;

    /* renamed from: h  reason: collision with root package name */
    public int f55862h;

    /* renamed from: i  reason: collision with root package name */
    public int f55863i;
    public w1 j;

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
        this.f55862h = 1;
        this.f55863i = 1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55855a : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55857c : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55858d : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55861g : invokeV.booleanValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55856b : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55860f : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55859e : (String) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f55855a = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
            this.f55856b = jSONObject.optInt("status");
            this.f55857c = jSONObject.optInt("begin_time");
            this.f55858d = jSONObject.optInt(ResultTB.ENDTIME);
            this.f55859e = jSONObject.optString("url");
            this.f55860f = jSONObject.optInt("total_num");
            jSONObject.optInt("activity_id");
            jSONObject.optInt("award_act_id");
            jSONObject.optInt("component_id");
            this.f55861g = jSONObject.optBoolean("is_senior");
            jSONObject.optString("banner_img");
            jSONObject.optInt("show_total_num");
            String optString = jSONObject.optString("banner_img_size");
            if (!d.a.c.e.p.k.isEmpty(optString)) {
                String[] split = optString.split(",");
                this.f55862h = d.a.c.e.m.b.d(split[0], 1);
                this.f55863i = d.a.c.e.m.b.d(split[1], 1);
            }
            if (this.f55862h <= 0) {
                this.f55862h = 1;
            }
            if (this.f55863i <= 0) {
                this.f55863i = 1;
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(ActInfo actInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, actInfo) == null) || actInfo == null) {
            return;
        }
        Integer num = actInfo.activity_type;
        this.f55855a = num != null ? num.intValue() : -1;
        Integer num2 = actInfo.status;
        this.f55856b = num2 != null ? num2.intValue() : -1;
        Integer num3 = actInfo.begin_time;
        this.f55857c = num3 != null ? num3.intValue() : -1;
        Integer num4 = actInfo.end_time;
        this.f55858d = num4 != null ? num4.intValue() : -1;
        this.f55859e = actInfo.url;
        Integer num5 = actInfo.total_num;
        this.f55860f = num5 != null ? num5.intValue() : -1;
        actInfo.activity_id.intValue();
        actInfo.award_act_id.intValue();
        actInfo.component_id.intValue();
        this.f55861g = actInfo.is_senior.booleanValue();
        String str = actInfo.banner_img;
        actInfo.show_total_num.intValue();
        String str2 = actInfo.banner_img_size;
        if (!d.a.c.e.p.k.isEmpty(str2)) {
            try {
                String[] split = str2.split(",");
                this.f55862h = d.a.c.e.m.b.d(split[0], 1);
                this.f55863i = d.a.c.e.m.b.d(split[1], 1);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f55862h <= 0) {
            this.f55862h = 1;
        }
        if (this.f55863i <= 0) {
            this.f55863i = 1;
        }
        w1 w1Var = new w1();
        this.j = w1Var;
        w1Var.a(actInfo.lottery_senior);
    }
}
