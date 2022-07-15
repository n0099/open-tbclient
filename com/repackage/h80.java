package com.repackage;

import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<LiveBannerEntity> a;

    public h80() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        jSONObject.optInt("inner_errno");
        jSONObject.optString("inner_msg");
        jSONObject.optInt("count");
        jSONObject.optInt(CriusAttrConstants.POSITION);
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.a = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                LiveBannerEntity liveBannerEntity = new LiveBannerEntity();
                liveBannerEntity.parserJson(optJSONObject);
                if (liveBannerEntity.isValid()) {
                    liveBannerEntity.position = this.a.size();
                    this.a.add(liveBannerEntity);
                }
            }
        }
    }
}
