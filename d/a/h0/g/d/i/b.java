package d.a.h0.g.d.i;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.g.d.e;
import d.a.h0.g.d.g.f;
import java.io.IOException;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f46260a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f46261b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f46262c;

    public final void a(String str) {
        this.f46261b = 0;
        d.a.h0.g.d.c.b().a(str, this);
    }

    public String b() {
        return this.f46262c;
    }

    public void c(String str) {
        this.f46262c = str;
    }

    public abstract void d(IOException iOException);

    public abstract void e(int i2);

    public final String f(byte[] bArr) {
        String str = new String(bArr);
        if (d.a.h0.g.d.a.f46216a) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.f46260a) {
            f c2 = d.a.h0.g.d.d.f().c(e.l().k(), bArr);
            if (c2 != null) {
                if (!TextUtils.isEmpty(c2.a())) {
                    str = c2.a();
                }
                this.f46261b = c2.b().intValue();
            } else {
                this.f46261b = -1;
            }
            e.l().k().s(this.f46261b);
            if (this.f46261b == -1) {
                d.a.h0.g.d.c.b().e(false);
            }
        }
        return str;
    }

    public abstract void g(byte[] bArr);

    public void h(boolean z) {
        this.f46260a = z;
    }
}
