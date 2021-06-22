package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f32274a;

    /* renamed from: b  reason: collision with root package name */
    public final EnumSet f32275b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32276c;

    public c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.f32274a = netcheckTaskListenerWrapper;
        this.f32275b = enumSet;
        this.f32276c = str;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32274a.f32263a.a(this.f32275b, this.f32276c);
    }
}
