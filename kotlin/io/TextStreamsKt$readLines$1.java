package kotlin.io;

import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
final class TextStreamsKt$readLines$1 extends Lambda implements kotlin.jvm.a.b<String, kotlin.h> {
    final /* synthetic */ ArrayList $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextStreamsKt$readLines$1(ArrayList arrayList) {
        super(1);
        this.$result = arrayList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ kotlin.h invoke(String str) {
        invoke2(str);
        return kotlin.h.qto;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        p.o(str, "it");
        this.$result.add(str);
    }
}
