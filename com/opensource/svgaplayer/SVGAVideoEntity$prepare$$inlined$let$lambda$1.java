package com.opensource.svgaplayer;

import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.l;
/* JADX INFO: Access modifiers changed from: package-private */
@h
/* loaded from: classes.dex */
public final class SVGAVideoEntity$prepare$$inlined$let$lambda$1 extends Lambda implements kotlin.jvm.a.a<l> {
    final /* synthetic */ kotlin.jvm.a.a $callback$inlined;
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAVideoEntity$prepare$$inlined$let$lambda$1(f fVar, kotlin.jvm.a.a aVar) {
        super(0);
        this.this$0 = fVar;
        this.$callback$inlined = aVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.a
    public /* bridge */ /* synthetic */ l invoke() {
        invoke2();
        return l.nse;
    }

    @Override // kotlin.jvm.a.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$callback$inlined.invoke();
    }
}
