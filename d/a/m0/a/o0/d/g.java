package d.a.m0.a.o0.d;

import android.net.Uri;
import android.util.Log;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g<T> extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47707e = k.f46983a;

    /* renamed from: c  reason: collision with root package name */
    public T f47708c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47709d = true;

    public g() {
        this.f47689a = "message";
    }

    @Override // d.a.m0.a.o0.d.a
    public String f(String str) {
        T t = this.f47708c;
        if (!(t instanceof String)) {
            return t instanceof JSONObject ? d.a.m0.a.o0.a.d(str, "message", (JSONObject) t) : "";
        }
        String str2 = (String) t;
        if (this.f47709d) {
            str2 = Uri.encode(str2);
        }
        if (f47707e) {
            Log.d("SwanAppWebMessage", "mData: " + this.f47708c);
            Log.d("SwanAppWebMessage", "encode mData: " + str2);
        }
        return d.a.m0.a.o0.a.c(str, "message", str2);
    }
}
