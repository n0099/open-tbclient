package d.a.l0.h.z;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f51485c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51486a;

    /* renamed from: b  reason: collision with root package name */
    public String f51487b;

    public static f a() {
        if (f51485c == null) {
            synchronized (f.class) {
                if (f51485c == null) {
                    f51485c = new f();
                }
            }
        }
        return f51485c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f51487b)) {
            return "";
        }
        return this.f51487b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f51486a;
    }

    public void d(boolean z) {
        this.f51486a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f51487b = str;
    }
}
