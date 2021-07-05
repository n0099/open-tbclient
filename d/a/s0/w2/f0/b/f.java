package d.a.s0.w2.f0.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69150a;

    /* renamed from: b  reason: collision with root package name */
    public String f69151b;

    /* renamed from: c  reason: collision with root package name */
    public String f69152c;

    /* renamed from: d  reason: collision with root package name */
    public String f69153d;

    /* renamed from: e  reason: collision with root package name */
    public String f69154e;

    /* renamed from: f  reason: collision with root package name */
    public String f69155f;

    /* renamed from: g  reason: collision with root package name */
    public String f69156g;

    /* renamed from: h  reason: collision with root package name */
    public int f69157h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69158i;

    public f() {
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
        this.f69158i = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.a4;
        if (i2 == 3) {
            this.f69150a = "apk_download";
            this.f69155f = advertAppInfo.d4;
            this.f69156g = advertAppInfo.c4;
        } else if (i2 == 1) {
            this.f69150a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f69154e = adCard.getButtonText();
        this.f69151b = adCard.userName;
        this.f69152c = adCard.userImage;
        this.f69153d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f69150a = jSONObject.optString("style");
        this.f69151b = jSONObject.optString("user_name");
        this.f69152c = jSONObject.optString("user_portrait");
        this.f69153d = jSONObject.optString("scheme");
        this.f69154e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f69157h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f69155f = optJSONObject.optString("pkgname");
            this.f69156g = optJSONObject.optString("download_url");
        }
        this.f69158i = true;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.f69150a);
                jSONObject.put("user_name", this.f69151b);
                jSONObject.put("user_portrait", this.f69152c);
                jSONObject.put("scheme", this.f69153d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f69154e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f69155f);
                jSONObject2.put("download_url", this.f69156g);
                jSONObject.put("ext_data", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.f69150a);
                jSONObject.put("user_name", this.f69151b);
                jSONObject.put("user_portrait", this.f69152c);
                jSONObject.put("scheme", this.f69153d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f69154e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f69155f);
                jSONObject2.put("download_url", this.f69156g);
                jSONObject.put("ext_data", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
