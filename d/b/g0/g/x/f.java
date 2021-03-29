package d.b.g0.g.x;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f48674c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f48675a;

    /* renamed from: b  reason: collision with root package name */
    public String f48676b;

    public static f a() {
        if (f48674c == null) {
            synchronized (f.class) {
                if (f48674c == null) {
                    f48674c = new f();
                }
            }
        }
        return f48674c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f48676b)) {
            return "";
        }
        return this.f48676b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f48675a;
    }

    public void d(boolean z) {
        this.f48675a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f48676b = str;
    }
}
