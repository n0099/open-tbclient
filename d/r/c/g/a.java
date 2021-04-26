package d.r.c.g;

import android.util.Log;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f67482b;

    /* renamed from: a  reason: collision with root package name */
    public d.r.c.a f67483a = null;

    public static a b() {
        if (f67482b == null) {
            f67482b = new a();
        }
        return f67482b;
    }

    public void a(String str) {
        d.r.c.a aVar = this.f67483a;
        if (aVar != null) {
            aVar.info("authsdk", str);
        } else {
            Log.i("authsdk", str);
        }
    }
}
