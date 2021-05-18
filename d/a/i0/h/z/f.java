package d.a.i0.h.z;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f47635c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47636a;

    /* renamed from: b  reason: collision with root package name */
    public String f47637b;

    public static f a() {
        if (f47635c == null) {
            synchronized (f.class) {
                if (f47635c == null) {
                    f47635c = new f();
                }
            }
        }
        return f47635c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f47637b)) {
            return "";
        }
        return this.f47637b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f47636a;
    }

    public void d(boolean z) {
        this.f47636a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f47637b = str;
    }
}
