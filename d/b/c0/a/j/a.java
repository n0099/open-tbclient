package d.b.c0.a.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import d.b.a0.b.f.e;
import d.b.c0.a.k.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f43049a;

    public a(Context context) {
        this.f43049a = context;
    }

    public final void a(RelativeLayout.LayoutParams layoutParams, int i, int i2, int i3) {
        if ((i & i2) == i2) {
            layoutParams.addRule(i3);
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
                for (int i = 0; i < 4; i++) {
                    try {
                        iArr[i] = Integer.parseInt(split[i]);
                    } catch (Exception unused) {
                        iArr[i] = 0;
                    }
                    if (i == 3 && z) {
                        iArr[i] = iArr[i] + e.b();
                    }
                }
            }
        }
        return iArr;
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i > 0) {
            a(layoutParams, i, 1, 10);
            a(layoutParams, i, 2, 12);
            a(layoutParams, i, 4, 9);
            a(layoutParams, i, 8, 11);
            a(layoutParams, i, 16, 14);
            a(layoutParams, i, 32, 15);
        }
    }

    public final void e(ViewGroup.MarginLayoutParams marginLayoutParams, int[] iArr) {
        if (iArr == null || iArr.length != 4) {
            return;
        }
        marginLayoutParams.setMargins(h.a(this.f43049a, iArr[0]), h.a(this.f43049a, iArr[1]), h.a(this.f43049a, iArr[2]), h.a(this.f43049a, iArr[3]));
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
