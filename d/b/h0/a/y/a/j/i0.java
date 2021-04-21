package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class i0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f47718a = 0;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        bVar.o = this.f47718a;
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "top")) {
                    this.f47718a = 1;
                } else if (TextUtils.equals(optString, "middle")) {
                    this.f47718a = 2;
                } else if (TextUtils.equals(optString, TipsConfigItem.TipConfigData.BOTTOM)) {
                    this.f47718a = 3;
                } else {
                    this.f47718a = 0;
                }
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
