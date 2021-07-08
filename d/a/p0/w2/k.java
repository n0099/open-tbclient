package d.a.p0.w2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f66052a;

    /* renamed from: b  reason: collision with root package name */
    public int f66053b;

    /* renamed from: c  reason: collision with root package name */
    public int f66054c;

    /* renamed from: d  reason: collision with root package name */
    public int f66055d;

    /* renamed from: e  reason: collision with root package name */
    public int f66056e;

    public k() {
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
        this.f66053b = 0;
        this.f66054c = 0;
        this.f66055d = 0;
        this.f66056e = 0;
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                if (z) {
                    this.f66056e++;
                } else {
                    this.f66055d++;
                }
            } else if (z) {
                this.f66053b++;
            } else {
                this.f66054c++;
            }
        }
    }

    public int b(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z2 ? z ? this.f66056e : this.f66055d : z ? this.f66053b : this.f66054c : invokeCommon.intValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("forum_name", this.f66052a);
                jSONObject.put("refresh_count", this.f66053b);
                jSONObject.put("loadmore_count", this.f66054c);
                jSONObject.put("loadmore_count_pb", this.f66055d);
                jSONObject.put("refresh_count_pb", this.f66056e);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66053b = 0;
        this.f66054c = 0;
        this.f66055d = 0;
        this.f66056e = 0;
        if (jSONObject != null) {
            this.f66052a = jSONObject.optString("forum_name");
            this.f66053b = jSONObject.optInt("refresh_count");
            this.f66054c = jSONObject.optInt("loadmore_count");
            this.f66055d = jSONObject.optInt("loadmore_count_pb");
            this.f66056e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
