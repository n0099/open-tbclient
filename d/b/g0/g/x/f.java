package d.b.g0.g.x;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f49066c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f49067a;

    /* renamed from: b  reason: collision with root package name */
    public String f49068b;

    public static f a() {
        if (f49066c == null) {
            synchronized (f.class) {
                if (f49066c == null) {
                    f49066c = new f();
                }
            }
        }
        return f49066c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f49068b)) {
            return "";
        }
        return this.f49068b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f49067a;
    }

    public void d(boolean z) {
        this.f49067a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f49068b = str;
    }
}
