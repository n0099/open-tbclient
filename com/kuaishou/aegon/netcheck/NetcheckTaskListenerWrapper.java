package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class NetcheckTaskListenerWrapper {
    public Executor b;
    public a.b pZi;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC1086a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC1086a.class);
        for (a.EnumC1086a enumC1086a : a.EnumC1086a.values()) {
            if (((1 << enumC1086a.a()) & j) != 0) {
                noneOf.add(enumC1086a);
            }
        }
        this.b.execute(c.b(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.b.execute(b.b(this, i));
    }
}
