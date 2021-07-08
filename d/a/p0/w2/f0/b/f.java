package d.a.p0.w2.f0.b;

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
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65922a;

    /* renamed from: b  reason: collision with root package name */
    public String f65923b;

    /* renamed from: c  reason: collision with root package name */
    public String f65924c;

    /* renamed from: d  reason: collision with root package name */
    public String f65925d;

    /* renamed from: e  reason: collision with root package name */
    public String f65926e;

    /* renamed from: f  reason: collision with root package name */
    public String f65927f;

    /* renamed from: g  reason: collision with root package name */
    public String f65928g;

    /* renamed from: h  reason: collision with root package name */
    public int f65929h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65930i;

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
        this.f65930i = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.a4;
        if (i2 == 3) {
            this.f65922a = "apk_download";
            this.f65927f = advertAppInfo.d4;
            this.f65928g = advertAppInfo.c4;
        } else if (i2 == 1) {
            this.f65922a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f65926e = adCard.getButtonText();
        this.f65923b = adCard.userName;
        this.f65924c = adCard.userImage;
        this.f65925d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f65922a = jSONObject.optString("style");
        this.f65923b = jSONObject.optString("user_name");
        this.f65924c = jSONObject.optString("user_portrait");
        this.f65925d = jSONObject.optString("scheme");
        this.f65926e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f65929h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f65927f = optJSONObject.optString("pkgname");
            this.f65928g = optJSONObject.optString("download_url");
        }
        this.f65930i = true;
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
                jSONObject.put("style", this.f65922a);
                jSONObject.put("user_name", this.f65923b);
                jSONObject.put("user_portrait", this.f65924c);
                jSONObject.put("scheme", this.f65925d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f65926e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f65927f);
                jSONObject2.put("download_url", this.f65928g);
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
                jSONObject.put("style", this.f65922a);
                jSONObject.put("user_name", this.f65923b);
                jSONObject.put("user_portrait", this.f65924c);
                jSONObject.put("scheme", this.f65925d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f65926e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f65927f);
                jSONObject2.put("download_url", this.f65928g);
                jSONObject.put("ext_data", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
