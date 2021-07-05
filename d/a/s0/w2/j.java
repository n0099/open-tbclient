package d.a.s0.w2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69235a;

    /* renamed from: b  reason: collision with root package name */
    public int f69236b;

    /* renamed from: c  reason: collision with root package name */
    public int f69237c;

    /* renamed from: d  reason: collision with root package name */
    public int f69238d;

    /* renamed from: e  reason: collision with root package name */
    public int f69239e;

    public j() {
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
        this.f69236b = 0;
        this.f69237c = 0;
        this.f69238d = 0;
        this.f69239e = 0;
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                if (z) {
                    this.f69239e++;
                } else {
                    this.f69238d++;
                }
            } else if (z) {
                this.f69236b++;
            } else {
                this.f69237c++;
            }
        }
    }

    public int b(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z2 ? z ? this.f69239e : this.f69238d : z ? this.f69236b : this.f69237c : invokeCommon.intValue;
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("forum_name", this.f69235a);
                jSONObject.put("refresh_count", this.f69236b);
                jSONObject.put("loadmore_count", this.f69237c);
                jSONObject.put("loadmore_count_pb", this.f69238d);
                jSONObject.put("refresh_count_pb", this.f69239e);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public j(JSONObject jSONObject) {
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
        this.f69236b = 0;
        this.f69237c = 0;
        this.f69238d = 0;
        this.f69239e = 0;
        if (jSONObject != null) {
            this.f69235a = jSONObject.optString("forum_name");
            this.f69236b = jSONObject.optInt("refresh_count");
            this.f69237c = jSONObject.optInt("loadmore_count");
            this.f69238d = jSONObject.optInt("loadmore_count_pb");
            this.f69239e = jSONObject.optInt("refresh_count_pb");
        }
    }
}
