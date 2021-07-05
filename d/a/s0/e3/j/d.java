package d.a.s0.e3.j;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f59266a;

    /* renamed from: b  reason: collision with root package name */
    public String f59267b;

    /* renamed from: c  reason: collision with root package name */
    public String f59268c;

    /* renamed from: d  reason: collision with root package name */
    public String f59269d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f59270e;

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

    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.f59266a = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
            this.f59267b = jSONObject.optString("menu_name");
            this.f59268c = jSONObject.optString("menu_id");
            String optString = jSONObject.optString("default_logo_url", null);
            this.f59269d = optString;
            this.f59269d = optString != null ? this.f59269d + "?v=2" : null;
            if (jSONObject.has("child_menu_list")) {
                ArrayList<d> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    d dVar = new d();
                    dVar.a(optJSONArray.getJSONObject(i2));
                    arrayList.add(dVar);
                }
                this.f59270e = arrayList;
            }
        }
    }
}
