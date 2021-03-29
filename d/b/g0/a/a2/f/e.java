package d.b.g0.a.a2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes2.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    public d f43234a;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43235a;

        static {
            int[] iArr = new int[PathType.values().length];
            f43235a = iArr;
            try {
                iArr[PathType.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43235a[PathType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43235a[PathType.BD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // d.b.g0.a.a2.f.c
    public String a() {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        return O == null ? "" : d.b.g0.a.a2.b.j(O.f45740f);
    }

    @Override // d.b.g0.a.a2.f.c
    public String b(String str) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        return O == null ? str : d.b.g0.a.a2.b.q(str, O.f45740f);
    }

    @Override // d.b.g0.a.a2.f.c
    public String c(String str) {
        String l = d.b.g0.p.d.l(str);
        if (TextUtils.isEmpty(l)) {
            return b(str);
        }
        return b(str) + "." + l;
    }

    @Override // d.b.g0.a.a2.f.c
    public String d(String str) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            return null;
        }
        return d.b.g0.a.a2.b.u(str, O.f45740f);
    }

    @Override // d.b.g0.a.a2.f.c
    public boolean e(String str) {
        return d.b.g0.a.a2.b.o(str);
    }

    @Override // d.b.g0.a.a2.f.c
    public String f(String str) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        return O == null ? "" : d.b.g0.a.a2.b.b(O.f45740f, str, null);
    }

    @Override // d.b.g0.a.a2.f.c
    public boolean g(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType c2 = d.b.g0.a.a2.b.c(str);
        if (z) {
            c2 = o(str, c2);
        }
        return c2 != PathType.ERROR;
    }

    @Override // d.b.g0.a.a2.f.c
    @NonNull
    public synchronized d h() {
        if (this.f43234a == null) {
            this.f43234a = new f();
        }
        return this.f43234a;
    }

    @Override // d.b.g0.a.a2.f.c
    public String i(String str) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            return null;
        }
        return d.b.g0.a.a2.b.t(str, O, O.W());
    }

    @Override // d.b.g0.a.a2.f.c
    public String j() {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        return O == null ? "" : d.b.g0.a.a2.b.h(O.f45740f);
    }

    @Override // d.b.g0.a.a2.f.c
    public boolean k(String str) {
        return d.b.g0.a.a2.b.n(str);
    }

    @Override // d.b.g0.a.a2.f.c
    public String l(String str) {
        return d.b.g0.a.a2.b.s(str);
    }

    @Override // d.b.g0.a.a2.f.c
    public String m(String str) {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        return O == null ? str : d.b.g0.a.a2.b.p(str, O);
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
        int i = a.f43235a[pathType.ordinal()];
        if (i == 1) {
            return n(str) ? PathType.ERROR : pathType;
        } else if (i != 2) {
            return i != 3 ? PathType.ERROR : pathType;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("bdfile://code");
            sb.append(File.separator);
            return (str.startsWith(sb.toString()) || "bdfile://code".equals(str)) ? PathType.RELATIVE : pathType;
        }
    }
}
