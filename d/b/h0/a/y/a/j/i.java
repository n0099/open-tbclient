package d.b.h0.a.y.a.j;

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
    public String f47715a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f47716b;

    /* renamed from: c  reason: collision with root package name */
    public Shader f47717c;

    public i(JSONArray jSONArray) {
        e(jSONArray);
    }

    public int a() {
        return this.f47716b;
    }

    public Shader b() {
        return this.f47717c;
    }

    public boolean c() {
        return TextUtils.equals(this.f47715a, "linearGradient") || TextUtils.equals(this.f47715a, "circularGradient");
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f47715a);
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
                    this.f47716b = Color.argb(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                    this.f47715a = "normal";
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
                        this.f47717c = new LinearGradient(d.b.h0.a.i2.h0.f(optJSONObject2.optInt("x0")), d.b.h0.a.i2.h0.f(optJSONObject2.optInt("y0")), d.b.h0.a.i2.h0.f(optJSONObject2.optInt("x1")), d.b.h0.a.i2.h0.f(optJSONObject2.optInt("y1")), iArr, fArr, Shader.TileMode.CLAMP);
                        this.f47715a = "linearGradient";
                        return;
                    }
                    this.f47717c = new RadialGradient(d.b.h0.a.i2.h0.f(optJSONObject2.optInt("x")), d.b.h0.a.i2.h0.f(optJSONObject2.optInt("y")), d.b.h0.a.i2.h0.f(optJSONObject2.optInt(com.baidu.mapsdkplatform.comapi.map.r.f7699a)), iArr, fArr, Shader.TileMode.CLAMP);
                    this.f47715a = "circularGradient";
                }
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
