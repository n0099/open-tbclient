package d.a.j0.b0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f48885a;

    /* renamed from: b  reason: collision with root package name */
    public int f48886b;

    /* renamed from: c  reason: collision with root package name */
    public int f48887c;

    /* renamed from: d  reason: collision with root package name */
    public String f48888d;

    /* renamed from: e  reason: collision with root package name */
    public String f48889e;

    /* renamed from: f  reason: collision with root package name */
    public String f48890f;

    /* renamed from: g  reason: collision with root package name */
    public String f48891g;

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.f48885a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.f48886b = jSONObject.optInt("width");
            cVar.f48887c = jSONObject.optInt("height");
            cVar.f48888d = jSONObject.optString("pic_url");
            cVar.f48889e = jSONObject.optString("thumbnail");
            cVar.f48891g = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
