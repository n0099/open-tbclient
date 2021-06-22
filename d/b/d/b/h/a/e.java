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
    public static volatile e f69753e;

    /* renamed from: a  reason: collision with root package name */
    public Context f69754a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f69755b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public b f69756c;

    /* renamed from: d  reason: collision with root package name */
    public d f69757d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69758a;

        static {
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f69758a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69758a[com.bytedance.tea.crash.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f69758a[com.bytedance.tea.crash.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        this.f69754a = context;
        this.f69756c = new b(context);
        this.f69757d = new d(this.f69754a);
    }

    public static e c() {
        if (f69753e != null) {
            return f69753e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (f69753e == null) {
            f69753e = new e(context);
        }
    }

    public d.b.d.b.e.a a(com.bytedance.tea.crash.c cVar, d.b.d.b.e.a aVar) {
        c b2;
        return (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar);
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.f69755b.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i2 = a.f69758a[cVar.ordinal()];
        if (i2 == 1) {
            cVar2 = new g(this.f69754a, this.f69756c, this.f69757d);
        } else if (i2 == 2) {
            cVar2 = new d.b.d.b.h.a.a(this.f69754a, this.f69756c, this.f69757d);
        } else if (i2 == 3) {
            cVar2 = new f(this.f69754a, this.f69756c, this.f69757d);
        }
        if (cVar2 != null) {
            this.f69755b.put(cVar, cVar2);
        }
        return cVar2;
    }
}
