package d.b.h0.a.g1.o.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45310d = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public final String f45311a;

    /* renamed from: b  reason: collision with root package name */
    public long f45312b;

    /* renamed from: c  reason: collision with root package name */
    public long f45313c;

    public d(String str) {
        this.f45311a = str;
        if (f45310d) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    public void a(long j) {
        this.f45312b = j;
    }

    public long b() {
        return this.f45312b;
    }

    public void c(long j) {
        this.f45313c = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.f45311a);
            jSONObject.put("begin_ts", this.f45312b);
            jSONObject.put("end_ts", this.f45313c);
        } catch (JSONException e2) {
            if (f45310d) {
                e2.printStackTrace();
            }
        }
        if (f45310d) {
            Log.d(ExifInterface.TAG_MODEL, jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
