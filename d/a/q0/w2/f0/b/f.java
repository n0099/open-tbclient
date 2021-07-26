package d.a.q0.w2.f0.b;

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
    public String f66597a;

    /* renamed from: b  reason: collision with root package name */
    public String f66598b;

    /* renamed from: c  reason: collision with root package name */
    public String f66599c;

    /* renamed from: d  reason: collision with root package name */
    public String f66600d;

    /* renamed from: e  reason: collision with root package name */
    public String f66601e;

    /* renamed from: f  reason: collision with root package name */
    public String f66602f;

    /* renamed from: g  reason: collision with root package name */
    public String f66603g;

    /* renamed from: h  reason: collision with root package name */
    public int f66604h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66605i;

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
        this.f66605i = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.g4;
        if (i2 == 3) {
            this.f66597a = "apk_download";
            this.f66602f = advertAppInfo.j4;
            this.f66603g = advertAppInfo.i4;
        } else if (i2 == 1) {
            this.f66597a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f66601e = adCard.getButtonText();
        this.f66598b = adCard.userName;
        this.f66599c = adCard.userImage;
        this.f66600d = adCard.scheme;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f66597a = jSONObject.optString("style");
        this.f66598b = jSONObject.optString("user_name");
        this.f66599c = jSONObject.optString("user_portrait");
        this.f66600d = jSONObject.optString("scheme");
        this.f66601e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f66604h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f66602f = optJSONObject.optString("pkgname");
            this.f66603g = optJSONObject.optString("download_url");
        }
        this.f66605i = true;
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
                jSONObject.put("style", this.f66597a);
                jSONObject.put("user_name", this.f66598b);
                jSONObject.put("user_portrait", this.f66599c);
                jSONObject.put("scheme", this.f66600d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f66601e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f66602f);
                jSONObject2.put("download_url", this.f66603g);
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
                jSONObject.put("style", this.f66597a);
                jSONObject.put("user_name", this.f66598b);
                jSONObject.put("user_portrait", this.f66599c);
                jSONObject.put("scheme", this.f66600d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f66601e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f66602f);
                jSONObject2.put("download_url", this.f66603g);
                jSONObject.put("ext_data", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
