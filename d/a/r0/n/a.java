package d.a.r0.n;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55501a;

    /* renamed from: b  reason: collision with root package name */
    public int f55502b;

    /* renamed from: c  reason: collision with root package name */
    public int f55503c;

    /* renamed from: d  reason: collision with root package name */
    public int f55504d;

    /* renamed from: e  reason: collision with root package name */
    public int f55505e;

    /* renamed from: f  reason: collision with root package name */
    public int f55506f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55507g;

    public a() {
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
        this.f55501a = 300;
        this.f55502b = 5000;
        this.f55503c = 10000;
        this.f55504d = 1500;
        this.f55505e = 3000;
        this.f55506f = 6000;
        this.f55507g = true;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("wifiSlow", -1);
            if (optInt > 0) {
                this.f55501a = optInt;
            }
            int optInt2 = jSONObject.optInt("threeGSlow", -1);
            if (optInt2 > 0) {
                this.f55502b = optInt2;
            }
            int optInt3 = jSONObject.optInt("twoGSlow", -1);
            if (optInt3 > 0) {
                this.f55503c = optInt3;
            }
            int optInt4 = jSONObject.optInt("wifiLog", -1);
            if (optInt4 > 0) {
                this.f55504d = optInt4;
            }
            int optInt5 = jSONObject.optInt("threeGLog", -1);
            if (optInt5 > 0) {
                this.f55505e = optInt5;
            }
            int optInt6 = jSONObject.optInt("twoGLog", -1);
            if (optInt6 > 0) {
                this.f55506f = optInt6;
            }
            boolean z = true;
            if (jSONObject.optInt("mobile_cdn_switch", 1) != 1) {
                z = false;
            }
            this.f55507g = z;
        } catch (Exception unused) {
        }
    }
}
