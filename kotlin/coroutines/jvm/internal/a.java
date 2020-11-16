package kotlin.coroutines.jvm.internal;

import kotlin.h;
@h
/* loaded from: classes9.dex */
public final class a implements kotlin.coroutines.a<Object> {
    public static final a pTQ = new a();

    private a() {
    }

    @Override // kotlin.coroutines.a
    public kotlin.coroutines.c getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.a
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
