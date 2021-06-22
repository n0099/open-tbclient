package d.a.n0.b0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f52691a;

    /* renamed from: b  reason: collision with root package name */
    public int f52692b;

    /* renamed from: c  reason: collision with root package name */
    public int f52693c;

    /* renamed from: d  reason: collision with root package name */
    public String f52694d;

    /* renamed from: e  reason: collision with root package name */
    public String f52695e;

    /* renamed from: f  reason: collision with root package name */
    public String f52696f;

    /* renamed from: g  reason: collision with root package name */
    public String f52697g;

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.f52691a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.f52692b = jSONObject.optInt("width");
            cVar.f52693c = jSONObject.optInt("height");
            cVar.f52694d = jSONObject.optString("pic_url");
            cVar.f52695e = jSONObject.optString("thumbnail");
            cVar.f52697g = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
