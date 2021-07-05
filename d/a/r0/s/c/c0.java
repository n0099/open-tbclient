package d.a.r0.s.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f56345a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56346b;

    /* renamed from: c  reason: collision with root package name */
    public int f56347c;

    /* renamed from: d  reason: collision with root package name */
    public int f56348d;

    /* renamed from: e  reason: collision with root package name */
    public String f56349e;

    /* renamed from: f  reason: collision with root package name */
    public String f56350f;

    /* renamed from: g  reason: collision with root package name */
    public String f56351g;

    /* renamed from: h  reason: collision with root package name */
    public int f56352h;

    /* renamed from: i  reason: collision with root package name */
    public String f56353i;

    public c0() {
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
        this.f56345a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f56346b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f56347c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f56348d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f56349e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f56350f = jSONObject.optString("downloadNaniTxt", null);
        this.f56351g = jSONObject.optString("showNaniTailTxt", null);
        this.f56352h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f56353i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
