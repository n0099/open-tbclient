package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f40648a = TypefaceCompatApi28Impl.DEFAULT_FAMILY;

    /* renamed from: b  reason: collision with root package name */
    public float f40649b = d.a.l0.a.v2.n0.g(10.0f);

    /* renamed from: c  reason: collision with root package name */
    public boolean f40650c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40651d = false;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        if (this.f40650c && this.f40651d) {
            i2 = 3;
        } else if (this.f40650c) {
            i2 = 1;
        } else {
            i2 = this.f40651d ? 2 : 0;
        }
        bVar.f40590i.setTypeface(Typeface.create(this.f40648a, i2));
        bVar.f40590i.setTextSize(this.f40649b);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.f40651d = true;
                    } else if (str.contains("oblique")) {
                        this.f40651d = true;
                    } else if (str.contains("bold")) {
                        this.f40650c = true;
                    } else if (!str.contains("normal")) {
                        if (Character.isDigit(str.charAt(0))) {
                            int length = str.length();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= str.length()) {
                                    break;
                                } else if (!Character.isDigit(str.charAt(i2))) {
                                    length = i2;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            this.f40649b = d.a.l0.a.v2.n0.g(Float.parseFloat(str.substring(0, length)));
                        } else {
                            this.f40648a = str;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
    }
}
