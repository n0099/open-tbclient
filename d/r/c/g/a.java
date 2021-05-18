package d.r.c.g;

import android.util.Log;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f68168b;

    /* renamed from: a  reason: collision with root package name */
    public d.r.c.a f68169a = null;

    public static a b() {
        if (f68168b == null) {
            f68168b = new a();
        }
        return f68168b;
    }

    public void a(String str) {
        d.r.c.a aVar = this.f68169a;
        if (aVar != null) {
            aVar.info("authsdk", str);
        } else {
            Log.i("authsdk", str);
        }
    }
}
