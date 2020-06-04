package com.opensource.svgaplayer;

import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.l;
@h
/* loaded from: classes.dex */
final class SVGAParser$FileDownloader$resume$cancelBlock$1 extends Lambda implements kotlin.jvm.a.a<l> {
    final /* synthetic */ Ref.BooleanRef $cancelled;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAParser$FileDownloader$resume$cancelBlock$1(Ref.BooleanRef booleanRef) {
        super(0);
        this.$cancelled = booleanRef;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.a
    public /* bridge */ /* synthetic */ l invoke() {
        invoke2();
        return l.nto;
    }

    @Override // kotlin.jvm.a.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$cancelled.element = true;
    }
}
