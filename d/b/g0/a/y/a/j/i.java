package d.b.g0.a.y.a.j;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f46994a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f46995b;

    /* renamed from: c  reason: collision with root package name */
    public Shader f46996c;

    public i(JSONArray jSONArray) {
        e(jSONArray);
    }

    public int a() {
        return this.f46995b;
    }

    public Shader b() {
        return this.f46996c;
    }

    public boolean c() {
        return TextUtils.equals(this.f46994a, "linearGradient") || TextUtils.equals(this.f46994a, "circularGradient");
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f46994a);
    }

    public void e(JSONArray jSONArray) {
        float[] fArr;
        int length;
        int i = 0;
        try {
            String optString = jSONArray.optString(0);
            int i2 = 4;
            int i3 = 1;
            if (TextUtils.equals(optString, "normal")) {
                JSONArray optJSONArray = jSONArray.optJSONArray(1);
                if (optJSONArray.length() == 4) {
                    this.f46995b = Color.argb(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                    this.f46994a = "normal";
                }
            } else if (TextUtils.equals(optString, "linearGradient") || TextUtils.equals(optString, "circularGradient")) {
                JSONArray optJSONArray2 = jSONArray.optJSONArray(1);
                int[] iArr = null;
                if (optJSONArray2 == null || (length = optJSONArray2.length()) <= 0) {
                    fArr = null;
                } else {
                    iArr = new int[length];
                    fArr = new float[length];
                    int i4 = 0;
                    while (i4 < length) {
                        JSONObject optJSONObject = optJSONArray2.optJSONObject(i4);
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("color");
                        if (optJSONArray3.length() == i2) {
                            iArr[i4] = Color.argb(optJSONArray3.optInt(3), optJSONArray3.optInt(i), optJSONArray3.optInt(i3), optJSONArray3.optInt(2));
                        }
                        fArr[i4] = (float) optJSONObject.optDouble(IntentConfig.STOP);
                        i4++;
                        i = 0;
                        i2 = 4;
                        i3 = 1;
                    }
                }
                if (iArr != null && fArr != null && iArr.length >= 2 && iArr.length == fArr.length) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(2);
                    if (TextUtils.equals(optString, "linearGradient")) {
                        this.f46996c = new LinearGradient(d.b.g0.a.i2.h0.f(optJSONObject2.optInt("x0")), d.b.g0.a.i2.h0.f(optJSONObject2.optInt("y0")), d.b.g0.a.i2.h0.f(optJSONObject2.optInt("x1")), d.b.g0.a.i2.h0.f(optJSONObject2.optInt("y1")), iArr, fArr, Shader.TileMode.CLAMP);
                        this.f46994a = "linearGradient";
                        return;
                    }
                    this.f46996c = new RadialGradient(d.b.g0.a.i2.h0.f(optJSONObject2.optInt("x")), d.b.g0.a.i2.h0.f(optJSONObject2.optInt("y")), d.b.g0.a.i2.h0.f(optJSONObject2.optInt(com.baidu.mapsdkplatform.comapi.map.r.f7664a)), iArr, fArr, Shader.TileMode.CLAMP);
                    this.f46994a = "circularGradient";
                }
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45051a) {
                e2.printStackTrace();
            }
        }
    }
}
