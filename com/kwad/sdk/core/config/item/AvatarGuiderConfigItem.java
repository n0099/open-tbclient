package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AvatarGuiderConfigItem extends b<AvatarGuiderConfig> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class AvatarGuiderConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int showByPlayRate;
        public int showMaxTimes;
        public int showTimeLength;

        public AvatarGuiderConfig() {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarGuiderConfigItem() {
        super("avatarGuiderConfig", null);
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
        String b2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            if (a() == null || a().toJson() == null) {
                b2 = b();
                str = "";
            } else {
                b2 = b();
                str = a().toJson().toString();
            }
            editor.putString(b2, str);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(@NonNull SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            AvatarGuiderConfig a2 = a();
            if (a2 == null) {
                a2 = new AvatarGuiderConfig();
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(sharedPreferences.getString(b(), ""));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (jSONObject != null) {
                a2.parseJson(jSONObject);
            }
            a((AvatarGuiderConfigItem) a2);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(b())) == null) {
                com.kwad.sdk.core.d.a.a("AvatarGuiderConfigItem", "AvatarGuiderConfigItem = getDefault");
                a((AvatarGuiderConfigItem) c());
                return;
            }
            AvatarGuiderConfig avatarGuiderConfig = new AvatarGuiderConfig();
            avatarGuiderConfig.parseJson(optJSONObject);
            com.kwad.sdk.core.d.a.a("AvatarGuiderConfigItem", "AvatarGuiderConfigItem = " + avatarGuiderConfig.toJson().toString());
            a((AvatarGuiderConfigItem) avatarGuiderConfig);
        }
    }
}
