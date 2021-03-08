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
    private static volatile e pyt;
    private Context b;
    private Map<com.bytedance.tea.crash.c, c> c = new HashMap();
    private b pyr;
    private d pys;

    private e(@NonNull Context context) {
        this.b = context;
        this.pyr = new b(this.b);
        this.pys = new d(this.b);
    }

    public static e erp() {
        if (pyt == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return pyt;
    }

    public static void a(Context context) {
        if (pyt == null) {
            pyt = new e(context);
        }
    }

    @Nullable
    private c c(com.bytedance.tea.crash.c cVar) {
        c cVar2 = this.c.get(cVar);
        if (cVar2 == null) {
            switch (cVar) {
                case JAVA:
                    cVar2 = new g(this.b, this.pyr, this.pys);
                    break;
                case ANR:
                    cVar2 = new a(this.b, this.pyr, this.pys);
                    break;
                case CUSTOM_JAVA:
                    cVar2 = new f(this.b, this.pyr, this.pys);
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
