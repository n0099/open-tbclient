package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f44432a = TypefaceCompatApi28Impl.DEFAULT_FAMILY;

    /* renamed from: b  reason: collision with root package name */
    public float f44433b = d.a.m0.a.v2.n0.g(10.0f);

    /* renamed from: c  reason: collision with root package name */
    public boolean f44434c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44435d = false;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        if (this.f44434c && this.f44435d) {
            i2 = 3;
        } else if (this.f44434c) {
            i2 = 1;
        } else {
            i2 = this.f44435d ? 2 : 0;
        }
        bVar.f44374i.setTypeface(Typeface.create(this.f44432a, i2));
        bVar.f44374i.setTextSize(this.f44433b);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.f44435d = true;
                    } else if (str.contains("oblique")) {
                        this.f44435d = true;
                    } else if (str.contains("bold")) {
                        this.f44434c = true;
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
                            this.f44433b = d.a.m0.a.v2.n0.g(Float.parseFloat(str.substring(0, length)));
                        } else {
                            this.f44432a = str;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }
}
