package d.a.l0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends d.a.l0.a.y0.a<d.a.l0.a.y0.g.h.b> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "getRemoteAudioLevels";
    }

    @Override // d.a.l0.a.y0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        command.obj = new JSONObject();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.g.h.b bVar) {
        ArrayList<d.a.l0.a.y0.g.i.a> w = bVar.w();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (w != null) {
            Iterator<d.a.l0.a.y0.g.i.a> it = w.iterator();
            while (it.hasNext()) {
                d.a.l0.a.y0.g.i.a next = it.next();
                JSONObject a2 = next == null ? null : next.a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
        }
        try {
            jSONObject.put("audioLevels", jSONArray);
        } catch (JSONException unused) {
        }
        command.obj = jSONObject;
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
    }
}
