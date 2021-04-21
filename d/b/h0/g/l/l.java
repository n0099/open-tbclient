package d.b.h0.g.l;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes3.dex */
public class l implements d.b.h0.a.a2.f.c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.a2.f.d f49185a;

    public l() {
        n.T(n.n(), n.r());
    }

    @Override // d.b.h0.a.a2.f.c
    public String a() {
        return n.M(a.USER_DATA_PATH);
    }

    @Override // d.b.h0.a.a2.f.c
    public String b(String str) {
        return n.V(str);
    }

    @Override // d.b.h0.a.a2.f.c
    public String c(String str) {
        return b(str);
    }

    @Override // d.b.h0.a.a2.f.c
    public String d(String str) {
        String y = n.y(str);
        if (TextUtils.isEmpty(y)) {
            return null;
        }
        return y;
    }

    @Override // d.b.h0.a.a2.f.c
    public boolean e(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!a.USER_DATA_PATH.equals(str)) {
                if (str.startsWith(a.USER_DATA_PATH + File.separator)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d.b.h0.a.a2.f.c
    public String f(String str) {
        return n.K("bdfile://tmp" + File.separator + str);
    }

    @Override // d.b.h0.a.a2.f.c
    public boolean g(String str, boolean z) {
        return n.R(str);
    }

    @Override // d.b.h0.a.a2.f.c
    @NonNull
    public synchronized d.b.h0.a.a2.f.d h() {
        if (this.f49185a == null) {
            this.f49185a = new m();
        }
        return this.f49185a;
    }

    @Override // d.b.h0.a.a2.f.c
    public String i(String str) {
        if (d.b.h0.a.a2.b.c(str) == PathType.RELATIVE) {
            return n.U(str);
        }
        return null;
    }

    @Override // d.b.h0.a.a2.f.c
    public String j() {
        return n.K("bdfile://tmp");
    }

    @Override // d.b.h0.a.a2.f.c
    public boolean k(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // d.b.h0.a.a2.f.c
    public String l(String str) {
        return i(str);
    }

    @Override // d.b.h0.a.a2.f.c
    public String m(String str) {
        return n.U(str);
    }
}
