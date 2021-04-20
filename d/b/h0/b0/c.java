package d.b.h0.b0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f50167a;

    /* renamed from: b  reason: collision with root package name */
    public int f50168b;

    /* renamed from: c  reason: collision with root package name */
    public int f50169c;

    /* renamed from: d  reason: collision with root package name */
    public String f50170d;

    /* renamed from: e  reason: collision with root package name */
    public String f50171e;

    /* renamed from: f  reason: collision with root package name */
    public String f50172f;

    /* renamed from: g  reason: collision with root package name */
    public String f50173g;

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.f50167a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.f50168b = jSONObject.optInt("width");
            cVar.f50169c = jSONObject.optInt("height");
            cVar.f50170d = jSONObject.optString("pic_url");
            cVar.f50171e = jSONObject.optString("thumbnail");
            cVar.f50173g = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
