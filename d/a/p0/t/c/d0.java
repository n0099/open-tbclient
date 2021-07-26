package d.a.p0.t.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53739a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53740b;

    /* renamed from: c  reason: collision with root package name */
    public int f53741c;

    /* renamed from: d  reason: collision with root package name */
    public int f53742d;

    /* renamed from: e  reason: collision with root package name */
    public String f53743e;

    /* renamed from: f  reason: collision with root package name */
    public String f53744f;

    /* renamed from: g  reason: collision with root package name */
    public String f53745g;

    /* renamed from: h  reason: collision with root package name */
    public int f53746h;

    /* renamed from: i  reason: collision with root package name */
    public String f53747i;

    public d0() {
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
        this.f53739a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f53740b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f53741c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f53742d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f53743e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f53744f = jSONObject.optString("downloadNaniTxt", null);
        this.f53745g = jSONObject.optString("showNaniTailTxt", null);
        this.f53746h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f53747i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
