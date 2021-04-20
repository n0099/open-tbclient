package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class i0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f47389a = 0;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        bVar.o = this.f47389a;
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "top")) {
                    this.f47389a = 1;
                } else if (TextUtils.equals(optString, "middle")) {
                    this.f47389a = 2;
                } else if (TextUtils.equals(optString, TipsConfigItem.TipConfigData.BOTTOM)) {
                    this.f47389a = 3;
                } else {
                    this.f47389a = 0;
                }
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45443a) {
                e2.printStackTrace();
            }
        }
    }
}
