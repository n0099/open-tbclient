package d.a.m0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.m0.n.j.a {
    @Override // d.a.m0.n.j.a, d.a.m0.n.j.d
    public void b(JSONObject jSONObject, d.a.m0.n.f.g gVar, @Nullable d.a.m0.n.f.g gVar2, @Nullable d.a.m0.n.f.g gVar3) {
        if (jSONObject == null) {
            return;
        }
        if (d.a.m0.n.c.f51766a) {
            Log.d("CommonNodeProcessor", WebGLImageLoader.DATA_URL + jSONObject);
        }
        f.b().e(jSONObject.optJSONObject("tipmsgs"));
        i.b().g(jSONObject.optJSONObject("page_tips"));
        b.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        k.a().d(jSONObject.optJSONObject("pkg_preload"));
        e.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        n.b().d(jSONObject.optJSONObject("tts"));
        o.e(jSONObject.optJSONObject("update_expire_time"));
        if (l.f51936a) {
            c(jSONObject);
        }
        g.a().c(jSONObject.optJSONObject("local_debug"));
        d.a.m0.n.c.a().b(jSONObject.optJSONObject(d.a.m0.n.c.a().c()));
        if (m.b()) {
            h.a().b(jSONObject.optJSONObject("api_description"));
        }
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("heartbeat");
        if (optJSONObject != null) {
            long optLong = optJSONObject.optLong("errno");
            if (optLong != 0) {
                if (d.a.m0.n.c.f51766a) {
                    Log.d("CommonNodeProcessor", "heartbeat error:" + optLong);
                    return;
                }
                return;
            }
            d.a.m0.n.a b2 = d.a.m0.n.c.b();
            d.a.m0.t.b j = b2 != null ? b2.j() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                l.f51937b = optString;
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
                    l.f51936a = false;
                }
            }
            if (d.a.m0.n.c.f51766a) {
                Log.d("CommonNodeProcessor", "heartBeatVersion=" + optString + ", data=" + optJSONObject2);
            }
        }
    }
}
