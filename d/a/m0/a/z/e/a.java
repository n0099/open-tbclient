package d.a.m0.a.z.e;

import android.text.TextUtils;
import com.alipay.sdk.widget.j;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import d.a.m0.a.e0.d;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.m0.a.c0.b.b {
    public String n;
    public String o;

    /* renamed from: d.a.m0.a.z.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0986a {
        public static String a(String str) {
            char c2;
            int hashCode = str.hashCode();
            if (hashCode == 3551) {
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 109935) {
                if (hashCode == 3005871 && str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            return (c2 == 0 || c2 == 1 || c2 == 2) ? str : DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
        }
    }

    public a(String str) {
        super(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, "cameraId");
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            d.c("Camera", "parsing CameraAttrModel occurs exception", e2);
        }
    }

    @Override // d.a.m0.a.c0.b.b, d.a.m0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        this.n = jSONObject.optString("devicePosition", j.j);
        this.o = jSONObject.optString("flash", DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
    }

    public String h() {
        return C0986a.a(this.o);
    }

    public int i() {
        d.a.m0.a.l1.e.a.a aVar = this.l;
        if (aVar == null) {
            return 0;
        }
        return aVar.d();
    }

    public int j() {
        d.a.m0.a.l1.e.a.a aVar = this.l;
        if (aVar == null) {
            return 0;
        }
        return aVar.g();
    }

    public boolean k() {
        return TextUtils.equals(this.n, "front");
    }
}
