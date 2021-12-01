package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TipsConfigItem extends b<TipConfigData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class TipConfigData implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BOTTOM = "bottom";
        public static final String TOAST = "toast";
        public static final long serialVersionUID = 268961350883157950L;
        public transient /* synthetic */ FieldHolder $fh;
        public String tipInfo;
        public transient Map<String, String> tipMap;
        public int tipShowSwitch;

        public TipConfigData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tipMap = new HashMap();
        }

        private void genTipMap(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, jSONObject) == null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.tipMap.put(next, jSONObject.optString(next, ""));
                }
            }
        }

        @Nullable
        public String getTipInfoData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.tipInfo : (String) invokeV.objValue;
        }

        public int getTipShowSwitch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.tipShowSwitch : invokeV.intValue;
        }

        public String getTips(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.tipMap.get(str) : (String) invokeL.objValue;
        }

        public boolean isShowTips() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tipShowSwitch == 0 : invokeV.booleanValue;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            setTipInfoData(jSONObject.optString("tipInfo"));
            this.tipShowSwitch = jSONObject.optInt("tipShowSwitch", 0);
        }

        public void setTipInfoData(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.tipInfo = str;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str)) {
                    return;
                }
                try {
                    genTipMap(new JSONObject(str));
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
        }

        public void setTipShowSwitch(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.tipShowSwitch = i2;
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                t.a(jSONObject, "tipShowSwitch", this.tipShowSwitch);
                t.a(jSONObject, "tipInfo", this.tipInfo);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TipsConfigItem() {
        super("tipConfig", new TipConfigData());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences.Editor editor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            editor.putInt("tipsSwitch", a().getTipShowSwitch());
            editor.putString("tipsInfo", a().getTipInfoData() != null ? a().getTipInfoData() : "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            TipConfigData a = a();
            if (a == null) {
                a = new TipConfigData();
            }
            a.setTipShowSwitch(sharedPreferences.getInt("tipsSwitch", 0));
            a.setTipInfoData(sharedPreferences.getString("tipsInfo", ""));
            a((TipsConfigItem) a);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(b())) == null) {
                a((TipsConfigItem) c());
                return;
            }
            TipConfigData tipConfigData = new TipConfigData();
            tipConfigData.parseJson(optJSONObject);
            a((TipsConfigItem) tipConfigData);
        }
    }
}
