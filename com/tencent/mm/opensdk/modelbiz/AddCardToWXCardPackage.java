package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;
/* loaded from: classes7.dex */
public class AddCardToWXCardPackage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MicroMsg.AddCardToWXCardPackage";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class Req extends BaseReq {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<WXCardItem> cardArrary;

        public Req() {
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

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            InterceptResult invokeV;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<WXCardItem> list = this.cardArrary;
                if (list == null || list.size() == 0 || this.cardArrary.size() > 40) {
                    return false;
                }
                for (WXCardItem wXCardItem : this.cardArrary) {
                    if (wXCardItem == null || (str = wXCardItem.cardId) == null || str.length() > 1024 || ((str2 = wXCardItem.cardExtMsg) != null && str2.length() > 1024)) {
                        return false;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 9;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
                super.toBundle(bundle);
                JSONStringer jSONStringer = new JSONStringer();
                try {
                    jSONStringer.object();
                    jSONStringer.key("card_list");
                    jSONStringer.array();
                    for (WXCardItem wXCardItem : this.cardArrary) {
                        jSONStringer.object();
                        jSONStringer.key(PersonalCardDetailActivityConfig.CARD_ID);
                        jSONStringer.value(wXCardItem.cardId);
                        jSONStringer.key("card_ext");
                        jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                        jSONStringer.endObject();
                    }
                    jSONStringer.endArray();
                    jSONStringer.endObject();
                } catch (Exception e) {
                    Log.e(AddCardToWXCardPackage.TAG, "Req.toBundle exception:" + e.getMessage());
                }
                bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class Resp extends BaseResp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<WXCardItem> cardArrary;

        public Resp() {
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

        public Resp(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<WXCardItem> list = this.cardArrary;
                return (list == null || list.size() == 0) ? false : true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                super.fromBundle(bundle);
                if (this.cardArrary == null) {
                    this.cardArrary = new LinkedList();
                }
                String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
                if (string == null || string.length() <= 0) {
                    return;
                }
                try {
                    JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        WXCardItem wXCardItem = new WXCardItem();
                        wXCardItem.cardId = jSONObject.optString(PersonalCardDetailActivityConfig.CARD_ID);
                        wXCardItem.cardExtMsg = jSONObject.optString("card_ext");
                        wXCardItem.cardState = jSONObject.optInt("is_succ");
                        this.cardArrary.add(wXCardItem);
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 9;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                super.toBundle(bundle);
                JSONStringer jSONStringer = new JSONStringer();
                try {
                    jSONStringer.object();
                    jSONStringer.key("card_list");
                    jSONStringer.array();
                    for (WXCardItem wXCardItem : this.cardArrary) {
                        jSONStringer.object();
                        jSONStringer.key(PersonalCardDetailActivityConfig.CARD_ID);
                        jSONStringer.value(wXCardItem.cardId);
                        jSONStringer.key("card_ext");
                        jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                        jSONStringer.key("is_succ");
                        jSONStringer.value(wXCardItem.cardState);
                        jSONStringer.endObject();
                    }
                    jSONStringer.endArray();
                    jSONStringer.endObject();
                } catch (Exception e) {
                    Log.e(AddCardToWXCardPackage.TAG, "Resp.toBundle exception:" + e.getMessage());
                }
                bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class WXCardItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String cardExtMsg;
        public String cardId;
        public int cardState;

        public WXCardItem() {
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
    }

    public AddCardToWXCardPackage() {
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
}
