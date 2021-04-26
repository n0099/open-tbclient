package d.a.h0.a.s0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k extends d.a.h0.a.s0.a<d.a.h0.a.s0.g.h.b> {
    @Override // d.a.h0.a.s0.a
    @NonNull
    public String b() {
        return "getRemoteAudioLevels";
    }

    @Override // d.a.h0.a.s0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        command.obj = new JSONObject();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.h0.a.s0.g.h.b bVar) {
        ArrayList<d.a.h0.a.s0.g.i.a> v = bVar.v();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (v != null) {
            Iterator<d.a.h0.a.s0.g.i.a> it = v.iterator();
            while (it.hasNext()) {
                d.a.h0.a.s0.g.i.a next = it.next();
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
