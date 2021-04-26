package d.a.h0.a.y.b;

import androidx.core.graphics.TypefaceCompatApi28Impl;
import d.a.h0.a.i2.h0;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {
    public String o;
    public String p;
    public float q;
    public boolean r;
    public boolean s;

    public d(String str) {
        super(str);
        String[] split;
        this.p = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
        this.q = h0.f(10.0f);
        this.r = false;
        this.s = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.o = jSONObject.optString("text");
            String optString = jSONObject.optString("font");
            if (optString == null || optString.length() <= 0) {
                return;
            }
            for (String str2 : optString.split(" ")) {
                if (str2.contains("italic")) {
                    this.s = true;
                } else if (str2.contains("oblique")) {
                    this.s = true;
                } else if (str2.contains("bold")) {
                    this.r = true;
                } else if (!str2.contains("normal")) {
                    if (Character.isDigit(str2.charAt(0))) {
                        int length = str2.length();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= str2.length()) {
                                break;
                            } else if (!Character.isDigit(str2.charAt(i2))) {
                                length = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        this.q = h0.f(Float.parseFloat(str2.substring(0, length)));
                    } else {
                        this.p = str2;
                    }
                }
            }
        } catch (Exception e2) {
            if (k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
