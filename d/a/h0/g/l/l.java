package d.a.h0.g.l;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes3.dex */
public class l implements d.a.h0.a.a2.f.c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.a2.f.d f46678a;

    public l() {
        n.T(n.n(), n.r());
    }

    @Override // d.a.h0.a.a2.f.c
    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!a.USER_DATA_PATH.equals(str)) {
                if (str.startsWith(a.USER_DATA_PATH + File.separator)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d.a.h0.a.a2.f.c
    public String b(String str) {
        return n.K("bdfile://tmp" + File.separator + str);
    }

    @Override // d.a.h0.a.a2.f.c
    @NonNull
    public synchronized d.a.h0.a.a2.f.d c() {
        if (this.f46678a == null) {
            this.f46678a = new m();
        }
        return this.f46678a;
    }

    @Override // d.a.h0.a.a2.f.c
    public String d(String str) {
        if (d.a.h0.a.a2.b.c(str) == PathType.RELATIVE) {
            return n.U(str);
        }
        return null;
    }

    @Override // d.a.h0.a.a2.f.c
    public String e(String str) {
        return n.U(str);
    }

    @Override // d.a.h0.a.a2.f.c
    public String f() {
        return n.M(a.USER_DATA_PATH);
    }

    @Override // d.a.h0.a.a2.f.c
    public String g(String str) {
        return n.V(str);
    }

    @Override // d.a.h0.a.a2.f.c
    public String h(String str) {
        return g(str);
    }

    @Override // d.a.h0.a.a2.f.c
    public String i(String str) {
        String y = n.y(str);
        if (TextUtils.isEmpty(y)) {
            return null;
        }
        return y;
    }

    @Override // d.a.h0.a.a2.f.c
    public boolean j(String str, boolean z) {
        return n.R(str);
    }

    @Override // d.a.h0.a.a2.f.c
    public String k() {
        return n.K("bdfile://tmp");
    }

    @Override // d.a.h0.a.a2.f.c
    public boolean l(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.h0.a.a2.f.c
    public String m(String str) {
        return d(str);
    }
}
