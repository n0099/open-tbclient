package com.meizu.cloud.pushsdk.pushtracer.emitter;

import com.meizu.cloud.pushsdk.networking.b.i;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class c {
    private final boolean a;
    private final i b;
    private final LinkedList<Long> c;

    public c(boolean z, i iVar, LinkedList<Long> linkedList) {
        this.a = z;
        this.b = iVar;
        this.c = linkedList;
    }

    public i a() {
        return this.b;
    }

    public LinkedList<Long> b() {
        return this.c;
    }

    public boolean c() {
        return this.a;
    }
}
