package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements kotlin.jvm.a.b<kotlin.b.c, String> {
    final /* synthetic */ CharSequence receiver$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        super(1);
        this.receiver$0 = charSequence;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(kotlin.b.c cVar) {
        kotlin.jvm.internal.p.i(cVar, AdvanceSetting.NETWORK_TYPE);
        return k.a(this.receiver$0, cVar);
    }
}
