package d.a.q0.n.j.i;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f54076a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f54077b;

    public j(String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54076a = str;
        this.f54077b = set;
    }

    public static j a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null || (optJSONArray = optJSONObject.optJSONArray("appkeys")) == null) {
                return null;
            }
            String optString = jSONObject.optString("version");
            HashSet hashSet = new HashSet();
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String optString2 = optJSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString2)) {
                    hashSet.add(optString2);
                }
            }
            return new j(optString, hashSet);
        }
        return (j) invokeL.objValue;
    }

    public Set<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54077b : (Set) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54076a : (String) invokeV.objValue;
    }
}
