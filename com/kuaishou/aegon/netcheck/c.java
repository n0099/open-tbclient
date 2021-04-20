package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f31924a;

    /* renamed from: b  reason: collision with root package name */
    public final EnumSet f31925b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31926c;

    public c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.f31924a = netcheckTaskListenerWrapper;
        this.f31925b = enumSet;
        this.f31926c = str;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31924a.f31913a.a(this.f31925b, this.f31926c);
    }
}
