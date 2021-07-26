package d.a.q0.c4;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<C1323a> f55404a;

    /* renamed from: d.a.q0.c4.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1323a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f55405a;

        /* renamed from: b  reason: collision with root package name */
        public String f55406b;

        public C1323a() {
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
    }

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
        this.f55404a = new ArrayList();
    }

    public List<C1323a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55404a : (List) invokeV.objValue;
    }

    public final void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() > 0) {
                if (this.f55404a == null) {
                    this.f55404a = new ArrayList();
                }
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    C1323a c1323a = new C1323a();
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    c1323a.f55405a = optJSONObject.optInt("tab_id");
                    c1323a.f55406b = optJSONObject.optString("tab_name");
                    optJSONObject.optInt("obj_type");
                    this.f55404a.add(c1323a);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        b(jSONArray);
    }
}
