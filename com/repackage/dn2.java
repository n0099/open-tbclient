package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dn2 implements gq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<an2> a;
    public int b;
    public float c;
    public boolean d;

    public dn2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0.0f;
        this.d = false;
    }

    @Override // com.repackage.gq2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("points")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("points");
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                this.a = new ArrayList<>(length);
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        an2 an2Var = new an2();
                        an2Var.a(optJSONObject);
                        if (an2Var.isValid()) {
                            this.a.add(an2Var);
                        }
                    }
                }
            }
            ArrayList<an2> arrayList = this.a;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.b = um2.a(jSONObject.optString("color"), 0);
            this.c = Math.abs(um2.b(jSONObject.optDouble("width", 0.0d)));
            this.d = jSONObject.optBoolean("dottedLine", false);
            jSONObject.optBoolean("arrowLine", false);
            jSONObject.optString("arrowIconPath");
            um2.a(jSONObject.optString("borderColor"), 0);
            Math.abs(um2.b(jSONObject.optDouble("borderWidth", 0.0d)));
        }
    }

    @Override // com.repackage.gq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<an2> arrayList = this.a;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }
}
