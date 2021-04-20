package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: a  reason: collision with root package name */
    public a.b f31913a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f31914b;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC0368a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC0368a.class);
        for (a.EnumC0368a enumC0368a : a.EnumC0368a.values()) {
            if (((1 << enumC0368a.a()) & j) != 0) {
                noneOf.add(enumC0368a);
            }
        }
        this.f31914b.execute(c.a(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.f31914b.execute(b.a(this, i));
    }
}
