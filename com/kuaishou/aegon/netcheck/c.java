package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f31635a;

    /* renamed from: b  reason: collision with root package name */
    public final EnumSet f31636b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31637c;

    public c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.f31635a = netcheckTaskListenerWrapper;
        this.f31636b = enumSet;
        this.f31637c = str;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31635a.f31624a.a(this.f31636b, this.f31637c);
    }
}
