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
    private static volatile e pvQ;

    /* renamed from: b  reason: collision with root package name */
    private Context f7642b;
    private Map<com.bytedance.tea.crash.c, c> c = new HashMap();
    private b pvO;
    private d pvP;

    private e(@NonNull Context context) {
        this.f7642b = context;
        this.pvO = new b(this.f7642b);
        this.pvP = new d(this.f7642b);
    }

    public static e eqY() {
        if (pvQ == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return pvQ;
    }

    public static void a(Context context) {
        if (pvQ == null) {
            pvQ = new e(context);
        }
    }

    @Nullable
    private c c(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.c.get(cVar);
        if (cVar2 == null) {
            switch (cVar) {
                case JAVA:
                    cVar2 = new g(this.f7642b, this.pvO, this.pvP);
                    break;
                case ANR:
                    cVar2 = new a(this.f7642b, this.pvO, this.pvP);
                    break;
                case CUSTOM_JAVA:
                    cVar2 = new f(this.f7642b, this.pvO, this.pvP);
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
