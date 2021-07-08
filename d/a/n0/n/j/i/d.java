package d.a.n0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.n0.n.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // d.a.n0.n.j.a, d.a.n0.n.j.d
    public void b(JSONObject jSONObject, d.a.n0.n.f.g gVar, @Nullable d.a.n0.n.f.g gVar2, @Nullable d.a.n0.n.f.g gVar3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, gVar, gVar2, gVar3) == null) || jSONObject == null) {
            return;
        }
        if (d.a.n0.n.c.f50608a) {
            Log.d("CommonNodeProcessor", WebGLImageLoader.DATA_URL + jSONObject);
        }
        f.b().e(jSONObject.optJSONObject("tipmsgs"));
        i.b().g(jSONObject.optJSONObject("page_tips"));
        b.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        k.a().d(jSONObject.optJSONObject("pkg_preload"));
        e.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        n.b().d(jSONObject.optJSONObject("tts"));
        o.e(jSONObject.optJSONObject("update_expire_time"));
        if (l.f50778a) {
            c(jSONObject);
        }
        g.a().c(jSONObject.optJSONObject("local_debug"));
        d.a.n0.n.c.a().b(jSONObject.optJSONObject(d.a.n0.n.c.a().c()));
        if (m.b()) {
            h.a().b(jSONObject.optJSONObject("api_description"));
        }
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("heartbeat")) == null) {
            return;
        }
        long optLong = optJSONObject.optLong("errno");
        if (optLong != 0) {
            if (d.a.n0.n.c.f50608a) {
                Log.d("CommonNodeProcessor", "heartbeat error:" + optLong);
                return;
            }
            return;
        }
        d.a.n0.n.a b2 = d.a.n0.n.c.b();
        d.a.n0.t.b j = b2 != null ? b2.j() : null;
        String optString = optJSONObject.optString("version");
        if (!TextUtils.isEmpty(optString)) {
            l.f50779b = optString;
            if (j != null) {
                j.putString("key_h2_heart_beat_version", optString);
            }
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
                int optInt = optJSONObject2.optInt("timespan");
                int optInt2 = optJSONObject2.optInt("timeout");
                if (j != null) {
                    if (optInt > 0) {
                        j.putInt("key_h2_heart_beat_timespan", optInt);
                    }
                    if (optInt2 > 0) {
                        j.putInt("key_h2_heart_beat_timeout", optInt2);
                    }
                }
            } else {
                l.f50778a = false;
            }
        }
        if (d.a.n0.n.c.f50608a) {
            Log.d("CommonNodeProcessor", "heartBeatVersion=" + optString + ", data=" + optJSONObject2);
        }
    }
}
