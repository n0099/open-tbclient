package d.b.g0.a.s0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x extends d.b.g0.a.s0.a<d.b.g0.a.s0.g.h.b> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "setRemoteAudioPlayState";
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
            if (jSONObject.has("status") && jSONObject.has("userId")) {
                long optLong = jSONObject.optLong("userId", -1L);
                boolean optBoolean = jSONObject.optBoolean("status");
                if (d.b.g0.a.s0.g.g.a.a(optLong)) {
                    bVar.z(optLong, optBoolean);
                }
            }
        }
    }
}
