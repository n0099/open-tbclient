package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
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
public class l57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<m57> a;
    public List<m57> b;

    public l57() {
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

    @NonNull
    public List<m57> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.a)) {
                arrayList.addAll(this.a);
            }
            if (!ListUtils.isEmpty(this.b)) {
                arrayList.addAll(this.b);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void b(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = c(jSONObject, "tieba_memes");
        this.b = c(jSONObject, "outer_memes");
    }

    @Nullable
    public final List<m57> c(@NonNull JSONObject jSONObject, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                m57 m57Var = new m57();
                m57Var.a(optJSONArray.optJSONObject(i));
                if (m57Var.isValid()) {
                    arrayList.add(m57Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
