package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f47750a = "sans-serif";

    /* renamed from: b  reason: collision with root package name */
    public float f47751b = d.b.h0.a.i2.h0.f(10.0f);

    /* renamed from: c  reason: collision with root package name */
    public boolean f47752c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47753d = false;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i;
        if (this.f47752c && this.f47753d) {
            i = 3;
        } else if (this.f47752c) {
            i = 1;
        } else {
            i = this.f47753d ? 2 : 0;
        }
        bVar.i.setTypeface(Typeface.create(this.f47750a, i));
        bVar.i.setTextSize(this.f47751b);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.f47753d = true;
                    } else if (str.contains("oblique")) {
                        this.f47753d = true;
                    } else if (str.contains("bold")) {
                        this.f47752c = true;
                    } else if (!str.contains("normal")) {
                        if (Character.isDigit(str.charAt(0))) {
                            int length = str.length();
                            int i = 0;
                            while (true) {
                                if (i >= str.length()) {
                                    break;
                                } else if (!Character.isDigit(str.charAt(i))) {
                                    length = i;
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            this.f47751b = d.b.h0.a.i2.h0.f(Float.parseFloat(str.substring(0, length)));
                        } else {
                            this.f47750a = str;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
