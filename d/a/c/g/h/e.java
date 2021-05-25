package d.a.c.g.h;

import android.text.TextUtils;
import java.util.AbstractMap;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f39053a = false;

    public abstract String a();

    public void b(int i2) {
        if (this.f39053a) {
            return;
        }
        this.f39053a = true;
        if (TextUtils.isEmpty(a())) {
            return;
        }
        try {
            new JSONObject().put("version", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void c(int i2, long j) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(j)));
        String str = a2 + "_download";
        if (i2 == 0) {
            d.c(str, arrayList);
        } else {
            d.b(str, arrayList);
        }
    }

    public void d(int i2, int i3) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(i3)));
        String str = a2 + "_install";
        if (i2 == 13) {
            d.c(str, arrayList);
        } else {
            d.b(str, arrayList);
        }
    }

    public void e(int i2, int i3) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AbstractMap.SimpleEntry("version", String.valueOf(i3)));
        String str = a2 + "_launch";
        if (i2 == 14) {
            d.c(str, arrayList);
        } else {
            d.b(str, arrayList);
        }
    }
}
