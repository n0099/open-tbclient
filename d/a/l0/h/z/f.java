package d.a.l0.h.z;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f47811c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47812a;

    /* renamed from: b  reason: collision with root package name */
    public String f47813b;

    public static f a() {
        if (f47811c == null) {
            synchronized (f.class) {
                if (f47811c == null) {
                    f47811c = new f();
                }
            }
        }
        return f47811c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f47813b)) {
            return "";
        }
        return this.f47813b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f47812a;
    }

    public void d(boolean z) {
        this.f47812a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f47813b = str;
    }
}
