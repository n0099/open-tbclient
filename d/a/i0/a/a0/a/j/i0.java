package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class i0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f40441a = 0;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        bVar.o = this.f40441a;
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "top")) {
                    this.f40441a = 1;
                } else if (TextUtils.equals(optString, "middle")) {
                    this.f40441a = 2;
                } else if (TextUtils.equals(optString, TipsConfigItem.TipConfigData.BOTTOM)) {
                    this.f40441a = 3;
                } else {
                    this.f40441a = 0;
                }
            }
        } catch (Exception e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }
}
