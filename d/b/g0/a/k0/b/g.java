package d.b.g0.a.k0.b;

import android.net.Uri;
import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g<T> extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45067d = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public T f45068b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45069c = true;

    public g() {
        this.f45055a = "message";
    }

    @Override // d.b.g0.a.k0.b.a
    public String a(String str) {
        T t = this.f45068b;
        if (!(t instanceof String)) {
            return t instanceof JSONObject ? d.b.g0.a.k0.a.f(str, "message", (JSONObject) t) : "";
        }
        String str2 = (String) t;
        if (this.f45069c) {
            str2 = Uri.encode(str2);
        }
        if (f45067d) {
            Log.d("SwanAppWebMessage", "mData: " + this.f45068b);
            Log.d("SwanAppWebMessage", "encode mData: " + str2);
        }
        return d.b.g0.a.k0.a.e(str, "message", str2);
    }
}
