package d.b.g0.a.y.b;

import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a {
    public String o;
    public String p;
    public float q;
    public boolean r;
    public boolean s;

    public d(String str) {
        super(str);
        String[] split;
        this.p = "sans-serif";
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
                        int i = 0;
                        while (true) {
                            if (i >= str2.length()) {
                                break;
                            } else if (!Character.isDigit(str2.charAt(i))) {
                                length = i;
                                break;
                            } else {
                                i++;
                            }
                        }
                        this.q = h0.f(Float.parseFloat(str2.substring(0, length)));
                    } else {
                        this.p = str2;
                    }
                }
            }
        } catch (Exception e2) {
            if (k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
