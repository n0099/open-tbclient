package d.a.h0.g.x;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f46893c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f46894a;

    /* renamed from: b  reason: collision with root package name */
    public String f46895b;

    public static f a() {
        if (f46893c == null) {
            synchronized (f.class) {
                if (f46893c == null) {
                    f46893c = new f();
                }
            }
        }
        return f46893c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f46895b)) {
            return "";
        }
        return this.f46895b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f46894a;
    }

    public void d(boolean z) {
        this.f46894a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f46895b = str;
    }
}
