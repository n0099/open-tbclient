package com.kuaishou.aegon.netcheck;

import androidx.annotation.Keep;
import com.kuaishou.aegon.netcheck.a;
import java.util.EnumSet;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class NetcheckTaskListenerWrapper {

    /* renamed from: a  reason: collision with root package name */
    public a.b f31624a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f31625b;

    @Keep
    public void OnFinish(long j, String str) {
        a.EnumC0354a[] values;
        EnumSet noneOf = EnumSet.noneOf(a.EnumC0354a.class);
        for (a.EnumC0354a enumC0354a : a.EnumC0354a.values()) {
            if (((1 << enumC0354a.a()) & j) != 0) {
                noneOf.add(enumC0354a);
            }
        }
        this.f31625b.execute(c.a(this, noneOf, str));
    }

    @Keep
    public void OnProgress(int i) {
        this.f31625b.execute(b.a(this, i));
    }
}
