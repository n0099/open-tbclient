package d.a.p0.w2.f0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65906a;

    /* renamed from: b  reason: collision with root package name */
    public String f65907b;

    /* renamed from: c  reason: collision with root package name */
    public String f65908c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65909d;

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
            }
        }
    }

    public static b a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            bVar.f65906a = jSONObject.optString("apk_name");
            bVar.f65907b = jSONObject.optString("apk_url");
            bVar.f65908c = jSONObject.optString("download_key");
            bVar.f65909d = jSONObject.optBoolean("direcrt_download");
            return bVar;
        }
        return (b) invokeL.objValue;
    }
}
