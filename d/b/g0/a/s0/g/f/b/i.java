package d.b.g0.a.s0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends d.b.g0.a.s0.a<d.b.g0.a.s0.g.h.b> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "enterRoom";
    }

    @Override // d.b.g0.a.s0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        Object obj = command.obj;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            command.ret = new d.b.g0.a.s0.g.i.b(jSONObject.optString("roomName"), jSONObject.optLong("userId", -1L), jSONObject.optString("displayName"), jSONObject.optString("rtcAppId"), jSONObject.optString("token")).a() ? 1 : 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            d.b.g0.a.s0.g.i.b bVar2 = new d.b.g0.a.s0.g.i.b(jSONObject.optString("roomName"), jSONObject.optLong("userId", -1L), jSONObject.optString("displayName"), jSONObject.optString("rtcAppId"), jSONObject.optString("token"));
            boolean a2 = bVar2.a();
            if (a2) {
                bVar.G(bVar2);
            }
            command.ret = a2 ? 1 : 0;
        }
        String str2 = command.what;
        d(bVar, str2, "result: " + command.ret, true);
    }
}
