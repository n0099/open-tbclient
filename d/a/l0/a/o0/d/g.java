package d.a.l0.a.o0.d;

import android.net.Uri;
import android.util.Log;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g<T> extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43923e = k.f43199a;

    /* renamed from: c  reason: collision with root package name */
    public T f43924c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43925d = true;

    public g() {
        this.f43905a = "message";
    }

    @Override // d.a.l0.a.o0.d.a
    public String f(String str) {
        T t = this.f43924c;
        if (!(t instanceof String)) {
            return t instanceof JSONObject ? d.a.l0.a.o0.a.d(str, "message", (JSONObject) t) : "";
        }
        String str2 = (String) t;
        if (this.f43925d) {
            str2 = Uri.encode(str2);
        }
        if (f43923e) {
            Log.d("SwanAppWebMessage", "mData: " + this.f43924c);
            Log.d("SwanAppWebMessage", "encode mData: " + str2);
        }
        return d.a.l0.a.o0.a.c(str, "message", str2);
    }
}
