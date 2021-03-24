package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: a  reason: collision with root package name */
    public a.b f31623a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f31624b;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC0353a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC0353a.class);
        for (a.EnumC0353a enumC0353a : a.EnumC0353a.values()) {
            if (((1 << enumC0353a.a()) & j) != 0) {
                noneOf.add(enumC0353a);
            }
        }
        this.f31624b.execute(c.a(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.f31624b.execute(b.a(this, i));
    }
}
