package d.a.o0.s.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53064a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53065b;

    /* renamed from: c  reason: collision with root package name */
    public int f53066c;

    /* renamed from: d  reason: collision with root package name */
    public int f53067d;

    /* renamed from: e  reason: collision with root package name */
    public String f53068e;

    /* renamed from: f  reason: collision with root package name */
    public String f53069f;

    /* renamed from: g  reason: collision with root package name */
    public String f53070g;

    /* renamed from: h  reason: collision with root package name */
    public int f53071h;

    /* renamed from: i  reason: collision with root package name */
    public String f53072i;

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
        this.f53064a = jSONObject.optInt("isShowDownloadNaniPanel", 2) == 1;
        this.f53065b = jSONObject.optInt("isActivateNaniApp", 1) == 1;
        this.f53066c = jSONObject.optInt("downloadNaniShowPosition", 3);
        this.f53067d = jSONObject.optInt("downloadNaniShowRate", 2);
        this.f53068e = jSONObject.optString("downloadNaniLinkUrl", null);
        this.f53069f = jSONObject.optString("downloadNaniTxt", null);
        this.f53070g = jSONObject.optString("showNaniTailTxt", null);
        this.f53071h = jSONObject.optInt("showNaniTailVideoType", 0);
        this.f53072i = jSONObject.optString("preNaniShareUrl", TbConfig.NANI_DEFAULT_H5_PREFIX);
    }
}
