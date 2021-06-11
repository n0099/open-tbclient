package d.a.l0.a.a0.a.j;

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
    public String f44288a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f44289b;

    /* renamed from: c  reason: collision with root package name */
    public Shader f44290c;

    public i(JSONArray jSONArray) {
        e(jSONArray);
    }

    public int a() {
        return this.f44289b;
    }

    public Shader b() {
        return this.f44290c;
    }

    public boolean c() {
        return TextUtils.equals(this.f44288a, "linearGradient") || TextUtils.equals(this.f44288a, "circularGradient");
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f44288a);
    }

    public void e(JSONArray jSONArray) {
        float[] fArr;
        int length;
        int i2 = 0;
        try {
            String optString = jSONArray.optString(0);
            int i3 = 4;
            int i4 = 1;
            if (TextUtils.equals(optString, "normal")) {
                JSONArray optJSONArray = jSONArray.optJSONArray(1);
                if (optJSONArray.length() == 4) {
                    this.f44289b = Color.argb(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                    this.f44288a = "normal";
                }
            } else if (TextUtils.equals(optString, "linearGradient") || TextUtils.equals(optString, "circularGradient")) {
                JSONArray optJSONArray2 = jSONArray.optJSONArray(1);
                int[] iArr = null;
                if (optJSONArray2 == null || (length = optJSONArray2.length()) <= 0) {
                    fArr = null;
                } else {
                    iArr = new int[length];
                    fArr = new float[length];
                    int i5 = 0;
                    while (i5 < length) {
                        JSONObject optJSONObject = optJSONArray2.optJSONObject(i5);
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("color");
                        if (optJSONArray3.length() == i3) {
                            iArr[i5] = Color.argb(optJSONArray3.optInt(3), optJSONArray3.optInt(i2), optJSONArray3.optInt(i4), optJSONArray3.optInt(2));
                        }
                        fArr[i5] = (float) optJSONObject.optDouble(IntentConfig.STOP);
                        i5++;
                        i2 = 0;
                        i3 = 4;
                        i4 = 1;
                    }
                }
                if (iArr != null && fArr != null && iArr.length >= 2 && iArr.length == fArr.length) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(2);
                    if (TextUtils.equals(optString, "linearGradient")) {
                        this.f44290c = new LinearGradient(d.a.l0.a.v2.n0.g(optJSONObject2.optInt("x0")), d.a.l0.a.v2.n0.g(optJSONObject2.optInt("y0")), d.a.l0.a.v2.n0.g(optJSONObject2.optInt("x1")), d.a.l0.a.v2.n0.g(optJSONObject2.optInt("y1")), iArr, fArr, Shader.TileMode.CLAMP);
                        this.f44288a = "linearGradient";
                        return;
                    }
                    this.f44290c = new RadialGradient(d.a.l0.a.v2.n0.g(optJSONObject2.optInt("x")), d.a.l0.a.v2.n0.g(optJSONObject2.optInt("y")), d.a.l0.a.v2.n0.g(optJSONObject2.optInt(com.baidu.mapsdkplatform.comapi.map.r.f7715a)), iArr, fArr, Shader.TileMode.CLAMP);
                    this.f44288a = "circularGradient";
                }
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }
}
