package d.b.g0.a.g1.o.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44981d = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public final String f44982a;

    /* renamed from: b  reason: collision with root package name */
    public long f44983b;

    /* renamed from: c  reason: collision with root package name */
    public long f44984c;

    public d(String str) {
        this.f44982a = str;
        if (f44981d) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    public void a(long j) {
        this.f44983b = j;
    }

    public long b() {
        return this.f44983b;
    }

    public void c(long j) {
        this.f44984c = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.f44982a);
            jSONObject.put("begin_ts", this.f44983b);
            jSONObject.put("end_ts", this.f44984c);
        } catch (JSONException e2) {
            if (f44981d) {
                e2.printStackTrace();
            }
        }
        if (f44981d) {
            Log.d(ExifInterface.TAG_MODEL, jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
