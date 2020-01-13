package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements kotlin.jvm.a.b<kotlin.b.c, String> {
    final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        super(1);
        this.$this_splitToSequence = charSequence;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(kotlin.b.c cVar) {
        kotlin.jvm.internal.q.j(cVar, AdvanceSetting.NETWORK_TYPE);
        return l.a(this.$this_splitToSequence, cVar);
    }
}
