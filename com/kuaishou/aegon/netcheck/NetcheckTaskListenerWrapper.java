package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: a  reason: collision with root package name */
    public a.b f32008a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f32009b;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC0371a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC0371a.class);
        for (a.EnumC0371a enumC0371a : a.EnumC0371a.values()) {
            if (((1 << enumC0371a.a()) & j) != 0) {
                noneOf.add(enumC0371a);
            }
        }
        this.f32009b.execute(c.a(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.f32009b.execute(b.a(this, i));
    }
}
