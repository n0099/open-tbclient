package d.a.i0.a.n1.q.d;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43592d = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public final String f43593a;

    /* renamed from: b  reason: collision with root package name */
    public long f43594b;

    /* renamed from: c  reason: collision with root package name */
    public long f43595c;

    public d(String str) {
        this.f43593a = str;
        if (f43592d) {
            Log.d("Model", "new model, scope id - " + str);
        }
    }

    public void a(long j) {
        this.f43594b = j;
    }

    public long b() {
        return this.f43594b;
    }

    public void c(long j) {
        this.f43595c = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.f43593a);
            jSONObject.put("begin_ts", this.f43594b);
            jSONObject.put("end_ts", this.f43595c);
        } catch (JSONException e2) {
            if (f43592d) {
                e2.printStackTrace();
            }
        }
        if (f43592d) {
            Log.d("Model", jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
