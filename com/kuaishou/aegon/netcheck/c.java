package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f32019a;

    /* renamed from: b  reason: collision with root package name */
    public final EnumSet f32020b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32021c;

    public c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.f32019a = netcheckTaskListenerWrapper;
        this.f32020b = enumSet;
        this.f32021c = str;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32019a.f32008a.a(this.f32020b, this.f32021c);
    }
}
