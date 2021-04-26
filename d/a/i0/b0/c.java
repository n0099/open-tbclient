package d.a.i0.b0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f48057a;

    /* renamed from: b  reason: collision with root package name */
    public int f48058b;

    /* renamed from: c  reason: collision with root package name */
    public int f48059c;

    /* renamed from: d  reason: collision with root package name */
    public String f48060d;

    /* renamed from: e  reason: collision with root package name */
    public String f48061e;

    /* renamed from: f  reason: collision with root package name */
    public String f48062f;

    /* renamed from: g  reason: collision with root package name */
    public String f48063g;

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.f48057a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.f48058b = jSONObject.optInt("width");
            cVar.f48059c = jSONObject.optInt("height");
            cVar.f48060d = jSONObject.optString("pic_url");
            cVar.f48061e = jSONObject.optString("thumbnail");
            cVar.f48063g = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
