package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdBitResultData extends AdResultData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3932631606478587475L;
    public transient /* synthetic */ FieldHolder $fh;
    public List adBidList;
    public String adxId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBitResultData(KsScene ksScene) {
        super(ksScene);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((KsScene) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adBidList = new ArrayList();
    }

    @Override // com.kwad.components.core.response.model.AdResultData, com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            try {
                this.adxId = jSONObject.optString("adxId");
                String optString = jSONObject.optString("adBids");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(optString);
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            AdBid adBid = new AdBid();
                            adBid.parseJson(optJSONObject);
                            this.adBidList.add(adBid);
                        }
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
    }
}
