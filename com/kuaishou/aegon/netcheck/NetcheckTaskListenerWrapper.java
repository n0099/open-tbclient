package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: b  reason: collision with root package name */
    public Executor f8416b;
    public a.b pSp;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC1080a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC1080a.class);
        for (a.EnumC1080a enumC1080a : a.EnumC1080a.values()) {
            if (((1 << enumC1080a.a()) & j) != 0) {
                noneOf.add(enumC1080a);
            }
        }
        this.f8416b.execute(c.b(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.f8416b.execute(b.b(this, i));
    }
}
