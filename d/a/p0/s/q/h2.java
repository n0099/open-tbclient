package d.a.p0.s.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes7.dex */
public class h2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f53351a;

    /* renamed from: b  reason: collision with root package name */
    public String f53352b;

    /* renamed from: c  reason: collision with root package name */
    public int f53353c;

    /* renamed from: d  reason: collision with root package name */
    public int f53354d;

    public h2() {
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
        this.f53351a = jSONObject.optLong("birthday_time", 0L);
        this.f53354d = jSONObject.optInt("birthday_show_status", 0);
        this.f53352b = jSONObject.optString("constellation", "");
        this.f53353c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, birthdayInfo) == null) || birthdayInfo == null) {
            return;
        }
        this.f53351a = birthdayInfo.birthday_time.longValue();
        this.f53354d = birthdayInfo.birthday_show_status.intValue();
        this.f53352b = birthdayInfo.constellation;
        this.f53353c = birthdayInfo.age.intValue();
    }
}
