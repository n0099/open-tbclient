package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gk7 implements jn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<zy4> b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755675074, "Lcom/repackage/gk7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755675074, "Lcom/repackage/gk7;");
                return;
            }
        }
        d = BdUniqueId.gen();
    }

    public gk7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("need_profile", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("nearby_person_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.b = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                zy4 zy4Var = new zy4();
                zy4Var.a(optJSONArray.optJSONObject(i));
                this.b.add(zy4Var);
            }
        }
        this.c = jSONObject.optInt("has_more", 0) == 1;
    }

    @Override // com.repackage.jn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d : (BdUniqueId) invokeV.objValue;
    }
}
