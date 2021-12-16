package com.kwad.sdk.e;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<e<a>> mHolders;

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

    private List<e<a>> getHolders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mHolders == null) {
                this.mHolders = new ArrayList();
                for (Class<?> cls = getClass(); cls != null && a.class.isAssignableFrom(cls); cls = cls.getSuperclass()) {
                    e<a> holder = getHolderMananger().getHolder(cls);
                    if (holder != null) {
                        this.mHolders.add(0, holder);
                    }
                }
            }
            return this.mHolders;
        }
        return (List) invokeV.objValue;
    }

    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
        }
    }

    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    public abstract b getHolderMananger();

    @Override // com.kwad.sdk.e.c
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            List<e<a>> holders = getHolders();
            for (int size = holders.size() - 1; size >= 0; size--) {
                holders.get(size).a(this, jSONObject);
            }
            afterParseJson(jSONObject);
        }
    }

    @Override // com.kwad.sdk.e.c
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<e<a>> holders = getHolders();
            JSONObject jSONObject = new JSONObject();
            for (int size = holders.size() - 1; size >= 0; size--) {
                holders.get(size).b(this, jSONObject);
            }
            afterToJson(jSONObject);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
