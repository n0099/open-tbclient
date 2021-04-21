package d.b.h0.a.y.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.i2.h0;
import d.b.h0.a.t1.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a {
    public e(j jVar) {
        super(jVar, "/swanAPI/canvas/measureTextSync");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        int i;
        int i2;
        unitedSchemeEntity.result = l(201);
        d.b.h0.a.y.b.d m = m(unitedSchemeEntity);
        if (m == null) {
            return false;
        }
        String str = m.o;
        if (str == null || str.length() <= 0) {
            i = 0;
        } else {
            if (m.r && m.s) {
                i2 = 3;
            } else if (m.r) {
                i2 = 1;
            } else {
                i2 = m.s ? 2 : 0;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.create(m.p, i2));
            textPaint.setTextSize(m.q);
            Rect rect = new Rect();
            String str2 = m.o;
            textPaint.getTextBounds(str2, 0, str2.length(), rect);
            i = h0.H(rect.width());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("width", Integer.valueOf(i));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
        return true;
    }

    public d.b.h0.a.y.b.d m(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new d.b.h0.a.y.b.d(str);
    }
}
