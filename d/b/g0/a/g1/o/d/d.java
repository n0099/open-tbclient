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
    public static final boolean f44589d = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public final String f44590a;

    /* renamed from: b  reason: collision with root package name */
    public long f44591b;

    /* renamed from: c  reason: collision with root package name */
    public long f44592c;

    public d(String str) {
        this.f44590a = str;
        if (f44589d) {
            Log.d(ExifInterface.TAG_MODEL, "new model, scope id - " + str);
        }
    }

    public void a(long j) {
        this.f44591b = j;
    }

    public long b() {
        return this.f44591b;
    }

    public void c(long j) {
        this.f44592c = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope_id", this.f44590a);
            jSONObject.put("begin_ts", this.f44591b);
            jSONObject.put("end_ts", this.f44592c);
        } catch (JSONException e2) {
            if (f44589d) {
                e2.printStackTrace();
            }
        }
        if (f44589d) {
            Log.d(ExifInterface.TAG_MODEL, jSONObject.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
