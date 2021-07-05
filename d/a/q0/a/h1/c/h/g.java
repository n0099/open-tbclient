package d.a.q0.a.h1.c.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g implements d.a.q0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48630e;

    /* renamed from: f  reason: collision with root package name */
    public int f48631f;

    /* renamed from: g  reason: collision with root package name */
    public int f48632g;

    /* renamed from: h  reason: collision with root package name */
    public int f48633h;

    public g() {
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
        this.f48630e = Integer.MIN_VALUE;
        this.f48631f = Integer.MIN_VALUE;
        this.f48632g = -1;
        this.f48633h = -1;
    }

    @Override // d.a.q0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has(CustomDialogData.POS_LEFT) && jSONObject.has("top")) {
            this.f48630e = n0.g(jSONObject.optInt(CustomDialogData.POS_LEFT));
            this.f48631f = n0.g(jSONObject.optInt("top"));
            this.f48632g = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.f48633h = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // d.a.q0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f48630e == Integer.MIN_VALUE || this.f48631f == Integer.MIN_VALUE) ? false : true : invokeV.booleanValue;
    }
}
