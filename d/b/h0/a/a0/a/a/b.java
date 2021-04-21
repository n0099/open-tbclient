package d.b.h0.a.a0.a.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.i2.h0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.a0.a.c.b {
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public String L;
    public boolean M;
    public int N;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.L = "";
    }

    private void i() {
        JSONObject jSONObject = this.n;
        if (jSONObject != null) {
            this.y = SwanAppConfigData.s(jSONObject.optString("color"));
            this.z = true;
        }
    }

    @Override // d.b.h0.a.a0.a.c.b, d.b.h0.a.a0.a.d.b, d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.G = jSONObject.optInt("maxLength");
        this.H = k(jSONObject);
        this.I = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR);
        this.J = jSONObject.optInt("selectionStart");
        this.K = jSONObject.optInt("selectionEnd");
        this.L = jSONObject.optString("confirmType");
        this.M = jSONObject.optInt("password") == 1;
        i();
    }

    @Override // d.b.h0.a.a0.a.c.b, d.b.h0.a.a0.a.d.b, d.b.h0.a.a0.b.b
    public void g(JSONObject jSONObject) {
        super.g(jSONObject);
        if (!TextUtils.isEmpty(jSONObject.optString("cursorSpacing"))) {
            this.H = k(jSONObject);
        }
        this.G = jSONObject.optInt("maxLength", this.G);
        this.I = jSONObject.optInt(Constants.EXTRA_CONFIG_CURSOR, this.I);
        this.J = jSONObject.optInt("selectionStart", this.J);
        this.K = jSONObject.optInt("selectionEnd", this.K);
        this.L = jSONObject.optString("confirmType", this.L);
        this.M = jSONObject.optInt("password", this.M ? 1 : 0) == 1;
        i();
    }

    public final int k(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("cursorSpacing");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        if (optString.endsWith("rpx")) {
            try {
                return h0.f(Integer.parseInt(optString.replace("rpx", "")));
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        try {
            return Integer.parseInt(optString.replace("px", ""));
        } catch (NumberFormatException unused2) {
            return 0;
        }
    }

    public void l(int i, int i2) {
        this.J = i;
        this.K = i2;
    }

    public void m(int i) {
        this.N = i;
    }
}
