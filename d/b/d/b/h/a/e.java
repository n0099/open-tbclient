package d.b.d.b.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f65875e;

    /* renamed from: a  reason: collision with root package name */
    public Context f65876a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f65877b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public b f65878c;

    /* renamed from: d  reason: collision with root package name */
    public d f65879d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65880a;

        static {
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f65880a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65880a[com.bytedance.tea.crash.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f65880a[com.bytedance.tea.crash.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        this.f65876a = context;
        this.f65878c = new b(context);
        this.f65879d = new d(this.f65876a);
    }

    public static e c() {
        if (f65875e != null) {
            return f65875e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (f65875e == null) {
            f65875e = new e(context);
        }
    }

    public d.b.d.b.e.a a(com.bytedance.tea.crash.c cVar, d.b.d.b.e.a aVar) {
        c b2;
        return (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar);
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.f65877b.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i2 = a.f65880a[cVar.ordinal()];
        if (i2 == 1) {
            cVar2 = new g(this.f65876a, this.f65878c, this.f65879d);
        } else if (i2 == 2) {
            cVar2 = new d.b.d.b.h.a.a(this.f65876a, this.f65878c, this.f65879d);
        } else if (i2 == 3) {
            cVar2 = new f(this.f65876a, this.f65878c, this.f65879d);
        }
        if (cVar2 != null) {
            this.f65877b.put(cVar, cVar2);
        }
        return cVar2;
    }
}
