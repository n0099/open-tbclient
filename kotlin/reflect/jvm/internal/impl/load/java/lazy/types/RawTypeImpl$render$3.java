package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes9.dex */
public final class RawTypeImpl$render$3 extends Lambda implements Function2<String, String, String> {
    public static final RawTypeImpl$render$3 INSTANCE = new RawTypeImpl$render$3();

    public RawTypeImpl$render$3() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function2
    public final String invoke(String str, String str2) {
        if (!StringsKt__StringsKt.contains$default((CharSequence) str, '<', false, 2, (Object) null)) {
            return str;
        }
        return StringsKt__StringsKt.substringBefore$default(str, '<', (String) null, 2, (Object) null) + '<' + str2 + '>' + StringsKt__StringsKt.substringAfterLast$default(str, '>', (String) null, 2, (Object) null);
    }
}
