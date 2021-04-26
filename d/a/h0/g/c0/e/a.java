package d.a.h0.g.c0.e;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f46209b;

    /* renamed from: c  reason: collision with root package name */
    public int f46210c;

    /* renamed from: d  reason: collision with root package name */
    public int f46211d;

    @Override // d.a.h0.g.c0.e.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f46209b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f46210c);
            jSONObject.put("net", this.f46211d);
            jSONObject.put("errMsg", this.f46215a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
