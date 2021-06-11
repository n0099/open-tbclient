package d.a.l0.a.r0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes3.dex */
public class l implements d.a.l0.a.k2.f.d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.k2.f.e f48081a;

    public l() {
        n.T(n.n(), n.r());
    }

    @Override // d.a.l0.a.k2.f.d
    public String a(String str) {
        return n.U(str);
    }

    @Override // d.a.l0.a.k2.f.d
    public boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!a.USER_DATA_PATH.equals(str)) {
                if (str.startsWith(a.USER_DATA_PATH + File.separator)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d.a.l0.a.k2.f.d
    public String c(String str) {
        return n.K("bdfile://tmp" + File.separator + str);
    }

    @Override // d.a.l0.a.k2.f.d
    @NonNull
    public synchronized d.a.l0.a.k2.f.e d() {
        if (this.f48081a == null) {
            this.f48081a = new m();
        }
        return this.f48081a;
    }

    @Override // d.a.l0.a.k2.f.d
    public String e(String str) {
        if (d.a.l0.a.k2.b.s(str) == PathType.RELATIVE) {
            return n.U(str);
        }
        return null;
    }

    @Override // d.a.l0.a.k2.f.d
    public String f() {
        return n.M(a.USER_DATA_PATH);
    }

    @Override // d.a.l0.a.k2.f.d
    public String g(String str) {
        return n.V(str);
    }

    @Override // d.a.l0.a.k2.f.d
    public String h(String str) {
        return g(str);
    }

    @Override // d.a.l0.a.k2.f.d
    public String i(String str) {
        String y = n.y(str);
        if (TextUtils.isEmpty(y)) {
            return null;
        }
        return y;
    }

    @Override // d.a.l0.a.k2.f.d
    public boolean j(String str, boolean z) {
        return n.R(str);
    }

    @Override // d.a.l0.a.k2.f.d
    public String k() {
        return n.K("bdfile://tmp");
    }

    @Override // d.a.l0.a.k2.f.d
    public boolean l(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.l0.a.k2.f.d
    public String m(String str) {
        return e(str);
    }
}
