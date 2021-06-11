package d.a.f0.a.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import d.a.d0.b.g.e;
import d.a.f0.a.k.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f43525a;

    public a(Context context) {
        this.f43525a = context;
    }

    public final void a(RelativeLayout.LayoutParams layoutParams, int i2, int i3, int i4) {
        if ((i2 & i3) == i3) {
            layoutParams.addRule(i4);
        }
    }

    public final int b(JSONObject jSONObject) {
        return jSONObject.optInt("l_gravity");
    }

    public final int[] c(JSONObject jSONObject) {
        int[] iArr = {0, 0, 0, 0};
        String optString = jSONObject.optString("margin");
        boolean z = jSONObject.optInt("is_equal_bottom_logo", 0) == 1;
        if (!TextUtils.isEmpty(optString)) {
            String[] split = optString.split("_");
            if (split.length == 4) {
                for (int i2 = 0; i2 < 4; i2++) {
                    try {
                        iArr[i2] = Integer.parseInt(split[i2]);
                    } catch (Exception unused) {
                        iArr[i2] = 0;
                    }
                    if (i2 == 3 && z) {
                        iArr[i2] = iArr[i2] + e.b();
                    }
                }
            }
        }
        return iArr;
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 > 0) {
            a(layoutParams, i2, 1, 10);
            a(layoutParams, i2, 2, 12);
            a(layoutParams, i2, 4, 9);
            a(layoutParams, i2, 8, 11);
            a(layoutParams, i2, 16, 14);
            a(layoutParams, i2, 32, 15);
        }
    }

    public final void e(ViewGroup.MarginLayoutParams marginLayoutParams, int[] iArr) {
        if (iArr == null || iArr.length != 4) {
            return;
        }
        marginLayoutParams.setMargins(h.a(this.f43525a, iArr[0]), h.a(this.f43525a, iArr[1]), h.a(this.f43525a, iArr[2]), h.a(this.f43525a, iArr[3]));
    }

    public final void f(RelativeLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        if (jSONObject != null) {
            d(layoutParams, b(jSONObject));
            e(layoutParams, c(jSONObject));
        }
    }

    public void g(ViewGroup.LayoutParams layoutParams, JSONObject jSONObject) {
        if (layoutParams == null || jSONObject == null || !(layoutParams instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        f((RelativeLayout.LayoutParams) layoutParams, jSONObject);
    }
}
