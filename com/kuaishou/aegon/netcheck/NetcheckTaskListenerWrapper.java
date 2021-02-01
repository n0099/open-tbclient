package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: b  reason: collision with root package name */
    public Executor f8118b;
    public a.b pXU;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC1067a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC1067a.class);
        for (a.EnumC1067a enumC1067a : a.EnumC1067a.values()) {
            if (((1 << enumC1067a.a()) & j) != 0) {
                noneOf.add(enumC1067a);
            }
        }
        this.f8118b.execute(c.b(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.f8118b.execute(b.b(this, i));
    }
}
