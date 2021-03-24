package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f31634a;

    /* renamed from: b  reason: collision with root package name */
    public final EnumSet f31635b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31636c;

    public c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.f31634a = netcheckTaskListenerWrapper;
        this.f31635b = enumSet;
        this.f31636c = str;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31634a.f31623a.a(this.f31635b, this.f31636c);
    }
}
