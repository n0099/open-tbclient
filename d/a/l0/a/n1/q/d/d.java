package d.a.l0.a.n1.q.d;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43766d = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public final String f43767a;

    /* renamed from: b  reason: collision with root package name */
    public long f43768b;

    /* renamed from: c  reason: collision with root package name */
    public long f43769c;

    public d(String str) {
        this.f43767a = str;
        if (f43766d) {
            Log.d("Model", "new model, scope id - " + str);
        }
    }

    public void a(long j) {
        this.f43768b = j;
    }

    public long b() {
        return this.f43768b;
    }

    public void c(long j) {
        this.f43769c = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.f43767a);
            jSONObject.put("begin_ts", this.f43768b);
            jSONObject.put("end_ts", this.f43769c);
        } catch (JSONException e2) {
            if (f43766d) {
                e2.printStackTrace();
            }
        }
        if (f43766d) {
            Log.d("Model", jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
