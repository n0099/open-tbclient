package d.a.i0.a.y0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends d.a.i0.a.y0.a<d.a.i0.a.y0.g.h.a> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "onSurfaceChanged";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.g.h.a aVar) {
        String str = command.what;
        d(aVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            aVar.U(jSONObject.optInt("width"), jSONObject.optInt("height"));
        }
    }
}
