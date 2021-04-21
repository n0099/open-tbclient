package d.b.j0.s.b.l;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import d.b.c.e.p.k;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e extends a0 {
    public e(j jVar) {
        super(jVar, "/swan/publishThread");
    }

    public static boolean j(Context context, String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("path");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("appid");
                if (StringUtils.isNull(optString2)) {
                    return false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, d.b.j0.s.a.a(optString2, "", "", 0)));
                return true;
            }
            String substring = optString.substring(39);
            if (StringUtils.isNull(substring)) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject(k.getUrlDecode(substring));
            String optString3 = jSONObject2.optString("third_app_id");
            String optString4 = jSONObject2.optString("third_app_name");
            String optString5 = jSONObject2.optString("third_app_pic");
            String optString6 = jSONObject2.optString("third_app_link");
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(context, 10086);
            selectForumActivityConfig.setAiAppsParams(optString3, optString4, optString5, null, null, optString6);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        j(context, unitedSchemeEntity.getParam("params"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
