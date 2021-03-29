package d.b.g0.a.t1.k.f0;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.b.g0.a.t1.j;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f46322e = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";

    /* renamed from: f  reason: collision with root package name */
    public static final String f46323f = SchemeConfig.getSchemeHead() + "://swangame/%s";

    public e(j jVar) {
        super(jVar, "/swanAPI/getFavor");
    }

    @Override // d.b.g0.a.t1.k.f0.b
    public boolean j(d.b.g0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        return true;
    }

    @Override // d.b.g0.a.t1.k.f0.b
    public void k(d.b.g0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONArray jSONArray = new JSONArray();
        List<SwanFavorItemData> j = SwanFavorDataManager.i().j();
        if (j.size() > 0) {
            for (SwanFavorItemData swanFavorItemData : j) {
                jSONArray.put(l(swanFavorItemData));
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("favors", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    public final JSONObject l(SwanFavorItemData swanFavorItemData) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", swanFavorItemData.getAppKey());
            jSONObject.put("type", swanFavorItemData.getAppType());
            jSONObject.put("iconUrl", swanFavorItemData.getIconUrl());
            jSONObject.put("title", swanFavorItemData.getAppName());
            jSONObject.put("frameType", swanFavorItemData.getAppFrameType());
            if (swanFavorItemData.getAppFrameType() == 1) {
                str = String.format(f46323f, swanFavorItemData.getAppKey());
            } else {
                str = f46322e + swanFavorItemData.getAppKey() + "\"}";
            }
            jSONObject.put("scheme", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
