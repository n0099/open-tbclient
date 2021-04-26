package d.a.h0.a.p.b;

import android.content.Context;
import android.graphics.Bitmap;
import d.a.h0.a.p.c.w;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i implements d.a.h0.a.p.c.w {
    @Override // d.a.h0.a.p.c.w
    public void a(HashMap<String, String> hashMap, File file, w.a aVar, String str) {
        e(aVar);
    }

    @Override // d.a.h0.a.p.c.w
    public void b(Context context, String str, String str2, String str3) {
    }

    @Override // d.a.h0.a.p.c.w
    public void c(HashMap<String, String> hashMap, File file, w.a aVar) {
        e(aVar);
    }

    @Override // d.a.h0.a.p.c.w
    public void d(Bitmap bitmap, HashMap<String, String> hashMap, File[] fileArr, w.a aVar) {
        e(aVar);
    }

    public final void e(w.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "success");
            aVar.onResult(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
