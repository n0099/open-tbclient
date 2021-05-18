package d.a.i0.a.o0.d;

import android.net.Uri;
import android.util.Log;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g<T> extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43749e = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public T f43750c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43751d = true;

    public g() {
        this.f43731a = "message";
    }

    @Override // d.a.i0.a.o0.d.a
    public String f(String str) {
        T t = this.f43750c;
        if (!(t instanceof String)) {
            return t instanceof JSONObject ? d.a.i0.a.o0.a.d(str, "message", (JSONObject) t) : "";
        }
        String str2 = (String) t;
        if (this.f43751d) {
            str2 = Uri.encode(str2);
        }
        if (f43749e) {
            Log.d("SwanAppWebMessage", "mData: " + this.f43750c);
            Log.d("SwanAppWebMessage", "encode mData: " + str2);
        }
        return d.a.i0.a.o0.a.c(str, "message", str2);
    }
}
