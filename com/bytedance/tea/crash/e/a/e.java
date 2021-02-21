package com.bytedance.tea.crash.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e pwq;

    /* renamed from: b  reason: collision with root package name */
    private Context f7642b;
    private Map<com.bytedance.tea.crash.c, c> c = new HashMap();
    private b pwo;
    private d pwp;

    private e(@NonNull Context context) {
        this.f7642b = context;
        this.pwo = new b(this.f7642b);
        this.pwp = new d(this.f7642b);
    }

    public static e erg() {
        if (pwq == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return pwq;
    }

    public static void a(Context context) {
        if (pwq == null) {
            pwq = new e(context);
        }
    }

    @Nullable
    private c c(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.c.get(cVar);
        if (cVar2 == null) {
            switch (cVar) {
                case JAVA:
                    cVar2 = new g(this.f7642b, this.pwo, this.pwp);
                    break;
                case ANR:
                    cVar2 = new a(this.f7642b, this.pwo, this.pwp);
                    break;
                case CUSTOM_JAVA:
                    cVar2 = new f(this.f7642b, this.pwo, this.pwp);
                    break;
            }
            if (cVar2 != null) {
                this.c.put(cVar, cVar2);
            }
        }
        return cVar2;
    }

    public com.bytedance.tea.crash.c.a a(com.bytedance.tea.crash.c cVar, com.bytedance.tea.crash.c.a aVar) {
        c c;
        if (cVar != null && (c = c(cVar)) != null) {
            return c.a(aVar);
        }
        return aVar;
    }
}
