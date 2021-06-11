package d.r.b.g;

import android.util.Log;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f71467b;

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a f71468a = null;

    public static a b() {
        if (f71467b == null) {
            f71467b = new a();
        }
        return f71467b;
    }

    public void a(String str) {
        d.r.b.a aVar = this.f71468a;
        if (aVar != null) {
            aVar.info("authsdk", str);
        } else {
            Log.i("authsdk", str);
        }
    }
}
