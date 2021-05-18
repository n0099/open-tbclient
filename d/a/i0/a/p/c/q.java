package d.a.i0.a.p.c;

import android.content.Context;
import android.graphics.Bitmap;
import d.a.i0.a.p.d.e0;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class q implements d.a.i0.a.p.d.e0 {
    @Override // d.a.i0.a.p.d.e0
    public void a(HashMap<String, String> hashMap, File file, e0.a aVar, String str) {
        e(aVar);
    }

    @Override // d.a.i0.a.p.d.e0
    public void b(Context context, String str, String str2, String str3) {
    }

    @Override // d.a.i0.a.p.d.e0
    public void c(HashMap<String, String> hashMap, File file, e0.a aVar) {
        e(aVar);
    }

    @Override // d.a.i0.a.p.d.e0
    public void d(Bitmap bitmap, HashMap<String, String> hashMap, File[] fileArr, e0.a aVar) {
        e(aVar);
    }

    public final void e(e0.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "success");
            aVar.onResult(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
