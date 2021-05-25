package d.r.c.g;

import android.util.Log;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f68211b;

    /* renamed from: a  reason: collision with root package name */
    public d.r.c.a f68212a = null;

    public static a b() {
        if (f68211b == null) {
            f68211b = new a();
        }
        return f68211b;
    }

    public void a(String str) {
        d.r.c.a aVar = this.f68212a;
        if (aVar != null) {
            aVar.info("authsdk", str);
        } else {
            Log.i("authsdk", str);
        }
    }
}
