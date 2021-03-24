package d.b.g0.a.s0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends d.b.g0.a.s0.a<d.b.g0.a.s0.g.h.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "onSurfaceChanged";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.g.h.a aVar) {
        String str = command.what;
        d(aVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            aVar.v(jSONObject.optInt("width"), jSONObject.optInt("height"));
        }
    }
}
