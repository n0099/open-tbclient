package d.b.i0.b0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f50503a;

    /* renamed from: b  reason: collision with root package name */
    public int f50504b;

    /* renamed from: c  reason: collision with root package name */
    public int f50505c;

    /* renamed from: d  reason: collision with root package name */
    public String f50506d;

    /* renamed from: e  reason: collision with root package name */
    public String f50507e;

    /* renamed from: f  reason: collision with root package name */
    public String f50508f;

    /* renamed from: g  reason: collision with root package name */
    public String f50509g;

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.f50503a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.f50504b = jSONObject.optInt("width");
            cVar.f50505c = jSONObject.optInt("height");
            cVar.f50506d = jSONObject.optString("pic_url");
            cVar.f50507e = jSONObject.optString("thumbnail");
            cVar.f50509g = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
