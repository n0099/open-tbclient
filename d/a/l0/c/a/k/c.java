package d.a.l0.c.a.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.c.a.g;
import d.a.l0.c.a.i.f;
import java.io.IOException;
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50178a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f50179b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f50180c;

    public final void a(String str) {
        this.f50179b = 0;
        d.a.l0.c.a.d.b().a(str, this);
    }

    public String b() {
        return this.f50180c;
    }

    public boolean c() {
        return this.f50178a;
    }

    public void d(String str) {
        this.f50180c = str;
    }

    public abstract void e(IOException iOException);

    public abstract void f(int i2);

    public final String g(byte[] bArr) {
        String str = new String(bArr);
        if (d.a.l0.c.a.a.f50123a) {
            Log.d("BDTLS", "processResponseData encodeResponseData=" + str);
        }
        if (this.f50178a) {
            f c2 = d.a.l0.c.a.e.f().c(g.l().m(), bArr);
            if (c2 != null) {
                if (!TextUtils.isEmpty(c2.a())) {
                    str = c2.a();
                }
                this.f50179b = c2.b().intValue();
            } else {
                this.f50179b = -1;
            }
            g.l().m().s(this.f50179b);
            if (this.f50179b == -1) {
                d.a.l0.c.a.d.b().f(false);
            }
        }
        return str;
    }

    public abstract void h(byte[] bArr);

    public void i(boolean z) {
        this.f50178a = z;
    }
}
