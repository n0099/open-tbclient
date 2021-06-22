package d.a.m0.h.z;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f51593c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51594a;

    /* renamed from: b  reason: collision with root package name */
    public String f51595b;

    public static f a() {
        if (f51593c == null) {
            synchronized (f.class) {
                if (f51593c == null) {
                    f51593c = new f();
                }
            }
        }
        return f51593c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f51595b)) {
            return "";
        }
        return this.f51595b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f51594a;
    }

    public void d(boolean z) {
        this.f51594a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f51595b = str;
    }
}
