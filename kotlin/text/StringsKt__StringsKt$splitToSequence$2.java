package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes20.dex */
final class StringsKt__StringsKt$splitToSequence$2 extends Lambda implements kotlin.jvm.a.b<kotlin.b.h, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$2(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(kotlin.b.h hVar) {
        kotlin.jvm.internal.q.m(hVar, AdvanceSetting.NETWORK_TYPE);
        return l.a(this.$this_splitToSequence, hVar);
    }
}
