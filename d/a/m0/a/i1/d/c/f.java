package d.a.m0.a.i1.d.c;

import com.alipay.sdk.widget.j;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public String f46665c;

    /* renamed from: a  reason: collision with root package name */
    public int f46663a = 3;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46664b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f46666d = j.j;

    /* renamed from: e  reason: collision with root package name */
    public int f46667e = 60;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
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
                        i2 |= 1;
                    } else if (c2 == 1) {
                        i2 |= 2;
                    }
                }
                fVar.f46663a = i2;
            }
            fVar.f46664b = jSONObject.optBoolean("compressed", true);
            int optInt = jSONObject.optInt("maxDuration", 60);
            fVar.f46667e = optInt <= 60 ? optInt : 60;
            fVar.f46666d = jSONObject.optString(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA);
            fVar.f46665c = jSONObject.optString("cb");
        }
        return fVar;
    }
}
