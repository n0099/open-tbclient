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
    public static volatile e f65918e;

    /* renamed from: a  reason: collision with root package name */
    public Context f65919a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f65920b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public b f65921c;

    /* renamed from: d  reason: collision with root package name */
    public d f65922d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65923a;

        static {
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f65923a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65923a[com.bytedance.tea.crash.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f65923a[com.bytedance.tea.crash.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        this.f65919a = context;
        this.f65921c = new b(context);
        this.f65922d = new d(this.f65919a);
    }

    public static e c() {
        if (f65918e != null) {
            return f65918e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (f65918e == null) {
            f65918e = new e(context);
        }
    }

    public d.b.d.b.e.a a(com.bytedance.tea.crash.c cVar, d.b.d.b.e.a aVar) {
        c b2;
        return (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar);
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.f65920b.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i2 = a.f65923a[cVar.ordinal()];
        if (i2 == 1) {
            cVar2 = new g(this.f65919a, this.f65921c, this.f65922d);
        } else if (i2 == 2) {
            cVar2 = new d.b.d.b.h.a.a(this.f65919a, this.f65921c, this.f65922d);
        } else if (i2 == 3) {
            cVar2 = new f(this.f65919a, this.f65921c, this.f65922d);
        }
        if (cVar2 != null) {
            this.f65920b.put(cVar, cVar2);
        }
        return cVar2;
    }
}
