package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: b  reason: collision with root package name */
    public Executor f8116b;
    public a.b pNQ;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC1063a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC1063a.class);
        for (a.EnumC1063a enumC1063a : a.EnumC1063a.values()) {
            if (((1 << enumC1063a.a()) & j) != 0) {
                noneOf.add(enumC1063a);
            }
        }
        this.f8116b.execute(c.b(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.f8116b.execute(b.b(this, i));
    }
}
