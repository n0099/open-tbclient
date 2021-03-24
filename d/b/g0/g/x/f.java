package d.b.g0.g.x;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f48673c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f48674a;

    /* renamed from: b  reason: collision with root package name */
    public String f48675b;

    public static f a() {
        if (f48673c == null) {
            synchronized (f.class) {
                if (f48673c == null) {
                    f48673c = new f();
                }
            }
        }
        return f48673c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f48675b)) {
            return "";
        }
        return this.f48675b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f48674a;
    }

    public void d(boolean z) {
        this.f48674a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f48675b = str;
    }
}
