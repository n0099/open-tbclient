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
    public static volatile e f69649e;

    /* renamed from: a  reason: collision with root package name */
    public Context f69650a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f69651b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public b f69652c;

    /* renamed from: d  reason: collision with root package name */
    public d f69653d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69654a;

        static {
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f69654a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69654a[com.bytedance.tea.crash.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f69654a[com.bytedance.tea.crash.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        this.f69650a = context;
        this.f69652c = new b(context);
        this.f69653d = new d(this.f69650a);
    }

    public static e c() {
        if (f69649e != null) {
            return f69649e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (f69649e == null) {
            f69649e = new e(context);
        }
    }

    public d.b.d.b.e.a a(com.bytedance.tea.crash.c cVar, d.b.d.b.e.a aVar) {
        c b2;
        return (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar);
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.f69651b.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i2 = a.f69654a[cVar.ordinal()];
        if (i2 == 1) {
            cVar2 = new g(this.f69650a, this.f69652c, this.f69653d);
        } else if (i2 == 2) {
            cVar2 = new d.b.d.b.h.a.a(this.f69650a, this.f69652c, this.f69653d);
        } else if (i2 == 3) {
            cVar2 = new f(this.f69650a, this.f69652c, this.f69653d);
        }
        if (cVar2 != null) {
            this.f69651b.put(cVar, cVar2);
        }
        return cVar2;
    }
}
