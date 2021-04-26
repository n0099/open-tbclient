package d.a.h0.a.a2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
/* loaded from: classes3.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    public d f41225a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41226a;

        static {
            int[] iArr = new int[PathType.values().length];
            f41226a = iArr;
            try {
                iArr[PathType.RELATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41226a[PathType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41226a[PathType.BD_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // d.a.h0.a.a2.f.c
    public boolean a(String str) {
        return d.a.h0.a.a2.b.o(str);
    }

    @Override // d.a.h0.a.a2.f.c
    public String b(String str) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        return O == null ? "" : d.a.h0.a.a2.b.b(O.f43823f, str, null);
    }

    @Override // d.a.h0.a.a2.f.c
    @NonNull
    public synchronized d c() {
        if (this.f41225a == null) {
            this.f41225a = new f();
        }
        return this.f41225a;
    }

    @Override // d.a.h0.a.a2.f.c
    public String d(String str) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return null;
        }
        return d.a.h0.a.a2.b.t(str, O, O.W());
    }

    @Override // d.a.h0.a.a2.f.c
    public String e(String str) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        return O == null ? str : d.a.h0.a.a2.b.p(str, O);
    }

    @Override // d.a.h0.a.a2.f.c
    public String f() {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        return O == null ? "" : d.a.h0.a.a2.b.j(O.f43823f);
    }

    @Override // d.a.h0.a.a2.f.c
    public String g(String str) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        return O == null ? str : d.a.h0.a.a2.b.q(str, O.f43823f);
    }

    @Override // d.a.h0.a.a2.f.c
    public String h(String str) {
        String l = d.a.h0.p.d.l(str);
        if (TextUtils.isEmpty(l)) {
            return g(str);
        }
        return g(str) + "." + l;
    }

    @Override // d.a.h0.a.a2.f.c
    public String i(String str) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return null;
        }
        return d.a.h0.a.a2.b.u(str, O.f43823f);
    }

    @Override // d.a.h0.a.a2.f.c
    public boolean j(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PathType c2 = d.a.h0.a.a2.b.c(str);
        if (z) {
            c2 = o(str, c2);
        }
        return c2 != PathType.ERROR;
    }

    @Override // d.a.h0.a.a2.f.c
    public String k() {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        return O == null ? "" : d.a.h0.a.a2.b.h(O.f43823f);
    }

    @Override // d.a.h0.a.a2.f.c
    public boolean l(String str) {
        return d.a.h0.a.a2.b.n(str);
    }

    @Override // d.a.h0.a.a2.f.c
    public String m(String str) {
        return d.a.h0.a.a2.b.s(str);
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
        int i2 = a.f41226a[pathType.ordinal()];
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
