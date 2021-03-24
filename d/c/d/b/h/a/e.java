package d.c.d.b.h.a;

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
    public static volatile e f65843e;

    /* renamed from: a  reason: collision with root package name */
    public Context f65844a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f65845b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public b f65846c;

    /* renamed from: d  reason: collision with root package name */
    public d f65847d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65848a;

        static {
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f65848a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65848a[com.bytedance.tea.crash.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f65848a[com.bytedance.tea.crash.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        this.f65844a = context;
        this.f65846c = new b(context);
        this.f65847d = new d(this.f65844a);
    }

    public static e c() {
        if (f65843e != null) {
            return f65843e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (f65843e == null) {
            f65843e = new e(context);
        }
    }

    public d.c.d.b.e.a a(com.bytedance.tea.crash.c cVar, d.c.d.b.e.a aVar) {
        c b2;
        return (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar);
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.f65845b.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i = a.f65848a[cVar.ordinal()];
        if (i == 1) {
            cVar2 = new g(this.f65844a, this.f65846c, this.f65847d);
        } else if (i == 2) {
            cVar2 = new d.c.d.b.h.a.a(this.f65844a, this.f65846c, this.f65847d);
        } else if (i == 3) {
            cVar2 = new f(this.f65844a, this.f65846c, this.f65847d);
        }
        if (cVar2 != null) {
            this.f65845b.put(cVar, cVar2);
        }
        return cVar2;
    }
}
