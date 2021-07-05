package kotlin.text;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class StringsKt___StringsKt$windowedSequence$1 extends Lambda implements Function1<CharSequence, String> {
    public static final StringsKt___StringsKt$windowedSequence$1 INSTANCE = new StringsKt___StringsKt$windowedSequence$1();

    public StringsKt___StringsKt$windowedSequence$1() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final String invoke(CharSequence it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }
}
