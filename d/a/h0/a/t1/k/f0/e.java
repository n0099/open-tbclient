package d.a.h0.a.t1.k.f0;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.a.h0.a.t1.j;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f44433e = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";

    /* renamed from: f  reason: collision with root package name */
    public static final String f44434f = SchemeConfig.getSchemeHead() + "://swangame/%s";

    public e(j jVar) {
        super(jVar, "/swanAPI/getFavor");
    }

    @Override // d.a.h0.a.t1.k.f0.b
    public boolean j(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        return true;
    }

    @Override // d.a.h0.a.t1.k.f0.b
    public void k(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
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
                str = String.format(f44434f, swanFavorItemData.getAppKey());
            } else {
                str = f44433e + swanFavorItemData.getAppKey() + "\"}";
            }
            jSONObject.put("scheme", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
