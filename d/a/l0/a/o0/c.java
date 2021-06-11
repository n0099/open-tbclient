package d.a.l0.a.o0;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public abstract class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f47578e = true;

    /* renamed from: f  reason: collision with root package name */
    public String f47579f;

    public c() {
    }

    public boolean a() {
        return this.f47578e;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f47579f)) {
            return false;
        }
        return this.f47579f.endsWith(str);
    }

    public abstract void c();

    @Override // java.lang.Runnable
    public final void run() {
        c();
        this.f47578e = false;
    }

    public c(String str) {
        this.f47579f = str;
    }
}
