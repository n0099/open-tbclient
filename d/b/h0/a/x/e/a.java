package d.b.h0.a.x.e;

import android.text.TextUtils;
import com.alipay.sdk.widget.j;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.h0.a.a0.b.b {
    public String n;
    public String o;
    public String p;

    /* renamed from: d.b.h0.a.x.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0911a {
        public static String a(String str) {
            char c2;
            int hashCode = str.hashCode();
            if (hashCode == 3551) {
                if (str.equals("on")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 109935) {
                if (hashCode == 3005871 && str.equals("auto")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("off")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            return (c2 == 0 || c2 == 1 || c2 == 2) ? str : "auto";
        }
    }

    public a(String str) {
        super(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, "cameraId");
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            d.b.h0.a.c0.c.c("Camera", "parsing CameraAttrModel occurs exception", e2);
        }
    }

    @Override // d.b.h0.a.a0.b.b, d.b.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        this.n = jSONObject.optString("devicePosition", j.j);
        this.o = jSONObject.optString("flash", "auto");
        this.p = jSONObject.optString("cameraId");
    }

    public String h() {
        return C0911a.a(this.o);
    }

    public int i() {
        d.b.h0.a.e1.d.a.a aVar = this.l;
        if (aVar == null) {
            return 0;
        }
        return aVar.d();
    }

    public int j() {
        d.b.h0.a.e1.d.a.a aVar = this.l;
        if (aVar == null) {
            return 0;
        }
        return aVar.g();
    }

    public boolean k() {
        return TextUtils.equals(this.n, "front");
    }
}
