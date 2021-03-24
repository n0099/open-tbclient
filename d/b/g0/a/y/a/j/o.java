package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f47028a = "sans-serif";

    /* renamed from: b  reason: collision with root package name */
    public float f47029b = d.b.g0.a.i2.h0.f(10.0f);

    /* renamed from: c  reason: collision with root package name */
    public boolean f47030c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47031d = false;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i;
        if (this.f47030c && this.f47031d) {
            i = 3;
        } else if (this.f47030c) {
            i = 1;
        } else {
            i = this.f47031d ? 2 : 0;
        }
        bVar.i.setTypeface(Typeface.create(this.f47028a, i));
        bVar.i.setTextSize(this.f47029b);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.f47031d = true;
                    } else if (str.contains("oblique")) {
                        this.f47031d = true;
                    } else if (str.contains("bold")) {
                        this.f47030c = true;
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
                            this.f47029b = d.b.g0.a.i2.h0.f(Float.parseFloat(str.substring(0, length)));
                        } else {
                            this.f47028a = str;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
