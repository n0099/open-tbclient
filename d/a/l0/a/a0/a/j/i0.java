package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class i0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f44291a = 0;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        bVar.o = this.f44291a;
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                String optString = jSONArray.optString(0);
                if (TextUtils.equals(optString, "top")) {
                    this.f44291a = 1;
                } else if (TextUtils.equals(optString, "middle")) {
                    this.f44291a = 2;
                } else if (TextUtils.equals(optString, TipsConfigItem.TipConfigData.BOTTOM)) {
                    this.f44291a = 3;
                } else {
                    this.f44291a = 0;
                }
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }
}
