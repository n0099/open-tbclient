package d.a.l0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l extends d.a.l0.a.y0.a<d.a.l0.a.y0.g.h.b> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "getRemoteUserList";
    }

    @Override // d.a.l0.a.y0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        command.obj = new JSONObject();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.g.h.b bVar) {
        ArrayList<d.a.l0.a.y0.g.i.c> g2 = bVar.g();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (g2 != null) {
            Iterator<d.a.l0.a.y0.g.i.c> it = g2.iterator();
            while (it.hasNext()) {
                d.a.l0.a.y0.g.i.c next = it.next();
                JSONObject a2 = next == null ? null : next.a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
        }
        try {
            jSONObject.put("userList", jSONArray);
        } catch (JSONException unused) {
        }
        command.obj = jSONObject;
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
    }
}
