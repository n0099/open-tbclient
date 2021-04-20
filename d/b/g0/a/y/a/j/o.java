package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f47421a = "sans-serif";

    /* renamed from: b  reason: collision with root package name */
    public float f47422b = d.b.g0.a.i2.h0.f(10.0f);

    /* renamed from: c  reason: collision with root package name */
    public boolean f47423c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47424d = false;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i;
        if (this.f47423c && this.f47424d) {
            i = 3;
        } else if (this.f47423c) {
            i = 1;
        } else {
            i = this.f47424d ? 2 : 0;
        }
        bVar.i.setTypeface(Typeface.create(this.f47421a, i));
        bVar.i.setTextSize(this.f47422b);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.f47424d = true;
                    } else if (str.contains("oblique")) {
                        this.f47424d = true;
                    } else if (str.contains("bold")) {
                        this.f47423c = true;
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
                            this.f47422b = d.b.g0.a.i2.h0.f(Float.parseFloat(str.substring(0, length)));
                        } else {
                            this.f47421a = str;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45443a) {
                e2.printStackTrace();
            }
        }
    }
}
