package d.a.l0.a.n1.q.d;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47442d = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final String f47443a;

    /* renamed from: b  reason: collision with root package name */
    public long f47444b;

    /* renamed from: c  reason: collision with root package name */
    public long f47445c;

    public d(String str) {
        this.f47443a = str;
        if (f47442d) {
            Log.d("Model", "new model, scope id - " + str);
        }
    }

    public void a(long j) {
        this.f47444b = j;
    }

    public long b() {
        return this.f47444b;
    }

    public void c(long j) {
        this.f47445c = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.f47443a);
            jSONObject.put("begin_ts", this.f47444b);
            jSONObject.put("end_ts", this.f47445c);
        } catch (JSONException e2) {
            if (f47442d) {
                e2.printStackTrace();
            }
        }
        if (f47442d) {
            Log.d("Model", jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
