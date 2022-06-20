package com.repackage;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xe8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public ArrayList<xe8> e;

    public xe8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.a = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
            this.b = jSONObject.optString("menu_name");
            this.c = jSONObject.optString("menu_id");
            String optString = jSONObject.optString("default_logo_url", null);
            this.d = optString;
            this.d = optString != null ? this.d + "?v=2" : null;
            if (jSONObject.has("child_menu_list")) {
                ArrayList<xe8> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    xe8 xe8Var = new xe8();
                    xe8Var.a(optJSONArray.getJSONObject(i));
                    arrayList.add(xe8Var);
                }
                this.e = arrayList;
            }
        }
    }
}
