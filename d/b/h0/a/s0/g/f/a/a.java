package d.b.h0.a.s0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.h0.a.s0.a<d.b.h0.a.s0.g.h.a> {
    @Override // d.b.h0.a.s0.a
    @NonNull
    public String b() {
        return "onFocus";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.h0.a.s0.g.h.a aVar) {
        String str = command.what;
        d(aVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            aVar.D(jSONObject.optInt("focusWidth"), jSONObject.optInt("focusHeight"), jSONObject.optInt("focusX"), jSONObject.optInt("focusY"));
        }
    }
}
