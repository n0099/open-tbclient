package d.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f64293e;

    public g(Context context) {
        super(false, false);
        this.f64293e = context;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = this.f64293e.getSharedPreferences("snssdk_openudid", 0);
        String string = sharedPreferences.getString("clientudid", null);
        if (!j.n(string)) {
            try {
                string = a("clientudid.dat", UUID.randomUUID().toString());
            } catch (Exception unused) {
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("clientudid", string);
            edit.apply();
        }
        jSONObject.put("clientudid", string);
        return true;
    }
}
