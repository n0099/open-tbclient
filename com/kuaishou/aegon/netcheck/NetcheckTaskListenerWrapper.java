package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: b  reason: collision with root package name */
    public Executor f8415b;
    public a.b pQH;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC1039a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC1039a.class);
        for (a.EnumC1039a enumC1039a : a.EnumC1039a.values()) {
            if (((1 << enumC1039a.a()) & j) != 0) {
                noneOf.add(enumC1039a);
            }
        }
        this.f8415b.execute(c.b(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.f8415b.execute(b.b(this, i));
    }
}
