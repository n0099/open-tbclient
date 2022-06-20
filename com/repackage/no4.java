package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class no4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;

    public no4() {
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
        this.b = "";
        this.g = "";
        this.h = "";
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a = jSONObject.optInt("is_business_account", 0);
                this.b = jSONObject.optString("auth_desc");
                this.c = jSONObject.optInt("auth_type", 0);
                this.d = jSONObject.optInt("is_original_author", 0);
                this.e = jSONObject.optInt("god_status", 0);
                this.f = jSONObject.optInt("is_god", 0);
                this.g = jSONObject.optString("bazhu_desc");
                this.h = jSONObject.optString("bazhu_level");
                this.i = jSONObject.optInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, 0);
                this.j = jSONObject.optInt(NativeEmotionManagerActivityConfig.KEY, 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void b(UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userData) == null) || userData == null) {
            return;
        }
        if (userData.getBusinessAccountData() != null) {
            this.a = userData.getBusinessAccountData().isBusinessAccount ? 1 : 0;
        }
        if (userData.getCreatorInfo() != null) {
            this.b = userData.getCreatorInfo().authDesc;
        }
        this.c = userData.getAuthType();
        this.d = userData.getIsOriginalAuthor();
        if (userData.getNewGodData() != null) {
            this.e = userData.getNewGodData().getStatus();
        }
        this.f = userData.isGod() ? 1 : 0;
        if (userData.getBazhuGradeData() != null) {
            this.g = userData.getBazhuGradeData().getDesc();
            this.h = userData.getBazhuGradeData().getLevel();
        }
        if (userData.getPrivSetsData() != null) {
            this.i = userData.getPrivSetsData().getBazhuShowOutside();
        }
        this.j = userData.getIsBaZhu();
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_business_account", this.a);
                jSONObject.put("auth_desc", this.b);
                jSONObject.put("auth_type", this.c);
                jSONObject.put("is_original_author", this.d);
                jSONObject.put("god_status", this.e);
                jSONObject.put("is_god", this.f);
                jSONObject.put("bazhu_desc", this.g);
                jSONObject.put("bazhu_level", this.h);
                jSONObject.put(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, this.i);
                jSONObject.put(NativeEmotionManagerActivityConfig.KEY, this.j);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
