package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f45184a = TypefaceCompatApi28Impl.DEFAULT_FAMILY;

    /* renamed from: b  reason: collision with root package name */
    public float f45185b = d.a.h0.a.i2.h0.f(10.0f);

    /* renamed from: c  reason: collision with root package name */
    public boolean f45186c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45187d = false;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2;
        if (this.f45186c && this.f45187d) {
            i2 = 3;
        } else if (this.f45186c) {
            i2 = 1;
        } else {
            i2 = this.f45187d ? 2 : 0;
        }
        bVar.f45126i.setTypeface(Typeface.create(this.f45184a, i2));
        bVar.f45126i.setTextSize(this.f45185b);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        String[] split;
        try {
            if (jSONArray.length() > 0) {
                for (String str : jSONArray.optString(0).split(" ")) {
                    if (str.contains("italic")) {
                        this.f45187d = true;
                    } else if (str.contains("oblique")) {
                        this.f45187d = true;
                    } else if (str.contains("bold")) {
                        this.f45186c = true;
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
                            this.f45185b = d.a.h0.a.i2.h0.f(Float.parseFloat(str.substring(0, length)));
                        } else {
                            this.f45184a = str;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
