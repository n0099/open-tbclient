package d.b.h0.g.x;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f49395c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f49396a;

    /* renamed from: b  reason: collision with root package name */
    public String f49397b;

    public static f a() {
        if (f49395c == null) {
            synchronized (f.class) {
                if (f49395c == null) {
                    f49395c = new f();
                }
            }
        }
        return f49395c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f49397b)) {
            return "";
        }
        return this.f49397b + File.separator + "index.js";
    }

    public boolean c() {
        return this.f49396a;
    }

    public void d(boolean z) {
        this.f49396a = z;
    }

    public void e(String str) {
    }

    public void f(String str) {
        this.f49397b = str;
    }
}
