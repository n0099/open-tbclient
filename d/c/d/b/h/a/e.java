package d.c.d.b.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f66689e;

    /* renamed from: a  reason: collision with root package name */
    public Context f66690a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f66691b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public b f66692c;

    /* renamed from: d  reason: collision with root package name */
    public d f66693d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66694a;

        static {
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f66694a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66694a[com.bytedance.tea.crash.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66694a[com.bytedance.tea.crash.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        this.f66690a = context;
        this.f66692c = new b(context);
        this.f66693d = new d(this.f66690a);
    }

    public static e c() {
        if (f66689e != null) {
            return f66689e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (f66689e == null) {
            f66689e = new e(context);
        }
    }

    public d.c.d.b.e.a a(com.bytedance.tea.crash.c cVar, d.c.d.b.e.a aVar) {
        c b2;
        return (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar);
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.f66691b.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i = a.f66694a[cVar.ordinal()];
        if (i == 1) {
            cVar2 = new g(this.f66690a, this.f66692c, this.f66693d);
        } else if (i == 2) {
            cVar2 = new d.c.d.b.h.a.a(this.f66690a, this.f66692c, this.f66693d);
        } else if (i == 3) {
            cVar2 = new f(this.f66690a, this.f66692c, this.f66693d);
        }
        if (cVar2 != null) {
            this.f66691b.put(cVar, cVar2);
        }
        return cVar2;
    }
}
