package com.opensource.svgaplayer;

import com.opensource.svgaplayer.d;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
@kotlin.e
/* loaded from: classes6.dex */
final class SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2 extends Lambda implements kotlin.jvm.a.a<h> {
    final /* synthetic */ f $videoItem;
    final /* synthetic */ d.RunnableC1146d this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(f fVar, d.RunnableC1146d runnableC1146d) {
        super(0);
        this.$videoItem = fVar;
        this.this$0 = runnableC1146d;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.a
    public /* bridge */ /* synthetic */ h invoke() {
        invoke2();
        return h.qlD;
    }

    @Override // kotlin.jvm.a.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d.this.a(this.$videoItem, this.this$0.$callback);
    }
}
