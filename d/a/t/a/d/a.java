package d.a.t.a.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.t.a.e.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f68181a;

    /* renamed from: b  reason: collision with root package name */
    public String f68182b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68183c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f68184d;

    public a(boolean z, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68183c = z;
        this.f68181a = jSONArray;
        this.f68182b = String.valueOf(System.currentTimeMillis());
    }

    public final JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = this.f68181a;
            if (jSONArray == null || jSONArray.length() < 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("metadata", b());
                jSONObject.put(Constant.IS_REAL, this.f68183c ? "1" : "0");
                jSONObject.put("data", this.f68181a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a("UploadData", "uploadJson:" + jSONObject.toString());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uploadtime", this.f68182b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f68184d = jSONObject;
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
