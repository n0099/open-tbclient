package d.b.g0.a.x.e;

import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.b.g0.a.a0.b.b {
    public String n;
    public String o;

    public c(String str) {
        super(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, "cameraId");
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            d.b.g0.a.c0.c.c("Camera", "parsing CameraTakePhotoModel occurs exception", e2);
        }
    }

    @Override // d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        this.o = jSONObject.optString("cameraId");
        this.n = jSONObject.optString("quality");
    }
}
