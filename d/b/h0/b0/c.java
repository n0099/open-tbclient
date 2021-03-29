package d.b.h0.b0;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f49774a;

    /* renamed from: b  reason: collision with root package name */
    public int f49775b;

    /* renamed from: c  reason: collision with root package name */
    public int f49776c;

    /* renamed from: d  reason: collision with root package name */
    public String f49777d;

    /* renamed from: e  reason: collision with root package name */
    public String f49778e;

    /* renamed from: f  reason: collision with root package name */
    public String f49779f;

    /* renamed from: g  reason: collision with root package name */
    public String f49780g;

    public static c a(JSONObject jSONObject) {
        try {
            c cVar = new c();
            cVar.f49774a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
            cVar.f49775b = jSONObject.optInt("width");
            cVar.f49776c = jSONObject.optInt("height");
            cVar.f49777d = jSONObject.optString("pic_url");
            cVar.f49778e = jSONObject.optString("thumbnail");
            cVar.f49780g = jSONObject.optString("origin_url");
            return cVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
