package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class InstallActivateReminderConfigItem extends a<InstallActivateReminderConfig> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class InstallActivateReminderConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6457271849826128465L;
        public transient /* synthetic */ FieldHolder $fh;
        public int noticeAppearTime;
        public int noticeContinueTime;
        public int noticeTotalCount;
        public int perAppNoticeCount;

        public InstallActivateReminderConfig() {
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
            this.noticeTotalCount = 3;
            this.perAppNoticeCount = 2;
            this.noticeAppearTime = 15000;
            this.noticeContinueTime = 15000;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallActivateReminderConfigItem() {
        super("installActivateReminderConfig", new InstallActivateReminderConfig());
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

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        String a2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editor) == null) {
            if (b() == null || b().toJson() == null) {
                a2 = a();
                str = "";
            } else {
                a2 = a();
                str = b().toJson().toString();
            }
            editor.putString(a2, str);
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sharedPreferences) == null) {
            InstallActivateReminderConfig b2 = b();
            if (b2 == null) {
                b2 = new InstallActivateReminderConfig();
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(sharedPreferences.getString(a(), ""));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (jSONObject != null) {
                b2.parseJson(jSONObject);
            }
            a((InstallActivateReminderConfigItem) b2);
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) {
                a((InstallActivateReminderConfigItem) c());
                return;
            }
            InstallActivateReminderConfig installActivateReminderConfig = new InstallActivateReminderConfig();
            installActivateReminderConfig.parseJson(optJSONObject);
            a((InstallActivateReminderConfigItem) installActivateReminderConfig);
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b().noticeTotalCount : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b().perAppNoticeCount : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b().noticeAppearTime : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b().noticeContinueTime : invokeV.intValue;
    }
}
