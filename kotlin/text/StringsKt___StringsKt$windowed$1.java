package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.internal.Lambda;
@kotlin.h
/* loaded from: classes7.dex */
final class StringsKt___StringsKt$windowed$1 extends Lambda implements kotlin.jvm.a.b<CharSequence, String> {
    public static final StringsKt___StringsKt$windowed$1 INSTANCE = new StringsKt___StringsKt$windowed$1();

    StringsKt___StringsKt$windowed$1() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.b
    public final String invoke(CharSequence charSequence) {
        kotlin.jvm.internal.q.m(charSequence, AdvanceSetting.NETWORK_TYPE);
        return charSequence.toString();
    }
}
