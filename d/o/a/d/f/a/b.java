package d.o.a.d.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    @NonNull
    public CopyOnWriteArrayList<c.b> a(String str, String str2) {
        CopyOnWriteArrayList<c.b> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = n.a().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    c.b a2 = c.b.a(jSONObject.optJSONObject(keys.next()));
                    if (a2 != null) {
                        copyOnWriteArrayList.add(a2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    public void b(String str, String str2, CopyOnWriteArrayList<c.b> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<c.b> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                c.b next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.f66513b), next.b());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        n.a().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        n.a().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }
}
