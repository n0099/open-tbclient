package d.a.m0.a.n1.q.d;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47550d = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final String f47551a;

    /* renamed from: b  reason: collision with root package name */
    public long f47552b;

    /* renamed from: c  reason: collision with root package name */
    public long f47553c;

    public d(String str) {
        this.f47551a = str;
        if (f47550d) {
            Log.d("Model", "new model, scope id - " + str);
        }
    }

    public void a(long j) {
        this.f47552b = j;
    }

    public long b() {
        return this.f47552b;
    }

    public void c(long j) {
        this.f47553c = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.f47551a);
            jSONObject.put("begin_ts", this.f47552b);
            jSONObject.put("end_ts", this.f47553c);
        } catch (JSONException e2) {
            if (f47550d) {
                e2.printStackTrace();
            }
        }
        if (f47550d) {
            Log.d("Model", jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
