package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes17.dex */
public final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements kotlin.jvm.a.b<kotlin.b.h, String> {
    final /* synthetic */ CharSequence receiver$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        super(1);
        this.receiver$0 = charSequence;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(kotlin.b.h hVar) {
        kotlin.jvm.internal.p.o(hVar, AdvanceSetting.NETWORK_TYPE);
        return l.a(this.receiver$0, hVar);
    }
}
