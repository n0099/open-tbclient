package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<MetaData> a;
    public HashMap<String, String> b;

    public hx8() {
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
        this.a = new ArrayList<>();
        this.b = null;
    }

    public ArrayList<MetaData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                c(new JSONObject(str), true);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void c(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, z) == null) || jSONObject == null) {
            return;
        }
        if (z) {
            try {
                if (this.b == null) {
                    this.b = new HashMap<>();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
                return;
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                MetaData metaData = new MetaData();
                metaData.parserJson(optJSONArray.getJSONObject(i));
                if (!TextUtils.isEmpty(metaData.getName_show())) {
                    this.a.add(metaData);
                    if (z) {
                        this.b.put(metaData.getName_show(), metaData.getPortrait());
                    }
                }
            }
        }
    }
}
