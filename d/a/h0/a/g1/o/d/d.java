package d.a.h0.a.g1.o.d;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42624d = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public final String f42625a;

    /* renamed from: b  reason: collision with root package name */
    public long f42626b;

    /* renamed from: c  reason: collision with root package name */
    public long f42627c;

    public d(String str) {
        this.f42625a = str;
        if (f42624d) {
            Log.d("Model", "new model, scope id - " + str);
        }
    }

    public void a(long j) {
        this.f42626b = j;
    }

    public long b() {
        return this.f42626b;
    }

    public void c(long j) {
        this.f42627c = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.f42625a);
            jSONObject.put("begin_ts", this.f42626b);
            jSONObject.put("end_ts", this.f42627c);
        } catch (JSONException e2) {
            if (f42624d) {
                e2.printStackTrace();
            }
        }
        if (f42624d) {
            Log.d("Model", jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
