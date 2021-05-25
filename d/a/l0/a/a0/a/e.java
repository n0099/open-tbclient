package d.a.l0.a.a0.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a {
    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/canvas/measureTextSync");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        int i2;
        int i3;
        unitedSchemeEntity.result = l(201);
        d.a.l0.a.a0.b.d m = m(unitedSchemeEntity);
        if (m == null) {
            return false;
        }
        String str = m.o;
        if (str == null || str.length() <= 0) {
            i2 = 0;
        } else {
            if (m.r && m.s) {
                i3 = 3;
            } else if (m.r) {
                i3 = 1;
            } else {
                i3 = m.s ? 2 : 0;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.create(m.p, i3));
            textPaint.setTextSize(m.q);
            Rect rect = new Rect();
            String str2 = m.o;
            textPaint.getTextBounds(str2, 0, str2.length(), rect);
            i2 = n0.K(rect.width());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("width", Integer.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        return true;
    }

    public d.a.l0.a.a0.b.d m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.a.l0.a.a0.b.d(str);
    }
}
