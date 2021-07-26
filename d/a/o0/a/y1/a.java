package d.a.o0.a.y1;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<C0998a> f49029a;

    /* renamed from: b  reason: collision with root package name */
    public String f49030b;

    /* renamed from: d.a.o0.a.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0998a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f49031a;

        /* renamed from: b  reason: collision with root package name */
        public String f49032b;

        /* renamed from: c  reason: collision with root package name */
        public String f49033c;

        public C0998a() {
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
            }
        }
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f49030b = jSONObject.optString("more");
            JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        C0998a c0998a = new C0998a();
                        optJSONObject.optString("app_key");
                        c0998a.f49032b = optJSONObject.optString("app_name");
                        c0998a.f49031a = optJSONObject.optString("photo_addr");
                        c0998a.f49033c = optJSONObject.optString("scheme");
                        arrayList.add(c0998a);
                    }
                }
                aVar.f49029a = arrayList;
                return aVar;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }
}
