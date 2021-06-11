package d.a.m0.b0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f52584a;

    /* renamed from: b  reason: collision with root package name */
    public int f52585b;

    /* renamed from: c  reason: collision with root package name */
    public int f52586c;

    /* renamed from: d  reason: collision with root package name */
    public String f52587d;

    /* renamed from: e  reason: collision with root package name */
    public String f52588e;

    /* renamed from: f  reason: collision with root package name */
    public String f52589f;

    /* renamed from: g  reason: collision with root package name */
    public String f52590g;

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.f52584a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.f52585b = jSONObject.optInt("width");
            cVar.f52586c = jSONObject.optInt("height");
            cVar.f52587d = jSONObject.optString("pic_url");
            cVar.f52588e = jSONObject.optString("thumbnail");
            cVar.f52590g = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
