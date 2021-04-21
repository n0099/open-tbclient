package d.b.b0.a.c;

import android.util.Log;
/* loaded from: classes2.dex */
public class a implements g {
    @Override // d.b.b0.a.c.g
    public int e(String str, String str2) {
        return Log.e(str, str2);
    }

    @Override // d.b.b0.a.c.g
    public int e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }
}
