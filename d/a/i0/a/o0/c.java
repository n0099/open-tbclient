package d.a.i0.a.o0;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public abstract class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f43728e = true;

    /* renamed from: f  reason: collision with root package name */
    public String f43729f;

    public c() {
    }

    public boolean a() {
        return this.f43728e;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f43729f)) {
            return false;
        }
        return this.f43729f.endsWith(str);
    }

    public abstract void c();

    @Override // java.lang.Runnable
    public final void run() {
        c();
        this.f43728e = false;
    }

    public c(String str) {
        this.f43729f = str;
    }
}
