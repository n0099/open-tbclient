package d.a.m0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y extends d.a.m0.a.y0.a<d.a.m0.a.y0.g.h.b> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "setRemoteAudioPlayState";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.has("status") && jSONObject.has("userId")) {
                long optLong = jSONObject.optLong("userId", -1L);
                boolean optBoolean = jSONObject.optBoolean("status");
                if (d.a.m0.a.y0.g.g.a.a(optLong)) {
                    bVar.o(optLong, optBoolean);
                }
            }
        }
    }
}
