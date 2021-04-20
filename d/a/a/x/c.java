package d.a.a.x;

import android.util.Log;
import d.a.a.i;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class c implements i {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f41787a = new HashSet();

    @Override // d.a.a.i
    public void a(String str) {
        d(str, null);
    }

    @Override // d.a.a.i
    public void b(String str, Throwable th) {
        if (d.a.a.c.f41409a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // d.a.a.i
    public void c(String str) {
        e(str, null);
    }

    @Override // d.a.a.i
    public void d(String str, Throwable th) {
        if (f41787a.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        f41787a.add(str);
    }

    public void e(String str, Throwable th) {
        if (d.a.a.c.f41409a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
