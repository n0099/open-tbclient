package d.b.g0.a.b1.d.c;

import com.alipay.sdk.widget.j;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public String f43835c;

    /* renamed from: a  reason: collision with root package name */
    public int f43833a = 3;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43834b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f43836d = j.j;

    /* renamed from: e  reason: collision with root package name */
    public int f43837e = 60;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = optJSONArray.optString(i2);
                    char c2 = 65535;
                    int hashCode = optString.hashCode();
                    if (hashCode != -1367751899) {
                        if (hashCode == 92896879 && optString.equals("album")) {
                            c2 = 0;
                        }
                    } else if (optString.equals(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA)) {
                        c2 = 1;
                    }
                    if (c2 == 0) {
                        i |= 1;
                    } else if (c2 == 1) {
                        i |= 2;
                    }
                }
                fVar.f43833a = i;
            }
            fVar.f43834b = jSONObject.optBoolean("compressed", true);
            int optInt = jSONObject.optInt("maxDuration", 60);
            fVar.f43837e = optInt <= 60 ? optInt : 60;
            fVar.f43836d = jSONObject.optString(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA);
            fVar.f43835c = jSONObject.optString("cb");
        }
        return fVar;
    }
}
