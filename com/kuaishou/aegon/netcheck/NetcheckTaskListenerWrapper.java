package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: a  reason: collision with root package name */
    public a.b f32263a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f32264b;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC0357a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC0357a.class);
        for (a.EnumC0357a enumC0357a : a.EnumC0357a.values()) {
            if (((1 << enumC0357a.a()) & j) != 0) {
                noneOf.add(enumC0357a);
            }
        }
        this.f32264b.execute(c.a(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i2) {
        this.f32264b.execute(b.a(this, i2));
    }
}
