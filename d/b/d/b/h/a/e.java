package d.b.d.b.h.a;

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
    public static volatile e f65189e;

    /* renamed from: a  reason: collision with root package name */
    public Context f65190a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f65191b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public b f65192c;

    /* renamed from: d  reason: collision with root package name */
    public d f65193d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65194a;

        static {
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f65194a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65194a[com.bytedance.tea.crash.c.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f65194a[com.bytedance.tea.crash.c.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        this.f65190a = context;
        this.f65192c = new b(context);
        this.f65193d = new d(this.f65190a);
    }

    public static e c() {
        if (f65189e != null) {
            return f65189e;
        }
        throw new IllegalArgumentException("CrashContextAssembly not init");
    }

    public static void d(Context context) {
        if (f65189e == null) {
            f65189e = new e(context);
        }
    }

    public d.b.d.b.e.a a(com.bytedance.tea.crash.c cVar, d.b.d.b.e.a aVar) {
        c b2;
        return (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar);
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.f65191b.get(cVar);
        if (cVar2 != null) {
            return cVar2;
        }
        int i2 = a.f65194a[cVar.ordinal()];
        if (i2 == 1) {
            cVar2 = new g(this.f65190a, this.f65192c, this.f65193d);
        } else if (i2 == 2) {
            cVar2 = new d.b.d.b.h.a.a(this.f65190a, this.f65192c, this.f65193d);
        } else if (i2 == 3) {
            cVar2 = new f(this.f65190a, this.f65192c, this.f65193d);
        }
        if (cVar2 != null) {
            this.f65191b.put(cVar, cVar2);
        }
        return cVar2;
    }
}
