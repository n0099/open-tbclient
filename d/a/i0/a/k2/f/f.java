package d.a.i0.a.k2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes3.dex */
public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public e f43065a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43066a;

        static {
            int[] iArr = new int[PathType.values().length];
            f43066a = iArr;
            try {
                iArr[PathType.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43066a[PathType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43066a[PathType.BD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // d.a.i0.a.k2.f.d
    public String a(String str) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        return Q == null ? str : d.a.i0.a.k2.b.H(str, Q);
    }

    @Override // d.a.i0.a.k2.f.d
    public boolean b(String str) {
        return d.a.i0.a.k2.b.G(str);
    }

    @Override // d.a.i0.a.k2.f.d
    public String c(String str) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        return Q == null ? "" : d.a.i0.a.k2.b.n(Q.f40575f, str, null);
    }

    @Override // d.a.i0.a.k2.f.d
    @NonNull
    public synchronized e d() {
        if (this.f43065a == null) {
            this.f43065a = new g();
        }
        return this.f43065a;
    }

    @Override // d.a.i0.a.k2.f.d
    public String e(String str) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return null;
        }
        return d.a.i0.a.k2.b.L(str, Q, Q.Z());
    }

    @Override // d.a.i0.a.k2.f.d
    public String f() {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        return Q == null ? "" : d.a.i0.a.k2.b.z(Q.f40575f);
    }

    @Override // d.a.i0.a.k2.f.d
    public String g(String str) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        return Q == null ? str : d.a.i0.a.k2.b.I(str, Q.f40575f);
    }

    @Override // d.a.i0.a.k2.f.d
    public String h(String str) {
        String s = d.a.i0.t.d.s(str);
        if (TextUtils.isEmpty(s)) {
            return g(str);
        }
        return g(str) + "." + s;
    }

    @Override // d.a.i0.a.k2.f.d
    public String i(String str) {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return null;
        }
        return d.a.i0.a.k2.b.M(str, Q.f40575f);
    }

    @Override // d.a.i0.a.k2.f.d
    public boolean j(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType s = d.a.i0.a.k2.b.s(str);
        if (z) {
            s = o(str, s);
        }
        return s != PathType.ERROR;
    }

    @Override // d.a.i0.a.k2.f.d
    public String k() {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        return Q == null ? "" : d.a.i0.a.k2.b.x(Q.f40575f);
    }

    @Override // d.a.i0.a.k2.f.d
    public boolean l(String str) {
        return d.a.i0.a.k2.b.F(str);
    }

    @Override // d.a.i0.a.k2.f.d
    public String m(String str) {
        return d.a.i0.a.k2.b.K(str);
    }

    public final boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf(Constants.PATH_PARENT);
        if (indexOf != 0) {
            return indexOf > 0;
        }
        String substring = str.substring(3);
        return !TextUtils.isEmpty(substring) && substring.contains(Constants.PATH_PARENT);
    }

    public final PathType o(String str, PathType pathType) {
        int i2 = a.f43066a[pathType.ordinal()];
        if (i2 == 1) {
            return n(str) ? PathType.ERROR : pathType;
        } else if (i2 != 2) {
            return i2 != 3 ? PathType.ERROR : pathType;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("bdfile://code");
            sb.append(File.separator);
            return (str.startsWith(sb.toString()) || "bdfile://code".equals(str)) ? PathType.RELATIVE : pathType;
        }
    }
}
