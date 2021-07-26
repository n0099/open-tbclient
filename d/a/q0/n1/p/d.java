package d.a.q0.n1.p;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f61275a;

    /* renamed from: b  reason: collision with root package name */
    public String f61276b;

    /* renamed from: c  reason: collision with root package name */
    public String f61277c;

    /* renamed from: d  reason: collision with root package name */
    public int f61278d;

    /* renamed from: e  reason: collision with root package name */
    public String f61279e;

    /* renamed from: f  reason: collision with root package name */
    public String f61280f;

    /* renamed from: g  reason: collision with root package name */
    public String f61281g;

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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f61277c)) {
                return false;
            }
            return this.f61278d == 2 ? (TextUtils.isEmpty(this.f61279e) || TextUtils.isEmpty(this.f61280f) || TextUtils.isEmpty(this.f61281g)) ? false : true : (TextUtils.isEmpty(this.f61275a) || TextUtils.isEmpty(this.f61276b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f61275a = jSONObject.optString("pic");
        this.f61276b = jSONObject.optString("picNight");
        this.f61277c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f61278d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f61279e = optJSONObject.optString("title");
        this.f61280f = optJSONObject.optString("content");
        this.f61281g = optJSONObject.optString("imageUrl");
    }
}
