package d.a.q0.a.j1.d;

import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49018a;

    /* renamed from: b  reason: collision with root package name */
    public String f49019b;

    /* renamed from: c  reason: collision with root package name */
    public String f49020c;

    /* renamed from: d  reason: collision with root package name */
    public String f49021d;

    /* renamed from: e  reason: collision with root package name */
    public String f49022e;

    /* renamed from: f  reason: collision with root package name */
    public String f49023f;

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
            }
        }
    }

    public static a a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            String optString = jSONObject.optString("error");
            if (optJSONObject2 == null || !TextUtils.equals(optString, "0")) {
                return null;
            }
            a aVar = new a();
            aVar.f49018a = optJSONObject2.optString(ContentUtil.RESULT_KEY_AK);
            aVar.f49019b = optJSONObject2.optString(ContentUtil.RESULT_KEY_SK);
            aVar.f49020c = optJSONObject2.optString("token");
            aVar.f49021d = optJSONObject2.optString(ContentUtil.RESULT_KEY_BUCKET);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("oname_list");
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject(str)) != null) {
                aVar.f49023f = optJSONObject.optString("bosobject");
                aVar.f49022e = optJSONObject.optString("bosurl");
            }
            return aVar;
        }
        return (a) invokeLL.objValue;
    }
}
