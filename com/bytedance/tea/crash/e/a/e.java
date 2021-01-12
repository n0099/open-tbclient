package com.bytedance.tea.crash.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e plA;

    /* renamed from: b  reason: collision with root package name */
    private Context f7640b;
    private Map<com.bytedance.tea.crash.c, c> c = new HashMap();
    private b ply;
    private d plz;

    private e(@NonNull Context context) {
        this.f7640b = context;
        this.ply = new b(this.f7640b);
        this.plz = new d(this.f7640b);
    }

    public static e eoG() {
        if (plA == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return plA;
    }

    public static void a(Context context) {
        if (plA == null) {
            plA = new e(context);
        }
    }

    @Nullable
    private c c(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.c.get(cVar);
        if (cVar2 == null) {
            switch (cVar) {
                case JAVA:
                    cVar2 = new g(this.f7640b, this.ply, this.plz);
                    break;
                case ANR:
                    cVar2 = new a(this.f7640b, this.ply, this.plz);
                    break;
                case CUSTOM_JAVA:
                    cVar2 = new f(this.f7640b, this.ply, this.plz);
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
