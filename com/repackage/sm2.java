package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sm2 extends tm2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] A;
    public ArrayList<an2> z;

    public sm2() {
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
        this.A = new int[]{0, 0, 0, 0};
    }

    @Override // com.repackage.tm2, com.repackage.xv1, com.repackage.gq2
    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (jSONObject.has("points") && (jSONArray2 = jSONObject.getJSONArray("points")) != null && jSONArray2.length() > 0) {
            int length = jSONArray2.length();
            this.z = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                if (jSONObject2 != null) {
                    an2 an2Var = new an2();
                    an2Var.a(jSONObject2);
                    if (an2Var.isValid()) {
                        this.z.add(an2Var);
                    }
                }
            }
        }
        if (!jSONObject.has(CriusAttrConstants.PADDING) || (jSONArray = jSONObject.getJSONArray(CriusAttrConstants.PADDING)) == null || jSONArray.length() <= 0) {
            return;
        }
        int min = Math.min(jSONArray.length(), 4);
        for (int i2 = 0; i2 < min; i2++) {
            this.A[i2] = yd3.g(jSONArray.optInt(i2));
        }
    }

    @Override // com.repackage.xv1, com.repackage.gq2
    public boolean isValid() {
        InterceptResult invokeV;
        ArrayList<an2> arrayList;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.b) || (arrayList = this.z) == null || arrayList.size() <= 0) ? false : true : invokeV.booleanValue;
    }
}
