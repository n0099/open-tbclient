package d.a.h0.a.k0.b;

import android.net.Uri;
import android.util.Log;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g<T> extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43118d = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public T f43119b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43120c = true;

    public g() {
        this.f43106a = "message";
    }

    @Override // d.a.h0.a.k0.b.a
    public String a(String str) {
        T t = this.f43119b;
        if (!(t instanceof String)) {
            return t instanceof JSONObject ? d.a.h0.a.k0.a.f(str, "message", (JSONObject) t) : "";
        }
        String str2 = (String) t;
        if (this.f43120c) {
            str2 = Uri.encode(str2);
        }
        if (f43118d) {
            Log.d("SwanAppWebMessage", "mData: " + this.f43119b);
            Log.d("SwanAppWebMessage", "encode mData: " + str2);
        }
        return d.a.h0.a.k0.a.e(str, "message", str2);
    }
}
