package d.b.g0.g.d.i;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.g.d.e;
import d.b.g0.g.d.g.f;
import java.io.IOException;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f48462a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f48463b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f48464c;

    public final void a(String str) {
        this.f48463b = 0;
        d.b.g0.g.d.c.b().a(str, this);
    }

    public String b() {
        return this.f48464c;
    }

    public void c(String str) {
        this.f48464c = str;
    }

    public abstract void d(IOException iOException);

    public abstract void e(int i);

    public final String f(byte[] bArr) {
        String str = new String(bArr);
        if (d.b.g0.g.d.a.f48420a) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.f48462a) {
            f c2 = d.b.g0.g.d.d.f().c(e.l().k(), bArr);
            if (c2 != null) {
                if (!TextUtils.isEmpty(c2.a())) {
                    str = c2.a();
                }
                this.f48463b = c2.b().intValue();
            } else {
                this.f48463b = -1;
            }
            e.l().k().s(this.f48463b);
            if (this.f48463b == -1) {
                d.b.g0.g.d.c.b().e(false);
            }
        }
        return str;
    }

    public abstract void g(byte[] bArr);

    public void h(boolean z) {
        this.f48462a = z;
    }
}
