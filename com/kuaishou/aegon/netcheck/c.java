package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f32176a;

    /* renamed from: b  reason: collision with root package name */
    public final EnumSet f32177b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32178c;

    public c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.f32176a = netcheckTaskListenerWrapper;
        this.f32177b = enumSet;
        this.f32178c = str;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32176a.f32165a.a(this.f32177b, this.f32178c);
    }
}
