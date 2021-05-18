package d.a.i0.a.z.e;

import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import d.a.i0.a.e0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.i0.a.c0.b.b {
    public String n;

    public c(String str) {
        super(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, "cameraId");
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            d.c("Camera", "parsing CameraTakePhotoModel occurs exception", e2);
        }
    }

    @Override // d.a.i0.a.c0.b.b, d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        this.n = jSONObject.optString("quality");
    }
}
