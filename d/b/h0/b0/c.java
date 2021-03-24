package d.b.h0.b0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f49773a;

    /* renamed from: b  reason: collision with root package name */
    public int f49774b;

    /* renamed from: c  reason: collision with root package name */
    public int f49775c;

    /* renamed from: d  reason: collision with root package name */
    public String f49776d;

    /* renamed from: e  reason: collision with root package name */
    public String f49777e;

    /* renamed from: f  reason: collision with root package name */
    public String f49778f;

    /* renamed from: g  reason: collision with root package name */
    public String f49779g;

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.f49773a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.f49774b = jSONObject.optInt("width");
            cVar.f49775c = jSONObject.optInt("height");
            cVar.f49776d = jSONObject.optString("pic_url");
            cVar.f49777e = jSONObject.optString("thumbnail");
            cVar.f49779g = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
