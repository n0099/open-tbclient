package com.meizu.cloud.pushsdk.c.b;

import com.meizu.cloud.pushsdk.b.c.i;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11270a;

    /* renamed from: b  reason: collision with root package name */
    private final i f11271b;
    private final LinkedList<Long> c;

    public e(boolean z, i iVar, LinkedList<Long> linkedList) {
        this.f11270a = z;
        this.f11271b = iVar;
        this.c = linkedList;
    }

    public i a() {
        return this.f11271b;
    }

    public LinkedList<Long> b() {
        return this.c;
    }

    public boolean c() {
        return this.f11270a;
    }
}
