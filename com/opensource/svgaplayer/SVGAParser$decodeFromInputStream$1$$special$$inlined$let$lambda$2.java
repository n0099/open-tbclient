package com.opensource.svgaplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$1$2$1", "com/opensource/svgaplayer/SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 1, 13}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SVGAVideoEntity $videoItem;
    public final /* synthetic */ SVGAParser$decodeFromInputStream$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAParser$decodeFromInputStream$1$$special$$inlined$let$lambda$2(SVGAVideoEntity sVGAVideoEntity, SVGAParser$decodeFromInputStream$1 sVGAParser$decodeFromInputStream$1) {
        super(0);
        this.$videoItem = sVGAVideoEntity;
        this.this$0 = sVGAParser$decodeFromInputStream$1;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SVGAParser$decodeFromInputStream$1 sVGAParser$decodeFromInputStream$1 = this.this$0;
        sVGAParser$decodeFromInputStream$1.f38845e.s(this.$videoItem, sVGAParser$decodeFromInputStream$1.f38848h);
    }
}
