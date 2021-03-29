package d.b.g0.a.s0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l extends d.b.g0.a.s0.a<d.b.g0.a.s0.g.h.b> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "getRemoteUserList";
    }

    @Override // d.b.g0.a.s0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        command.obj = new JSONObject();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.g.h.b bVar) {
        ArrayList<d.b.g0.a.s0.g.i.c> i = bVar.i();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (i != null) {
            Iterator<d.b.g0.a.s0.g.i.c> it = i.iterator();
            while (it.hasNext()) {
                d.b.g0.a.s0.g.i.c next = it.next();
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
