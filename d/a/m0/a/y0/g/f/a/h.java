package d.a.m0.a.y0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends d.a.m0.a.y0.a<d.a.m0.a.y0.g.h.a> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "onSurfaceChanged";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.g.h.a aVar) {
        String str = command.what;
        d(aVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            aVar.R(jSONObject.optInt("width"), jSONObject.optInt("height"));
        }
    }
}
