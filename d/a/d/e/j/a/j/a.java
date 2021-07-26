package d.a.d.e.j.a.j;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f41738a;

    /* renamed from: b  reason: collision with root package name */
    public String f41739b;

    /* renamed from: c  reason: collision with root package name */
    public long f41740c;

    /* renamed from: d  reason: collision with root package name */
    public long f41741d;

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
                return;
            }
        }
        this.f41741d = System.currentTimeMillis();
    }

    public List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41738a : (List) invokeV.objValue;
    }

    public a b(String str) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f41740c = jSONObject.optLong(ResultTB.TTL);
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    return null;
                }
                String next = optJSONObject.keys().next();
                this.f41739b = next;
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ip")) != null && optJSONArray.length() > 0) {
                    this.f41738a = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        this.f41738a.add((String) optJSONArray.get(i2));
                    }
                }
                return this;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public boolean c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? j - this.f41741d > this.f41740c * 1000 : invokeJ.booleanValue;
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f41740c = j;
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f41741d = j;
        }
    }
}
