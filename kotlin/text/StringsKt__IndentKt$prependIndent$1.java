package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes2.dex */
final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements kotlin.jvm.a.b<String, String> {
    final /* synthetic */ String $indent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StringsKt__IndentKt$prependIndent$1(String str) {
        super(1);
        this.$indent = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(String str) {
        kotlin.jvm.internal.p.j(str, AdvanceSetting.NETWORK_TYPE);
        if (k.i(str)) {
            return str.length() < this.$indent.length() ? this.$indent : str;
        }
        return this.$indent + str;
    }
}
